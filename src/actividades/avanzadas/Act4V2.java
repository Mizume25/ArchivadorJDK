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

public class Act4V2 {
	// Scanner como variable de classe y import de un Random
	static Scanner sc = new Scanner(System.in);
	static Random rand = new Random();

	

	

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

			for (int columna = 0; columna < classe[fila].length; columna++) {

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
		columna = 0;
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
	
	public static int menuPrincipal () {
		
		System.out.println("==BIENVENIDO A LA BASE DE DATOS DE ESCUELA RIGOBERTO==");
		System.out.println("¿Que te gustaria revisar?");
		System.out.println("1. Tabla General de Resultados");
		System.out.println("2. Saber cuantos alumnos y materias hay");
		System.out.println("3. Promedio de Materias");
		System.out.println("4. Promedio de Alumnos");
		System.out.println("5. El Estudiante con mejor promedio");
		System.out.println("6. Salir");
		System.out.println("\n Introduzca la accion busque realizar: ");
		return sc.nextInt();
		
	}

	public static void main(String[] args) {

	    // Declaramos variables necesarias
	    int filas;
	    int columnas;
	    String programa;
	    
	    String minimoAlumnos = "Numero Insuficiente de alumnos";
	    String maximoAlumnos = "Demasiados alumnos introducidos de alumnos";
	    String enunciadoAlumnos = "Nº de Alumnos - [Nº Max: 20 | [Nº Min: 2]: ";
	    String titulo = "ESCUELA RIGOBERTO";
	    
	    String minimoMaterias = "Numero Insuficiente de materias";
	    String maximoMaterias = "Solo existen 7 materias";
	    String enunciadoMaterias = "Nº de Materias - [Nº Max: 7 | [Nº Min: 3]: ";
	    
	    programa = " ";
	    boolean sistema;
		sistema = true;
	    do {
	        // Las inicializamos
	        filas = 2;
	        columnas = 3;
	      
	        filas = MetodosEntradaslib.numUsuario(titulo, enunciadoAlumnos, maximoAlumnos, minimoAlumnos, 20, 2);
	        columnas = MetodosEntradaslib.numUsuario(" ", enunciadoMaterias, maximoMaterias, minimoMaterias, 7, 2);
	        
	        // DECLARAMOS MATRIZ
	        int[][] classe = new int[filas][columnas];

	        //LISTA DE NOMBRES DE MATERIAS
	        String[] materias = { "Castellano", "Matemáticas", "Historia", "Biologia", "Gimnasia", "Religion",
	                "Tutoria" };
	        
	        String menu = "\n=== MENÚ E.RIGOBERTO ===" +
		              "\n1. Tabla General" + 
		              "\n2. Cantidad de Alumnos y Materias" + 
		              "\n3. Promedio de Materias" + 
		              "\n4. Promedio de Alumnos" + 
		              "\n5. Promediod de Alumno más alto" + 
		              "\n6. Salir" + 
		              "\n\nOpción: ";
	        // ASIGNAMOS NOTAS ALEATORIAS
	        MetodosMatriceslib.llenarMatrizRandom(classe, 21, 0, 0);

	        // ARRAYS DE PROMEDIOS REQUERIDOS
	        double[] promediosAlumnos = new double[filas];
	        double[] promediosMaterias = new double[columnas];
	        
	        //CALCULOS ESPECIFICOS
	        promediosAlumnos(classe, columnas, promediosAlumnos); // CALCULAMOS PROMEDIOS ALUMNOS
	        promediosMaterias(classe, promediosMaterias, filas); // CALCULAMOS PROMEDIOS MATERIAS
	        // Mostramos maximo promedio de alumnos
	        int index = maxPromedioAlumno(promediosAlumnos);
	        
	        
			
		
	        int numMenu = menuPrincipal();	//FUNCION QUE IMPRIME UN MENU PRINCIPAL
	        do {
				switch (numMenu) {
				case 1:
					MetodosMatriceslib.mostrarTablaPrefijoFilas(classe, "EST", materias, "ESCUELA RIGOBERTO");
					break;
				case 2:
					// Mostramos la cantidad de alumnos y materias
			        System.out.println("Cantidad de Alumnos: " + filas);
			        System.out.println("Cantidad de Materias: " + columnas);
			        System.out.println();
					break;
				case 3:
					// Muestra nombre de materias cauntas columnas menos las posicion inicial salgan
			        mostrarPromedioMateria(promediosMaterias, materias);
			        System.out.println();
					break;
				case 4:
					System.out.println();
			        System.out.println("Promedios Alumnos:");
			        mostrarPromedioEstudiante(promediosAlumnos);
			        System.out.println();
					break;
				case 5:
			        System.out.println("El promedio mas alto es de " + promediosAlumnos[index] + " del Estudiante " + (index + 1));
					break;
				case 6:
					sistema = false;
					System.out.println("\n¡Gracias por usar la Base de Datos de E.Rigobert");
					break;
				default:
					System.out.println("\n[ERROR] Opción no válida. Introduce un número del 1 al 7.");
					break;
				}

				
				if (sistema && numMenu != 6) {
					numMenu = MetodosEntradaslib.numeroUsuario(menu);
				}

				} while (sistema);
	        
	        System.out.println("¿Quiere reiniciar el programa? - [Si | No]: ");
	        programa = sc.next().toLowerCase();

	    } while (programa.equals("si"));

	    
	}
}
