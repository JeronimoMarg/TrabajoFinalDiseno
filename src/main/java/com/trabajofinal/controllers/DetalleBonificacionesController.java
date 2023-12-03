package com.trabajofinal.controllers;

import com.trabajofinal.gui.DetalleBonificaciones;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class DetalleBonificacionesController implements ActionListener {

    private DetalleBonificaciones detalleBonificaciones;

    public DetalleBonificacionesController(DetalleBonificaciones detalleBonificaciones, Double dcto_antig, Double dcto_mas_una_un, Double dcto_pago_sem) {
        this.detalleBonificaciones = detalleBonificaciones;
        
        //setear los datos, previo formatearlos
        String montoFormateado = String.format("%.2f", dcto_antig);
        this.detalleBonificaciones.txt_det_bon_ant.setText(montoFormateado);
        montoFormateado = String.format("%.2f", dcto_mas_una_un);
        this.detalleBonificaciones.txt_det_bon_unidad.setText(montoFormateado);
        montoFormateado = String.format("%.2f", dcto_pago_sem);
        this.detalleBonificaciones.txt_det_bon_sem.setText(montoFormateado);
        
        //Botón en escucha
        this.detalleBonificaciones.btn_detalle_bonificaciones.addActionListener(this);

        this.detalleBonificaciones.setDefaultCloseOperation(DetalleBonificaciones.DISPOSE_ON_CLOSE);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()== detalleBonificaciones.btn_detalle_bonificaciones) {
            this.detalleBonificaciones.dispose();
        }
    }
    
}
