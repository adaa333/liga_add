package entities;

import java.util.List;
import java.util.Random;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import dao.CRUD;
import dao.DAO;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityExistsException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityNotFoundException;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.PersistenceException;
import jakarta.persistence.Query;
import jakarta.persistence.RollbackException;
import jakarta.persistence.Table;
import jakarta.persistence.TransactionRequiredException;
import util.Manager;

@Entity
@Table (name="MATCHES")
public class Partido extends CRUD<Partido>{
	private static Logger logger=LogManager.getLogger(Equipo.class.getName());

	@Id
	@GeneratedValue (strategy= GenerationType.IDENTITY)
	@Column (name="MATCH_ID")
	private Long idPartido;
	/*@JoinColumn (name="LOCAL_TEAM_ID")
	@ManyToOne (optional = false, cascade = CascadeType.MERGE)
	private Equipo equipoLocal;
	@JoinColumn (name="VISITING_TEAM_ID")
	@ManyToOne (optional = false, cascade = CascadeType.MERGE)
	private Equipo equipoVisitante;*/
	@Column (name="teams_confronted")
	private String teams;
	@Column (name="RINK")
	private String pista;
	@Column (name="OUTCOME")
	private String resultado;
	
	@ManyToOne(optional = false, cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
	@JoinColumn (name="season", referencedColumnName = "NAME")
	Competicion competicion;
	
	private String jornada;
	
//getters y setters
	
	public Long getIdPartido() {
		return idPartido;
	}

	public void setIdPartido(Long idJornada) {
		this.idPartido = idJornada;
	}

	
	public String getPista() {
		return pista;
	}

	public void setPista(String pista) {
		this.pista = pista;
	}

	public String getResultado() {
		return resultado;
	}

	public void setResultado(String resultado) {
		this.resultado = resultado;
	}
	
	public void setJornada(String jornada) {
		this.jornada = jornada;
	}
	public String getJornada() {
		return jornada;
	}
	
	public void setTeams(String teams) {
		this.teams = teams;
	}
	public String getTeams() {
		return teams;
	}

	//constructor
	public Partido() {super(Partido.class);}
	
	public Partido(String teams) {
		super(Partido.class);
		this.teams=teams;
		String [] equipos = this.teams.split("-");
		Equipo equipoLocal = new Equipo();
		equipoLocal=equipoLocal.selectByName(equipos[0]);
		this.pista=equipoLocal.getPista();
	}
	
	public void iniciar() {
		Equipo equipoLocal = new Equipo();
		equipoLocal=equipoLocal.select(equipoLocal.getId());
		
		Equipo equipoVisitante = new Equipo();
		equipoVisitante=equipoVisitante.select(equipoVisitante.getId());
		
		Random rnd = new Random();
		int ptosEquipoLocal=rnd.nextInt(4);
		int ptosEquipoVisitante=0;
		
		switch (ptosEquipoLocal) {
		case 0:
			ptosEquipoVisitante=3;
			this.resultado="0-3";
			break;
			
		case 1:
			ptosEquipoVisitante=2;
			this.resultado="1-2";
			break;
			
		case 2:
			ptosEquipoVisitante=1;
			this.resultado="2-1";
			break;
			
		case 3:
			ptosEquipoVisitante=0;
			this.resultado="3-0";
			break;
			
		}
		
		equipoLocal.setJornadasJugadasEnTemporadaActual(equipoLocal.getJornadasJugadasEnTemporadaActual()+1);
		equipoVisitante.setJornadasJugadasEnTemporadaActual(equipoVisitante.getJornadasJugadasEnTemporadaActual()+1);
		
		equipoLocal.setPuntos(equipoLocal.getPuntos()+ptosEquipoLocal);
		equipoVisitante.setPuntos(equipoVisitante.getPuntos()+ptosEquipoVisitante);
	}

	//DAO
	
	public Partido select(long id) {
		EntityManager manager = Manager.getEntityManagerFactory().createEntityManager();
		  String jpql = "SELECT m FROM MATCHES m WHERE m.id = :id";
	        Query query = manager.createQuery(jpql, Partido.class);
	        query.setParameter("id", id);

	        try {
	            return (Partido) query.getSingleResult();
	        } catch (Exception e) {
	            System.err.println("Exception");
	            return null;
	        }
	}

}