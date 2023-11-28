package com.trabajofinal.controllers;

import com.trabajofinal.dto.ClienteDTO;
import com.trabajofinal.dto.VehiculoDTO;
import com.trabajofinal.dto.HijoDTO;
import com.trabajofinal.dto.PolizaDTO;
import com.trabajofinal.gui.AltaPoliza02;
import com.trabajofinal.gui.ConfirmacionDatosPoliza;
import com.trabajofinal.models.TipoCobertura;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import com.trabajofinal.dao.TipoCoberturaDao;

import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JOptionPane;

public class AltaPoliza02Controller implements ActionListener, MouseListener, PropertyChangeListener {

    private AltaPoliza02 altaPoliza02;
    DefaultListModel<String> lista = new DefaultListModel<>();
    private int selectedAnyo;
    private int selectedMes;
    private int selectedDia;
    private ClienteDTO cliente;
    private VehiculoDTO vehiculo;
    private List<HijoDTO> hijoDTO;
    private PolizaDTO poliza;

    private Object[] options = {"Sí", "No"};

    public AltaPoliza02Controller(AltaPoliza02 altaPoliza02, ClienteDTO cliente, VehiculoDTO vehiculo, List<HijoDTO> hijoDTO) {
        this.altaPoliza02 = altaPoliza02;
        this.cliente = cliente;
        this.vehiculo = vehiculo;
        this.hijoDTO = hijoDTO;
        this.poliza = new PolizaDTO();
        
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
            ConfirmacionDatosPoliza confirmacionDatosPoliza = new ConfirmacionDatosPoliza(cliente, vehiculo, hijoDTO, poliza);

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
        
        TipoCoberturaDao dao = new TipoCoberturaDao();
        List<TipoCobertura> tiposCobertura = dao.getAll();
        
        for(TipoCobertura t: tiposCobertura) {
        	lista.addElement(t.getNombre());
        }
        
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
                	poliza.setFechaInicioVigencia(selectedDate);
                }
            }
        }
    }

}
