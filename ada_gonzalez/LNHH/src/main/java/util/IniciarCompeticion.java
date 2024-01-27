package util;

import java.util.ArrayList;
import java.util.List;

import dao.CRUD;
import entities.Competicion;
import entities.Equipo;
import entities.Partido;

public class IniciarCompeticion {
	
	public static void iniciarTemporada(Competicion competicion) {
		CRUD<Equipo> crud = new CRUD<Equipo>(Equipo.class);
		
		List<Equipo> equiposDB = crud.selectAll();
		
		List<Partido> partidos = new ArrayList<Partido>();
		List<Partido> partidosVuelta2 = new ArrayList<Partido>();

		partidos.add(new Partido(equiposDB.get(0).getNombre()+"-"+equiposDB.get(1).getNombre()));
		partidos.add(new Partido(equiposDB.get(2).getNombre() + "-" + equiposDB.get(3).getNombre()));
		partidos.add(new Partido(equiposDB.get(4).getNombre() + "-" + equiposDB.get(5).getNombre()));

		partidos.add(new Partido(equiposDB.get(0).getNombre() + "-" + equiposDB.get(2).getNombre()));
		partidos.add(new Partido(equiposDB.get(1).getNombre() + "-" + equiposDB.get(6).getNombre()));
		partidos.add(new Partido(equiposDB.get(4).getNombre() + "-" + equiposDB.get(3).getNombre()));

		partidos.add(new Partido(equiposDB.get(0).getNombre() + "-" + equiposDB.get(3).getNombre()));
		partidos.add(new Partido(equiposDB.get(1).getNombre() + "-" + equiposDB.get(5).getNombre()));
		partidos.add(new Partido(equiposDB.get(2).getNombre() + "-" + equiposDB.get(6).getNombre()));

		partidos.add(new Partido(equiposDB.get(0).getNombre() + "-" + equiposDB.get(5).getNombre()));
		partidos.add(new Partido(equiposDB.get(1).getNombre() + "-" + equiposDB.get(2).getNombre()));
		partidos.add(new Partido(equiposDB.get(4).getNombre() + "-" + equiposDB.get(6).getNombre()));

		partidos.add(new Partido(equiposDB.get(0).getNombre() + "-" + equiposDB.get(4).getNombre()));
		partidos.add(new Partido(equiposDB.get(1).getNombre() + "-" + equiposDB.get(3).getNombre()));
		partidos.add(new Partido(equiposDB.get(6).getNombre() + "-" + equiposDB.get(5).getNombre()));

		partidos.add(new Partido(equiposDB.get(0).getNombre() + "-" + equiposDB.get(6).getNombre()));
		partidos.add(new Partido(equiposDB.get(2).getNombre() + "-" + equiposDB.get(4).getNombre()));
		partidos.add(new Partido(equiposDB.get(3).getNombre() + "-" + equiposDB.get(5).getNombre()));

		partidos.add(new Partido(equiposDB.get(1).getNombre() + "-" + equiposDB.get(4).getNombre()));
		partidos.add(new Partido(equiposDB.get(2).getNombre() + "-" + equiposDB.get(5).getNombre()));
		partidos.add(new Partido(equiposDB.get(3).getNombre() + "-" + equiposDB.get(6).getNombre()));
		for(Partido partido: partidos) {
			String [] equipos = partido.getTeams().split("-");
			partidosVuelta2.add(new Partido(equipos[1]+"-"+equipos[0]));
		}


		List<Jornada> jornadas= new ArrayList<Jornada>();

		
		for (int i=0; i<7;i+=3) {
			jornadas.add(new Jornada(competicion, partidos.get(i), partidos.get(i+1),partidos.get(i+2)));
		}
		
		for (int i=0; i<7;i+=3) {
			jornadas.add(new Jornada(competicion, partidosVuelta2.get(i), partidosVuelta2.get(i+1),partidosVuelta2.get(i+2)));
		}	
		
		//jornadas y partidos en memoria
		for(Jornada jornada: jornadas) {
			jornada.iniciarJornada();
		}
	}
	
}
