/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.trabajofinal.gui;

import com.trabajofinal.controllers.ConfirmacionDatosPolizaController;
import com.trabajofinal.dto.ClienteDTO;
import com.trabajofinal.dto.HijoDTO;
import com.trabajofinal.dto.PolizaDTO;
import com.trabajofinal.dto.VehiculoDTO;

import java.awt.image.BufferedImage;
import java.util.List;

/**
 *
 * @author franco
 */
public class ConfirmacionDatosPoliza extends javax.swing.JFrame {

	private ClienteDTO cliente;
	private VehiculoDTO vehiculo;
	private List<HijoDTO> hijoDTO;
	private PolizaDTO poliza;
	
    public ConfirmacionDatosPoliza(ClienteDTO cliente, VehiculoDTO vehiculo, List<HijoDTO> hijoDTO, PolizaDTO poliza) {
    	super("Confirmación de póliza");

        // Establece un ícono transparente para evitar que se muestre el ícono de Java
        BufferedImage transparentImage = new BufferedImage(1, 1, BufferedImage.TYPE_INT_ARGB);
        setIconImage(transparentImage);

        initComponents();
        setSize(900, 600);
        setResizable(false);
        setLocationRelativeTo(null);
        setVisible(true);

        ConfirmacionDatosPolizaController confirmacionDatosPolizaController = new ConfirmacionDatosPolizaController(this, cliente, vehiculo, hijoDTO, poliza);
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
        jPanel4 = new javax.swing.JPanel();
        txt_confirma_pol_nombre = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txt_confirma_pol_modelo = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txt_confirma_pol_apellido = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        txt_confirma_pol_marca = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        txt_confirma_pol_motor = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        txt_confirma_pol_chasis = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        txt_confirma_pol_patente = new javax.swing.JLabel();
        txt_confirma_pol_fecha_ini = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        txt_confirma_pol_fecha_fin = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        txt_confirma_pol_suma_aseg = new javax.swing.JLabel();
        txt_confirma_pol_dscto = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        txt_confirma_pol_monto = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        txt_confirma_pol_ult_dia_pago = new javax.swing.JLabel();
        lab_confirma_pol_ult_dia_pago = new javax.swing.JLabel();
        txt_confirma_pol_premio = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        btn_confirma_datos_pol_ver_det = new javax.swing.JButton();
        btn_conf_dat_pol_ver_bon = new javax.swing.JButton();
        btn_confirma_datos_pol_mod = new javax.swing.JButton();
        btn_confirma_datos_pol_cancelar = new javax.swing.JButton();
        btn_confirma_datos_pol_fin = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel2.setText("Confirme los datos de la póliza:");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 16, 550, 50));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 800, 100));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/El-asegurado.png"))); // NOI18N
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 0, 100, 70));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 0, 140, 100));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txt_confirma_pol_nombre.setBackground(new java.awt.Color(204, 204, 204));
        txt_confirma_pol_nombre.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txt_confirma_pol_nombre.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel4.add(txt_confirma_pol_nombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 70, 180, 30));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jLabel4.setText("Vehiculo");
        jPanel4.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, -1, -1));

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setText("Nombre");
        jPanel4.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 50, -1, -1));

        txt_confirma_pol_modelo.setBackground(new java.awt.Color(204, 204, 204));
        txt_confirma_pol_modelo.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txt_confirma_pol_modelo.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel4.add(txt_confirma_pol_modelo, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 180, 170, 30));

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel8.setText("Modelo");
        jPanel4.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 160, -1, -1));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jLabel6.setText("Cliente <n_cliente>");
        jPanel4.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, -1));

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel9.setText("Apellido");
        jPanel4.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, -1, -1));

        txt_confirma_pol_apellido.setBackground(new java.awt.Color(204, 204, 204));
        txt_confirma_pol_apellido.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txt_confirma_pol_apellido.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel4.add(txt_confirma_pol_apellido, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, 180, 30));

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel11.setText("Marca");
        jPanel4.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 160, -1, -1));

        txt_confirma_pol_marca.setBackground(new java.awt.Color(204, 204, 204));
        txt_confirma_pol_marca.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txt_confirma_pol_marca.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel4.add(txt_confirma_pol_marca, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 180, 170, 30));

        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel13.setText("Motor");
        jPanel4.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 220, -1, -1));

        txt_confirma_pol_motor.setBackground(new java.awt.Color(204, 204, 204));
        txt_confirma_pol_motor.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txt_confirma_pol_motor.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel4.add(txt_confirma_pol_motor, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 240, 170, 30));

        jLabel15.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel15.setText("Chasis");
        jPanel4.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 220, -1, -1));

        txt_confirma_pol_chasis.setBackground(new java.awt.Color(204, 204, 204));
        txt_confirma_pol_chasis.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txt_confirma_pol_chasis.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel4.add(txt_confirma_pol_chasis, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 240, 180, 30));

        jLabel17.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel17.setText("Patente");
        jPanel4.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 290, -1, -1));

        txt_confirma_pol_patente.setBackground(new java.awt.Color(204, 204, 204));
        txt_confirma_pol_patente.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txt_confirma_pol_patente.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel4.add(txt_confirma_pol_patente, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 310, 140, 30));

        txt_confirma_pol_fecha_ini.setBackground(new java.awt.Color(204, 204, 204));
        txt_confirma_pol_fecha_ini.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txt_confirma_pol_fecha_ini.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel4.add(txt_confirma_pol_fecha_ini, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 70, 140, 30));

        jLabel20.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel20.setText("Fecha de inicio");
        jPanel4.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 50, -1, -1));

        jLabel21.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jLabel21.setText("Vigencia");
        jPanel4.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 20, -1, -1));

        txt_confirma_pol_fecha_fin.setBackground(new java.awt.Color(204, 204, 204));
        txt_confirma_pol_fecha_fin.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txt_confirma_pol_fecha_fin.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel4.add(txt_confirma_pol_fecha_fin, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 70, 140, 30));

        jLabel23.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel23.setText("Fecha de fin");
        jPanel4.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 50, -1, -1));

        jLabel24.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jLabel24.setText("Seguro");
        jPanel4.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 130, -1, -1));

        jLabel25.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel25.setText("Suma asegurada");
        jPanel4.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 160, -1, -1));

        txt_confirma_pol_suma_aseg.setBackground(new java.awt.Color(204, 204, 204));
        txt_confirma_pol_suma_aseg.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txt_confirma_pol_suma_aseg.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel4.add(txt_confirma_pol_suma_aseg, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 180, 140, 30));

        txt_confirma_pol_dscto.setBackground(new java.awt.Color(204, 204, 204));
        txt_confirma_pol_dscto.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txt_confirma_pol_dscto.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel4.add(txt_confirma_pol_dscto, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 240, 140, 30));

        jLabel28.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel28.setText("Importe por descuento");
        jPanel4.add(jLabel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 220, -1, -1));

        txt_confirma_pol_monto.setBackground(new java.awt.Color(204, 204, 204));
        txt_confirma_pol_monto.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txt_confirma_pol_monto.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel4.add(txt_confirma_pol_monto, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 240, 140, 30));

        jLabel30.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel30.setText("Monto total a abonar");
        jPanel4.add(jLabel30, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 220, -1, -1));

        txt_confirma_pol_ult_dia_pago.setBackground(new java.awt.Color(204, 204, 204));
        txt_confirma_pol_ult_dia_pago.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txt_confirma_pol_ult_dia_pago.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel4.add(txt_confirma_pol_ult_dia_pago, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 310, 140, 30));

        lab_confirma_pol_ult_dia_pago.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lab_confirma_pol_ult_dia_pago.setText("Ultimo dia de pago");
        jPanel4.add(lab_confirma_pol_ult_dia_pago, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 290, -1, -1));

        txt_confirma_pol_premio.setBackground(new java.awt.Color(204, 204, 204));
        txt_confirma_pol_premio.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txt_confirma_pol_premio.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel4.add(txt_confirma_pol_premio, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 180, 140, 30));

        jLabel34.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel34.setText("Premio");
        jPanel4.add(jLabel34, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 160, -1, -1));

        btn_confirma_datos_pol_ver_det.setBackground(new java.awt.Color(52, 162, 224));
        btn_confirma_datos_pol_ver_det.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btn_confirma_datos_pol_ver_det.setText("Ver detalle de cuotas");
        jPanel4.add(btn_confirma_datos_pol_ver_det, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 310, 180, 30));

        btn_conf_dat_pol_ver_bon.setBackground(new java.awt.Color(242, 242, 242));
        btn_conf_dat_pol_ver_bon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/pequenio negro.png"))); // NOI18N
        jPanel4.add(btn_conf_dat_pol_ver_bon, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 230, 40, -1));

        jPanel3.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 0, 810, 400));

        btn_confirma_datos_pol_mod.setBackground(new java.awt.Color(52, 162, 224));
        btn_confirma_datos_pol_mod.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btn_confirma_datos_pol_mod.setText("Modificar");
        btn_confirma_datos_pol_mod.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_confirma_datos_pol_modActionPerformed(evt);
            }
        });
        jPanel3.add(btn_confirma_datos_pol_mod, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 410, 100, 30));

        btn_confirma_datos_pol_cancelar.setBackground(new java.awt.Color(255, 128, 146));
        btn_confirma_datos_pol_cancelar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btn_confirma_datos_pol_cancelar.setText("Cancelar");
        btn_confirma_datos_pol_cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_confirma_datos_pol_cancelarActionPerformed(evt);
            }
        });
        jPanel3.add(btn_confirma_datos_pol_cancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 410, 100, 30));

        btn_confirma_datos_pol_fin.setBackground(new java.awt.Color(52, 162, 224));
        btn_confirma_datos_pol_fin.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btn_confirma_datos_pol_fin.setText("Finalizar");
        btn_confirma_datos_pol_fin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_confirma_datos_pol_finActionPerformed(evt);
            }
        });
        jPanel3.add(btn_confirma_datos_pol_fin, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 410, 100, 30));

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 100, 900, 500));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_confirma_datos_pol_cancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_confirma_datos_pol_cancelarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_confirma_datos_pol_cancelarActionPerformed

    private void btn_confirma_datos_pol_modActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_confirma_datos_pol_modActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_confirma_datos_pol_modActionPerformed

    private void btn_confirma_datos_pol_finActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_confirma_datos_pol_finActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_confirma_datos_pol_finActionPerformed

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
            java.util.logging.Logger.getLogger(ConfirmacionDatosPoliza.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ConfirmacionDatosPoliza.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ConfirmacionDatosPoliza.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ConfirmacionDatosPoliza.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                //new ConfirmacionDatosPoliza(cliente, vehiculo, hijoDTO).setVisible(true);
            	//FIJARSE QUE HACE ESTO
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btn_conf_dat_pol_ver_bon;
    public javax.swing.JButton btn_confirma_datos_pol_cancelar;
    public javax.swing.JButton btn_confirma_datos_pol_fin;
    public javax.swing.JButton btn_confirma_datos_pol_mod;
    public javax.swing.JButton btn_confirma_datos_pol_ver_det;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    public javax.swing.JLabel lab_confirma_pol_ult_dia_pago;
    public javax.swing.JLabel txt_confirma_pol_apellido;
    public javax.swing.JLabel txt_confirma_pol_chasis;
    public javax.swing.JLabel txt_confirma_pol_dscto;
    public javax.swing.JLabel txt_confirma_pol_fecha_fin;
    public javax.swing.JLabel txt_confirma_pol_fecha_ini;
    public javax.swing.JLabel txt_confirma_pol_marca;
    public javax.swing.JLabel txt_confirma_pol_modelo;
    public javax.swing.JLabel txt_confirma_pol_monto;
    public javax.swing.JLabel txt_confirma_pol_motor;
    public javax.swing.JLabel txt_confirma_pol_nombre;
    public javax.swing.JLabel txt_confirma_pol_patente;
    public javax.swing.JLabel txt_confirma_pol_premio;
    public javax.swing.JLabel txt_confirma_pol_suma_aseg;
   public javax.swing.JLabel txt_confirma_pol_ult_dia_pago;
    // End of variables declaration//GEN-END:variables
}
