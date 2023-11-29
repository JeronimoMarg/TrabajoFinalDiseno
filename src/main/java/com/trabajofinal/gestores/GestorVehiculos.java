package com.trabajofinal.gestores;

import com.trabajofinal.dto.PolizaDTO;
import com.trabajofinal.dto.VehiculoDTO;
import com.trabajofinal.models.TipoVehiculo;
import com.trabajofinal.models.Vehiculo;
import com.trabajofinal.dao.TipoVehiculoDao;

public class GestorVehiculos {
	
	private static GestorVehiculos instance;

	private GestorVehiculos() {
		
	}
	
	public static GestorVehiculos getInstance() {
		if(instance == null) {
			instance = new GestorVehiculos();
		}
		return instance;
	}

	public Vehiculo crearVehiculo(VehiculoDTO vehiculo) {

		Vehiculo v = new Vehiculo();
		v.setChasis(vehiculo.getChasis());
		v.setCon_alarma(vehiculo.getCon_alarma());
		v.setCon_rastreo(vehiculo.getCon_rastreo());
		v.setCon_tuerca_antirrobo(vehiculo.getCon_tuerca_antirrobo());
		v.setEn_garage(vehiculo.getEn_garage());
		v.setId(vehiculo.getId());
		v.setKilometros_anio(vehiculo.getKilometros_anio());
		v.setMotor(vehiculo.getMotor());
		v.setPatente(vehiculo.getPatente());
		v.setTipo_vehiculo(obtenerTipoVehiculo(vehiculo));
		
		return v;
	}
	
	private TipoVehiculo obtenerTipoVehiculo(VehiculoDTO vehiculo) {
		
		TipoVehiculoDao dao = new TipoVehiculoDao();
		return dao.getTipoVehiculoPorNombre(vehiculo.getModelo());
	}

}
