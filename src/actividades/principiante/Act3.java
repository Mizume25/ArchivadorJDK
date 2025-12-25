package actividades.principiante;

import java.util.Scanner;

// Ejercicio de bucles
//Decir la cantidad de caracteres que hay en una secuencia de numeros
public class Act3 {
	//DECLARAMOS SCANNER STATICO PARA QUE CUALQUIER FUNCION PUEDA ACCEDER
	static Scanner sc = new Scanner (System.in);
	
	//IMPLEMENTACION DE FUNCIONES
	
	// 1º FUNCION QUE PIDE UN NUMERO
	public static int pedirNumero () {
		System.out.println("Introduce un numero: ");
		return sc.nextInt();
	}
	
	//2º FUNCION QUE CALCULA EL ESPACIO DE ESA SECUENCIA DE NUMEROS
	
											//PARAMETRO
	public static int calculcarMedidaNumero(int numero) {
		
		//DECLARAMOS VARIABLES
		int cont;
		
		//INICLIAZAMOS VARIABLE
		cont = 0;
		
		//ESTRUCTURA SE REPITE MIENTRA EL VALOR SEA MAYOR A "0"
		while (numero > 0) {
			numero /= 10;
			cont++;
		}
		
		return cont;
	}	
	
	public static void main(String[] args) {
	
		//DECLARAMOS VARIABLES
		int numero;
		int contador;
		
		//INICIALIZAMOS VARIABLES
		numero = 0;
		contador = 0;
		
		//EJECUTAMOS BLOQUES DE CODIGO
		numero = pedirNumero();
		contador = calculcarMedidaNumero(numero); //AURGMENTO
		
		//MOSTRAMOS RESULTADO
		System.out.println("\nLa secuencia " + numero + " contiene " + contador + " caracteres/numeros");
		

	}

}
