package com.trabajofinal.controllers;

import com.trabajofinal.gui.DetalleCuotas;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DetalleCuotasController implements ActionListener {

    private DetalleCuotas detalleCuotas;
    
    public DetalleCuotasController(DetalleCuotas detalleCuotas) {
        this.detalleCuotas = detalleCuotas;
        
        //Pongo a la escucha el botón
        this.detalleCuotas.btn_detalle_cuotas.addActionListener(this);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == detalleCuotas.btn_detalle_cuotas) {
            this.detalleCuotas.dispose();
        }
        
    }
    
}
