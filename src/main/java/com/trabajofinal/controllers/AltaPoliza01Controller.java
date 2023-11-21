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
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.time.LocalDate;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;

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
        if (e.getSource() == altaPoliza01.txt_alta_pol01_chasis) {
            // Obtener el texto actual del JTextField
            String regex = "[a-zA-Z0-9]+";
            String input = altaPoliza01.txt_alta_pol01_chasis.getText().trim();
            // Verificar si el texto ingresado coincide con la expresión regular
            boolean isValid = Pattern.matches(regex, input);
            // Cambiar el color del JTextField dependiendo de si es válido o no
            if (isValid) {
                altaPoliza01.txt_alta_pol01_chasis.setForeground(java.awt.Color.BLACK);
            } else {
                altaPoliza01.txt_alta_pol01_chasis.setForeground(java.awt.Color.RED);
            }
        } else if (e.getSource() == altaPoliza01.txt_alta_pol01_patente) {
            // Obtener el texto actual del JTextField
            String regex = "[a-zA-Z0-9]+";
            String input = altaPoliza01.txt_alta_pol01_patente.getText().trim();
            boolean isValid = Pattern.matches(regex, input);
            if (isValid) {
                altaPoliza01.txt_alta_pol01_patente.setForeground(java.awt.Color.BLACK);
            } else {
                altaPoliza01.txt_alta_pol01_patente.setForeground(java.awt.Color.RED);
            }
        } else if (e.getSource() == altaPoliza01.txt_alta_pol01_km) {
            // Este método se llama cada vez que el usuario ingresa una tecla en el JTextField
            String regex = "^[0-9]*\\.?[0-9]*$";

            // Obtener la tecla ingresada por el usuario
            char c = e.getKeyChar();
            // Verificar si la tecla ingresada coincide con la expresión regular
            if (!Character.toString(c).matches(regex)) {
                // Si la tecla no coincide, se consume el evento, evitando que se agregue al JTextField
                e.consume();
            }
        } else if (e.getSource() == altaPoliza01.txt_alta_pol01_motor) {
            // Este método se llama cada vez que el usuario ingresa una tecla en el JTextField
            String regex = "[a-zA-Z0-9]+";
            String input = altaPoliza01.txt_alta_pol01_motor.getText().trim();
            boolean isValid = Pattern.matches(regex, input);
            if (isValid) {
                altaPoliza01.txt_alta_pol01_motor.setForeground(java.awt.Color.BLACK);

            } else {
                altaPoliza01.txt_alta_pol01_motor.setForeground(java.awt.Color.RED);
            }
        } else if (e.getSource() == altaPoliza01.txt_alta_pol01_valor) {
            // Este método se llama cada vez que el usuario ingresa una tecla en el JTextField
            String regex = "^-?\\d*\\.?\\d*$";
            // Obtener la tecla ingresada por el usuario
            char c = e.getKeyChar();
            // Verificar si la tecla ingresada coincide con la expresión regular
            if (!Character.toString(c).matches(regex)) {
                // Si la tecla no coincide, se consume el evento, evitando que se agregue al JTextField
                e.consume();
            }
        } else if (e.getSource() == altaPoliza01.txt_alta_pol01_nro_stros) {
            // Este método se llama cada vez que el usuario ingresa una tecla en el JTextField
            String regex = "\\d";
            // Obtener la tecla ingresada por el usuario
            char c = e.getKeyChar();
            // Verificar si la tecla ingresada coincide con la expresión regular
            if (!Character.toString(c).matches(regex)) {
                // Si la tecla no coincide, se consume el evento, evitando que se agregue al JTextField
                e.consume();
            }
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
                || altaPoliza01.txt_alta_pol01_nro_stros.equals("")
                || altaPoliza01.txt_alta_pol01_patente.equals("")
                || altaPoliza01.txt_alta_pol01_valor.equals(""));
    }

    private VehiculoDTO crearVehiculo() {
        VehiculoDTO vehiculo = new VehiculoDTO();
        TipoVehiculo tipo = new TipoVehiculo();
        Modelo modelo = new Modelo();
        FactoresModelo factoresModelo = new FactoresModelo();
        FactoresVehiculo factoresVehiculo = new FactoresVehiculo();
        Marca marca = new Marca();

        //Setear valores a factoresModelo
        factoresModelo.setFecha_fin_vigencia(LocalDate.MIN);
        factoresModelo.setFecha_inicio_vigencia(LocalDate.EPOCH);
        //factores.setSuma_asegurada(Double.MAX_VALUE);
        factoresModelo.setProbabilidad_robo(12.56);

        //Setear valores a factoresVehiculo
        factoresVehiculo.setFecha_fin_vigencia(LocalDate.MIN);
        factoresVehiculo.setFecha_inicio_vigencia(LocalDate.EPOCH);
        factoresVehiculo.setSuma_asegurada(Double.parseDouble(altaPoliza01.txt_alta_pol01_valor.getText().trim()));

        //Setear valores a marca
        marca.setNombre("Toyota");

        //Setear valores a modelo
        modelo.setNombre("Ethios");
        modelo.setFactor_actual(factoresModelo);
        modelo.setMarca(marca);

        //Setear valores a tipo de vehículo
        tipo.setAnio(2020);
        tipo.setPeso(850.0);
        tipo.setPotencia(183.00);
        tipo.setVelocidad(177.7);
        tipo.setModelo_vehiculo(modelo);
        tipo.setFactores_actuales(factoresVehiculo);
        factoresModelo.setModelo(modelo);

        vehiculo.setChasis(altaPoliza01.txt_alta_pol01_chasis.getText().toString().trim());
        vehiculo.setMotor(altaPoliza01.txt_alta_pol01_motor.getText().toString().trim());
        vehiculo.setKilometros_anio(Integer.parseInt(altaPoliza01.txt_alta_pol01_km.getText().trim()));
        vehiculo.setPatente(altaPoliza01.txt_alta_pol01_patente.getText().toString().trim());
        vehiculo.setTipo_vehiculo(tipo);
        vehiculo.setCon_alarma(altaPoliza01.chk_alta_pol01_alarma.isSelected());
        vehiculo.setCon_tuerca_antirrobo(altaPoliza01.chk_alta_pol01_tuerca.isSelected());
        vehiculo.setCon_rastreo(altaPoliza01.chk_alta_pol01_rastreo.isSelected());
        vehiculo.setEn_garage(altaPoliza01.chk_alta_pol01_cochera.isSelected());

        return vehiculo;
    }

}