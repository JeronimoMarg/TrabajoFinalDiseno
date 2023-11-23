package com.trabajofinal.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "pais")
public class Pais {

   @Id
   // @GeneratedValue(strategy = GenerationType.IDENTITY)
   @Column(name = "id_pais")
   private int id;

   @Column(name = "nombre")
   private String nombre;

   public Pais() {
   }

   public Pais(String nombre) {
      this.nombre = nombre;
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

}
