package com.trabajofinal.gestores;

public class GestorSistemaSiniestros {
	
	private static GestorSistemaSiniestros instance;

	private GestorSistemaSiniestros() {
		
	}
	
	public static GestorSistemaSiniestros getInstance() {
		if(instance == null) {
			instance = new GestorSistemaSiniestros();
		}
		return instance;
	}

}