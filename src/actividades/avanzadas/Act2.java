package actividades.avanzadas;
/*Calcula e imprime:
1. La suma total de todos los elementos*
2. La suma de cada fila por separado*
3. La suma de cada columna por separado*

*/

import java.util.Arrays;
import java.util.Scanner;

import lib.Arraylib;
import lib.Matriceslib;
import matrices.MetodosMatriceslib;

public class Act2 {
	static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		try {
			
		
		// Inicializamos la tabla que se nos da en el enunciado
        int[][] tabla = {
                { 2, 4, 1 },
                { 3, 5, 7 },
                { 6, 8, 9 }
        };

        // Inizamos los arrays donde podamos guardar valores
        int[] sumaFilas = new int[3];
        int[] sumaColumnas = new int[3];

        //int sumaTotal = MetodosMatriceslib.sumaTotalMatriz(tabla);    // Sumamos el total con el metodos sumaTotalMatriz
        
        int sumaTotal = Matriceslib.sumTotal(tabla); //Sumamos Total
        
        Matriceslib.sumRows(sumaFilas, tabla); //Suma de filas

        Matriceslib.sumColumns(tabla, sumaColumnas);
        
        
        

        // Mostrar resultados
        Matriceslib.printMatrix(tabla);
        System.out.print("Suma de filas separadas:");
        Arraylib.printArray(sumaFilas);

        System.out.print("Suma de columnas separadas:");
        Arraylib.printArray(sumaColumnas);

        System.out.println("\nSuma Total de la matriz: " + sumaTotal);
        
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

}
