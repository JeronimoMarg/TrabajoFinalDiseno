package com.trabajofinal.dao;

import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Query;

import com.trabajofinal.utils.EntityManagerUtil;


public  abstract class AbstractDao<T> implements Dao<T> {

   private EntityManager entityManager = EntityManagerUtil.getEntityManager();
	
   //private final EntityManager entityManager;
   
   private Class<T> clazz;
   
   /*
   public AbstractDao(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
	*/
	
    public EntityManager getEntityManager() {
       return entityManager;
    }
	
    @Override
	public T getById(int id) {
		return entityManager.find(clazz, id);
	}
  
	
    @Override
	public List<T> getAll() {
		String qlString = "FROM " + clazz.getName();
		Query query = entityManager.createQuery(qlString);
		return query.getResultList();
	}

	@Override
	public void save(T t) {
		executeInsideTransaction(entityManager -> entityManager.persist(t));
		
	}

	@Override
	public void update(T t) {
		executeInsideTransaction(entityManager -> entityManager.merge(t));
		
	}

	@Override
	public void delete(T t) {
		executeInsideTransaction(entityManager -> entityManager.remove(t));
		
	}
	
	public void setClazz(Class <T> clazz) {
		this.clazz = clazz;
	}
	
	private void executeInsideTransaction(Consumer<EntityManager> action) {
		EntityTransaction tx = entityManager.getTransaction();
		try {
			tx.begin();
			action.accept(entityManager);
			tx.commit();
		} catch (RuntimeException e) {
			tx.rollback();
			throw e;
		}
	}

}
