package com.trabajofinal.models;

import java.util.HashSet;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;


@Entity
public class CuotaPago {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_cuota_pago")
	private int id;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "id_pago")
	private Pago pago;
	
	@ManyToOne
    @JoinColumn(name = "cuota_id")
    private Cuota cuota;
	
    @Column(name = "recargo_mora")
    private Double recargo_mora;

    @Column(name = "bonificacion_pago_adelantado")
    private Double bonificacion_pago_adelantado;

    public CuotaPago() {
    	
    }
    
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Pago getPago() {
		return pago;
	}

	public void setPago(Pago pago) {
		this.pago = pago;
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
	

}
