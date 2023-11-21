package com.trabajofinal.gestores;

public class GestorPagos {
	
	private static GestorPagos instance;

	private GestorPagos() {
		
	}
	
	private static GestorPagos getInstance() {
		if(instance == null) {
			instance = new GestorPagos();
		}
		return instance;
	}

}
