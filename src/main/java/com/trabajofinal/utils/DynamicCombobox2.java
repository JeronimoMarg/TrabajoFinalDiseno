package com.trabajofinal.utils;

public class DynamicCombobox2 {

    private Double valor;
    private int anyo;

    public DynamicCombobox2(Double valor, int anyo) {
        this.valor = valor;
        this.anyo = anyo;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public int getAnyo() {
        return anyo;
    }

    public void setAnyo(int anyo) {
        this.anyo = anyo;
    }

    @Override
    public String toString() {
        return String.valueOf(this.getAnyo());
    }  
    
    
}
