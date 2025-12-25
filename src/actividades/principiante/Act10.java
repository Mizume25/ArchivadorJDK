package actividades.principiante;

import java.util.Scanner;

//Porgrama que cuenta las vocales de una cadena
//MODIFICACION PERSONAL: DECIR CUANTAS VOCALES HAY DE CADA UNA
public class Act10 {
	static Scanner sc = new Scanner(System.in);		//DECLARAMOS SCANNER
	
	//1º FUNCION QUE RETORNA UN STRING
	public static String escribirCadena() {
		System.out.print("Escribe una cadena de caracteres:");
		return sc.nextLine();
	}
	
	//2º FUNCION QUE CUENTA LOS NUMEROS DE VOCALES DE UNA CADENA
	public static int contadorVocales (String cadena) {
		
		//DECLARAMOS VARIABLES
		int contador;
		int longitud;
		
		
		//INICIALIZAMOS VARIABLES
		contador = 0;
		longitud = cadena.length();
		
		//ESTRUCTURA ITERATIVA QUE REVISE TODA LA CADENA
		for (int i = 0; i < longitud; i++) {
			
			if (cadena.charAt(i) == 'a' || cadena.charAt(i) == 'e' || cadena.charAt(i) == 'i' || cadena.charAt(i) == 'o'
			 || cadena.charAt(i) == 'u') {
				
				contador++;
			}
		}
		
		return contador;
	}
	
	//3º FUNCION QUE CUENTA CUANTAS VOCALES HAY DE CADA 1
		public static void contadorVocalesSolas (String cadena, int [] vocales) {
			
			//DECLARAMOS VARIABLES
			int longitud;
			
			
			//INICIALIZAMOS VARIABLES
			
			longitud = cadena.length();
			
			//ESTRUCTURA ITERATIVA QUE REVISE TODA LA CADENA
			for (int j = 0; j < longitud; j++) {
				
				if (cadena.charAt(j) == 'a') {
					vocales[0]++;						
				} else if (cadena.charAt(j) == 'e') {
					vocales[1]++;
				} else if (cadena.charAt(j) == 'i') {
					vocales[2]++;
				}else if (cadena.charAt(j) == 'o') {
					vocales[3]++;
				}else if (cadena.charAt(j) == 'u') {
					vocales[4]++;
				}
			}
			
			
		}
	public static void main(String[] args) {
		
		//DECALARAMOS VARIABLES
		String cadena;
		int contador;
		int [] vocales = new int[5];
		String [] vocalesS = {"a","e","i","o","u"};
		
		//INCIALIZAR VARIABLES
		cadena = escribirCadena();
		
		contador = contadorVocales(cadena);
		
		contadorVocalesSolas(cadena,vocales);
		
		//MOSTRAR RESULTADO
		if (contador == 0) {
			System.out.println("No hay vocales en esta cadena");
		} else {
			System.out.println("En la cadena: " + cadena + " hay un total de " + contador + " vocales");
			
			System.out.println("\n==Total de vocales individuales==");
			for (int i = 0; i < vocales.length; i++) {
					System.out.println(vocalesS[i] + ":" + vocales[i]);
			}
		}
		
		
	}

}
