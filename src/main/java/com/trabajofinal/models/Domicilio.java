package com.trabajofinal.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity

public class Domicilio {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_vehiculo")
    private int id;
    private String codigo_postal;
    private int numero_calle;
    private String nombre_calle;
    private Boolean es_departamento;
    private int piso;
    private String departamento;
    private Localidad localidad;

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getCodigo_postal() {
        return codigo_postal;
    }
    public void setCodigo_postal(String codigo_postal) {
        this.codigo_postal = codigo_postal;
    }
    public int getNumero_calle() {
        return numero_calle;
    }
    public void setNumero_calle(int numero_calle) {
        this.numero_calle = numero_calle;
    }
    public String getNombre_calle() {
        return nombre_calle;
    }
    public void setNombre_calle(String nombre_calle) {
        this.nombre_calle = nombre_calle;
    }
    public Boolean getEs_departamento() {
        return es_departamento;
    }
    public void setEs_departamento(Boolean es_departamento) {
        this.es_departamento = es_departamento;
    }
    public int getPiso() {
        return piso;
    }
    public void setPiso(int piso) {
        this.piso = piso;
    }
    public String getDepartamento() {
        return departamento;
    }
    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }
    public Localidad getLocalidad() {
        return localidad;
    }
    public void setLocalidad(Localidad localidad) {
        this.localidad = localidad;
    }
}
