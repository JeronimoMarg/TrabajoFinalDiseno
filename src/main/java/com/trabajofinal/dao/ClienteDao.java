package com.trabajofinal.dao;

import java.util.ArrayList;
import java.util.List;

import com.trabajofinal.gestores.GestorLimiteDeBusqueda;
import com.trabajofinal.models.Cliente;
import com.trabajofinal.models.Poliza;
import com.trabajofinal.models.TipoCondicionIVA;
import com.trabajofinal.models.TipoDocumento;

import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;

public class ClienteDao extends AbstractDao<Cliente> {

    private List<Predicate> predicados;
    private CriteriaBuilder constructor_criterios;
    private Root<Cliente> root;
    private CriteriaQuery<Cliente> query;

    public ClienteDao() {
        setClazz(Cliente.class);
        predicados = new ArrayList();
        constructor_criterios = getEntityManager().getCriteriaBuilder();
        query = constructor_criterios.createQuery(Cliente.class);
        root = query.from(Cliente.class);
    }

    public Cliente getById(int id) {
        CriteriaBuilder criteriaBuilder = getEntityManager().getCriteriaBuilder();
        CriteriaQuery<Cliente> query = criteriaBuilder.createQuery(Cliente.class);
        Root<Cliente> root = query.from(Cliente.class);

        Predicate predicate = criteriaBuilder.equal(root.get("id"), id); // Reemplaza "id" por el nombre real del atributo que representa el ID en tu clase Cliente

        query.select(root).where(predicate);

        return getEntityManager().createQuery(query).getSingleResult();
    }

    public void getClientesPorNumero(String numero) {
        predicados.add(constructor_criterios.equal(root.get("numero_cliente"), numero));
    }

    public void getClientesPorDocumento(String numero, TipoDocumento tipo) {
        predicados.add(constructor_criterios.equal(root.get("numero_documento"), numero));
        predicados.add(constructor_criterios.equal(root.get("tipo_documento"), tipo));
    }

    public void getClientesPorTipoIVA(TipoCondicionIVA tipo) {
        predicados.add(constructor_criterios.equal(root.get("condicion_iva"), tipo));
    }

    public void getClientesPorNombre(String nombre) {
        predicados.add(constructor_criterios.like(root.get("nombre"), nombre + "%"));
    }

    public void getClientesPorApellido(String apellido) {
        predicados.add(constructor_criterios.like(root.get("apellido"), apellido + "%"));
    }

    public List<Cliente> ejecutarQuery() {
        List<Cliente> resultado = new ArrayList();
        if (predicados.size() > 0) {
            query.select(root).where(predicados.toArray(new Predicate[0]));
            resultado = getEntityManager().createQuery(query).setMaxResults(GestorLimiteDeBusqueda.getInstance().getLimite()).getResultList();
            predicados.clear();
            query = null;
        }
        return resultado;
    }

}
