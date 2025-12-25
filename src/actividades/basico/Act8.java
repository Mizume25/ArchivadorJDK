package actividades.basico;

import java.util.Scanner;
//Ejercicio 4: calculos simples
public class Act8 {
//Escribir un programa que calcule el perímetro y el área de un círculo y la muestre por consola. 
//El `radio` del mismo lo puedes proporcionar como un valor inicial de la variable correspondiente.
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);	//DECLARAMOS SCANNER
		
		//DECLARAMOS VARIABLES
				double radio;
				double perimetro;
				double area;
				
				//INICIALIZAMOS VARIABLES
					//DATOS DE ENTRADA
				System.out.print("Radio:");
				radio = sc.nextDouble();
				
				//CALCULO 
				perimetro = 2 * Math.PI * radio;
				area = radio * radio * Math.PI ;
				
				//MOSTRAR RESULTADO
				System.out.println("\nCalculo de un circulo con el radio de " + radio + " centimentros");
				
				System.out.printf("Perimetro: %.2fcm\n", perimetro);
				System.out.printf("Area: %.2fcm", area);
				
				sc.close(); 	//CERRAMOS TECLADO
	}

}
