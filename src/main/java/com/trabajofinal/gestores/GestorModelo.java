package com.trabajofinal.gestores;

public class GestorModelo {
	
private static GestorModelo instance;
	
	private GestorModelo() {
		
	}
	
	public static GestorModelo getInstance() {
		if(instance == null) {
			instance = new GestorModelo();
		}
		return instance;
	}

}
