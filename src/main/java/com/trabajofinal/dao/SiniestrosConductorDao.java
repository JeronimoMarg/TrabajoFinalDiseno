package com.trabajofinal.dao;

import java.util.List;

import com.trabajofinal.models.SiniestrosConductor;

import jakarta.persistence.NoResultException;
import jakarta.persistence.TypedQuery;

public class SiniestrosConductorDao extends AbstractDao<SiniestrosConductor> {
	   
	   public SiniestrosConductorDao() {
	      //super(em);  
	      setClazz(SiniestrosConductor.class);
	    }

	   public int getCantidadSiniestros(int id_cliente) {
		      String qlString = "SELECT COUNT (*) FROM SiniestrosPoliza s WHERE s.cliente.id = :id_cliente";
		      TypedQuery<Integer> query = getEntityManager().createQuery(qlString, Integer.class);
		      query.setParameter("id_cliente", id_cliente);
		      try {
		         return query.getSingleResult();
		      } catch (NoResultException e) {
		         System.out.println(e.getMessage());
		         e.printStackTrace();
		         return -1;
		      }
		   }

}
