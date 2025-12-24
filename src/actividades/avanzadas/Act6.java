package actividades.avanzadas;

import java.util.Random;
//PROGRAMA DE ANALISIS DE DATOS DE UNA LIGA DE DEPORTE
import java.util.Scanner;

import arrays.MetodosArrayslib;
import datosentrada.MetodosEntradaslib;
import matrices.MetodosMatriceslib;

public class Act6 {
	static Scanner sc = new Scanner(System.in); // Declarar Scanner como variable de classe
	static Random rand = new Random(); // Declarar Random como variable de classe

	//FUNCION BASE
	public static int pedirNumeroEquipos (int numEquipos) {
		// Do while que controla y condiciona los datos del usuario
		numEquipos = 5;
		do {
			System.out.println("== LALIGA EA SPORTS ==");
			numEquipos = MetodosEntradaslib.numeroUsuario("Numero de Equipos a analizar [5-20]: ");

			// Estructura de control con if-else para mensajes específicos
			if (numEquipos < 5) {
				System.out.println("\n[ERROR]: El análisis requiere un mínimo de 5 equipos.");
				System.out.println();
				
			} else if (numEquipos > 20) {
				System.out.println("\n[ERROR]: LALIGA EA SPORTS solo cuenta con 20 equipos.");
				System.out.println();
			}

		} while (numEquipos < 5 || numEquipos > 20);
		
		return numEquipos;
		// Calculamos las jornadas en base a la cantidad de equipos que hay Expresion:
		// (numEquipos - 1) * 2
	}
	// 1º Funcion llenar array de Strings usuario con los nombres de los clubes del
	public static void llenarNombresEquipos(String[] equiposLaLiga, String[] equiposUsuario) {
		// Array para marcar qué índices ya hemos usado
	    boolean[] usado = new boolean[equiposLaLiga.length];
	    int index;

	    for (int i = 0; i < equiposUsuario.length; i++) {
	        // Generamos un random y si ya salió, tiramos otra vez (bucle de búsqueda)
	        do {
	            index = rand.nextInt(equiposLaLiga.length);
	        } while (usado[index]); // Si usado[index] es true, repite el random

	        // Cuando sale del do-while, tenemos un número que NO se ha repetido
	        equiposUsuario[i] = equiposLaLiga[index];
	        usado[index] = true; // Marcamos este número como "ya usado"
	    }
	}
	// 2º Funcion que calcula el numero de puntos de cada equipo
	public static void llenarDatosEquiposLiga(int[][] tablaDeportiva, int numEquipos, int numJornadas,
			int[][] tablaResultado, int[][] tablaTiros, int[][] totalResultado) {

		int filas;
		int totalPuntos;
		int j;
		int k;

		totalPuntos = 0;
		filas = 0;
		j = 0;

		// Declaramos un array que guarade los puntos
		int[] puntos = new int[numJornadas]; // NumEquipos - 1 Representa numero de afrentas
		int[] puntosPosibles = { 0, 1, 3 }; // Los valores que tú quieres

		do {

			k = 0;

			for (int i = 0; i < puntos.length; i++) {
				j = rand.nextInt(puntosPosibles.length);
				puntos[i] = puntosPosibles[j];

				if (k < puntos.length) {
					if (j == 2) {
						tablaTiros[filas][k] = rand.nextInt((20 - 10) + 1) + 10;
						tablaResultado[filas][k] = puntosPosibles[j];
						totalResultado[filas][0] += 1;
					}

					if (j == 1) {
						tablaTiros[filas][k] = rand.nextInt((10 - 5) + 1) + 5;
						tablaResultado[filas][k] = puntosPosibles[j];
						totalResultado[filas][2] += 1;
					}

					if (j == 0) {
						tablaTiros[filas][k] = rand.nextInt((5 - 0) + 1) + 0;
						tablaResultado[filas][k] = puntosPosibles[j];
						totalResultado[filas][1] += 1;
					}

					k++;
				}
			}

			totalPuntos = MetodosArrayslib.sumaValorTotalArray(puntos);

			tablaDeportiva[filas][1] = totalPuntos;

			filas++;

		} while (filas < tablaDeportiva.length);

	}
	// 3º - Funcion que ordena la matriz con metodo bombolla
	public static void OrdenarTablaLiga(int[][] tablaDeportiva) {

		boolean cambios;
		int filas;
		int j;

		do {
			cambios = false; // Reinicio de boolean,index 1 y index 2
			filas = tablaDeportiva.length - 1;
			j = tablaDeportiva.length - 2;

			// Recorremos todo el array comparando parejas consecutivas

			while (j >= 0) {

				if (tablaDeportiva[filas][1] > tablaDeportiva[j][1]) {
					// Intercambiamos valores
					int temp = tablaDeportiva[filas][1];
					tablaDeportiva[filas][1] = tablaDeportiva[j][1];
					tablaDeportiva[j][1] = temp;

					cambios = true; // Hubo al menos un cambio
				}

				// Avanzamos a la siguiente pareja
				filas--;
				j--;
			}

			// Si hubo cambios, repetimos desde el principio
		} while (cambios);

	}
	// 4º Funcion que calcula Goles a favor
	public static void golesEquiposGF(int[][] tablaDeportiva, int numEquipos, int numJornadas,double [] golesFA) {

		int filas;
		int totalPuntos;
		
		totalPuntos = 0;
		filas = 0;
		
		

		// Declaramos un array que guarade los puntos
		int[] goles = new int[numJornadas];

		do {
			for (int i = 0; i < goles.length; i++) {
				goles[i] = rand.nextInt(6);
			}
			totalPuntos = MetodosArrayslib.sumaValorTotalArray(goles);
			golesFA[filas] = ((double)totalPuntos/numJornadas); 
			tablaDeportiva[filas][2] = totalPuntos;
			filas++;
		} while (filas < tablaDeportiva.length);
	}
	// 4º Funcion que calcula Goles a favor
	public static void golesEquiposGC(int[][] tablaDeportiva, int numEquipos, int numJornadas, double [] golesCO) {

			int filas;
			int totalPuntos;
			
			totalPuntos = 0;
			filas = 0;
			
			

			// Declaramos un array que guarade los puntos
			int[] goles = new int[numJornadas];

			do {
				for (int i = 0; i < goles.length; i++) {
					goles[i] = rand.nextInt(6);
				}
				totalPuntos = MetodosArrayslib.sumaValorTotalArray(goles);
				golesCO[filas] = ((double)totalPuntos/numJornadas);
				tablaDeportiva[filas][3] = totalPuntos;
				filas++;
			} while (filas < tablaDeportiva.length);
	}
	// 5º Funcion que Calcula diferencia de goles
	public static void diferenciaGol(int[][] tablaDeportiva) {

		int filas;
		int diferencia;

		diferencia = 0;
		filas = 0;

		do {
			diferencia = tablaDeportiva[filas][2] - tablaDeportiva[filas][3];
			tablaDeportiva[filas][4] = diferencia;
			filas++;

		} while (filas < tablaDeportiva.length);
	}
	// 6º - Calcular la efectividad de un equipo
	public static void calcularEfectividadEquipo(int[][] tablaDeportiva, int[][] tablaTiros,int numEquipos,double [] efectividadEquipo) {
		
		int [] sumaFilas = new int [numEquipos]; 
		
		
		for (int fila = 0; fila < tablaTiros.length; fila++) {
			sumaFilas[fila] = 0; // Inicializar
			
			for (int columna = 1; columna < tablaTiros[fila].length; columna++) {
				sumaFilas[fila] += tablaTiros[fila][columna];
				}
			}

		int filas;
		filas = 0;
		
		
		do {
			
			efectividadEquipo[filas] = ((double) tablaDeportiva[filas][2] / sumaFilas[filas]) * 100;
			filas++;
		} while (filas < tablaDeportiva.length);

	}
	//7º - Funcion para calcular probabilidad de victoria de cada equipo
	public static void calcularProbVictoria(int [][] tablaDeportiva,double [] probabilidadVictoria) {
		
		double probVic;
		double numerador;
		double denominador;
		
		probVic = 0.0;
		
		for (int filas = 0; filas < tablaDeportiva.length; filas++) {
			
			numerador = Math.pow((double)tablaDeportiva[filas][2], 2);
			denominador = numerador + Math.pow((double)tablaDeportiva[filas][3], 2);

			// Si quieres evitar 0 absoluto, añade un pequeño valor
			probVic = (numerador / (numerador + denominador)) * 100;
			
			probabilidadVictoria[filas] = probVic;
			
			
			
		}
		
		
		
	}
	//8º - Rendimiento de equipos con formato
	public static void mostrarTablaGeneralFormato (String[] equiposUsuario,int[][] tablaDeportiva,double [] efectividadEquipo,double [] probabilidadVictoria) {
		// --- CONFIGURACIÓN DE ANCHOS PARA QUE COINCIDA CON LA TABLA ---
		int anchoNombre1 = 20; 
		int anchoCifras1 = 10;
		int numColumnas1 = tablaDeportiva[0].length;
		int anchoTotal1 = anchoNombre1 + (numColumnas1 * anchoCifras1); 

		String titulo = "ESTADÍSTICAS DE LALIGA";

		// --- RECTÁNGULO DEL TÍTULO (BLOQUE INDEPENDIENTE) ---
		System.out.print("┌"); 
		for (int k = 0; k < anchoTotal1; k++) System.out.print("—");
		System.out.println("┐");

		System.out.print("|");
		int espacios1 = (anchoTotal1 - titulo.length()) / 2;
		for (int k = 0; k < espacios1; k++) System.out.print(" ");
		System.out.print(titulo);

		// Rellenamos el resto de espacios para que el borde derecho cierre perfecto
		int resto1 = anchoTotal1 - titulo.length() - espacios1;
		for (int k = 0; k < resto1; k++) System.out.print(" ");
		System.out.println("|");

		System.out.print("└"); 
		for (int k = 0; k < anchoTotal1; k++) System.out.print("—");
		System.out.println("┘");
		
		// --- CONFIGURACIÓN DE ANCHOS (Variables únicas para la cabecera) ---
		int anchoNombre_Cab = 20; 
		int anchoCifras_Cab = 10;
		int numColumnas_Cab = 5; // Posición, Puntos, GF, GC, DG
		int anchoTotal_Cab = anchoNombre_Cab + (numColumnas_Cab * anchoCifras_Cab); 

		// --- 1. TECHO DEL RECTÁNGULO DE CABECERA ---
		System.out.print("┌"); 
		for (int k = 0; k < anchoTotal_Cab; k++) System.out.print("—");
		System.out.println("┐");

		// --- 2. CONTENIDO DE LA CABECERA ---
		System.out.print("|");
		// Título de la primera columna (Nombres de Club)
		System.out.printf(" %-" + (anchoNombre_Cab - 2) + "s |", "CLUB");

		// Títulos de las columnas de datos
		System.out.printf("%" + (anchoCifras_Cab - 2) + "s |", "POS");
		System.out.printf("%" + (anchoCifras_Cab - 2) + "s |", "PTS");
		System.out.printf("%" + (anchoCifras_Cab - 2) + "s |", "GF");
		System.out.printf("%" + (anchoCifras_Cab - 2) + "s |", "GC");
		System.out.printf("%" + (anchoCifras_Cab - 2) + "s |", "DG");
		System.out.println();

		// --- 3. SUELO DEL RECTÁNGULO DE CABECERA ---
		System.out.print("└"); 
		for (int k = 0; k < anchoTotal_Cab; k++) System.out.print("—");
		System.out.println("┘");
		
		// 1. Ajustamos el ancho: la primera columna será más ancha (20) para los nombres
		int anchoNombre = 20; 
		int anchoCifras = 10;
		int numColumnasDatos = tablaDeportiva[0].length;
		int anchoTotal = anchoNombre + (numColumnasDatos * anchoCifras);

		// --- TECHO ---
		System.out.print("┌");
		for (int k = 0; k < anchoTotal; k++) System.out.print("—");
		System.out.println("┐");

		// --- CONTENIDO ---
		for (int f = 0; f < equiposUsuario.length; f++) {
		    System.out.print("|"); // Borde izquierdo
		    
		    // PRIMERA COLUMNA: El nombre del equipo (String)
		    // %-20s alinea el texto a la izquierda en 20 espacios
		    System.out.printf(" %-18s |", equiposUsuario[f]);
		    
		    // RESTO DE COLUMNAS: Los números de la matriz (int)
		    for (int c = 0; c < tablaDeportiva[f].length; c++) {
		        System.out.printf("%8d |", (int)tablaDeportiva[f][c]);
		    }
		    System.out.println();
		}

		// --- SUELO ---
		System.out.print("└");
		for (int k = 0; k < anchoTotal; k++) System.out.print("—");
		System.out.println("┘");
		
	}		
	// 9º Efectividad y probabilidad con pronosticos de cada equipo con formato tabla
	public static void  mostrardatosLaligaFormato (String [] equiposUsuario, double[] efectividadEquipo,  double []probabilidadVictoria) {
		// --- CONFIGURACIÓN DE ANCHOS ---
		int anchoNombre_Ef = 20; 
		int anchoDato_Ef = 15;
		int anchoTotal_Ef = anchoNombre_Ef + (anchoDato_Ef * 2); 

		// --- 1. TECHO DEL RECTÁNGULO ---
		System.out.print("┌"); 
		for (int k = 0; k < anchoTotal_Ef; k++) System.out.print("—");
		System.out.println("┐");

		// --- 2. CABECERA ---
		System.out.print("|");
		System.out.printf(" %-" + (anchoNombre_Ef - 2) + "s |", "CLUB");
		System.out.printf(" %-" + (anchoDato_Ef - 2) + "s |", "EFECTIVIDAD");
		System.out.printf(" %-" + (anchoDato_Ef - 2) + "s |", "%PROB VIC.");
		System.out.println();

		// Línea divisoria interna
		System.out.print("├"); 
		for (int k = 0; k < anchoTotal_Ef; k++) System.out.print("—");
		System.out.println("┤");

		// --- 3. CONTENIDO DE DATOS ---
		for (int i = 0; i < efectividadEquipo.length; i++) {
		    System.out.print("|");
		    
		    // Nombre del equipo
		    System.out.printf(" %-" + (anchoNombre_Ef - 2) + "s |", equiposUsuario[i]);
		    
		    // Datos con el símbolo de %
		    // Usamos .2f para los decimales y %% para imprimir el símbolo de porcentaje literal
		    System.out.printf("%12.2f%% |", efectividadEquipo[i]);
		    System.out.printf("%12.2f%% |", probabilidadVictoria[i]);
		    System.out.println();
		}

		// --- 4. SUELO DEL RECTÁNGULO ---
		System.out.print("└"); 
		for (int k = 0; k < anchoTotal_Ef; k++) System.out.print("—");
		System.out.println("┘");
	}
	//10 º Mostrar tabla de resultados con formato
	public static void mostrarResultadoJornadasFormato(int numEquipos, String[] equiposUsuario,int numJornadas,int[][]tablaResultado) {
		// 1. Calculamos el ancho del equipo dinámicamente según el nombre más largo
				int anchoEquipo = 10; 
				for (int i = 0; i < numEquipos; i++) {
				    if (equiposUsuario[i].length() > anchoEquipo) {
				        anchoEquipo = equiposUsuario[i].length() + 2;
				    }
				}

				// 2. Definimos el ancho fijo de cada columna de datos
				int esp = 6; 

				// 3. CABECERA DINÁMICA (J1 a J8...)
				System.out.printf("%-" + anchoEquipo + "s", "Equipo");
				for (int j = 0; j < numJornadas; j++) {
				    // Usamos (j+1) para que el usuario vea "J1" en la posición 0
				    System.out.printf("%-" + esp + "s", "J" + (j + 1)); 
				}
				System.out.println();

				// Línea decorativa dinámica
				int totalGuiones = anchoEquipo + (numJornadas * esp);
				for(int k = 0; k < totalGuiones; k++) System.out.print("-");
				System.out.println();

				// 4. FILAS DINÁMICAS (Sin saltar columnas)
				for (int i = 0; i < numEquipos; i++) {
				    // Nombre del equipo
				    System.out.printf("%-" + anchoEquipo + "s", equiposUsuario[i]);
				    
				    // Imprimimos DESDE j=0 hasta el final porque ya no hay IDs
				    for (int j = 0; j < numJornadas; j++) {
				        System.out.printf("%-" + esp + "d", tablaResultado[i][j]);
				    }
				    System.out.println();
				}
	}
	//11 º Verifica nombre en la accion de buscar datos de equipo especifico
	public static boolean verficacionNombre(String nombre, String[] equiposUsuario) {
	    int i = 0;
	    boolean encontrado = false;  // Mejor nombre de variable
	    
	    // IMPORTANTE: usar i < equiposUsuario.length (no length-1)
	    // para revisar TODOS los elementos
	    
	    while (!encontrado && i < equiposUsuario.length) {
	        if (equiposUsuario[i].equals(nombre)) {  // SIN el !
	            encontrado = true;
	        } 
	        i++;
	    }
	    
	    
	    if (!encontrado) {
	    	System.out.println();
	    	System.out.println("Nombre Equivocado");	
		}
	   
	    
	    return encontrado;
	}
	//12º Busca la posicon especifica de un equipo una vez encontrado
	public static int posicionEquipo(String nombre, String[] equiposUsuario) {
		int index = 0;
		int i = 0;
		boolean coincidencia = false;
		
		while (!coincidencia) {
			
			if (equiposUsuario[i].equals(nombre)) {
				index = i;
				coincidencia = true;
			}
			i++;
		}
		
		return index;
		
		
	}
	//13º Print del menu principal de la base de datos
	public static int menuPrincipal () {
		
		System.out.println("==Bienvenido a la base de datos de la LaLiga Sport==");
		System.out.println("¿Que te gustaria revisar?");
		System.out.println("1. Mostrar Tabla General");
		System.out.println("2. Mostrar Tabla de Rendimiento");
		System.out.println("3. Mostrar Resultados Generales de esta temporada");
		System.out.println("4. Mostrar Resultados de Tiros a Puerta");
		System.out.println("5. Mostrar Tabla de resultados finales de las jornadas realizadas");
		System.out.println("6. Mostrar lista de equipos analizados");
		System.out.println("7. Buscar datos estadisticos de un equipo en concreto");
		System.out.println("8. Salir de la Base de datos LaLiga");
		System.out.println("\n Introduzca la accion busque realizar: ");
		return sc.nextInt();
		
	}	
	//14º Ordena la secuencia de victorias y derrotas de un equipo
	public static void ordenarTablaResultado(int[][] tablaResultado) {
	    
	    int n = tablaResultado.length; // Número de filas (equipos)
	    int m = tablaResultado[0].length; // Número de columnas (jornadas)
	    
	    // Paso 1: Crear un array con las sumas de cada fila
	    int[] sumas = new int[n];
	    
	    for (int i = 0; i < n; i++) {
	        int sumaFila = 0;
	        for (int j = 0; j < m; j++) {
	            sumaFila += tablaResultado[i][j];
	        }
	        sumas[i] = sumaFila;
	    }
	    
	    // Paso 2: Ordenar las filas usando el método de burbuja
	    boolean cambios;
	    do {
	        cambios = false;
	        for (int i = 0; i < n - 1; i++) {
	            // Si la fila i tiene menos puntos que la fila i+1, intercambiar
	            if (sumas[i] < sumas[i + 1]) {
	                // Intercambiar sumas
	                int tempSuma = sumas[i];
	                sumas[i] = sumas[i + 1];
	                sumas[i + 1] = tempSuma;
	                
	                // Intercambiar filas completas de tablaResultado
	                int[] tempFila = tablaResultado[i];
	                tablaResultado[i] = tablaResultado[i + 1];
	                tablaResultado[i + 1] = tempFila;
	                
	                cambios = true;
	            }
	        }
	    } while (cambios);
	}	
	//15º Muestra lista de equipos que el programa ha analizado
	public static void mostrarListaEquipos(String [] equiposUsuario) {
		System.out.println("==Equipos que se han somteido a analisis=");
		for (int i = 0; i < equiposUsuario.length; i++) {
			System.out.println(equiposUsuario[i] + " ");
		}
	}
	//16º Funcion que muestra Datos Generales de Laliga
	public static void mostrarDatosGenerales (int [][] tablaDeportiva,double [] golesFA,double [] golesCO,String [] equiposUsuario, int numJornadas) {
		//CALCULOS GENERALES
				int sumaTotal;
				sumaTotal = 0;
				for (int i = 0; i < tablaDeportiva.length; i++) {
					
					sumaTotal += tablaDeportiva[i][1];
				}
				
				System.out.println("Total de Puntos de esta Liga: " + sumaTotal);
				System.out.println();
				
				System.out.println();
				System.out.println("==LISTA DE PROMEDIOS TOTAL DE GOLES A FAVOR==");
				
				for (int j = 0; j < golesFA.length; j++) {
					System.out.printf("%s: %.3f%%\n",equiposUsuario[j],golesFA[j]);
				}
				
				System.out.println();
				System.out.println("==LISTA DE PROMEDIOS TOTAL DE GOLES EN CONTRA==");
				
				for (int j = 0; j < golesCO.length; j++) {
					System.out.printf("%s: %.3f%%\n",equiposUsuario[j],golesCO[j]);
				}
				
				int indexFA = MetodosArrayslib.maxValorArray(golesFA);
				int indexCO= MetodosArrayslib.maxValorArray(golesCO);
				System.out.println();
				System.out.printf("Equipo con mayor GF en el total de jornadas realizadas "
						+ "es %s\ncon un promedio de %.2f%% goles en el total de %d jornadas jugadas",equiposUsuario[indexFA],golesFA[indexFA],numJornadas);
				System.out.println();
				System.out.println();
				System.out.printf("Equipo con mayor GC en el total de jornadas realizadas "
						+ "es %s\ncon un promedio de %.2f%% goles en el total de %d jornadas jugadas",equiposUsuario[indexCO],golesFA[indexCO],numJornadas);
				System.out.println();
	}
	// 17º Funcion para mostrar datos de un equipo especifico
	public static void mostrarDatosEquipoEspecifico(int [][] tablaDeportiva,double [] golesFA,double [] golesCO,String [] equiposUsuario, int numJornadas,
	double [] probabilidadVictoria, double [] efectividadEquipo, int [][]totalResultado, int numEquipos, int [][]tablaResultado,int[][] tablaTiros) {
		
		String respuesta = "";
		boolean sistema = true;
		
		while (sistema) {
			System.out.println();
			// 1º Imprimos una lista con los equipos que se han analizado
			System.out.println("==Equipos que se han somteido a analisis=");
			for (int i = 0; i < equiposUsuario.length; i++) {
				System.out.println(equiposUsuario[i] + " ");
			}
			System.out.println();
			System.out.println();
			boolean verificacionNombre;
			verificacionNombre = false;
			String nombre;
			nombre = " ";
			sc.nextLine().trim(); // <-- ESTA ES LA LÍNEA CRÍTICA
			do {

			System.out.println("Nombre que quieres buscar[ej. FC Barcelona]: ");
			nombre = sc.nextLine().trim(); //El String estan todo mezclado entre minusculas y mayusculas le exigiremos al usuario que ocpie el nombre especifico que aparece en la lista
			
			verificacionNombre = verficacionNombre(nombre,equiposUsuario);
			
		
			} while (!verificacionNombre);
			
			
			int posicion = posicionEquipo(nombre, equiposUsuario);
			System.out.println();
			System.out.println("El equipo " + nombre + " esta en la posicion " + (posicion + 1) + " de la tabla Laliga Sport");
			System.out.println();
			System.out.println("Puntos: " + tablaDeportiva[posicion][1]);
			System.out.println("Goles a Favor: " + tablaDeportiva[posicion][2]);
			System.out.println("Goles en Contra: " + tablaDeportiva[posicion][3]);
			System.out.println("Diferencia de Gol: " + tablaDeportiva[posicion][4]);
			System.out.println();
			System.out.printf("Efectividad en la Temporada: %.2f%%\n", efectividadEquipo[posicion]);
			System.out.printf("Probabilidad de Victoria: %.2f%%\n", probabilidadVictoria[posicion]);
			System.out.println();
			System.out.printf("Promedio e Goles a favor %.2f%%\n" , golesFA[posicion]);
			System.out.printf("Promedio e Goles en contra %.2f%%\n" , golesCO[posicion]);
			System.out.println();
			System.out.println("Total de victoria: " + totalResultado[posicion][0]);
			System.out.println("Total de derrotas: " + totalResultado[posicion][1]);
			System.out.println("Total de empates: " + totalResultado[posicion][2]);
			System.out.println();
			
			//SubMenu
			boolean subMenu;
			subMenu = true;
			String menu = "\nMenu de Comprobaciones" +
		              "\n1. Tabla General" + 
		              "\n2. Rendimiento" + 
		              "\n3. Resultados por Jornada" +      
		              "\n4. Tiros a puerta por jornada" +    
		              "\n5. Salir" + 
		              "\n\nOpción: ";
			
			int numUsuario = 0;
			do {
			    // PRIMERO pedir la opción
			    numUsuario = MetodosEntradaslib.numeroUsuario(menu);
			    
			    // LUEGO procesar con switch
			    switch (numUsuario) {
			    case 1:
			        mostrarTablaGeneralFormato(equiposUsuario, tablaDeportiva, efectividadEquipo, probabilidadVictoria);
			        break;
			    case 2:
			        mostrardatosLaligaFormato(equiposUsuario, efectividadEquipo, probabilidadVictoria);
			        break;
			    case 3:
			        mostrarResultadoJornadasFormato(numEquipos, equiposUsuario, numJornadas, tablaResultado);
			        break;
			    case 4:
			    	mostrarTablaTirosPuerta(tablaTiros, equiposUsuario, numEquipos, numJornadas);
			    	break;
			    case 5:
			        subMenu = false;
			        System.out.println("Cierre de SubMenu");
			        break;
			    default:
			        System.out.println("Opción no válida. Elige 1-5.");
			        break;
			    }
			    
			} while (subMenu);
			
			
			System.out.println();
			System.out.println();
			System.out.print("¿Quieres buscar otro equipo especifico?(si/no): ");
			respuesta = sc.next().toLowerCase();
			sc.nextLine();
			if (!respuesta.equals("si")) {
				sistema = false;
			}
			
			} 
	}
	// 18 º Mostrar Tabla de Tiros a puerta con formato tabla
	public static void mostrarTablaTirosPuerta (int [][] tablaTiros, String [] equiposUsuario, int numEquipos, int numJornadas) {
		int n = tablaTiros.length; // Número de filas (equipos)
	    int m = tablaTiros[0].length; // Número de columnas (jornadas)
	    
	    // Paso 1: Crear un array con las sumas de cada fila
	    int[] sumas = new int[n];
	    
	    for (int i = 0; i < n; i++) {
	        int sumaFila = 0;
	        for (int j = 0; j < m; j++) {
	            sumaFila += tablaTiros[i][j];
	        }
	        sumas[i] = sumaFila;
	    }
	    
	    // Paso 2: Ordenar las filas usando el método de burbuja
	    boolean cambios;
	    do {
	        cambios = false;
	        for (int i = 0; i < n - 1; i++) {
	            // Si la fila i tiene menos puntos que la fila i+1, intercambiar
	            if (sumas[i] < sumas[i + 1]) {
	                // Intercambiar sumas
	                int tempSuma = sumas[i];
	                sumas[i] = sumas[i + 1];
	                sumas[i + 1] = tempSuma;
	                
	                // Intercambiar filas completas de tablaResultado
	                int[] tempFila = tablaTiros[i];
	                tablaTiros[i] = tablaTiros[i + 1];
	                tablaTiros[i + 1] = tempFila;
	                
	                cambios = true;
	            }
	        }
	    } while (cambios);
	    
	 // 1. Calculamos el ancho del equipo dinámicamente según el nombre más largo
		int anchoEquipo = 10; 
		for (int i = 0; i < numEquipos; i++) {
		    if (equiposUsuario[i].length() > anchoEquipo) {
		        anchoEquipo = equiposUsuario[i].length() + 2;
		    }
		}

		// 2. Definimos el ancho fijo de cada columna de datos
		int esp = 6; 

		// 3. CABECERA DINÁMICA (J1 a J8...)
		System.out.printf("%-" + anchoEquipo + "s", "Equipo");
		for (int j = 0; j < numJornadas; j++) {
		    // Usamos (j+1) para que el usuario vea "J1" en la posición 0
		    System.out.printf("%-" + esp + "s", "J" + (j + 1)); 
		}
		System.out.println();

		// Línea decorativa dinámica
		int totalGuiones = anchoEquipo + (numJornadas * esp);
		for(int k = 0; k < totalGuiones; k++) System.out.print("-");
		System.out.println();

		// 4. FILAS DINÁMICAS (Sin saltar columnas)
		for (int i = 0; i < numEquipos; i++) {
		    // Nombre del equipo
		    System.out.printf("%-" + anchoEquipo + "s", equiposUsuario[i]);
		    
		    // Imprimimos DESDE j=0 hasta el final porque ya no hay IDs
		    for (int j = 0; j < numJornadas; j++) {
		        System.out.printf("%-" + esp + "d", tablaTiros[i][j]);
		    }
		    System.out.println();
		}
	    
	}
	
	public static void main(String[] args) {	
		
		//DECLARAMOS VARIABLES BASE
		int numEquipos;
		int numJornadas;
		
		//DECLARAMOS UN ARRAY DE STRINGS BASE CON NOMBRES DE LA LA LIGA BASE
		String[] equiposLaLiga = { "Real Madrid", "FC Barcelona", "Atlético Madrid", "Villarreal CF", "Real Betis",
				"Athletic Club", "Real Sociedad", "Girona FC", "Sevilla FC", "Valencia CF", "RC Celta", "RCD Espanyol",
				"CA Osasuna", "Getafe CF", "Rayo Vallecano", "RCD Mallorca", "Deportivo Alavés", "Elche CF",
				"Levante UD", "Real Oviedo" };
		
		//INICIALIZAMOS VARIABLES
		numEquipos = 5;
		numJornadas = 0;
		
		numEquipos = pedirNumeroEquipos(numEquipos);	//EJECUTAMOS LA FUNCION BASE
		numJornadas = (numEquipos - 1) * 2;				//CALCULAMOS LA SEGUNDA VARIABLE BASE DEL PROGRAMA
		
		//ENUNCIADO DE INICIO
		System.out.println("\n[INFO]: Configuración aceptada.");
		System.out.println("Para " + numEquipos + " equipos, se analizarán " + numJornadas + " jornadas (Ida y Vuelta).");
		System.out.println();
		
		
		//DECLARAMOS ARRAYS Y MATRICES NECESARIAS PARA REALIZAR TODO EL MARCO DE OPERACIONES QUE NECESITEMOS
		
		//Array que imprime la cantidad de nombres del array base de Laliga que el usuario especifica
		String[] equiposUsuario = new String[numEquipos];
		
		//Matriz madre que se pesupondra base de todo el programa y de las cuales surjen todas las operaciones subsecuentes
		
		//Matrices Estaticas/Dinamicas
		int[][] tablaDeportiva = new int[numEquipos][5];				//TABLA GENERAL DE RESULTADOS
		int[][] totalResultado = new int[numEquipos][3];				//TABLA GENERAL TOTAL DE VICTORIAS / DERROTAS / EMPATES DE UN EQUIPO
		//Matrices Dinamicas
		double [] efectividadEquipo = new double[numEquipos];			//EFECTIVIDAD DE EQUIPO
		double [] probabilidadVictoria = new double [numEquipos];		//PROBABILIDAD DE VICTORIA
		int[][] tablaTiros = new int[numEquipos][numJornadas];			//TABLA DE TIROS A PUERTA POR JORNADA JUGADA
		int[][] tablaResultado = new int[numEquipos][numJornadas];		//TABLA QUE REGISTRA LAS DERROTAS Y VICTORISA Y EMPATES QUE HUBO
		double [] golesFA = new double [numEquipos];
		double [] golesCO = new double [numEquipos];
		
		
		/*NOTA IMPORTANTE: INCLUSO SI LOS DATOS SON RANDOMS EN CUANTO A SU REALIZACION PRINCIPAL (Los puntos de un equipo) en general
		 * el codigo se encarga ce compilar esos resultados como datos base en los caules se subdesarollara los posteriores calculos 
		 * realizados siemore tomando estos como referencia incluso en interludio de algunos calculos uso randoms para establecer
		 * secuencia de valores determinados.
		 * 
		 * NOTA 1:UN EQUIPO QUE TIENE MUCHOS PUNTOS NO PEUDE TENER MENOS EFECTIVIDAD EN PORTERIA POR DEFECTO TAMPOCO PUEDEN TENER
		 * INFERIORIDAD EN GOLES SI BIEN NO DEBEN SER DATOS EXAGERADAMENTE DISTANTES DEBEN MANTENER UNA COHERENCIA INEDITA
		 * SI TIENE MUCHOS PUNTOS ES PORQUE SU NUMERO RANDOM DE 3 SALIO MAS POR TANTO GANAROON MAS PARTIDOS
		 * 
		 * LOS TIROS PUERTA SE MANIPULAN CON ESA COHERENCIA SI UN EQUIPO GANA UN PARTIDO SE ESTABLECE QUE EL LIMITE ESTA ENTRE 10 - 21
		 * SI HAY EMPATE ENTRE 10 - 5 SI PIERDEN ENTRE 5 - 0 SI UN EQUIPO PIERDE SI BIEN NO IMPLICA MENOS TIROS APUERTA NI MENOS
		 * GOLES (PUEDEN PERDER 4-5) SE ASUMIRA QUE POR LO GENERAL EL RENDIMIENTO DE UNE QUIPO SE MEDIRA MAS POR VICTORIAS QUE POR TIROS
		 * 
		 * PARA FUTURAS MODIFICACIONES SENCILLAMENTE HAY QUE MODIFICAR LOS RANGOS
		 * */
		
		//EJECUCCION DE TODAS LAS FUNCIONES DE CALCULO
		
		//	1.1LLENADO DE DATOS
		
		//1º - LLENAMOS EL ARRAY DE EQUIPOS ALEATORIOS CON UN ESTRUCTURA DE DESCARTE
		llenarNombresEquipos(equiposLaLiga, equiposUsuario);
		
		//2º - LLENAR DE DATOS GENERALES A LOS EQUIPOS
		llenarDatosEquiposLiga(tablaDeportiva, numEquipos, numJornadas, tablaResultado, tablaTiros, totalResultado);
		
		//3º - FUNCION QUE DOTA DE GOLES A FAVOR Y ENCONTRA LLENA LA MATRIZ PRINCIPAL JUNTO A LA DIFERENCIA DE GOLES
		golesEquiposGF(tablaDeportiva, numEquipos, numJornadas,golesFA);		
		golesEquiposGC(tablaDeportiva, numEquipos, numJornadas,golesCO);
		diferenciaGol(tablaDeportiva);
		
		// 4º - FUNCION QUE DOTA LAS POSICIONES A LA MATRIZ DEPORTIVA
		MetodosMatriceslib.idsAutoIncrementadas(tablaDeportiva);
		
		// 1.2 ORDENAMIENTO DE DATOS
		
		//5º - ORDENAMIENTO DE TABLAS DE MAYOR A MENOR - TABLADEPORTIVA | TABLA RESULTADO
		OrdenarTablaLiga(tablaDeportiva);
		ordenarTablaResultado(tablaResultado);
		
		// 1.3 CALCULO DE DATOS
		
		//7º - FUNCION QUE CALCULA LA EFECTIVIDAD DE EL EQUIPO
		calcularEfectividadEquipo(tablaDeportiva, tablaTiros, numEquipos, efectividadEquipo);
		
		//8º - FUNCION QUE CALCULA LA PROBABILIDAD DE VICTORIA
		calcularProbVictoria(tablaDeportiva, probabilidadVictoria);
		
		
		/*==========================================================/
		  MENU PRINCIPAL INTERACTIVO PARA RECORRER TODA LA MATRIZ
		/==========================================================*/
		
		//ESTRUCTURA DE CONTROL PRINCIPAL
		boolean sistema;
		sistema = true;
		
		//SUB MENU
		String menu = "\n=== MENÚ LALIGA ===" +
	              "\n1. Tabla General" + 
	              "\n2. Rendimiento" + 
	              "\n3. Resultados Temporada" + 
	              "\n4. Resultados Tiros a Puerta" + 
	              "\n5. Resultados por Jornada" + 
	              "\n6. Equipos Analizados" + 
	              "\n7. Buscar Equipo" + 
	              "\n8. Salir" + 
	              "\n\nOpción: ";
		
		// MOSTRAR MENU PRINCIPAL
		int numUsuario = menuPrincipal();	//FUNCION QUE IMPRIME UN MENU PRINCIPAL
		
		//ESTRUCTURA DO WHILE QUE MANTINE EN VIGENCIA EL MENU INTERACTIVO
		do {
			switch (numUsuario) {
			case 1:
				mostrarTablaGeneralFormato(equiposUsuario, tablaDeportiva, efectividadEquipo, probabilidadVictoria); 
				break;
			case 2:
				mostrardatosLaligaFormato(equiposUsuario, efectividadEquipo, probabilidadVictoria);
				break;
			case 3:
				mostrarDatosGenerales(tablaDeportiva, golesFA, golesCO, equiposUsuario, numJornadas);
				break;
			case 4:
				mostrarTablaTirosPuerta(tablaTiros, equiposUsuario, numEquipos, numJornadas);
				break;
			case 5:
				mostrarResultadoJornadasFormato(numEquipos, equiposUsuario, numJornadas, tablaResultado);
				break;
			case 6:
				mostrarListaEquipos(equiposUsuario);
				break;
			case 7:
				mostrarDatosEquipoEspecifico(tablaDeportiva, golesFA, golesCO, equiposUsuario, numJornadas,
						probabilidadVictoria, efectividadEquipo, totalResultado, numEquipos, tablaResultado,tablaTiros);
				break;
			case 8:
				sistema = false;
				System.out.println("\n¡Gracias por usar la Base de Datos LaLiga Sport!");
				break;
			default:
				System.out.println("\n[ERROR] Opción no válida. Introduce un número del 1 al 7.");
				break;
			}

			
			if (sistema && numUsuario != 8) {
				numUsuario = MetodosEntradaslib.numeroUsuario(menu);
			}

		} while (sistema);
		
		
		
	}

}


