package com.trabajofinal.controllers;

import com.trabajofinal.gui.AltaPolizaHijo;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

public class AltaPolizaHijoController implements ActionListener {

    private AltaPolizaHijo altaPolizaHijo;

    private Object[] options = {"Sí", "No"};

    public AltaPolizaHijoController(AltaPolizaHijo altaPolizaHijo) {
        this.altaPolizaHijo = altaPolizaHijo;

        //Pongo a escuchar los botones de la interfaz
        this.altaPolizaHijo.btn_alta_poliza_hijo_cancelar.addActionListener(this);
        this.altaPolizaHijo.btn_alta_poliza_hijo_continuar.addActionListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == altaPolizaHijo.btn_alta_poliza_hijo_continuar) {
            //Paso 1: chequear que los datos esten correctos con un Metodo
            //Paso 2: cerrar la ventana.
            this.altaPolizaHijo.dispose();
        } else if (e.getSource() == altaPolizaHijo.btn_alta_poliza_hijo_cancelar) {
            //Paso 1: preguntar si confirma. Si lo hace, entonces cerramos.
            int confirmacion = JOptionPane.showOptionDialog(null, "¿Seguro de cancelar los cambios?", "Confirmar cancelacíon",
                    JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
            if (confirmacion == 0) {
                this.altaPolizaHijo.dispose();
            }
        }

    }

}
