package actividades.basico;
//Ejercicio 2: Calculo de valores simple
import java.util.Scanner;
/*Anexo:
 * CALCULAR NOTA TRIMESTRAL EN BASE AL PROMEDIO DE 3 NOTAS
 * MOSTRAR UN MENSAJE DE APROBADO O SUSPENSO
 * */
public class Act6 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);		//DECLARAMOS SCANNER
		
		//DECLARAMOS VARIABLES
		double notaPrimera;
		double notaSegunda;
		double notaTercera;
		double promedioNotas;
		
		//INICIALIZAMOS VARIABLES
		
			//DATOS DE ENTRADA
		System.out.println("Introduce notas trimestrales:");
		
		System.out.print("\n1º Nota:");
		notaPrimera = sc.nextDouble();
		
		System.out.print("\n2º Nota:");
		notaSegunda = sc.nextDouble();
		
		System.out.print("\n3º Nota:");
		notaTercera = sc.nextDouble();
		
		//CALCULO DE DATOS
		promedioNotas = (notaPrimera + notaSegunda + notaTercera)/3;
		
		//MOSTRAR RESULTADO
			//DATOS DE SALIDA
		System.out.println("\n==Resultado==");
		System.out.printf("El promedio del Alumno es %d eso signfica un %s",Math.round(promedioNotas), Math.round(promedioNotas) >= 5? "Aprobado":"Suspendido");
		
		sc.close(); //CEERRAMOS TECLADO
	}

}
