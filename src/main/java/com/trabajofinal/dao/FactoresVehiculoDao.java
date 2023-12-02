package com.trabajofinal.dao;

import com.trabajofinal.models.FactoresVehiculo;

import jakarta.persistence.NoResultException;
import jakarta.persistence.TypedQuery;

public class FactoresVehiculoDao extends AbstractDao<FactoresVehiculo> {

    public FactoresVehiculoDao() {
        setClazz(FactoresVehiculo.class);
    }

    public FactoresVehiculo getUltimoFactorVehiculo(int id_tipo_vehiculo) {
        String qlString = "SELECT f FROM FactoresVehiculo f "
                + "JOIN f.vehiculo t "
                + "WHERE t.id = :id_tipo_vehiculo "
                + "AND f.fecha_fin_vigencia IS NULL";
        TypedQuery<FactoresVehiculo> query = getEntityManager().createQuery(qlString, FactoresVehiculo.class);
        query.setParameter("id_tipo_vehiculo", id_tipo_vehiculo);
        try {
            return query.getSingleResult();
        } catch (NoResultException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
            return null;
        }
    }

}
