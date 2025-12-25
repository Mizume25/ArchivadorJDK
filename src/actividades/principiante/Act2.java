package actividades.principiante;
//Ejercicio: Estructuras de control
import java.util.Scanner;
// Pon un numero de dia y el programa debe devolver el nombre del dia
public class Act2 {

	public static void main(String[] args) {
		//DECLARAMOS SCANNER
		Scanner sc = new Scanner(System.in);
		
		//DECLARAR VARIABLE
		int numeroDia;
		
		//INICIALIZAMOS VARIABLES
		System.out.print("Numero de el dia:");
		numeroDia = sc.nextInt();
		
		//MOSTRAR RESULTADO
		//ESTRUCTURA DE CONTROL SWITCH
		switch (numeroDia) {
		case 1:
			System.out.println("Lunes");
			break;
		case 2:
			System.out.println("Martes");
			break;
		case 3:
			System.out.println("Miercoles");
			break;
		case 4:
			System.out.println("Jueves");
			break;
		case 5:
			System.out.println("Viernes");
			break;
		case 6:
			System.out.println("Sabado");
			break;
		case 7:
			System.out.println("Domingo");
			break;
		default:
			System.out.println("ERROR - SOLO HAY 7 DIAS");
			break;
		};
		
		//CERRAMOS SCANNER
		sc.close();
		
	}

}
