package com.trabajofinal.controllers;

import com.trabajofinal.gui.DetalleBonificaciones;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class DetalleBonificacionesController implements ActionListener {

    private DetalleBonificaciones detalleBonificaciones;

    public DetalleBonificacionesController(DetalleBonificaciones detalleBonificaciones) {
        this.detalleBonificaciones = detalleBonificaciones;
        
        //Botón en escucha
        this.detalleBonificaciones.btn_detalle_bonificaciones.addActionListener(this);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()== detalleBonificaciones.btn_detalle_bonificaciones) {
            this.detalleBonificaciones.dispose();
        }
    }
    
}
