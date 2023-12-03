package com.trabajofinal.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

import com.trabajofinal.gestores.GestorLimiteDeBusqueda;
import com.trabajofinal.gui.ConfiguracionLimiteDeBusqueda;

public class ConfiguracionLimiteController implements ActionListener, KeyListener, ItemListener{
    
    private ConfiguracionLimiteDeBusqueda configuracionLimiteDeBusqueda;
    private Integer limite_actual;

    private String regex = "\\d";

    public ConfiguracionLimiteController(ConfiguracionLimiteDeBusqueda configuracionLimiteBusqueda) {
        this.configuracionLimiteDeBusqueda = configuracionLimiteBusqueda;
        this.limite_actual = GestorLimiteDeBusqueda.getInstance().getLimite();
        cargarLimite();

        this.configuracionLimiteDeBusqueda.btn_config_limite_guardar.addActionListener(this);
        this.configuracionLimiteDeBusqueda.btn_config_limite_cancelar.addActionListener(this);
        this.configuracionLimiteDeBusqueda.chk_config_limite_habilitar_cambio.addItemListener(this);
        this.configuracionLimiteDeBusqueda.txt_config_limite_valor_nuevo.addKeyListener(this);

        this.configuracionLimiteDeBusqueda.setDefaultCloseOperation(ConfiguracionLimiteDeBusqueda.DISPOSE_ON_CLOSE);
    }

    private void cargarLimite(){
        this.configuracionLimiteDeBusqueda.txt_config_limite_valor_actual.setText(limite_actual.toString());
        this.configuracionLimiteDeBusqueda.txt_config_limite_valor_nuevo.setText(limite_actual.toString());
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.configuracionLimiteDeBusqueda.btn_config_limite_cancelar) {
            this.configuracionLimiteDeBusqueda.dispose();
        } else if (e.getSource() == this.configuracionLimiteDeBusqueda.btn_config_limite_guardar) {
            if (Integer.parseInt(this.configuracionLimiteDeBusqueda.txt_config_limite_valor_nuevo.getText().trim()) == 0) {
                JOptionPane.showMessageDialog(null, "El valor debe ser distinto de 0.", "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                GestorLimiteDeBusqueda.getInstance().modificarLimite(Integer.parseInt(this.configuracionLimiteDeBusqueda.txt_config_limite_valor_nuevo.getText().trim()));
                this.configuracionLimiteDeBusqueda.dispose();
            }
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
        JTextField textField = (JTextField) e.getSource();
        if ((textField == this.configuracionLimiteDeBusqueda.txt_config_limite_valor_nuevo)) {
            char c = e.getKeyChar();
            if (!Character.toString(c).matches(regex)) {
                e.consume();
            }
            if (this.configuracionLimiteDeBusqueda.txt_config_limite_valor_nuevo.getText().length() > 1) {
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

    @Override
    public void itemStateChanged(ItemEvent e) {
        if (this.configuracionLimiteDeBusqueda.chk_config_limite_habilitar_cambio.isSelected()) {
            this.configuracionLimiteDeBusqueda.txt_config_limite_valor_nuevo.setEditable(true);
            this.configuracionLimiteDeBusqueda.btn_config_limite_guardar.setEnabled(true);
        } else {
            this.configuracionLimiteDeBusqueda.txt_config_limite_valor_nuevo.setEditable(false);
            this.configuracionLimiteDeBusqueda.btn_config_limite_guardar.setEnabled(false);
        }
    }
}
