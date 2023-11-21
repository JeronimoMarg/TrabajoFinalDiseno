package com.trabajofinal.dto;

import java.time.LocalDate;

import com.trabajofinal.models.Domicilio;
import com.trabajofinal.models.EstadoCivil;
import com.trabajofinal.models.TipoCondicion;
import com.trabajofinal.models.TipoCondicionIVA;
import com.trabajofinal.models.TipoDocumento;

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
   private TipoCondicionIVA condicion_iva;
   private LocalDate fecha_nacimiento;
   private EstadoCivil estado_civil;
   private Boolean sexo;
   private Domicilio domicilio;
   private int cantidadSiniestros;

   @Override
   public String toString() {
      return "ClienteDTO [id=" + id + ", numero_cliente=" + numero_cliente + ", numero_documento=" + numero_documento
            + ", tipo_documento=" + tipo_documento + ", nombre=" + nombre + ", apellido=" + apellido + ", condicion="
            + condicion + ", activo=" + activo + ", anio_registro=" + anio_registro + ", profesion=" + profesion
            + ", numero_cuil=" + numero_cuil + ", email=" + email + ", condicion_iva=" + condicion_iva
            + ", fecha_nacimiento=" + fecha_nacimiento + ", estado_civil=" + estado_civil + ", sexo=" + sexo
            + ", domicilio=" + domicilio + "]";
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

   public Domicilio getDomicilio() {
      return domicilio;
   }

   public void setDomicilio(Domicilio domicilio) {
      this.domicilio = domicilio;
   }

   public int getAnio_registro() {
      return anio_registro;
   }

   public void setAnio_registro(int anio_registro) {
      this.anio_registro = anio_registro;
   }
   
   public int getCantidadSiniestros() {
	return cantidadSiniestros;
   }

   public void setCantidadSiniestros(int cantidadSiniestros) {
	   this.cantidadSiniestros = cantidadSiniestros;
   }

@Override
   public int hashCode() {
      final int prime = 31;
      int result = 1;
      result = prime * result + id;
      result = prime * result + ((numero_cliente == null) ? 0 : numero_cliente.hashCode());
      result = prime * result + ((numero_documento == null) ? 0 : numero_documento.hashCode());
      result = prime * result + ((tipo_documento == null) ? 0 : tipo_documento.hashCode());
      result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
      result = prime * result + ((apellido == null) ? 0 : apellido.hashCode());
      result = prime * result + ((condicion == null) ? 0 : condicion.hashCode());
      result = prime * result + ((activo == null) ? 0 : activo.hashCode());
      result = prime * result + anio_registro;
      result = prime * result + ((profesion == null) ? 0 : profesion.hashCode());
      result = prime * result + ((numero_cuil == null) ? 0 : numero_cuil.hashCode());
      result = prime * result + ((email == null) ? 0 : email.hashCode());
      result = prime * result + ((condicion_iva == null) ? 0 : condicion_iva.hashCode());
      result = prime * result + ((fecha_nacimiento == null) ? 0 : fecha_nacimiento.hashCode());
      result = prime * result + ((estado_civil == null) ? 0 : estado_civil.hashCode());
      result = prime * result + ((sexo == null) ? 0 : sexo.hashCode());
      result = prime * result + ((domicilio == null) ? 0 : domicilio.hashCode());
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
      ClienteDTO other = (ClienteDTO) obj;
      if (id != other.id)
         return false;
      if (numero_cliente == null) {
         if (other.numero_cliente != null)
            return false;
      } else if (!numero_cliente.equals(other.numero_cliente))
         return false;
      if (numero_documento == null) {
         if (other.numero_documento != null)
            return false;
      } else if (!numero_documento.equals(other.numero_documento))
         return false;
      if (tipo_documento != other.tipo_documento)
         return false;
      if (nombre == null) {
         if (other.nombre != null)
            return false;
      } else if (!nombre.equals(other.nombre))
         return false;
      if (apellido == null) {
         if (other.apellido != null)
            return false;
      } else if (!apellido.equals(other.apellido))
         return false;
      if (condicion != other.condicion)
         return false;
      if (activo == null) {
         if (other.activo != null)
            return false;
      } else if (!activo.equals(other.activo))
         return false;
      if (anio_registro != other.anio_registro)
         return false;
      if (profesion == null) {
         if (other.profesion != null)
            return false;
      } else if (!profesion.equals(other.profesion))
         return false;
      if (numero_cuil == null) {
         if (other.numero_cuil != null)
            return false;
      } else if (!numero_cuil.equals(other.numero_cuil))
         return false;
      if (email == null) {
         if (other.email != null)
            return false;
      } else if (!email.equals(other.email))
         return false;
      if (condicion_iva != other.condicion_iva)
         return false;
      if (fecha_nacimiento == null) {
         if (other.fecha_nacimiento != null)
            return false;
      } else if (!fecha_nacimiento.equals(other.fecha_nacimiento))
         return false;
      if (estado_civil != other.estado_civil)
         return false;
      if (sexo == null) {
         if (other.sexo != null)
            return false;
      } else if (!sexo.equals(other.sexo))
         return false;
      if (domicilio == null) {
         if (other.domicilio != null)
            return false;
      } else if (!domicilio.equals(other.domicilio))
         return false;
      return true;
   }

}
