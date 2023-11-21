package com.trabajofinal.gestores;

public class GestorPais {
	
	private static GestorPais instance;

	private GestorPais() {
		
	}
	
	public static GestorPais getInstance() {
		if(instance == null) {
			instance = new GestorPais();
		}
		return instance;
	}

}
