/*Dada una matriz donde:
 * 
- Filas representan estudiantes (4 estudiantes)
- Columnas representan materias (3 materias)
- Valores son notas (0-20)

Calcula:
1. El promedio de notas de cada estudiante*
2. El promedio de cada materia*
3. Identifica al estudiante con mejor promedio*
*/
package actividades.avanzadas;

import java.util.Random;
import java.util.Scanner;


import datosentrada.MetodosEntradaslib;
import matrices.MetodosMatriceslib;

public class Act4 {
	// Scanner como variable de classe y import de un Random
	static Scanner sc = new Scanner(System.in);
	static Random rand = new Random();

	// 1º - Funcion que otorga ID's autoincrementadas y no aleatorias
	public static void alumnosID(int[][] classe) {
		// DECLARAMOS VARIABLES
		int j;
		int idAlumnos;

		// INICIALIZAMOS VALORES
		idAlumnos = 1;
		j = 0;

		// MODIFICAMOS LA PRIMERA COLUMNA QUE REPRESENTA LOS ESTUDIANTES
		for (int i = 0; i < classe.length; i++) {
			classe[i][j] = idAlumnos;
			idAlumnos++;
		}
	}

	// 2º Funcion automatica de llenado de notas aleatorias
	public static void notasAlumnos(int[][] classe) {
		// RECORREMOS EL ARRAY CON EL AUTO INCREMENTADO IMPLEMENTADO
		// Columna comienza con 1 para no modificar la columna 0,0 1,0 2,0 3,0 etc...
		for (int fila = 0; fila < classe.length; fila++) {

			for (int columna = 1; columna < classe[fila].length; columna++) {

				classe[fila][columna] = rand.nextInt(21);
			}
		}
	}

	// 3º Funcion que calcula promedio de alumnos
	public static void promediosAlumnos(int[][] classe, int columnas, double[] promediosAlumnos) {
		// DECLARAMOS VARIABLES
		int sumaNota;
		int i;

		// INICIALIZAMOS VARIABLES
		i = 0;

		for (int fila = 0; fila < classe.length; fila++) {

			// Reiniciamos acumulador
			sumaNota = 0;

			for (int columna = 1; columna < classe[fila].length; columna++) {

				sumaNota += classe[fila][columna]; // Acumulamos notas

			}

			promediosAlumnos[i] = ((double) sumaNota / (columnas - 1));
			i++;

		}

	}

	// 4º Funcion que calcula el promedio de las materias
	public static void promediosMaterias(int[][] classe, double[] promediosMaterias, int filas) {
		// DECLARAMOS VARIABLES
		int columna;
		int sumaNota;
		int i;

		// INICIALIZAMOS VARIABLES
		columna = 1;
		i = 0;
		while (columna < classe[0].length) {
			// REINICIAMOS ACUMULADOR
			sumaNota = 0;

			for (int fila = 0; fila < classe.length; fila++) {
				sumaNota += classe[fila][columna]; // ACUMULAMOS
			}

			promediosMaterias[i] = ((double) sumaNota / filas); // GUARDAMOS VALORES
			i++;
			columna++;

		}
	}

	// 5º Funcion que encuentra mejor promedio del alumno
	public static int maxPromedioAlumno(double[] promediosAlumnos) {

		// DECLARAMOS VARIABLES
		double valorMax;
		int posicion;

		// INICIALIZAMOS INDEX
		valorMax = promediosAlumnos[0]; // Punto de partida
		posicion = 0;

		// RECORREMOS EL ARRAY EN BUSCA DEL PROMEDIO MAYOR
		for (int i = 1; i < promediosAlumnos.length; i++) {

			if (valorMax < promediosAlumnos[i]) {
				// ACTUALIZAMOS VALOR Y POSICION
				valorMax = promediosAlumnos[i];
				posicion = i;
			}
		}

		return posicion;

	}
	//6º Mostrar promedios Alumnos con formato especifico
	public static void mostrarPromedioEstudiante(double[] promediosAlumnos) {
		// Calculamos la potencia una sola vez fuera del bucle por eficiencia
		double potencia = Math.pow(10, 2);
		double valorRedondeado;
		valorRedondeado = 0.0;

		// Recorrer el array
		for (int i = 0; i < promediosAlumnos.length; i++) {
			valorRedondeado = Math.round(promediosAlumnos[i] * potencia) / potencia;
			System.out.println("Estudiante " + (i + 1) + ": " + valorRedondeado);
		}
		System.out.println();
	}
	//7º Mostrar promedios materias con formato especifico
	public static void mostrarPromedioMateria(double[] promediosMaterias, String[] materias) {
		// Calculamos la potencia una sola vez fuera del bucle por eficiencia
		double potencia = Math.pow(10, 2);
		double valorRedondeado;
		valorRedondeado = 0.0;

		// Recorrer el array
		for (int i = 0; i < promediosMaterias.length; i++) {
			valorRedondeado = Math.round(promediosMaterias[i] * potencia) / potencia;
			System.out.print( materias[i] + ": "+ valorRedondeado + "  ");
		}
		
	}

	public static void main(String[] args) {

		// Declaramos variables necesarias
		int filas;
		int columnas;
		String programa;

		programa = " ";

		do {

			// Las inicializamos
			filas = 2;
			columnas = 3;

			// Trazamos limites al usuario
			do {

				// Estructura de control de prints y menus para el usuario
				if (filas < 2 && columnas > 3) {
					System.out.println();
					System.out.println("Numero Insuficiente de alumnos");
					System.out.println();
				}

				if (columnas < 3 && filas > 2) {
					System.out.println();
					System.out.println("Numero Insuficiente de materias");
					System.out.println();
				}

				if (columnas < 3 && filas < 2) {
					System.out.println();
					System.out.println("Numero Insuficiente de alumnos y materias");
					System.out.println();
				}

				filas = MetodosEntradaslib.numeroUsuario("Nº de Alumnos - [Nº Max: 20 | [Nº Min: 2]: ");
				columnas = MetodosEntradaslib.numeroUsuario("Nº de Materias - [Nº Max: 7] | [Nº Min: 3]: ");

			} while ((filas < 2 || filas > 20) || (columnas < 3 || columnas > 7));

			// Declaramos una matriz con las medidas condicionadas del usuario
			int[][] classe = new int[filas][columnas];

			// Habra 7 nombres de materias independientemente si el usuario pone si hay 7
			String[] materias = { "Castellano", "Matemáticas", "Historia", "Biologia", "Gimnasia", "Religion",
					"Tutoria" };

			// Asignamos unas ID's a los Alumnos
			alumnosID(classe);

			// Asignamos notas aleatorias
			notasAlumnos(classe);

			// El array sera tan grande como filas de alumnos haya
			double[] promediosAlumnos = new double[filas];

			// El array sera tan grande como columnas menos el id de alumno haya
			double[] promediosMaterias = new double[columnas - 1];

			promediosAlumnos(classe, columnas, promediosAlumnos); // CALCULAMOS PROMEDIOS ALUMNOS

			promediosMaterias(classe, promediosMaterias, filas); // CALCULAMOS PROMEDIOS MATERIAS

			// MOSTRAMOS LA MATRIZ
			System.out.println("ID Materias");
			MetodosMatriceslib.mostrarMatriz(classe);
			System.out.println();

			// Mostramos la cantidad de alumnos y materias
			System.out.println("Cantidad de Alumnos: " + filas);
			System.out.println("Cantidad de Materias: " + (columnas - 1));
			System.out.println();

			// Muestra nombre de materias cauntas columnas menos las posicion inicial salgan
			mostrarPromedioMateria(promediosMaterias,materias );
			System.out.println();
			
			System.out.println();
			System.out.println("Promedios Alumnos:");
			mostrarPromedioEstudiante(promediosAlumnos);
			System.out.println();

			// Mostramos maximo promedio de alumnos
			int index = maxPromedioAlumno(promediosAlumnos);
			System.out.println("El promedio mas alto es de " + promediosAlumnos[index] + " del Estudiante " + (index + 1));

			System.out.println("¿Quiere coontinuar con el programa? - [Si | No]: ");
			programa = sc.next().toLowerCase();

		} while (programa.equals("si"));

	}

}
