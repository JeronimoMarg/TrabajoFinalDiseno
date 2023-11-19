package com.trabajofinal.controllers;

import com.trabajofinal.gui.AltaPoliza01;
import com.trabajofinal.gui.DatosCliente;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

public class DatosClienteController implements ActionListener {
    
    private DatosCliente datosCliente;
    
    private Object[] options = {"Sí", "No"};

    public DatosClienteController(DatosCliente datosCliente) {
        
        this.datosCliente = datosCliente;
        
        //Botones a la escucha
        this.datosCliente.btn_det_cliente_ver_pol.addActionListener(this);
        this.datosCliente.btn_det_cliente_nueva_pol.addActionListener(this);
        this.datosCliente.btn_det_cliente_cancelar.addActionListener(this);
        this.datosCliente.btn_det_cliente_baja.addActionListener(this);
        
    }
    
    

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == datosCliente.btn_det_cliente_ver_pol) {
            //Logica para ver póliza
            JOptionPane.showMessageDialog(null, "Aun no implementado");
        } else if (e.getSource() == datosCliente.btn_det_cliente_nueva_pol) {
            //Validaciones? 
            this.datosCliente.dispose();
            AltaPoliza01 altaPoliza01 = new AltaPoliza01();
            
        } if (e.getSource() == datosCliente.btn_det_cliente_baja) {
            //Lógica para dar de baja una póliza
                        JOptionPane.showMessageDialog(null, "Aun no implementado");
        }if (e.getSource() == datosCliente.btn_det_cliente_cancelar) {
             //Paso 1: preguntar si confirma. Si lo hace, entonces cerramos.
            int confirmacion = JOptionPane.showOptionDialog(null, "¿Seguro de cancelar los cambios?", "Confirmar cancelación",
                    JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
            if (confirmacion == 0) {
                this.datosCliente.dispose();
            }
        }
    }
    
}
