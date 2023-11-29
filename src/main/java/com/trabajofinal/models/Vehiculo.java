package com.trabajofinal.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "vehiculo")
public class Vehiculo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_vehiculo")
    private int id;

    @Column(name = "motor")
    private String motor;

    @Column(name = "chasis")
    private String chasis;

    @Column(name = "patente")
    private String patente;

    @Column(name = "kilometros_anio")
    private int kilometros_anio;

    @Column(name = "en_garage")
    private Boolean en_garage;

    @Column(name = "con_alarma")
    private Boolean con_alarma;

    @Column(name = "con_rastreo")
    private Boolean con_rastreo;

    @Column(name = "con_tuerca_antirrobo")
    private Boolean con_tuerca_antirrobo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_tipo_vehiculo")
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

    /*
     * public TipoVehiculo getTipo_vehiculo() {
     * return tipo_vehiculo;
     * }
     * public void setTipo_vehiculo(TipoVehiculo tipo_vehiculo) {
     * this.tipo_vehiculo = tipo_vehiculo;
     * }
     */
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

	public TipoVehiculo getTipo_vehiculo() {
		return tipo_vehiculo;
	}

	public void setTipo_vehiculo(TipoVehiculo tipo_vehiculo) {
		this.tipo_vehiculo = tipo_vehiculo;
	}
    
    

}
