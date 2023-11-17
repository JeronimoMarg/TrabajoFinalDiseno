package com.trabajofinal.models;

public class Modelo {

    private int id;
    private String nombre;
    private FactoresModelo factor_actual;
    private Marca marca;

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public FactoresModelo getFactor_actual() {
        return factor_actual;
    }
    public void setFactor_actual(FactoresModelo factor_actual) {
        this.factor_actual = factor_actual;
    }
    public Marca getMarca() {
        return marca;
    }
    public void setMarca(Marca marca) {
        this.marca = marca;
    }


}
