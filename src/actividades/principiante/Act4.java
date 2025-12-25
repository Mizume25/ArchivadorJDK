package actividades.principiante;
//RECICLAMOS FUNCIONES ANTERIORES
import java.util.Scanner;


public class Act4 {
	//DECLARAMOS SCANNER STATICO PARA QUE CUALQUIER FUNCION PUEDA ACCEDER
	static Scanner sc = new Scanner (System.in);
	
	//IMPLEMENTACION DE FUNCIONES
	
	// 1º FUNCION QUE PIDE UN NUMERO
	public static int pedirNumero () {
		System.out.println("Introduce un numero: ");
		return sc.nextInt();
	}
	
	//2º FUNCION QUE CALCULA LA SUMA DE LOS NUMEROS
	
											//PARAMETRO
	public static int calcularSuma(int numero) {
		
		//DECLARAMOS VARIABLES
		int suma;
		
		//INICLIAZAMOS VARIABLE
		suma = 0;
		
		//ESTRUCTURA FOR RECORRE TODO LOS NUMEROS DE "N"
		for (int i = 0; i <= numero; i++) {
			suma += i; //Acumulamos i
		}
		
		return suma;
	}	
	
	public static void main(String[] args) {
	
		//DECLARAMOS VARIABLES
		int numero;
		int suma;
		
		//INICIALIZAMOS VARIABLES
		numero = 0;
		suma = 0;
		
		//EJECUTAMOS BLOQUES DE CODIGO
		numero = pedirNumero();
		suma = calcularSuma(numero); //AURGMENTO
		
		//MOSTRAMOS RESULTADO
		System.out.println("\nLa suma total de los primeros " + numero + " numeros es " + suma);
		

	}

}