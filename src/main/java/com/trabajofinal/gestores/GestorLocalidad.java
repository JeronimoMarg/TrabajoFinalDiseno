package com.trabajofinal.gestores;

import com.trabajofinal.models.Localidad;
import com.trabajofinal.dao.LocalidadDao;

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

	public Localidad obtenerLocalidad(int id_localidad) {
		
		LocalidadDao dao = new LocalidadDao();
		return dao.getById(id_localidad);
	}

}
