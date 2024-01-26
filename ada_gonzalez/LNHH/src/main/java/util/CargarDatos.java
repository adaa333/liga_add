package util;

import java.util.ArrayList;
import java.util.List;

import entities.Deportista;
import entities.Equipo;
import entities.Patrocinador;

public class CargarDatos {
	
	public static void loadDataInDB() {
		for(Equipo equipo:DataSource.equipos) {
			equipo.insert(equipo);
			
			List<Patrocinador> patrocinadoresDelEquipo= new ArrayList<Patrocinador>();
			
			for(Patrocinador patrocinador: DataSource.patrocinadores) {
				if(patrocinador.getEquipos().contains(equipo)) {
					patrocinadoresDelEquipo.add(patrocinador);
				}
			}
			
			Equipo equipoRecuperado= equipo.select(equipo.getId());
			equipoRecuperado.setPatrocinadores(patrocinadoresDelEquipo);

	
			for(Patrocinador patrocinador: equipoRecuperado.getPatrocinadores()) {
				patrocinador.getEquipos().add(equipoRecuperado);
				if(patrocinador.getIdPatrocinador()!=null) {
					patrocinador.update(patrocinador);
				}else{
					patrocinador.insert(patrocinador);
				}
				System.out.println(patrocinador.getNombre());
				
			}
			equipoRecuperado.setJugadores(DataSource.deportistas.get(equipo.getNombre()));
			equipoRecuperado.update(equipoRecuperado);
			
			for (Deportista deportista: equipo.getJugadores()) {
				deportista.insert(deportista);
			}
	
			
			
			
		}
	}
	
	/*public static void loadSponsors() {
		for(Patrocinador patrocinador: DataSource.patrocinadores) {
			for(Equipo equipo: patrocinador.getEquipos()) {
				Equipo equipoRecuperado=equipo.select(equipo.getId());
				
				equipoRecuperado.getPatrocinadores();
			}
		}
	}*/
	
}
