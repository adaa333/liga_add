package entities;


/**
 * Esta clase representa a un deportista en la liga, se genera la tabla SPORTSMEN en la BDD
 * */
import org.apache.logging.log4j.*;

import dao.CRUD;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Query;
import jakarta.persistence.Table;
import util.Manager;

@Entity
@Table (name="SPORTSMEN")
public class Deportista extends CRUD<Deportista>{
	
	@Column (name="SPORTSMAN_ID")
	@Id
	@GeneratedValue (strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column (name="SPORTSMAN_NAME")
	private String nombre;
	
	@Column (name="BIRTH_DATE")
	private String edad;
	
	@Column (name="NATIONALITY")
	private String nacionalidad;
	
	@Column (name="POSITION")
	private String posicion;
	
	@Column (name="NEW_INCORPORATION")
	private boolean nuevo=false;
	
	
	@JoinColumn (name="current_team_number")
	@ManyToOne (optional = false, cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
	private Equipo equipoActual;
	
//getters & setters
	
	public void setNuevo(boolean nuevo) {
		this.nuevo = nuevo;
	}
	public boolean isNuevo() {
		return nuevo;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public void setPosicion(String posicion) {
		this.posicion = posicion;
	}
	
	public String getPosicion() {
		return posicion;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getEdad() {
		return edad;
	}

	public void setEdad(String edad) {
		this.edad = edad;
	}

	public String getNacionalidad() {
		return nacionalidad;
	}

	public void setNacionalidad(String nacionalidad) {
		this.nacionalidad = nacionalidad;
	}

	public Equipo getEquipoActual() {
		return equipoActual;
	}

	public void setEquipoActual(Equipo equipoActual) {
		this.equipoActual = equipoActual;
	}
	
//constructor
	public Deportista(String nombre, String edad, String nacionalidad, Equipo equipoActual) {
		this.nombre=nombre;
		this.edad=edad;
		this.nacionalidad=nacionalidad;
		this.equipoActual=equipoActual;
	}
	
	public Deportista(String nombre, String edad, String nacionalidad, String posicion) {
		this.nombre=nombre;
		this.edad=edad;
		this.nacionalidad=nacionalidad;
		this.posicion=posicion;
	}

	public Deportista() {}

//DAO
	
	@Override
	public Class<Deportista> getEntityClass(){
		return Deportista.class;
	}
	
	public Deportista select(long id) {
		EntityManager manager = Manager.getEntityManagerFactory().createEntityManager();
		  String jpql = "SELECT d FROM Deportista d WHERE d.id = :id";
	        Query query = manager.createQuery(jpql, Deportista.class);
	        query.setParameter("id", id);

	        try {
	            return (Deportista) query.getSingleResult();
	        } catch (Exception e) {
	            System.err.println("Exception");
	            return null;
	        }
	}
}
