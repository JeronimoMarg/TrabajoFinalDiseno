package com.trabajofinal.models;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
@Table(name = "factores_vehiculo")
public class FactoresVehiculo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_factores_vehiculo")
    private int id;

    @Column(name = "fecha_inicio_vigencia")
    private LocalDate fecha_inicio_vigencia;

    @Column(name = "fecha_fin_vigencia")
    private LocalDate fecha_fin_vigencia;

    @Column(name = "suma_asegurada")
    private Double suma_asegurada;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_tipo_vehiculo")
    private TipoVehiculo vehiculo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_usuario")
    private Usuario modificador;

    public FactoresVehiculo() {
    }

    public FactoresVehiculo(LocalDate fecha_inicio_vigencia, LocalDate fecha_fin_vigencia, Double suma_asegurada,
            TipoVehiculo vehiculo, Usuario modificador) {
        this.fecha_inicio_vigencia = fecha_inicio_vigencia;
        this.fecha_fin_vigencia = fecha_fin_vigencia;
        this.suma_asegurada = suma_asegurada;
        this.vehiculo = vehiculo;
        this.modificador = modificador;
    }

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
