package com.trabajofinal.gestores;

import com.trabajofinal.dao.ClienteDao;
import com.trabajofinal.dto.ClienteDTO;
import com.trabajofinal.models.Cliente;

public class GestorClientes {
	
	private static GestorClientes instance;

	private GestorClientes() {
		
	}
	
	public static GestorClientes getInstance() {
		if(instance == null) {
			instance = new GestorClientes();
		}
		return instance;
	}

	public Cliente obtenerCliente(int id) {
		ClienteDao dao = new ClienteDao();
		return dao.getById(id);
	}

	public void actualizarEstado(Cliente cliente, int cantidadPolizasCliente, int cantidadSiniestros) {
		//actualiza el estado de cliente
		//ver caso de uso
		
	}

}
