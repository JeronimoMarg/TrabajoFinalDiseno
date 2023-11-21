package com.trabajofinal.gestores;

public class GestorProvincia {
	
	private static GestorProvincia instance;

	private GestorProvincia() {
		
	}
	
	private static GestorProvincia getInstance() {
		if(instance == null) {
			instance = new GestorProvincia();
		}
		return instance;
	}

}
