package actividades.principiante;
//Generar contador de racha de numero

import java.util.Random;
import java.util.Scanner;

import arrays.MetodosArrayslib;
import datosentrada.MetodosEntradaslib;

public class Act11 {
	static Scanner sc = new Scanner (System.in);		//DECLARAMOS SCANNER
	static Random rand = new Random();
	
	//1º Funcion llenar arrray de rachas
	public static void llenarArray (int max, int []arr) {
		//DECLARAMOS VARIABLES
		int min;
		//INICIALIZAMOS VARIABLES
		min = max - 4;
		
		for (int i = 0; i < arr.length; i++) {
				arr[i] = rand.nextInt(max - min + 1) + min;
		}
		
	}
	
	//FUNCION QUE CUNETA LA RACHA MAS ALTA
	
	public static void main(String[] args) {
		
		//DECLARAMOS VARIABLES
		int medidaArray;
		int max;
		int [] arr;
		//INICIALIZAR VARIABLES
		medidaArray = MetodosEntradaslib.numUsuario("==Racha Numero==", "Introduce Tamaño de array:", "Maximo debe medir 30", "Minimo debe medir 15", 30, 15);
		
		max = MetodosEntradaslib.numUsuario("==Referencia==", "Num referencia:", "No mas de 100", "No menos de 5",100,5 );
		
		arr = new int[medidaArray];
		
		
		llenarArray(max, arr);
		
		MetodosArrayslib.mostrarArray(arr);
		
		

	}

}
