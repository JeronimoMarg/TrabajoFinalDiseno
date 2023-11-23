package com.trabajofinal.controllers;

import com.trabajofinal.dto.ClienteDTO;
import com.trabajofinal.dto.VehiculoDTO;
import com.trabajofinal.gui.AltaPoliza01;
import com.trabajofinal.gui.AltaPoliza02;
import com.trabajofinal.gui.AltaPolizaHijo;
import dinamicComboBox.DynamicCombobox;
import dinamicComboBox.DynamicCombobox2;
import com.trabajofinal.models.EstadoCivil;
import com.trabajofinal.models.FactoresVehiculo;
import com.trabajofinal.models.Hijo;
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
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Pattern;

import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class AltaPoliza01Controller implements ActionListener, KeyListener, MouseListener {

    private AltaPoliza01 altaPoliza01;
    private ClienteDTO cliente;
    private Object[] options = {"Sí", "No"};
    DefaultTableModel tabla = new DefaultTableModel();
    private String peso;
    private String potencia;
    

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
    private TipoVehiculo tipo5;
    private TipoVehiculo tipo6;
    private FactoresVehiculo fact1 = new FactoresVehiculo();
    private FactoresVehiculo fact2= new FactoresVehiculo();
    private FactoresVehiculo fact3= new FactoresVehiculo();
    private FactoresVehiculo fact4= new FactoresVehiculo();
    private FactoresVehiculo fact5= new FactoresVehiculo();
    private FactoresVehiculo fact6= new FactoresVehiculo();
    private Hijo hijo1 = new Hijo();
    private Hijo hijo2 = new Hijo();

    private List<Provincia> provincias = new ArrayList<>();
    private List<Localidad> localidades = new ArrayList<>();
    private Set<Marca> marcas = new HashSet<>();
    private Set<Modelo> modelos = new HashSet<>();
    private List<TipoVehiculo> tipoVehiculos = new ArrayList<>();
    private List<FactoresVehiculo> factoresVehiculos = new ArrayList<>();
    private List<Hijo> hijos = new ArrayList<>();

    public AltaPoliza01Controller() {
        
    }

    public AltaPoliza01Controller(AltaPoliza01 altaPoliza01, ClienteDTO cliente) {
        this.altaPoliza01 = altaPoliza01;
        this.cliente = cliente;

        // Inicializo los comboBox independientes
        crear();
        inicializarCmbProvincias();
        inicializarCmbMarcas();
        listarHijos();

        // Pongo a la escucha los botones de la interface
        this.altaPoliza01.btn_alta_poliza_agregar_hijo.addActionListener(this);
        this.altaPoliza01.btn_alta_poliza01_continuar.addActionListener(this);
        this.altaPoliza01.btn_alta_poliza01_cancelar.addActionListener(this);
        this.altaPoliza01.cmb_alta_pol01_prov.addActionListener(this);
        this.altaPoliza01.cmb_alta_pol01_marca.addActionListener(this);
        this.altaPoliza01.cmb_alta_pol01_modelo.addActionListener(this);
        this.altaPoliza01.cmb_alta_pol01_anio.addActionListener(this);

        //Tabla de hijos en escucha
        this.altaPoliza01.table_alta_pol01_hijos.addMouseListener(this);

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
            DynamicCombobox selectedModelo = (DynamicCombobox) altaPoliza01.cmb_alta_pol01_modelo.getSelectedItem();
            if (selectedModelo != null) {
                cargarAnyoVehiculos(selectedModelo.getId());
            }
        } else if (e.getSource() == altaPoliza01.cmb_alta_pol01_anio) {
            DynamicCombobox2 selectedAnyo = (DynamicCombobox2) altaPoliza01.cmb_alta_pol01_anio.getSelectedItem();
            altaPoliza01.txt_alta_pol01_valor.setText("");
            if (selectedAnyo != null) {
                String anyo = selectedAnyo.getValor().toString();
                altaPoliza01.txt_alta_pol01_valor.setText(anyo);
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
                || altaPoliza01.txt_alta_pol01_patente.equals("")
                || altaPoliza01.cmb_alta_pol01_prov.getSelectedItem() == null
                || altaPoliza01.cmb_alta_pol01_local.getSelectedItem() == null
                || altaPoliza01.cmb_alta_pol01_marca.getSelectedItem() == null
                || altaPoliza01.cmb_alta_pol01_modelo.getSelectedItem() == null
                || altaPoliza01.cmb_alta_pol01_anio.getSelectedItem() == null);
    }

    // Métodos mock que usamos hasta que tengamos la persistencia implementada
    private void inicializarCmbProvincias() {
        // Iterar sobre la lista de provincias y agregar nombres al JComboBox
        for (Provincia provincia : provincias) {
            DynamicCombobox comboBoxItem = new DynamicCombobox(provincia.getId(), provincia.getNombre());
            altaPoliza01.cmb_alta_pol01_prov.addItem(comboBoxItem);
        }
        altaPoliza01.cmb_alta_pol01_prov.setSelectedIndex(0);
    }

    private void inicializarCmbMarcas() {
        altaPoliza01.cmb_alta_pol01_marca.removeAllItems();
        for (Marca marca : marcas) {
            DynamicCombobox comboBoxItem = new DynamicCombobox(marca.getId(), marca.getNombre());
            altaPoliza01.cmb_alta_pol01_marca.addItem(comboBoxItem);
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
        vehiculo.setAnio(altaPoliza01.cmb_alta_pol01_anio.getSelectedItem().toString());
        vehiculo.setMarca(altaPoliza01.cmb_alta_pol01_marca.getSelectedItem().toString());
        vehiculo.setModelo(altaPoliza01.cmb_alta_pol01_modelo.getSelectedItem().toString());
        vehiculo.setPeso(peso);
        vehiculo.setPotencia(potencia);

        return vehiculo;
    }
    
    private void cargarAnyoVehiculos(int id) {
        altaPoliza01.cmb_alta_pol01_anio.removeAllItems();
        for (TipoVehiculo tipoV : tipoVehiculos) {
            if (tipoV.getModelo_vehiculo().getId() == id) {
                DynamicCombobox2 comboBoxItem = new DynamicCombobox2(tipoV.getFactores_actuales().getSuma_asegurada(), tipoV.getAnio());
                altaPoliza01.cmb_alta_pol01_anio.addItem(comboBoxItem);
                //Acá asigno los valores de peso y potencia, en base a los valores que correspondan al modelo.
                peso = tipoV.getPeso().toString();
                potencia = tipoV.getPotencia().toString();

            }
        }
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

    private TipoVehiculo nuevoTipo(double peso, double potencia, double velocidad, int anio, Modelo modelo, FactoresVehiculo fac) {
        TipoVehiculo vehiculo = new TipoVehiculo();
        vehiculo.setAnio(anio);
        vehiculo.setPeso(peso);
        vehiculo.setPotencia(potencia);
        vehiculo.setVelocidad(velocidad);
        vehiculo.setModelo_vehiculo(modelo);
        vehiculo.setFactores_actuales(fac);

        return vehiculo;
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
    
    private void cargarModelos(int id) {
        altaPoliza01.cmb_alta_pol01_modelo.removeAllItems();
        for (Modelo modelo : modelos) {
            if (modelo.getMarca().getId() == id) {
                DynamicCombobox comboBoxItem = new DynamicCombobox(modelo.getId(), modelo.getNombre());
                altaPoliza01.cmb_alta_pol01_modelo.addItem(comboBoxItem);

            }
        }
    }
        
    public void listarHijos() {
        tabla = (DefaultTableModel) altaPoliza01.table_alta_pol01_hijos.getModel();
        Object[] row = new Object[3];

        for (int i = 0; i < hijos.size(); i++) {
            // Fecha de Nacimiento
            LocalDate fechaNacimiento = hijos.get(i).getFecha_nacimiento();
            String fechaFormateada = DateTimeFormatter.ofPattern("dd/MM/yyyy").format(fechaNacimiento);
            row[0] = fechaFormateada;
            boolean sexo = hijos.get(i).getSexo();
            String sexoTexto = sexo ? "MASCULINO" : "FEMENINO";
            row[1] = sexoTexto;
            row[2] = hijos.get(i).getEstado_civil();
            tabla.addRow(row);
        }
        altaPoliza01.table_alta_pol01_hijos.setModel(tabla);
    }

    //Limpiar la tabla
    public void limpiarTabla() {
        for (int i = 0; i < tabla.getRowCount(); i++) {
            tabla.removeRow(i);
            i = i - 1;
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource() == altaPoliza01.table_alta_pol01_hijos) {
            int row = altaPoliza01.table_alta_pol01_hijos.rowAtPoint(e.getPoint());
            JOptionPane.showMessageDialog(null, "Ha seleccionado la fila: " + row);
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
        fact1.setSuma_asegurada(2950000.0);
        fact1.setVehiculo(tipo1);
        fact2.setSuma_asegurada(2500000.0);
        fact2.setVehiculo(tipo2);
        fact3.setSuma_asegurada(2750000.0);
        fact3.setVehiculo(tipo3);
        fact4.setSuma_asegurada(2990000.0);
        fact4.setVehiculo(tipo4);
        fact5.setSuma_asegurada(2599900.0);
        fact5.setVehiculo(tipo5);
        fact6.setSuma_asegurada(3900000.0);
        fact6.setVehiculo(tipo6);
        modelo1 = nuevoModelo(1, "Ethios", marca1);
        modelo2 = nuevoModelo(2, "EcoSport", marca2);
        modelo3 = nuevoModelo(3, "Oroch", marca3);
        modelo4 = nuevoModelo(4, "Hilux", marca1);
        tipo1 = nuevoTipo(1000, 168, 179, 2020, modelo1, fact1);
        tipo5 = nuevoTipo(1000, 168, 179, 2021, modelo1, fact2);
        tipo6 = nuevoTipo(1000, 168, 179, 2022, modelo1, fact3);
        tipo2 = nuevoTipo(800.00, 122, 155, 2021, modelo2, fact4);
        tipo3 = nuevoTipo(1255, 180, 175.5, 2023, modelo3, fact5);
        tipo4 = nuevoTipo(956, 150, 190, 2022, modelo4, fact6);
        
        tipoVehiculos.add(tipo1);
        tipoVehiculos.add(tipo2);
        tipoVehiculos.add(tipo3);
        tipoVehiculos.add(tipo4);
        tipoVehiculos.add(tipo5);
        tipoVehiculos.add(tipo6);
        
        modelos.add(modelo1);
        modelos.add(modelo2);
        modelos.add(modelo3);
        modelos.add(modelo4);
        modelos.add(modelo1);
        modelos.add(modelo2);
        modelos.add(modelo3);
        modelos.add(modelo4);
        marcas.add(marca1);
        marcas.add(marca2);
        marcas.add(marca3);
        provincias.add(prov1);
        provincias.add(prov2);
        hijo1.setEstado_civil(EstadoCivil.SOLTERO);
        hijo1.setFecha_nacimiento(LocalDate.now().minusYears(5));
        hijo1.setSexo(Boolean.TRUE);
        hijo2.setEstado_civil(EstadoCivil.CASADO);
        hijo2.setFecha_nacimiento(LocalDate.now().minusYears(15));
        hijo2.setSexo(Boolean.FALSE);
        hijos.add(hijo1);
        hijos.add(hijo2);
    }
}
