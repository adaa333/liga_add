package demo;

import entities.Patrocinador;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import entities.Competicion;
import entities.Deportista;
import entities.Equipo;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import util.CargarDatos;
import util.DataSource;

public class SimulacionMain {
	private static final Competicion COMPETICION= new Competicion("Liga Nacional de Hockey Hielo", new Date(1972, 11, 20), 7);
	public static void main(String[] args) {
		
		//Simulacion.cargarDatosEnDatabase(COMPETICION);
		//Simulacion.simularTemporada2425(COMPETICION);
		//Simulacion.simularBajas();
		
		/*Patrocinador patrocinador1=DataSource.getPatrocinadores().get(0);
		Patrocinador patrocinador2=DataSource.getPatrocinadores().get(1);
		
		Equipo equipo1=DataSource.getEquipos().get(0);
		Equipo equipo2=DataSource.getEquipos().get(1);*/
		
		/*equipo1.getPatrocinadores().add(patrocinador1);
		equipo1.getPatrocinadores().add(patrocinador2);
		
		equipo1.insert(equipo1);*/
		
		for(Equipo equipo: DataSource.getEquipos()) {
			for(Patrocinador patrocinador: DataSource.getPatrocinadoresPorEquipo(equipo)) {
				equipo.addPatrocinador(patrocinador);
			}
			equipo.insert(equipo);
		}
		
	
		
		
	
	}
}
