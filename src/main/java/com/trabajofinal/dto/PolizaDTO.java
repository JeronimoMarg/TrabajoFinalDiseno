package com.trabajofinal.dto;

import java.util.List;
import java.util.Date;

import com.trabajofinal.models.TipoCobertura;
import com.trabajofinal.models.TipoPago;
import com.trabajofinal.models.Cuota;

public class PolizaDTO {

   private String localidad;
   private int id_localidad;
   private Date fechaInicioVigencia;
   private TipoPago tipoPago;
   private TipoCobertura tipoCobertura;
   private Double dto_pago_semestral;
   private Double dto_antiguedad;
   private Double dto_mas_un_vehiculo;
   private Double derechos_emision;
   private Double premio;
   private Double monto_a_pagar;

   private List<Cuota> cuotas;

   public List<Cuota> getCuotas() {
      return cuotas;
   }

   public void setCuotas(List<Cuota> cuotas) {
      this.cuotas = cuotas;
   }

   public String getLocalidad() {
      return localidad;
   }

   public void setLocalidad(String localidad) {
      this.localidad = localidad;
   }

   public Date getFechaInicioVigencia() {
      return fechaInicioVigencia;
   }

   public void setFechaInicioVigencia(Date fechaInicioVigencia) {
      this.fechaInicioVigencia = fechaInicioVigencia;
   }

   public TipoPago getTipoPago() {
      return tipoPago;
   }

   public void setTipoPago(TipoPago tipoPago) {
      this.tipoPago = tipoPago;
   }

   public TipoCobertura getTipoCobertura() {
      return tipoCobertura;
   }

   public void setTipoCobertura(TipoCobertura tipoCobertura) {
      this.tipoCobertura = tipoCobertura;
   }

   public Double getDerechos_emision() {
      return derechos_emision;
   }

   public void setDerechos_emision(Double derechos_emision) {
      this.derechos_emision = derechos_emision;
   }

   public Double getPremio() {
      return premio;
   }

   public void setPremio(Double premio) {
      this.premio = premio;
   }

   public Double getDto_pago_semestral() {
      return dto_pago_semestral;
   }

   public void setDto_pago_semestral(Double dto_pago_semestral) {
      this.dto_pago_semestral = dto_pago_semestral;
   }

   public Double getDto_antiguedad() {
      return dto_antiguedad;
   }

   public void setDto_antiguedad(Double dto_antiguedad) {
      this.dto_antiguedad = dto_antiguedad;
   }

   public Double getDto_mas_un_vehiculo() {
      return dto_mas_un_vehiculo;
   }

   public void setDto_mas_un_vehiculo(Double dto_mas_un_vehiculo) {
      this.dto_mas_un_vehiculo = dto_mas_un_vehiculo;
   }

   public Double getMonto_a_pagar() {
      return monto_a_pagar;
   }

   public void setMonto_a_pagar(Double monto_a_pagar) {
      this.monto_a_pagar = monto_a_pagar;
   }

   public int getId_localidad() {
	return id_localidad;
   }

   public void setId_localidad(int id_localidad) {
	this.id_localidad = id_localidad;
	}

}
