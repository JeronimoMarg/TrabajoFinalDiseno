package com.trabajofinal.dto;

import com.trabajofinal.models.EstadoCivil;
import com.trabajofinal.models.TipoCondicion;
import com.trabajofinal.models.TipoCondicionIVA;
import java.time.LocalDate;

import com.trabajofinal.models.TipoDocumento;
import java.util.Objects;

public class ClienteDTO {

    private int id;

    private String numero_cliente;
    private String numero_documento;
    private TipoDocumento tipo_documento;
    private String nombre;
    private String apellido;
    private TipoCondicion condicion;
    private Boolean activo;
    private int anio_registro;
    private String profesion;
    private String numero_cuil;
    private String email;
    //private String condicion_iva;
    private TipoCondicionIVA condicion_iva;
    private LocalDate fecha_nacimiento;
    //private String estado_civil;
    private EstadoCivil estado_civil;
    private char sexo;
    private String calle;
    private String cod_postal;
    private int nro;
    private int piso;
    private String departamento;
    //private Domicilio domicilio;
    private int cantidadSiniestros;
    private String provincia;
    private String pais;
    private String localidad;

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

    public LocalDate getFecha_nacimiento() {
        return fecha_nacimiento;
    }

    public void setFecha_nacimiento(LocalDate fecha_nacimiento) {
        this.fecha_nacimiento = fecha_nacimiento;
    }

    public char getSexo() {
        return sexo;
    }

    public void setSexo(char sexo) {
        this.sexo = sexo;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public String getCod_postal() {
        return cod_postal;
    }

    public void setCod_postal(String cod_postal) {
        this.cod_postal = cod_postal;
    }

    public int getNro() {
        return nro;
    }

    public void setNro(int nro) {
        this.nro = nro;
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

    public int getCantidadSiniestros() {
        return cantidadSiniestros;
    }

    public void setCantidadSiniestros(int cantidadSiniestros) {
        this.cantidadSiniestros = cantidadSiniestros;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getLocalidad() {
        return localidad;
    }

    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }

    public TipoCondicion getCondicion() {
        return condicion;
    }

    public void setCondicion(TipoCondicion condicion) {
        this.condicion = condicion;
    }

    public TipoCondicionIVA getCondicion_iva() {
        return condicion_iva;
    }

    public void setCondicion_iva(TipoCondicionIVA condicion_iva) {
        this.condicion_iva = condicion_iva;
    }

    public EstadoCivil getEstado_civil() {
        return estado_civil;
    }

    public void setEstado_civil(EstadoCivil estado_civil) {
        this.estado_civil = estado_civil;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 37 * hash + this.id;
        hash = 37 * hash + Objects.hashCode(this.numero_cliente);
        hash = 37 * hash + Objects.hashCode(this.numero_documento);
        hash = 37 * hash + Objects.hashCode(this.tipo_documento);
        hash = 37 * hash + Objects.hashCode(this.nombre);
        hash = 37 * hash + Objects.hashCode(this.apellido);
        hash = 37 * hash + Objects.hashCode(this.condicion);
        hash = 37 * hash + Objects.hashCode(this.activo);
        hash = 37 * hash + this.anio_registro;
        hash = 37 * hash + Objects.hashCode(this.profesion);
        hash = 37 * hash + Objects.hashCode(this.numero_cuil);
        hash = 37 * hash + Objects.hashCode(this.email);
        hash = 37 * hash + Objects.hashCode(this.condicion_iva);
        hash = 37 * hash + Objects.hashCode(this.fecha_nacimiento);
        hash = 37 * hash + Objects.hashCode(this.estado_civil);
        hash = 37 * hash + Objects.hashCode(this.sexo);
        hash = 37 * hash + Objects.hashCode(this.calle);
        hash = 37 * hash + Objects.hashCode(this.cod_postal);
        hash = 37 * hash + this.nro;
        hash = 37 * hash + Objects.hashCode(this.piso);
        hash = 37 * hash + Objects.hashCode(this.departamento);
        hash = 37 * hash + this.cantidadSiniestros;
        hash = 37 * hash + Objects.hashCode(this.provincia);
        hash = 37 * hash + Objects.hashCode(this.pais);
        hash = 37 * hash + Objects.hashCode(this.localidad);
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
        final ClienteDTO other = (ClienteDTO) obj;
        if (this.id != other.id) {
            return false;
        }
        if (this.anio_registro != other.anio_registro) {
            return false;
        }
        if (this.nro != other.nro) {
            return false;
        }
        if (this.cantidadSiniestros != other.cantidadSiniestros) {
            return false;
        }
        if (!Objects.equals(this.numero_cliente, other.numero_cliente)) {
            return false;
        }
        if (!Objects.equals(this.numero_documento, other.numero_documento)) {
            return false;
        }
        if (!Objects.equals(this.nombre, other.nombre)) {
            return false;
        }
        if (!Objects.equals(this.apellido, other.apellido)) {
            return false;
        }
        if (!Objects.equals(this.profesion, other.profesion)) {
            return false;
        }
        if (!Objects.equals(this.numero_cuil, other.numero_cuil)) {
            return false;
        }
        if (!Objects.equals(this.email, other.email)) {
            return false;
        }
        if (!Objects.equals(this.calle, other.calle)) {
            return false;
        }
        if (!Objects.equals(this.cod_postal, other.cod_postal)) {
            return false;
        }
        if (!Objects.equals(this.piso, other.piso)) {
            return false;
        }
        if (!Objects.equals(this.departamento, other.departamento)) {
            return false;
        }
        if (!Objects.equals(this.provincia, other.provincia)) {
            return false;
        }
        if (!Objects.equals(this.pais, other.pais)) {
            return false;
        }
        if (!Objects.equals(this.localidad, other.localidad)) {
            return false;
        }
        if (this.tipo_documento != other.tipo_documento) {
            return false;
        }
        if (this.condicion != other.condicion) {
            return false;
        }
        if (!Objects.equals(this.activo, other.activo)) {
            return false;
        }
        if (this.condicion_iva != other.condicion_iva) {
            return false;
        }
        if (!Objects.equals(this.fecha_nacimiento, other.fecha_nacimiento)) {
            return false;
        }
        if (this.estado_civil != other.estado_civil) {
            return false;
        }
        return Objects.equals(this.sexo, other.sexo);
    }

    @Override
    public String toString() {
        return "ClienteDTO{" + "provincia=" + provincia + ", pais=" + pais + ", localidad=" + localidad + '}';
    }
   
}
