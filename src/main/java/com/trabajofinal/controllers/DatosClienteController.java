package com.trabajofinal.controllers;

import com.trabajofinal.gui.AltaPoliza01;
import com.trabajofinal.gui.DatosCliente;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DatosClienteController implements ActionListener {
    
    private DatosCliente datosCliente;
    
    private Object[] options = {"Sí", "No"};

    public DatosClienteController(DatosCliente datosCliente) {
       
        
        this.datosCliente = datosCliente;
        
        //Botones en escucha
        this.datosCliente.btn_datos_cliente_nueva_poliza.addActionListener(this);
        
         //Le agrego un valor a txt_datos_cliente_user_code, después hay que modificar esto
        this.datosCliente.txt_datos_cliente_user_code.setText("<USER001>"); 
    }

    

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == datosCliente.btn_datos_cliente_nueva_poliza) {
            //Paso 1: hacer validaciones
            //Paso 2: Cargamos la vista de AltaPoliza01
            AltaPoliza01 altaPoliza01 = new AltaPoliza01();
        }
    }
    
}
