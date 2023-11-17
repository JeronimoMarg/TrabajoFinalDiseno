package com.trabajofinal.models;

import java.time.LocalDate;
import java.util.HashSet;

public class ModificacionPoliza {

    private int id;
    private LocalDate fecha_inicio_vigencia;
    private LocalDate fecha_fin_vigencia;
    private int cantidad_siniestros;
    private Poliza poliza;
    private HashSet<ModificacionHijo> modificaciones_hijo;
    private TipoCobertura covertura;

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
    public int getCantidad_siniestros() {
        return cantidad_siniestros;
    }
    public void setCantidad_siniestros(int cantidad_siniestros) {
        this.cantidad_siniestros = cantidad_siniestros;
    }
    public Poliza getPoliza() {
        return poliza;
    }
    public void setPoliza(Poliza poliza) {
        this.poliza = poliza;
    }
    public HashSet<ModificacionHijo> getModificaciones_hijo() {
        return modificaciones_hijo;
    }
    public void setModificaciones_hijo(HashSet<ModificacionHijo> modificaciones_hijo) {
        this.modificaciones_hijo = modificaciones_hijo;
    }
    public TipoCobertura getCovertura() {
        return covertura;
    }
    public void setCovertura(TipoCobertura covertura) {
        this.covertura = covertura;
    }

}
