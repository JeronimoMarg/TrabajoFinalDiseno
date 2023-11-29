package com.trabajofinal.dao;

import com.trabajofinal.models.FactoresVehiculo;

import jakarta.persistence.NoResultException;
import jakarta.persistence.TypedQuery;


public class FactoresVehiculoDao extends AbstractDao<FactoresVehiculo>{

	public FactoresVehiculoDao() {
	      setClazz(FactoresVehiculo.class);
	    }
	
	public FactoresVehiculo getUltimoFactorVehiculo(String modelo) {
	      String qlString = "SELECT f FROM FactoresVehiculo f "
	      		+ "JOIN f.vehiculo t "
	      		+ "JOIN t.modelo m "
	      		+ "WHERE m.nombre = :modelo"
	      		+ "AND f.fecha_fin_vigencia IS NULL";
	      TypedQuery<FactoresVehiculo> query = getEntityManager().createQuery(qlString, FactoresVehiculo.class);
	      query.setParameter("modelo", modelo);
	      try {
	         return query.getSingleResult();
	      } catch (NoResultException e) {
	         System.out.println(e.getMessage());
	         e.printStackTrace();
	         return null;
	      }
	   }
}