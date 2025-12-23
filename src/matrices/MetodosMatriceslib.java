package matrices;

import java.util.Random;
import java.util.Scanner;

public class MetodosMatriceslib {
	// PUBLIC SCANNER
	static Scanner sc = new Scanner(System.in);
	static Random rand = new Random();

// ============================================
// SECCIÓN 1: MÉTODOS DE ENTRADA/SALIDA (I/O)
// ============================================

// MÉTODO: Llena el matriz automaticamente con numeros random
// PARÁMETROS: 1 matriz int
	public static void llenarMatrizRandom(int[][] tabla, int rangoRandom) {
		for (int fila = 0; fila < tabla.length; fila++) {
			// Recorrer columnas de cada fila
			for (int columna = 0; columna < tabla[fila].length; columna++) {
				tabla[fila][columna] = rand.nextInt(rangoRandom);
			}
		}
	}

	// MÉTODO: LLena la primera columna con numeros autoincrementados que
	// representan Id's de un tabla
	// PARÁMETROS: 1 matriz int
	public static void idsAutoIncrementadas(int[][] tabla) {
		// DECLARAMOS VARIABLES
		int j;
		int id;

		// INICIALIZAMOS VALORES
		id = 1;
		j = 0;

		// MODIFICAMOS LA PRIMERA COLUMNA QUE REPRESENTA LAS SUCURSALES
		for (int i = 0; i < tabla.length; i++) {
			tabla[i][j] = id;
			id++;
		}
	}

	// MÉTODO: LLena las filas de datos random ignorando la ID's
	// PARÁMETROS: 1 matriz int
	public static void llenarValorIdsRandom(int[][] tabla) {
		// RECORREMOS EL ARRAY CON EL AUTO INCREMENTADO IMPLEMENTADO
		// Columna comienza con 1 para no modificar la columna 0,0 | 1,0 | 2,0 | 3,0
		// etc...
		for (int fila = 0; fila < tabla.length; fila++) {

			for (int columna = 1; columna < tabla[fila].length; columna++) {

				tabla[fila][columna] = rand.nextInt(9001) + 1000;
			}
		}
	}

// ============================================
// SECCIÓN 2: MÉTODOS DE MOSTRAR DATOS
// ============================================

	// MÉTODO: Imprime la matriz completa
	// PARÁMETROS: 1 matriz de int
	public static void mostrarMatriz(int[][] tabla) {
		// Recorrer filas
		for (int fila = 0; fila < tabla.length; fila++) {
			// Recorrer columnas de cada fila
			for (int columna = 0; columna < tabla[fila].length; columna++) {
				System.out.print(tabla[fila][columna] + " ");
			}
			System.out.println(); // Salto de línea después de cada fila
		}
	}

	// MÉTODO: MOSTRAR MATRIZ CON FORMATO DE TABLA
	// PARÁMETROS: ARRAY DE STRINGS, MATRIZ DE INT, NUMCOLUMNAS, NUMFILAS
	public static void mostrarMatrizFormatoTabla(int[][] tabla, String[] listaNombres, int numFilas, int numcolumnas,
			String encabezadoSuperior, String tituloFilas) {

		// 1. Calculamos el ancho del equipo dinámicamente según el nombre más largo
		int anchoEquipo = 10;
		// CORRECTO: listaNombres tiene numFilas elementos
		for (int i = 0; i < numFilas; i++) { // ← Cambiado a numFilas
			if (listaNombres[i].length() > anchoEquipo) {
				anchoEquipo = listaNombres[i].length() + 2;
			}
		}

		// 2. Definimos el ancho fijo de cada columna de datos
		int esp = 6;

		// 3. CABECERA DINÁMICA (J1 a JX...)
		System.out.printf("%-" + anchoEquipo + "s", encabezadoSuperior);
		// CORRECTO: Los encabezados corresponden a COLUMNAS, no filas
		for (int j = 0; j < numcolumnas; j++) { // ← Cambiado a numcolumnas
			System.out.printf("%-" + esp + "s", tituloFilas + (j + 1));
		}
		System.out.println();

		// Línea decorativa dinámica
		int totalGuiones = anchoEquipo + (numcolumnas * esp); // ← Cambiado a numcolumnas
		for (int k = 0; k < totalGuiones; k++)
			System.out.print("-");
		System.out.println();

		// 4. FILAS DINÁMICAS
		// CORRECTO: Recorrer filas
		for (int i = 0; i < numFilas; i++) {
			// Nombre del equipo (por fila)
			System.out.printf("%-" + anchoEquipo + "s", listaNombres[i]);

			// CORRECTO: Recorrer columnas de esa fila
			for (int j = 0; j < numcolumnas; j++) {
				System.out.printf("%-" + esp + "d", tabla[i][j]);
			}
			System.out.println();
		}

	}

	// MÉTODO: ORDENAR MATRIZ CON METODO BOMBOLLA DE MAYOR A MENOR
	// PARÁMETROS: ARRAY DE STRINGS, MATRIZ DE INT, NUMCOLUMNAS, NUMFILAS
	public static void ordenarFilasMatrizAscendente(int[][] tabla) {
	    if (tabla == null || tabla.length == 0) {
	        return;
	    }
	    
	    int n = tabla.length; // Número de filas
	    int m = tabla[0].length; // Número total de columnas
	    
	    // Validar que haya al menos 2 columnas (ID + datos)
	    if (m < 2) {
	        System.out.println("Error: La matriz debe tener al menos 2 columnas");
	        return;
	    }
	    
	    // Validar que todas las filas tengan la misma longitud
	    for (int i = 1; i < n; i++) {
	        if (tabla[i].length != m) {
	            System.out.println("Error: Las filas no tienen la misma longitud");
	            return;
	        }
	    }

	    // CALCULAR SUMAS IGNORANDO LA PRIMERA COLUMNA (ID)
	    int[] sumas = new int[n];
	    
	    for (int i = 0; i < n; i++) {
	        int sumaFila = 0;
	        // Empezar desde j=1 para saltar la primera columna (ID)
	        for (int j = 1; j < m; j++) {
	            sumaFila += tabla[i][j];
	        }
	        sumas[i] = sumaFila;
	        System.out.println("Fila " + i + " (ID " + tabla[i][0] + "): suma = " + sumas[i]);
	    }

	    // ORDENAR ASCENDENTE (menor arriba, mayor abajo)
	    boolean cambios;
	    do {
	        cambios = false;
	        for (int i = 0; i < n - 1; i++) {
	            // Para orden ASCENDENTE: intercambiar si el actual es MAYOR que el siguiente
	            if (sumas[i] > sumas[i + 1]) {
	                // Intercambiar sumas
	                int tempSuma = sumas[i];
	                sumas[i] = sumas[i + 1];
	                sumas[i + 1] = tempSuma;

	                // Intercambiar filas completas (incluyendo el ID)
	                int[] tempFila = tabla[i];
	                tabla[i] = tabla[i + 1];
	                tabla[i + 1] = tempFila;

	                cambios = true;
	            }
	        }
	    } while (cambios);

	    // Mostrar resultado
	    System.out.println("\n--- Matriz ordenada ---");
	    for (int i = 0; i < n; i++) {
	        System.out.print("Fila " + i + ": ID " + tabla[i][0] + " | Datos: ");
	        int suma = 0;
	        for (int j = 1; j < m; j++) {
	            System.out.print(tabla[i][j] + " ");
	            suma += tabla[i][j];
	        }
	        System.out.println("→ Suma = " + suma);
	    }
	}
	
	public static void ordenarFilasMatrizDescendente(int[][] tabla) {
	    int n = tabla.length; // Número de filas (equipos)
	    int m = tabla[0].length; // Número de columnas (jornadas)

	    // SUMAMOS CADA FILA
	    int[] sumas = new int[n];

	    for (int i = 0; i < n; i++) {
	        int sumaFila = 0;
	        for (int j = 0; j < m; j++) {
	            sumaFila += tabla[i][j];
	        }
	        sumas[i] = sumaFila;
	    }

	    // Paso 2: ORDENAR FILAS EN ORDEN DESCENDENTE (mayor arriba, menor abajo)
	    boolean cambios;
	    do {
	        cambios = false;
	        for (int i = 0; i < n - 1; i++) {
	            // PARA ORDEN DESCENDENTE: si la suma actual es MENOR que la siguiente
	            // La intercambiamos para que la MAYOR quede primero
	            if (sumas[i] < sumas[i + 1]) {  // Esta condición está BIEN para descendente
	                // Intercambiar sumas
	                int tempSuma = sumas[i];
	                sumas[i] = sumas[i + 1];
	                sumas[i + 1] = tempSuma;

	                // Intercambiar filas completas
	                int[] tempFila = tabla[i];
	                tabla[i] = tabla[i + 1];
	                tabla[i + 1] = tempFila;

	                cambios = true;
	            }
	        }
	    } while (cambios);
	}

	// ============================================
	// SECCIÓN 3: CALCULOS MATEMATICOS
	// ============================================

	// SECCIÓN 3.1: CALCULOS ARITMETICOS

	// MÉTODO: Metodo que suma el total de toda la matriz COMPLETA
	// PARÁMETROS: 1 matriz int
	public static int sumaTotalMatriz(int[][] tabla) {
		int sumaTotal = 0;
		for (int fila = 0; fila < tabla.length; fila++) {
			// Recorrer columnas de cada fila
			for (int columna = 0; columna < tabla[fila].length; columna++) {
				sumaTotal += tabla[fila][columna];
			}
		}
		return sumaTotal;
	}

	// MÉTODO: Metodo que suma filas de una matriz
	// PARÁMETROS: 1 matriz int, 1 array int
	public static void sumaFilasMatriz(int[] sumaFila, int[][] tabla) {
		for (int fila = 0; fila < tabla.length; fila++) {
			sumaFila[fila] = 0; // Inicializar
			for (int columna = 0; columna < tabla[fila].length; columna++) {
				sumaFila[fila] += tabla[fila][columna];
			}
		}
	}

	// MÉTODO: Metodo que suma columnas de una matriz
	// PARÁMETROS: 1 matriz int, 1 array int, maximo de columnas
	public static void sumaColumnasMatriz(int[] sumaColumnas, int[][] tabla, int maxColumnas) {
		// Sumar columnas (solo donde existan)
		for (int columna = 0; columna < maxColumnas; columna++) {
			for (int fila = 0; fila < tabla.length; fila++) {
				if (columna < tabla[fila].length) { // Verificar que la columna existe
					sumaColumnas[columna] += tabla[fila][columna];
				}
			}
		}
	}

	// MÉTODO: Calcula el valor total de cada fila de Id's
	// PARÁMETROS: 1 matriz int
	public static void sumaTotalIdsFilas(int[][] tabla, int[] valorTotal) {
		// DECLARAMOS VARIABLES
		int sumaValor;
		int i;

		// INICIALIZAMOS VARIABLES
		i = 0;

		for (int fila = 0; fila < tabla.length; fila++) {
			// Reiniciamos acumulador
			sumaValor = 0;

			for (int columna = 1; columna < tabla[fila].length; columna++) {
				sumaValor += tabla[fila][columna]; // Acumulamos valor
			}

			valorTotal[i] = sumaValor;
			i++;

		}
	}

	// MÉTODO: Metodo que calcula el valor total por columnas ignorando la primera
	// fila de ID's
	// PARÁMETROS: 1 matriz int
	public static void sumaTotalIdsColumnas(int[][] tabla, int[] valorTotalColumna) {
		// DECLARAMOS VARIABLES
		int columna;
		int sumaValor;
		int i;

		// INICIALIZAMOS VARIABLES
		columna = 1;
		i = 0;

		while (columna < tabla[0].length) {
			// REINICIAMOS ACUMULADOR

			sumaValor = 0;

			for (int fila = 0; fila < tabla.length; fila++) {
				sumaValor += tabla[fila][columna]; // ACUMULAMOS
			}

			valorTotalColumna[i] = sumaValor; // GUARDAMOS VALORES
			i++;
			columna++;

		}
	}

	// SECCIÓN 3.2: Calculos Estadisticos

	// MÉTODO: Metodo que encuentra el valor maximo de una matriz completa
	// PARÁMETROS: 1 matriz int
	public static int valorMaxMatriz(int[][] tabla) {
		int valorMaximo = tabla[0][0]; // Punto de partida
		// Recorremos la matriz completa
		for (int filas = 0; filas < tabla.length; filas++) {
			for (int columnas = 0; columnas < tabla[filas].length; columnas++) {
				if (valorMaximo < tabla[filas][columnas]) {
					valorMaximo = tabla[filas][columnas];
				}
			}
		}
		return valorMaximo;
	}

	// MÉTODO: Metodo que encuentra el valor minimo de una matriz completa
	// PARÁMETROS: 1 matriz int
	public static int valorMinMatriz(int[][] tabla) {
		int valorMinimo = tabla[0][0]; // Punto de partida
		// Recorremos la matriz completa
		for (int filas = 0; filas < tabla.length; filas++) {
			for (int columnas = 0; columnas < tabla[filas].length; columnas++) {
				if (valorMinimo > tabla[filas][columnas]) {
					valorMinimo = tabla[filas][columnas];
				}
			}
		}
		return valorMinimo;
	}

	// MÉTODO: Metodo que calcula el porcentaje respecto a un total
	// PARÁMETROS: 1 matriz int, 1 int, 1 array double
	public static void porcentajePorTotal(int[] valorTotalId, int total, double[] porcentajes, int rangodecimal) {

		// DECLARAMOS VARIABLES
		double potencia = Math.pow(10, rangodecimal);
		double valorRedondeado;
		double porcentaje;

		// INICIALIZAMOS VARIABLES
		valorRedondeado = 0.0;
		porcentaje = 0.0;

		for (int i = 0; i < valorTotalId.length; i++) {

			porcentaje = ((double) valorTotalId[i] / total) * 100; // CALCULAMOS PORCENTAJE

			valorRedondeado = Math.round(porcentaje * potencia) / potencia;// REDONDEAMOS VALOR A 0

			porcentajes[i] = valorRedondeado; // GUARDAMOS EL VALOR EN UN ARRAY DE DOUBLE
		}
	}

	// ============================================
	// SECCIÓN 4: CONSULTA Y MANIPULACIONES DE MATRIZ
	// ============================================

	// MÉTODO: Metodo que determina si un numero existe en la matriz o no
	// PARÁMETROS: 1 matriz int, int numero
	public static boolean buscarNumeroMatriz(int[][] tabla, int numero) {
		// Recorremos la matriz completa
		for (int filas = 0; filas < tabla.length; filas++) {
			for (int columnas = 0; columnas < tabla[filas].length; columnas++) {
				if (tabla[filas][columnas] == numero) {
					return true;
				}
			}
		}
		return false;
	}

// MÉTODO: Metodo que cuenta las veces que aparece un numero repetido
// PARÁMETROS: 1 matriz int, int numero
	public static int numeroRepetidoMatriz(int[][] tabla, int numero) {
		int contador;
		contador = 0;
		// Recorremos la matriz completa
		for (int filas = 0; filas < tabla.length; filas++) {
			for (int columnas = 0; columnas < tabla[filas].length; columnas++) {
				if (tabla[filas][columnas] == numero) {
					contador++;
				}
			}
		}
		return contador;
	}

// MÉTODO: Metodo que cuenta las posiciones que aparece un numero repetido
// PARÁMETROS: 1 matriz int, int numero, 1 int array
	public static void posicionesNumeroMatriz(int[][] tabla, int numero, int[] numPosiciones) {
		int i = 0;
		int j = 1;
		// Recorremos la matriz completa
		for (int filas = 0; filas < tabla.length; filas++) {
			for (int columnas = 0; columnas < tabla[filas].length; columnas++) {
				if (tabla[filas][columnas] == numero) {
					numPosiciones[i] = filas;
					numPosiciones[j] = columnas;
					i += 2;
					j += 2;
				}
			}
		}
	}

// MÉTODO: Metodo que cuenta las posiciones que aparece un numero repetido
// PARÁMETROS: 1 matriz int, int numero, 1 int array
	public static void invertirHorizontal(int[][] tabla, int[][] tablaInvertida) {

		int filas = tabla.length;
		int columnas = tabla[0].length;

		for (int i = 0; i < filas; i++) {
			for (int j = 0; j < columnas; j++) {
				tablaInvertida[i][columnas - 1 - j] = tabla[i][j];
			}
		}

	}
}
