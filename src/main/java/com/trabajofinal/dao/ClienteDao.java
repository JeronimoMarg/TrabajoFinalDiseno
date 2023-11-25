package com.trabajofinal.dao;

import java.util.List;

import com.trabajofinal.models.Cliente;
import com.trabajofinal.models.Poliza;
import com.trabajofinal.models.TipoCondicionIVA;
import com.trabajofinal.models.TipoDocumento;

import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.TypedQuery;

public class ClienteDao extends AbstractDao<Cliente>{

	public ClienteDao() {
	      setClazz(Cliente.class);
	    }
	
	
	public List<Cliente> getClientesPorNumero(String numero) {
	      String qlString = "SELECT c FROM Cliente c WHERE c.numero_cliente = :numero";
	      TypedQuery<Cliente> query = getEntityManager().createQuery(qlString, Cliente.class);
	      query.setParameter("numero", numero);
	      try {
	         return query.getResultList();
	      } catch (NoResultException e) {
	         System.out.println(e.getMessage());
	         e.printStackTrace();
	         return null;
	      }
	   }
	
	public List<Cliente> getClientesPorDocumento(String numero, TipoDocumento tipo) {
	      String qlString = "SELECT c FROM Cliente c WHERE c.numero_documento = :numero AND c.tipo_documento = :tipo";
	      TypedQuery<Cliente> query = getEntityManager().createQuery(qlString, Cliente.class);
	      query.setParameter("numero", numero);
	      query.setParameter("tipo", tipo);
	      try {
	         return query.getResultList();
	      } catch (NoResultException e) {
	         System.out.println(e.getMessage());
	         e.printStackTrace();
	         return null;
	      }
	   }
	
	public List<Cliente> getClientesPorTipoIVA(TipoCondicionIVA tipo) {
	      String qlString = "SELECT c FROM Cliente c WHERE c.condicion_iva = :tipo";
	      TypedQuery<Cliente> query = getEntityManager().createQuery(qlString, Cliente.class);
	      query.setParameter("tipo", tipo);
	      try {
	         return query.getResultList();
	      } catch (NoResultException e) {
	         System.out.println(e.getMessage());
	         e.printStackTrace();
	         return null;
	      }
	   }
	
	public List<Cliente> getClientesPorNombre(String nombre) {
	      String qlString = "SELECT c FROM Cliente c WHERE c.nombre = :nombre";
	      TypedQuery<Cliente> query = getEntityManager().createQuery(qlString, Cliente.class);
	      query.setParameter("nombre", nombre);
	      try {
	         return query.getResultList();
	      } catch (NoResultException e) {
	         System.out.println(e.getMessage());
	         e.printStackTrace();
	         return null;
	      }
	   }
	
	public List<Cliente> getClientesPorApellido(String apellido) {
	      String qlString = "SELECT c FROM Cliente c WHERE c.apellido = :apellido";
	      TypedQuery<Cliente> query = getEntityManager().createQuery(qlString, Cliente.class);
	      query.setParameter("apellido", apellido);
	      try {
	         return query.getResultList();
	      } catch (NoResultException e) {
	         System.out.println(e.getMessage());
	         e.printStackTrace();
	         return null;
	      }
	   }
	
}
