package util;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import entities.Equipo;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;
import jakarta.persistence.RollbackException;

/**
 * Esta clase gestiona los EntityManager y las transacciones
 * 
 * @author Ada
 * */


public class Manager <T>{
	private static Logger logger=LogManager.getLogger(Manager.class.getName());
	
	/*private static SessionFactory sessionFactory = buildSessionFactory();

	private static SessionFactory buildSessionFactory() {
		try {
			if (sessionFactory == null) {
				StandardServiceRegistry standardRegistry = new StandardServiceRegistryBuilder()
						.configure("hibernate.cfg.xml").build();

				Metadata metaData = new MetadataSources(standardRegistry).getMetadataBuilder().build();

				sessionFactory = metaData.getSessionFactoryBuilder().build();
			}
			return sessionFactory;
			
		} catch (Throwable ex) {

			System.err.println("Initial SessionFactory creation failed." + ex);

			throw new ExceptionInInitializerError(ex);
		}
	}

	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public static void shutdown() {
		getSessionFactory().close();
	}*/
	
	//jpa

	private static EntityManagerFactory emFactory= buildEntityManagerFactory();
	
//gestión de transacciones
	
	public static EntityManagerFactory buildEntityManagerFactory() {
		EntityManagerFactory emFactory=null;
		if(emFactory==null) {
			emFactory=Persistence.createEntityManagerFactory("lnhh");
		}
		return emFactory;
	}
	
	public static EntityManagerFactory getEntityManagerFactory() {
		return emFactory;
	}
	


}
