package com.trabajofinal.gestores;

public class GestorDomicilios {
	
	private static GestorDomicilios instance;
	
	private GestorDomicilios() {
		
	}
	
	private static GestorDomicilios getInstance() {
		if(instance == null) {
			instance = new GestorDomicilios();
		}
		return instance;
	}

}
