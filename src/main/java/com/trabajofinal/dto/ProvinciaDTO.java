package com.trabajofinal.dto;

import com.trabajofinal.models.Pais;

public class ProvinciaDTO {

   private int id;
   private String nombre;
   private Pais pais;

   
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
   public Pais getPais() {
      return pais;
      //coso
   }
   public void setPais(Pais pais) {
      this.pais = pais;
   }
   @Override
   public int hashCode() {
      final int prime = 31;
      int result = 1;
      result = prime * result + id;
      result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
      result = prime * result + ((pais == null) ? 0 : pais.hashCode());
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
      ProvinciaDTO other = (ProvinciaDTO) obj;
      if (id != other.id)
         return false;
      if (nombre == null) {
         if (other.nombre != null)
            return false;
      } else if (!nombre.equals(other.nombre))
         return false;
      if (pais == null) {
         if (other.pais != null)
            return false;
      } else if (!pais.equals(other.pais))
         return false;
      return true;
   }
   @Override
   public String toString() {
      return "ProvinciaDTO [nombre=" + nombre + "]";
   }    
}
