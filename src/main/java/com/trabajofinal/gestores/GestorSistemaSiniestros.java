package com.trabajofinal.gestores;

import java.util.List;

import com.trabajofinal.dao.PolizaDao;
import com.trabajofinal.dao.SiniestrosConductorDao;
import com.trabajofinal.dto.PolizaDTO;
import com.trabajofinal.models.Poliza;

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
	   
		public int obtenerSiniestros(int id_cliente) {
			
			SiniestrosConductorDao dao = new SiniestrosConductorDao();
			return dao.getCantidadSiniestros(id_cliente);
		}

}
