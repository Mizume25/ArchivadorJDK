package actividades.intermedio;
//ARCHIVO DE PRUEBA DE METODOS PARA IMPLEMENTAR EN LIBRERIAS
import arrays.MetodosArrayslib;
import datosentrada.MetodosEntradaslib;
import matrices.MetodosMatriceslib;
//VALOR MAXIMO DE UN ARRAY
public class Act3 {

	public static void main(String[] args) {
		
		// DECLARAMOS VARIABLES
        double valorMax;
        int posicion;
        int [] array = new int [5];
        int filas;
        int columnas;
        int suma;
        int sumaMatriz;
        var x = "Hola";
        suma = 0;
        MetodosArrayslib.llenarArrayRandom(array, 5);
        
        // INICIALIZAMOS INDEX
        valorMax = array[0]; // Punto de partida
        posicion = 0;

        // RECORREMOS EL ARRAY EN BUSCA DEL PROMEDIO MAYOR
        for (int i = 1; i < array.length; i++) {

            if (valorMax < array[i]) {
                // ACTUALIZAMOS VALOR Y POSICION
                valorMax = array[i];
                posicion = i;
            }
        }
        
        //MOSTRAMOS RESULTADO
        MetodosArrayslib.mostrarArray(array);
        System.out.println();
        System.out.println("El valor max es: " + array[posicion]);
        suma = MetodosArrayslib.sumaValorTotalArray(array);
        System.out.println("\nSuma total es: " + suma);
        
        filas = MetodosEntradaslib.numeroUsuario("Filas: ");
        columnas = MetodosEntradaslib.numeroUsuario("Columnas: ");
        int [][] tabla = new int[filas][columnas];
        
        MetodosMatriceslib.llenarMatrizRandom(tabla, 2, 0, 0);
        
        sumaMatriz = MetodosMatriceslib.sumaTotalMatriz(tabla);
        
        MetodosMatriceslib.mostrarTablaPrefijos(tabla, "Fil", "Col", "Tabla Ejemplo");
        System.out.println();
        System.out.println(sumaMatriz);
        
        
	}

}
