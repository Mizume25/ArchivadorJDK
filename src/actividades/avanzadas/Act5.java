/*Enunciado:
Dada una matriz donde:

Filas representan sucursales de la tienda (Sucursal 1, Sucursal 2, etc.)

Columnas representan categorías de productos (Electrónica, Ropa, Hogar, etc.)

Valores representan ventas mensuales en euros

Calcula:

Total de ventas por sucursal - Suma de todas las categorías por cada sucursal

Total de ventas por categoría - Suma de todas las sucursales por cada categoría

Sucursal con más ventas - Identifica qué sucursal tiene el mayor total de ventas

Categoría más vendida - Identifica qué categoría tiene el mayor total de ventas

Porcentaje de contribución - Porcentaje que cada sucursal aporta al total general

Restricciones adicionales:

Las ventas deben generarse aleatoriamente entre 1000 y 10000 euros

El usuario puede configurar cuántas sucursales (2-10) y categorías (3-8) analizar

Mostrar todos los resultados con formato monetario (€)*/

package actividades.avanzadas;

import java.util.Random;
import java.util.Scanner;

import arrays.MetodosArrayslib;
import datosentrada.MetodosEntradaslib;
import matrices.MetodosMatriceslib;

public class Act5 {

	static Scanner sc = new Scanner(System.in); // DECLARAMOS SCANNER COM VARIABLE DE CLASSE
	static Random rand = new Random(); // DECLARAMOS RANDOM COMO VARAIBLE DE CLASSE

	// 1º - Funcion que otorga ID's autoincrementadas a Sucursales
	public static void sucursalesID(int[][] empresa) {
		// DECLARAMOS VARIABLES
		int j;
		int idSucursal;

		// INICIALIZAMOS VALORES
		idSucursal = 1;
		j = 0;

		// MODIFICAMOS LA PRIMERA COLUMNA QUE REPRESENTA LAS SUCURSALES
		for (int i = 0; i < empresa.length; i++) {
			empresa[i][j] = idSucursal;
			idSucursal++;
		}
	}

	// 2º Funcion automatica de llenado de ganancia mensual de cada sucursal
	public static void beneficioMensual(int[][] empresa) {
		// RECORREMOS EL ARRAY CON EL AUTO INCREMENTADO IMPLEMENTADO
		// Columna comienza con 1 para no modificar la columna 0,0 1,0 2,0 3,0 etc...
		for (int fila = 0; fila < empresa.length; fila++) {

			for (int columna = 1; columna < empresa[fila].length; columna++) {

				empresa[fila][columna] = rand.nextInt(9001) + 1000;
			}
		}
	}

	// 3º Funcion que calcula el total de beneficio de cada sucursal
	public static void beneficioTotalSucursal(int[][] empresa, int[] totalBeneficioSucursal) {
		// DECLARAMOS VARIABLES
		int sumaBeneficio;
		int i;

		// INICIALIZAMOS VARIABLES
		i = 0;

		for (int fila = 0; fila < empresa.length; fila++) {
			// Reiniciamos acumulador
			sumaBeneficio = 0;

			for (int columna = 1; columna < empresa[fila].length; columna++) {
				sumaBeneficio += empresa[fila][columna]; // Acumulamos notas
			}

			totalBeneficioSucursal[i] = sumaBeneficio;
			i++;

		}

	}

	// 4º Funcion que calculca el beneficio total por categoria
	public static void beneficioTotalCategoria(int[][] empresa, int[] totalBeneficioCategoria) {
		// DECLARAMOS VARIABLES
		int columna;
		int sumaBeneficio;
		int i;

		// INICIALIZAMOS VARIABLES
		columna = 1;
		i = 0;

		while (columna < empresa[0].length) {
			// REINICIAMOS ACUMULADOR

			sumaBeneficio = 0;

			for (int fila = 0; fila < empresa.length; fila++) {
				sumaBeneficio += empresa[fila][columna]; // ACUMULAMOS
			}

			totalBeneficioCategoria[i] = sumaBeneficio; // GUARDAMOS VALORES
			i++;
			columna++;

		}
	}

	// 5º - Funcion que calcula el valor total de la Empresa
	public static int sumaTotalBeneficioEmpresa(int[] totalBeneficioSucursal) {

		int sumaTotal;
		sumaTotal = 0;

		for (int i = 0; i < totalBeneficioSucursal.length; i++) {

			sumaTotal += totalBeneficioSucursal[i];
		}

		return sumaTotal;
	}

	// 6º - Funcion que calcula el porcentaje  con respecto al total de cada empresa
	public static void porcentajeContribucion(int[] totalBeneficioSucursal, int totalEmpresa, double[] porcentajes) {

		double potencia = Math.pow(10, 3);
		double valorRedondeado;
		double porcentaje;
		valorRedondeado = 0.0;
		porcentaje = 0.0;

		for (int i = 0; i < totalBeneficioSucursal.length; i++) {
			porcentaje = ((double) totalBeneficioSucursal[i] / totalEmpresa) * 100;
			valorRedondeado = Math.round(porcentaje * potencia) / potencia;
			porcentajes[i] = valorRedondeado;
		}
	}

	// 7º Mostrar total sucursales con formato especifico
	public static void mostrarTotalesSucursales(int[] totalBeneficioSucursal) {
		// Recorrer el array
		for (int i = 0; i < totalBeneficioSucursal.length; i++) {
			System.out.printf("Sucursal %d: %d€%n", (i + 1) , totalBeneficioSucursal[i]);
		}
		System.out.println();
	}

	// 8º Mostrar total categorias con formato especifico
	public static void mostrarTotalesCategorias(int[] totalBeneficioCategoria, String[] categorias) {

		// Recorrer el array
		for (int i = 0; i < totalBeneficioCategoria.length; i++) {
			System.out.printf("Categoria %s: %d€%n", categorias[i] , totalBeneficioCategoria[i]);
		}

	}

	// 9º Mostrar total sucursales con formato especifico
	public static void mostrarPorcentajesSucursales(double [] porcentajes) {
		// Recorrer el array
		for (int i = 0; i < porcentajes.length; i++) {
			System.out.printf("Sucursal %d: %.2f%%%n", (i + 1) , porcentajes[i]);
		}
	}
	
	//10º Representacion estadistica de los datos recopilados
	public static void mostrarEstadisticas(double [] porcentajes) {
		//Funcion netamente experimental
		//REPRESENTACION ESTADISTICA DE LOS PORCENTAJES
		//REPRESENTAREMOS CON "*" LA REPRESENTACION A % DEL VALOR DE CADA EMPRESA RESPECTO AL TOTAL
		int totalEmpresa = 100; //El total de una empresa siempre son 100%
		
		System.out.print("Total [100%]: ");
		for (int k = 0; k < totalEmpresa; k++) {
            System.out.print("*");
        }
		
		System.out.println();
		
		
		// Ejecutamos un for que recorra todo el array
        for (int i = 0; i < porcentajes.length; i++) {
        	//Ejecutamos un formato
            System.out.printf("S%d [%.2f%%] ",i,porcentajes[i]);

            // Ejecutamos un segundo for que imprima la cantidad de "*" que hay en el el
            // valor del array
            for (int j = 0; j < porcentajes[i]; j++) {
                System.out.print("*");
            }

            System.out.println(); // salto de linea por linea ejecutada
        }
	}

	public static void main(String[] args) {

		// Declaramos variables necesarias
		int filas;
		int columnas;

		// Las inicializamos
		filas = 2;
		columnas = 3;

		// Bautizamos a la empresa
		String nombreEmpresa = MetodosEntradaslib.tituloUsuario("Introduce el nombre de la empresa: ");
		// Trazamos limites al usuario
		do {

			// Estructura de control de prints y menus para el usuario
			if (filas < 2 && columnas > 3) {
				System.out.println();
				System.out.println("Numero Insuficiente de Sucursales");
				System.out.println();
			}

			if (columnas < 3 && filas > 2) {
				System.out.println();
				System.out.println("Numero Insuficiente de Categorias");
				System.out.println();
			}

			if (columnas < 3 && filas < 2) {
				System.out.println();
				System.out.println("Numero Insuficiente de Sucursales y Categorias");
				System.out.println();
			}
			System.out.println("==" + nombreEmpresa.toUpperCase() + "==");
			System.out.println();
			filas = MetodosEntradaslib.numeroUsuario("Nº de Sucursales - [Nº Max: 10 | [Nº Min: 2]: ");
			columnas = MetodosEntradaslib.numeroUsuario("Nº de Categorias - [Nº Max: 8] | [Nº Min: 3]: ");

		} while ((filas < 2 || filas > 10) || (columnas < 3 || columnas > 8));

		// INICIALIZAMOS UNA MATRIZ CON LA MEDIDAS DEL USUARIO
		int[][] empresa = new int[filas][columnas];

		// INICIALIZAMOS UN ARRAY CON 8 CATEGORIAS QUE ES EL NUMERO MAXIMO QUE EL
		// USUARIO PUEDE PONER
		String[] categorias = { "Hogar", "Electronica", "Alimentacion", "Fitnes", "Bienes_Raices", "Entretenimiento",
				"Moda", "Automotriz" };

		// Hacemos una lista autoncrementadas de id's de sucursales
		sucursalesID(empresa);

		// Llenamos de valores de beneficios de cada categoria x sucursal
		beneficioMensual(empresa);

		// El array sea tan grande como fila de sucursales haya
		int[] totalBeneficioSucursal = new int[filas];
		int[] totalBeneficioCategoria = new int[columnas - 1];

		// CALCULAMOS TOTALES POR SUCURSAL Y CATEGORIA
		beneficioTotalSucursal(empresa, totalBeneficioSucursal);
		beneficioTotalCategoria(empresa, totalBeneficioCategoria);

		// Calculamos las posiciones mas altas de cada array de valores totales
		int indexSucursal = MetodosArrayslib.maxValorArray(totalBeneficioSucursal);

		int indexCategoria = MetodosArrayslib.maxValorArray(totalBeneficioCategoria);

		// Calculamos el total de la empresa sumando el beneficio de las sucursales
		int totalEmpresa = sumaTotalBeneficioEmpresa(totalBeneficioSucursal);

		double[] porcentajes = new double[filas];

		// Calculamos porcentaje respecto al total
		porcentajeContribucion(totalBeneficioSucursal, totalEmpresa, porcentajes);
		
		// Imprimimos resultado
		System.out.println("==Resultados==");
		System.out.println("Datos recopilados de " + nombreEmpresa.toUpperCase());
		System.out.println("=== VENTAS MENSUALES (€) ===");
		
		MetodosMatriceslib.mostrarMatriz(empresa);
		System.out.println();

		System.out.println("Numero total de Sucursales: " + filas);
		System.out.println("Numero total de Categorias: " + (columnas - 1));
		System.out.println();

		mostrarTotalesSucursales(totalBeneficioSucursal);
		mostrarTotalesCategorias(totalBeneficioCategoria, categorias);
		System.out.println();

		System.out.println("Sucursal con benefico maximo es la sucursal " + (indexSucursal + 1) + " con la cuantia de: "
				+ totalBeneficioSucursal[indexSucursal] + "€");
		System.out.println("Categoria con benefico maximo es " + categorias[indexCategoria] + " con la cuantia de: "
				+ totalBeneficioCategoria[indexCategoria] + "€");
		System.out.println();
		
		mostrarPorcentajesSucursales(porcentajes);
		System.out.println();
		mostrarEstadisticas(porcentajes);

	}

}
