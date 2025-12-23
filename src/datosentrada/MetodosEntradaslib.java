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
}
