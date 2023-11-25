package com.trabajofinal.models;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
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

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_factores_riesgo_localidad")
    private FactorRiesgoLocalidad factorActual;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_provincia")
    private Provincia provincia;

    public Localidad() {
    }

    public Localidad(String nombre, FactorRiesgoLocalidad riesgo_localidad, Provincia provincia) {
        this.nombre = nombre;
        this.factorActual = riesgo_localidad;
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

    public FactorRiesgoLocalidad getRiesgo_localidad() {
        return factorActual;
    }

    public void setRiesgo_localidad(FactorRiesgoLocalidad riesgo_localidad) {
        this.factorActual = riesgo_localidad;
    }

}
