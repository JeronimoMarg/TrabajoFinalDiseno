package com.trabajofinal.gestores;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import com.trabajofinal.dto.ClienteDTO;
import com.trabajofinal.dto.HijoDTO;
import com.trabajofinal.dto.PolizaDTO;
import com.trabajofinal.dto.VehiculoDTO;
import com.trabajofinal.models.*;
import com.trabajofinal.utils.EntityManagerUtil;
import com.trabajofinal.dao.PolizaDao;
import com.trabajofinal.dao.ClienteDao;

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
	
	public void crearPoliza(PolizaDTO poliza, List<HijoDTO> hijos, ClienteDTO cliente, VehiculoDTO vehiculo) {
		
		if(validarLogica()) {
			
			Poliza polizaNueva = new Poliza();
			polizaNueva.setFecha_inicio_vigencia(poliza.getFechaInicioVigencia());
			polizaNueva.setForma_pago(poliza.getTipoPago());
			polizaNueva.setCobertura_poliza(obtenerFactoresTipoCobertura(poliza.getTipoCobertura()));
			polizaNueva.setFactores_generacion(obtenerFactoresCaracteristicas());
			polizaNueva.setDescuentos(poliza.getDescuentos().doubleValue());
			polizaNueva.setDerechosEmision(poliza.getDerechos_emision().doubleValue());
			polizaNueva.setPremio(poliza.getPremio().doubleValue());
			polizaNueva.setCantidad_siniestros(cliente.getCantidadSiniestros());
			polizaNueva.setEstado(TipoEstadoPoliza.GENERADA);
			polizaNueva.setCliente(obtenerCliente(cliente));
			setearHijos(hijos, polizaNueva);
			polizaNueva.setLocalidad(obtenerLocalidad(poliza));
			polizaNueva.setFactor_riesgo_localidad(obtenerFactorRiesgoLocalidad(poliza));
			polizaNueva.setFactores_vehiculo(obtenerFactoresVehiculo(vehiculo));
			polizaNueva.setFactores_modelo(obtenerFactoresModelo(vehiculo));
			polizaNueva.setVehiculo_asegurado(obtenerVehiculo(vehiculo));
			
			actualizarEstadoCliente(cliente, poliza);
			setearCuotas(poliza, polizaNueva);
			guardar(polizaNueva);
			
            System.out.println("Poliza creada con exito!" + polizaNueva);
			
		}
		
		
		
	}
	
	private boolean validarLogica() {
		
		boolean bool = true;
		
		//metodo de validarLogica para la poliza que va a ser creada
		
		return bool;
	}
	
    public void calcularPremioDerechosDescuentos(PolizaDTO poliza) {
    	
    	poliza.setDerechos_emision(1000);
    	poliza.setPremio(5000);
    	poliza.setDescuentos(500);
    	
    }
	
	private FactoresTipoCobertura obtenerFactoresTipoCobertura(TipoCobertura tipo) {
		
		GestorFactoresCaracteristicas gestor = GestorFactoresCaracteristicas.getInstance();
		FactoresTipoCobertura factorCobertura = gestor.obtenerFactoresTipoCobertura(tipo);
		return factorCobertura;
		
	}
	
	private FactoresCaracteristicas obtenerFactoresCaracteristicas() {
		
		GestorFactoresCaracteristicas gestor = GestorFactoresCaracteristicas.getInstance();
		FactoresCaracteristicas factoresCaracteristicas = gestor.obtenerFactoresCaracteristicas();
		return factoresCaracteristicas;
		
	}
	
	private void setearHijos(List<HijoDTO> hijos, Poliza polizaNueva) {
		
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
	
	private FactorRiesgoLocalidad obtenerFactorRiesgoLocalidad(PolizaDTO poliza) {
		
		GestorFactoresCaracteristicas gestor = GestorFactoresCaracteristicas.getInstance();
		FactorRiesgoLocalidad factoresLocalidad = gestor.obtenerFactoresLocalidad(poliza.getLocalidad());
		return factoresLocalidad;
		
	}
	
	private FactoresVehiculo obtenerFactoresVehiculo(VehiculoDTO vehiculo) {
		
		GestorFactoresCaracteristicas gestor = GestorFactoresCaracteristicas.getInstance();
		FactoresVehiculo factoresVehiculo = gestor.obtenerFactoresVehiculo(vehiculo.getModelo());
		return factoresVehiculo;
		
	}
	
	private FactoresModelo obtenerFactoresModelo(VehiculoDTO vehiculo) {
		
		GestorFactoresCaracteristicas gestor = GestorFactoresCaracteristicas.getInstance();
		FactoresModelo factoresModelo = gestor.obtenerFactoresModelo(vehiculo.getModelo());
		return factoresModelo;
		
	}
	
	private Vehiculo obtenerVehiculo(VehiculoDTO vehiculo) {
		
		GestorVehiculos gestor = GestorVehiculos.getInstance();
		Vehiculo v = gestor.crearVehiculo(vehiculo);
		return v;
		
	}
	
	private Cliente obtenerCliente(ClienteDTO cliente_dto) {
		
		GestorClientes gestor = GestorClientes.getInstance();
		Cliente cliente = gestor.obtenerCliente(cliente_dto.getId());
		return cliente;
		
	}
	
	private void actualizarEstadoCliente(ClienteDTO cliente_dto, PolizaDTO poliza) {
		
		/*
		 * Si la póliza es la primera que se le asocia al cliente, pasa a ser
			considerado un cliente “Normal”.
			
			Si el cliente poseía otras pólizas asociadas pero ninguna de ellas se
			encuentra vigente el cliente debe considerarse “Normal”.
			
			Si el cliente posee siniestros en el último año o posee alguna cuota
			impaga o no ha sido un cliente “activo” ininterrumpido al menos por
			los dos últimos años debe ser considerado un cliente “Normal”.
			
			Si el cliente no posee siniestros en el último año y no posee cuotas
			impagas, como así también el mismo hace al menos 2 años que es
			cliente “activo” ininterrumpido de la compañía, el mismo es
			considerado un cliente “Plata”
			
		 */
		
		ClienteDao daocliente = new ClienteDao();
		
		
		
		
	}
	
	private void guardar(Poliza poliza) {
		
		PolizaDao polizaDao = new PolizaDao();
		polizaDao.save(poliza);
		//System.out.println("Polizas: " + polizaDao.getAll());
		
	}

}
