/*Implementa funciones para:
1. Encontrar el valor máximo y mínimo*
2. Contar cuántas veces aparece un número específico (ej: 7)*
3. Encontrar la posición (fila, columna) de un valor dado (ej: 11)*
EXTRA: Añadir si esta o no un numero y contar cuantas posiciones tiene
*/
package actividades.avanzadas;

import java.util.Scanner;

import datosentrada.MetodosEntradaslib;
import matrices.MetodosMatriceslib;

import java.util.Random;
public class Act3 {
	static Random rand = new Random(); // Importamos Random como variable de classe
    static Scanner sc = new Scanner(System.in); // Importamos Scanner como variable de clase

	public static void main(String[] args) {
		String sistema;     // String como estructura de control del programa
        sistema = " ";

        //Datos Iniciales del programa

        System.out.println("Introduce los elementos de la matriz");
        // Usuario introduce numero tablas 
        int filas = MetodosEntradaslib.numeroUsuario("Numero de Filas: ");
        int columnas = MetodosEntradaslib.numeroUsuario("Numero de Columnas: ");
        
        int[][] tabla = new int[filas][columnas]; //Introducimos numero de filas y columnas que se quiera
        
        int numeroRandom = MetodosEntradaslib.numeroUsuario("Hasta que numero random imprimimos [ej 9 => Nº 0 - 8 ]: ");

        MetodosMatriceslib.llenarMatrizRandom(tabla, numeroRandom); // Llamamos al metodo con un rango de randoms

        do {
            
        MetodosMatriceslib.mostrarMatriz(tabla); // Llammos a un metodo que muestra la matriz

        int valorMaximo = MetodosMatriceslib.valorMaxMatriz(tabla);   //Calculamos valor maximo
        int valorMinimo = MetodosMatriceslib.valorMinMatriz(tabla);  //Calculamos valor minimo

        //Buscamos si esta o no el numero
        int numero = MetodosEntradaslib.numeroUsuario("Numero que quieres buscar? ");
        boolean coincidencia = MetodosMatriceslib.buscarNumeroMatriz(tabla, numero);   //Buscamos Numero
        
        // Si el numero existe calcula numero de veces que aparece y en las posiciones en las que lo hace
        if (coincidencia) {
        
        //Calculamos el numero de veces que aparece
        int numeroRepetido = MetodosMatriceslib.numeroRepetidoMatriz(tabla, numero);
         
        //El array medira el doble de las veces que aparece para imprimir numeros consecutivos como posiciones de filas|columnas
        int [] numPosiciones = new int[numeroRepetido * 2]; 
        
        //Calculamos las posiciones en las que aparece el numero y lo gauradamos en un array
        MetodosMatriceslib.posicionesNumeroMatriz(tabla, numero, numPosiciones);

        //imprimimos todos los resultados de los calculos

        System.out.println(numero + " aparece en la matriz");   //Coincidencia
        System.out.println();
        
        System.out.println("==Valores Maximos de la matriz==");
        System.out.println("Numero maximo de la matriz: " + valorMaximo); // Valor maximo
        System.out.println("Numero minimo de la matriz: " + valorMinimo); // valor minimo
        System.out.println();

        System.out.println("==¿Cuantas veces aparece el " + numero + "?==");
        System.out.println("El numero " + numero + " aparece " + numeroRepetido + " veces");  //Numero repetido
        System.out.println();

        //Posiciones encontradas
        System.out.println("Posiciones encontradas de el " + numero + " son:"); //Posiciones
    
        for (int i = 0; i < numPosiciones.length; i += 2) {
            // i = índice de fila, i+1 = índice de columna
            int posicion = (i / 2) + 1; // Número de posición (1, 2, 3...)
            System.out.println("Posición " + posicion + " = [" + 
                            numPosiciones[i] + ", " + 
                            numPosiciones[i + 1] + "]");


            }
        

        } else {
            System.out.println(numero + " NO aparece en la matriz");    //NO coincidenciia
            System.out.println();

            System.out.println("==Valores Maximos de la matriz==");
            System.out.println("Numero maximo de la matriz: " + valorMaximo); // Valor maximo
            System.out.println("Numero minimo de la matriz: " + valorMinimo); // valor minimo

        }

        System.out.println("¿Quieres continuar con el programa?[Si | No]");
        sistema = sc.next().toLowerCase();

        } while (sistema.equals("si"));

	}

}
