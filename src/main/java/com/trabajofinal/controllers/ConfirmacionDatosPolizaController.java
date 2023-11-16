package com.trabajofinal.controllers;

import com.trabajofinal.gui.ConfirmacionDatosPoliza;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

public class ConfirmacionDatosPolizaController implements ActionListener {
    
    private ConfirmacionDatosPoliza confirmacionDatosPoliza;
    
    private Object[] options = {"Sí", "No"};

    public ConfirmacionDatosPolizaController(ConfirmacionDatosPoliza confirmacionDatosPoliza) {
        this.confirmacionDatosPoliza = confirmacionDatosPoliza;
        
        //Pongo a escuchar los botones
        this.confirmacionDatosPoliza.btn_confirma_datos_pol_mod.addActionListener(this);
        this.confirmacionDatosPoliza.btn_confirma_datos_pol_fin.addActionListener(this);
        this.confirmacionDatosPoliza.btn_confirma_datos_pol_cancelar.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()== confirmacionDatosPoliza.btn_confirma_datos_pol_mod) {
            //Logica de modificacion
            this.confirmacionDatosPoliza.dispose();
        } else if (e.getSource() == confirmacionDatosPoliza.btn_confirma_datos_pol_fin) {
            //Logica de finalizar
            this.confirmacionDatosPoliza.dispose();
        } else if (e.getSource() == confirmacionDatosPoliza.btn_confirma_datos_pol_cancelar) {
            //Paso 1: preguntar si confirma. Si lo hace, entonces cerramos.
            int confirmacion = JOptionPane.showOptionDialog(null, "¿Seguro de cancelar los cambios?", "Confirmar cancelación",
                    JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
            if (confirmacion == 0) {
                this.confirmacionDatosPoliza.dispose();
            }
        }
    }
    
    
    
    
}
