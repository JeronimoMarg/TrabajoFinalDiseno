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
@Table(name = "factor_riesgo_localidad")
public class FactorRiesgoLocalidad {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_factores_riesgo_localidad")
    private int id;

    @Column(name = "fecha_inicio_vigencia")
    private LocalDate fecha_inicio_vigencia;

    @Column(name = "fecha_fin_vigencia")
    private LocalDate fecha_fin_vigencia;

    @Column(name = "riesgo")
    private Double riesgo;
    
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "id_localidad")
    private Localidad localidad;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "id_usuario")
    private Usuario modificador;

    public FactorRiesgoLocalidad(LocalDate fecha_inicio_vigencia, LocalDate fecha_fin_vigencia, Double riesgo,
            Usuario modificador, Localidad localidad) {
        this.fecha_inicio_vigencia = fecha_inicio_vigencia;
        this.fecha_fin_vigencia = fecha_fin_vigencia;
        this.riesgo = riesgo;
        this.modificador = modificador;
        this.localidad = localidad;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public Double getRiesgo() {
        return riesgo;
    }

    public void setRiesgo(Double riesgo) {
        this.riesgo = riesgo;
    }

    public Usuario getModificador() {
        return modificador;
    }

    public void setModificador(Usuario modificador) {
        this.modificador = modificador;
    }
}
