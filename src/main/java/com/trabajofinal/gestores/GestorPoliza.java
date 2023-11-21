package com.trabajofinal.gestores;

import java.util.HashSet;

import com.trabajofinal.dto.ClienteDTO;
import com.trabajofinal.dto.HijoDTO;
import com.trabajofinal.dto.PolizaDTO;
import com.trabajofinal.models.*;

public class GestorPoliza {
	
	private static GestorPoliza instance;
	private HashSet<Poliza> polizas;
	
	private GestorPoliza() {
		
	}
	
	public static GestorPoliza getInstance() {
		if(instance == null) {
			instance = new GestorPoliza();
		}
		return instance;
	}
	
	private void crearPoliza(PolizaDTO poliza, HashSet<HijoDTO> hijos, ClienteDTO cliente) {
		
		if(validarLogica()) {
			
			Poliza polizaNueva = new Poliza();
			polizaNueva.setFechaInicioVigencia(PolizaDTO.getFechaInicio());
			polizaNueva.setTipoPago(PolizaDTO.getTipoPago());
			polizaNueva.setFactoresTipoCobertura(obtenerFactoresTipoCobertura());
			polizaNueva.setFactoresCaracteristicas(obtenerFactoresCaracteristicas());
			polizaNueva.setDescuentos(calcularDescuentos());
			polizaNueva.setDerechosEmision(calcularDerechosEmision());
			polizaNueva.setPremio(calcularPremio());
			polizaNueva.setCantidad_siniestros(PolizaDTO.setCantidadSiniestros());
			polizaNueva.setEstado(TipoEstadoPoliza.GENERADA);
			polizaNueva.setCliente(ClienteDTO.getId());
			setearHijos(hijos, polizaNueva);
			setearCuotas(PolizaDTO.getFormaPago(), polizaNueva);
			
			
		}
		
	}
	
	private boolean validarLogica() {
		
		boolean bool = true;
		
		//metodo de validarLogica para la poliza que va a ser creada
		
		return bool;
	}
	
	private FactoresTipoCobertura obtenerFactoresTipoCobertura() {
		
		GestorFactoresCaracteristicas gestor = GestorFactoresCaracteristicas.getInstance();
		FactoresTipoCobertura factorCobertura = gestor.obtenerFactoresTipoCobertura();
		return factorCobertura;
		
	}
	
	private FactoresCaracteristicas obtenerFactoresCaracteristicas() {
		
		GestorFactoresCaracteristicas gestor = GestorFactoresCaracteristicas.getInstance();
		FactoresCaracteristicas factoresCaracteristicas = gestor.obtenerFactoresCaracteristicas();
		return factoresCaracteristicas;
		
	}
	
	private Double calcularPremio() {
		//calcula el premio de la poliza y lo retorna
		return null;
	}
	
	private Double calcularDerechosEmision() {
		//calcula los derechos de emision y retorna
		return null;
	}
	
	private Double calcularDescuentos() {
		//calcula los descuentos y retorna
		return null;
	}
	
	private Cliente obtenerCliente(int id) {
		
		GestorClientes gestor = GestorClientes.getInstance();
		Cliente cliente = gestor.obtenerCliente(id);
		return cliente;
		
	}
	
	private void setearHijos(HashSet<HijoDTO> hijos, Poliza polizaNueva) {
		
		//para cada hijo en la lista, crearlo, setearlo a poliza (add).
		
	}
	
	private void setearCuotas(int formaDePago, Poliza polizaNueva) {
		
		//dependiendo del int, crear 1 o 6 cuotas y setearlo a poliza (add).
		
	}

}
