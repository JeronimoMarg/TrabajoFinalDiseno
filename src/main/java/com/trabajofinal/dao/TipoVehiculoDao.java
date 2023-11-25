package com.trabajofinal.dao;

import java.util.List;

import com.trabajofinal.models.TipoVehiculo;

import jakarta.persistence.NoResultException;
import jakarta.persistence.TypedQuery;

public class TipoVehiculoDao extends AbstractDao<TipoVehiculo> {

	public TipoVehiculoDao() {
		setClazz(TipoVehiculo.class);
	}

	public List<TipoVehiculo> getTipoVehiculoModelo(int id_modelo) {
		String qlString = "SELECT t FROM TipoVehiculo t WHERE t.modelo.id = :id_modelo";
		TypedQuery<TipoVehiculo> query = getEntityManager().createQuery(qlString, TipoVehiculo.class);
		query.setParameter("id_modelo", id_modelo);
		try {
			return query.getResultList();
		} catch (NoResultException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
			return null;
		}
	}

}