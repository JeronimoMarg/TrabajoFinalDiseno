package com.trabajofinal.models;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
@Table(name = "factores_tipo_cobertura")
public class FactoresTipoCobertura {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_factores_tipocobertura")
    private int id;

    @Column(name = "fecha_inicio_vigencia")
    private LocalDate fecha_inicio_vigencia;

    @Column(name = "fecha_fin_vigencia")
    private LocalDate fecha_fin_vigencia;

    @Column(name = "porcentaje")
    private Double porcentaje;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_cobertura")
    private TipoCobertura tipo_cobertura;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_usuario")
    private Usuario modificador;

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

    public Double getPorcentaje() {
        return porcentaje;
    }

    public void setPorcentaje(Double porcentaje) {
        this.porcentaje = porcentaje;
    }

    public TipoCobertura getTipo_cobertura() {
        return tipo_cobertura;
    }

    public void setTipo_cobertura(TipoCobertura tipo_cobertura) {
        this.tipo_cobertura = tipo_cobertura;
    }

    public Usuario getModificador() {
        return modificador;
    }

    public void setModificador(Usuario modificador) {
        this.modificador = modificador;
    }

}
