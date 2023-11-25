package com.trabajofinal.models;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "cliente")
public class Cliente {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   @Column(name = "id_cliente")
   private int id;

   @Column(name = "nro_cliente")
   private String numero_cliente;

   @Column(name = "nro_documento")
   private String numero_documento;

   @Enumerated(EnumType.STRING)
   @Column(name = "tipo_documento")
   private TipoDocumento tipo_documento;

   @Column(name = "nombre")
   private String nombre;

   @Column(name = "apellido")
   private String apellido;

   @Enumerated(EnumType.STRING)
   @Column(name = "condicion")
   private TipoCondicion condicion;

   @Column(name = "activo")
   private Boolean activo;

   // HAY QUE MODIFICAR!!! ACÁ VA UN INTEGER, NO UNA LocalDate!
   @Column(name = "anio_registro")
   private int anio_registro;

   @Column(name = "profesion")
   private String profesion;

   @Column(name = "numero_cuil")
   private String numero_cuil;

   @Column(name = "email")
   private String email;

   @Enumerated(EnumType.STRING)
   @Column(name = "condicion_iva")
   private TipoCondicionIVA condicion_iva;

   @Column(name = "fecha_nacimiento")
   private LocalDate fecha_nacimiento;

   @Enumerated(EnumType.STRING)
   @Column(name = "estado_civil")
   private EstadoCivil estado_civil;

   @Column(name = "sexo")
   private char sexo;

   @OneToOne(cascade = CascadeType.ALL)
   @JoinColumn(name = "id_domicilio")
   private Domicilio domicilio;

   public Cliente() {

   }

   public Cliente(String numero_cliente, String numero_documento, TipoDocumento tipo_documento, String nombre,
         String apellido, TipoCondicion condicion, Boolean activo, int anio_registro, String profesion,
         String numero_cuil, String email, TipoCondicionIVA condicion_iva, LocalDate fecha_nacimiento,
         EstadoCivil estado_civil, char sexo, Domicilio domicilio) {
      super();
      // this.id = id;
      this.numero_cliente = numero_cliente;
      this.numero_documento = numero_documento;
      this.tipo_documento = tipo_documento;
      this.nombre = nombre;
      this.apellido = apellido;
      this.condicion = condicion;
      this.activo = activo;
      this.anio_registro = anio_registro;
      this.profesion = profesion;
      this.numero_cuil = numero_cuil;
      this.email = email;
      this.condicion_iva = condicion_iva;
      this.fecha_nacimiento = fecha_nacimiento;
      this.estado_civil = estado_civil;
      this.sexo = sexo;
      this.domicilio = domicilio;
   }

   public int getId() {
      return id;
   }

   public void setId(int id) {
      this.id = id;
   }

   public String getNumero_cliente() {
      return numero_cliente;
   }

   public void setNumero_cliente(String numero_cliente) {
      this.numero_cliente = numero_cliente;
   }

   public String getNumero_documento() {
      return numero_documento;
   }

   public void setNumero_documento(String numero_documento) {
      this.numero_documento = numero_documento;
   }

   public TipoDocumento getTipo_documento() {
      return tipo_documento;
   }

   public void setTipo_documento(TipoDocumento tipo_documento) {
      this.tipo_documento = tipo_documento;
   }

   public String getNombre() {
      return nombre;
   }

   public void setNombre(String nombre) {
      this.nombre = nombre;
   }

   public String getApellido() {
      return apellido;
   }

   public void setApellido(String apellido) {
      this.apellido = apellido;
   }

   public TipoCondicion getCondicion() {
      return condicion;
   }

   public void setCondicion(TipoCondicion condicion) {
      this.condicion = condicion;
   }

   public Boolean getActivo() {
      return activo;
   }

   public void setActivo(Boolean activo) {
      this.activo = activo;
   }

   public int getAnio_registro() {
      return anio_registro;
   }

   public void setAnio_registro(int anio_registro) {
      this.anio_registro = anio_registro;
   }

   public String getProfesion() {
      return profesion;
   }

   public void setProfesion(String profesion) {
      this.profesion = profesion;
   }

   public String getNumero_cuil() {
      return numero_cuil;
   }

   public void setNumero_cuil(String numero_cuil) {
      this.numero_cuil = numero_cuil;
   }

   public String getEmail() {
      return email;
   }

   public void setEmail(String email) {
      this.email = email;
   }

   public TipoCondicionIVA getCondicion_iva() {
      return condicion_iva;
   }

   public void setCondicion_iva(TipoCondicionIVA condicion_iva) {
      this.condicion_iva = condicion_iva;
   }

   public LocalDate getFecha_nacimiento() {
      return fecha_nacimiento;
   }

   public void setFecha_nacimiento(LocalDate fecha_nacimiento) {
      this.fecha_nacimiento = fecha_nacimiento;
   }

   public EstadoCivil getEstado_civil() {
      return estado_civil;
   }

   public void setEstado_civil(EstadoCivil estado_civil) {
      this.estado_civil = estado_civil;
   }

   public char getSexo() {
      return sexo;
   }

   public void setSexo(char sexo) {
      this.sexo = sexo;
   }

   @Override
   public String toString() {
      return "Cliente [id=" + id + ", numero_cliente=" + numero_cliente + ", numero_documento=" + numero_documento
            + ", tipo_documento=" + tipo_documento + ", nombre=" + nombre + ", apellido=" + apellido + ", condicion="
            + condicion + ", activo=" + activo + ", anio_registro=" + anio_registro + ", profesion=" + profesion
            + ", numero_cuil=" + numero_cuil + ", email=" + email + ", condicion_iva=" + condicion_iva
            + ", fecha_nacimiento=" + fecha_nacimiento + ", estado_civil=" + estado_civil + ", sexo=" + sexo
            + ", domicilio=" + domicilio + "]";
   }

   /*
    * public Domicilio getDomicilio() {
    * return domicilio;
    * }
    * public void setDomicilio(Domicilio domicilio) {
    * this.domicilio = domicilio;
    * }
    */

}
