package com.trabajofinal.gestores;

import com.trabajofinal.dto.PolizaDTO;
import com.trabajofinal.models.Vehiculo;

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

	public Vehiculo crearVehiculo(PolizaDTO poliza) {

		//metodo q crea el vehiculo
		//todos los datos estan en poliza
		
		return null;
	}

}
