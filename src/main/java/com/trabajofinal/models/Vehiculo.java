package com.trabajofinal.models;

public class Vehiculo {

    private int id;
    private String motor;
    private String chasis;
    private String patente;
    private int kilometros_anio;
    private Boolean en_garage;
    private Boolean con_alarma;
    private Boolean con_rastreo;
    private Boolean con_tuerca_antirrobo;
    private TipoVehiculo tipo_vehiculo;
    public String getMotor() {
        return motor;
    }
    public void setMotor(String motor) {
        this.motor = motor;
    }
    public String getChasis() {
        return chasis;
    }
    public void setChasis(String chasis) {
        this.chasis = chasis;
    }
    public String getPatente() {
        return patente;
    }
    public void setPatente(String patente) {
        this.patente = patente;
    }
    public int getKilometros_anio() {
        return kilometros_anio;
    }
    public void setKilometros_anio(int kilometros_anio) {
        this.kilometros_anio = kilometros_anio;
    }
    public Boolean getEn_garage() {
        return en_garage;
    }
    public void setEn_garage(Boolean en_garage) {
        this.en_garage = en_garage;
    }
    public Boolean getCon_alarma() {
        return con_alarma;
    }
    public void setCon_alarma(Boolean con_alarma) {
        this.con_alarma = con_alarma;
    }
    public Boolean getCon_rastreo() {
        return con_rastreo;
    }
    public void setCon_rastreo(Boolean con_rastreo) {
        this.con_rastreo = con_rastreo;
    }
    public Boolean getCon_tuerca_antirrobo() {
        return con_tuerca_antirrobo;
    }
    public void setCon_tuerca_antirrobo(Boolean con_tuerca_antirrobo) {
        this.con_tuerca_antirrobo = con_tuerca_antirrobo;
    }
    public TipoVehiculo getTipo_vehiculo() {
        return tipo_vehiculo;
    }
    public void setTipo_vehiculo(TipoVehiculo tipo_vehiculo) {
        this.tipo_vehiculo = tipo_vehiculo;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
 
}
