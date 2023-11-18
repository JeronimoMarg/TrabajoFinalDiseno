package com.trabajofinal.models;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.OneToMany;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
@Entity
public class FactorRiesgoLocalidad {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_poliza")
    private int id;
    private LocalDate fecha_inicio_vigencia;
    private LocalDate fecha_fin_vigencia;
    private Double riesgo;
    private Usuario modificador;
    
    @OneToMany(mappedBy = "factor_riesgo_localidad")		//factores NO conoce a LAS polizaS
    private List<Poliza> polizas;

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
