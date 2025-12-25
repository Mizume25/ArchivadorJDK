package actividades.principiante;


import java.util.Scanner;

// Ejercicio de cadenas:
/*Un palindrome es una cadena de caracteres que se lee 
 * igual desde izquierda a derecha que de derecha a izquierda. Pueden ser simplemente palabras como:
Ana, Salas, rajar,...
O también frases completas:

Dábale arroz a la zorra el abad

A luna ese anula

Allí ves a Sevilla*/
public class Act7 {
	static Scanner sc = new Scanner(System.in); //DECLARAMOS VARIABLE
	
	// 1º FUNCION QUE PIDE UNA PALABRA
	public static String escribirPalabra () {
		System.out.println("Introduce un palindromo:");
		return sc.next().toLowerCase();
	}
	
	//2º FUNCION QUE LE UNA FRASE
	public static String escribirFrase () {
		System.out.println("Introduce un palindromo:");
		return sc.nextLine().toLowerCase();
	}
	
	// 3º FUNCION PARA QUITAR ACCENTOS
	public static String quitarAcentos(String input) {
	    return input
	        .replace('á', 'a')
	        .replace('é', 'e')
	        .replace('í', 'i')
	        .replace('ó', 'o')
	        .replace('ú', 'u')
	        .replace('Á', 'A')
	        .replace('É', 'E')
	        .replace('Í', 'I')
	        .replace('Ó', 'O')
	        .replace('Ú', 'U');
	}
	
	//4º FUNCION QUE COMPRUEBA SI ES O NO PALINDROMO
	public static boolean comprobarPalindromo (String cadena, boolean tipo) {
		//DECLARAMOS VARIABLES
		int longitud;
		boolean palindromo;
		int j;
		int i;
		
		//INICIALIZAMOS VARIABLES
		longitud = cadena.length();
		palindromo = true;
		j = longitud - 1;
		i = 0;
		
		//ESTRUCTURA DE CONTROL QUE EVALUA SI ES PALABRA O FRASE
		if (tipo) {
			
			//ESTRUCTURA ITERATIVA QUE SE ROMPE O BIEN CUANDO HAYA UN FALSE O BIEN CUANDO J LLEGE A 0
			do {
			    if (cadena.charAt(i) != cadena.charAt(j)) {
			        palindromo = false;
			    }
			    j--;
			    i++;
			} while(palindromo && i <= j);
			
		} else {
			
		    String cadenaLimpia = cadena.replaceAll("\\s+", ""); // ELIMINAMOS LOS ESPACIOS
		    cadenaLimpia = quitarAcentos(cadenaLimpia); // QUITAMOS LOS ACCENTOS
		    longitud = cadenaLimpia.length();		//MEDIMOS LA LONGITUD
		    j = longitud - 1;
		    i = 0;
		    
		    do {
		        if (cadenaLimpia.charAt(i) != cadenaLimpia.charAt(j)) {
		            palindromo = false;
		        }
		        j--;
		        i++;
		    } while(palindromo && i <= j);
		}
		
		return palindromo;
		
	}
	
	// 5º FUNCION QUE DICTAMINA SI EL USUARIO QUIERE UNA PALABRA O UNA FRASE
	public static boolean palabraOfrase() {
		System.out.print("¿Quieres comprobar un palindromo en una frase o en una palabra? [p / f]: ");
		return sc.next().equalsIgnoreCase("p")? true:false;
	}
	
	public static void main(String[] args) {
		
		//DECLARAMOS VARIABLES
		String cadena;
		String resultado;
		boolean tipo;
		
		
		//INICILIAZMOS VARIABLES
		tipo = palabraOfrase();
		cadena = " ";
		resultado = "";
		
		//ESTRUCTURA DE CONTROL
		if (tipo) {
			//DETECTAR PALABRAS
			boolean palindromo;
			cadena = escribirPalabra();
			
			palindromo = comprobarPalindromo(cadena, tipo);
			
			resultado = palindromo? " es un palindromo": " no es un palindromo";
			System.out.println("La palabra " + cadena + resultado );
			
			
		} else {
			
			 //DETECTAR FRASES
			 sc.nextLine(); // LIMPIAMOS BUFFER
			 
			 boolean palindromo;
			 cadena = escribirFrase();
			    
			 palindromo = comprobarPalindromo(cadena, tipo);
			    
			 resultado = palindromo ? " es un palindromo" : " no es un palindromo";
			 System.out.println("La frase \"" + cadena + "\"" + resultado);
			
		}
		
		
		

	}

}
