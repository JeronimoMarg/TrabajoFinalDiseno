package com.trabajofinal.gestores;

public class GestorClientes {
	
	private static GestorClientes instance;

	private GestorClientes() {
		
	}
	
	private static GestorClientes getInstance() {
		if(instance == null) {
			instance = new GestorClientes();
		}
		return instance;
	}

}
