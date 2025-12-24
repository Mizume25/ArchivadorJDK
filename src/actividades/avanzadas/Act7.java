package actividades.avanzadas;
//ARCHIVO DE PRUEBA PARA AFINAR RECICLADO DE METODOS
import arrays.MetodosArrayslib;
import datosentrada.MetodosEntradaslib;
import matrices.MetodosMatriceslib;

public class Act7 {

	public static void main(String[] args) {
		
		//METODO RECICLADO:  METODO ORDENAR FILA MATRIZ - ORDENAR ASCENDENTE / ORDEN DESCENDENTE
		
		
		/*
		String [] lista = {"Ejemplo ","Ejemplo ","Ejemplo ", "Ejmplo ","Ejmplo ","Ejmplo ","Ejmplo ","Ejemplo ","Ejemplo ","Ejemplo "};
		int [] valor = new int [10];
		int [][] tabla = new int [10][10];
		
		MetodosMatriceslib.llenarMatrizRandom(tabla, 5);
		MetodosMatriceslib.idsAutoIncrementadas(tabla);
		MetodosMatriceslib.ordenarFilasMatrizAscendente(tabla);
		
		MetodosMatriceslib.mostrarMatrizFormatoTabla(tabla, lista, 10, 10, "TablaEJ", "F");
		System.out.println();
		
		MetodosMatriceslib.sumaTotalIdsFilas(tabla, valor);
		MetodosArrayslib.mostrarArray(valor);
		
		
		//METODO RECICLADO:  METODO DE DATOS ENTRADA ESUTRUCTURA DE CONTROL DE MAXIMO Y MINIMO
		
		
		String Titulo = "Bienvenido a la estructura de prueba";
		String enunciado = "Introduce un numero entre 10 y 50:";
		String enunciadoMax = "Tu numero es mayor a 50";
		String enunciadoMin = "Tu numero es menor a 10";
		int numUsuario = 0;
		System.out.println();
		System.out.println();
		
		MetodosEntradaslib.numUsuario(Titulo, enunciado, enunciadoMax, enunciadoMin, numUsuario, 50, 10);
		
		
		System.out.println("Funciono");*/
		
		
		//METODO RECICLADO: MODIFICACION SUMAFILASMATRIZ sumara la fila desde la columna deseada
		
		/*
		int [][] tabla = new int[5][5];
		
		MetodosMatriceslib.llenarMatrizRandom(tabla, 15);
		
		MetodosMatriceslib.mostrarMatriz(tabla);
		System.out.println();
		
		
		
		
		int [] suma = new int[5];
		MetodosMatriceslib.sumaFilasMatriz(suma, tabla,6);
		
		MetodosArrayslib.mostrarArray(suma);*/
		
		
		
		//METODO RECICLADO: MODIFICACION SUMARCOLUMNAS MATRIZ SUMA TOTAL DE TODAS Y SUMA ESPECIFICA DE 1
		
		/*
		int [][] tabla = new int[5][5];
		int [] suma = new int[5];
		
		MetodosMatriceslib.llenarMatrizRandom(tabla, 25);
		
		MetodosMatriceslib.mostrarMatriz(tabla);
		
		System.out.println();
		
		MetodosMatriceslib.sumaColumnasMatriz(suma,tabla,0,5);
		MetodosArrayslib.mostrarArray(suma);
		
		int sumaCol1 = 0;
		sumaCol1 = MetodosMatriceslib.sumaColumnaMatriz(tabla, 0);
		System.out.println();
		System.out.println(sumaCol1);*/
		
		
		//METODO RECICLADO: RANDOMS DESDE FILAS Y COLUMNAS QUE DICTAMINE
		int [][] tabla = new int[5][5];
		int [] suma = new int [5];
		MetodosMatriceslib.llenarMatrizRandom(tabla, 25,0,0);
		
		MetodosMatriceslib.ordenarFilasMatrizAscendente(tabla);
		
		MetodosMatriceslib.sumaFilasMatriz(suma, tabla, 0);
		
		MetodosMatriceslib.mostrarTablaPrefijos(tabla, "Ej", "Ej", "Ejemplo");
		System.out.println();
		MetodosArrayslib.mostrarArray(suma);

	}

}
