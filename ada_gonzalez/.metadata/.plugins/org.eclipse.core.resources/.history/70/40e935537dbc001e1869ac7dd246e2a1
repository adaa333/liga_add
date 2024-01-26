package entities;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import dao.CRUD;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

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

//DAO
	
}
