package com.trabajofinal.gestores;

public class GestorFactoresCaracteristicas {
	
	private static GestorFactoresCaracteristicas instance;

	private GestorFactoresCaracteristicas() {
		
	}
	
	private static GestorFactoresCaracteristicas getInstance() {
		if(instance == null) {
			instance = new GestorFactoresCaracteristicas();
		}
		return instance;
	}

}
