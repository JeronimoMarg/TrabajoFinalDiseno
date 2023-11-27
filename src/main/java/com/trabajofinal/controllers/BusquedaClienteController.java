package com.trabajofinal.controllers;

import com.trabajofinal.dao.ClienteDao;
import com.trabajofinal.dto.ClienteDTO;
import com.trabajofinal.gui.BusquedaCliente;
import com.trabajofinal.gui.DatosCliente;
import com.trabajofinal.gui.ProgressWindow;
import com.trabajofinal.models.Cliente;
import com.trabajofinal.models.TipoCondicionIVA;
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
    private boolean isValid = false;
    private Object[] options = {"Sí", "No"};
    private DefaultTableModel tabla = new DefaultTableModel();
    ClienteDTO clienteDTO = new ClienteDTO();

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
        //Tabla a la escucha
        this.busquedaCliente.table_busqueda_cliente.addMouseListener(this);

        inicializar_cmbx();

    }

    private void inicializar_cmbx() {

        TipoDocumento[] valores = TipoDocumento.values();
        for (TipoDocumento valor : valores) {
            busquedaCliente.cmb_busqueda_cliente_tipo1.addItem(valor.toString());
        }

        TipoCondicionIVA[] valores2 = TipoCondicionIVA.values();
        for (TipoCondicionIVA valor : valores2) {
            busquedaCliente.cmb_busqueda_cliente_cond.addItem(valor.toString());
        }

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == busquedaCliente.btn_busq_cliente_select) {
            // Lógica de verificación previa
            //ClienteDTO clienteDTO = aDTO(cliente);
        	
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
        busquedaCliente.txt_busqueda_cliente_nro_cte.setText("");
        busquedaCliente.cmb_busqueda_cliente_cond.setSelectedIndex(0);
    }

    private List<Cliente> searchClient() {

        ClienteDao cliente_dao = new ClienteDao();
        String nombre = busquedaCliente.txt_busqueda_cliente_nombre.getText().toString().trim();
        if (nombre != null && !nombre.isEmpty()) {
            cliente_dao.getClientesPorNombre(nombre);
        }
        String apellido = busquedaCliente.txt_busqueda_cliente_apellido.getText().toString().trim();
        if (apellido != null && !apellido.isEmpty()) {
            cliente_dao.getClientesPorApellido(apellido);
        }
        String numero_doc = busquedaCliente.txt_busqueda_cliente_nro_doc.getText().toString().trim();
        TipoDocumento tipo_doc = TipoDocumento
                .valueOf(busquedaCliente.cmb_busqueda_cliente_tipo1.getSelectedItem().toString());
        if (numero_doc != null && !numero_doc.isEmpty() && tipo_doc != null) {
            cliente_dao.getClientesPorDocumento(numero_doc, tipo_doc);
        }
        String numero_cliente = busquedaCliente.txt_busqueda_cliente_nro_cte.getText().toString().trim();
        if (numero_cliente != null && !numero_cliente.isEmpty()) {
            cliente_dao.getClientesPorNumero(numero_cliente);
        }
        TipoCondicionIVA iva = TipoCondicionIVA
                .valueOf(busquedaCliente.cmb_busqueda_cliente_cond.getSelectedItem().toString());
        if (iva != null && busquedaCliente.chk_busqueda_cliente.isSelected()) {
            cliente_dao.getClientesPorTipoIVA(iva);
        }
       return cliente_dao.ejecutarQuery();
    }

    private void listAllClients(List<Cliente> l) {
    	
    	
        List<ClienteDTO> lista = new ArrayList<>();
        for (Cliente c: l) {
            lista.add(aDTO(c));
        }
        
        
        tabla = (DefaultTableModel) busquedaCliente.table_busqueda_cliente.getModel();
        Object[] row = new Object[9];
        for (int i = 0; i < lista.size(); i++) {
            row[0] = lista.get(i).getNumero_cliente();
            row[1] = lista.get(i).getTipo_documento();
            row[2] = lista.get(i).getNumero_documento();
            row[3] = lista.get(i).getApellido();
            row[4] = lista.get(i).getNombre();
            row[5] = lista.get(i).getNumero_cuil();
            row[6] = lista.get(i).getCondicion_iva();
            row[7] = lista.get(i).getEmail();
            row[8] = lista.get(i).getId();
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
        
        //Necesito un método para traer el nombre de la provincia y del pais
        /*
        String prov = cliente.getDomicilio().getLocalidad().getProvincia().getNombre();
        String pais = cliente.getDomicilio().getLocalidad().getProvincia().getPais().getNombre();
        dto.setProvincia(prov);
        dto.setPais(pais);
        */
        
        return dto;
        
        
    }
    
    
    /*
    *****CON ESTE METODO SE IBA A LA MIERDA TODO. AHORA FUNCA.
    private List<ClienteDTO> listaADTO(List<Cliente> lista){
    	//ACA TENEMOS QUE PASAR LOS OBJETOS CLIENTE A DTO Y DESPUES MOSTRARLOS!!!
        List<ClienteDTO> clientes = Collections.emptyList();
        for (Cliente c: lista) {
            clientes.add(aDTO(c));
        }        
        return clientes;
    	
    }
*/

    //Método para limpiar la tabla
    public void cleanTable() {
        for (int i = 0; i < tabla.getRowCount(); i++) {
            tabla.removeRow(i);
            i--;
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource() == busquedaCliente.table_busqueda_cliente) {
            int fila = busquedaCliente.table_busqueda_cliente.rowAtPoint(e.getPoint());
            //La fila la proveé el método de arriba, pero la columna la sacamos de la posiición en la tabla
            busquedaCliente.txt_busqueda_cliente_nro_cte.setText(busquedaCliente.table_busqueda_cliente.getValueAt(fila, 0).toString());
            busquedaCliente.cmb_busqueda_cliente_tipo1.setSelectedItem(busquedaCliente.table_busqueda_cliente.getValueAt(fila, 1).toString());
            busquedaCliente.txt_busqueda_cliente_nro_doc.setText(busquedaCliente.table_busqueda_cliente.getValueAt(fila, 2).toString());
            busquedaCliente.txt_busqueda_cliente_apellido.setText(busquedaCliente.table_busqueda_cliente.getValueAt(fila, 3).toString());
            busquedaCliente.txt_busqueda_cliente_nombre.setText(busquedaCliente.table_busqueda_cliente.getValueAt(fila, 4).toString());
            busquedaCliente.cmb_busqueda_cliente_cond.setSelectedItem(busquedaCliente.table_busqueda_cliente.getValueAt(fila, 6).toString());
            int id = Integer.parseInt(busquedaCliente.table_busqueda_cliente.getValueAt(fila, 8).toString());
            ClienteDao cliente_dao = new ClienteDao();
            Cliente cliente = new Cliente();
            cliente = cliente_dao.getById(id);
            clienteDTO = aDTO(cliente);
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
