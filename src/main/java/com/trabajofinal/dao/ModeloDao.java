package com.trabajofinal.dao;

import com.trabajofinal.models.Modelo;

import jakarta.persistence.NoResultException;
import jakarta.persistence.TypedQuery;
import java.util.List;

public class ModeloDao extends AbstractDao<Modelo> {

  public ModeloDao() {
    setClazz(Modelo.class);
  }

  public List<Modelo> getModelosMarca(int id_marca) {
    String qlString = "SELECT m FROM Modelo m WHERE m.marca.id = :id_marca";
    TypedQuery<Modelo> query = getEntityManager().createQuery(qlString, Modelo.class);
    query.setParameter("id_marca", id_marca);
    try {
      return query.getResultList();
    } catch (NoResultException e) {
      System.out.println(e.getMessage());
      e.printStackTrace();
      return null;
    }

  }

}
