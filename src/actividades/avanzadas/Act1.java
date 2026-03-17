package actividades.avanzadas;
	/*	
	 	1. Crea una matriz 3x3 con números del 1 al 9*
		2. Imprímela en formato de matriz (filas y columnas visibles)*
		3. Extrae e imprime la diagonal principal*
	*/
import java.util.Scanner;
import lib.Matriceslib;
public class Act1 {
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		try {
			
		
		//Declaramos Matriz
		int[][] tabla = new int[3][3];
		
		//Funcion de llenar randoms
		Matriceslib.fillRandom(tabla, 10, 0, 0);
		
		//Mostrar Matriz
		Matriceslib.printMatrix(tabla);
		
		System.out.println("\n"); // Salto de linea

		// Imrpimir diagonal principal diagonal
		System.out.print("Diagonal Principal:" + "[");
		for (int i = 0; i < tabla.length; i++) {
			System.out.print(tabla[i][i] + " ");
		}
		System.out.println("]");
		
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

}
