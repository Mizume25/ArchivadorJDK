package actividades.basico;

import java.util.Scanner;

//Ejercicios 5: Calculos simple
public class Act9 {
/*Escribir un programa que, dada una cantidad de euros, nos indique cuál es su valor en dólares americanos. 
 * Además de la variable para la cantidad de euros, se debe declarar
 *  otra para el cambio (el valor de un dólar en euros) y para el resultado final. Muestra el resultado por consola.*/
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);	//DECLARAMOS SCANNER
		
		//DECLARAMOS VARIABLES
		double cuantiaEuros;
		double cambio;
		double cuantiaDolares;
		
		//INICIALIZAMOS VARIABLE
		System.out.println("Cuantia de Euros:");
		cuantiaEuros = sc.nextDouble();
		
		System.out.println("Cambio:");
		cambio = sc.nextDouble();
		
		//CALCULO
		cuantiaDolares = cuantiaEuros * cambio;
		
		//MOSTRAR RESULTADO
		System.out.printf("La cantidad de %.2f€ equivale a %.2f$ con la conversion de %.2f",cuantiaEuros,cuantiaDolares,cambio);
		
		
		sc.close();
	}

}
