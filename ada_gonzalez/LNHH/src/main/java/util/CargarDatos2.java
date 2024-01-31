package util;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import entities.Deportista;
import entities.Equipo;
import entities.Patrocinador;

public class CargarDatos2 {
	private static Logger logger=LogManager.getLogger(CargarDatos2.class.getName());
	/*public static void loadData() {
		for(Equipo equipo:DataSource.getEquipos()) {
			equipo.insert(equipo);
			List<Patrocinador> patrocinadoresDelEquipo= new ArrayList<Patrocinador>();
			
			for(Patrocinador patrocinador: DataSource.getPatrocinadores()) {
				if(patrocinador.getEquipos().contains(equipo)) {
					patrocinadoresDelEquipo.add(patrocinador);
				}
					
			}
			
			Equipo equipoRecuperado= equipo.select(equipo.getId());
			
			equipoRecuperado.setJugadores(DataSource.getDeportistas().get(equipoRecuperado.getNombre()));
			equipoRecuperado.update(equipoRecuperado);
			

			//equipoRecuperado.setPatrocinadores(patrocinadoresDelEquipo);
			
			for (Patrocinador patrocinador: equipoRecuperado.getPatrocinadores()) {
				
				if(patrocinador.getIdPatrocinador()!=null) {
					patrocinador.update(patrocinador);
				}else {
					patrocinador.insert(patrocinador);
				}
			}
			
			for (Deportista deportista: equipoRecuperado.getJugadores()) {
				deportista.insert(deportista);
			}
			
			equipo.update(equipoRecuperado);
		}
	}*/
	
	public static void loadData() {
		List<Equipo> equipos = DataSource.getEquipos();
    	Map<String, List<Deportista>> jugadoresPorEquipo = DataSource.getDeportistas();
    	
    	for (Equipo equipo : equipos) {
			// Insertar equipo
    		equipo.insert(equipo);
    		
    		//Obtener jugadores por equipo
    		List<Deportista> jugadores = jugadoresPorEquipo.get(equipo.getNombre());
    		
    		
    		//Insertar Jugadores
    		for (Deportista jugador : jugadores) { 
                logger.info("Insertando jugador en la base de datos: " + jugador.getNombre());
    			jugador.setEquipoActual(equipo);
    			equipo.addJugador(jugador);

    			if (jugador.getId() != null) {
                    jugador.update(jugador); 
                } else {
                    jugador.insert(jugador);                
                }
    		} 		
    		for (Patrocinador sponsor : DataSource.getPatrocinadoresPorEquipo(equipo)) { 
    			
    				logger.info("Insertando sponsor en la base de datos: " + sponsor.getNombre());
        			sponsor.addEquipo(equipo);
        			equipo.addPatrocinador(sponsor);

                    // Si el sponsor ya está en la base de datos, actualizar en lugar de guardar
                    if (sponsor.getId() != null) {
                        sponsor.update(sponsor);
                        
                    } else {
                        sponsor.insert(sponsor);                    
                    }  
                          			
    		}    	
    		
    		equipo.update(equipo);
    	}   	

	}
}


