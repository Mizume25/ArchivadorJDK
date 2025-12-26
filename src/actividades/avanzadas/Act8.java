package actividades.avanzadas;



import java.util.Scanner;

import arrays.MetodosArrayslib;
import datosentrada.MetodosEntradaslib;

//Verificacion de correo electronico y contraseña
public class Act8 {
	
	//DECLARAMOS UN SCANNER COMO VARIABLE DE CLASSE
	static Scanner sc = new Scanner(System.in);
	
	//1º FUNCION QUE ESCRIBE UN CORREO ELETRONICO COMPLETO
	public static String escribirCorreo () {
		System.out.print("\nEscribe tu correo eletronico que cumpla estos equisitos:"
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
		verificacion = false;
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
		
		if (medidaDominio != 6 && medidaDominio != 8) {
			return false;
		}
		
		dominio = new char [medidaDominio];
		
		
		//LLENAMOS LOS CARACTERES DEL DOMINIO Y LOS GUARDAMOS
		for (int j = 0; j < dominio.length; j++) {
			dominio[j] = caracteres[posicionArroba];
			posicionArroba++;
		}
		
		
		
		
		if (dominio[1] == 'g') {
			//DECLARAMOS VARIABLES
			verificacion = true;
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
			verificacion = true;
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
		
		if (contExtension != 4 && contExtension != 3) {
			return false;
		}
		
		extension = new char [contExtension];
		
		
		//LLENAMOS LOS CARACTERES DEL DOMINIO Y LOS GUARDAMOS
		for (int j = 0; j < extension.length; j++) {
			extension[j] = caracteres[posicionPunto];
			posicionPunto++;
		}
		
		
		verificacion = false;
		
		if (extension[1] == 'c') {
			//DECLARAMOS VARIABLES
			verificacion = true;
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
			verificacion = true;
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
	
	public static boolean correoRepetido(String correo,String [][] tabla,int fila) {
		// DECLARAMOS VARIABLES
		int longitud;
		int i;
		char[] caracteres;
		char[] nombreCorreo; 
		int contador;
		boolean repetido;
		// INICIALIAMOS VARIABLES
		longitud = correo.length(); // MEDIRA TANTO MIDA EL CORREO
		i = 0;
		contador = 0;
		caracteres = new char[longitud];

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
		
		nombreCorreo = new char [contador];
		
		
		for (int j = 0; j < contador; j++) {
			nombreCorreo[j] = correo.charAt(j);
		}
		
		
		
		repetido = true;
		for (int j = 0; j < nombreCorreo.length; j++) {
			if (nombreCorreo[j] != tabla[fila - 1][0].charAt(j)) {
				repetido = false;
			}
		}
		
		return repetido;
		
		
	}
	
	public static void main(String[] args) {
        //DECLARAMOS VARIABLES
		int fil;
		String [][] tabla;
		String correo;
		String contra;
		int i;
		int fila;
		//VARIABLES DE COMPROBACION
		//VALIDACION INICIAL
		boolean basicCheck;
		
		//COMPROBACIONES FINALES
		boolean medidaCorreo;
		boolean dominio;
		boolean extension;
		boolean mayusculas;
		boolean minusculas;
		boolean digitos;
		boolean [] correoValido;
		int [] traductorBooleans;
		boolean validacionCompleta;
		boolean correoRepetido;
		
		
		//INICIALIZAMOS VARIRABLES
			//LLAMAMOS AL METODO DE ESTRUCTURA DE CONTROL PARA QUE ME DE ENTRE UN NUMERO DE 2 A 5
		fil = MetodosEntradaslib.numUsuario("==Gestor de correos==", "\nIntroduce cantidad de correos que te gustari introducir:",
		"\nMaximo puedes introducir 5", "\nMinimo necesitas introducir 2 correos", 5, 2);
		
		tabla = new String [fil][2];			//INDEPENDIENTEMENTE DE SI HAY 5 O 2 CORREO SIEMPRE HBARA 1 COLUMNA
		mayusculas = false;
		minusculas = false;
		digitos = false;
		correoValido = new boolean [6];
		traductorBooleans = new int [6];
		basicCheck = true;
		i = 0;
		fila = 0;
		do {
			
			correo = escribirCorreo();
			
			//COMPROBACIONES INICIALES QUE NO CONTENGA ESPACIOS EN BLANCO, QUE CONTENGA 1 ARROBA DE MONIO Y UN PUNTO DE EXTENSION
			// 1. ESPACIOS
			if (correo.contains(" ")) {
			    System.out.println("\nERROR: Tu correo no puede contener espacios vacios");
			    basicCheck = false;
			}

			// 2. ARROBA (@)
			if (!correo.contains("@")) {  
			    System.out.println("\nERROR: Tu correo debe contener @ (ej: @gmail.com)");
			    basicCheck = false;
			}

			// 3. PUNTO (.)
			if (!correo.contains(".")) {  
			    System.out.println("\nERROR: Tu correo debe contener punto (ej: .com)");
			    basicCheck = false;
			}
			
			if (basicCheck) {
				boolean error;
				i = 0; //reiniciamos i
				//COMPROBAMOS MEDIDA DEL CORREO
				medidaCorreo = medidaCorreo(correo);		//COMPROBAMOS
				correoValido[i] = medidaCorreo;				//GUARDAMOS EN EL ARRAY DE BOOLEANS
				i++;										// INCREMENTAMOS i
				
				//COMPROBAMOS MEDIDA DEL CORREO
				dominio = dominioCorreo(correo);
				correoValido[i] = dominio;	
				i++;
				
				//COMPROBAMOS EXTENSION
				extension = extensionCorreo(correo);
				correoValido[i] = extension;	
				i++;
				
				//COMPROBAMOS MAYUSCULAS
				mayusculas = buscarMayusculaCorreo(correo);
				correoValido[i] = mayusculas;	
				i++;
				
				//COMPROBAMOS MINUSCULAS
				minusculas = buscarMinusculaCorreo(correo);
				correoValido[i] = minusculas;	
				i++;
				
				//COMPROBAMOS DIGITOS
				digitos = buscarDigitoCorreo(correo);
				correoValido[i] = digitos;
				
				//TRADUCIMOS EL ARRAY DE BOOLEANS A INTS DE 1 A 0
				for (int j = 0; j < correoValido.length; j++) {
					
					if (correoValido[j]) {
						traductorBooleans[j] = 1;
					} else {
						traductorBooleans[j] = 0;
					}
				}
				
				error = MetodosArrayslib.buscarCoincidenciaArray(traductorBooleans, 0);
				
				if (error) {
				
				int k = 0;
				int posicion = 0;
				boolean secuencia = false;
				
				while (!secuencia) {

		            if (traductorBooleans[k] == 0) {
		            	posicion = k;
		            	secuencia = true;
		            }
		            k++;
		        }
				
			
					
					switch (posicion) {
					case 0:
		                System.out.println("Error: Longitud incorrecta (10-40 caracteres)");
		                break;
		            case 1:
		                System.out.println("Error: Dominio no válido");
		                break;
		            case 2:
		                System.out.println("Error: Extensión no válida");
		                break;
		            case 3:
		                System.out.println("Error: Falta mayúscula");
		                break;
		            case 4:
		                System.out.println("Error: Falta minúscula");
		                break;
		            case 5:
		                System.out.println("Error: Falta dígito");
		                break;
						}
				
				
				} else {
					
					//Mas de una iteracion
					if (fila > 0) {
						
						correoRepetido = correoRepetido(correo, tabla, fila);
						
						if (!correoRepetido) {
							tabla[fila][0] = correo;
							fila++;
							System.out.println("\nTu correo se ha guardado perfectamente!");
						} else {
							
							System.out.println("\n EL correo esta repetido");
						}
					}
					
					//Primera iteracion
					if (fila == 0) {
					tabla[fila][0] = correo;
					fila++;
					System.out.println("\nTu correo se ha guardado perfectamente!");
					}
					
				}
				
				
				
			} else {
				
				System.out.println("\nTu correo no contiene caracteristicas basicas");
			}
			
			
			
		
		
		} while (fila < fil);
		
		contra = escribirContra(correo);
		
  }
}
