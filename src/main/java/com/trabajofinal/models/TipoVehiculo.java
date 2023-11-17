package com.trabajofinal.models;

public class TipoVehiculo {

    private Double potencia;
    private Double velocidad;
    private Double peso;
    private int anio;
    private Modelo modelo_vehiculo;
    private FactoresVehiculo factores_actuales;

    public FactoresVehiculo getFactores_actuales() {
        return factores_actuales;
    }
    public void setFactores_actuales(FactoresVehiculo factores_actuales) {
        this.factores_actuales = factores_actuales;
    }
    public Modelo getModelo_vehiculo() {
        return modelo_vehiculo;
    }
    public void setModelo_vehiculo(Modelo modelo_vehiculo) {
        this.modelo_vehiculo = modelo_vehiculo;
    }
    public Double getPotencia() {
        return potencia;
    }
    public void setPotencia(Double potencia) {
        this.potencia = potencia;
    }
    public Double getVelocidad() {
        return velocidad;
    }
    public void setVelocidad(Double velocidad) {
        this.velocidad = velocidad;
    }
    public Double getPeso() {
        return peso;
    }
    public void setPeso(Double peso) {
        this.peso = peso;
    }
    public int getAnio() {
        return anio;
    }
    public void setAnio(int anio) {
        this.anio = anio;
    }
}
