package actividades.profesional;

import java.util.Scanner;

import lib.Matriceslib;

public class Notas {
		
	//DECLARAMOS SCANNER
	static Scanner sc = new Scanner(System.in);
	
	public static int numeroUsuario(String texto) {
		System.out.println(texto);
		return sc.nextInt();
	}
	public static void main(String[] args) {
		
		int col = 0;
		int filas = 0;
		do {
			
		
		 filas = numeroUsuario("Nº de Alumnos - [Nº Max: 20 | [Nº Min: 2]: ");
		 col = numeroUsuario("Nº de Materias - [Nº Max: 7] | [Nº Min: 3]: ");
		
		} while ((filas < 2 || filas > 20) || (col < 3 || col > 7));
		
	
		int[][] classe = new int[filas][col];
		
		String[] materias = { "Castellano", "Matemáticas", "Historia", "Biologia", "Gimnasia", "Religion",
		"Tutoria" };
		
		
		
		

	}

}
