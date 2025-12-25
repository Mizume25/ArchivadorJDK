package actividades.basico;



public class Act1 {

	public static void main(String[] args) {
		//MOSTRAR MENSAJE POR TERMINAL
		System.out.println("Hola Mundo");
		
		//DECLARACION DE VARIABLES
		String msg;						//TEXTO
		int numero;						//NUMERO ENTERO
		double decimal;					//NUMERO DECIMAL PEQUEÑO
		float decP;						//DECIMAL "PEQUEÑO"
		boolean comprobador;			// TRUE O FALSE
		long grande;					//CADENA DE NUMEROS ENORME
		var cadena = "Hola a todos";;	//CADENA DE CARACTERES
		String multilinea;
		
		
		//INICIALIZACION DE VARIABLES
		msg = "Hola";
		numero = 1;
		decimal = 4.5;
		decP = 14;
		comprobador = true;
		grande = 2343523532525235L;
		multilinea = "'Declaracion de multiples lineas de texto en bloque String "
				+ "Declaracion de multiples linea de texto en bloque '";
		
		//IMPRIMIR VALORES
		System.out.println(msg + numero + decimal + decP + comprobador + grande + cadena);
		
		//CONVERSIONES ENTRE DATOS (PELIGRO)
		int i;
		long l;
		
		i = 1234;
		l = i;
		
		System.out.println("Conversion de int -> long");
		System.out.println(i);
		System.out.println(l);
		
		//DECLARAR CONSTANTE
		
		final int numero2 = 6;
		System.out.println(numero2);
		System.out.println(multilinea);
		
		String mensaje = String.format("Hola me llamo %s y estoy encantado de conocerte", "Gabriel");
		
		System.out.println(mensaje);
		
		String ejemplo = "H O L A";
		System.out.println(ejemplo.isEmpty());

		
		
		
		
		
		
		
	}

}
