package com.trabajofinal.controllers;

import com.trabajofinal.dto.ClienteDTO;
import com.trabajofinal.dto.HijoDTO;
import com.trabajofinal.dto.PolizaDTO;
import com.trabajofinal.dto.VehiculoDTO;
import com.trabajofinal.gui.ConfirmacionDatosPoliza;
import com.trabajofinal.gui.DetalleBonificaciones;
import com.trabajofinal.gui.DetalleCuotas;
import com.trabajofinal.gestores.GestorPoliza;
import com.trabajofinal.gui.ProgressWindow;
import com.trabajofinal.models.TipoPago;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import javax.swing.JOptionPane;

public class ConfirmacionDatosPolizaController implements ActionListener {

   private ConfirmacionDatosPoliza confirmacionDatosPoliza;

   private Object[] options = { "Sí", "No" };

   private ClienteDTO cliente;
   private VehiculoDTO vehiculo;
   private List<HijoDTO> hijoDTO;
   private PolizaDTO poliza;
   private Double dcto_pago_sem;
   private Double dcto_mas_una_un;
   private Double dcto_antig;

   public ConfirmacionDatosPolizaController(ConfirmacionDatosPoliza confirmacionDatosPoliza, ClienteDTO cliente,
         VehiculoDTO vehiculo, List<HijoDTO> hijoDTO, PolizaDTO poliza) {
      this.confirmacionDatosPoliza = confirmacionDatosPoliza;
      this.cliente = cliente;
      this.vehiculo = vehiculo;
      this.hijoDTO = hijoDTO;
      this.poliza = poliza;
      this.confirmacionDatosPoliza.modificar = false;

      inicializarDatos();

      // Los elementos de la interfaz varían si es o no de pago único.
      boolean pagoMensual = poliza.getTipoPago().equals(TipoPago.MENSUAL);

      if (pagoMensual) {
         this.confirmacionDatosPoliza.btn_confirma_datos_pol_ver_det.setVisible(true);
         this.confirmacionDatosPoliza.txt_confirma_pol_ult_dia_pago.setVisible(false);
         this.confirmacionDatosPoliza.lab_confirma_pol_ult_dia_pago.setVisible(false);
         this.confirmacionDatosPoliza.btn_confirma_datos_pol_ver_det.addActionListener(this);

      } else {
         this.confirmacionDatosPoliza.btn_confirma_datos_pol_ver_det.setVisible(false);
         this.confirmacionDatosPoliza.txt_confirma_pol_ult_dia_pago.setVisible(true);
         this.confirmacionDatosPoliza.lab_confirma_pol_ult_dia_pago.setVisible(true);
         DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
         String fechaFormateada = poliza.getCuotas().get(0).getFecha_vencimiento().format(formatter);
         confirmacionDatosPoliza.txt_confirma_pol_ult_dia_pago.setText(fechaFormateada);

      }

      // Cargar descuentos. Lo necesitamos en la interfaz y en la ventana
      // correspondiente
      dcto_antig = poliza.getDto_antiguedad();
      dcto_mas_una_un = poliza.getDto_mas_un_vehiculo();
      dcto_pago_sem = poliza.getDto_pago_semestral();

      // Pongo a escuchar los botones
      this.confirmacionDatosPoliza.btn_confirma_datos_pol_mod.addActionListener(this);
      this.confirmacionDatosPoliza.btn_confirma_datos_pol_fin.addActionListener(this);
      this.confirmacionDatosPoliza.btn_confirma_datos_pol_cancelar.addActionListener(this);
      this.confirmacionDatosPoliza.btn_conf_dat_pol_ver_bon.addActionListener(this);
   }

   @Override
   public void actionPerformed(ActionEvent e) {
      if (e.getSource() == confirmacionDatosPoliza.btn_confirma_datos_pol_mod) {
         confirmacionDatosPoliza.modificar = true;
         this.confirmacionDatosPoliza.dispose();
      } else if (e.getSource() == confirmacionDatosPoliza.btn_confirma_datos_pol_fin) {
         ProgressWindow progreso = new ProgressWindow();
         // Hilo para la carga de datos
         Thread hiloDatos = new Thread() {
            @Override
            public void run() {
               GestorPoliza.getInstance().crearPoliza(poliza, hijoDTO, cliente, vehiculo);
               progreso.dispose();
               JOptionPane.showMessageDialog(null, "Poliza creada exitosamente", "Advertencia",
                     JOptionPane.WARNING_MESSAGE);
               confirmacionDatosPoliza.dispose();
            }
         };
         // Hilo para la barra de progreso
         Thread hiloProgreso = new Thread() {
            @Override
            public void run() {
               int progresoActual = 1;
               while (true) {
                  progreso.jpb_progress.setValue(progresoActual);
                  progresoActual = (progresoActual % 100) + 1; // Reinicia el contador al llegar a 100
                  try {
                     Thread.sleep(50); // Simula un retardo de tiempo durante la actualización del progreso
                  } catch (InterruptedException e) {
                     e.printStackTrace();
                  }
               }
            }
         };
         // Iniciar ambos hilos
         hiloProgreso.start();
         hiloDatos.start();

      } else if (e.getSource() == confirmacionDatosPoliza.btn_confirma_datos_pol_cancelar) {
         // Paso 1: preguntar si confirma. Si lo hace, entonces cerramos.
         int confirmacion = JOptionPane.showOptionDialog(null, "¿Seguro de cancelar los cambios?",
               "Confirmar cancelación",
               JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
         if (confirmacion == 0) {
            this.confirmacionDatosPoliza.dispose();
         }
      } else if (e.getSource() == confirmacionDatosPoliza.btn_conf_dat_pol_ver_bon) {
         DetalleBonificaciones detalleBonificaciones = new DetalleBonificaciones(dcto_antig, dcto_mas_una_un,
               dcto_pago_sem);
      } else if (e.getSource() == confirmacionDatosPoliza.btn_confirma_datos_pol_ver_det) {
         // Verificar consistencia de los datos primero.

         DetalleCuotas detalleCuotas = new DetalleCuotas(poliza.getCuotas());
      }
   }

   public void inicializarDatos() {

      confirmacionDatosPoliza.jlb_confirma_poliza.setText("Cliente <" + cliente.getNumero_cliente().trim() + ">");
      confirmacionDatosPoliza.txt_confirma_pol_apellido.setText(cliente.getApellido().trim().toUpperCase());
      confirmacionDatosPoliza.txt_confirma_pol_nombre.setText(cliente.getNombre().trim().toUpperCase());
      double valor = poliza.getDto_antiguedad() + poliza.getDto_mas_un_vehiculo() + poliza.getDto_pago_semestral();
      String montoFormateado = String.format("%.2f", valor);
      confirmacionDatosPoliza.txt_confirma_pol_dscto.setText(montoFormateado);
      // Formatear la fecha para presentarla en pantalla
      SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy"); // Define el formato deseado
      String fechaFormateada = sdf.format(poliza.getFechaInicioVigencia()); // Formatea la fecha a String
      confirmacionDatosPoliza.txt_confirma_pol_fecha_ini.setText(fechaFormateada);
      Calendar calendario = Calendar.getInstance();
      calendario.setTime(poliza.getFechaInicioVigencia());
      calendario.add(Calendar.MONTH, 6);
      fechaFormateada = sdf.format(calendario.getTime());
      confirmacionDatosPoliza.txt_confirma_pol_fecha_fin.setText(fechaFormateada);
      confirmacionDatosPoliza.txt_confirma_pol_marca.setText(vehiculo.getMarca().trim().toUpperCase());
      confirmacionDatosPoliza.txt_confirma_pol_modelo.setText(vehiculo.getModelo().trim().toUpperCase());
      confirmacionDatosPoliza.txt_confirma_pol_motor.setText(vehiculo.getMotor().trim().toUpperCase());
      confirmacionDatosPoliza.txt_confirma_pol_chasis.setText(vehiculo.getChasis().trim().toUpperCase());
      confirmacionDatosPoliza.txt_confirma_pol_patente.setText(vehiculo.getPatente().trim().toUpperCase());
      valor = poliza.getPremio();
      montoFormateado = String.format("%.2f", valor);
      confirmacionDatosPoliza.txt_confirma_pol_premio.setText(montoFormateado);
      confirmacionDatosPoliza.txt_confirma_pol_suma_aseg.setText(vehiculo.getValor_estimado());
      montoFormateado = String.format("%.2f", valor);
      confirmacionDatosPoliza.txt_confirma_pol_monto.setText(montoFormateado);
   }

}
