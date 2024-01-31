package util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Reader {

	
	
	public static String [] obtenerEnfrentamientos() {
		String [] enfrentamientos = null;
		File file= new File("calendario_liga//enfrentamientos.txt");
		try(BufferedReader buffer= new BufferedReader(new FileReader(file))){
			enfrentamientos=buffer.readLine().split(" - ");
		}catch (IOException io) {
			System.err.println("Ocurrió un error al leer el fichero de enfrentamientos");
		}
		
		return  enfrentamientos;
	}
}
