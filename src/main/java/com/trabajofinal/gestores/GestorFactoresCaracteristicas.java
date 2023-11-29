package com.trabajofinal.gestores;

import com.trabajofinal.dto.PolizaDTO;
import com.trabajofinal.dto.VehiculoDTO;
import com.trabajofinal.models.FactorRiesgoLocalidad;
import com.trabajofinal.models.FactoresCaracteristicas;
import com.trabajofinal.models.FactoresModelo;
import com.trabajofinal.models.FactoresTipoCobertura;
import com.trabajofinal.models.FactoresVehiculo;
import com.trabajofinal.models.Localidad;
import com.trabajofinal.models.TipoCobertura;
import com.trabajofinal.dao.FactoresTipoCoberturaDao;
import com.trabajofinal.dao.FactoresCaracteristicasDao;
import com.trabajofinal.dao.FactorRiesgoLocalidadDao;

public class GestorFactoresCaracteristicas {
	
	private static GestorFactoresCaracteristicas instance;

	private GestorFactoresCaracteristicas() {
		
	}
	
	public static GestorFactoresCaracteristicas getInstance() {
		if(instance == null) {
			instance = new GestorFactoresCaracteristicas();
		}
		return instance;
	}

	public FactoresTipoCobertura obtenerFactoresTipoCobertura(TipoCobertura tipo) {
		
		FactoresTipoCoberturaDao dao = new FactoresTipoCoberturaDao();
		return dao.getUltimoFactor(tipo);
	}

	public FactoresCaracteristicas obtenerFactoresCaracteristicas() {
		FactoresCaracteristicasDao dao = new FactoresCaracteristicasDao();
		return dao.getUltimoFactor();
	}

	public FactorRiesgoLocalidad obtenerFactoresLocalidad(String localidad) {
		
		FactorRiesgoLocalidadDao dao = new FactorRiesgoLocalidadDao();
		return dao.getUltimoFactorLocalidad(localidad);
	}

	public FactoresVehiculo obtenerFactoresVehiculo(VehiculoDTO vehiculo) {
		//retorna el factorVehiculo para un vehiculo en particular.
		//el dto tiene marca, modelo, anio
		return null;
	}

	public FactoresModelo obtenerFactoresModelo(VehiculoDTO vehiculo) {
		//retorna el factorModelo para un modelo en particular
		//el dto tiene modelo
		return null;
	}

}
