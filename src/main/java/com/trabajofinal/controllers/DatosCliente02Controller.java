package com.trabajofinal.controllers;

import com.trabajofinal.gui.AltaPoliza01;
import com.trabajofinal.gui.DatosCliente02;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

public class DatosCliente02Controller implements ActionListener {
    
    private DatosCliente02 datosCliente02;
    
    private Object[] options = {"Sí", "No"};

    public DatosCliente02Controller(DatosCliente02 datosCliente02) {
        this.datosCliente02 = datosCliente02;
        
        //Botones a la escucha
        this.datosCliente02.btn_det_cliente01_ver_pol.addActionListener(this);
        this.datosCliente02.btn_det_cliente01_nueva_pol.addActionListener(this);
        this.datosCliente02.btn_det_cliente01_cancelar.addActionListener(this);
        this.datosCliente02.btn_det_cliente01_baja.addActionListener(this);
    }
    
    

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == datosCliente02.btn_det_cliente01_ver_pol) {
            //Logica para ver póliza
        } else if (e.getSource() == datosCliente02.btn_det_cliente01_nueva_pol) {
            //Validaciones? 
            this.datosCliente02.dispose();
            AltaPoliza01 altaPoliza01 = new AltaPoliza01();
            
        } if (e.getSource() == datosCliente02.btn_det_cliente01_baja) {
            //Lógica para dar de baja una póliza
        }if (e.getSource() == datosCliente02.btn_det_cliente01_cancelar) {
             //Paso 1: preguntar si confirma. Si lo hace, entonces cerramos.
            int confirmacion = JOptionPane.showOptionDialog(null, "¿Seguro de cancelar los cambios?", "Confirmar cancelación",
                    JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
            if (confirmacion == 0) {
                this.datosCliente02.dispose();
            }
        }
    }
    
}
