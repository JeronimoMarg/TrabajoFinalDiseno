package com.trabajofinal.controllers;

import com.trabajofinal.dao.ClienteDao;
import com.trabajofinal.dto.ClienteDTO;
import com.trabajofinal.gui.BusquedaCliente;
import com.trabajofinal.gui.DatosCliente;
import com.trabajofinal.models.Cliente;
import com.trabajofinal.models.Domicilio;
import com.trabajofinal.models.EstadoCivil;
import com.trabajofinal.models.Localidad;
import com.trabajofinal.models.Pais;
import com.trabajofinal.models.Provincia;
import com.trabajofinal.models.TipoCondicion;
import com.trabajofinal.models.TipoCondicionIVA;
import com.trabajofinal.models.TipoDocumento;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

import java.awt.Color;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.time.LocalDate;
import java.util.List;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class BusquedaClienteController implements ActionListener, KeyListener {

    private BusquedaCliente busquedaCliente;

    // bloque de variables que usaremos en las validaciones y mensajes de
    private String regex = "^[a-zA-Z\\u00C0-\\u017FñÑ]+(\\s[a-zA-Z\\u00C0-\\u017FñÑ]+)*$";
    private String regex1 = "\\d";
    private boolean isValid = false;
    private Object[] options = {"Sí", "No"};

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
            this.busquedaCliente.dispose();
            //ClienteDTO cliente = aDTO(buscarCliente());
            //DatosCliente datosCliente = new DatosCliente(cliente);
        } else if (e.getSource() == busquedaCliente.btn_busq_cliente_cancelar) {
            // Paso 1: preguntar si confirma. Si lo hace, entonces cerramos.
            int confirmacion = JOptionPane.showOptionDialog(null, "¿Seguro de cancelar la búsqueda?",
                    "Confirmar cancelación",
                    JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
            if (confirmacion == 0) {
                this.busquedaCliente.dispose();
            }
        } else if (e.getSource() == busquedaCliente.btn_busq_cliente_buscar) {
        	
        	buscarCliente();
        	
        	
        } else if (e.getSource() == busquedaCliente.btn_busq_cliente_limpiar) {
            cleanFields();
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
        JTextField textField = (JTextField) e.getSource();

        if (textField == busquedaCliente.txt_busqueda_cliente_apellido || textField == busquedaCliente.txt_busqueda_cliente_nombre) {
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
    
    private void buscarClientePorNumero(String numero_cliente) {
 	   
    	ClienteDao dao = new ClienteDao();
    	List<Cliente> clientes = dao.getClientesPorNumero(numero_cliente);
    	System.out.println(clientes);
 	   
    }
    
    private void buscarClientePorDocumento(String documento, TipoDocumento tipo) {
    	
    	ClienteDao dao = new ClienteDao();
    	List<Cliente> clientes = dao.getClientesPorDocumento(documento, tipo);
    	System.out.println(clientes);
    	
    }
    
    private void buscarClientePorTipoIVA(TipoCondicionIVA tipo) {
    	
    	ClienteDao dao = new ClienteDao();
    	List<Cliente> clientes = dao.getClientesPorTipoIVA(tipo);
    	System.out.println(clientes);
    	
    }
    
    private void buscarClientePorNombre(String nombre) {
    	
    	ClienteDao dao = new ClienteDao();
    	List<Cliente> clientes = dao.getClientesPorNombre(nombre);
    	System.out.println(clientes);
    	
    }
    
    private void buscarClientePorApellido(String apellido) {
    	
    	ClienteDao dao = new ClienteDao();
    	List<Cliente> clientes = dao.getClientesPorApellido(apellido);
    	System.out.println(clientes);
    	
    }
    
    private void buscarCliente() {
    	
    	//busqueda por Numero de cliente:
    	buscarClientePorNumero(busquedaCliente.txt_busqueda_cliente_nro_cte.getText().toString().trim());
    	
    	//busqueda por numero de documento:
    	buscarClientePorDocumento(busquedaCliente.txt_busqueda_cliente_nro_doc.getText().toString().trim(), TipoDocumento.valueOf(busquedaCliente.cmb_busqueda_cliente_tipo1.getSelectedItem().toString()));
    	
    	//busqueda por tipo de condicion iva:
    	buscarClientePorTipoIVA(TipoCondicionIVA.valueOf(busquedaCliente.cmb_busqueda_cliente_cond.getSelectedItem().toString()));
    	
    	//busqueda por nombre:
    	buscarClientePorNombre(busquedaCliente.txt_busqueda_cliente_nombre.getText().toString().trim());
    	
    	//busqueda por nombre:
    	buscarClientePorApellido(busquedaCliente.txt_busqueda_cliente_apellido.getText().toString().trim());
    
    }
    
    private ClienteDTO aDTO(Cliente cliente) {
    	
    	ClienteDTO dto = new ClienteDTO();
    	
    	/*
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
    	*/


    	return dto;
    	
    }

}
