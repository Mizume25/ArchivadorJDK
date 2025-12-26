package actividades.avanzadas;

import java.util.Scanner;

import datosentrada.MetodosEntradaslib;

//Verificacion de correo electronico y contraseña
public class Act8 {
	
	//DECLARAMOS UN SCANNER COMO VARIABLE DE CLASSE
	static Scanner sc = new Scanner(System.in);
	
	//1º FUNCION QUE ESCRIBE UN CORREO ELETRONICO COMPLETO
	public static String escribirCorreo () {
		System.out.print("Escribe tu correo eletronico que cumpla estos equisitos:"
				+ "\n 1. Debe tener entre 10 - 40 caracteres (sin contar la extension @gmail.com)"
				+ "\n 2. Solo se admitiran los dominios @hotmail y @gmail"
				+ "\n 3, Si escribes un dominio @hotmail puedes escojer entre .com o .es "
				+ "\n 4. Tu correo debe al menos contenre 1 mayuscula y un 1 numero"
				+ "\n 5. No debe contener espacios vacios"
				+ "\n Introduce tu correo:");
		return sc.nextLine();
		
	}
	
	//2º FUNCION QUE ESCRIBE UNA CONTRASEÑA COMPLETO
		public static String escribirContra (String correo) {
			System.out.println(correo);
			System.out.println("\nEscribe una contraseña que cumpla estos equisitos"
					+ "\n 1. Debe medir entre 8 a 20 caracteres"
					+ "\n 2. Debe contener al menos 1 Mayuscula y Minuscula"
					+ "\n 3. Debe contener al menos un caracter raro: * _ @ %"
					+ "\n 4. Debe contener 1 numero"
					+ "\nIntroduce tu contraseña: ");
			return sc.nextLine();
			
	}
	//3º FUNCION QUE COMPRUEBA EL TAMAÑO DEL CORREO
	public static boolean medidaCorreo (String correo) {	
		//DECLARAMOS VARIABLES
		int longitud;
		int i;
		char [] caracteres;
		int contador;
		
		//INICIALIAMOS VARIABLES
		longitud = correo.length();				//MEDIRA TANTO MIDA EL CORREO
		i = 0;							
		contador = 0;							
		caracteres = new char[longitud];
		
		//LLENAMOS EL ARRAY DE CADENA DE CARACTERES DEL CORREO
		for (int j = 0; j < longitud; j++) {
			caracteres[j] = correo.charAt(j);
		}
		
		//DICTAMINAMOS TAMAÑOS
		while (caracteres[i] != '@') {
			
			//SI EL CARACTER ACTUAL NO ES "@" NO TERMINA EL BUCLE
			contador++;											//INCREMENTAMOS CARACTER NO "@"
			i++; 												//INCREMENTAMOS I HASTA QUE ENCUENTRA LA POSICION DE @
			
		}
		
		
		if (contador >= 10 && contador <= 40) {
			return true;
		} else {
			return false;
		}
		
	}
	
	// 4º FUNCION QEU COMRPEUBA LOS DOMINIOS
	public static boolean dominioCorreo(String correo) {
		// 1º DEBEMOS DICTAMINAR QUE DOMINIO USA Y QUE EXTENSION QUE USA EN CASO DE SER
		// HOTMAIL

		// DECLARAMOS VARIABLES
		int longitud;
		int i;
		char[] caracteres;
		char [] dominio;
		int contador;
		int contExtension;
		int posicionArroba;
		char [] nombreDominioGmail = {'@','g','m','a','i','l'};
		char [] nombreDominioHotMail = {'@','h','o','t','m','a','i','l'};
		int medidaDominio;
		boolean verificacion;
		
		// INICIALIAMOS VARIABLES
		longitud = correo.length(); // MEDIRA TANTO MIDA EL CORREO
		i = longitud - 1;
		contador = 1;
		caracteres = new char[longitud];
		
		// LLENAMOS EL ARRAY DE CADENA DE CARACTERES DEL CORREO
		for (int j = 0; j < longitud; j++) {
			caracteres[j] = correo.charAt(j);
		}

		// DICTAMINAMOS TAMAÑOS DE DOMINIO + EXTENSION
		while (caracteres[i] != '@') {

			// SI EL CARACTER ACTUAL NO ES "@" NO TERMINA EL BUCLE
			contador++;		 // INCREMENTAMOS CARACTER NO "@"
			i--; 			// DECREMENTAMOS I HASTA QUE ENCUENTRA LA POSICION DE @

		}
		
		
		i = longitud - 1;  //REINICIAMOS INDICE
		
		
		//QUITAMOS LA EXRENSION
		// CARACTERES DE EXTENSION
		contExtension = 1;
		while (caracteres[i] != '.') {

			// SI EL CARACTER ACTUAL NO ES "@" NO TERMINA EL BUCLE
			contExtension++; // INCREMENTAMOS CARACTER NO "@"
			i--; // DECREMENTAMOS I HASTA QUE ENCUENTRA LA POSICION DE @

		}
		
		posicionArroba = longitud - contador;		//CORREO - (DOMINIO Y EXTENSION)
		
		medidaDominio = contador - contExtension;	// DOMINIO - EXTENSION = ESPACIODOMINIO
		
		dominio = new char [medidaDominio];
		
		
		//LLENAMOS LOS CARACTERES DEL DOMINIO Y LOS GUARDAMOS
		for (int j = 0; j < dominio.length; j++) {
			dominio[j] = caracteres[posicionArroba];
			posicionArroba++;
		}
		
		
		verificacion = true;
		
		if (dominio[1] == 'g') {
			//DECLARAMOS VARIABLES
			
			int j;
			
			j = 0;
			
			
			do {
				
				if (dominio[j] != nombreDominioGmail[j]) {
					verificacion = false;
				} else {				
					j++;		
				}
				
			} while (verificacion && j < dominio.length);
			
			
			
		} else if (dominio[1] == 'h') {
			//DECLARAMOS VARIABLES
			
			int j;
			
			j = 0;
			
			
			do {
				
				if (dominio[j] != nombreDominioHotMail[j]) {
					verificacion = false;
				} else {				
					j++;		
				}
				
			} while (verificacion && j < dominio.length);
			
			

		}
		
		/*MEDIDA DE DOMINIOS
		 * 1. Si es gmail solo puede medir 10 caracteres
		 * 2. Si es hotmail solo puede medir 12 o 11*/
		
		return verificacion;

	}
	
	
	// 4º FUNCION QEU COMRPEUBA LOS EXTENSIONES
	public static boolean extensionCorreo(String correo) {
		// 1º DEBEMOS DICTAMINAR QUE DOMINIO USA Y QUE EXTENSION QUE USA EN CASO DE SER
		// HOTMAIL

		// DECLARAMOS VARIABLES
		int longitud;
		int i;
		char[] caracteres;
		char [] extension;
		int contExtension;
		int posicionPunto;
		char [] tipoExtensionC = {'.','c','o','m'};
		char [] tipoExtensionS = {'.','e','s'};
		boolean verificacion;
		
		// INICIALIAMOS VARIABLES
		longitud = correo.length(); // MEDIRA TANTO MIDA EL CORREO
		i = longitud - 1;
		caracteres = new char[longitud];
		
		// LLENAMOS EL ARRAY DE CADENA DE CARACTERES DEL CORREO
		for (int j = 0; j < longitud; j++) {
			caracteres[j] = correo.charAt(j);
		}
		
		
		// CARACTERES DE EXTENSION
		contExtension = 1;
		while (caracteres[i] != '.') {

			// SI EL CARACTER ACTUAL NO ES "@" NO TERMINA EL BUCLE
			contExtension++; // INCREMENTAMOS CARACTER NO "@"
			i--; // DECREMENTAMOS I HASTA QUE ENCUENTRA LA POSICION DE @

		}
		
		
		posicionPunto = longitud - contExtension;		//CORREO - (DOMINIO Y EXTENSION)
		
		extension = new char [contExtension];
		
		
		//LLENAMOS LOS CARACTERES DEL DOMINIO Y LOS GUARDAMOS
		for (int j = 0; j < extension.length; j++) {
			extension[j] = caracteres[posicionPunto];
			posicionPunto++;
		}
		
		
		verificacion = true;
		
		if (extension[1] == 'c') {
			//DECLARAMOS VARIABLES
			
			int j;
			
			j = 0;
			
			
			do {
				
				if (extension[j] != tipoExtensionC[j]) {
					verificacion = false;
				} else {				
					j++;		
				}
				
			} while (verificacion && j < extension.length);
			
			
			
		} else if (extension[1] == 'e') {
			//DECLARAMOS VARIABLES
			
			int j;
			
			j = 0;
			
			
			do {
				
				if (extension[j] != tipoExtensionS[j]) {
					verificacion = false;
				} else {				
					j++;		
				}
				
			} while (verificacion && j < extension.length);
			
			

		}
		
		
		
		return verificacion;

	}
	
	// 5º FUNCION QUE COMRPEUBA MINUSUCULAS
	public static boolean buscarMinusculaCorreo(String correo) {
		// DECLARAMOS VARIABLE
		boolean encontrado;
		int longitud;
		int i;
		int contador;
		char [] caracteres;

		// INICIALIZAMOS
		//INICIALIAMOS VARIABLES
		longitud = correo.length(); // MEDIRA TANTO MIDA EL CORREO
		i = 0;
		contador = 0;
		caracteres = new char[longitud];
		encontrado = false;

		// LLENAMOS EL ARRAY DE CADENA DE CARACTERES DEL CORREO
		for (int j = 0; j < longitud; j++) {
			caracteres[j] = correo.charAt(j);
		}

		// DICTAMINAMOS TAMAÑOS
		while (caracteres[i] != '@') {

			// SI EL CARACTER ACTUAL NO ES "@" NO TERMINA EL BUCLE
			contador++; // INCREMENTAMOS CARACTER NO "@"
			i++; // INCREMENTAMOS I HASTA QUE ENCUENTRA LA POSICION DE @

		}
		// RECORREMOS TODA LA CADENA
		
		i = 0; //REINICIAMOS I
		do {

			encontrado = Character.isLowerCase(caracteres[i]);

			i++;
		} while (!encontrado && i < contador);

		return encontrado;
	}
	
	// 6º FUNCION QUE COMRPEUBA MAYUSCULAS
	public static boolean buscarMayusculaCorreo(String correo) {
		// DECLARAMOS VARIABLE
		boolean encontrado;
		int longitud;
		int i;
		int contador;
		char[] caracteres;

		// INICIALIZAMOS
		// INICIALIAMOS VARIABLES
		longitud = correo.length(); // MEDIRA TANTO MIDA EL CORREO
		i = 0;
		contador = 0;
		caracteres = new char[longitud];
		encontrado = false;

		// LLENAMOS EL ARRAY DE CADENA DE CARACTERES DEL CORREO
		for (int j = 0; j < longitud; j++) {
			caracteres[j] = correo.charAt(j);
		}

		// DICTAMINAMOS TAMAÑOS
		while (caracteres[i] != '@') {

			// SI EL CARACTER ACTUAL NO ES "@" NO TERMINA EL BUCLE
			contador++; // INCREMENTAMOS CARACTER NO "@"
			i++; // INCREMENTAMOS I HASTA QUE ENCUENTRA LA POSICION DE @

		}
		// RECORREMOS TODA LA CADENA

		i = 0; // REINICIAMOS I
		do {

			encontrado = Character.isUpperCase(caracteres[i]);

			i++;
		} while (!encontrado && i < contador);

		return encontrado;
	}
	
	// 7º FUNCION QUE COMRPEUBA SI HAY DIGITOS
	public static boolean buscarDigitoCorreo(String correo) {
		// DECLARAMOS VARIABLE
		boolean encontrado;
		int longitud;
		int i;
		int contador;
		char[] caracteres;

		// INICIALIZAMOS
		// INICIALIAMOS VARIABLES
		longitud = correo.length(); // MEDIRA TANTO MIDA EL CORREO
		i = 0;
		contador = 0;
		caracteres = new char[longitud];
		encontrado = false;

		// LLENAMOS EL ARRAY DE CADENA DE CARACTERES DEL CORREO
		for (int j = 0; j < longitud; j++) {
			caracteres[j] = correo.charAt(j);
		}

		// DICTAMINAMOS TAMAÑOS
		while (caracteres[i] != '@') {

			// SI EL CARACTER ACTUAL NO ES "@" NO TERMINA EL BUCLE
			contador++; // INCREMENTAMOS CARACTER NO "@"
			i++; // INCREMENTAMOS I HASTA QUE ENCUENTRA LA POSICION DE @

		}
		// RECORREMOS TODA LA CADENA

		i = 0; // REINICIAMOS I
		do {

			encontrado = Character.isDigit(caracteres[i]);

			i++;
		} while (!encontrado && i < contador);

		return encontrado;
	}
	
	public static boolean validarCorreo (boolean medidaCorreo,boolean dominio,boolean extension, boolean mayusculas, boolean minusculas, boolean digitos) {
		
		if (medidaCorreo) {
			
			if (dominio) {
				
				if (extension) {
					
					if (mayusculas) {
						
						if (minusculas) {
							
							if (digitos) {
										return true;
								} else {
									System.out.println("\nTu correo debe contener digitos");
								}
						} else {
							System.out.println("\nTu correo debe contener minusculas");
						}
						
					} else {
						System.out.println("\nTu correo debe contener mayusculas");
					}
					
				} else {
					
					System.out.println("\nTu correo solo puede contener @gmail o @hotmail");
				}
				
			} else {
				
				System.out.println("\nTu correo solo puede contener @gmial o @hotmail");
			}
			
		} else {
			System.out.println("\nTu correo debe medir entre 10 a 40 caracteres sin contar @dominio.extension");
		}
		
		return false;
	}
	
	public static void main(String[] args) {
        //DECLARAMOS VARIABLES
		int fil;
		String [][] tabla;
		String correo;
		String contra;
		
		//VARIABLES DE COMPROBACION
		//CORREO
		boolean espaciosVaciosCorreo;
		boolean medidaCorreo;
		boolean dominio;
		boolean extension;
		boolean mayusculas;
		boolean minusculas;
		boolean digitos;
		boolean correoValido;
		
		
		
		//INICIALIZAMOS VARIRABLES
			//LLAMAMOS AL METODO DE ESTRUCTURA DE CONTROL PARA QUE ME DE ENTRE UN NUMERO DE 2 A 5
		fil = MetodosEntradaslib.numUsuario("==Gestor de correos==", "\nIntroduce cantidad de correos que te gustari introducir:",
		"\nMaximo puedes introducir 5", "\nMinimo necesitas introducir 2 correos", 5, 2);
		
		tabla = new String [fil][1];			//INDEPENDIENTEMENTE DE SI HAY 5 O 2 CORREO SIEMPRE HBARA 1 COLUMNA
		mayusculas = false;
		minusculas = false;
		digitos = false;
		correoValido = false;
		do {
			
			correo = escribirCorreo();
			espaciosVaciosCorreo = correo.contains(" ");
			if (!espaciosVaciosCorreo) {
				
				medidaCorreo = medidaCorreo(correo);
				dominio = dominioCorreo(correo);
				extension = extensionCorreo(correo);
				mayusculas = buscarMayusculaCorreo(correo);
				minusculas = buscarMinusculaCorreo(correo);
				digitos = buscarDigitoCorreo(correo);
				
				
				
				correoValido = validarCorreo(medidaCorreo, dominio, extension, mayusculas, minusculas, digitos);
			
			} else {
				
				System.out.println("Tu correo no puede contener espacios en blanco");
			}
		
		
		} while (!correoValido);
		
		contra = escribirContra(correo);
		
  }
}
