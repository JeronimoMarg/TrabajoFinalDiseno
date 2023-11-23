package com.trabajofinal.controllers;

import com.trabajofinal.gui.AltaPolizaHijo;
import com.trabajofinal.models.EstadoCivil;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class AltaPolizaHijoController implements ActionListener {

    private AltaPolizaHijo altaPolizaHijo;
    private int selectedAnyo;
    private int selectedMes;
    private int selectedDia;
    private EstadoCivil estado_civil;

    private Object[] options = {"Sí", "No"};

    public AltaPolizaHijoController(AltaPolizaHijo altaPolizaHijo) {
        this.altaPolizaHijo = altaPolizaHijo;

        cargarDatos();

        //Pongo a escuchar los botones de la interfaz
        this.altaPolizaHijo.btn_alta_poliza_hijo_cancelar.addActionListener(this);
        this.altaPolizaHijo.btn_alta_poliza_hijo_continuar.addActionListener(this);
        this.altaPolizaHijo.cmb_alta_pol_hijo_anio.addActionListener(this);
        this.altaPolizaHijo.cmb_alta_pol_hijo_dia.addActionListener(this);
        this.altaPolizaHijo.cmb_alta_pol_hijo_estado.addActionListener(this);
        this.altaPolizaHijo.cmb_alta_pol_hijo_mes.addActionListener(this);
        this.altaPolizaHijo.cmb_alta_pol_hijo_sexo.addActionListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == altaPolizaHijo.btn_alta_poliza_hijo_continuar) {
            //Paso 1: chequear que los datos esten correctos con un Metodo
            //Paso 2: cerrar la ventana.
            //Cargar los datos de hijos para agregarlos al cliente!!!
            if (validar()) {
                this.altaPolizaHijo.dispose();
            }  else {
                JOptionPane.showMessageDialog(null, "Todos los campos son obligatorios.");
            }
            
        } else if (e.getSource() == altaPolizaHijo.btn_alta_poliza_hijo_cancelar) {
            //Paso 1: preguntar si confirma. Si lo hace, entonces cerramos.
            int confirmacion = JOptionPane.showOptionDialog(null, "¿Seguro de cancelar los cambios?", "Confirmar cancelacíon",
                    JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
            if (confirmacion == 0) {
                this.altaPolizaHijo.dispose();
            }
        }
        if (e.getSource() == altaPolizaHijo.cmb_alta_pol_hijo_mes) {
            selectedMes = (int) altaPolizaHijo.cmb_alta_pol_hijo_mes.getSelectedItem();
            selectedAnyo = (int) altaPolizaHijo.cmb_alta_pol_hijo_anio.getSelectedItem();
            int dias;
            if (selectedMes == 2) {
                dias = (selectedAnyo % 4) == 0 ? 29 : 28;
            } else if (selectedMes == 1 || selectedMes == 3 || selectedMes == 5 || selectedMes == 7
                    || selectedMes == 8 || selectedMes == 10 || selectedMes == 12) {
                dias = 31;
            } else {
                dias = 30;
            }
            altaPolizaHijo.cmb_alta_pol_hijo_dia.removeAllItems();
            for (int i = 1; i <= dias; i++) {
                altaPolizaHijo.cmb_alta_pol_hijo_dia.addItem(i);
            }
        }

    }

    private void cargarDatos() {
        //Inicializar los cmb de fechas
        LocalDate fechaActual = LocalDate.now();
        // Extraer el año de la fecha actual
        int anio = fechaActual.getYear();

        for (int i = 1900; i <= anio; i++) {
            altaPolizaHijo.cmb_alta_pol_hijo_anio.addItem(i);
        }
        altaPolizaHijo.cmb_alta_pol_hijo_anio.setSelectedItem(anio);
        for (int i = 1; i <= 12; i++) {
            altaPolizaHijo.cmb_alta_pol_hijo_mes.addItem(i);
        }

        //Inicialiar cmb estado civil y sexo
        altaPolizaHijo.cmb_alta_pol_hijo_estado.addItem(EstadoCivil.SOLTERO);
        altaPolizaHijo.cmb_alta_pol_hijo_estado.addItem(EstadoCivil.CASADO);
        altaPolizaHijo.cmb_alta_pol_hijo_estado.addItem(EstadoCivil.DIVORCIADO);
        altaPolizaHijo.cmb_alta_pol_hijo_estado.addItem(EstadoCivil.VIUDO);
        altaPolizaHijo.cmb_alta_pol_hijo_sexo.addItem("MASCULINO");
        altaPolizaHijo.cmb_alta_pol_hijo_sexo.addItem("FEMENINO");
    }
    
    private boolean validar() {
        return !(altaPolizaHijo.cmb_alta_pol_hijo_estado.getSelectedItem() == null
                || altaPolizaHijo.cmb_alta_pol_hijo_sexo.getSelectedItem() == null
                || altaPolizaHijo.cmb_alta_pol_hijo_dia.getSelectedItem() == null
                || altaPolizaHijo.cmb_alta_pol_hijo_mes.getSelectedItem() == null
                || altaPolizaHijo.cmb_alta_pol_hijo_anio.getSelectedItem() == null);
    }
}
