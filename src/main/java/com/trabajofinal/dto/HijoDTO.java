package com.trabajofinal.dto;

import java.time.LocalDate;
import com.trabajofinal.models.EstadoCivil;

public class HijoDTO {
   private int id;

   private LocalDate fecha_nacimiento;
   private Boolean sexo;	//1 es masculino
   private EstadoCivil estado_civil;

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

   @Override
   public int hashCode() {
      final int prime = 31;
      int result = 1;
      result = prime * result + id;
      result = prime * result + ((fecha_nacimiento == null) ? 0 : fecha_nacimiento.hashCode());
      result = prime * result + ((sexo == null) ? 0 : sexo.hashCode());
      result = prime * result + ((estado_civil == null) ? 0 : estado_civil.hashCode());
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
      HijoDTO other = (HijoDTO) obj;
      if (id != other.id)
         return false;
      if (fecha_nacimiento == null) {
         if (other.fecha_nacimiento != null)
            return false;
      } else if (!fecha_nacimiento.equals(other.fecha_nacimiento))
         return false;
      if (sexo == null) {
         if (other.sexo != null)
            return false;
      } else if (!sexo.equals(other.sexo))
         return false;
      if (estado_civil != other.estado_civil)
         return false;
      return true;
   }

   public void setEstado_civil(EstadoCivil estado_civil) {
      this.estado_civil = estado_civil;
   }

   @Override
   public String toString() {
      return "HijoDTO [id=" + id + ", fecha_nacimiento=" + fecha_nacimiento + ", sexo=" + sexo + ", estado_civil="
            + estado_civil + "]";
   }

}
