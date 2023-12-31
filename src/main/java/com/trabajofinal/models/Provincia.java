package com.trabajofinal.models;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "provincia")
public class Provincia {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   @Column(name = "id_provincia")
   private int id;

   @Column(name = "nombre")
   private String nombre;

   @ManyToOne(fetch = FetchType.LAZY)
   @JoinColumn(name = "id_pais")
   private Pais pais;

   public Provincia() {
   }

   public Provincia(String nombre, Pais pais) {
      this.nombre = nombre;
      this.pais = pais;
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

   public Pais getPais() {
      return pais;
   }

   public void setPais(Pais pais) {
      this.pais = pais;
   }

@Override
public String toString() {
	return "Provincia [id=" + id + ", nombre=" + nombre + ", pais=" + pais + "]";
}
   
   

}
