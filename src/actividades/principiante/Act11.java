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
		int diff;
		//INICIALIZAMOS VARIABLES
		diff = rand.nextInt(3) + 3; // Rango de minimo
		min = max - diff; 			//Rango de maximos 
		
		for (int i = 0; i < arr.length; i++) {
				arr[i] = rand.nextInt(max - min + 1) + min;
		}
		
	}
	
	//2º FUNCION QUE CUNETA LA RACHA MAS ALTA
	public static int contadorRachas (int [] arr) {
		
		//DECLARAMOS VARIABLES
		int indexMax;
		int indexMin;
		int valorMax;
		int valorMin;
		int [] rachas;
		
		int cont;
		//INICIALIZAMOS VARIABLES
		indexMax = MetodosArrayslib.maxValorArray(arr);
		valorMax = arr[indexMax];
		
		
		indexMin = MetodosArrayslib.minValorArray(arr);
		valorMin = arr[indexMin];
		
		//HABRA TANTAS NUMERO DE RACHAS COMO DIFERENCIA HAYA ENTRE VALOR MAX Y MIN
		rachas = new int [valorMax - valorMin];
		int k = 0;;
		int y;
		int j = rachas.length - 1;
		for (int i = 0; i < arr.length; i++) {
			
			if (arr[i] != valorMax && arr[i] != valorMin) {
				
				k++;
				
				do {
					
					if (arr[i] != valorMax && arr[i] != valorMin) {
						
						rachas[0 + k]++;		
					}
					
					i++;
					
				} while (arr[i] != valorMax && arr[i] != valorMin);
				
				
			}
			
			if (arr[i] == valorMin) {
				rachas[0]++;
			}
			
			if (arr[i] == valorMax) {
				rachas[j]++;
			}
			
			
		}
		
		
		
		return MetodosArrayslib.maxValorArray(rachas);
	}
	
	
	
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
		
		int posicion = contadorRachas(arr);
		System.out.println(posicion);
		

	}

}
