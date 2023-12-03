package com.trabajofinal.controllers;

import com.trabajofinal.dto.ClienteDTO;
import com.trabajofinal.dto.HijoDTO;
import com.trabajofinal.dto.VehiculoDTO;
import com.trabajofinal.dto.PolizaDTO;
import com.trabajofinal.gui.AltaPoliza01;
import com.trabajofinal.gui.AltaPoliza02;
import com.trabajofinal.gui.AltaPolizaHijo;
import com.trabajofinal.gui.ProgressWindow;
import com.trabajofinal.utils.DynamicCombobox;
import com.trabajofinal.models.FactoresVehiculo;
import com.trabajofinal.models.Localidad;
import com.trabajofinal.models.Marca;
import com.trabajofinal.models.Modelo;
import com.trabajofinal.models.Provincia;
import com.trabajofinal.models.TipoVehiculo;
import com.trabajofinal.gestores.GestorLocalidad;
import com.trabajofinal.gestores.GestorMarca;
import com.trabajofinal.gestores.GestorModelo;
import com.trabajofinal.gestores.GestorProvincia;
import com.trabajofinal.gestores.GestorSistemaSiniestros;
import com.trabajofinal.gestores.GestorVehiculos;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
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
    private static List<HijoDTO> hijoDTO = new ArrayList<>();

    // Variables que vamos a usar ahora para probar la lógica
    private List<Provincia> provincias = new ArrayList<>();
    private List<Localidad> localidades = new ArrayList<>();
    private List<Marca> marcas = new ArrayList<>();
    private List<Modelo> modelos = new ArrayList<>();
    private List<TipoVehiculo> tipoVehiculos = new ArrayList<>();
    private List<FactoresVehiculo> factoresVehiculos = new ArrayList<>();

    public AltaPoliza01Controller() {

    }

    public AltaPoliza01Controller(AltaPoliza01 altaPoliza01, ClienteDTO cliente) {
        this.altaPoliza01 = altaPoliza01;
        this.cliente = cliente;

        ProgressWindow progreso = new ProgressWindow();
        // Hilo para la carga de datos
        Thread hiloDatos = new Thread() {
            @Override
            public void run() {
                // Aquí se ejecutan las operaciones de carga de datos
                cargarDatos();
                inicializarCmbProvincias();
                inicializarCmbMarcas();
                listarHijos();
                progreso.dispose();
            }
        };

        // Hilo para la barra de progreso
        Thread hiloProgreso = new Thread() {
            @Override
            public void run() {
                int progresoActual = 1;
                while (true) {
                    progreso.jpb_progress.setValue(progresoActual);
                    progresoActual = (progresoActual + 1) % 100; // Reinicia el contador al llegar a 100

                    try {
                        Thread.sleep(50); // Simula un retardo de tiempo durante la actualización del progreso
                    } catch (InterruptedException e) {
                    }
                }
            }
        };

        // Iniciar ambos hilos
        hiloDatos.start();
        hiloProgreso.start();

        // Pongo a la escucha los botones de la interface
        this.altaPoliza01.btn_alta_poliza_agregar_hijo.addActionListener(this);
        this.altaPoliza01.btn_alta_poliza01_continuar.addActionListener(this);
        this.altaPoliza01.btn_alta_poliza01_cancelar.addActionListener(this);
        this.altaPoliza01.cmb_alta_pol01_prov.addActionListener(this);
        this.altaPoliza01.cmb_alta_pol01_marca.addActionListener(this);
        this.altaPoliza01.cmb_alta_pol01_modelo.addActionListener(this);
        this.altaPoliza01.cmb_alta_pol01_anio.addActionListener(this);

        // Tabla de hijos en escucha
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
            altaPolizaHijo.addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosed(WindowEvent e) {
                    limpiarTabla();
                    listarHijos();
                }
            });

        } else if (e.getSource() == altaPoliza01.btn_alta_poliza01_continuar) {
            // Paso 1: verificar todos los datos ya cargados.
            if (validar()) {
                VehiculoDTO vehiculoDTO = crearVehiculo();
                PolizaDTO polizaDTO = crearPoliza();
                altaPoliza01.dispose();
                AltaPoliza02 altaPoliza02 = new AltaPoliza02(cliente, vehiculoDTO, hijoDTO, polizaDTO);

            } else {
                JOptionPane.showMessageDialog(null, "Todos los campos deben contener información correcta. Verifique campos vacíos y/o en rojo.");
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
            // Filtrar los años de los módelos en la tabla
            DynamicCombobox selectedModelo = (DynamicCombobox) altaPoliza01.cmb_alta_pol01_modelo.getSelectedItem();
            if (selectedModelo != null) {
                cargarAnyoVehiculos(selectedModelo.getId());
            }
        } else if (e.getSource() == altaPoliza01.cmb_alta_pol01_anio) {
            DynamicCombobox selectedAnyo = (DynamicCombobox) altaPoliza01.cmb_alta_pol01_anio.getSelectedItem();
            if (selectedAnyo != null) {
                cargarValor(selectedAnyo.getId());
            }
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
        if (e.getSource() == altaPoliza01.txt_alta_pol01_chasis
                || e.getSource() == altaPoliza01.txt_alta_pol01_patente || e.getSource() == altaPoliza01.txt_alta_pol01_motor) {
            validarCampoAlfanumerico((JTextField) e.getSource(), "[a-zA-Z0-9]+");
        } else if (e.getSource() == altaPoliza01.txt_alta_pol01_km) {
            validarCampoRegex(e, "^[0-9]+$");
        } 
    }

    private boolean validarCampoAlfanumerico(JTextField textField, String regex) {
    String input = textField.getText().trim();
    boolean isValid = input.isEmpty() || Pattern.matches(regex, input);
    if (isValid) {
        textField.setForeground(Color.BLACK);
    } else {
        textField.setForeground(Color.RED);
    }
    return isValid;
}


   private void validarCampoRegex(KeyEvent e, String regex) {
    char c = e.getKeyChar();
    if (!Character.toString(c).matches(regex)) {
        // Aquí no haces nada si el carácter no coincide con la expresión regular
    }
}


    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    private boolean validar() {    
    boolean camposNoNulos = !(altaPoliza01.txt_alta_pol01_chasis.getText().isEmpty()
            || altaPoliza01.txt_alta_pol01_km.getText().isEmpty()
            || altaPoliza01.txt_alta_pol01_motor.getText().isEmpty()
            || altaPoliza01.txt_alta_pol01_patente.getText().isEmpty()
            || altaPoliza01.cmb_alta_pol01_prov.getSelectedItem() == null
            || altaPoliza01.cmb_alta_pol01_local.getSelectedItem() == null
            || altaPoliza01.cmb_alta_pol01_marca.getSelectedItem() == null
            || altaPoliza01.cmb_alta_pol01_modelo.getSelectedItem() == null
            || altaPoliza01.cmb_alta_pol01_anio.getSelectedItem() == null);

    boolean camposValidos = validarCampoAlfanumerico(altaPoliza01.txt_alta_pol01_chasis, "[a-zA-Z0-9]+")
            && validarCampoAlfanumerico(altaPoliza01.txt_alta_pol01_patente, "[a-zA-Z0-9]+")
            && validarCampoAlfanumerico(altaPoliza01.txt_alta_pol01_motor, "[a-zA-Z0-9]+");

    return camposNoNulos && camposValidos;
}

    

    private void inicializarCmbProvincias() {
        // Iterar sobre la lista de provincias y agregar nombres al JComboBox
        for (Provincia provincia : provincias) {
            DynamicCombobox comboBoxItem = new DynamicCombobox(provincia.getId(), provincia.getNombre());
            altaPoliza01.cmb_alta_pol01_prov.addItem(comboBoxItem);
        }
        // Cómo aquí ya tengo los datos del cliente, voy a traer la cantidad de
        // sniestros del ultimo año y lo voy a setear.
        altaPoliza01.txt_alta_pol01_nro_stros
                .setText(String.valueOf(GestorSistemaSiniestros.getInstance().obtenerSiniestros(cliente.getId())));
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
        vehiculo.setKilometros_anio(Integer.parseInt(altaPoliza01.txt_alta_pol01_km.getText().toString().trim()));
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
        vehiculo.setValor_estimado(altaPoliza01.txt_alta_pol01_valor.getText());

        int aux = ((DynamicCombobox) altaPoliza01.cmb_alta_pol01_anio.getSelectedItem()).getId();
        vehiculo.setId_tipo_vehiculo(aux);

        aux = ((DynamicCombobox) altaPoliza01.cmb_alta_pol01_modelo.getSelectedItem()).getId();
        vehiculo.setId_modelo(aux);

        return vehiculo;
    }

    private PolizaDTO crearPoliza() {

        PolizaDTO poliza = new PolizaDTO();
        poliza.setLocalidad(altaPoliza01.cmb_alta_pol01_local.getSelectedItem().toString().trim());

        int aux = ((DynamicCombobox) altaPoliza01.cmb_alta_pol01_local.getSelectedItem()).getId();

        poliza.setId_localidad(aux);

        return poliza;

    }

    private void cargarValor(int id_tipo) {
        altaPoliza01.txt_alta_pol01_valor.setText("");
        GestorVehiculos gestorVehiculos = GestorVehiculos.getInstance();
        TipoVehiculo tipo = gestorVehiculos.obtenerTipoVehiculoPorId(id_tipo);
        if (tipo != null) {
            altaPoliza01.txt_alta_pol01_valor.setText(tipo.getFactores_actuales().getSuma_asegurada().toString());
        }
    }

    private void cargarAnyoVehiculos(int id_modelo) {
        altaPoliza01.cmb_alta_pol01_anio.removeAllItems();
        GestorVehiculos gestorVehiculos = GestorVehiculos.getInstance();
        List<TipoVehiculo> tipoVehiculos = gestorVehiculos.obtenerTiposVehiculoPorModelo(id_modelo);

        for (TipoVehiculo tipoV : tipoVehiculos) {
            DynamicCombobox comboBoxItem = new DynamicCombobox(tipoV.getId(), tipoV.getAnio().toString());
            altaPoliza01.cmb_alta_pol01_anio.addItem(comboBoxItem);
            // Asignación de valores de peso y potencia basados en el modelo.
            peso = tipoV.getPeso().toString();
            potencia = tipoV.getPotencia().toString();
        }
    }

    private void cargarLocalidades(int id_prov) {
        altaPoliza01.cmb_alta_pol01_local.removeAllItems();
        GestorLocalidad gestorLocalidad = GestorLocalidad.getInstance();
        List<Localidad> localidades = gestorLocalidad.obtenerLocalidadesPorProvincia(id_prov);
        for (Localidad loc : localidades) {
            DynamicCombobox comboBoxItem = new DynamicCombobox(loc.getId(), loc.getNombre());
            altaPoliza01.cmb_alta_pol01_local.addItem(comboBoxItem);
        }
    }

    private void cargarModelos(int id_marca) {
        altaPoliza01.cmb_alta_pol01_modelo.removeAllItems();
        GestorModelo gestorModelo = GestorModelo.getInstance();
        List<Modelo> modelos = gestorModelo.obtenerModelosPorMarca(id_marca);
        for (Modelo modelo : modelos) {
            DynamicCombobox comboBoxItem = new DynamicCombobox(modelo.getId(), modelo.getNombre());
            altaPoliza01.cmb_alta_pol01_modelo.addItem(comboBoxItem);
        }
    }

    public void listarHijos() {
        tabla = (DefaultTableModel) altaPoliza01.table_alta_pol01_hijos.getModel();
        Object[] row = new Object[3];

        for (int i = 0; i < hijoDTO.size(); i++) {
            // Fecha de Nacimiento
            LocalDate fechaNacimiento = hijoDTO.get(i).getFecha_nacimiento();
            String fechaFormateada = DateTimeFormatter.ofPattern("dd/MM/yyyy").format(fechaNacimiento);
            row[0] = fechaFormateada;
            boolean sexo = hijoDTO.get(i).getSexo();
            String sexoTexto = sexo ? "MASCULINO" : "FEMENINO";
            row[1] = sexoTexto;
            row[2] = hijoDTO.get(i).getEstado_civil();
            tabla.addRow(row);
        }
        altaPoliza01.table_alta_pol01_hijos.setModel(tabla);
    }

    // Limpiar la tabla
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
            int confirmacion = JOptionPane.showOptionDialog(null, "¿Seguro de ELIMINAR  la fila?",
                    "Confirmar cancelación",
                    JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
            if (confirmacion == 0) {
                hijoDTO.remove(row);
                limpiarTabla();
                listarHijos();
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

    // Este método es static porque le van a setear los datos desde el
    // AltaPolizaHijoController.
    public static void addHijoDTO(HijoDTO dto) {
        hijoDTO.add(dto);
    }

    public void cargarDatos() {
        GestorMarca gestorMarca = GestorMarca.getInstance();
        GestorProvincia gestorProvincia = GestorProvincia.getInstance();

        provincias.addAll(gestorProvincia.obtenerTodasLasProvincias());
        marcas.addAll(gestorMarca.obtenerTodasLasMarcas());
    }

}
