package com.trabajofinal.controllers;

import com.trabajofinal.dto.ClienteDTO;
import com.trabajofinal.dto.HijoDTO;
import com.trabajofinal.dto.PolizaDTO;
import com.trabajofinal.dto.VehiculoDTO;
import com.trabajofinal.gui.ConfirmacionDatosPoliza;
import com.trabajofinal.gui.DetalleBonificaciones;
import com.trabajofinal.gui.DetalleCuotas;
import com.trabajofinal.gestores.GestorPoliza;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.util.List;

import javax.swing.JOptionPane;

public class ConfirmacionDatosPolizaController implements ActionListener {

   private ConfirmacionDatosPoliza confirmacionDatosPoliza;

   private Object[] options = { "Sí", "No" };

   private ClienteDTO cliente;
   private VehiculoDTO vehiculo;
   private List<HijoDTO> hijoDTO;
   private PolizaDTO poliza;

   public ConfirmacionDatosPolizaController(ConfirmacionDatosPoliza confirmacionDatosPoliza, ClienteDTO cliente,
         VehiculoDTO vehiculo, List<HijoDTO> hijoDTO, PolizaDTO poliza) {
      this.confirmacionDatosPoliza = confirmacionDatosPoliza;
      this.cliente = cliente;
      this.vehiculo = vehiculo;
      this.hijoDTO = hijoDTO;
      this.poliza = poliza;

      inicializarDatos();
      GestorPoliza.getInstance().calcularPremioDerechosDescuentos(poliza);

      // Para probar la interface, luego se validará con el valor que trainga los
      // datosDTO
      boolean pagoUnico = true;

      if (pagoUnico) {
         this.confirmacionDatosPoliza.btn_confirma_datos_pol_ver_det.setVisible(true);
         this.confirmacionDatosPoliza.txt_confirma_pol_ult_dia_pago.setVisible(false);
         this.confirmacionDatosPoliza.lab_confirma_pol_ult_dia_pago.setVisible(false);
         this.confirmacionDatosPoliza.btn_confirma_datos_pol_ver_det.addActionListener(this);

      } else {
         this.confirmacionDatosPoliza.btn_confirma_datos_pol_ver_det.setVisible(false);
         this.confirmacionDatosPoliza.txt_confirma_pol_ult_dia_pago.setVisible(true);
         this.confirmacionDatosPoliza.lab_confirma_pol_ult_dia_pago.setVisible(true);
      }

      // Pongo a escuchar los botones
      this.confirmacionDatosPoliza.btn_confirma_datos_pol_mod.addActionListener(this);
      this.confirmacionDatosPoliza.btn_confirma_datos_pol_fin.addActionListener(this);
      this.confirmacionDatosPoliza.btn_confirma_datos_pol_cancelar.addActionListener(this);
      this.confirmacionDatosPoliza.btn_conf_dat_pol_ver_bon.addActionListener(this);
   }

   @Override
   public void actionPerformed(ActionEvent e) {
      if (e.getSource() == confirmacionDatosPoliza.btn_confirma_datos_pol_mod) {
         // Logica de modificacion
         this.confirmacionDatosPoliza.dispose();
      } else if (e.getSource() == confirmacionDatosPoliza.btn_confirma_datos_pol_fin) {
         // Logica de finalizar
         this.confirmacionDatosPoliza.dispose();
         GestorPoliza.getInstance().crearPoliza(poliza, hijoDTO, cliente, vehiculo);
         // mostrar un mensaje de exito

      } else if (e.getSource() == confirmacionDatosPoliza.btn_confirma_datos_pol_cancelar) {
         // Paso 1: preguntar si confirma. Si lo hace, entonces cerramos.
         int confirmacion = JOptionPane.showOptionDialog(null, "¿Seguro de cancelar los cambios?",
               "Confirmar cancelación",
               JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
         if (confirmacion == 0) {
            this.confirmacionDatosPoliza.dispose();
         }
      } else if (e.getSource() == confirmacionDatosPoliza.btn_conf_dat_pol_ver_bon) {
         DetalleBonificaciones detalleBonificaciones = new DetalleBonificaciones();
      } else if (e.getSource() == confirmacionDatosPoliza.btn_confirma_datos_pol_ver_det) {
         // Verificar consistencia de los datos primero.
         DetalleCuotas detalleCuotas = new DetalleCuotas();
      }
   }

   public void inicializarDatos() {

      confirmacionDatosPoliza.txt_confirma_pol_apellido.setText(cliente.getApellido().trim());
      confirmacionDatosPoliza.txt_confirma_pol_nombre.setText(cliente.getNombre().trim());
      // confirmacionDatosPoliza.txt_confirma_pol_dscto.setText(poliza.getDescuentos().toString().trim());

      confirmacionDatosPoliza.txt_confirma_pol_fecha_ini.setText(poliza.getFechaInicioVigencia().toString().trim());
      Calendar calendario = Calendar.getInstance();
      calendario.setTime(poliza.getFechaInicioVigencia());
      calendario.add(Calendar.MONTH, 6);
      confirmacionDatosPoliza.txt_confirma_pol_fecha_fin.setText(calendario.getTime().toString().trim());
      confirmacionDatosPoliza.txt_confirma_pol_marca.setText(vehiculo.getMarca().trim());
      confirmacionDatosPoliza.txt_confirma_pol_modelo.setText(vehiculo.getModelo().trim());
      confirmacionDatosPoliza.txt_confirma_pol_motor.setText(vehiculo.getMotor().trim());
      confirmacionDatosPoliza.txt_confirma_pol_chasis.setText(vehiculo.getChasis().trim());
      confirmacionDatosPoliza.txt_confirma_pol_patente.setText(vehiculo.getPatente().trim());
      confirmacionDatosPoliza.txt_confirma_pol_premio.setText(poliza.getPremio().toString().trim());
      confirmacionDatosPoliza.txt_confirma_pol_suma_aseg.setText(vehiculo.getValor_estimado());
      // confirmacionDatosPoliza.txt_confirma_pol_ult_dia_pago.
      // confirmacionDatosPoliza.txt_confirma_pol_monto

   }

}
