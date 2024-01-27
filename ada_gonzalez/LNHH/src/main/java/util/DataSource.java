package util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import entities.Deportista;
import entities.Equipo;
import entities.Patrocinador;

public class DataSource {
	
	public DataSource() {}
	
	public static List<Patrocinador> getPatrocinadores() {
		return patrocinadores;
	}
	
	public static List<Equipo> getEquipos() {
		return equipos;
	}
	
	public static Map<String, List<Deportista>> getDeportistas() {
		return deportistas;
	}

	static List <Equipo> equipos= new ArrayList<Equipo>(Arrays.asList(	
			new Equipo("Club Hielo Jaca Hockey", "Pabellón de Hielo de Jaca"),
			new Equipo("Club Gel Puigcerdà", "Club Poliesportiu Puigcerdà"),
			new Equipo("Fútbol Club Barcelona", "Pista de hielo del FC Barcelona"),
			new Equipo("TXURI URDIN", "Pista de hielo en Donostia-San Sebastián"),
			new Equipo("SAD Majadahonda", "La Nevera"),
			new Equipo("Club de Hielo Huarte", "Palacio de Hielo de Huarte"),
			new Equipo("Logroño Panthers", "Milenio Club Patín"))
			);
	
    @SuppressWarnings("serial")
    static Map<String, List<Deportista>> deportistas = new HashMap<String, List<Deportista>>() {{
            put("Club Hielo Jaca Hockey", new ArrayList<Deportista>(Arrays.asList(
                new Deportista("Adrian Aranguren", "09/02/1998", "Español", "CENTRO"),
                new Deportista("Raúl Barbo", "12/02/2000", "Español", "PORTERO"),
                new Deportista("Alfred Encinar", "22/07/2003", "Español", "DEFENSA DERECHA"),
                new Deportista("Guillermo Betrán", "12/10/1985", "Español", "DEFENSA IZQUIERDA"),
                new Deportista("Jaime Capillas", "13/02/2001", "Español", "ALA DERECHA"),
                new Deportista("Pablo Pantoja", "23/09/1996", "Español", "ALA IZQUIERDA")
            )));
            
            put("Club Gel Puigcerdà", new ArrayList<Deportista>(Arrays.asList(
            		new Deportista("Bastien Tona", "07/03/1989", "Español", "CENTRO"),
    				new Deportista("Riku Törnqvist", "05/05/1998", "Finés", "PORTERO"),
    				new Deportista("David Caballero", "07/11/1996", "Español", "DEFENSA DERECHA"),
    				new Deportista("Jorge Piñar", "03/03/1992", "Español", "DEFENSA IZQUIERDA"),
    				new Deportista("Oriol Boronat", "11/05/1992", "Español", "ALA DERECHA"),
    				new Deportista("Pol Piedra", "14/07/1997", "Español", "ALA IZQUIERDA")
	        )));
            
            put("Fútbol Club Barcelona", new ArrayList<Deportista>(Arrays.asList(
            		new Deportista("Joaquim Muratet", "07/03/1989", "Español", "CENTRO"),
            		new Deportista("David Ros", "27/03/2003", "Español", "PORTERO"),
    				new Deportista("Alex Torres", "07/11/1996", "Español", "DEFENSA DERECHA"),
    				new Deportista("Arturo Guerra", "03/03/1992", "Español", "DEFENSA IZQUIERDA"),
    				new Deportista("Ernest Muratet", "07/03/1989", "Español", "ALA DERECHA"),
    				new Deportista("Marc Layola", "19/11/1998", "Español", "ALA IZQUIERDA")
            )));
            
            put("TXURI URDIN", new ArrayList<Deportista>(Arrays.asList(
            		new Deportista("Maxime Lutaud", "17/11/1989", "Español", "CENTRO"),
            		new Deportista("Iker Etxeberria", "27/03/1994", "Español", "PORTERO"),
    				new Deportista("Mickael Fernandez", "15/11/1992", "Español", "DEFENSA DERECHA"),
    				new Deportista("Jimmy Ferrez", "08/03/1997", "Español", "DEFENSA IZQUIERDA"),
    				new Deportista("Ramiro Remesar", "19/03/1990", "Español", "ALA DERECHA"),
    				new Deportista("Borja Ruiz", "23/11/1998", "Español", "ALA IZQUIERDA")
            )));
            
            put("SAD Majadahonda", new ArrayList<Deportista>(Arrays.asList(
            		new Deportista("Gonzalo Ansa", "08/09/1991", "Español", "CENTRO"),
            		new Deportista("Alan Gemmel", "27/03/2003", "Inglés", "PORTERO"),
    				new Deportista("Eduardo Paz", "12/12/1981", "Español", "DEFENSA DERECHA"),
    				new Deportista("Adrian González", "29/06/1992", "Español", "DEFENSA IZQUIERDA"),
    				new Deportista("Javier Senac", "24/12/1990", "Español", "ALA DERECHA"),
    				new Deportista("Alejandro Pedraz", "04/09/1991", "Español", "ALA IZQUIERDA")
            )));
            
            put("Club de Hielo Huarte", new ArrayList<Deportista>(Arrays.asList(
            		new Deportista("Alejandro Hernández", "08/09/1991", "Español", "CENTRO"),
            		new Deportista("Alex Biec", "12/05/2000", "Inglés", "PORTERO"),
    				new Deportista("Elías Arraiza", "18/12/1992", "Español", "DEFENSA DERECHA"),
    				new Deportista("Sergio Martínez", "06/04/1995", "Español", "DEFENSA IZQUIERDA"),
    				new Deportista("Pablo Zapata", "01/10/1993", "Español", "ALA DERECHA"),
    				new Deportista("Pablo Guerra", "23/09/1989", "Español", "ALA IZQUIERDA")
            )));
            
            put("Logroño Panthers", new ArrayList<Deportista>(Arrays.asList(
	                new Deportista("Salvador Barnola", "15/02/2001", "Español", "CENTRO"),
	                new Deportista("Diego Perez", "26/03/2000", "Español", "PORTERO"),
	                new Deportista("Pol González", "02/10/1996", "Español", "DEFENSA DERECHA"),
	                new Deportista("Alejandro Hernandez", "04/09/1998", "Español", "DEFENSA IZQUIERDA"),
	                new Deportista("Oscar Vázquez", "30/12/1997", "Español", "ALA DERECHA"),
	                new Deportista("Guillermo Betrán", "23/04/2002", "Español", "ALA IZQUIERDA")
	            )));
            
            
        }};
        
        private static List<Patrocinador> patrocinadores= new ArrayList<Patrocinador>(Arrays.asList(
        		new Patrocinador("Ambar", new ArrayList<Equipo>(Arrays.asList(equipos.get(0), equipos.get(3), equipos.get(5)))), 
        		new Patrocinador("Huesca la magia", new ArrayList<Equipo>(Arrays.asList(equipos.get(1)))),
        		new Patrocinador("Carrefour", new ArrayList<Equipo>(Arrays.asList(equipos.get(2), equipos.get(4), equipos.get(6)))),
        		new Patrocinador("LaPerla", new ArrayList<Equipo>(Arrays.asList(equipos.get(0), equipos.get(2)))),
        		new Patrocinador("Mafesa", new ArrayList<Equipo>(Arrays.asList(equipos.get(1), equipos.get(2)))),
        		new Patrocinador("Óptica 70", new ArrayList<Equipo>(Arrays.asList(equipos.get(3), equipos.get(5)))),
        		new Patrocinador("Mantenimientos Chema", new ArrayList<Equipo>(Arrays.asList(equipos.get(1), equipos.get(3)))),
        		new Patrocinador("Logroño Deporte", new ArrayList<Equipo>(Arrays.asList(equipos.get(6)))),
        		new Patrocinador("Fabra Motor", new ArrayList<Equipo>(Arrays.asList(equipos.get(1), equipos.get(2)))),
        		new Patrocinador("Campus Cerdania", new ArrayList<Equipo>(Arrays.asList(equipos.get(3), equipos.get(4)))),
        		new Patrocinador("Arche", new ArrayList<Equipo>(Arrays.asList(equipos.get(0)))),
        		new Patrocinador("Comunidad de Madrid", new ArrayList<Equipo>(Arrays.asList(equipos.get(4)))),
        		new Patrocinador("Go Fit", new ArrayList<Equipo>(Arrays.asList(equipos.get(1), equipos.get(2), equipos.get(5)))),
        		new Patrocinador("Bauer", new ArrayList<Equipo>(Arrays.asList(equipos.get(2)))),
        		new Patrocinador("La Caixa", new ArrayList<Equipo>(Arrays.asList(equipos.get(0), equipos.get(2)))),
        		new Patrocinador("Kosner", new ArrayList<Equipo>(Arrays.asList(equipos.get(5)))),
        		new Patrocinador("Comantur", new ArrayList<Equipo>(Arrays.asList(equipos.get(1), equipos.get(3)))),
        		new Patrocinador("Latasa", new ArrayList<Equipo>(Arrays.asList(equipos.get(4), equipos.get(6)))),
        		new Patrocinador("Tecman", new ArrayList<Equipo>(Arrays.asList(equipos.get(6), equipos.get(2)))),
        		new Patrocinador("Conor VRC", new ArrayList<Equipo>(Arrays.asList(equipos.get(3), equipos.get(5))))
        		
        		));
        

}
