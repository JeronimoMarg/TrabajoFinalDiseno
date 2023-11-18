package PruebaMapeo;

import com.trabajofinal.utils.EntityManagerUtil;

import jakarta.persistence.EntityManager;

public class APP {

	public static void main(String[] args) {
		EntityManager em = EntityManagerUtil.getEntityManager();
		 Estudiante e = new Estudiante();
		 em.persist(e);

	}

}
