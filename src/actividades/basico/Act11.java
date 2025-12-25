package actividades.basico;

import java.util.Scanner;

//Ejercicos 7: Menu de operaciones
public class Act11 {
//Escribe un programa que lea dos números enteros por teclado, y realice las operaciones básicas de una calculadora con ellos: 
	//suma, resta, multiplicación, división y resto. Debe mostrar todos los resultados por consola.
	
	//CONDICION: LOS NUMEROS NO PUEDEN SER NEGATIVOS
	public static void main(String[] args) {
		Scanner sc = new Scanner (System.in);	//DECLARAMOS SCANNER
		
		//DECLARAMOS VARIABLES
		int n1;
		int n2;
		int accion;
		String nombreAccion;
		int resultado;
		
		//INICIALIZAMOS VARIABLES
		nombreAccion = " ";
		resultado = 0;
		
		System.out.print("Introduce un numero:");
		n1 = sc.nextInt();
		
		System.out.print("Introduce otro numero:");
		n2 = sc.nextInt();
		
		System.out.println("\n==Menu de operaciones aritmeticas=="
				+ "\n 1. Sumar"
				+ "\n 2. Restar"
				+ "\n 3. Multiplicar"
				+ "\n 4. Dividir"
				+ "\n 5. Todas las anteriores juntas"
				+ "\nIntroduce la accion que se busca realizar: ");
				accion = sc.nextInt();
				
				
				
				//2º CALCULO DE LOS DATOS DE ENTRADA
				switch (accion) {
				case 1:
					resultado = n1 + n2;
					break;
				case 2:
					resultado = n1 > n2? n1 - n2: n2 - n1;
					break;
				case 3:
					resultado = n1 * n2;
					break;
				case 4: 
					resultado = n1 > n2? n1 / n2: n2 / n1;
					break;
				case 5:
					//MOSTRAMOS RESULTADO  - sub caso
					System.out.println("\nTODAS LAS OPRACIONES A LA VEZ");
					System.out.println("Resultado generales entre" + n1 +" "+n2);
					System.out.println("Suma: " + (n1 + n2));
					System.out.println("Resta:" +(n1 > n2? n1 - n2: n2 - n1));
					System.out.println("Multiplicacion: " +(n1 * n2));
					System.out.println("Division: " +(accion = n1 > n2? n1 / n2: n2 / n1));
					break;
				default:
					System.out.println("Las acciones solo tiene de 1-4 ");
					break;
				}
				
				//ESTRUCTURA DE CONTROL - GUARDAR QUE ACCION REALIZA
				if (accion == 1) {
					nombreAccion = "suma";
				} else if (accion == 2) {
					nombreAccion = "resta";
				} else if (accion == 3) {
					nombreAccion = "multiplicacion";
				} else if (accion == 4){
					nombreAccion = "division";
				}
				
				//MOSTRAMOS RESULTADO
				System.out.println("El resultado de la " + nombreAccion + " del numero " + n1 + 
						" y " + n2  + " da un total de " + resultado);
				
				
		
		sc.close();
	}

}
