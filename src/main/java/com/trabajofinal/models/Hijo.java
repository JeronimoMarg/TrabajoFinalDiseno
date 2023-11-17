package com.trabajofinal.models;

import java.time.LocalDate;

public class Hijo {

    private int id;
    private LocalDate fecha_nacimiento;
    private Boolean sexo;
    private EstadoCivil estado_civil;

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public LocalDate getFecha_nacimiento() {
        return fecha_nacimiento;
    }
    public void setFecha_nacimiento(LocalDate fecha_nacimiento) {
        this.fecha_nacimiento = fecha_nacimiento;
    }
    public Boolean getSexo() {
        return sexo;
    }
    public void setSexo(Boolean sexo) {
        this.sexo = sexo;
    }
    public EstadoCivil getEstado_civil() {
        return estado_civil;
    }
    public void setEstado_civil(EstadoCivil estado_civil) {
        this.estado_civil = estado_civil;
    }

}
