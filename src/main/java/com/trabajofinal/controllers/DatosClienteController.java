package com.trabajofinal.controllers;

import com.trabajofinal.dto.ClienteDTO;
import com.trabajofinal.gui.AltaPoliza01;
import com.trabajofinal.gui.DatosCliente;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

public class DatosClienteController implements ActionListener {

   private DatosCliente datosCliente;
   private ClienteDTO cliente;

   private Object[] options = { "Sí", "No" };

   public DatosClienteController(DatosCliente datosCliente, ClienteDTO cliente) {

      this.datosCliente = datosCliente;
      this.cliente = cliente;

      // Botones a la escucha
      this.datosCliente.btn_det_cliente_ver_pol.addActionListener(this);
      this.datosCliente.btn_det_cliente_nueva_pol.addActionListener(this);
      this.datosCliente.btn_det_cliente_cancelar.addActionListener(this);
      this.datosCliente.btn_det_cliente_baja.addActionListener(this);
      actualizarInterface();

   }

   @Override
   public void actionPerformed(ActionEvent e) {
      if (e.getSource() == datosCliente.btn_det_cliente_ver_pol) {
         // Logica para ver póliza
         JOptionPane.showMessageDialog(null, "Aun no implementado");
      } else if (e.getSource() == datosCliente.btn_det_cliente_nueva_pol) {
         // Validaciones?
         this.datosCliente.dispose();
         AltaPoliza01 altaPoliza01 = new AltaPoliza01(cliente);

      }
      if (e.getSource() == datosCliente.btn_det_cliente_baja) {
         // Lógica para dar de baja una póliza
         JOptionPane.showMessageDialog(null, "Aun no implementado");
      }
      if (e.getSource() == datosCliente.btn_det_cliente_cancelar) {
         // Paso 1: preguntar si confirma. Si lo hace, entonces cerramos.
         int confirmacion = JOptionPane.showOptionDialog(null, "¿Seguro de cancelar los cambios?",
               "Confirmar cancelación",
               JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
         if (confirmacion == 0) {
            this.datosCliente.dispose();
         }
      }
   }

   private void actualizarInterface() {
      String nombre = cliente.getApellido().toString().trim() + ", " + cliente.getNombre().toString().trim();
      datosCliente.jlab_nombre_apellido.setText(nombre);
      datosCliente.txt_datos_cliente_calle.setText(cliente.getDomicilio().getNombre_calle().toString().trim());
      datosCliente.txt_datos_cliente_cod_postal.setText(cliente.getDomicilio().getCodigo_postal().toString().trim());
      datosCliente.txt_datos_cliente_dom_nro.setText(Integer.toString(cliente.getDomicilio().getNumero_calle()).trim());
      datosCliente.txt_datos_cliente_dpto.setText(cliente.getDomicilio().getDepartamento().toString().trim());
      datosCliente.txt_datos_cliente_local.setText(cliente.getDomicilio().getLocalidad().getNombre().toString().trim());
      datosCliente.txt_datos_cliente_provincia.setText("Santa Fe (ojo)");
      datosCliente.txt_datos_cliente_pais.setText("Argentina (ojo)");
      datosCliente.txt_datos_cliente_piso.setText(Integer.toString(cliente.getDomicilio().getPiso()).trim());
      datosCliente.txt_datos_cliente_tipo.setText(cliente.getTipo_documento().toString().trim());
      datosCliente.txt_datos_cliente_nro_cte.setText(cliente.getNumero_cliente().toString().trim());
      datosCliente.txt_datos_cliente_nro_doc.setText(cliente.getNumero_documento().toString().trim());

   }

}
