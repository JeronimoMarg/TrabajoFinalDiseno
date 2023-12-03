package com.trabajofinal.dao;

import java.util.List;

import com.trabajofinal.models.Poliza;
import com.trabajofinal.models.Provincia;
import com.trabajofinal.models.Vehiculo;

import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.TypedQuery;

public class VehiculoDao extends AbstractDao<Vehiculo>{

	
	public VehiculoDao() {
		//super(entityManager);
		setClazz(Vehiculo.class);
	}

	   public int getUltimoId() {
		   
		   String qlString = "SELECT MAX (p.id) FROM Vehiculo p";
		      TypedQuery<Integer> query = getEntityManager().createQuery(qlString, Integer.class);
		      try {
		    	 Integer aux = query.getSingleResult();
		         return (aux!=null)? aux:0;
		      } catch (NoResultException e) {
		         System.out.println(e.getMessage());
		         e.printStackTrace();
		         return -1;
		      }
		  
	   }
	   
	   public List<Poliza> getByPatente(String patente) {
		   
		   String qlString = "SELECT p FROM Poliza p "
		   		+ "JOIN p.vehiculo_asegurado v "
		   		+ "WHERE v.patente = :patente ";
		      TypedQuery<Poliza> query = getEntityManager().createQuery(qlString, Poliza.class);
		      query.setParameter("patente", patente);
		      try {
		    	 return query.getResultList();
		      } catch (NoResultException e) {
		         //System.out.println(e.getMessage());
		         //e.printStackTrace();
		         return null;
		      }
		  
	   }
	   
}
