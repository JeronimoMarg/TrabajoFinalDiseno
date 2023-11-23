package com.trabajofinal.dao;

import com.trabajofinal.models.Cliente;
import com.trabajofinal.models.Poliza;

import jakarta.persistence.EntityManager;

public class ClienteDao extends AbstractDao<Cliente>{

	public ClienteDao() {
	      setClazz(Cliente.class);
	    }
	
}
