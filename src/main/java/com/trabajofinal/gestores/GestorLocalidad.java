package com.trabajofinal.gestores;

import com.trabajofinal.models.Localidad;

public class GestorLocalidad {
	
	private static GestorLocalidad instance;

	private GestorLocalidad() {
		
	}
	
	public static GestorLocalidad getInstance() {
		if(instance == null) {
			instance = new GestorLocalidad();
		}
		return instance;
	}

	public Localidad obtenerLocalidad(Object localidad) {
		//metodo que busca en por ID la localidad y devuelve el objeto correspondien
		return null;
	}

}
