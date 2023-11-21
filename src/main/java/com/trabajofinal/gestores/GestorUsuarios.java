package com.trabajofinal.gestores;

public class GestorUsuarios {
	
	private static GestorUsuarios instance;

	private GestorUsuarios() {
		
	}
	
	private static GestorUsuarios getInstance() {
		if(instance == null) {
			instance = new GestorUsuarios();
		}
		return instance;
	}

}
