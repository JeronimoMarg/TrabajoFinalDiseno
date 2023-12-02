package com.trabajofinal.gestores;

import java.util.List;

import com.trabajofinal.dao.PolizaDao;
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
	
	   public List<Poliza> obtenerCantidadPolizas(int id_cliente) {

		      PolizaDao dao = new PolizaDao();
		      return dao.getAsociadasCliente(id_cliente);

		   }

}
