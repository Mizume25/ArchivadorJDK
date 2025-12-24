package actividades.avanzadas;
/*Calcula e imprime:
1. La suma total de todos los elementos*
2. La suma de cada fila por separado*
3. La suma de cada columna por separado*

*/

import java.util.Arrays;
import java.util.Scanner;

import matrices.MetodosMatriceslib;

public class Act2 {
	static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		// Inicializamos la tabla que se nos da en el enunciado
        int[][] tabla = {
                { 2, 4, 1 },
                { 3, 5, 7 },
                { 6, 8, 9 }
        };

        // Inizamos los arrays donde podamos guardar valores
        int[] sumaFilas = new int[3];
        int[] sumaColumnas = new int[3];

        int sumaTotal = MetodosMatriceslib.sumaTotalMatriz(tabla);    // Sumamos el total con el metodos sumaTotalMatriz

        MetodosMatriceslib.sumaFilasMatriz(sumaFilas, tabla,0);     //Sumamos las filas con el metodo SumamosFilasMatriz

        MetodosMatriceslib.sumaColumnasMatriz(sumaColumnas, tabla, 0,3);    //Sumamos las columnas con el metodo sumaColumnaMtriz

        // Mostrar resultados
        MetodosMatriceslib.mostrarMatriz(tabla);
        System.out.print("Suma de filas separadas:");
        System.out.println(Arrays.toString(sumaFilas));

        System.out.print("Suma de columnas separadas:");
        System.out.print(Arrays.toString(sumaColumnas));

        System.out.println("\nSuma Total de la matriz: " + sumaTotal);

	}

}
