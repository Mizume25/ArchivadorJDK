package actividades.avanzadas;

import arrays.MetodosArrayslib;
import matrices.MetodosMatriceslib;

public class Act7 {

	public static void main(String[] args) {
		
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
		
		

		
		
		
		
		

	}

}
