package com.trabajofinal.models;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
@Table(name = "localidad")
public class Localidad {

    @Override
    public String toString() {
        return "Localidad [id=" + id + ", nombre=" + nombre + "]";
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_localidad")
    private int id;

    @Column(name = "nombre")
    private String nombre;

    @OneToMany
    @JoinColumn(name = "id_factores_riesgo_localidad")
    private Set<FactorRiesgoLocalidad> riesgo_localidad;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_provincia")
    private Provincia provincia;

    public Localidad() {
    }

    public Localidad(String nombre, HashSet<FactorRiesgoLocalidad> riesgo_localidad, Provincia provincia) {
        this.nombre = nombre;
        this.riesgo_localidad = riesgo_localidad;
        this.provincia = provincia;
    }

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

    public Provincia getProvincia() {
        return provincia;
    }

    public void setProvincia(Provincia provincia) {
        this.provincia = provincia;
    }

    public Set<FactorRiesgoLocalidad> getRiesgo_localidad() {
        return riesgo_localidad;
    }

    public void setRiesgo_localidad(HashSet<FactorRiesgoLocalidad> riesgo_localidad) {
        this.riesgo_localidad = riesgo_localidad;
    }

}
