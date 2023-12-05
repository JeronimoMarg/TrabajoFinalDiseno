
package com.trabajofinal.gui;

import com.trabajofinal.controllers.AltaPoliza01Controller;
import com.trabajofinal.dto.ClienteDTO;
import java.awt.image.BufferedImage;

/**
 *
 * @author Diego
 */
public class AltaPoliza01 extends javax.swing.JFrame {

    ClienteDTO cliente;
    public AltaPoliza01(){}
    
    public AltaPoliza01(ClienteDTO cliente) {
    super("Alta de Póliza");

    // Establece un ícono transparente para evitar que se muestre el ícono de Java
    BufferedImage transparentImage = new BufferedImage(1, 1, BufferedImage.TYPE_INT_ARGB);
    setIconImage(transparentImage);

    initComponents();
    setSize(900, 600);
    setResizable(false);
    setLocationRelativeTo(null);
    setVisible(true);
    
    AltaPoliza01Controller altaPoliza01Controller = new AltaPoliza01Controller(this, cliente);
}


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        cmb_alta_pol01_prov = new javax.swing.JComboBox<>();
        cmb_alta_pol01_local = new javax.swing.JComboBox<>();
        cmb_alta_pol01_marca = new javax.swing.JComboBox<>();
        cmb_alta_pol01_modelo = new javax.swing.JComboBox<>();
        cmb_alta_pol01_anio = new javax.swing.JComboBox<>();
        txt_alta_pol01_valor = new javax.swing.JTextField();
        txt_alta_pol01_motor = new javax.swing.JTextField();
        txt_alta_pol01_chasis = new javax.swing.JTextField();
        txt_alta_pol01_patente = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        chk_alta_pol01_alarma = new javax.swing.JCheckBox();
        chk_alta_pol01_cochera = new javax.swing.JCheckBox();
        btn_alta_poliza_agregar_hijo = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        table_alta_pol01_hijos = new javax.swing.JTable();
        btn_alta_poliza01_continuar = new javax.swing.JButton();
        btn_alta_poliza01_cancelar = new javax.swing.JButton();
        txt_alta_pol01_nro_stros = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        chk_alta_pol01_rastreo = new javax.swing.JCheckBox();
        jLabel4 = new javax.swing.JLabel();
        txt_alta_pol01_km = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        chk_alta_pol01_tuerca = new javax.swing.JCheckBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel2.setText("Ingrese los datos de la póliza para el cliente:");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 16, 550, 50));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 800, 70));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/El-asegurado.png"))); // NOI18N
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 0, 100, 70));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 0, 140, 100));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        cmb_alta_pol01_prov.setBackground(new java.awt.Color(220, 220, 220));
        cmb_alta_pol01_prov.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        cmb_alta_pol01_prov.setSelectedItem("Provincia");
        cmb_alta_pol01_prov.setToolTipText("Provincia");
        cmb_alta_pol01_prov.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmb_alta_pol01_provActionPerformed(evt);
            }
        });
        jPanel3.add(cmb_alta_pol01_prov, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 30, 140, 30));

        cmb_alta_pol01_local.setBackground(new java.awt.Color(220, 220, 220));
        cmb_alta_pol01_local.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jPanel3.add(cmb_alta_pol01_local, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 30, 140, 30));

        cmb_alta_pol01_marca.setBackground(new java.awt.Color(220, 220, 220));
        cmb_alta_pol01_marca.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jPanel3.add(cmb_alta_pol01_marca, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 90, 310, 30));

        cmb_alta_pol01_modelo.setBackground(new java.awt.Color(220, 220, 220));
        cmb_alta_pol01_modelo.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        cmb_alta_pol01_modelo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmb_alta_pol01_modeloActionPerformed(evt);
            }
        });
        jPanel3.add(cmb_alta_pol01_modelo, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 150, 310, 30));

        cmb_alta_pol01_anio.setBackground(new java.awt.Color(220, 220, 220));
        cmb_alta_pol01_anio.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        cmb_alta_pol01_anio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmb_alta_pol01_anioActionPerformed(evt);
            }
        });
        jPanel3.add(cmb_alta_pol01_anio, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 210, 310, 30));

        txt_alta_pol01_valor.setEditable(false);
        txt_alta_pol01_valor.setBackground(new java.awt.Color(220, 220, 220));
        txt_alta_pol01_valor.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txt_alta_pol01_valor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_alta_pol01_valorActionPerformed(evt);
            }
        });
        jPanel3.add(txt_alta_pol01_valor, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 270, 310, 30));

        txt_alta_pol01_motor.setBackground(new java.awt.Color(220, 220, 220));
        txt_alta_pol01_motor.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txt_alta_pol01_motor.setToolTipText("Introduzca los 10 caracteres alfanuméricos");
        txt_alta_pol01_motor.setFocusTraversalPolicyProvider(true);
        txt_alta_pol01_motor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_alta_pol01_motorActionPerformed(evt);
            }
        });
        jPanel3.add(txt_alta_pol01_motor, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 330, 310, 30));

        txt_alta_pol01_chasis.setBackground(new java.awt.Color(220, 220, 220));
        txt_alta_pol01_chasis.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txt_alta_pol01_chasis.setToolTipText("Introduzca los 17 caracteres alfanuméricos");
        txt_alta_pol01_chasis.setFocusTraversalPolicyProvider(true);
        jPanel3.add(txt_alta_pol01_chasis, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 390, 310, 30));

        txt_alta_pol01_patente.setBackground(new java.awt.Color(220, 220, 220));
        txt_alta_pol01_patente.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txt_alta_pol01_patente.setToolTipText("Ingrese un formato de patente válido para la República Argentina");
        txt_alta_pol01_patente.setFocusTraversalPolicyProvider(true);
        txt_alta_pol01_patente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_alta_pol01_patenteActionPerformed(evt);
            }
        });
        jPanel3.add(txt_alta_pol01_patente, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 450, 310, 30));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 51, 51));
        jLabel5.setText("*");
        jPanel3.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 30, -1, -1));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 51, 51));
        jLabel6.setText("*");
        jPanel3.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 90, -1, -1));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 51, 51));
        jLabel7.setText("*");
        jPanel3.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 150, -1, -1));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 51, 51));
        jLabel8.setText("*");
        jPanel3.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 210, -1, -1));

        jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 51, 51));
        jLabel9.setText("*");
        jPanel3.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 270, -1, -1));

        jLabel12.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 51, 51));
        jLabel12.setText("*");
        jPanel3.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 390, -1, -1));

        jLabel13.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 51, 51));
        jLabel13.setText("*");
        jPanel3.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 450, -1, -1));

        jLabel15.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel15.setText("N° de patente");
        jPanel3.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 430, 90, -1));

        jLabel16.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel16.setText("Provincia");
        jPanel3.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 10, -1, -1));

        jLabel17.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel17.setText("Marca");
        jPanel3.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 70, -1, -1));

        jLabel18.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel18.setText("Modelo");
        jPanel3.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 130, -1, -1));

        jLabel19.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel19.setText("Año");
        jPanel3.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 190, -1, -1));

        jLabel20.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel20.setText("Valor estimado");
        jPanel3.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 250, -1, -1));

        jLabel21.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel21.setText("Motor");
        jPanel3.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 310, -1, -1));

        jLabel22.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel22.setText("N° de chasis");
        jPanel3.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 370, 90, -1));

        jLabel23.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel23.setText("Localidad");
        jPanel3.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 10, -1, -1));

        jLabel25.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(255, 51, 51));
        jLabel25.setText("*");
        jPanel3.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 330, -1, -1));

        jLabel10.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 51, 51));
        jLabel10.setText("*");
        jPanel3.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 30, -1, -1));

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 70, 450, 530));

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        chk_alta_pol01_alarma.setBackground(new java.awt.Color(255, 255, 255));
        chk_alta_pol01_alarma.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        chk_alta_pol01_alarma.setText("¿Alarma?");
        chk_alta_pol01_alarma.setFocusTraversalPolicyProvider(true);
        chk_alta_pol01_alarma.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chk_alta_pol01_alarmaActionPerformed(evt);
            }
        });
        jPanel4.add(chk_alta_pol01_alarma, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 160, 310, 30));

        chk_alta_pol01_cochera.setBackground(new java.awt.Color(255, 255, 255));
        chk_alta_pol01_cochera.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        chk_alta_pol01_cochera.setText("¿Cochera?");
        chk_alta_pol01_cochera.setFocusTraversalPolicyProvider(true);
        chk_alta_pol01_cochera.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chk_alta_pol01_cocheraActionPerformed(evt);
            }
        });
        jPanel4.add(chk_alta_pol01_cochera, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 250, 310, 30));

        btn_alta_poliza_agregar_hijo.setBackground(new java.awt.Color(52, 162, 224));
        btn_alta_poliza_agregar_hijo.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btn_alta_poliza_agregar_hijo.setText("Agregar hijos");
        btn_alta_poliza_agregar_hijo.setFocusTraversalPolicyProvider(true);
        jPanel4.add(btn_alta_poliza_agregar_hijo, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 290, 120, 30));

        table_alta_pol01_hijos.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        table_alta_pol01_hijos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Fecha Nac.", "Sexo", "Estado Civil"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(table_alta_pol01_hijos);
        if (table_alta_pol01_hijos.getColumnModel().getColumnCount() > 0) {
            table_alta_pol01_hijos.getColumnModel().getColumn(0).setResizable(false);
            table_alta_pol01_hijos.getColumnModel().getColumn(1).setResizable(false);
            table_alta_pol01_hijos.getColumnModel().getColumn(2).setResizable(false);
        }

        jPanel4.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 340, 360, 90));

        btn_alta_poliza01_continuar.setBackground(new java.awt.Color(52, 162, 224));
        btn_alta_poliza01_continuar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btn_alta_poliza01_continuar.setText("Continuar");
        btn_alta_poliza01_continuar.setFocusTraversalPolicyProvider(true);
        jPanel4.add(btn_alta_poliza01_continuar, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 450, 100, 30));

        btn_alta_poliza01_cancelar.setBackground(new java.awt.Color(255, 128, 146));
        btn_alta_poliza01_cancelar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btn_alta_poliza01_cancelar.setText("Cancelar");
        btn_alta_poliza01_cancelar.setFocusTraversalPolicyProvider(true);
        btn_alta_poliza01_cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_alta_poliza01_cancelarActionPerformed(evt);
            }
        });
        jPanel4.add(btn_alta_poliza01_cancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 450, 100, 30));

        txt_alta_pol01_nro_stros.setEditable(false);
        txt_alta_pol01_nro_stros.setBackground(new java.awt.Color(220, 220, 220));
        txt_alta_pol01_nro_stros.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txt_alta_pol01_nro_stros.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_alta_pol01_nro_strosActionPerformed(evt);
            }
        });
        jPanel4.add(txt_alta_pol01_nro_stros, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 90, 310, 30));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("El vehículo posee:");
        jPanel4.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 140, 140, -1));

        chk_alta_pol01_rastreo.setBackground(new java.awt.Color(255, 255, 255));
        chk_alta_pol01_rastreo.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        chk_alta_pol01_rastreo.setText("¿Dispositivo de rastreo satelital?");
        chk_alta_pol01_rastreo.setFocusTraversalPolicyProvider(true);
        chk_alta_pol01_rastreo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chk_alta_pol01_rastreoActionPerformed(evt);
            }
        });
        jPanel4.add(chk_alta_pol01_rastreo, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 190, 310, 30));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 51, 51));
        jLabel4.setText("*");
        jPanel4.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 30, -1, -1));

        txt_alta_pol01_km.setBackground(new java.awt.Color(220, 220, 220));
        txt_alta_pol01_km.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txt_alta_pol01_km.setFocusTraversalPolicyProvider(true);
        jPanel4.add(txt_alta_pol01_km, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, 310, 30));

        jLabel14.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel14.setText("Numero de siniestros en el último año");
        jPanel4.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 70, -1, -1));

        jLabel24.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel24.setText("Kilometros realizados por año");
        jPanel4.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, -1));

        jLabel11.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 51, 51));
        jLabel11.setText("*");
        jPanel4.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 90, -1, -1));

        chk_alta_pol01_tuerca.setBackground(new java.awt.Color(255, 255, 255));
        chk_alta_pol01_tuerca.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        chk_alta_pol01_tuerca.setText("¿Tuerca antirrobo en las cuatro ruedas?");
        chk_alta_pol01_tuerca.setFocusTraversalPolicyProvider(true);
        chk_alta_pol01_tuerca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chk_alta_pol01_tuercaActionPerformed(evt);
            }
        });
        jPanel4.add(chk_alta_pol01_tuerca, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 220, 310, 30));

        getContentPane().add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 70, 450, 530));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cmb_alta_pol01_provActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmb_alta_pol01_provActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmb_alta_pol01_provActionPerformed

    private void txt_alta_pol01_valorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_alta_pol01_valorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_alta_pol01_valorActionPerformed

    private void txt_alta_pol01_nro_strosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_alta_pol01_nro_strosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_alta_pol01_nro_strosActionPerformed

    private void chk_alta_pol01_cocheraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chk_alta_pol01_cocheraActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_chk_alta_pol01_cocheraActionPerformed

    private void chk_alta_pol01_alarmaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chk_alta_pol01_alarmaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_chk_alta_pol01_alarmaActionPerformed

    private void btn_alta_poliza01_cancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_alta_poliza01_cancelarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_alta_poliza01_cancelarActionPerformed

    private void chk_alta_pol01_rastreoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chk_alta_pol01_rastreoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_chk_alta_pol01_rastreoActionPerformed

    private void cmb_alta_pol01_modeloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmb_alta_pol01_modeloActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmb_alta_pol01_modeloActionPerformed

    private void cmb_alta_pol01_anioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmb_alta_pol01_anioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmb_alta_pol01_anioActionPerformed

    private void txt_alta_pol01_motorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_alta_pol01_motorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_alta_pol01_motorActionPerformed

    private void txt_alta_pol01_patenteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_alta_pol01_patenteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_alta_pol01_patenteActionPerformed

    private void chk_alta_pol01_tuercaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chk_alta_pol01_tuercaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_chk_alta_pol01_tuercaActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(AltaPoliza01.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AltaPoliza01.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AltaPoliza01.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AltaPoliza01.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AltaPoliza01().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btn_alta_poliza01_cancelar;
    public javax.swing.JButton btn_alta_poliza01_continuar;
    public javax.swing.JButton btn_alta_poliza_agregar_hijo;
    public javax.swing.JCheckBox chk_alta_pol01_alarma;
    public javax.swing.JCheckBox chk_alta_pol01_cochera;
    public javax.swing.JCheckBox chk_alta_pol01_rastreo;
    public javax.swing.JCheckBox chk_alta_pol01_tuerca;
    public javax.swing.JComboBox<Object> cmb_alta_pol01_anio;
    public javax.swing.JComboBox<Object> cmb_alta_pol01_local;
    public javax.swing.JComboBox<Object> cmb_alta_pol01_marca;
    public javax.swing.JComboBox<Object> cmb_alta_pol01_modelo;
    public javax.swing.JComboBox<Object> cmb_alta_pol01_prov;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JTable table_alta_pol01_hijos;
    public javax.swing.JTextField txt_alta_pol01_chasis;
    public javax.swing.JTextField txt_alta_pol01_km;
    public javax.swing.JTextField txt_alta_pol01_motor;
    public javax.swing.JTextField txt_alta_pol01_nro_stros;
    public javax.swing.JTextField txt_alta_pol01_patente;
    public javax.swing.JTextField txt_alta_pol01_valor;
    // End of variables declaration//GEN-END:variables
}
