package util;

import entities.Competicion;
import entities.Partido;

public class Jornada {
	
	private int idJornada;
	
	private Competicion competicion;
	private Partido partido1;
	private Partido partido2;
	private Partido partido3;
	
	private String equiposPartido1;
	private String equiposPartido2;
	private String equiposPartido3;
	
	private Partido[] partidos = new Partido[3];
	
//getters y setters
	public Competicion getCompeticion() {
		return competicion;
	}
	public void setCompeticion(Competicion competicion) {
		this.competicion = competicion;
	}
	public Partido getPartido1() {
		return partido1;
	}
	public void setPartido1(Partido partido1) {
		this.partido1 = partido1;
	}
	public Partido getPartido2() {
		return partido2;
	}
	public void setPartido2(Partido partido2) {
		this.partido2 = partido2;
	}
	public Partido getPartido3() {
		return partido3;
	}
	public void setPartido3(Partido partido3) {
		this.partido3 = partido3;
	}
	

	public int getIdJornada() {
		return idJornada;
	}
	public void setIdJornada(int idJornada) {
		this.idJornada = idJornada;
	}
	
	public String getEquiposPartido1() {
		return equiposPartido1;
	}
	public void setEquiposPartido1(String equiposPartido1) {
		this.equiposPartido1 = equiposPartido1;
	}
	public String getEquiposPartido2() {
		return equiposPartido2;
	}
	public void setEquiposPartido2(String equiposPartido2) {
		this.equiposPartido2 = equiposPartido2;
	}
	public String getEquiposPartido3() {
		return equiposPartido3;
	}
	public void setEquiposPartido3(String equiposPartido3) {
		this.equiposPartido3 = equiposPartido3;
	}
	public Partido[] getPartidos() {
		return partidos;
	}
	public void setPartidos(Partido[] partidos) {
		this.partidos = partidos;
	}
	
//constructor
	
	public Jornada(Competicion competicion, Partido partido1, Partido partido2, Partido partido3) {
		this.competicion = competicion;
		this.partido1 = partido1;
		this.partido2 = partido2;
		this.partido3 = partido3;
	}
	
//
	public void iniciarJornada() {
		partido1.iniciar();
		partido2.iniciar();
		partido3.iniciar();
		competicion.getJornadas().getAndIncrement();
		
		setEquiposPartido1(partido1.getEquipoLocal()+"_"+partido1.getEquipoVisitante());
		setEquiposPartido2(partido2.getEquipoLocal()+"_"+partido2.getEquipoVisitante());
		setEquiposPartido3(partido3.getEquipoLocal()+"_"+partido3.getEquipoVisitante());
	}
	
}
