package com.trabajofinal.gestores;

import com.trabajofinal.dto.PolizaDTO;
import com.trabajofinal.models.FactorRiesgoLocalidad;
import com.trabajofinal.models.FactoresCaracteristicas;
import com.trabajofinal.models.FactoresModelo;
import com.trabajofinal.models.FactoresTipoCobertura;
import com.trabajofinal.models.FactoresVehiculo;
import com.trabajofinal.models.Localidad;

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

	public FactoresTipoCobertura obtenerFactoresTipoCobertura() {
		//retorna el factorTipoCobertura actual
		return null;
	}

	public FactoresCaracteristicas obtenerFactoresCaracteristicas() {
		//retorna el factorCaracteristicas actual
		return null;
	}

	public FactorRiesgoLocalidad obtenerFactoresLocalidad(Localidad localidad) {
		//retorna el factorRiesgoLocalidad para una localidad especificada
		return null;
	}

	public FactoresVehiculo obtenerFactoresVehiculo(PolizaDTO poliza) {
		//retorna el factorVehiculo para un vehiculo en particular.
		//el dto tiene marca, modelo, anio
		return null;
	}

	public FactoresModelo obtenerFactoresModelo(PolizaDTO poliza) {
		//retorna el factorModelo para un modelo en particular
		//el dto tiene modelo
		return null;
	}

}
