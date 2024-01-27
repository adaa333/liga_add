package dao;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.TransientObjectException;

import entities.Equipo;
import jakarta.persistence.EntityExistsException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityNotFoundException;
import jakarta.persistence.PersistenceException;
import jakarta.persistence.Query;
import jakarta.persistence.RollbackException;
import jakarta.persistence.TransactionRequiredException;
import util.Manager;

public abstract class CRUD<T> implements DAO<T>{
	private static Logger logger=LogManager.getLogger(Equipo.class.getName());
	
	public void insert(T entity) {
		EntityManager manager = Manager.getEntityManagerFactory().createEntityManager();
		try {
			
			manager.getTransaction().begin();
			manager.persist(entity);
			manager.getTransaction().commit();
			
		} catch (EntityExistsException entityExists) {
			System.err.println("Entity: "+entity.getClass()+" already exists");
			logger.error("Entity: "+entity.getClass()+" already exists - "+entityExists.getMessage()+"\nCaused by: "+entityExists.getCause());
			entityExists.printStackTrace(); //borrar
		}catch (TransactionRequiredException transactionRequired) {
			System.err.println(transactionRequired.getMessage());
			logger.error("Error con la transacción al insertar: "+entity.getClass()+" - "+transactionRequired.getMessage());
			transactionRequired.printStackTrace();//borrar
		}catch(TransientObjectException transientObject) {
			transientObject.printStackTrace();
		}catch (RollbackException rollback) {
			System.err.println("Error: ha fallado un commit al intentar añadir: "+entity.getClass());
			logger.error("Ha fallado un commit al intentar añadir: "+entity.getClass()+" - "+rollback.getMessage());
			
			 if (manager.getTransaction() != null && manager.getTransaction().isActive()) {
				 manager.getTransaction().rollback();
	            }
			 rollback.printStackTrace();//borrar
		}catch(PersistenceException persistenceFailed) {
			System.err.println("Flush failed while inserting entity: "+entity.getClass());
			logger.error("Flush failed while inserting entity: "+entity.getClass()+"\nCaused by: "+persistenceFailed.getCause());
			persistenceFailed.printStackTrace();//borrar
		}finally {
			if(manager != null) {
				manager.close();
				manager=null;
	        }
		}

		

		logger.info("la entidad "+entity.getClass()+" se ha insertado en orm_competicion");
		
	}

	public void delete(T entity) {
		EntityManager manager = Manager.getEntityManagerFactory().createEntityManager();
		try {
			manager.getTransaction().begin();
			manager.remove(entity);
			manager.getTransaction().commit();
		}catch (TransactionRequiredException transactionRequired) {
			System.err.println(transactionRequired.getMessage());
			logger.error("Error con la transacción al eliminar: "+entity.getClass()+" - "+transactionRequired.getMessage());
		}catch (RollbackException rollback) {
			System.err.println("Error: ha fallado un commit al intentar eliminar: "+entity.getClass());
			logger.error("Ha fallado un commit al intentar eliminar: "+entity.getClass()+" - "+rollback.getMessage());
			

			 if (manager.getTransaction() != null && manager.getTransaction().isActive()) {
				 manager.getTransaction().rollback();
	            }
			 
		}catch(PersistenceException persistenceFailed) {
			System.err.println("Flush failed while deleting entity: Deportista-"+entity.getClass());
			logger.error("Flush failed while deleting entity: Deportista-"+entity.getClass()+"\nCaused by: "+persistenceFailed.getCause());
		}finally {
			if(manager != null) {
				manager.close();
				manager=null;
	        }
		}
	}

	public List<T> selectAll() {
		EntityManager manager = Manager.getEntityManagerFactory().createEntityManager();
		List<T> resultado=null; 
		try {
			manager.getTransaction().begin();
			manager.getTransaction().commit();
		} catch (IllegalStateException illegalState) {
			System.err.println("Error con la transacción: "+illegalState.getMessage()+"\nCaused by: "+illegalState.getCause());
			logger.error("Error con la transacción: "+illegalState.getMessage()+"\nCaused by: "+illegalState.getCause());
		}catch (RollbackException rollback) {
			System.err.println("Error: ha fallado un commit al intentar obtener todos los registros de una tabla.");
			logger.error("Ha fallado un commit al intentar obtener todos los registros de una tabla - "+rollback.getMessage());
			
			if (manager.getTransaction() != null && manager.getTransaction().isActive()) {
				 manager.getTransaction().rollback();
	            }
			
		}finally {
			if(manager != null) {
				manager.close();
				manager=null;
	        }
		}
		return resultado;
	}

	public void update(T entity) {
		EntityManager manager = Manager.getEntityManagerFactory().createEntityManager();
		try {
			manager.getTransaction().begin();
			manager.merge(entity);
			manager.getTransaction().commit();
		}catch (EntityNotFoundException entityNotFound) {
			System.err.println("Entity: "+entity.getClass()+" already exists");
			logger.error("Entity: "+entity.getClass()+" can´t be found - "+entityNotFound.getMessage()+"\nCaused by: "+entityNotFound.getCause()); 
		}catch(RollbackException rollback) {
			System.err.println("Error: ha fallado un commit al intentar actualizar: "+entity.getClass());
			logger.error("Ha fallado un commit al intentar actualizar: "+entity.getClass()+" - "+rollback.getMessage());
			
			 if (manager.getTransaction() != null && manager.getTransaction().isActive()) {
				 manager.getTransaction().rollback();
	            }
			 rollback.printStackTrace();//borrar
		}catch (TransactionRequiredException transactionRequired) {
			System.err.println(transactionRequired.getMessage());
			logger.error("Error con la transacción al actualizar: "+entity.getClass()+" - "+transactionRequired.getMessage());
		}catch (IllegalArgumentException illegalArgument) {
			System.err.println(illegalArgument.getMessage());
			logger.error("Error con los argumentos al actualizar: "+entity.getClass()+" - "+illegalArgument.getMessage());
			illegalArgument.printStackTrace();//borrar
		}catch(PersistenceException persistenceFailed) {
			System.err.println("Flush failed while updating entity: "+entity.getClass());
			logger.error("Flush failed while updating entity: "+entity.getClass()+"\nCaused by: "+persistenceFailed.getCause());
		}finally {
			if(manager != null) {
				manager.close();
				manager=null;
	        }
		}
	}
	
}
