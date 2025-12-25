package actividades.basico;

import java.util.Scanner;

//Ejercicio 3: calculos simples
public class Act7 {
	/*Escribir un programa que calcule el área y el perímetro de un rectángulo y la muestre por consola. 
	 * La `altura` y la `anchura` del mismo la puedes proporcionar como valores iniciales de las variables correspondientes.*/
	
	public static void main(String[] args) {
		//DECLARAMOS EL SCANNER
		Scanner sc = new Scanner(System.in);
		
		//DECLARAMOS VARIABLES
		int altura;
		int ancho;
		int perimetro;
		int area;
		
		//INICIALIZAMOS VARIABLES
			//DATOS DE ENTRADA
		System.out.print("Altura:");
		altura = sc.nextInt();
		
		System.out.print("Ancho:");
		ancho = sc.nextInt();
		
		//CALCULO 
		perimetro = 2 * (altura + ancho);
		area = altura * ancho;
		
		//MOSTRAR RESULTADO
		System.out.println("\nCalculo de un rectangulo con la altura de " + altura + " y el ancho de " + ancho + " centimentros");
		
		System.out.printf("Perimetro: %dcm\n", perimetro);
		System.out.printf("Area: %dcm", area);
		
	
		
		sc.close();
	}

}
