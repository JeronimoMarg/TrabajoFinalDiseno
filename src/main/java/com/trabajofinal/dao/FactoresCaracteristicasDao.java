package com.trabajofinal.dao;

import com.trabajofinal.models.FactoresCaracteristicas;
import com.trabajofinal.models.Poliza;
import com.trabajofinal.models.TipoCobertura;

import jakarta.persistence.NoResultException;
import jakarta.persistence.TypedQuery;

public class FactoresCaracteristicasDao extends AbstractDao<FactoresCaracteristicas> {

	public FactoresCaracteristicasDao() {
	      //super(em);
	      setClazz(FactoresCaracteristicas.class);
	    }

	public FactoresCaracteristicas getUltimoFactor() {
	      String qlString = "SELECT f FROM FactoresCaracteristicas f WHERE f.fecha_fin_vigencia IS NULL";
	      TypedQuery<FactoresCaracteristicas> query = getEntityManager().createQuery(qlString, FactoresCaracteristicas.class);
	      //query.setParameter("tipo", tipo);
	      try {
	         return query.getSingleResult();
	      } catch (NoResultException e) {
	         System.out.println(e.getMessage());
	         e.printStackTrace();
	         return null;
	      }
	   }
	
}
