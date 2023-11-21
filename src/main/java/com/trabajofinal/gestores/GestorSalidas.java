package com.trabajofinal.gestores;

public class GestorSalidas {
	
	private static GestorSalidas instance;

	private GestorSalidas() {
		
	}
	
	public static GestorSalidas getInstance() {
		if(instance == null) {
			instance = new GestorSalidas();
		}
		return instance;
	}

}
