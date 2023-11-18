package com.trabajofinal.models;

import java.util.List;

import jakarta.persistence.OneToMany;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
@Entity
public class Localidad {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_poliza")
    private int id;
    private String nombre;
    private FactorRiesgoLocalidad riesgo_localidad;
    private Provincia provincia;
    
    @OneToMany(mappedBy = "localidad")		//factores NO conoce a LAS polizaS
    private List<Poliza> polizas;

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public FactorRiesgoLocalidad getRiesgo_localidad() {
        return riesgo_localidad;
    }
    public void setRiesgo_localidad(FactorRiesgoLocalidad riesgo_localidad) {
        this.riesgo_localidad = riesgo_localidad;
    }
    public Provincia getProvincia() {
        return provincia;
    }
    public void setProvincia(Provincia provincia) {
        this.provincia = provincia;
    }

}
