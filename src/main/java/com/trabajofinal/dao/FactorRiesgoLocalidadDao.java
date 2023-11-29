package com.trabajofinal.dao;

import com.trabajofinal.models.FactorRiesgoLocalidad;

import jakarta.persistence.NoResultException;
import jakarta.persistence.TypedQuery;

public class FactorRiesgoLocalidadDao extends AbstractDao<FactorRiesgoLocalidad>{

	public FactorRiesgoLocalidadDao() {
	      setClazz(FactorRiesgoLocalidad.class);
	    }
	
	 public FactorRiesgoLocalidad getUltimoFactorLocalidad(String localidad) {
	      String qlString = "SELECT l FROM FactorRiesgoLocalidad l WHERE l.localidad.nombre = :localidad AND fecha_fin_vigencia IS NULL";
	      TypedQuery<FactorRiesgoLocalidad> query = getEntityManager().createQuery(qlString, FactorRiesgoLocalidad.class);
	      query.setParameter("localidad", localidad);
	      try {
	         return query.getSingleResult();
	      } catch (NoResultException e) {
	         System.out.println(e.getMessage());
	         e.printStackTrace();
	         return null;
	      }
	   }
}
