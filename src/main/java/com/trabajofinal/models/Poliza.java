package com.trabajofinal.models;

import java.util.Date;

public class Poliza {
    
    private String numero_poliza;
    private float premio;
    private Date fecha_inicio_vigencia;

    public String getNumero_poliza() {
        return numero_poliza;
    }
    public void setNumero_poliza(String numero_poliza) {
        this.numero_poliza = numero_poliza;
    }
    public float getPremio() {
        return premio;
    }
    public void setPremio(float premio) {
        this.premio = premio;
    }
    public Date getFecha_inicio_vigencia() {
        return fecha_inicio_vigencia;
    }
    public void setFecha_inicio_vigencia(Date fecha_inicio_vigencia) {
        this.fecha_inicio_vigencia = fecha_inicio_vigencia;
    }
}
