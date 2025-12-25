package actividades.basico;
//Ejercicio 1: Calculo de valores simple
import java.util.Scanner;
//Anexo:
/*
 * PRECIO TOTAL DE UN PRODUCTO = COSTE FABRICACION + PORCENTAJE DE BENEFICIO DEL VENDEDOR + LOS IMPUESTOS
 * DATOS DE ENTRADA:
 * COSTE DE FABRICACION: INPUT
 * MARGEN DE BENEFICIO: 30%
 * MARGEN DE IMPUESTOS : 21%
 * 
 * ADICIONAL: MOSTRAR SI EL PRECIO ES NORMAL O DE LUJO
 * MARGEN DE DIFERENCIA: 600 SI ES MENO O IGUAL ES NORMAL SI NO DE LUJO
 * */

public class Act5 {
	
	public static void main(String[] args) {
		//DECLARAMOS SCANNER 
		Scanner sc = new Scanner(System.in); 	
	
			//DECLARAMOS VARIABLES 
			double precioFabricacion;
			
			//PEDIMOS PRECIO DE FABRICACION
			System.out.println("==Calcular precio de un producto==");
			System.out.print("Introduzca el precio del producto:");
			precioFabricacion = sc.nextDouble();
			
			//CALCULAMOS DIRECTAMENTE EL RESULTADO
			System.out.println("\n==Resultado==");
			System.out.printf("Margen de beneficio: %.2f€\n" , (precioFabricacion *  0.30));
			System.out.printf("Margen de impuestos: %.2f€\n" , (precioFabricacion *  0.21));
			
			/*EXPRESION ARITMETICA
			 * pFabricacion * 0,30 = 30% del precio de fabricacion
			 * pFabricacion * 0,21 = 21% del precio de fabricacion
			 * */
			
			//CALCULO FINAL
			System.out.printf("Precio Total:  %.2f€," , precioFabricacion + ((precioFabricacion *  0.30) +(precioFabricacion *  0.21)));
			
			/*EXPRESION ARITMETICA
			 * 30% + 21% = 51% + pFabricacion ? Precio Real
			 * */
			
			//IMPRIMIMOS MENSAJE FINAL
			if ((precioFabricacion + (precioFabricacion *  0.30) + (precioFabricacion *  0.21) > 600)) {
				System.out.println("\nPrecio de Lujo");
			} else {					
				System.out.println("\nPrecio Normal");
			}

			sc.close();	//CERRAMOS TECLADO
	}
	

}
