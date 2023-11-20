package com.trabajofinal.models;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Pago {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_pago")
    private int id;
	
	@Column(name = "numero_recibo")
    private int numero_recibo;
	
	@Column(name = "monto")
    private Double monto;
	
	@Column(name = "premio")
    private Double premio;
	
	@Column(name = "recargo_mora")
    private Double recargo_mora;
	
	@Column(name = "bonificacion_pago_adelantado")
    private Double bonificacion_pago_adelantado;
	
	@Column(name = "fecha_pago")
    private LocalDate fecha_pago;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_usuario")
    private Usuario operador;

    public Usuario getOperador() {
        return operador;
    }
    public void setOperador(Usuario operador) {
        this.operador = operador;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public int getNumero_recibo() {
        return numero_recibo;
    }
    public void setNumero_recibo(int numero_recibo) {
        this.numero_recibo = numero_recibo;
    }
    public Double getMonto() {
        return monto;
    }
    public void setMonto(Double monto) {
        this.monto = monto;
    }
    public Double getPremio() {
        return premio;
    }
    public void setPremio(Double premio) {
        this.premio = premio;
    }
    public Double getRecargo_mora() {
        return recargo_mora;
    }
    public void setRecargo_mora(Double recargo_mora) {
        this.recargo_mora = recargo_mora;
    }
    public Double getBonificacion_pago_adelantado() {
        return bonificacion_pago_adelantado;
    }
    public void setBonificacion_pago_adelantado(Double bonificacion_pago_adelantado) {
        this.bonificacion_pago_adelantado = bonificacion_pago_adelantado;
    }
    public LocalDate getFecha_pago() {
        return fecha_pago;
    }
    public void setFecha_pago(LocalDate fecha_pago) {
        this.fecha_pago = fecha_pago;
    }


}
