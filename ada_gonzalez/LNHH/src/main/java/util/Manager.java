package util;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Manager {
	private static EntityManagerFactory emFactory= Persistence.createEntityManagerFactory("lnhh");
	private static EntityManager eManager= emFactory.createEntityManager();
	
	public static void persist(Object entity) {
		eManager.getTransaction().begin();
		eManager.persist(entity);
		eManager.getTransaction().commit();
	}
}