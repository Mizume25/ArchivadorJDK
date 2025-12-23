package actividades.avanzadas;

import matrices.MetodosMatriceslib;

public class Act7 {

	public static void main(String[] args) {
		
		String [] lista = {"Ejemplo ","Ejemplo ","Ejemplo ", "Ejmplo ","Ejmplo ","Ejmplo ","Ejmplo ","Ejemplo ","Ejemplo ","Ejemplo "};
		
		int [][] tabla = new int [10][10];
		MetodosMatriceslib.llenarMatrizRandom(tabla, 40);
		MetodosMatriceslib.idsAutoIncrementadas(tabla);
		
		MetodosMatriceslib.mostrarMatrizFormatoTabla(tabla, lista, 10, 10, "TablaEJ", "F");
		
		
		

	}

}
