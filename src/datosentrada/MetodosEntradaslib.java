package datosentrada;

import java.util.Random;
import java.util.Scanner;

public class MetodosEntradaslib {
	// PUBLIC SCANNER
    static Scanner sc = new Scanner(System.in);
    static Random rand = new Random();

    // ============================================
    // SECCIÓN 1: METODO DE DATOS DE ENTRADA
    // ============================================

    // MÉTODO: Devuelve un valor que el usuario decide sobre cualqueir estructura de control
    // PARÁMETROS: 1 String.
    public static int numeroUsuario(String texto) {
        System.out.println(texto);
        return sc.nextInt();
    }
    
    // MÉTODO: Devuelve un titulo que el usuario decide sobre cualqueir estructura de control
    // PARÁMETROS: 1 String.
    public static String tituloUsuario(String texto) {
        System.out.println(texto);
        return sc.next();
    }
    
    // ============================================
    // SECCIÓN 2: METODO DE DATOS DE ENTRADA CON ESTRUCTURA DE MAXIMO Y MINIMO
    // ============================================
    
    public static int numUsuario (String titulo,String enunciado, String EnunciadoMaximo,String EnunciadoMinimo,int numMaximo, int numMinimo) {
		
    		int numUsuario = numMinimo;
    	
		do {
			
			//PEDIMOS NUM USUARIO
			

			//ESUTRUCTURA DE CONTROL DE MINIMO
			if (numUsuario < numMinimo) {
				System.out.println(EnunciadoMinimo);
				System.out.println();
			
			//ESTRUCTURA DE CONTROL DE MAXIMOS
			} else if (numUsuario > numMaximo) {
				System.out.println(EnunciadoMaximo);
				System.out.println();
			}
			
			
			System.out.println(titulo);
			System.out.println(enunciado);
			numUsuario = sc.nextInt();

		} while (numUsuario < numMinimo || numUsuario > numMaximo);
		
		return numUsuario;
		
	}
    
}
