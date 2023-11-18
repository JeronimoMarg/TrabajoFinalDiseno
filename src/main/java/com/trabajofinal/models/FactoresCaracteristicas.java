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
public class FactoresCaracteristicas {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_poliza")
    private int id;
    private Double porcentaje_garage;
    private Double porcentaje_alarma;
    private Double porcentaje_tuercas;
    private Double porcentaje_kilometros;
    private List<Double> porcentaje_siniestros;
    private Double porcentaje_hijo;
    private Double derechos_emision;
    private Double descuento_unidad_adicional;
    private Double factor_premio;
    private Double factor_descuento;
    private LocalDate fecha_inicio_vigencia;
    private LocalDate fecha_fin_vigencia;
    private int clientes_a_mostrar;
    private Usuario modificador;
    
    @OneToMany(mappedBy = "factores_generacion")		//factores NO conoce a LAS polizaS
    private List<Poliza> polizas;

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public Double getPorcentaje_garage() {
        return porcentaje_garage;
    }
    public void setPorcentaje_garage(Double porcentaje_garage) {
        this.porcentaje_garage = porcentaje_garage;
    }
    public Double getPorcentaje_alarma() {
        return porcentaje_alarma;
    }
    public void setPorcentaje_alarma(Double porcentaje_alarma) {
        this.porcentaje_alarma = porcentaje_alarma;
    }
    public Double getPorcentaje_tuercas() {
        return porcentaje_tuercas;
    }
    public void setPorcentaje_tuercas(Double porcentaje_tuercas) {
        this.porcentaje_tuercas = porcentaje_tuercas;
    }
    public Double getPorcentaje_kilometros() {
        return porcentaje_kilometros;
    }
    public void setPorcentaje_kilometros(Double porcentaje_kilometros) {
        this.porcentaje_kilometros = porcentaje_kilometros;
    }
    public List<Double> getPorcentaje_siniestros() {
        return porcentaje_siniestros;
    }
    public void setPorcentaje_siniestros(List<Double> porcentaje_siniestros) {
        this.porcentaje_siniestros = porcentaje_siniestros;
    }
    public Double getPorcentaje_hijo() {
        return porcentaje_hijo;
    }
    public void setPorcentaje_hijo(Double porcentaje_hijo) {
        this.porcentaje_hijo = porcentaje_hijo;
    }
    public Double getDerechos_emision() {
        return derechos_emision;
    }
    public void setDerechos_emision(Double derechos_emision) {
        this.derechos_emision = derechos_emision;
    }
    public Double getDescuento_unidad_adicional() {
        return descuento_unidad_adicional;
    }
    public void setDescuento_unidad_adicional(Double descuento_unidad_adicional) {
        this.descuento_unidad_adicional = descuento_unidad_adicional;
    }
    public Double getFactor_premio() {
        return factor_premio;
    }
    public void setFactor_premio(Double factor_premio) {
        this.factor_premio = factor_premio;
    }
    public Double getFactor_descuento() {
        return factor_descuento;
    }
    public void setFactor_descuento(Double factor_descuento) {
        this.factor_descuento = factor_descuento;
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
    public int getClientes_a_mostrar() {
        return clientes_a_mostrar;
    }
    public void setClientes_a_mostrar(int clientes_a_mostrar) {
        this.clientes_a_mostrar = clientes_a_mostrar;
    }
    public Usuario getModificador() {
        return modificador;
    }
    public void setModificador(Usuario modificador) {
        this.modificador = modificador;
    }

}
