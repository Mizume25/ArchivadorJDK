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
		public static String escribirContra () {
			System.out.println("\nEscribe una contraseña que cumpla estos equisitos"
					+ "\n 1. Debe medir entre 8 a 20 caracteres"
					+ "\n 2. Debe contener al menos 1 Mayuscula y Minuscula"
					+ "\n 3. Debe contener al menos un caracter raro: * _ @ %"
					+ "\n 4. Debe contener 1 numero"
					+ "\nIntroduce tu contraseña:");
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
	
	
	// 8º FUNCION QUE COMRPEUBA SI HAY CARACTERES EN CONTRASEÑA
	public static boolean medidaContra(String password) {
		// DECLARAMOS VARIABLES
		int longitud;

		// INICIALIZAMOS VARIABLES
		longitud = password.length();

		// ESTURCTURA QUE COMPRUEBA TAMAÑO
		if (longitud >= 8 && longitud <= 20) {
			return true;

		} else {

			return false;
		}

	}

	// 9º FUNCION QUE COMRPEUBA SI HAY MAYUSCULAS EN CONTRASEÑA
	public static boolean buscarMayusculaContra(String password) {
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

			encontrado = Character.isUpperCase(password.charAt(i));

			i++;
		} while (!encontrado && i < longitud);

		return encontrado;

	}

	// 10º FUNCION QUE COMRPEUBA SI HAY MINUSCULAS EN CONTRASEÑA
	public static boolean buscarMinusculaContra(String password) {
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

	// 11º FUNCION QUE COMRPEUBA SI HAY CARACTERES RAROS EN CONTRASEÑA
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

			if (password.charAt(i) == '%' || password.charAt(i) == '$' || password.charAt(i) == '_'
					|| password.charAt(i) == '*') {

				encontrado = true;
			}

			i++;
		} while (!encontrado && i < longitud);

		return encontrado;

	}

	// 12º FUNCION QUE COMRPEUBA SI HAY DIGITOS RAROS EN CONTRASEÑA
	public static boolean buscarDigitoContra(String password) {
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
		} while (!encontrado && i < longitud);

		return encontrado;

	}
	
	//13º FUNCION QUE CALCULA SI LOS VALORES DE UN CORREO ESTAN REPETIDOS
	public static void correoRepetido(String [][] tabla, int [] repetido) {
		//COMRPBACIONES POSTERIORES
				int j = 0; //Fila completa
				int k; // Fila Iterna
				int y = 0;
				
				
				while (j < tabla.length) {
				    k = j + 1;  // Comparamos con los siguientes elementos
				    
				    while (k < tabla.length) {
				        // Comparar el elemento [j][0] con [k][0]
				        if (tabla[j][0].equals(tabla[k][0])) {
				            repetido[y] = j;      // Guardar índice del primer repetido
				            repetido[y + 1] = k;  // Guardar índice del segundo repetido
				            y += 2; 			 // IMPORTANTE: Incrementar y para no sobrescribir
				        }
				        
				        k++;
				    }
				    
				    j++;
				}
	}
	
	public static void procesarCorreo(String[][] tabla,int fil) {

		String correo;
		boolean medidaCorreo, dominio, extension, mayusculas, minusculas, digitos;
		boolean [] correoValido = new boolean [6];
		int [] traductorBooleans = new int [6];
		int i = 0;
		int fila = 0;
		boolean basicCheck = true;

		do {
			correo = escribirCorreo();
			basicCheck = true; // Reiniciar para cada intento

			//COMPROBACIONES INICIALES QUE NO CONTENGA ESPACIOS EN BLANCO, QUE CONTENGA 1 ARROBA Y UN PUNTO
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
				i = 0; // reiniciamos i

				//COMPROBAMOS MEDIDA DEL CORREO
				medidaCorreo = medidaCorreo(correo); // COMPROBAMOS
				correoValido[i] = medidaCorreo; // GUARDAMOS EN EL ARRAY DE BOOLEANS
				i++; // INCREMENTAMOS i

				//COMPROBAMOS DOMINIO DEL CORREO
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

					while (!secuencia && k < traductorBooleans.length) {
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
					tabla[fila][0] = correo;
					fila++;
					System.out.println("\nTu correo se ha guardado perfectamente!");
				}
			} else {
				System.out.println("\nTu correo no contiene características básicas");
			}

		} while (fila < fil);
	}
	
	public static void procesarContrasenas(String[][] tabla,int fil) {

		String password;
		boolean medidaContra, mayusculasContra, minusculasContra, digitosContra, caracteresRaroContra;
		boolean [] contraValida = new boolean [5];
		int [] traductorBooleansContra = new int [5];
		int fila = 0;
		int i = 0;
		boolean basicCheck = true;
		do {
			password = escribirContra();
			basicCheck = true; // Reiniciar para cada intento

			//COMPROBACIONES INICIALES
			// 1. ESPACIOS
			if (password.contains(" ")) {
				System.out.println("\nERROR: Tu contraseña no puede contener espacios vacíos");
				basicCheck = false;
			}

			if (basicCheck) {
				boolean error;
				i = 0; // reiniciamos i

				//COMPROBAMOS MEDIDA DE LA CONTRASEÑA
				medidaContra = medidaContra(password);
				contraValida[i] = medidaContra;
				i++;

				//COMPROBAMOS MAYÚSCULAS
				mayusculasContra = buscarMayusculaContra(password);
				contraValida[i] = mayusculasContra;
				i++;

				//COMPROBAMOS MINÚSCULAS
				minusculasContra = buscarMinusculaContra(password);
				contraValida[i] = minusculasContra;
				i++;

				//COMPROBAMOS CARACTERES ESPECIALES
				caracteresRaroContra = buscarCaracterEspecial(password);
				contraValida[i] = caracteresRaroContra;
				i++;

				//COMPROBAMOS DÍGITOS
				digitosContra = buscarDigitoContra(password);
				contraValida[i] = digitosContra;
				i++;

				//TRADUCIMOS EL ARRAY DE BOOLEANS A INTS DE 1 A 0
				for (int j = 0; j < contraValida.length; j++) {
					if (contraValida[j]) {
						traductorBooleansContra[j] = 1;
					} else {
						traductorBooleansContra[j] = 0;
					}
				}

				error = MetodosArrayslib.buscarCoincidenciaArray(traductorBooleansContra, 0);

				if (error) {
					int k = 0;
					int posicion = 0;
					boolean secuencia = false;

					while (!secuencia && k < traductorBooleansContra.length) {
						if (traductorBooleansContra[k] == 0) {
							posicion = k;
							secuencia = true;
						}
						k++;
					}

					switch (posicion) {
					case 0:
						System.out.println("Error: Longitud incorrecta (8-20 caracteres)");
						break;
					case 1:
						System.out.println("Error: Falta Mayúscula");
						break;
					case 2:
						System.out.println("Error: Falta Minúscula");
						break;
					case 3:
						System.out.println("Error: Falta caracter especial *_%$");
						break;
					case 4:
						System.out.println("Error: Falta dígitos");
						break;
					}
				} else {
					tabla[fila][1] = password;
					fila++;
					System.out.println("\nTu contraseña se ha guardado perfectamente!");
				}
			} else {
				System.out.println("\nTu contraseña no contiene características básicas");
			}

		} while (fila < tabla.length && tabla[fila][0] != null);
	}
	
	public static void main(String[] args) {
        //DECLARAMOS VARIABLES
		int fil;
		String [][] tabla;
		// INICIALIZAMOS VARIABLES
		
		fil = MetodosEntradaslib.numUsuario("==Gestor de correos==", "\nIntroduce cantidad de correos que te gustari introducir:",
		"\nMaximo puedes introducir 5", "\nMinimo necesitas introducir 2 correos", 5, 2);
		
		tabla = new String [fil][2];			//INDEPENDIENTEMENTE DE SI HAY 5 O 2 CORREO SIEMPRE HBARA 1 COLUMNA
		
		//RELLENAMOS MATRIZ CON LOGICAS DE COMPROBACION
		procesarCorreo(tabla, fil);

		procesarContrasenas(tabla, fil);
		
		int [] repetido;
		int espacioArray = tabla.length * (tabla.length - 1);
		repetido = new int [espacioArray];
		
		correoRepetido(tabla, repetido);
		
		int suma = MetodosArrayslib.sumaValorTotalArray(repetido);
		
		if (suma != 0) {
			System.out.println("Tienes correos repetidos");
			
			for (int f = 0; f < tabla.length; f++) {  
	                System.out.print(tabla[f][0] + " ");
	            
	            System.out.println();
	        }
			int accion = 0;
			do {
			    accion = MetodosEntradaslib.numeroUsuario("¿Qué correo quieres eliminar? (1-" + tabla.length + "):");
			} while (accion < 1 || accion > tabla.length); 
			
			int traductor = accion - 1;
			
			tabla[traductor][0] = " ";
			
			
			
			
			
			
			
		}
		
  }
}
