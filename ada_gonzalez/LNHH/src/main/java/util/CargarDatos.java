package util;

import java.util.ArrayList;
import java.util.List;

import entities.Deportista;
import entities.Equipo;
import entities.Patrocinador;

public class CargarDatos {
	
	public static void loadDataInDB() {
		for(Equipo equipo:DataSource.equipos) {
			
		//asignar patrocinadores del equipo
			List<Patrocinador> patrocinadoresDelEquipo= new ArrayList<Patrocinador>();
			
			for(Patrocinador patrocinador: DataSource.patrocinadores) {
				if(patrocinador.getEquipos().contains(equipo)) {
					patrocinadoresDelEquipo.add(patrocinador);
				}
			}
			equipo.setPatrocinadores(patrocinadoresDelEquipo);
			
		//asignar jugadores del equipo
			equipo.setJugadores(DataSource.deportistas.get(equipo.getNombre()));
			
			for (Deportista deportista: equipo.getJugadores()) {
				deportista.setEquipoActual(equipo);
			}
			
			equipo.insert(equipo);
		
		//insertar patrocinadores
			
			/*for(Patrocinador patrocinador: equipo.getPatrocinadores()) {
				if(patrocinador.getIdPatrocinador() != null) {
					patrocinador.update(patrocinador);
				}else {
					patrocinador.insert(patrocinador);
				}
			}
			
		//insertar jugadores
			
			for(Deportista deportista: equipo.getJugadores()) {
				if(deportista.getId()!=null) {
					deportista.update(deportista);
				}else {
					deportista.insert(deportista);
				}
			}*/
			
		}
		
		
	}
}
