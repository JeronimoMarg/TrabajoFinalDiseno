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
@Table(name = "factores_caracteristicas")
public class FactoresCaracteristicas {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_factores_caracteristicas")
    private int id;

    @Column(name = "porcentaje_garage")
    private Double porcentaje_garage;

    @Column(name = "porcentaje_alarma")
    private Double porcentaje_alarma;

    @Column(name = "porcentaje_tuercas")
    private Double porcentaje_tuercas;

    @Column(name = "porcentaje_kilometros")
    private Double porcentaje_kilometros;

    @Column(name = "porcentaje_siniestros_0")
    private Double porcentaje_siniestros_0;

    @Column(name = "porcentaje_siniestros_1")
    private Double porcentaje_siniestros_1;

    @Column(name = "porcentaje_siniestros_2")
    private Double porcentaje_siniestros_2;

    @Column(name = "porcentaje_siniestros_mas2")
    private Double porcentaje_siniestros_mas2;

    @Column(name = "porcentaje_hijo")
    private Double porcentaje_hijo;

    @Column(name = "derechos_emision")
    private Double derechos_emision;

    @Column(name = "descuento_unidad_adicional")
    private Double descuento_unidad_adicional;

    @Column(name = "factor_premio")
    private Double factor_premio;

    @Column(name = "factor_descuento")
    private Double factor_descuento;

    @Column(name = "fecha_inicio_vigencia")
    private LocalDate fecha_inicio_vigencia;

    @Column(name = "fecha_fin_vigencia")
    private LocalDate fecha_fin_vigencia;

    @Column(name = "clientes_a_mostrar")
    private int clientes_a_mostrar;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_usuario")
    private Usuario modificador;

    public FactoresCaracteristicas() {

    }

    public FactoresCaracteristicas(Double porcentaje_garage, Double porcentaje_alarma,
            Double porcentaje_tuercas, Double porcentaje_kilometros, Double porcentaje_siniestros_0,
            Double porcentaje_siniestros_1, Double porcentaje_siniestros_2, Double porcentaje_siniestros_mas2,
            Double porcentaje_hijo, Double derechos_emision, Double descuento_unidad_adicional, Double factor_premio,
            Double factor_descuento, LocalDate fecha_inicio_vigencia, LocalDate fecha_fin_vigencia,
            int clientes_a_mostrar, Usuario modificador) {
        super();
        // this.id = id;
        this.porcentaje_garage = porcentaje_garage;
        this.porcentaje_alarma = porcentaje_alarma;
        this.porcentaje_tuercas = porcentaje_tuercas;
        this.porcentaje_kilometros = porcentaje_kilometros;
        this.porcentaje_siniestros_0 = porcentaje_siniestros_0;
        this.porcentaje_siniestros_1 = porcentaje_siniestros_1;
        this.porcentaje_siniestros_2 = porcentaje_siniestros_2;
        this.porcentaje_siniestros_mas2 = porcentaje_siniestros_mas2;
        this.porcentaje_hijo = porcentaje_hijo;
        this.derechos_emision = derechos_emision;
        this.descuento_unidad_adicional = descuento_unidad_adicional;
        this.factor_premio = factor_premio;
        this.factor_descuento = factor_descuento;
        this.fecha_inicio_vigencia = fecha_inicio_vigencia;
        this.fecha_fin_vigencia = fecha_fin_vigencia;
        this.clientes_a_mostrar = clientes_a_mostrar;
        this.modificador = modificador;
    }

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

    public Double getPorcentaje_siniestros_0() {
        return porcentaje_siniestros_0;
    }

    public void setPorcentaje_siniestros_0(Double porcentaje_siniestros_0) {
        this.porcentaje_siniestros_0 = porcentaje_siniestros_0;
    }

    public Double getPorcentaje_siniestros_1() {
        return porcentaje_siniestros_1;
    }

    public void setPorcentaje_siniestros_1(Double porcentaje_siniestros_1) {
        this.porcentaje_siniestros_1 = porcentaje_siniestros_1;
    }

    public Double getPorcentaje_siniestros_2() {
        return porcentaje_siniestros_2;
    }

    public void setPorcentaje_siniestros_2(Double porcentaje_siniestros_2) {
        this.porcentaje_siniestros_2 = porcentaje_siniestros_2;
    }

    public Double getPorcentaje_siniestros_mas2() {
        return porcentaje_siniestros_mas2;
    }

    public void setPorcentaje_siniestros_mas2(Double porcentaje_siniestros_mas2) {
        this.porcentaje_siniestros_mas2 = porcentaje_siniestros_mas2;
    }

    @Override
    public String toString() {
        return "FactoresCaracteristicas [id=" + id + ", porcentaje_garage=" + porcentaje_garage + ", porcentaje_alarma="
                + porcentaje_alarma + ", porcentaje_tuercas=" + porcentaje_tuercas + ", porcentaje_kilometros="
                + porcentaje_kilometros + ", porcentaje_siniestros_0=" + porcentaje_siniestros_0
                + ", porcentaje_siniestros_1=" + porcentaje_siniestros_1 + ", porcentaje_siniestros_2="
                + porcentaje_siniestros_2 + ", porcentaje_siniestros_mas2=" + porcentaje_siniestros_mas2
                + ", porcentaje_hijo=" + porcentaje_hijo + ", derechos_emision=" + derechos_emision
                + ", descuento_unidad_adicional=" + descuento_unidad_adicional + ", factor_premio=" + factor_premio
                + ", factor_descuento=" + factor_descuento + ", fecha_inicio_vigencia=" + fecha_inicio_vigencia
                + ", fecha_fin_vigencia=" + fecha_fin_vigencia + ", clientes_a_mostrar=" + clientes_a_mostrar
                + ", modificador=" + modificador + "]";
    }

}
