package com.trabajofinal.models;

public class AnyoVehiculo {

    private int anio;
    private Double valorMercado;

    public AnyoVehiculo() {
    }

    public AnyoVehiculo(int anio, Double valorMercado) {
        this.anio = anio;
        this.valorMercado = valorMercado;
    }

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    public Double getValorMercado() {
        return valorMercado;
    }

    public void setValorMercado(Double valorMercado) {
        this.valorMercado = valorMercado;
    }    
}
