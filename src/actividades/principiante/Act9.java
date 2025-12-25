package actividades.principiante;

import java.util.Scanner;
//Escribir un programa en Java que detecte el primer carácter repetido de una cadena de caracteres.
public class Act9 {
	static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		
		//DECLARAMOS VARIABLES
		String str;
		boolean repetido;
		char caracterRepetido;
		int i;
		int j;
		char c;
		int longitud;
		
		
		//INICIALIZAMOS VARIABLES
		repetido = false;
        caracterRepetido = ' ';
        i = 0;
        c = 'c';
        
        
        //DATOS DE ENTRADA
        System.out.println("Introduzca la cadena a verificar");
        str = sc.nextLine();
        longitud = str.length();
        
        //ESTRUCTURA DE BUCLES QUE EVALUAN EL PRIMER CARACTERC OMPARADO CON OTROS
        while (i < longitud && !repetido) {
           
        	c = str.charAt(i);
            j = i + 1;
           
            while (j < longitud && !repetido) {
               
            	if (c == str.charAt(j)) {
            		
                    repetido = true;
                    caracterRepetido = c;
                } else {
                    j++;
                }
            }
            i++;
        }
        
        if (repetido)
            System.out.println("El primer carácter repetido es " + caracterRepetido);
        else
            System.out.println("No hay ningún carácter repetido");

        

	}

}
