package com.trabajofinal.dao;

import com.trabajofinal.models.SiniestrosConductor;

import jakarta.persistence.NoResultException;
import jakarta.persistence.TypedQuery;

public class SiniestrosConductorDao extends AbstractDao<SiniestrosConductor> {

    public SiniestrosConductorDao() {
        //super(em);  
        setClazz(SiniestrosConductor.class);
    }

    public int getCantidadSiniestros(int id_cliente) {
    String qlString = "SELECT s.numero_siniestros FROM SiniestrosConductor s WHERE s.cliente.id = :id_cliente";
    TypedQuery<Integer> query = getEntityManager().createQuery(qlString, Integer.class);
    query.setParameter("id_cliente", id_cliente);
    try {
        Integer numero = query.getSingleResult();
        return numero != null ? numero : 0; // Manejo de valor nulo
    } catch (NoResultException e) {
        System.out.println(e.getMessage());
        e.printStackTrace();
        return -1;
    }
}


}
