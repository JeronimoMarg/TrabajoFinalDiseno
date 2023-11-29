package com.trabajofinal.models;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "siniestros_conductor")
public class SiniestrosConductor {
	
	//esta clase "simula" lo que es el subsistema de siniestros.
	//como este subsistema no esta presente, lo simbolizamos como una tabla en nuestra BD
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_siniestros_conductor")
	private int id;
	
	@OneToOne
	@JoinColumn(name = "id_cliente")
	private Cliente cliente;
	
	@Column(name = "numero")
	private int numero_siniestros;

	public SiniestrosConductor() {
		
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public int getNumero_siniestros() {
		return numero_siniestros;
	}

	public void setNumero_siniestros(int numero_siniestros) {
		this.numero_siniestros = numero_siniestros;
	}

	public SiniestrosConductor(Cliente cliente, int numero_siniestros) {
		super();
		this.cliente = cliente;
		this.numero_siniestros = numero_siniestros;
	}
	
	

}
