package actividades.basico;

public class Act3 {

	public static void main(String[] args) {
		
		System.out.println("OPERADORES COMPARACION");
		
		/*	> / <  	| 	>=  / <= 	|	== / == / != 	*/
		int a;
		int b;
		
		a = 6;
		b = 7;
		
		boolean r1 = a > b;
		System.out.println(r1);
		
		r1 = a < b;
		System.out.println(r1);
		
		
		System.out.println("OPERADORES LÓGICO");
		
		/*AND = && | 	OR = ||  | NOT = !expresion = no expresion	*/
		
		boolean r2;
		r2 = false;
		System.out.println(!r2);
		
		//Imprime true porque imprime: NO false
		
		
		/*A nivel de bits --> & | >> <<*/
		
		int e;
		int y1;
		e = 10;
		y1 = e << 2;
		
		System.out.println(e + " - " + Integer.toBinaryString(e));
		System.out.println(y1 + " - " + Integer.toBinaryString(y1));
		
		
		//TIPOS DE IMPRESION GENERAL
		System.out.println("H");	//Impresion con salto de liena
		System.out.print("H");		//Impresion sin salto de linea
		System.out.printf("%d",e);	//Impresion con formato
		
	}

}
