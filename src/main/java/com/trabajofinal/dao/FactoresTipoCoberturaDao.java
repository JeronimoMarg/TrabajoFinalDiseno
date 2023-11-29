package com.trabajofinal.dao;

import java.util.List;

import com.trabajofinal.models.FactoresTipoCobertura;
import com.trabajofinal.models.TipoCobertura;

import jakarta.persistence.NoResultException;
import jakarta.persistence.TypedQuery;

public class FactoresTipoCoberturaDao extends AbstractDao<FactoresTipoCobertura> {

	public FactoresTipoCoberturaDao() {
	      //super(em);  
	      setClazz(FactoresTipoCobertura.class);
	    }
	
	
	   public FactoresTipoCobertura getUltimoFactor(TipoCobertura tipo) {
		      String qlString = "SELECT f FROM FactoresTipoCobertura f WHERE f.tipo_cobertura = :tipo AND f.fecha_fin_vigencia IS NULL";
		      TypedQuery<FactoresTipoCobertura> query = getEntityManager().createQuery(qlString, FactoresTipoCobertura.class);
		      query.setParameter("tipo", tipo);
		      try {
		         return query.getSingleResult();
		      } catch (NoResultException e) {
		         System.out.println(e.getMessage());
		         e.printStackTrace();
		         return null;
		      }
		   }
}
