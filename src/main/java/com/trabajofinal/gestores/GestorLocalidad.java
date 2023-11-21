package com.trabajofinal.gestores;

public class GestorLocalidad {
	
	private static GestorLocalidad instance;

	private GestorLocalidad() {
		
	}
	
	private static GestorLocalidad getInstance() {
		if(instance == null) {
			instance = new GestorLocalidad();
		}
		return instance;
	}

}
