package actividades.principiante;
//RECICLAMOS FUNCIONES ANTERIORES
import java.util.Scanner;


public class Act5 {
	//DECLARAMOS SCANNER STATICO PARA QUE CUALQUIER FUNCION PUEDA ACCEDER
	static Scanner sc = new Scanner (System.in);
	
	//IMPLEMENTACION DE FUNCIONES
	
	// 1º FUNCION QUE PIDE UN NUMERO
	public static int pedirNumero () {
		System.out.println("Introduce un numero: ");
		return sc.nextInt();
	}
	
	//2º FUNCION QUE MUESTRA LA TABLA DE MULTIPLICAR
	
											//PARAMETRO
	public static void mostrarTablaMultiplicar(int numero) {
		
		//ESTRUCTURA FOR RECORRE TODO LOS NUMEROS DE "N"
		System.out.println(); //Salto de linea
		for (int i = 0; i <= 10; i++) {
			System.out.println(numero + " x " + i + " = " + (numero*i));
		}
		
		
	}	
	
	public static void main(String[] args) {
	
		//DECLARAMOS VARIABLES
		int numero;
	
		
		//INICIALIZAMOS VARIABLES
		numero = 0;
		
		
		//ESTRUCTURA DE CONTROL QUE MANTIENE LOS RESULTADOS ENTRE 1 Y 10
		do {
			
		numero = pedirNumero();
		
		} while (numero > 10 || numero < 0);
		
		//MOSTRAMOS RESULTADO
		mostrarTablaMultiplicar(numero);
		

	}

}
