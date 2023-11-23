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
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
@Entity
public class Hijo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_hijo")
    private int id;
	
	@Column(name = "fecha_nacimiento")
    private LocalDate fecha_nacimiento;
	
	@Column(name = "sexo")
    private Boolean sexo;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "estado_civil")
    private EstadoCivil estado_civil;

	public Hijo() {
		
	}
	
    public Hijo(LocalDate fecha_nacimiento2, Boolean sexo2, EstadoCivil estado_civil2) {
		fecha_nacimiento = fecha_nacimiento2;
		sexo = sexo2;
		estado_civil = estado_civil2;
	}
    
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
