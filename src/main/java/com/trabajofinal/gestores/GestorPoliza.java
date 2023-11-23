package com.trabajofinal.gestores;

import java.util.ArrayList;
import java.util.HashSet;

import com.trabajofinal.dto.ClienteDTO;
import com.trabajofinal.dto.HijoDTO;
import com.trabajofinal.dto.PolizaDTO;
import com.trabajofinal.dto.VehiculoDTO;
import com.trabajofinal.models.*;
import com.trabajofinal.utils.EntityManagerUtil;
import com.trabajofinal.dao.PolizaDao;

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
	
	private void crearPoliza(PolizaDTO poliza, ArrayList<HijoDTO> hijos, ClienteDTO cliente, VehiculoDTO vehiculo) {
		
		if(validarLogica()) {
			
			Poliza polizaNueva = new Poliza();
			polizaNueva.setFecha_inicio_vigencia(poliza.getFechaInicioVigencia());
			polizaNueva.setForma_pago(poliza.getTipoPago());
			polizaNueva.setCobertura_poliza(obtenerFactoresTipoCobertura());
			polizaNueva.setFactores_generacion(obtenerFactoresCaracteristicas());
			polizaNueva.setDescuentos(calcularDescuentos());
			polizaNueva.setDerechosEmision(calcularDerechosEmision());
			polizaNueva.setPremio(calcularPremio());
			polizaNueva.setCantidad_siniestros(cliente.getCantidadSiniestros());
			polizaNueva.setEstado(TipoEstadoPoliza.GENERADA);
			polizaNueva.setCliente(obtenerCliente(cliente));
			setearHijos(hijos, polizaNueva);
			setearCuotas(poliza, polizaNueva);
			polizaNueva.setLocalidad(obtenerLocalidad(poliza));
			polizaNueva.setFactor_riesgo_localidad(obtenerFactorRiesgoLocalidad(polizaNueva.getLocalidad()));
			polizaNueva.setFactores_vehiculo(obtenerFactoresVehiculo(poliza));
			polizaNueva.setFactores_modelo(obtenerFactoresModelo(poliza));
			polizaNueva.setVehiculo_asegurado(obtenerVehiculo(poliza));
			actualizarEstadoCliente(cliente, poliza);
			guardar(polizaNueva);
			
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
	
	private void setearHijos(ArrayList<HijoDTO> hijos, Poliza polizaNueva) {
		
		for(int i=0; i<hijos.size(); i++) {
			HijoDTO actual = hijos.get(i);
			Hijo nuevo = new Hijo(actual.getFecha_nacimiento(), actual.getSexo(), actual.getEstado_civil());
			polizaNueva.getHijos().add(nuevo);
		}
		
	}
	
	private void setearCuotas(PolizaDTO poliza, Poliza polizaNueva) {
		
		int iteraciones = 0;
		if (poliza.getTipoPago() == TipoPago.MENSUAL) {
			iteraciones = 6;
		}else {
			iteraciones = 1;
		}
		
		for(int i=0; i<iteraciones; i++) {
			Cuota nueva = new Cuota(polizaNueva.getPremio(), poliza.getTipoPago());
			polizaNueva.getCuotas().add(nueva);
		}
		
	}
	
	private Localidad obtenerLocalidad(PolizaDTO poliza) {
		
		GestorLocalidad gestor = GestorLocalidad.getInstance();
		Localidad localidad = gestor.obtenerLocalidad(poliza.getLocalidad());
		return localidad;
		
	}
	
	private FactorRiesgoLocalidad obtenerFactorRiesgoLocalidad(Localidad localidad) {
		
		GestorFactoresCaracteristicas gestor = GestorFactoresCaracteristicas.getInstance();
		FactorRiesgoLocalidad factoresLocalidad = gestor.obtenerFactoresLocalidad(localidad);
		return factoresLocalidad;
		
	}
	
	private FactoresVehiculo obtenerFactoresVehiculo(PolizaDTO poliza) {
		
		GestorFactoresCaracteristicas gestor = GestorFactoresCaracteristicas.getInstance();
		FactoresVehiculo factoresVehiculo = gestor.obtenerFactoresVehiculo(poliza);
		return factoresVehiculo;
		
	}
	
	private FactoresModelo obtenerFactoresModelo(PolizaDTO poliza) {
		
		GestorFactoresCaracteristicas gestor = GestorFactoresCaracteristicas.getInstance();
		FactoresModelo factoresModelo = gestor.obtenerFactoresModelo(poliza);
		return factoresModelo;
		
	}
	
	private Vehiculo obtenerVehiculo(PolizaDTO poliza) {
		
		GestorVehiculos gestor = GestorVehiculos.getInstance();
		Vehiculo vehiculo = gestor.crearVehiculo(poliza);
		return vehiculo;
		
	}
	
	private Cliente obtenerCliente(ClienteDTO cliente_dto) {
		
		GestorClientes gestor = GestorClientes.getInstance();
		Cliente cliente = gestor.obtenerCliente(cliente_dto);
		return cliente;
		
	}
	
	private void actualizarEstadoCliente(ClienteDTO cliente_dto, PolizaDTO poliza) {
		
		Cliente cliente = obtenerCliente(cliente_dto);
		//obtener del PolizaDAO una lista de polizas. O directamente el count;
		int cantidadPolizasCliente = 0; 	//aca iria seteado con el count;
		
		GestorClientes gestor = GestorClientes.getInstance();
		gestor.actualizarEstado(cliente, cantidadPolizasCliente, cliente_dto.getCantidadSiniestros());
		
	}
	
	private void guardar(Poliza poliza) {
		
		PolizaDao polizaDao = new PolizaDao();
		polizaDao.save(poliza);
		System.out.println("Polizas: " + polizaDao.getAll());
		
	}

}
