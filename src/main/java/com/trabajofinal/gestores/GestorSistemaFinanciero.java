package com.trabajofinal.gestores;

public class GestorSistemaFinanciero {
	
	private static GestorSistemaFinanciero instance;

	private GestorSistemaFinanciero() {
		
	}
	
	private static GestorSistemaFinanciero getInstance() {
		if(instance == null) {
			instance = new GestorSistemaFinanciero();
		}
		return instance;
	}

}
