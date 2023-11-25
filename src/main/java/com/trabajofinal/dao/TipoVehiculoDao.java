package com.trabajofinal.dao;

import java.util.List;

import com.trabajofinal.models.TipoVehiculo;

import jakarta.persistence.NoResultException;
import jakarta.persistence.TypedQuery;

public class TipoVehiculoDao extends AbstractDao<TipoVehiculo>{

	public TipoVehiculoDao() {
	      setClazz(TipoVehiculo.class);
	    }
	public List<TipoVehiculo> getTipoVehiculoModelo(int id_modelo) {
		String qlString = "SELECT t FROM TipoVehiculo t WHERE t.id_modelo = :id_modelo";
		TypedQuery<TipoVehiculo> query = getEntityManager().createQuery(qlString, TipoVehiculo.class);
		query.setParameter("id_modelo", id_modelo);
		try {
			return query.getResultList();
		} catch (NoResultException e) {
			return null;
			// HACER ALGO CON EL ERROR
		}
	}

}