package com.trabajofinal.controllers;

import com.trabajofinal.dto.ClienteDTO;
import com.trabajofinal.dto.VehiculoDTO;
import com.trabajofinal.gui.AltaPoliza02;
import com.trabajofinal.gui.ConfirmacionDatosPoliza;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.time.LocalDate;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JOptionPane;

public class AltaPoliza02Controller implements ActionListener, MouseListener {

    private AltaPoliza02 altaPoliza02;
    DefaultListModel<String> lista = new DefaultListModel<>();
     private int selectedAnyo;
    private int selectedMes;
    private int selectedDia;

    private Object[] options = {"Sí", "No"};

    public AltaPoliza02Controller(AltaPoliza02 altaPoliza02, ClienteDTO cliente, VehiculoDTO vehiculo) {
        this.altaPoliza02 = altaPoliza02;
        cargarDatos();
        listarTipos();

        //Pongo a escuchar los botones de la interfaz
        this.altaPoliza02.btn_alta_poliza02_continuar.addActionListener(this);
        this.altaPoliza02.btn_alta_poliza02_cancelar.addActionListener(this);
        
        //Campos de selección de datos
        this.altaPoliza02.cmb_alta_pol02_anio.addActionListener(this);
        this.altaPoliza02.cmb_alta_pol02_mes.addActionListener(this);
        this.altaPoliza02.cmb_alta_pol02_dia.addActionListener(this);

        //Lista en escucha
        this.altaPoliza02.list_alta_pol02.addMouseListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == altaPoliza02.btn_alta_poliza02_continuar) {
            //Paso 1: verificar todos los datos ya cargados.
            //Paso 2: pasamos a la siguiente ventana.
            ConfirmacionDatosPoliza confirmacionDatosPoliza = new ConfirmacionDatosPoliza();

        } else if (e.getSource() == altaPoliza02.btn_alta_poliza02_cancelar) {
            //Paso 1: preguntar si confirma. Si lo hace, entonces cerramos.
            int confirmacion = JOptionPane.showOptionDialog(null, "¿Seguro de cancelar los cambios?", "Confirmar cancelación",
                    JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
            if (confirmacion == 0) {
                this.altaPoliza02.dispose();
            }
        } if (e.getSource() == altaPoliza02.cmb_alta_pol02_mes) {
            selectedMes = (int) altaPoliza02.cmb_alta_pol02_mes.getSelectedItem();
            selectedAnyo = (int) altaPoliza02.cmb_alta_pol02_anio.getSelectedItem();
            int dias;
            if (selectedMes == 2) {
                dias = (selectedAnyo % 4) == 0 ? 29 : 28;
            } else if (selectedMes == 1 || selectedMes == 3 || selectedMes == 5 || selectedMes == 7
                    || selectedMes == 8 || selectedMes == 10 || selectedMes == 12) {
                dias = 31;
            } else {
                dias = 30;
            }
            altaPoliza02.cmb_alta_pol02_dia.removeAllItems();
            for (int i = 1; i <= dias; i++) {
                altaPoliza02.cmb_alta_pol02_dia.addItem(i);
            }
        }
    }

    public void listarTipos() {
        lista.clear();
        lista.addElement("Cobertura Basica");
        lista.addElement("Cobertura Intermedia");
        lista.addElement("Cobertura Golden");
        altaPoliza02.list_alta_pol02.setModel(lista);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource() == altaPoliza02.list_alta_pol02) {
            JList<String> lista = (JList<String>) e.getSource();
            int index = lista.locationToIndex(e.getPoint()); // Obtiene el índice del elemento seleccionado

            // Si el índice es válido, lo seleccionamos en el JList
            if (index != -1) {
                lista.setSelectedIndex(index);
                JOptionPane.showMessageDialog(null, "Seleccionó el elemento en la posición: " + index);
            }
        }
    }
    
     private void cargarDatos() {
        //Inicializar los cmb de fechas
        LocalDate fechaActual = LocalDate.now();
        // Extraer el año de la fecha actual
        int anio = fechaActual.getYear();
        int mes = fechaActual.getMonthValue();
        int dia = fechaActual.getDayOfMonth();
        
        for (int i = anio; i <= anio+10; i++) {
            altaPoliza02.cmb_alta_pol02_anio.addItem(i);
        }
        //El año actual debe ser el que se ve como primer opción.
        altaPoliza02.cmb_alta_pol02_anio.setSelectedItem(anio);
        for (int i = 1; i <= 12; i++) {            
            altaPoliza02.cmb_alta_pol02_mes.addItem(i);
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }

}
