package com.trabajofinal.dao;

import java.util.List;

import com.trabajofinal.models.Localidad;

import jakarta.persistence.NoResultException;
import jakarta.persistence.TypedQuery;

public class LocalidadDao extends AbstractDao<Localidad> {

   public LocalidadDao() {
      setClazz(Localidad.class);
   }

   public List<Localidad> getLocalidadesProvincia(int id_provincia) {
      String qlString = "SELECT l FROM Localidad l WHERE l.provincia.id = :id_provincia";
      TypedQuery<Localidad> query = getEntityManager().createQuery(qlString, Localidad.class);
      query.setParameter("id_provincia", id_provincia);
      try {
         return query.getResultList();
      } catch (NoResultException e) {
         System.out.println(e.getMessage());
         e.printStackTrace();
         return null;
      }
   }
   
   public Localidad getLocalidad(String localidad) {
	   	  System.out.println(localidad);
	      String qlString = "SELECT l FROM Localidad l WHERE l.nombre = :localidad";
	      TypedQuery<Localidad> query = getEntityManager().createQuery(qlString, Localidad.class);
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
