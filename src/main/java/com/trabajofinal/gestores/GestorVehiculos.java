package com.trabajofinal.gestores;

public class GestorVehiculos {
	
	private static GestorVehiculos instance;

	private GestorVehiculos() {
		
	}
	
	private static GestorVehiculos getInstance() {
		if(instance == null) {
			instance = new GestorVehiculos();
		}
		return instance;
	}

}
