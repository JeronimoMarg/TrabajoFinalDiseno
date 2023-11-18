package com.trabajofinal.models;

public class Pais {

   private int id;
   private String nombre;

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

   // Le agrego el constructor para poder probar el método main de provincia,
   // borrar luego
   public Pais(int id, String nombre) {
      this.id = id;
      this.nombre = nombre;
   }
}
