package com.trabajofinal.controllers;

import com.trabajofinal.dto.ClienteDTO;
import com.trabajofinal.dto.VehiculoDTO;
import com.trabajofinal.gestores.GestorClientes;
import com.trabajofinal.gestores.GestorPoliza;
import com.trabajofinal.gestores.GestorSistemaFinanciero;
import com.trabajofinal.gestores.GestorTipoCobertura;
import com.trabajofinal.dto.HijoDTO;
import com.trabajofinal.dto.PolizaDTO;
import com.trabajofinal.gui.AltaPoliza02;
import com.trabajofinal.gui.ConfirmacionDatosPoliza;
import com.trabajofinal.models.TipoCobertura;
import com.trabajofinal.models.TipoPago;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JOptionPane;

public class AltaPoliza02Controller implements ActionListener, MouseListener, PropertyChangeListener {

   private AltaPoliza02 altaPoliza02;
   DefaultListModel<String> lista = new DefaultListModel<>();
   private ClienteDTO cliente;
   private VehiculoDTO vehiculo;
   private List<HijoDTO> hijoDTO;
   private PolizaDTO poliza;
   private String elementoSeleccionado = "Ninguno";
   private Date selectedDate;
   private List<TipoCobertura> tiposCobertura;
   private GestorPoliza gestorPoliza;
   private GestorClientes gestorClientes;

   private Object[] options = { "Sí", "No" };

   public AltaPoliza02Controller(AltaPoliza02 altaPoliza02, ClienteDTO cliente, VehiculoDTO vehiculo,
         List<HijoDTO> hijoDTO, PolizaDTO poliza) {
      this.altaPoliza02 = altaPoliza02;
      this.cliente = cliente;
      this.vehiculo = vehiculo;
      this.hijoDTO = hijoDTO;
      this.poliza = poliza;

      listarTipos();
      listarTiposPago();

      // Pongo a escuchar los botones de la interfaz
      this.altaPoliza02.btn_alta_poliza02_continuar.addActionListener(this);
      this.altaPoliza02.btn_alta_poliza02_cancelar.addActionListener(this);

      // Lista en escucha
      this.altaPoliza02.list_alta_pol02.addMouseListener(this);
      // JCalendar escucha
      this.altaPoliza02.jdate_alta_pol02_vigencia.addPropertyChangeListener(this);
   }

   @Override
   public void actionPerformed(ActionEvent e) {
      if (e.getSource() == altaPoliza02.btn_alta_poliza02_continuar) {
         if (elementoSeleccionado.equals("Ninguno")) {
            JOptionPane.showMessageDialog(null, "Debe seleccionar un tipo de cobertura.", "Error",
                  JOptionPane.ERROR_MESSAGE);
         } else if (selectedDate == null || fechaAnterior(selectedDate) || fechaExcedida(selectedDate)) {
            JOptionPane.showMessageDialog(null, "Verifique las fechas.", "Error", JOptionPane.ERROR_MESSAGE);
         } else {
            actualizarPoliza();
            ConfirmacionDatosPoliza confirmacionDatosPoliza = new ConfirmacionDatosPoliza(cliente, vehiculo, hijoDTO,
                  poliza);
            // Acá analizamos si en confirmacion de Póliza el usuario eligió modificar o
            // confirmar, antes de cerra esta ventana
            confirmacionDatosPoliza.addWindowListener(new WindowAdapter() {
               @Override
               public void windowClosed(WindowEvent e) {
                  if (!confirmacionDatosPoliza.modificar) {
                     altaPoliza02.dispose();
                  }
               }
            });
         }
      } else if (e.getSource() == altaPoliza02.btn_alta_poliza02_cancelar) {
         // Paso 1: preguntar si confirma. Si lo hace, entonces cerramos.
         int confirmacion = JOptionPane.showOptionDialog(null, "¿Seguro de cancelar los cambios?",
               "Confirmar cancelación",
               JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
         if (confirmacion == 0) {
            this.altaPoliza02.dispose();
         }
      }
   }

   public void listarTipos() {
      lista.clear();

      tiposCobertura = GestorTipoCobertura.getInstance().getTipos();

      Integer anio_vehiculo = Integer.valueOf(vehiculo.getAnio());
      if (LocalDate.now().getYear() - anio_vehiculo > 10) {
         String resp_civil = tiposCobertura.stream().filter(t -> t.getNombre().equals("Responsabilidad Civil"))
               .map(t -> t.getNombre()).findAny().orElse(null);
         lista.addElement(resp_civil);
      } else {
         for (TipoCobertura t : tiposCobertura) {
            lista.addElement(t.getNombre());
         }
      }

      altaPoliza02.list_alta_pol02.setModel(lista);

   }

   public void listarTiposPago() {
      TipoPago[] valores = TipoPago.values();
      for (TipoPago valor : valores) {
         altaPoliza02.cmb_alta_pol02_forma_pago.addItem(valor.toString());
      }
   }

   @Override
   public void mouseClicked(MouseEvent e) {
      if (e.getSource() == altaPoliza02.list_alta_pol02) {
         JList<String> lista = (JList<String>) e.getSource();
         int index = lista.locationToIndex(e.getPoint()); // Obtiene el índice del elemento seleccionado
         // Si el índice es válido, obtenemos el texto de la fila seleccionada
         if (index != -1) {
            elementoSeleccionado = lista.getModel().getElementAt(index); //// Verificar cómo se carga el combo box para
            //// la selección
            TipoCobertura tipo = new TipoCobertura();

            for (TipoCobertura tipos : tiposCobertura) {
               if (tipos.getNombre().equals(elementoSeleccionado)) {
                  tipo = tipos;
               }
            }
            // Acá nos asguramos que el tipo de cobertura siempre sea el que está
            // seleccionado
            poliza.setTipoCobertura(tipo);
         }
      }
   }

   @Override
   public void propertyChange(PropertyChangeEvent evt) {
      if ("date".equals(evt.getPropertyName())) {
         selectedDate = (Date) evt.getNewValue();
         if (selectedDate != null) {
            // Verificar que la fecha sea futura
            if (fechaAnterior(selectedDate)) {
               JOptionPane.showMessageDialog(null, "Seleccione una fecha futura.", "Error", JOptionPane.ERROR_MESSAGE);
            } else {
               // Verificar que la fecha no sea más de 1 mes desde la fecha actual
               if (fechaExcedida(selectedDate)) {
                  JOptionPane.showMessageDialog(null,
                        "La fecha de inicio de cobertura no puede ser más de 1 mes desde hoy.", "Error",
                        JOptionPane.ERROR_MESSAGE);
               } else {
                  poliza.setFechaInicioVigencia(selectedDate);
               }
            }
         }
      }
   }

   private boolean fechaAnterior(Date selectedDate) {
      LocalDate localDate = selectedDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
      LocalDate currentDate = LocalDate.now();
      return (localDate.isBefore(currentDate) || localDate.isEqual(currentDate));

   }

   private boolean fechaExcedida(Date selectedDate) {
      LocalDate localDate = selectedDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
      LocalDate currentDate = LocalDate.now();
      LocalDate maxDate = currentDate.plusMonths(1);
      return (localDate.isAfter(maxDate));
   }

   private void actualizarPoliza() {
      // Datos relativos a la poliza a crearse
      poliza.setTipoPago(
            altaPoliza02.cmb_alta_pol02_forma_pago.getSelectedItem().toString().equals("MENSUAL") ? TipoPago.MENSUAL
                  : TipoPago.SEMESTRAL);
      poliza.setFechaInicioVigencia(selectedDate);
      // poliza.setTipoCobertura(); <--- Seteado en el mouse listener
      GestorSistemaFinanciero.getInstance().calcularPremioDerechosDescuentos(poliza);
      poliza.setCuotas(GestorPoliza.getInstance().crearCuotas(poliza));

   }

   @Override
   public void mousePressed(MouseEvent e) {
   }

   @Override
   public void mouseReleased(MouseEvent e) {
   }

   @Override
   public void mouseEntered(MouseEvent e) {
   }

   @Override
   public void mouseExited(MouseEvent e) {
   }
}
