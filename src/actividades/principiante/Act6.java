package actividades.principiante;

import java.util.Scanner;

public class Act6 {
	static Scanner sc = new Scanner(System.in); 	//DECLARAMOS SCANNER
	
	// 1º FUNCION QUE LE UN ACADENA DE CARACTERES
	public static String cadenaCaracteres () {
		System.out.println("Introduce una cadena de caracteres: ");
		return sc.next();
	}
	
	//2º FUNCION QUE INVIERTE CADENA
	public static String invertirCadenaCaracteres(String cadena){
		
		
		//DECLARAMOS VARIABLES
		String cadenaInvertida;
		int longitudmsg;
		char caracter;
		
		//INICIALIZAMOS VARIABLES
		cadenaInvertida = "";
		longitudmsg = cadena.length(); //CALCULAMOS EL ESPACIO DE UNA CLASSE STRING 
		caracter = 'A';
		//DECLARAMOS ESTRUCTURA FOR QUE IMPRIMA UN INDEX INVERSO  CON CHAR AT 
		for (int i = longitudmsg - 1; i >= 0; i--) {
			
		    caracter = cadena.charAt(i);
		    
		    cadenaInvertida = cadenaInvertida + caracter;
		}
		
		return cadenaInvertida;
	}
	public static void main(String[] args) {
		
		//DECLARAMOS VARIABLES
		String cadena;
		String cadenaInversa;
		
		//INICIALIZAMOS VAIRABLES
		cadena = cadenaCaracteres();
		cadenaInversa = invertirCadenaCaracteres(cadena);
		
		//Mostramos Resultado:
		System.out.println(cadena);
		System.out.println();
		System.out.println(cadenaInversa);
		
		
	}

}
