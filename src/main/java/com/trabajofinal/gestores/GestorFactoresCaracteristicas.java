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
import com.trabajofinal.dao.FactoresVehiculoDao;
import com.trabajofinal.dao.FactoresModeloDao;

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

	public FactorRiesgoLocalidad obtenerFactoresLocalidad(int id_localidad) {
		
		FactorRiesgoLocalidadDao dao = new FactorRiesgoLocalidadDao();
		return dao.getUltimoFactorLocalidad(id_localidad);
	}

	public FactoresVehiculo obtenerFactoresVehiculo(int id_tipo_vehiculo) {
		
		FactoresVehiculoDao dao = new FactoresVehiculoDao();
		return dao.getUltimoFactorVehiculo(id_tipo_vehiculo);
		
	}

	public FactoresModelo obtenerFactoresModelo(int id_modelo) {
		
		FactoresModeloDao dao = new FactoresModeloDao();
		return dao.getUltimoFactorModelo(id_modelo);
	
	}

}
