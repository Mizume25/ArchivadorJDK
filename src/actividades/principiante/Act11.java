package actividades.principiante;
//Generar contador de racha de numero

import java.util.Random;
import java.util.Scanner;

import arrays.MetodosArrayslib;
import datosentrada.MetodosEntradaslib;

public class Act11 {
	static Scanner sc = new Scanner (System.in);		//DECLARAMOS SCANNER
	static Random rand = new Random();
	//1º FUNCIONES QUE LLENA CON ARRAY
	public static void llenarArray (int [] arr, int valMax) {
		
		//DECALRACION DE VARIABLES
		int diff = rand.nextInt(5 - 3 + 1) + 3;
		int min = valMax - diff;
		
		//LLENAMOS LOS VALORES DE RANDOMS CON UNA DIFERENCIA MINIMA
		for (int i = 0; i < arr.length; i++) {
			arr[i] = rand.nextInt(valMax - min + 1) + min;
		}
	}
	
	//2º FUNCIONES QUE BUSCA LA RACHA MAS GRANDE
	public static void rachaMasGrande (int [] arr, int [] resultado) {
		
		
		//DECLARAMOS VARIABLES
		for (int i = 0; i < resultado.length; i++) {
			if (arr[i] == arr[i + 1]) {
				resultado [0] = arr[i];
				
				
			}
		}
		
		
		
		
		
		
	}
	public static void main(String[] args) {
		
		//DECLARAR VARIABLES
		int [] arr;
		int espacioArray;
		int valMax;
		int [] resultado = new int[2];
		
		espacioArray = MetodosEntradaslib.numUsuario("=Array=", "Espacio de array:", "Maximo 30", "Minimo 15", 30, 15);
		valMax = MetodosEntradaslib.numUsuario("==Referencia==", "Num de referencia:", "MAX 100", "MIN 10", 100, 10);
		
		arr = new int [espacioArray];
		
		llenarArray(arr, valMax);
		
		MetodosArrayslib.mostrarArray(arr);
		
		
		
		

	}

}
