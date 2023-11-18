package com.trabajofinal.models;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Cliente {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_poliza")
    private int id;
    private String numero_cliente;
    private String numero_documento;
    private TipoDocumento tipo_documento;
    private String nombre;
    private String apellido;
    private TipoCondicion condicion;
    private Boolean activo;
    private LocalDate anio_registro;
    private String profesion;
    private String numero_cuil;
    private String email;
    private TipoCondicionIVA condicion_iva;
    private LocalDate fecha_nacimiento;
    private EstadoCivil estado_civil;
    private Boolean sexo;
    //private Domicilio domicilio;
    
    @OneToMany(mappedBy = "cliente")		//factores NO conoce a LAS polizaS
    private List<Poliza> polizas;

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
    public LocalDate getAnio_registro() {
        return anio_registro;
    }
    public void setAnio_registro(LocalDate anio_registro) {
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
    public Boolean getSexo() {
        return sexo;
    }
    public void setSexo(Boolean sexo) {
        this.sexo = sexo;
    }
    /*
    public Domicilio getDomicilio() {
        return domicilio;
    }
    public void setDomicilio(Domicilio domicilio) {
        this.domicilio = domicilio;
    }
    */
    


}
