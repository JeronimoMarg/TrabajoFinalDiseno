package com.trabajofinal.controllers;

import com.trabajofinal.dao.ClienteDao;
import com.trabajofinal.dto.ClienteDTO;
import com.trabajofinal.gestores.GestorClientes;
import com.trabajofinal.gestores.GestorLimiteDeBusqueda;
import com.trabajofinal.gui.BusquedaCliente;
import com.trabajofinal.gui.ConfiguracionLimiteDeBusqueda;
import com.trabajofinal.gui.DatosCliente;
import com.trabajofinal.gui.ProgressWindow;
import com.trabajofinal.models.Cliente;
import com.trabajofinal.models.TipoDocumento;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class BusquedaClienteController implements ActionListener, KeyListener, MouseListener {

   private BusquedaCliente busquedaCliente;

   // bloque de variables que usaremos en las validaciones y mensajes de
   private String regex = "^[a-zA-Z\\u00C0-\\u017FñÑ]+(\\s[a-zA-Z\\u00C0-\\u017FñÑ]+)*$";
   private String regex1 = "\\d";
   private Object[] options = { "Sí", "No" };
   private DefaultTableModel tabla = new DefaultTableModel();
   private ClienteDTO clienteDTO = new ClienteDTO();
   private int fila;
   private int limite = GestorLimiteDeBusqueda.getInstance().getLimite();

   public BusquedaClienteController(BusquedaCliente busquedaCliente) {
      this.busquedaCliente = busquedaCliente;

      // Botones a la escucha
      this.busquedaCliente.btn_busq_cliente_config_limite.addActionListener(this);
      this.busquedaCliente.btn_busq_cliente_select.addActionListener(this);
      this.busquedaCliente.btn_busq_cliente_cancelar.addActionListener(this);
      this.busquedaCliente.btn_busq_cliente_buscar.addActionListener(this);
      this.busquedaCliente.btn_busq_cliente_limpiar.addActionListener(this);
      // ...y los campos de datos, para validarlos
      this.busquedaCliente.txt_busqueda_cliente_apellido.addKeyListener(this);
      this.busquedaCliente.txt_busqueda_cliente_nombre.addKeyListener(this);
      this.busquedaCliente.txt_busqueda_cliente_nro_doc.addKeyListener(this);
      // Tabla a la escucha
      this.busquedaCliente.table_busqueda_cliente.addMouseListener(this);

      inicializar_cmbx();

   }

   private void inicializar_cmbx() {

      TipoDocumento[] valores = TipoDocumento.values();
      for (TipoDocumento valor : valores) {
         busquedaCliente.cmb_busqueda_cliente_tipo1.addItem(valor.toString());
      }
   }

   @Override
   public void actionPerformed(ActionEvent e) {
      if (e.getSource() == busquedaCliente.btn_busq_cliente_select) {
         int id = Integer.parseInt(busquedaCliente.table_busqueda_cliente.getValueAt(fila, 5).toString());
         Cliente cliente = new Cliente();
         cliente = GestorClientes.getInstance().obtenerCliente(id);
         clienteDTO = aDTO(cliente);

         this.busquedaCliente.dispose();
         DatosCliente datosCliente = new DatosCliente(clienteDTO);

      } else if (e.getSource() == busquedaCliente.btn_busq_cliente_cancelar) {
         // Paso 1: preguntar si confirma. Si lo hace, entonces cerramos.
         int confirmacion = JOptionPane.showOptionDialog(null, "¿Seguro de cancelar la búsqueda?",
               "Confirmar cancelación",
               JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
         if (confirmacion == 0) {
            this.busquedaCliente.dispose();
         }
      } else if (e.getSource() == busquedaCliente.btn_busq_cliente_buscar) {
         cleanTable();

         ProgressWindow progreso = new ProgressWindow();
         // Hilo para la carga de datos
         Thread hiloDatos = new Thread() {
            @Override
            public void run() {
               listAllClients(searchClient());
               progreso.dispose();
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
         hiloDatos.start();
         hiloProgreso.start();
      } else if (e.getSource() == busquedaCliente.btn_busq_cliente_limpiar) {
         cleanFields();
      } else if (e.getSource() == busquedaCliente.btn_busq_cliente_config_limite) {
         ConfiguracionLimiteDeBusqueda configuracionLimiteDeBusqueda = new ConfiguracionLimiteDeBusqueda();
      }
   }

   @Override
   public void keyTyped(KeyEvent e) {
      JTextField textField = (JTextField) e.getSource();

      if (textField == busquedaCliente.txt_busqueda_cliente_apellido
            || textField == busquedaCliente.txt_busqueda_cliente_nombre) {
         validarCampoTexto(textField, regex);
      } else if (textField == busquedaCliente.txt_busqueda_cliente_nro_doc) {
         char c = e.getKeyChar();
         if (!Character.toString(c).matches(regex1)) {
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

   private void validarCampoTexto(JTextField textField, String regex) {
      String input = textField.getText().trim();
      boolean isValid = Pattern.matches(regex, input);

      if (isValid) {
         textField.setForeground(Color.BLACK);
      } else {
         textField.setForeground(Color.RED);
      }
   }

   private void cleanFields() {
      busquedaCliente.txt_busqueda_cliente_apellido.setText("");
      busquedaCliente.txt_busqueda_cliente_nombre.setText("");
      busquedaCliente.txt_busqueda_cliente_nro_cte.setText("");
      busquedaCliente.txt_busqueda_cliente_nro_doc.setText("");
      busquedaCliente.cmb_busqueda_cliente_tipo1.setSelectedIndex(0);
   }

   private List<Cliente> searchClient() {
      GestorClientes gestorClientes = GestorClientes.getInstance();

      String nombre = busquedaCliente.txt_busqueda_cliente_nombre.getText().toString().trim();
      String apellido = busquedaCliente.txt_busqueda_cliente_apellido.getText().toString().trim();
      String numeroDoc = busquedaCliente.txt_busqueda_cliente_nro_doc.getText().toString().trim();
      TipoDocumento tipoDoc = TipoDocumento
            .valueOf(busquedaCliente.cmb_busqueda_cliente_tipo1.getSelectedItem().toString());
      String numeroCliente = busquedaCliente.txt_busqueda_cliente_nro_cte.getText().toString().trim();

      return gestorClientes.buscarClientes(nombre, apellido, numeroDoc, tipoDoc, numeroCliente);
   }

   private void listAllClients(List<Cliente> l) {
      List<ClienteDTO> lista = new ArrayList<>();
      for (Cliente c : l) {
         lista.add(aDTO(c));
      }

      tabla = (DefaultTableModel) busquedaCliente.table_busqueda_cliente.getModel();
      Object[] row = new Object[6];
      for (int i = 0; i < lista.size(); i++) {
         row[0] = lista.get(i).getNumero_cliente();
         row[1] = lista.get(i).getTipo_documento();
         row[2] = lista.get(i).getNumero_documento();
         row[3] = lista.get(i).getApellido();
         row[4] = lista.get(i).getNombre();
         row[5] = lista.get(i).getId();
         // System.out.println(lista.get(i).getId());

         tabla.addRow(row);
      }
   }

   private ClienteDTO aDTO(Cliente cliente) {

      ClienteDTO dto = new ClienteDTO();

      dto.setId(cliente.getId());
      dto.setNumero_cliente(cliente.getNumero_cliente());
      dto.setNumero_documento(cliente.getNumero_documento());
      dto.setTipo_documento(cliente.getTipo_documento());
      dto.setNombre(cliente.getNombre());
      dto.setApellido(cliente.getApellido());
      dto.setCondicion(cliente.getCondicion());
      dto.setActivo(cliente.getActivo());
      dto.setAnio_registro(cliente.getAnio_registro());
      dto.setProfesion(cliente.getProfesion());
      dto.setNumero_cuil(cliente.getNumero_cuil());
      dto.setEmail(cliente.getEmail());
      dto.setCondicion_iva(cliente.getCondicion_iva());
      dto.setFecha_nacimiento(cliente.getFecha_nacimiento());
      dto.setEstado_civil(cliente.getEstado_civil());
      dto.setSexo(cliente.getSexo());
      dto.setCalle(cliente.getDomicilio().getNombre_calle());
      dto.setCod_postal(cliente.getDomicilio().getCodigo_postal());
      dto.setNro(cliente.getDomicilio().getNumero_calle());
      dto.setPiso(cliente.getDomicilio().getPiso());
      dto.setDepartamento(cliente.getDomicilio().getDepartamento());
      dto.setLocalidad(cliente.getDomicilio().getLocalidad().getNombre());

      String prov = cliente.getDomicilio().getLocalidad().getProvincia().getNombre();
      String pais = cliente.getDomicilio().getLocalidad().getProvincia().getPais().getNombre();
      dto.setProvincia(prov);
      dto.setPais(pais);

      return dto;

   }

   // Método para limpiar la tabla
   public void cleanTable() {
      for (int i = 0; i < tabla.getRowCount(); i++) {
         tabla.removeRow(i);
         i--;
      }
   }

   @Override
   public void mouseClicked(MouseEvent e) {
      if (e.getSource() == busquedaCliente.table_busqueda_cliente) {
         fila = busquedaCliente.table_busqueda_cliente.rowAtPoint(e.getPoint());
         // La fila la proveé el método de arriba, pero la columna la sacamos de la
         // posiición en la tabla
         busquedaCliente.txt_busqueda_cliente_nro_cte
               .setText(busquedaCliente.table_busqueda_cliente.getValueAt(fila, 0).toString());
         busquedaCliente.cmb_busqueda_cliente_tipo1
               .setSelectedItem(busquedaCliente.table_busqueda_cliente.getValueAt(fila, 1).toString());
         busquedaCliente.txt_busqueda_cliente_nro_doc
               .setText(busquedaCliente.table_busqueda_cliente.getValueAt(fila, 2).toString());
         busquedaCliente.txt_busqueda_cliente_apellido
               .setText(busquedaCliente.table_busqueda_cliente.getValueAt(fila, 3).toString());
         busquedaCliente.txt_busqueda_cliente_nombre
               .setText(busquedaCliente.table_busqueda_cliente.getValueAt(fila, 4).toString());
         /*
          * int id =
          * Integer.parseInt(busquedaCliente.table_busqueda_cliente.getValueAt(fila,
          * 8).toString());
          * ClienteDao cliente_dao = new ClienteDao();
          * Cliente cliente = new Cliente();
          * cliente = cliente_dao.getById(id);
          * clienteDTO = aDTO(cliente);
          */
         busquedaCliente.btn_busq_cliente_select.setEnabled(true);
      }
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
