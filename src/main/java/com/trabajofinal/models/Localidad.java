package com.trabajofinal.models;

public class Localidad {

    private int id;
    private String nombre;
    private FactorRiesgoLocalidad riesgo_localidad;
    private Provincia provincia;

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
