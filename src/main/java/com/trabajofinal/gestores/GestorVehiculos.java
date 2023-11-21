package com.trabajofinal.gestores;

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

}
