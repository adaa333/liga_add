package demo;

import entities.Partido;
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
import util.Jornada;

public class SimulacionMain {
	private static final Competicion COMPETICION= new Competicion("Liga Nacional de Hockey Hielo", new Date(1972, 11, 20), 7);
	public static void main(String[] args) {
		COMPETICION.insert(COMPETICION);
		CargarDatos.loadDataInDB();
		
		
		for(Patrocinador patrocinadorDS: DataSource.getPatrocinadores()) {
			Patrocinador patrocinadorDB =patrocinadorDS.select(patrocinadorDS.getIdPatrocinador());
			if(patrocinadorDB==null) {
				System.out.println(patrocinadorDS.getNombre()+" no está en la base de datos");
			}else {
				System.out.println(patrocinadorDB.getNombre()+"(DB)-"+patrocinadorDS.getNombre()+"(DS)");
			}
			
		}
		
	/*
	 *EntityManagerFactory emFactory= Persistence.createEntityManagerFactory("lnhh");
		EntityManager eManager= emFactory.createEntityManager();
		
		eManager.getTransaction().begin();
		
	//equipo1
		Equipo equipo1= new Equipo("Club Hielo Jaca Hockey", "Pabellón de Hielo de Jaca");
		eManager.persist(equipo1);
		
		Deportista centro1= new Deportista("Adrian Aranguren","09/02/1998", "Español", equipo1);
		eManager.persist(centro1);
		Deportista goalie1= new Deportista("Raúl Barbo", "12/02/2000", "Español", equipo1);
		eManager.persist(goalie1);
		Deportista dd1= new Deportista("Alfred Encinar", "22/07/2003", "Español", equipo1);
		eManager.persist(dd1);
		Deportista di1= new Deportista("Guillermo Betrán", "12/10/1985", "Español", equipo1);
		eManager.persist(di1);
		Deportista ad1= new Deportista("Jaime Capillas", "13/02/2001", "Español", equipo1);
		eManager.persist(ad1);
		Deportista ai1= new Deportista("Pablo Pantoja", "23/09/1996", "Español", equipo1);
		eManager.persist(ai1);
		
		//asignarJugadores(equipo1, centro1, goalie1, dd1, di1, ad1, ai1);
		
	//equipo2
		
		Equipo equipo2= new Equipo("Club Gel Puigcerdà", "Club Poliesportiu Puigcerdà");
		eManager.persist(equipo2);
		
		Deportista centro2= new Deportista("Bastien Tona", "07/03/1989", "Español", equipo2);
		eManager.persist(centro2);
		Deportista goalie2= new Deportista("Riku Törnqvist", "05/05/1998", "Finés", equipo2);
		eManager.persist(goalie2);
		Deportista dd2= new Deportista("David Caballero", "07/11/1996", "Español", equipo2);
		eManager.persist(dd2);
		Deportista di2= new Deportista("Jorge Piñar", "03/03/1992", "Español", equipo2);
		eManager.persist(di2);
		Deportista ad2= new Deportista("Oriol Boronat", "11/05/1992", "Español",equipo2);
		eManager.persist(ad2);
		Deportista ai2= new Deportista("Pol Piedra", "14/07/1997", "Español", equipo2);
		eManager.persist(ai2);
		
		//asignarJugadores(equipo2, centro2, goalie2, dd2, di2, ad2, ai2);
		
	//equipo3
		
		Equipo equipo3= new Equipo("Fútbol Club Barcelona", "Pista de hielo del FC Barcelona");
		eManager.persist(equipo3);
		
		Deportista centro3= new Deportista("Joaquim Muratet", "07/03/1989", "Español", equipo3);
		eManager.persist(centro3);
		Deportista goalie3= new Deportista("David Ros", "27/03/2003", "Español", equipo3);
		eManager.persist(goalie3);
		Deportista dd3= new Deportista("Alex Torres", "07/11/1996", "Español", equipo3);
		eManager.persist(dd3);
		Deportista di3= new Deportista("Arturo Guerra", "03/03/1992", "Español", equipo3);
		eManager.persist(di3);
		Deportista ad3= new Deportista("Ernest Muratet", "07/03/1989", "Español", equipo3);
		eManager.persist(ad3);
		Deportista ai3= new Deportista("Marc Layola", "19/11/1998", "Español", equipo3);
		eManager.persist(ai3);
		
		//asignarJugadores(equipo3, centro3, goalie3, dd3, di3, ad3, ai3);
		
	//equipo4
		
		Equipo equipo4= new Equipo("TXURI URDIN", "Pista de hielo en Donostia-San Sebastián");
		eManager.persist(equipo4);
		
		Deportista centro4= new Deportista("Maxime Lutaud", "17/11/1989", "Español", equipo4);
		eManager.persist(centro4);
		Deportista goalie4= new Deportista("Iker Etxeberria", "27/03/1994", "Español", equipo4);
		eManager.persist(goalie4);
		Deportista dd4= new Deportista("Mickael Fernandez", "15/11/1992", "Español", equipo4);
		eManager.persist(dd4);
		Deportista di4= new Deportista("Jimmy Ferrez", "08/03/1997", "Español", equipo4);
		eManager.persist(di4);
		Deportista ad4= new Deportista("Ramiro Remesar", "19/03/1990", "Español", equipo4);
		eManager.persist(ad4);
		Deportista ai4= new Deportista("Borja Ruiz", "23/11/1998", "Español", equipo4);
		eManager.persist(ai4);
		
		//asignarJugadores(equipo4, centro4, goalie4, dd4, di4, ad4, ai4);
		
	//equipo5
		Equipo equipo5= new Equipo("SAD Majadahonda", "La Nevera");
		eManager.persist(equipo5);
		
		Deportista centro5= new Deportista("Gonzalo Ansa", "08/09/1991", "Español", equipo5);
		eManager.persist(centro5);
		Deportista goalie5= new Deportista("Alan Gemmel", "27/03/2003", "Inglés", equipo5);
		eManager.persist(goalie5);
		Deportista dd5= new Deportista("Eduardo Paz", "12/12/1981", "Español", equipo5);
		eManager.persist(dd5);
		Deportista di5= new Deportista("Adrian González", "29/06/1992", "Español", equipo5);
		eManager.persist(di5);
		Deportista ad5= new Deportista("Javier Senac", "24/12/1990", "Español", equipo5);
		eManager.persist(ad5);
		Deportista ai5= new Deportista("Alejandro Pedraz", "04/09/1991", "Español", equipo5);
		eManager.persist(ai5);
		
		//asignarJugadores(equipo5, centro5, goalie5, dd5, di5, ad5, ai5);
		
	//equipo6
		
		Equipo equipo6= new Equipo("Kosner Club", "Palacio de Hielo de Huarte");
		eManager.persist(equipo6);
		
		Deportista centro6= new Deportista("Alejandro Hernández", "08/09/1991", "Español", equipo6);
		eManager.persist(centro6);
		Deportista goalie6= new Deportista("Alex Biec", "12/05/2000", "Inglés", equipo6);
		eManager.persist(goalie6);
		Deportista dd6= new Deportista("Elías Arraiza", "18/12/1992", "Español", equipo6);
		eManager.persist(dd6);
		Deportista di6= new Deportista("Sergio Martínez", "06/04/1995", "Español", equipo6);
		eManager.persist(di6);
		Deportista ad6= new Deportista("Pablo Zapata", "01/10/1993", "Español", equipo6);
		eManager.persist(ad6);
		Deportista ai6= new Deportista("Pablo Guerra", "23/09/1989", "Español", equipo6);
		eManager.persist(ai6);
		
		//asignarJugadores(equipo5, centro5, goalie5, dd5, di5, ad5, ai5);
		
	//equipo7
		
		Equipo equipo7= new Equipo("Logroño Panthers", "Milenio Club Patín");
		eManager.persist(equipo7);
		
		Deportista centro7= new Deportista("Salvador Barnola", "15/02/2001", "Venezolano", equipo7);
		eManager.persist(centro7);
		Deportista goalie7= new Deportista("Diego Perez", "26/03/2000", "Español", equipo7);
		eManager.persist(goalie7);
		Deportista dd7= new Deportista("Pol González", "02/10/1996", "Español", equipo7);
		eManager.persist(dd7);
		Deportista di7= new Deportista("Alejandro Hernandez", "04/09/1998", "Español", equipo7);
		eManager.persist(di7);
		Deportista ad7= new Deportista("Oscar Vázquez", "30/12/1997", "Español", equipo7);
		eManager.persist(ad7);
		Deportista ai7= new Deportista("Guillermo Betrán", "23/04/2002", "Español", equipo7);
		eManager.persist(ai7);
		
		//asignarJugadores(equipo5, centro5, goalie5, dd5, di5, ad5, ai5);
		
	//inicio temporada
		
		//jornada1
		Partido partido1= new Partido(equipo1,equipo2);
		eManager.persist(partido1);
		
		Partido partido2= new Partido(equipo3,equipo4);
		eManager.persist(partido2);
		
		Partido partido3= new Partido(equipo5,equipo6);
		eManager.persist(partido3);
		
		Jornada jornada1= new Jornada(COMPETICION,partido1,partido2,partido3);
		
		jornada1.iniciarJornada();
		
		//jornada2
		Partido partido4= new Partido(equipo1,equipo3);
		eManager.persist(partido1);
		
		Partido partido5= new Partido(equipo4,equipo5);
		eManager.persist(partido2);
		
		Partido partido6= new Partido(equipo2,equipo6);
		eManager.persist(partido3);
		
		Jornada jornada2= new Jornada(COMPETICION,partido1,partido2,partido3);
		
		jornada2.iniciarJornada();
		
		eManager.getTransaction().commit();
	}

	/*private static void asignarJugadores(Equipo equipo, Deportista centro, Deportista goalie, 
			Deportista defensaDerecha,Deportista defensaIzquierda, Deportista alaDerecha, Deportista alaIzquierda) {
		equipo.setCentro(centro.getNombre());
		equipo.setGoalKeeper(goalie.getNombre());
		equipo.setAlaDch(alaDerecha.getNombre());
		equipo.setAlaIzq(alaIzquierda.getNombre());
		equipo.setDefensaDch(defensaDerecha.getNombre());
		equipo.setDefensaIzq(defensaIzquierda.getNombre());
	}*/ 
		
		
	}
}
