package entities;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import dao.CRUD;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Query;
import jakarta.persistence.Table;
import util.Manager;

@Entity
@Table (name="SPONSORS")
public class Patrocinador extends CRUD<Patrocinador>{
	
	private static Logger logger=LogManager.getLogger(Equipo.class.getName());

	@Id
	@GeneratedValue (strategy=GenerationType.IDENTITY)
	@Column(name="SPONSORS_ID")
	private Long idPatrocinador;
	
	@Column (name="SPONSORS_NAME")
	private String name;
	
	@Column
	@ManyToMany (mappedBy="patrocinadores")
	private List<Equipo> equipos= new ArrayList<Equipo>();

	
//getters y setters
	
	public void addEquipo(Equipo equipo) {
	    equipos.add(equipo);
	    equipo.getPatrocinadores().add(this);
	    this.update(this);
	}
	
	public Long getIdPatrocinador() {
		return idPatrocinador;
	}

	public void setIdPatrocinador(Long idPatrocinador) {
		this.idPatrocinador = idPatrocinador;
	}

	public String getNombre() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Equipo> getEquipos() {
		return equipos;
	}

	public void setEquipos(List<Equipo> equipos) {
		this.equipos = equipos;
	}

	public Patrocinador(String name, List<Equipo> equipos) {
		this.name = name;
		this.equipos=equipos;
	}

public Patrocinador() {
		// TODO Auto-generated constructor stub
	}

	//DAO
	public Patrocinador select(long id) {
		EntityManager manager = Manager.getEntityManagerFactory().createEntityManager();

		 String jpql = "SELECT p FROM Patrocinador p WHERE p.id = :id";
	     Query query = manager.createQuery(jpql, Patrocinador.class);
	     query.setParameter("id", id);
	
	        try {
	            return (Patrocinador) query.getSingleResult();
	        } catch (Exception e) {
	            System.err.println("EXCEPCION");
	            return null;
	        }
	}
}
