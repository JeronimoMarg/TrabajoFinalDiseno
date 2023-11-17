package com.trabajofinal.models;

import java.time.LocalDate;

public class FactoresVehiculo {

    private LocalDate fecha_inicio_vigencia;
    private LocalDate fecha_fin_vigencia;
    private Double suma_asegurada;
    private TipoVehiculo vehiculo;

    public LocalDate getFecha_inicio_vigencia() {
        return fecha_inicio_vigencia;
    }
    public void setFecha_inicio_vigencia(LocalDate fecha_inicio_vigencia) {
        this.fecha_inicio_vigencia = fecha_inicio_vigencia;
    }
    public LocalDate getFecha_fin_vigencia() {
        return fecha_fin_vigencia;
    }
    public void setFecha_fin_vigencia(LocalDate fecha_fin_vigencia) {
        this.fecha_fin_vigencia = fecha_fin_vigencia;
    }
    public Double getSuma_asegurada() {
        return suma_asegurada;
    }
    public void setSuma_asegurada(Double suma_asegurada) {
        this.suma_asegurada = suma_asegurada;
    }
    public TipoVehiculo getVehiculo() {
        return vehiculo;
    }
    public void setVehiculo(TipoVehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }
}
