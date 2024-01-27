package entities;

import java.util.Date;
import java.util.concurrent.atomic.AtomicInteger;

import dao.CRUD;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Id;
import jakarta.persistence.Query;
import jakarta.persistence.Table;
import util.Manager;
@Entity
@Table (name="COMPETITION")
public class Competicion extends CRUD<Competicion>{

	@Id
	@Column (name="NAME")
	private String nombre;
	@Column (name="CREATION_DATE")
	private Date fechaCreacion;
	@Column (name="TEAMS")
	private int numEquipos;
	@Column (name="journeys")
	private AtomicInteger jornadas=new AtomicInteger(0);
	
//getters y setters
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Date getFechaCreacion() {
		return fechaCreacion;
	}
	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}
	public int getNumEquipos() {
		return numEquipos;
	}
	public void setNumEquipos(int numEquipos) {
		this.numEquipos = numEquipos;
	}
	public AtomicInteger getJornadas() {
		return jornadas;
	}
	public void setJornadas(AtomicInteger jornadas) {
		this.jornadas = jornadas;
	}
	
	public void añadirJornada() {
		getJornadas().getAndIncrement();
		this.update(this);
	}
	
//constructor
	public Competicion(String nombre, Date fechaCreacion, int numEquipos) {
		super(Competicion.class);
		this.nombre = nombre;
		this.fechaCreacion = fechaCreacion;
		this.numEquipos = numEquipos;
	}
	
//DAO
	
	public Competicion select(long id) {
		EntityManager manager = Manager.getEntityManagerFactory().createEntityManager();

		 String jpql = "SELECT e FROM Entidad e WHERE e.id = :id";
	     Query query = manager.createQuery(jpql, Competicion.class);
	     query.setParameter("id", id);
	
	        try {
	            return (Competicion) query.getSingleResult();
	        } catch (Exception e) {
	            System.err.println("EXCEPCION");
	            return null;
	        }
	}
	
	
}
