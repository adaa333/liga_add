package demo;

import entities.Patrocinador;

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
		Simulacion.cargarDatosEnDatabase(COMPETICION);
		Simulacion.simularTemporada2425(COMPETICION);
	
	}
}
