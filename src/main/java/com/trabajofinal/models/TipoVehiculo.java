package com.trabajofinal.models;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tipo_vehiculo")
public class TipoVehiculo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_tipo_vehiculo")
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(name = "potencia")
    private Double potencia;

    @Column(name = "velocidad")
    private Double velocidad;

    @Column(name = "peso")
    private Double peso;

    @Column(name = "anio")
    private int anio;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_modelo")
    private Modelo modelo;

    @OneToOne
    @JoinColumn(name = "id_factores_vehiculo")
    private FactoresVehiculo factores_actuales;

    public TipoVehiculo() {

    }

    public TipoVehiculo(Double potencia, Double velocidad, Double peso, int anio, Modelo modelo_vehiculo,
            FactoresVehiculo factores_actuales) {
        this.potencia = potencia;
        this.velocidad = velocidad;
        this.peso = peso;
        this.anio = anio;
        this.modelo = modelo_vehiculo;
        this.factores_actuales = factores_actuales;
    }

    public FactoresVehiculo getFactores_actuales() {
        return factores_actuales;
    }

    public void setFactores_actuales(FactoresVehiculo factores_actuales) {
        this.factores_actuales = factores_actuales;
    }

    public Modelo getModelo_vehiculo() {
        return modelo;
    }

    public void setModelo_vehiculo(Modelo modelo_vehiculo) {
        this.modelo = modelo_vehiculo;
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

    public Integer getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }
}
