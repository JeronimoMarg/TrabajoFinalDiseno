package com.trabajofinal.controllers;

import com.trabajofinal.dto.ClienteDTO;
import com.trabajofinal.dto.VehiculoDTO;
import com.trabajofinal.gui.AltaPoliza01;
import com.trabajofinal.gui.AltaPoliza02;
import com.trabajofinal.gui.AltaPolizaHijo;
import com.trabajofinal.models.DynamicCombobox;
import com.trabajofinal.models.Localidad;
import com.trabajofinal.models.Marca;
import com.trabajofinal.models.Modelo;
import com.trabajofinal.models.Pais;
import com.trabajofinal.models.Provincia;
import com.trabajofinal.models.TipoVehiculo;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class AltaPoliza01Controller implements ActionListener, KeyListener {

    private AltaPoliza01 altaPoliza01;
    private ClienteDTO cliente;
    private Object[] options = {"Sí", "No"};

    // Variables que vamos a usar ahora para probar la lógica
    private Provincia prov1;
    private Provincia prov2;
    private Localidad loc1;
    private Localidad loc2;
    private Localidad loc3;
    private Marca marca1;
    private Marca marca2;
    private Marca marca3;
    private Modelo modelo1;
    private Modelo modelo2;
    private Modelo modelo3;
    private Modelo modelo4;
    private TipoVehiculo tipo1;
    private TipoVehiculo tipo2;
    private TipoVehiculo tipo3;
    private TipoVehiculo tipo4;
        

    private List<Provincia> provincias = new ArrayList<>();
    private List<Localidad> localidades = new ArrayList<>();
    private List<Marca> marcas = new ArrayList<>();
    private List<Modelo> modelos = new ArrayList<>();
    private List<TipoVehiculo> tipoVehiculos = new ArrayList<>();
    

    public AltaPoliza01Controller() {
    }

    public AltaPoliza01Controller(AltaPoliza01 altaPoliza01, ClienteDTO cliente) {
        this.altaPoliza01 = altaPoliza01;
        this.cliente = cliente;

        // Inicializo los comboBox independinetes
        crear();
        inicializarCmbProvincias();
        inicializarCmbMarcas();
        iniciarlizarCmbModelos();

        // Pongo a la escucha los botones de la interface
        this.altaPoliza01.btn_alta_poliza_agregar_hijo.addActionListener(this);
        this.altaPoliza01.btn_alta_poliza01_continuar.addActionListener(this);
        this.altaPoliza01.btn_alta_poliza01_cancelar.addActionListener(this);
        this.altaPoliza01.cmb_alta_pol01_prov.addActionListener(this);
        this.altaPoliza01.cmb_alta_pol01_marca.addActionListener(this);

        // Campos de texto para validar
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
            // Paso 1: verificar todos los datos ya cargados.
            if (validar()) {
                VehiculoDTO vehiculo = crearVehiculo();
                AltaPoliza02 altaPoliza02 = new AltaPoliza02(cliente, vehiculo);
            } else {
                JOptionPane.showMessageDialog(null, "Todos los campos son obligatorios.");
            }
        } else if (e.getSource() == altaPoliza01.btn_alta_poliza01_cancelar) {
            // Paso 1: preguntar si confirma. Si lo hace, entonces cerramos.
            int confirmacion = JOptionPane.showOptionDialog(null, "¿Seguro de cancelar los cambios?",
                    "Confirmar cancelación",
                    JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
            if (confirmacion == 0) {
                this.altaPoliza01.dispose();
            }
        } else if (e.getSource() == altaPoliza01.cmb_alta_pol01_prov) {
            // Obtener la provincia seleccionada del JComboBox
            DynamicCombobox selectedProvincia = (DynamicCombobox) altaPoliza01.cmb_alta_pol01_prov.getSelectedItem();
            if (selectedProvincia != null) {
                cargarLocalidades(selectedProvincia.getId());
            }
        } else if (e.getSource() == altaPoliza01.cmb_alta_pol01_marca) {
            DynamicCombobox selectedMarca = (DynamicCombobox) altaPoliza01.cmb_alta_pol01_marca.getSelectedItem();
            if (selectedMarca != null) {
                cargarModelos(selectedMarca.getId());
            }
        } else if (e.getSource() == altaPoliza01.cmb_alta_pol01_modelo) {
            //Filtrar los años de los módelos en la tabla
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

    // Métodos mock que usamos hasta que tengamos la persistencia implementada
    private void inicializarCmbProvincias() {
        provincias.add(prov1);
        provincias.add(prov2);

        // Iterar sobre la lista de provincias y agregar nombres al JComboBox
        for (Provincia provincia : provincias) {
            DynamicCombobox comboBoxItem = new DynamicCombobox(provincia.getId(), provincia.getNombre());
            altaPoliza01.cmb_alta_pol01_prov.addItem(comboBoxItem);
            //System.out.println(comboBoxItem.getId() + " --- " +  comboBoxItem.getNombre() + " --- " + comboBoxItem.getClass());
        }
    }

    private void inicializarCmbMarcas() {
        marcas.add(marca1);
        marcas.add(marca2);
        marcas.add(marca3);

        for (Marca marca : marcas) {
            DynamicCombobox comboBoxItem = new DynamicCombobox(marca.getId(), marca.getNombre());
            altaPoliza01.cmb_alta_pol01_marca.addItem(comboBoxItem);
        }
    }

    private void iniciarlizarCmbModelos() {
        modelos.add(modelo1);
        modelos.add(modelo2);
        modelos.add(modelo3);
        modelos.add(modelo4);

        for (Modelo model : modelos) {
            DynamicCombobox comboBoxItem = new DynamicCombobox(model.getId(), model.getNombre());
            altaPoliza01.cmb_alta_pol01_modelo.addItem(comboBoxItem);
        }

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

    private Provincia nuevaProvincia(int id, String nombre) {
        Pais pais = new Pais();
        pais.setId(1);
        pais.setNombre("Argentina");
        Provincia prov = new Provincia();
        prov.setId(id);
        prov.setNombre(nombre);
        prov.setPais(pais);
        return prov;
    }

    private Localidad nuevaLocalidad(int id, String nombre, Provincia provincia) {
        // No tiene factores de riesgos asociados
        Localidad loc = new Localidad();
        loc.setId(id);
        loc.setNombre(nombre);
        loc.setProvincia(provincia);
        return loc;
    }

    private Marca nuevaMarca(int id, String nombre) {
        Marca marca = new Marca();
        marca.setId(id);
        marca.setNombre(nombre);
        return marca;
    }

    private Modelo nuevoModelo(int id, String nombre, Marca marca) {
        Modelo modelo = new Modelo();
        modelo.setId(id);
        modelo.setNombre(nombre);
        modelo.setMarca(marca);
        return modelo;
    }
    
    private TipoVehiculo nuevoTipo (double peso,double potencia, double velocidad, int anio) {
        TipoVehiculo vehiculo = new TipoVehiculo();
        vehiculo.setAnio(anio);
        vehiculo.setPeso(peso);
        vehiculo.setPotencia(potencia);
        vehiculo.setVelocidad(velocidad);
                
        return vehiculo;
    }

    private void crear() {
        prov1 = nuevaProvincia(1, "Santa Fe");
        prov2 = nuevaProvincia(2, "Entre Ríos");
        loc1 = nuevaLocalidad(1, "Recreo", prov1);
        loc2 = nuevaLocalidad(2, "Santa Fe de la Vera Cruz", prov1);
        loc3 = nuevaLocalidad(3, "Parana", prov2);
        localidades.add(loc1);
        localidades.add(loc2);
        localidades.add(loc3);
        marca1 = nuevaMarca(1, "Toyota");
        marca2 = nuevaMarca(2, "Ford");
        marca3 = nuevaMarca(3, "Renault");
        modelo1 = nuevoModelo(1, "Ethios", marca1);
        modelo2 = nuevoModelo(2, "EcoSport", marca2);
        modelo3 = nuevoModelo(3, "Oroch", marca3);
        modelo4 = nuevoModelo(4, "Hilux", marca1);
        tipo1 = nuevoTipo(1000, 168, 179, 2020);
        tipo2 = nuevoTipo(800.00, 122, 155, 2021);
        tipo3 = nuevoTipo(1255, 180, 175.5, 2015);
        tipo4 = nuevoTipo(956, 150, 190, 2022);
    }
    

    private void cargarLocalidades(int id_prov) {
        altaPoliza01.cmb_alta_pol01_local.removeAllItems();
        for (Localidad loc : localidades) {
            if (loc.getProvincia().getId() == id_prov) {
                DynamicCombobox comboBoxItem = new DynamicCombobox(loc.getId(), loc.getNombre());
                altaPoliza01.cmb_alta_pol01_local.addItem(comboBoxItem);
            }
        }
    }

    private void cargarMarcas(int id) {
        altaPoliza01.cmb_alta_pol01_modelo.removeAllItems();
        for (Marca marca : marcas) {
            if (marca.getId() == id) {
                DynamicCombobox comboBoxItem = new DynamicCombobox(marca.getId(), marca.getNombre());
                altaPoliza01.cmb_alta_pol01_modelo.addItem(comboBoxItem.getNombre());
            }
        }
    }

    private void cargarModelos(int id) {
        altaPoliza01.cmb_alta_pol01_modelo.removeAllItems();
        for (Modelo modelo : modelos) {
            if (modelo.getMarca().getId() == id) {
                DynamicCombobox comboBoxItem = new DynamicCombobox(modelo.getId(), modelo.getNombre());
                altaPoliza01.cmb_alta_pol01_modelo.addItem(comboBoxItem.getNombre());
            }
        }
    }
    
    private void cargarTipoVehiculo(int id) {
        altaPoliza01.cmb_alta_pol01_anio.removeAllItems();
        
    }
}
