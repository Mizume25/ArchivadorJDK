package actividades.principiante;

import java.util.Scanner;

/*Implementa un validador de contraseñas. 
 * Ésta se debe leer por teclado y debemos comprobar que cumple determinadas características:
	Tiene entre 8 y 20 caracteres.

	Tiene alguna letra mayúscula y alguna letra minúscula.

	Tiene algún carácter raro entre $%_*

	Tiene algún número

*/
public class Act8 {
	static Scanner sc = new Scanner(System.in);	//DECLARAMOS VARIABLES
	
	//1º Funcion que lee una contraña
	public static String escribirPassword() {
		System.out.print("Escribe una contraseña que cumpla los siguientes requisitos:"
				+ "\n1. Tiene entre 8 o 20 caracteres"
				+ "\n2. Tiene alguna letra mayuscula y minuscula"
				+ "\n3. Tiene algun caracter raro $%_*"
				+ "\n4. Tiene algun numero"
				+ "\nIntroduce tu contraseña:");
		return sc.nextLine();
	}
	
	// 2º FUNCION QUE COMPRUEBA NUMERO DE CARACTERES
	public static boolean numCaracteres (String password) {
		//DECLARAMOS VARIABLES
		int longitud;
		
		//INICIALIZAMOS VARIABLES
		longitud = password.length();
		
		//ESTURCTURA QUE COMPRUEBA TAMAÑO
		if (longitud >= 8 && longitud <= 20) {
			return true;
			
		} else {
			
			return false;
		}
		
	}
	
	//3º FUNCION QUE COMPRUEBA SI HAY UNA MAYUSCULA
	public static boolean buscarMayuscula (String password) {
		//DECLARAMOS VARIABLE
		boolean encontrado;
		int longitud;
		int i;
		
		//INICIALIZAMOS
		longitud = password.length();
		encontrado = false;
		i = 0;
		//RECORREMOS TODA LA CADENA
		do {
			
			encontrado = Character.isUpperCase(password.charAt(i));
			
			i++;
		}while(!encontrado && i < longitud - 1);
		
		return encontrado;
		
	}
	
	//4º FUNCION QUE COMPRUEBA SI HAY UNA MINUSCULA
	public static boolean buscarMinuscula(String password) {
		// DECLARAMOS VARIABLE
		boolean encontrado;
		int longitud;
		int i;

		// INICIALIZAMOS
		longitud = password.length();
		encontrado = false;
		i = 0;
		// RECORREMOS TODA LA CADENA
		do {

			encontrado = Character.isLowerCase(password.charAt(i));

			i++;
		} while (!encontrado && i < longitud - 1);

		return encontrado;

	}
	
	//5º FUNCION QUE ANALIZA SI HAY O NO AL MENOS 1 CARACTER RARO
	public static boolean buscarCaracterEspecial(String password) {
		// DECLARAMOS VARIABLE
		boolean encontrado;
		int longitud;
		int i;

		// INICIALIZAMOS
		longitud = password.length();
		encontrado = false;
		i = 0;
		// RECORREMOS TODA LA CADENA
		do {

			if (password.charAt(i) == '%' || password.charAt(i) == '$' ||
				password.charAt(i) == '_' || password.charAt(i) == '*') {
				
				encontrado = true;
			}

			i++;
		} while (!encontrado && i < longitud - 1);

		return encontrado;

	}
	
	//6º FUNCION QUE COMPRUEBA SI HAY DIGITOS
		public static boolean buscarDigito(String password) {
			// DECLARAMOS VARIABLE
			boolean encontrado;
			int longitud;
			int i;

			// INICIALIZAMOS
			longitud = password.length();
			encontrado = false;
			i = 0;
			// RECORREMOS TODA LA CADENA
			do {

				encontrado = Character.isDigit(password.charAt(i));

				i++;
			} while (!encontrado && i < longitud - 1);

			return encontrado;

		}
	
	
	public static void main(String[] args) {
		
		//DECLARAMOS VARIABLES
		String password;
		boolean numeroCaracteres;
		boolean mayuscula;
		boolean minuscula;
		boolean caracteRaro;
		boolean numeros;
		
		//INICIALIZAMOS VARIABLES
		password = escribirPassword();
		numeroCaracteres = false;
		mayuscula = false;
		minuscula = false;
		caracteRaro = false;
		numeros = false;
		
		//COMPROBAMOS TAMAÑO
		//COMPROBAMOS TAMAÑO
		numeroCaracteres = numCaracteres(password);
		if (!numeroCaracteres) System.out.println("\nTu contraseña no tiene entre 8 o 20 caracteres");

		//SEPARAMOS LAS COMROBACIONES POR BLOQUES IF'S
		if (numeroCaracteres) {
		    
		    //COMPROBAMOS MAYUS Y MINUS
		    mayuscula = buscarMayuscula(password);
		    minuscula = buscarMinuscula(password);
		    if (!mayuscula && minuscula) {
		        System.out.println("\n Falta una letra Mayuscula");
		    } else if (mayuscula && !minuscula) {
		        System.out.println("\n Falta una letra Minuscula");
		    } else if (mayuscula && minuscula) {
		        
		        //COMPROBAMOS CARACTER ESPECIAL
		        caracteRaro = buscarCaracterEspecial(password);
		        if (!caracteRaro) System.out.println("\nTu contraseña debe tener al menos 1 caracter raro $%_*");
		        
		        if (caracteRaro) {
		            
		            //COMPROBAMOS SI HAY NUMEROS
		            numeros = buscarDigito(password);
		            if (!numeros) System.out.println("\nTu contraseña debe contener numeros");
		            
		            if (numeros) {
		                System.out.println("\nTu contraseña cumple los requisitos requeridos!");
		            }
		        }
		    }
		}
	}

}
