package com.trabajofinal.models;

import java.util.Date;
import java.util.HashSet;
import java.util.List;

public class Poliza {
    
    private int id;
    private String numero_poliza;
    private Double premio;
    private Date fecha_inicio_vigencia;
    private TipoPago forma_pago;
    private Double descuentos;
    private Double total_a_pagar;
    private int cantidad_siniestros;
    private TipoEstadoPoliza estado;
    private Poliza poliza_propuesta;
    private Vehiculo vehiculo_asegurado;
    private HashSet<Hijo> hijos;
    private List<ModificacionPoliza> modificaciones;
    private FactoresTipoCobertura cobertura_poliza;
    private FactoresCaracteristicas factores_generacion;
    private List<Cuota> cuotas;
    private FactoresVehiculo factores_vehiculo;
    private FactoresModelo factores_modelo;
    private Cliente cliente;
    private Localidad localidad;
    private FactorRiesgoLocalidad factor_riesgo_localidad;
    

    public Cliente getCliente() {
        return cliente;
    }
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    public Localidad getLocalidad() {
        return localidad;
    }
    public void setLocalidad(Localidad localidad) {
        this.localidad = localidad;
    }
    public FactorRiesgoLocalidad getFactor_riesgo_localidad() {
        return factor_riesgo_localidad;
    }
    public void setFactor_riesgo_localidad(FactorRiesgoLocalidad factor_riesgo_localidad) {
        this.factor_riesgo_localidad = factor_riesgo_localidad;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public TipoPago getForma_pago() {
        return forma_pago;
    }
    public void setForma_pago(TipoPago forma_pago) {
        this.forma_pago = forma_pago;
    }
    public Double getDescuentos() {
        return descuentos;
    }
    public void setDescuentos(Double descuentos) {
        this.descuentos = descuentos;
    }
    public Double getTotal_a_pagar() {
        return total_a_pagar;
    }
    public void setTotal_a_pagar(Double total_a_pagar) {
        this.total_a_pagar = total_a_pagar;
    }
    public int getCantidad_siniestros() {
        return cantidad_siniestros;
    }
    public void setCantidad_siniestros(int cantidad_siniestros) {
        this.cantidad_siniestros = cantidad_siniestros;
    }
    public TipoEstadoPoliza getEstado() {
        return estado;
    }
    public void setEstado(TipoEstadoPoliza estado) {
        this.estado = estado;
    }
    public Poliza getPoliza_propuesta() {
        return poliza_propuesta;
    }
    public void setPoliza_propuesta(Poliza poliza_propuesta) {
        this.poliza_propuesta = poliza_propuesta;
    }
    public Vehiculo getVehiculo_asegurado() {
        return vehiculo_asegurado;
    }
    public void setVehiculo_asegurado(Vehiculo vehiculo_asegurado) {
        this.vehiculo_asegurado = vehiculo_asegurado;
    }
    public HashSet<Hijo> getHijos() {
        return hijos;
    }
    public void setHijos(HashSet<Hijo> hijos) {
        this.hijos = hijos;
    }
    public List<ModificacionPoliza> getModificaciones() {
        return modificaciones;
    }
    public void setModificaciones(List<ModificacionPoliza> modificaciones) {
        this.modificaciones = modificaciones;
    }
    public FactoresTipoCobertura getCobertura_poliza() {
        return cobertura_poliza;
    }
    public void setCobertura_poliza(FactoresTipoCobertura cobertura_poliza) {
        this.cobertura_poliza = cobertura_poliza;
    }
    public FactoresCaracteristicas getFactores_generacion() {
        return factores_generacion;
    }
    public void setFactores_generacion(FactoresCaracteristicas factores_generacion) {
        this.factores_generacion = factores_generacion;
    }
    public List<Cuota> getCuotas() {
        return cuotas;
    }
    public void setCuotas(List<Cuota> cuotas) {
        this.cuotas = cuotas;
    }
    public FactoresVehiculo getFactores_vehiculo() {
        return factores_vehiculo;
    }
    public void setFactores_vehiculo(FactoresVehiculo factores_vehiculo) {
        this.factores_vehiculo = factores_vehiculo;
    }
    public FactoresModelo getFactores_modelo() {
        return factores_modelo;
    }
    public void setFactores_modelo(FactoresModelo factores_modelo) {
        this.factores_modelo = factores_modelo;
    }
    public String getNumero_poliza() {
        return numero_poliza;
    }
    public void setNumero_poliza(String numero_poliza) {
        this.numero_poliza = numero_poliza;
    }
    public Double getPremio() {
        return premio;
    }
    public void setPremio(Double premio) {
        this.premio = premio;
    }
    public Date getFecha_inicio_vigencia() {
        return fecha_inicio_vigencia;
    }
    public void setFecha_inicio_vigencia(Date fecha_inicio_vigencia) {
        this.fecha_inicio_vigencia = fecha_inicio_vigencia;
    }
}
