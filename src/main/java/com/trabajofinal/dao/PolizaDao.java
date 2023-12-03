package com.trabajofinal.dao;

import java.util.List;

import javax.swing.text.html.parser.Entity;

import com.trabajofinal.models.Poliza;

import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.TypedQuery;

public class PolizaDao extends AbstractDao<Poliza> {
   
   public PolizaDao() {
      //super(em);  
      setClazz(Poliza.class);
    }
   
   
   public List<Poliza> getAsociadasCliente(int id_cliente) {
	      String qlString = "SELECT p FROM Poliza p WHERE p.cliente.id = :id_cliente";
	      TypedQuery<Poliza> query = getEntityManager().createQuery(qlString, Poliza.class);
	      query.setParameter("id_cliente", id_cliente);
	      try {
	         return query.getResultList();
	      } catch (NoResultException e) {
	         System.out.println(e.getMessage());
	         e.printStackTrace();
	         return null;
	      }
	   }
 
}
