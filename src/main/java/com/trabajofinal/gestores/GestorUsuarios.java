package com.trabajofinal.gestores;

public class GestorUsuarios {
	
	private static GestorUsuarios instance;

	private GestorUsuarios() {
		
	}
	
	public static GestorUsuarios getInstance() {
		if(instance == null) {
			instance = new GestorUsuarios();
		}
		return instance;
	}

}
