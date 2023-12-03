package com.trabajofinal.dao;

import com.trabajofinal.models.LimiteDeBusqueda;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;

public class LimiteDao extends AbstractDao<LimiteDeBusqueda>{
    
    public LimiteDao() {
        setClazz(LimiteDeBusqueda.class);
    }

    public int getLimiteDeBusqueda() {
        CriteriaBuilder criteriaBuilder = getEntityManager().getCriteriaBuilder();
        CriteriaQuery<LimiteDeBusqueda> query = criteriaBuilder.createQuery(LimiteDeBusqueda.class);
        Root<LimiteDeBusqueda> root = query.from(LimiteDeBusqueda.class);

        Predicate predicate = criteriaBuilder.equal(root.get("id"), 1);

        query.select(root).where(predicate);

        return getEntityManager().createQuery(query).getSingleResult().getLimite();
    }
}
