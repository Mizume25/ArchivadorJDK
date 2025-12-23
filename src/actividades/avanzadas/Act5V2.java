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

public class Act5V2 {

	static Scanner sc = new Scanner(System.in); // DECLARAMOS SCANNER COM VARIABLE DE CLASSE
	static Random rand = new Random(); // DECLARAMOS RANDOM COMO VARAIBLE DE CLASSE

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
		MetodosMatriceslib.idsAutoIncrementadas(empresa);

		// Llenamos de valores de beneficios de cada categoria x sucursal
		MetodosMatriceslib.llenarValorIdsRandom(empresa);

		// El array sea tan grande como fila de sucursales haya
		int[] totalBeneficioSucursal = new int[filas];
		int[] totalBeneficioCategoria = new int[columnas - 1];

		// CALCULAMOS TOTALES POR SUCURSAL Y CATEGORIA
		MetodosMatriceslib.sumaTotalIdsFilas(empresa, totalBeneficioSucursal);
		MetodosMatriceslib.sumaTotalIdsColumnas(empresa, totalBeneficioCategoria);

		// Calculamos las posiciones mas altas de cada array de valores totales
		int indexSucursal = MetodosArrayslib.maxValorArray(totalBeneficioSucursal);
		int indexCategoria = MetodosArrayslib.maxValorArray(totalBeneficioCategoria);

		// Calculamos el total de la empresa sumando el beneficio de las sucursales
		int totalEmpresa = MetodosArrayslib.sumaValorTotalArray(totalBeneficioCategoria);

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

		MetodosArrayslib.mostrarArrayFormato(totalBeneficioSucursal, "S");
		System.out.println();
		MetodosArrayslib.mostrarArrayFormato(totalBeneficioCategoria, categorias, "C.");
		System.out.println();

		System.out.println("Sucursal con benefico maximo es la sucursal " + (indexSucursal + 1) + " con la cuantia de: "
				+ totalBeneficioSucursal[indexSucursal] + "€");
		System.out.println("Categoria con benefico maximo es " + categorias[indexCategoria] + " con la cuantia de: "
				+ totalBeneficioCategoria[indexCategoria] + "€");
		System.out.println();
		
		System.out.print("Total Empresa [100%] ");
		for (int i = 0; i < 100; i++) {
			System.out.print("*");
		}
		System.out.printf("  %d€%n",totalEmpresa);
		MetodosArrayslib.mostrarEstadisticaArray(porcentajes, "S");
		
	}

}