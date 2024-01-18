package entities;

import java.util.List;

/**
 * Esta clase representa a un deportista en la liga, se genera la tabla SPORTSMEN en la BDD
 * */

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import util.DAO;
import util.Manager;

@Entity
@Table (name="SPORTSMEN")
public class Deportista implements DAO<Deportista>{
	
	@Column (name="SPORTSMAN_ID")
	@Id
	@GeneratedValue (strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column (name="SPORTSMAN_NAME")
	private String nombre;
	
	@Column (name="BIRTH_DATE")
	private String edad;
	
	@Column (name="NATIONALITY")
	private String nacionalidad;
	
	@Column (name="POSITION")
	private String posicion;
	
	@JoinColumn (name="current_team_number")
	@ManyToOne (optional = false, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private Equipo equipoActual;
	
//getters & setters
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
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
	public void insert(Deportista obj) {
		Manager.persist(obj);	
	}

	public void delete(int id) {
		// TODO Auto-generated method stub
		
	}

	public List<Deportista> selectAll() {
		// TODO Auto-generated method stub
		return null;
	}

	public Deportista select(int id) {
		// TODO Auto-generated method stub
		return null;
	}
}
