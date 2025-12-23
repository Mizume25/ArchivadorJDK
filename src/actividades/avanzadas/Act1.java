package actividades.avanzadas;
/*1. Crea una matriz 3x3 con números del 1 al 9*
2. Imprímela en formato de matriz (filas y columnas visibles)*
3. Extrae e imprime la diagonal principal*
*/
import java.util.Scanner;

import matrices.MetodosMatriceslib;

public class Act1 {
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		// Inicializamos la matriz de 3x3
		int[][] tabla = new int[3][3];

		MetodosMatriceslib.llenarMatrizRandom(tabla, 10); // Imprimimos un metodo que llena el array automaticamente con
		// numeros random de 0 a 9
		MetodosMatriceslib.mostrarMatriz(tabla); // Mostramos matriz con otro metodo

		System.out.println("\n"); // Salto de linea

		// Imrpimir diagonal principal diagonal
		System.out.print("Diagonal Principal:" + "[");
		for (int i = 0; i < tabla.length; i++) {
			System.out.print(tabla[i][i] + " ");
		}
		System.out.println("]");

	}

}
