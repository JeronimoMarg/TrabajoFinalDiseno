package com.trabajofinal.controllers;

import com.trabajofinal.dto.ClienteDTO;
import com.trabajofinal.dto.VehiculoDTO;
import com.trabajofinal.gui.AltaPoliza01;
import com.trabajofinal.gui.AltaPoliza02;
import com.trabajofinal.gui.AltaPolizaHijo;
import com.trabajofinal.models.FactoresModelo;
import com.trabajofinal.models.FactoresVehiculo;
import com.trabajofinal.models.Marca;
import com.trabajofinal.models.Modelo;
import com.trabajofinal.models.TipoVehiculo;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.time.LocalDate;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class AltaPoliza01Controller implements ActionListener, KeyListener {

    private AltaPoliza01 altaPoliza01;
    private ClienteDTO cliente;

    private Object[] options = {"Sí", "No"};

    public AltaPoliza01Controller() {
    }

    public AltaPoliza01Controller(AltaPoliza01 altaPoliza01, ClienteDTO cliente) {
        this.altaPoliza01 = altaPoliza01;
        this.cliente = cliente;

        //Pongo a la escucha los botones de la interface
        this.altaPoliza01.btn_alta_poliza_agregar_hijo.addActionListener(this);
        this.altaPoliza01.btn_alta_poliza01_continuar.addActionListener(this);
        this.altaPoliza01.btn_alta_poliza01_cancelar.addActionListener(this);

        //Campos de texto para validar
        this.altaPoliza01.txt_alta_pol01_chasis.addKeyListener(this);
        this.altaPoliza01.txt_alta_pol01_km.addKeyListener(this);
        this.altaPoliza01.txt_alta_pol01_motor.addKeyListener(this);
        this.altaPoliza01.txt_alta_pol01_nro_stros.addKeyListener(this);
        this.altaPoliza01.txt_alta_pol01_patente.addKeyListener(this);
        this.altaPoliza01.txt_alta_pol01_valor.addKeyListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == altaPoliza01.btn_alta_poliza_agregar_hijo) {
            AltaPolizaHijo altaPolizaHijo = new AltaPolizaHijo();
        } else if (e.getSource() == altaPoliza01.btn_alta_poliza01_continuar) {
            //Paso 1: verificar todos los datos ya cargados.
            if (validar()) {
                VehiculoDTO vehiculo = crearVehiculo();
                AltaPoliza02 altaPoliza02 = new AltaPoliza02(cliente, vehiculo);
            } else {
                JOptionPane.showMessageDialog(null, "Todos los campos son obligatorios.");
            }
        } else if (e.getSource() == altaPoliza01.btn_alta_poliza01_cancelar) {
            //Paso 1: preguntar si confirma. Si lo hace, entonces cerramos.
            int confirmacion = JOptionPane.showOptionDialog(null, "¿Seguro de cancelar los cambios?", "Confirmar cancelación",
                    JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
            if (confirmacion == 0) {
                this.altaPoliza01.dispose();
            }
        }
    }

    @Override
public void keyTyped(KeyEvent e) {
    if (e.getSource() == altaPoliza01.txt_alta_pol01_chasis || e.getSource() == altaPoliza01.txt_alta_pol01_patente) {
        validarCampoAlfanumerico((JTextField) e.getSource(), "[a-zA-Z0-9]+");
    } else if (e.getSource() == altaPoliza01.txt_alta_pol01_km) {
        validarCampoRegex(e, "^[0-9]*\\.?[0-9]*$");
    } else if (e.getSource() == altaPoliza01.txt_alta_pol01_motor) {
        validarCampoAlfanumerico((JTextField) e.getSource(), "[a-zA-Z0-9]+");
    }
}

private void validarCampoAlfanumerico(JTextField textField, String regex) {
    String input = textField.getText().trim();
    boolean isValid = Pattern.matches(regex, input);
    if (isValid) {
        textField.setForeground(Color.BLACK);
    } else {
        textField.setForeground(Color.RED);
    }
}

private void validarCampoRegex(KeyEvent e, String regex) {
    char c = e.getKeyChar();
    if (!Character.toString(c).matches(regex)) {
        e.consume();
    }
}

private void validarCampoNumero(KeyEvent e) {
    char c = e.getKeyChar();
    if (!Character.isDigit(c)) {
        e.consume();
    }
}

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    private boolean validar() {
        return !(altaPoliza01.txt_alta_pol01_chasis.getText().equals("")
                || altaPoliza01.txt_alta_pol01_km.equals("")
                || altaPoliza01.txt_alta_pol01_motor.equals("")
                || altaPoliza01.txt_alta_pol01_patente.equals(""));
    }

    private VehiculoDTO crearVehiculo() {
        VehiculoDTO vehiculo = new VehiculoDTO();
        vehiculo.setChasis(altaPoliza01.txt_alta_pol01_chasis.getText().toString().trim()); 
        vehiculo.setMotor(altaPoliza01.txt_alta_pol01_motor.getText().toString().trim());
        vehiculo.setKilometros_anio(altaPoliza01.txt_alta_pol01_km.getText().toString().trim());
        vehiculo.setPatente(altaPoliza01.txt_alta_pol01_patente.getText().toString().trim());
        vehiculo.setCon_alarma(altaPoliza01.chk_alta_pol01_alarma.isSelected());
        vehiculo.setCon_tuerca_antirrobo(altaPoliza01.chk_alta_pol01_tuerca.isSelected());
        vehiculo.setCon_rastreo(altaPoliza01.chk_alta_pol01_rastreo.isSelected());
        vehiculo.setEn_garage(altaPoliza01.chk_alta_pol01_cochera.isSelected());

        
        vehiculo.setAnio("2020");
        vehiculo.setPeso("750");
        vehiculo.setPotencia("183");
        vehiculo.setMarca("Toyota");
        vehiculo.setModelo("Ethios");

        return vehiculo;
    }
}
