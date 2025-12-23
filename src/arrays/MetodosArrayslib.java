package arrays;

import java.util.Random;
import java.util.Scanner;

public class MetodosArrayslib {
	// PUBLIC SCANNER || RANDOM IMPORT
	static Scanner sc = new Scanner(System.in);
	static Random rand = new Random();

	// ===========================
	// SECCIÓN 1:LLENADO DE DATOS
	// ===========================

	// MÉTODO: Llenar un array de enteros por completo (SOBRECARGA)
	// PARÁMETROS: 1 String, 1 array int
	public static void llenarArray(String texto, int[] numeros) {
		// Pedir algo
		System.out.print(texto);
		// Recorrer el array
		for (int i = 0; i < numeros.length; i++) {
			// Guardar el siguiente valor entero
			numeros[i] = sc.nextInt();
		}
	}

	// MÉTODO: Llenar un array de decimales por completo (SOBRECARGA)
	// PARÁMETROS: 1 String, 1 array double
	public static void llenarArray(String texto, double[] numeros) {
		// Pedir algo
		System.out.print(texto + ": ");
		// Recorrer el array
		for (int i = 0; i < numeros.length; i++) {
			// Guardar el siguiente valor entero
			numeros[i] = sc.nextDouble();
		}
	}

	// MÉTODO: Llena el array automaticamente con numeros random
	// PARÁMETROS: 1 array int
	public static void llenarArrayRandom(int[] array, int rangoRandom) {
		for (int i = 0; i < array.length; i++) {
			int num = rand.nextInt(rangoRandom);
			array[i] = num;
		}
	}

	// ===========================
	// SECCIÓN 2: METODOS DE MOSTRAR ELEMENTOS
	// ===========================

	// MÉTODO:Mostrar array de int
	// PARÁMETROS: 1 array int
	public static void mostrarArray(int[] numeros) {

		// Recorrer el array
		for (int i = 0; i < numeros.length; i++) {
			System.out.print(numeros[i] + " ");
		}
	}
	
	// MÉTODO:Mostrar array de Strings
	// PARÁMETROS: 1 array int
	public static void mostrarArray(String[] numeros) {

		// Recorrer el array
		for (int i = 0; i < numeros.length; i++) {
			System.out.print(numeros[i] + " ");
		}
	}
	
	// MÉTODO:Mostrar array de double
		// PARÁMETROS: 1 array double
		public static void mostrarArray(double[] numeros, int decimales) {

			// Calculamos la potencia una sola vez fuera del bucle por eficiencia
			double potencia = Math.pow(10, decimales);
			double valorRedondeado;
			valorRedondeado = 0.0;
			// Recorrer el array
			for (int i = 0; i < numeros.length; i++) {
				valorRedondeado = Math.round(numeros[i] * potencia) / potencia;
				System.out.print(valorRedondeado + " ");
			}
		}

	// MÉTODO:Mostrar array con formato de dinero y enunciado implementado junto a
	// array de nombres
	// PARÁMETROS: 1 array int, 1 array de Strings , String enunciado
	public static void mostrarArrayFormato(int[] array, String enunciado) {

		// Recorrer el array
		for (int i = 0; i < array.length; i++) {
			System.out.printf("%s%d: %d€%n", enunciado,(i+1),array[i]);
		}

	}

	// MÉTODO:Mostrar array con formato de dinero y enunciado implementado junto a
	// PARÁMETROS: 1 array int, 1 array de Strings , String enunciado
	public static void mostrarArrayFormato(int[] array, String[] listanombres, String enunciado) {

		// Recorrer el array
		for (int i = 0; i < array.length; i++) {
			System.out.printf("%s%s: %d€%n", enunciado, listanombres[i], array[i]);
		}

	}

	// MÉTODO:Mostrar array con formato de porcentaje
	// PARÁMETROS: 1 array int, 1 array de Strings , String enunciado
	public static void mostrarArrayFormatoIDs(double[] porcentajes, String texto) {
		// Recorrer el array
		for (int i = 0; i < porcentajes.length; i++) {
			System.out.printf("%s%d: %.2f%%%n", texto, (i + 1), porcentajes[i]);
		}
	}

	// MÉTODO:Mostrar array con formato de estadistico
	// PARÁMETROS: 1 array double
	public static void mostrarEstadisticaArray(double[] porcentajes, String titulo) {
		// REPRESENTACION ESTADISTICA DE LOS PORCENTAJES
		// REPRESENTAREMOS CON "*" LA REPRESENTACION A % DEL VALOR DE CADA ARRAY

		// Ejecutamos un for que recorra todo el array
		for (int i = 0; i < porcentajes.length; i++) {
			// Ejecutamos un formato
			System.out.printf("%s%d [%.2f%%] ", titulo, (i + 1), porcentajes[i]);

			// Ejecutamos un segundo for que imprima la cantidad de "*" que hay en el el
			// valor del array
			for (int j = 0; j < porcentajes[i]; j++) {
				System.out.print("*");
			}

			System.out.println(); // salto de linea por linea ejecutada
		}
	}

	

	// ================================
	// SECCIÓN 3:MANIPULACION Y CONSULTA DE ARRAYS
	// ================================

	// MÉTODO: Invertir valores de un array y mostrar otro con los valores
	// invertidos
	// PARÁMETROS: 1 secuencia de numeros
	public static void invertirValoresArray(int[] array, int[] array2) {

		int j = array2.length - 1; // J es un index que se posiciona al final

		for (int i = 0; i < array.length; i++) {
			array2[j] = array[i]; // El valor de la posicion inicial pasa a la final
			j--; // Decrementamos J
		}

	}

	// MÉTODO: Saber espacio de una secuancia de numeros
	// PARÁMETROS: 1 secuencia de numeros
	public static int medidaSecuencia(int secuencia) {

		int cont = 0; // contador

		while (secuencia > 0) {
			cont++; // Incrementamos contador
			secuencia = secuencia / 10; // Eliminamos numero
		}
		return cont;
	}

	// MÉTODO: Guardar una secuencia en un array
	// PARÁMETROS: 1 secuencia de numeros
	public static void guardarPatron(int[] array, int secuencia) {

		int i = array.length - 1;
		int temp = secuencia;

		while (temp > 0) {
			int digito = temp % 10; // Obtenemos ultimo digito
			array[i] = digito; // Guardamos ultimo digito
			temp /= 10; // Eliminar ultimo dígito
			i--; // Decrementamos indice
		}

	}

	// MÉTODO: Buscar 1 coincidencia en un array
	// PARÁMETROS: 1 array de numeros, una coincidencia
	public static boolean buscarCoincidenciaArray(int[] vector, int numeroBuscar) {
		int i = 0;

		while (i < vector.length) {

			if (vector[i] == numeroBuscar)
				return true;

			i++;
		}

		return false;

	}

	// MÉTODO: Contar cuantas veces se repite un numero en un array (si esta)
	// PARÁMETROS: 1 array de numeros, una coincidencia
	public static int numerosRepetidosArray(int[] vector, int numeroBuscar) {

		int contador = 0;

		// For que recorra todo el array
		for (int i = 0; i < vector.length; i++) {

			if (vector[i] == numeroBuscar) { // Si hay coincidencia aumenta el contador
				contador++;
			}
		}

		return contador;

	}

	// ===========================
	// SECCIÓN 4:CALCULOS ARITMETICOS
	// ===========================
	// MÉTODO: Metodo que calcula el valor maximo y devuelve la poscion de ese valor
	// PARÁMETROS: 1 array double
	public static int sumaValorTotalArray(int[] array) {
		// DECLARAMOS VARIABLES
		int sumaValor;

		// INICIALIZAMOS INDEX
		sumaValor = 0; // Punto de partida

		// RECORREMOS EL ARRAY EN BUSCA DEL PROMEDIO MAYOR
		for (int i = 0; i < array.length; i++) {
			sumaValor += array[i];
		}
		return sumaValor;
	}

	// MÉTODO: Calcula el promedio de la suma de todos los elementos de un array
	// PARÁMETROS: 1 array double
	public static double calcularMediana(double[] array) {
		// DECLARACIÓN
		double suma, promedio;

		// Inicializar variables de control
		suma = 0;
		// Recorrer el array
		for (int i = 0; i < array.length; i++) {
			// Sumar los valores del array
			suma += array[i];
		}

		// Calcular el promedio según la suma de todos los elementos del array
		promedio = (suma / array.length);

		// Devolver el valor del promedio
		return promedio;
	}

	// MÉTODO: Cuenta la cantidad de elementos mayor que un valor dentro de un array
	// PARÁMETROS: 1 array double, 1 double
	public static int numeroElementsSuperiorValor(double[] array, double valor) {
		// DECLARACIÓN
		int contador;

		// Inicializar variable de control
		contador = 0;
		// Recorrer el array
		for (int i = 0; i < array.length; i++) {
			// Si el elemento es mayor que el promedio
			if (array[i] > valor) {
				// Aumentar contador
				contador++;
			}
		}

		// Devolver el valor del promedio
		return contador;
	}

	// MÉTODO: Cuenta la cantidad de elementos menor que un valor dentro de un array
	// PARÁMETROS: 1 array double, 1 double
	public static int numeroElementsInferiorValor(double[] array, double valor) {
		// DECLARACIÓN
		int contador;

		// Inicializar variable de control
		contador = 0;
		// Recorrer el array
		for (int i = 0; i < array.length; i++) {
			// Si el elemento es mayor que el promedio
			if (array[i] < valor) {
				// Aumentar contador
				contador++;
			}
		}

		// Devolver el valor del promedio
		return contador;
	}

	// MÉTODO: Metodo que calcula el valor maximo y devuelve la poscion de ese valor
	// PARÁMETROS: 1 array double
	public static int maxValorArray(double[] arraydouble) {

		// DECLARAMOS VARIABLES
		double valorMax;
		int posicion;

		// INICIALIZAMOS INDEX
		valorMax = arraydouble[0]; // Punto de partida
		posicion = 0;

		// RECORREMOS EL ARRAY EN BUSCA DEL PROMEDIO MAYOR
		for (int i = 1; i < arraydouble.length; i++) {

			if (valorMax < arraydouble[i]) {
				// ACTUALIZAMOS VALOR Y POSICION
				valorMax = arraydouble[i];
				posicion = i;
			}
		}

		return posicion;

	}

	// MÉTODO: Metodo que calcula el valor maximo y devuelve la poscion de ese valor
	// PARÁMETROS: 1 array double
	public static int maxValorArray(int[] arrayint) {

		// DECLARAMOS VARIABLES
		double valorMax;
		int posicion;

		// INICIALIZAMOS INDEX
		valorMax = arrayint[0]; // Punto de partida
		posicion = 0;

		// RECORREMOS EL ARRAY EN BUSCA DEL PROMEDIO MAYOR
		for (int i = 1; i < arrayint.length; i++) {

			if (valorMax < arrayint[i]) {
				// ACTUALIZAMOS VALOR Y POSICION
				valorMax = arrayint[i];
				posicion = i;
			}
		}

		return posicion;

	}
}
