package com.trabajofinal.dao;

import com.trabajofinal.models.FactoresModelo;

import jakarta.persistence.NoResultException;
import jakarta.persistence.TypedQuery;

public class FactoresModeloDao extends AbstractDao<FactoresModelo>{
	
	
	public FactoresModeloDao() {
	      setClazz(FactoresModelo.class);
	    }
	
	public FactoresModelo getUltimoFactorModelo(String modelo) {
	      String qlString = "SELECT f FROM FactoresModelo f "
	      		+ "JOIN f.modelo m "
	      		+ "WHERE m.nombre = :modelo"
	      		+ "AND f.fecha_fin_vigencia IS NULL";
	      TypedQuery<FactoresModelo> query = getEntityManager().createQuery(qlString, FactoresModelo.class);
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
