package com.trabajofinal.dto;

import com.trabajofinal.models.TipoVehiculo;

public class VehiculoDTO {
   private int id;
   private String motor;
   private String chasis;
   private String patente;
   private int kilometros_anio;
   private Boolean en_garage;
   private Boolean con_alarma;
   private Boolean con_rastreo;
   private Boolean con_tuerca_antirrobo;
   private String anio;
   private String peso;
   private String potencia;
   private String velocidad;
   private String marca;
   private int id_modelo;
   private String modelo;
   private int id_tipo_vehiculo;
   private String valor_estimado;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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

    public String getAnio() {
        return anio;
    }

    public void setAnio(String anio) {
        this.anio = anio;
    }

    public String getPeso() {
        return peso;
    }

    public void setPeso(String peso) {
        this.peso = peso;
    }

    public String getPotencia() {
        return potencia;
    }

    public void setPotencia(String potencia) {
        this.potencia = potencia;
    }

    public String getVelocidad() {
        return velocidad;
    }

    public void setVelocidad(String velocidad) {
        this.velocidad = velocidad;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getValor_estimado() {
		return valor_estimado;
	}

	public void setValor_estimado(String valor_estimado) {
		this.valor_estimado = valor_estimado;
	}
	

	public int getId_tipo_vehiculo() {
		return id_tipo_vehiculo;
	}

	public void setId_tipo_vehiculo(int id_tipo_vehiculo) {
		this.id_tipo_vehiculo = id_tipo_vehiculo;
	}

	public int getId_modelo() {
		return id_modelo;
	}

	public void setId_modelo(int id_modelo) {
		this.id_modelo = id_modelo;
	}

	@Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + this.id;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final VehiculoDTO other = (VehiculoDTO) obj;
        return this.id == other.id;
    }
   
   

   
}
