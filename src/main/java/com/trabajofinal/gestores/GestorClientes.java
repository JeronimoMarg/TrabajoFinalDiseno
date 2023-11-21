package com.trabajofinal.gestores;

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
		//pasado el id como parametro, busca en base de datos el cliente y lo retorna en forma de objeto
		return null;
	}

}
