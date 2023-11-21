package com.trabajofinal.gestores;

import com.trabajofinal.models.FactoresCaracteristicas;
import com.trabajofinal.models.FactoresTipoCobertura;

public class GestorFactoresCaracteristicas {
	
	private static GestorFactoresCaracteristicas instance;

	private GestorFactoresCaracteristicas() {
		
	}
	
	public static GestorFactoresCaracteristicas getInstance() {
		if(instance == null) {
			instance = new GestorFactoresCaracteristicas();
		}
		return instance;
	}

	public FactoresTipoCobertura obtenerFactoresTipoCobertura() {
		//retorna el factorTipoCobertura actual
		return null;
	}

	public FactoresCaracteristicas obtenerFactoresCaracteristicas() {
		//retorna el factorCaracteristicas actual
		return null;
	}

}
