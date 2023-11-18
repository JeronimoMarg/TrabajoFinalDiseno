package com.trabajofinal.controllers;

import com.trabajofinal.gui.BusquedaCliente;
import com.trabajofinal.gui.DatosCliente02;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

public class BusquedaClienteController implements ActionListener {
    
    private BusquedaCliente busquedaCliente;
    
    private Object[] options = {"Sí", "No"};

    public BusquedaClienteController(BusquedaCliente busquedaCliente) {
        this.busquedaCliente = busquedaCliente;
        
        //Botones a la escucha
        this.busquedaCliente.btn_busq_cliente_select.addActionListener(this);
        this.busquedaCliente.btn_busq_cliente_cancelar.addActionListener(this);
    }
    

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == busquedaCliente.btn_busq_cliente_select) {
            //Lógica de verificación previa
            this.busquedaCliente.dispose();
            DatosCliente02 datosCliente02 = new DatosCliente02();
        } else if (e.getSource() == busquedaCliente.btn_busq_cliente_cancelar) {
        //Paso 1: preguntar si confirma. Si lo hace, entonces cerramos.
            int confirmacion = JOptionPane.showOptionDialog(null, "¿Seguro de cancelar la búsqueda?", "Confirmar cancelación",
                    JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
            if (confirmacion == 0) {
                this.busquedaCliente.dispose();
            }
        }
    }
    
    
}
