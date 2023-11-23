package com.trabajofinal.dao;

import com.trabajofinal.models.Poliza;
import com.trabajofinal.models.Provincia;
import com.trabajofinal.models.Vehiculo;

import jakarta.persistence.EntityManager;

public class VehiculoDao extends AbstractDao<Vehiculo>{

	
	public VehiculoDao() {
		//super(entityManager);
		setClazz(Vehiculo.class);
	}

}
