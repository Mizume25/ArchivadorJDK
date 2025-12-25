package actividades.basico;

import java.util.Scanner;
// Ejercico de calculo simple
public class Act12 {
/*Escribe un programa en Java que calcule cuál es el espacio recorrido por un objeto, como por ejemplo, una sonda espacial, que se mueve a velocidad constante. 
 * Podemos suponer que el objeto ha recorrido un espacio inicial de 150.000 km y se mueve a una velocidad 17 km por segundo.*/
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);	//DECLARAMOS VARIABLE
		
		//DECLARAMOS VARIABLES
		double espacioInicial;
		double distanciaTotal;
		
		//INICIALIZAR VARIABLES
		espacioInicial = 150000;
		distanciaTotal = espacioInicial + (17.0 * 1.0);
		
		System.out.printf("Recorrido: %.2fkm", distanciaTotal);
		
		sc.close();

	}

}
