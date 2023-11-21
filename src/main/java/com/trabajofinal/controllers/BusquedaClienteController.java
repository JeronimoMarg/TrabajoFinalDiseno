package com.trabajofinal.controllers;

import com.trabajofinal.dto.ClienteDTO;
import com.trabajofinal.gui.BusquedaCliente;
import com.trabajofinal.gui.DatosCliente;
import com.trabajofinal.models.Domicilio;
import com.trabajofinal.models.EstadoCivil;
import com.trabajofinal.models.Localidad;
import com.trabajofinal.models.Pais;
import com.trabajofinal.models.Provincia;
import com.trabajofinal.models.TipoCondicion;
import com.trabajofinal.models.TipoCondicionIVA;
import com.trabajofinal.models.TipoDocumento;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.time.LocalDate;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;

public class BusquedaClienteController implements ActionListener, KeyListener {

   private BusquedaCliente busquedaCliente;

   // bloque de variables que usaremos en las validaciones y mensajes de
   private String regex = "^[a-zA-Z\\u00C0-\\u017FñÑ]+(\\s[a-zA-Z\\u00C0-\\u017FñÑ]+)*$";
   private String regex1 = "\\d";
   private boolean isValid = false;
   private Object[] options = { "Sí", "No" };

   public BusquedaClienteController(BusquedaCliente busquedaCliente) {
      this.busquedaCliente = busquedaCliente;

      // Botones a la escucha
      this.busquedaCliente.btn_busq_cliente_select.addActionListener(this);
      this.busquedaCliente.btn_busq_cliente_cancelar.addActionListener(this);
      this.busquedaCliente.btn_busq_cliente_buscar.addActionListener(this);
      this.busquedaCliente.btn_busq_cliente_limpiar.addActionListener(this);
      // ...y los campos de datos, para validarlos
      this.busquedaCliente.txt_busqueda_cliente_apellido.addKeyListener(this);
      this.busquedaCliente.txt_busqueda_cliente_nombre.addKeyListener(this);
      this.busquedaCliente.txt_busqueda_cliente_nro_doc.addKeyListener(this);

   }

   @Override
   public void actionPerformed(ActionEvent e) {
      if (e.getSource() == busquedaCliente.btn_busq_cliente_select) {
         // Lógica de verificación previa
         this.busquedaCliente.dispose();
         ClienteDTO cliente = crearCliente();
         cliente = crearCliente();
         DatosCliente datosCliente = new DatosCliente(cliente);
      } else if (e.getSource() == busquedaCliente.btn_busq_cliente_cancelar) {
         // Paso 1: preguntar si confirma. Si lo hace, entonces cerramos.
         int confirmacion = JOptionPane.showOptionDialog(null, "¿Seguro de cancelar la búsqueda?",
               "Confirmar cancelación",
               JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
         if (confirmacion == 0) {
            this.busquedaCliente.dispose();
         }
      } else if (e.getSource() == busquedaCliente.btn_busq_cliente_buscar) {
         JOptionPane.showMessageDialog(null, "Lo sentimos, implementación aun no realizada");
      } else if (e.getSource() == busquedaCliente.btn_busq_cliente_limpiar) {
         cleanFields();
      }
   }

   @Override
   public void keyTyped(KeyEvent e) {
      if (e.getSource() == busquedaCliente.txt_busqueda_cliente_apellido) {
         // Obtener el texto actual del JTextField
         String input = busquedaCliente.txt_busqueda_cliente_apellido.getText().trim();
         // Verificar si el texto ingresado coincide con la expresión regular
         isValid = Pattern.matches(regex, input);
         // Cambiar el color del JTextField dependiendo de si es válido o no
         if (isValid) {
            busquedaCliente.txt_busqueda_cliente_apellido.setForeground(java.awt.Color.BLACK);
         } else {
            busquedaCliente.txt_busqueda_cliente_apellido.setForeground(java.awt.Color.RED);
         }
      } else if (e.getSource() == busquedaCliente.txt_busqueda_cliente_nombre) {
         // Obtener el texto actual del JTextField
         String input = busquedaCliente.txt_busqueda_cliente_nombre.getText().trim();
         isValid = Pattern.matches(regex, input);
         if (isValid) {
            busquedaCliente.txt_busqueda_cliente_nombre.setForeground(java.awt.Color.BLACK);
         } else {
            busquedaCliente.txt_busqueda_cliente_nombre.setForeground(java.awt.Color.RED);
         }
      } else if (e.getSource() == busquedaCliente.txt_busqueda_cliente_nro_doc) {
         // Este método se llama cada vez que el usuario ingresa una tecla en el
         // JTextField
         // Obtener la tecla ingresada por el usuario
         char c = e.getKeyChar();
         // Verificar si la tecla ingresada coincide con la expresión regular
         if (!Character.toString(c).matches(regex1)) {
            // Si la tecla no coincide, se consume el evento, evitando que se agregue al
            // JTextField
            e.consume();
         }
      }
   }

   @Override
   public void keyPressed(KeyEvent e) {

   }

   @Override
   public void keyReleased(KeyEvent e) {

   }

   private void cleanFields() {
      busquedaCliente.txt_busqueda_cliente_apellido.setText("");
      busquedaCliente.txt_busqueda_cliente_nombre.setText("");
      busquedaCliente.txt_busqueda_cliente_nro_cte.setText("");
      busquedaCliente.txt_busqueda_cliente_nro_doc.setText("");
      busquedaCliente.txt_busqueda_cliente_nro_cte.setText("");
      busquedaCliente.cmb_busqueda_cliente_tipo.setSelectedIndex(0);
   }

   private ClienteDTO crearCliente() {
      ClienteDTO cliente = new ClienteDTO();
      cliente.setApellido("Danelone Cocco");
      cliente.setNombre("Diego Fernando");
      cliente.setNumero_documento("24876678");
      cliente.setNumero_cliente("C24876678");
      cliente.setTipo_documento(TipoDocumento.DNI);
      cliente.setActivo(true);
      cliente.setAnio_registro(2021);
      cliente.setCondicion(TipoCondicion.NORMAL);
      cliente.setCondicion_iva(TipoCondicionIVA.CONSUMIDOR_FINAL);
      cliente.setNumero_cuil("20248766787");
      Domicilio domicilio = new Domicilio();
      Pais pais = new Pais();
      Localidad localidad = new Localidad();
      Provincia provincia = new Provincia();
      provincia.setNombre("Santa Fe");
      pais.setNombre("Argentina");
      domicilio.setNombre_calle("Luciano Torrent");
      domicilio.setNumero_calle(1534);
      domicilio.setPiso(1);
      domicilio.setDepartamento("--");
      domicilio.setCodigo_postal("3000");
      domicilio.setId(1);
      domicilio.setEs_departamento(true);
      localidad.setNombre("Santa Fe");
      localidad.setRiesgo_localidad(null);
      provincia.setNombre("Santa Fe");
      provincia.setId(1);
      localidad.setProvincia(provincia);
      localidad.setId(1);
      domicilio.setLocalidad(localidad);
      pais.setNombre("Argentina");
      pais.setId(1);
      provincia.setPais(pais);
      cliente.setDomicilio(domicilio);
      cliente.setEmail("dr.danelone@gmail.com");
      cliente.setEstado_civil(EstadoCivil.SOLTERO);
      cliente.setProfesion("Abogado");
      cliente.setSexo(true);
      cliente.setFecha_nacimiento(LocalDate.of(1975, 11, 19));
      return cliente;
   }

}
