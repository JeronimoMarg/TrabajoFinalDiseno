package com.trabajofinal.dao;

import java.util.List;
import java.util.Optional;

import javax.swing.text.html.parser.Entity;

import com.trabajofinal.models.Provincia;

import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.TypedQuery;

public class ProvinciaDao extends AbstractDao<Provincia> {

	/*
   public ProvinciaDao(EntityManager em) {
      super(em);
      setClazz(Provincia.class);
   }
   */
      
   public Provincia getByName(String name) {
      String qlString = "SELECT s FROM provincia p WHERE p.nombre = :name";
      TypedQuery<Provincia> query = getEntityManager().createQuery(qlString, Provincia.class);
      query.setParameter("name", name);
      try {
         return query.getSingleResult();
      } catch (NoResultException e) {
         return null;
      }
   }
    
   public List<Provincia> getProvinciaByName(String name) {
        String qlString = "SELECT p FROM provincia p WHERE p.nombre LIKE ?1";
        TypedQuery<Provincia> query = getEntityManager().createQuery(qlString, Provincia.class);
        query.setParameter(1, "%"+name+"%");
        return query.getResultList();
    }

   
   
}
