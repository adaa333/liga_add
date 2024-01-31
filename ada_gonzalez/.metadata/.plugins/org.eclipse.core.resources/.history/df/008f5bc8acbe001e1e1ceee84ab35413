package demo;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import entities.Competicion;
import entities.Equipo;
import util.CargarDatos;

public class Simulacion {
	
	private static List<Equipo> equiposDB=new ArrayList<Equipo>();
	
	
	public static void cargarDatosEnDatabase(Competicion competicion) {
		competicion.insert(competicion);
		CargarDatos.loadDataInDB();
	}
	
	public static void simularTemporada2425(Competicion competicion) {
		List<Equipo> equiposDB=getEquiposDB();
		//inicio temporada
		System.out.println("Inicio de la "+Competicion.getNombre()+" - (since"+Competicion.getFechaCreacion()+")");

		for(int i=0; i<14;i++) {
			//jornada1
			System.out.println("::JORNADA["+(i+1)+"]::");
			//-partido1
			System.out.println("::::PRIMER PARTIDO DE LA JORNADA["+(i+1)+"]::::");	
			
			
			
			System.out.println("::::SEGUNDO PARTIDO DE LA JORNADA["+(i+1)+"]::::");	
			
			System.out.println("::::TERCER PARTIDO DE LA JORNADA["+(i+1)+"]::::");	
		}
	}

	public static List<Equipo> getEquiposDB() {
		return equiposDB;
	}
	
	public static void simularPartido(Equipo equipoLocal, Equipo equipoVisitante) {
		Random rnd = new Random();
		int ptosEquipoLocal=rnd.nextInt(4);
		int ptosEquipoVisitante=0;
		
		switch(ptosEquipoLocal) {
			case 0:
				ptosEquipoVisitante=3;
				break;
			case 1:
				ptosEquipoVisitante=2;
				break;
			case 2:
				ptosEquipoVisitante=1;
				break;
			case 3:
				ptosEquipoVisitante=0;
				break;
			}
		equipoLocal.addPartido(ptosEquipoLocal);
		equipoVisitante.addPartido(ptosEquipoVisitante);
		
	}
}
