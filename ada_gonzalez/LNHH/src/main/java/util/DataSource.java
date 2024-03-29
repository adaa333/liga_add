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
	
	public static List<Deportista> getNuevasIncorporaciones() {
		return nuevasIncorporaciones;
	}
	
	public static List<Patrocinador> getPatrocinadoresPorEquipo(Equipo equipo) {
		
		return patrocinadoresPorEquipo.get(equipo);
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
        
       /*private static List<Patrocinador> patrocinadores= new ArrayList<Patrocinador>(Arrays.asList(
        		new Patrocinador("Ambar", new ArrayList<Equipo>(Arrays.asList(equipos.get(0), equipos.get(3), equipos.get(5)))), 
        		new Patrocinador("Huesca la magia", new ArrayList<Equipo>(Arrays.asList(equipos.get(0)))),
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
        		
        		));*/
        
        static List<Deportista> nuevasIncorporaciones = new ArrayList<>(Arrays.asList(
        		new Deportista("Lucía González", "28/05/1995", "Argentino", "ALA IZQUIERDA"),
        		new Deportista("Javier López", "10/11/1998", "Mexicano", "DEFENSA DERECHA"),
        		new Deportista("Aisha Patel", "03/09/1993", "Indio", "ALA DERECHA"),
        		new Deportista("Olga Ivanova", "17/07/1990", "Ruso", "PORTERO"),
        		new Deportista("Abdul Rahman", "22/03/1996", "Saudí", "CENTRO"),
        		new Deportista("Carmen Rodríguez", "14/12/1997", "Español", "ALA IZQUIERDA"),
        		new Deportista("Mateo Silva", "19/08/1994", "Uruguayo", "DEFENSA IZQUIERDA"),
        		new Deportista("Airi Tanaka", "02/04/2000", "Japonés", "ALA DERECHA"),
        		new Deportista("Mikhail Sokolov", "09/01/1992", "Ruso", "DEFENSA DERECHA"),
        		new Deportista("Elena Martinez", "08/06/1999", "Español", "PORTERO")
        		
        		));
        
        
        private static List<Patrocinador> patrocinadores= new ArrayList<Patrocinador>(Arrays.asList(
        		new Patrocinador("Ambar"), 
        		new Patrocinador("Huesca la magia"),
        		new Patrocinador("Carrefour"),
        		new Patrocinador("LaPerla"),
        		new Patrocinador("Mafesa"),
        		new Patrocinador("Óptica 70"),
        		new Patrocinador("Mantenimientos Chema"),
        		new Patrocinador("Logroño Deporte"),
        		new Patrocinador("Fabra Motor"),
        		new Patrocinador("Campus Cerdania"),
        		new Patrocinador("Arche"),
        		new Patrocinador("Comunidad de Madrid"),
        		new Patrocinador("Go Fit"),
        		new Patrocinador("Bauer"),
        		new Patrocinador("La Caixa"),
        		new Patrocinador("Kosner"),
        		new Patrocinador("Comantur"),
        		new Patrocinador("Latasa"),
        		new Patrocinador("Tecman"),
        		new Patrocinador("Conor VRC")
        		
        		));
        
        @SuppressWarnings( "serial" )
		static Map<Equipo, List<Patrocinador>> patrocinadoresPorEquipo = new HashMap<Equipo, List<Patrocinador>>() {{
            put(equipos.get(0), Arrays.asList(patrocinadores.get(0), patrocinadores.get(1), patrocinadores.get(3), patrocinadores.get(4), patrocinadores.get(10), patrocinadores.get(15)));
            put(equipos.get(1), Arrays.asList(patrocinadores.get(5), patrocinadores.get(6), patrocinadores.get(9), patrocinadores.get(13), patrocinadores.get(17)));
            put(equipos.get(2), Arrays.asList(patrocinadores.get(2), patrocinadores.get(4), patrocinadores.get(8), patrocinadores.get(11), patrocinadores.get(14), patrocinadores.get(18)));
            put(equipos.get(3), Arrays.asList(patrocinadores.get(5), patrocinadores.get(7), patrocinadores.get(10), patrocinadores.get(13), patrocinadores.get(19)));
            put(equipos.get(4), Arrays.asList(patrocinadores.get(2), patrocinadores.get(8), patrocinadores.get(12), patrocinadores.get(16), patrocinadores.get(18)));
            put(equipos.get(5), Arrays.asList(patrocinadores.get(0), patrocinadores.get(3), patrocinadores.get(9), patrocinadores.get(14), patrocinadores.get(19)));
            put(equipos.get(6), Arrays.asList(patrocinadores.get(4), patrocinadores.get(7), patrocinadores.get(12), patrocinadores.get(16), patrocinadores.get(17), patrocinadores.get(18)));
        }};
}
