package com.trabajofinal.controllers;

import com.trabajofinal.dto.ClienteDTO;
import com.trabajofinal.dto.VehiculoDTO;
import com.trabajofinal.gui.AltaPoliza02;
import com.trabajofinal.gui.ConfirmacionDatosPoliza;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

public class AltaPoliza02Controller implements ActionListener {

    private AltaPoliza02 altaPoliza02;
    
    private Object[] options = {"Sí", "No"};

    public AltaPoliza02Controller(AltaPoliza02 altaPoliza02, ClienteDTO cliente, VehiculoDTO vehiculo) {
        this.altaPoliza02 = altaPoliza02;
        
        System.out.println(cliente + " --- " + vehiculo);
        //Pongo a escuchar los botones de la interfaz
        this.altaPoliza02.btn_alta_poliza02_continuar.addActionListener(this);
        this.altaPoliza02.btn_alta_poliza02_cancelar.addActionListener(this);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == altaPoliza02.btn_alta_poliza02_continuar) {
            //Paso 1: verificar todos los datos ya cargados.
            //Paso 2: pasamos a la siguiente ventana.
            ConfirmacionDatosPoliza confirmacionDatosPoliza  = new ConfirmacionDatosPoliza();
     
        } else if (e.getSource() == altaPoliza02.btn_alta_poliza02_cancelar) {
            //Paso 1: preguntar si confirma. Si lo hace, entonces cerramos.
            int confirmacion = JOptionPane.showOptionDialog(null, "¿Seguro de cancelar los cambios?", "Confirmar cancelación",
                    JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
            if (confirmacion == 0) {
                this.altaPoliza02.dispose();
            }
        }
    }
    
}
