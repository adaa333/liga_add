package entities;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import util.DAO;
import util.Manager;

@Entity
@Table (name="SPONSORS")
public class Patrocinador implements DAO <Patrocinador>{
	
	@Id
	@GeneratedValue (strategy=GenerationType.IDENTITY)
	@Column(name="SPONSORS_ID")
	private int idPatrocinador;
	
	@Column (name="SPONSORS_NAME")
	private String name;
	
	@Column
	@ManyToMany (mappedBy="patrocinadores")
	private List<Equipo> equipos= new ArrayList<Equipo>();

	public int getIdPatrocinador() {
		return idPatrocinador;
	}

	public void setIdPatrocinador(int idPatrocinador) {
		this.idPatrocinador = idPatrocinador;
	}

	public String getName() {
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
	public void insert(Patrocinador entity) {
		Manager.persist(entity);
	}

	public void delete(int id) {
		// TODO Auto-generated method stub
		
	}

	public List<Patrocinador> selectAll() {
		// TODO Auto-generated method stub
		return null;
	}

	public Patrocinador select(int id) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
