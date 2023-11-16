package com.trabajofinal.controllers;

import com.trabajofinal.gui.AltaPoliza01;
import com.trabajofinal.gui.AltaPoliza02;
import com.trabajofinal.gui.AltaPolizaHijo;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

public class AltaPoliza01Controller implements ActionListener {
    
    private AltaPoliza01 altaPoliza01;
    
     private Object[] options = {"Sí", "No"};

    public AltaPoliza01Controller(AltaPoliza01 altaPoliza01) {
        this.altaPoliza01 = altaPoliza01;
        
        //Pongo a la escucha los botones de la interface
        this.altaPoliza01.btn_alta_poliza_agregar_hijo.addActionListener(this);
        this.altaPoliza01.btn_alta_poliza01_continuar.addActionListener(this);
        this.altaPoliza01.btn_alta_poliza01_cancelar.addActionListener(this);
    }
      


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()== altaPoliza01.btn_alta_poliza_agregar_hijo) {
            AltaPolizaHijo altaPolizaHijo = new AltaPolizaHijo();
        } else if (e.getSource() == altaPoliza01.btn_alta_poliza01_continuar) {
            //Paso 1: verificar todos los datos ya cargados.
            //Paso 2: pasamos a la siguiente ventana.
            AltaPoliza02 altaPoliza02 = new AltaPoliza02();
        
        } else if (e.getSource() == altaPoliza01.btn_alta_poliza01_cancelar) {
            //Paso 1: preguntar si confirma. Si lo hace, entonces cerramos.
            int confirmacion = JOptionPane.showOptionDialog(null, "¿Seguro de cancelar los cambios?", "Confirmar cancelación",
                    JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
            if (confirmacion == 0) {
                this.altaPoliza01.dispose();
            }
        }
    }
    
}
