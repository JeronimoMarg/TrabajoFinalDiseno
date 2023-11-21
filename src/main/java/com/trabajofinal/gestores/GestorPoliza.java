package com.trabajofinal.gestores;

public class GestorPoliza {
	
	private static GestorPoliza instance;
	
	private GestorPoliza() {
		
	}
	
	private static GestorPoliza getInstance() {
		if(instance == null) {
			instance = new GestorPoliza();
		}
		return instance;
	}

}
