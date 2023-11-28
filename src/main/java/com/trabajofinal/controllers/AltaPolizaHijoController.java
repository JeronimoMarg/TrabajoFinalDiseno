package com.trabajofinal.controllers;

import com.trabajofinal.dto.HijoDTO;
import com.trabajofinal.gui.AltaPolizaHijo;
import com.trabajofinal.models.EstadoCivil;
import com.trabajofinal.models.TipoDocumento;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import javax.swing.JOptionPane;

public class AltaPolizaHijoController implements ActionListener, PropertyChangeListener {

    private AltaPolizaHijo altaPolizaHijo;
    private EstadoCivil estado_civil;
    LocalDate localDate;
    

    private Object[] options = {"Sí", "No"};

    public AltaPolizaHijoController(AltaPolizaHijo altaPolizaHijo) {
        this.altaPolizaHijo = altaPolizaHijo;

        cargarDatos();

        //Pongo a escuchar los botones de la interfaz
        this.altaPolizaHijo.btn_alta_poliza_hijo_cancelar.addActionListener(this);
        this.altaPolizaHijo.btn_alta_poliza_hijo_continuar.addActionListener(this);
        this.altaPolizaHijo.cmb_alta_pol_hijo_estado.addActionListener(this);
        this.altaPolizaHijo.cmb_alta_pol_hijo_sexo.addActionListener(this);
        this.altaPolizaHijo.jdate_alta_hijo.addPropertyChangeListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == altaPolizaHijo.btn_alta_poliza_hijo_continuar) {
            //Paso 1: chequear que los datos esten correctos con un Metodo
            //Paso 2: cerrar la ventana.
            //Cargar los datos de hijos para agregarlos al cliente!!!
            if (localDate != null) {
                AltaPoliza01Controller.addHijoDTO(setDatosHijo());
                this.altaPolizaHijo.dispose();
            } else {
                JOptionPane.showMessageDialog(null, "Debe seleccionar una fecha.");
            }

        } else if (e.getSource() == altaPolizaHijo.btn_alta_poliza_hijo_cancelar) {
            //Paso 1: preguntar si confirma. Si lo hace, entonces cerramos.
            int confirmacion = JOptionPane.showOptionDialog(null, "¿Seguro de cancelar los cambios?", "Confirmar cancelacíon",
                    JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
            if (confirmacion == 0) {
                this.altaPolizaHijo.dispose();
            }
        }        
    }

    private void cargarDatos() {
    	
        //Inicialiar cmb estado civil y sexo
    	EstadoCivil[] valores = EstadoCivil.values();
        for (EstadoCivil valor : valores) {
        	altaPolizaHijo.cmb_alta_pol_hijo_estado.addItem(valor.toString());
        }
        altaPolizaHijo.cmb_alta_pol_hijo_sexo.addItem("MASCULINO");
        altaPolizaHijo.cmb_alta_pol_hijo_sexo.addItem("FEMENINO");
    }

    private boolean validar() {
        return !(altaPolizaHijo.cmb_alta_pol_hijo_estado.getSelectedItem() == null
                || altaPolizaHijo.cmb_alta_pol_hijo_sexo.getSelectedItem() == null);
    }
    
    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        if ("date".equals(evt.getPropertyName())) {
            Date selectedDate = (Date) evt.getNewValue();
            if (selectedDate != null) {
                localDate = selectedDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
                LocalDate currentDate = LocalDate.now();

                if (localDate.isAfter(currentDate)) {
                    JOptionPane.showMessageDialog(null, "La fecha no puede ser superior a la actual.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
    }
    
    private HijoDTO setDatosHijo() {
        HijoDTO dto = new HijoDTO();
        
            dto.setEstado_civil(EstadoCivil.valueOf(altaPolizaHijo.cmb_alta_pol_hijo_estado.getSelectedItem().toString()));
            dto.setSexo(altaPolizaHijo.cmb_alta_pol_hijo_sexo.getSelectedItem().equals("MASCULINO"));
            dto.setFecha_nacimiento(localDate);
        
        return dto;
    }
}
