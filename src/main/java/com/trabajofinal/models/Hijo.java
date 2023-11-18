package com.trabajofinal.models;

import java.time.LocalDate;

import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
@Entity
public class Hijo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_poliza")
    private int id;
    private LocalDate fecha_nacimiento;
    private Boolean sexo;
    private EstadoCivil estado_civil;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_poliza")			//chequear si es que esta bien que el hijo conozca la poliza
    private Poliza poliza;

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
