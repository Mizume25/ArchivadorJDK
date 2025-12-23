package actividades.intermedio;
import datosentrada.MetodosEntradaslib;
import arrays.MetodosArrayslib;
import java.util.Scanner;

public class Act1 {
	static Scanner sc = new Scanner(System.in); // Scanner como variable de classe

	// 4º Funcion que determina si es o no palindromo
	public static boolean comprobacion(int[] vector) {

		boolean comprobacion = true;

		int j = 0; // Index opuesto

		// For que decrementa i y recorre el array desde la ultima posicion a la primera
		for (int i = vector.length - 1; i >= 0; i--) {

			if (vector[j] != vector[i]) {

				comprobacion = false; // Si hay 1 solo valor diferente devuelve falso
			}

			j++; // index que recorre desde la primera posicion a la ultima
		}

		return comprobacion;
	}

	public static void main(String[] args) {

		int palindromo = MetodosEntradaslib.numeroUsuario("Introduce una serie de numeros: "); // Numero que queremos analizar
		
		int espacioArray = MetodosArrayslib.medidaSecuencia(palindromo);
				
		int[] vector = new int[espacioArray]; // Iniciamos array con espacio adquirido

		MetodosArrayslib.guardarPatron(vector, palindromo); //Guardar secuencia de numeros
		
		
		
		boolean comprobacion = comprobacion(vector); // Comprueba si es plaindromo o no

		// Compara el boolean e imprimimos resultado
		if (comprobacion) {
			System.out.println();
			System.out.println(palindromo + " és un palíndromo");
		} else {
			System.out.println();
			System.out.println(palindromo + " No és un palíndromo");
		}

	}

}
