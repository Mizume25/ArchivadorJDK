package actividades.intermedio;

//Programa que busca el numero en un array y cuenta las veces que aparece si esta
import java.util.Scanner;

import arrays.MetodosArrayslib;
import datosentrada.MetodosEntradaslib;

public class Act2 {
	static Scanner sc = new Scanner(System.in); // Declaramos Scanner

	public static void main(String[] args) {

		int espacioArray = MetodosEntradaslib.numeroUsuario("Espacio del vector: ");

		int[] vector = new int[espacioArray]; // Declaramos un array con "N" espacio

		MetodosArrayslib.llenarArray("Introduce numeros del vector: ", vector); // Introduce numeros el usuario

		int numeroBuscar = MetodosEntradaslib.numeroUsuario("Numero que queremos buscar: ");

		boolean coincidencia = MetodosArrayslib.buscarCoincidenciaArray(vector, numeroBuscar);

		if (coincidencia) {

			System.out.println("El numero " + numeroBuscar + " si aparece en el vector");

			int contador = MetodosArrayslib.numerosRepetidosArray(vector, numeroBuscar);

			System.out.println("Aparece un total de " + contador + " veces");

		} else {

			System.out.println("El numero " + numeroBuscar + " no aparece en el vector");

		}

	}

}
