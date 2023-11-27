package com.trabajofinal.dao;

import com.trabajofinal.models.Hijo;
import jakarta.persistence.NoResultException;
import jakarta.persistence.TypedQuery;
import java.util.List;

public class HijoDao extends AbstractDao<Hijo> {
    
    public HijoDao() {
        setClazz(Hijo.class);
    }
    
     public List<Hijo> getHijos(int id_hijo) {
      String qlString = "SELECT l FROM Localidad l WHERE l.provincia.id = :id_provincia";
      TypedQuery<Hijo> query = getEntityManager().createQuery(qlString, Hijo.class);
      query.setParameter("id_provincia", id_hijo);
      try {
         return query.getResultList();
      } catch (NoResultException e) {
         System.out.println(e.getMessage());
         e.printStackTrace();
         return null;
      }
   }
    
}
