package com.trabajofinal.utils;


import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class EntityManagerUtil {
	
   private static EntityManagerFactory factory;

	private EntityManagerUtil() {
	}

   public static EntityManager getEntityManager() {
      EntityManagerFactory factory = Persistence.createEntityManagerFactory("tpdiseno");
      EntityManager manager = factory.createEntityManager();
      return manager;
   }
   
   public static void closeEntityManagerFactory() {
		if (factory != null) {
			factory.close();
		}
	}
	/* 
	public static void main(String[] args) {
		EntityManager manager = EntityManagerUtil.getEntityManager();
		System.out.println("EntityManager class ==> " + manager.getClass().getCanonicalName());
	} */

}
