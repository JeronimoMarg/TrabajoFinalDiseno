package com.trabajofinal.models;

import jakarta.persistence.CascadeType;
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

@Table(name = "domicilio")
public class Domicilio {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   @Column(name = "id_domicilio")
   private int id;

   @Column(name = "codigo_postal")
   private String codigo_postal;

   @Column(name = "numero_calle")
   private int numero_calle;

   @Column(name = "nombre_calle")
   private String nombre_calle;

   @Column(name = "es_departamento")
   private Boolean es_departamento;

   @Column(name = "piso")
   private int piso;

   @Column(name = "departamento")
   private String departamento;

   @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
   @JoinColumn(name = "id_localidad")
   private Localidad localidad;

   public Domicilio() {

   }

   public Domicilio(String codigo_postal, int numero_calle, String nombre_calle, Boolean es_departamento, int piso,
         String departamento, Localidad localidad) {
      super();
      // this.id = id;
      this.codigo_postal = codigo_postal;
      this.numero_calle = numero_calle;
      this.nombre_calle = nombre_calle;
      this.es_departamento = es_departamento;
      this.piso = piso;
      this.departamento = departamento;
      this.localidad = localidad;
   }

   public int getId() {
      return id;
   }

   public void setId(int id) {
      this.id = id;
   }

   public String getCodigo_postal() {
      return codigo_postal;
   }

   public void setCodigo_postal(String codigo_postal) {
      this.codigo_postal = codigo_postal;
   }

   public int getNumero_calle() {
      return numero_calle;
   }

   public void setNumero_calle(int numero_calle) {
      this.numero_calle = numero_calle;
   }

   public String getNombre_calle() {
      return nombre_calle;
   }

   public void setNombre_calle(String nombre_calle) {
      this.nombre_calle = nombre_calle;
   }

   public Boolean getEs_departamento() {
      return es_departamento;
   }

   public void setEs_departamento(Boolean es_departamento) {
      this.es_departamento = es_departamento;
   }

   public int getPiso() {
      return piso;
   }

   public void setPiso(int piso) {
      this.piso = piso;
   }

   public String getDepartamento() {
      return departamento;
   }

   public void setDepartamento(String departamento) {
      this.departamento = departamento;
   }

   public Localidad getLocalidad() {
      return localidad;
   }

   public void setLocalidad(Localidad localidad) {
      this.localidad = localidad;
   }
}
