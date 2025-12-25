package actividades.basico;
//Ejercicios 6: Estructura de control ternario
import java.util.Scanner;
//Escribe un programa que determine si un número es par o impar usando el operador ternario.
public class Act10 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in); 	//DECLARAMOS TECLADO
		
		//DECLARAMOS VARAIBLES
		int numero;
		String msgResultado;
		
		//INICIALIZAMOS VARIRABLE
		System.out.print("Introduce un numero:");
		numero = sc.nextInt();
		
		//ESTRUCTURA DE CONTROL 
		msgResultado = numero % 2 == 0? "\nEs un numero parejo":"\nEs un numero impar";
		
		//MOSTRAR RESULTADO
		System.out.println(msgResultado);
			
		sc.close();		//CERRAMOS TECLADO
	}

}
