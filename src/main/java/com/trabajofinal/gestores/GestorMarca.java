package com.trabajofinal.gestores;

public class GestorMarca {
	
	private static GestorMarca instance;

	private GestorMarca() {
		
	}
	
	private static GestorMarca getInstance() {
		if(instance == null) {
			instance = new GestorMarca();
		}
		return instance;
	}
	
}
