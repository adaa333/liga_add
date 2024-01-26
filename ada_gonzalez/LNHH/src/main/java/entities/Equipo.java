package entities;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.logging.log4j.*;

import dao.CRUD;
import dao.DAO;
import jakarta.persistence.CascadeType;

/**
 * Esta clase representa a un equipo en la liga, se genera la tabla TEAMS en la BDD
 * 
 * */

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityExistsException;
import jakarta.persistence.EntityNotFoundException;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PersistenceException;
import jakarta.persistence.RollbackException;
import jakarta.persistence.Table;
import jakarta.persistence.TransactionRequiredException;
import util.Manager;

@Entity
@Table (name="TEAMS")
public class Equipo extends CRUD<Equipo>{
	private static Logger logger=LogManager.getLogger(Equipo.class.getName());
	@Column (name="TEAM_NAME")
	private String nombre;
	@Id
	@Column (name="TEAM_ID")
	@GeneratedValue (strategy=GenerationType.IDENTITY)
	private Long id;
	@Column (name="RINK")
	private String pista;
	/*@Column (name="GOALIE")
	private String goalKeeper;
	@Column (name="LEFT_WING")
	private String alaIzq;
	@Column (name="RIGHT_WING")
	private String alaDch;
	@Column (name="LEFT_DEFENSE")
	private String defensaIzq;
	@Column (name="RIGHT_DEFENSE")
	private String defensaDch;
	@Column (name="CENTRE")
	private String centro;*/
	
	@OneToMany (mappedBy="equipoActual")
	private Set<Deportista> jugadores=new HashSet<Deportista>();
	@Column (name="MATCHS_PLAYED")
	private int jornadasJugadasEnTemporadaActual;
	@Column (name="POINTS")
	private int puntos;

	@ManyToMany (cascade = CascadeType.MERGE)
    @JoinTable(
        name = "TEAM_SPONSOR",
        joinColumns = @JoinColumn(name = "TEAM_ID"),
        inverseJoinColumns = @JoinColumn(name = "SPONSOR_ID")
    )
	private Set<Patrocinador> patrocinadores= new HashSet<Patrocinador>();
	
//getters & setters
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getPista() {
		return pista;
	}
	public void setPista(String pista) {
		this.pista = pista;
	}
	
	public int getJornadasJugadasEnTemporadaActual() {
		return jornadasJugadasEnTemporadaActual;
	}
	public void setJornadasJugadasEnTemporadaActual(int jornadasJugadasEnTemporadaActual) {
		this.jornadasJugadasEnTemporadaActual = jornadasJugadasEnTemporadaActual;
	}
	public void setPuntos(int puntos) {
		this.puntos = puntos;
	}
	public int getPuntos() {
		return puntos;
	}
	
	public void setJugadores(List<Deportista> jugadores) {
		this.jugadores.addAll(jugadores);
	}
	
	public Set<Deportista> getJugadores() {
		return jugadores;
	}
	
	public void setPatrocinadores(List<Patrocinador> patrocinadores) {
		this.patrocinadores.addAll(patrocinadores);
	}
	
	public Set<Patrocinador> getPatrocinadores() {
		return patrocinadores;
	}
	
	
//constructor
	
	public Equipo() {}
	
	public Equipo(String nombre, String pista) {
		this.nombre=nombre;
		this.pista=pista;
	}
	
//DAO
	
}
