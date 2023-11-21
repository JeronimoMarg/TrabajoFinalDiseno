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
   private TipoVehiculo tipo_vehiculo;

   @Override
   public String toString() {
      return "VehiculoDTO [id=" + id + ", motor=" + motor + ", chasis=" + chasis + ", patente=" + patente
            + ", kilometros_anio=" + kilometros_anio + ", en_garage=" + en_garage + ", con_alarma=" + con_alarma
            + ", con_rastreo=" + con_rastreo + ", con_tuerca_antirrobo=" + con_tuerca_antirrobo + ", tipo_vehiculo="
            + tipo_vehiculo + "]";
   }

   public int getId() {
      return id;
   }

   @Override
   public int hashCode() {
      final int prime = 31;
      int result = 1;
      result = prime * result + id;
      result = prime * result + ((motor == null) ? 0 : motor.hashCode());
      result = prime * result + ((chasis == null) ? 0 : chasis.hashCode());
      result = prime * result + ((patente == null) ? 0 : patente.hashCode());
      result = prime * result + kilometros_anio;
      result = prime * result + ((en_garage == null) ? 0 : en_garage.hashCode());
      result = prime * result + ((con_alarma == null) ? 0 : con_alarma.hashCode());
      result = prime * result + ((con_rastreo == null) ? 0 : con_rastreo.hashCode());
      result = prime * result + ((con_tuerca_antirrobo == null) ? 0 : con_tuerca_antirrobo.hashCode());
      result = prime * result + ((tipo_vehiculo == null) ? 0 : tipo_vehiculo.hashCode());
      return result;
   }

   @Override
   public boolean equals(Object obj) {
      if (this == obj)
         return true;
      if (obj == null)
         return false;
      if (getClass() != obj.getClass())
         return false;
      VehiculoDTO other = (VehiculoDTO) obj;
      if (id != other.id)
         return false;
      if (motor == null) {
         if (other.motor != null)
            return false;
      } else if (!motor.equals(other.motor))
         return false;
      if (chasis == null) {
         if (other.chasis != null)
            return false;
      } else if (!chasis.equals(other.chasis))
         return false;
      if (patente == null) {
         if (other.patente != null)
            return false;
      } else if (!patente.equals(other.patente))
         return false;
      if (kilometros_anio != other.kilometros_anio)
         return false;
      if (en_garage == null) {
         if (other.en_garage != null)
            return false;
      } else if (!en_garage.equals(other.en_garage))
         return false;
      if (con_alarma == null) {
         if (other.con_alarma != null)
            return false;
      } else if (!con_alarma.equals(other.con_alarma))
         return false;
      if (con_rastreo == null) {
         if (other.con_rastreo != null)
            return false;
      } else if (!con_rastreo.equals(other.con_rastreo))
         return false;
      if (con_tuerca_antirrobo == null) {
         if (other.con_tuerca_antirrobo != null)
            return false;
      } else if (!con_tuerca_antirrobo.equals(other.con_tuerca_antirrobo))
         return false;
      if (tipo_vehiculo == null) {
         if (other.tipo_vehiculo != null)
            return false;
      } else if (!tipo_vehiculo.equals(other.tipo_vehiculo))
         return false;
      return true;
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

   public TipoVehiculo getTipo_vehiculo() {
      return tipo_vehiculo;
   }

   public void setTipo_vehiculo(TipoVehiculo tipo_vehiculo) {
      this.tipo_vehiculo = tipo_vehiculo;
   }

}
