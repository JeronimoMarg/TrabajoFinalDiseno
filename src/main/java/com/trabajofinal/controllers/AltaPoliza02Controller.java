package com.trabajofinal.controllers;

import com.trabajofinal.dto.ClienteDTO;
import com.trabajofinal.dto.VehiculoDTO;
import com.trabajofinal.gui.AltaPoliza02;
import com.trabajofinal.gui.ConfirmacionDatosPoliza;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JOptionPane;

public class AltaPoliza02Controller implements ActionListener, MouseListener, PropertyChangeListener {

    private AltaPoliza02 altaPoliza02;
    DefaultListModel<String> lista = new DefaultListModel<>();
    private int selectedAnyo;
    private int selectedMes;
    private int selectedDia;

    private Object[] options = {"Sí", "No"};

    public AltaPoliza02Controller(AltaPoliza02 altaPoliza02, ClienteDTO cliente, VehiculoDTO vehiculo) {
        this.altaPoliza02 = altaPoliza02;
        listarTipos();

        //Pongo a escuchar los botones de la interfaz
        this.altaPoliza02.btn_alta_poliza02_continuar.addActionListener(this);
        this.altaPoliza02.btn_alta_poliza02_cancelar.addActionListener(this);

        //Lista en escucha
        this.altaPoliza02.list_alta_pol02.addMouseListener(this);
        
        this.altaPoliza02.jdate_alta_pol02_vigencia.addPropertyChangeListener(this);
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

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        if ("date".equals(evt.getPropertyName())) {
            Date selectedDate = (Date) evt.getNewValue();
            if (selectedDate != null) {
                LocalDate localDate = selectedDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
                LocalDate currentDate = LocalDate.now();

                if (localDate.isBefore(currentDate) || localDate.isEqual(currentDate)) {
                    JOptionPane.showMessageDialog(null, "Seleccione una fecha futura.", "Error", JOptionPane.ERROR_MESSAGE);
                } else {
                    int dia = localDate.getDayOfMonth();
                    int mes = localDate.getMonthValue();
                    int año = localDate.getYear();

                    System.out.println("Día: " + dia + ", Mes: " + mes + ", Año: " + año);
                }
            }
        }
    }

}
