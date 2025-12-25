package actividades.principiante;

import java.util.Scanner;

public class Act1 {

	public static void main(String[] args) {
		
		//DECLARAMOS SCANNER
        Scanner sc = new Scanner(System.in);

        //DECLARAMOS VARIABLES
        int mes;
        int dia;
        int any;
        
        //INICIALIZAMOS VARIRABLES
        System.out.print("Que mes? ");
        mes = sc.nextInt();

        System.out.print("Que dia? ");
        dia = sc.nextInt();

        System.out.print("Que año? ");
        any = sc.nextInt();

        //ESRUCTURA DE CONTROL
		if (any <= 0) {
			System.out.println("Fecha incorrecta porque AÑO INVÁLIDO.");		//EL AÑO - DEBE SER UN NUMERO POSITIVO
		} else {

			if (mes < 1 || mes > 12) {
				System.out.print("Fecha incorrecta porque MES INVÁLIDO, ");		// EL MES NO PUEDE SUPERAR LOS 12 ESTABLECIDOS
			} else {

				if (dia < 1 || dia > 31) {
					System.out.print("Fecha incorrecta porque DÍA INVÁLIDO, "); //EL DIA NO PUEDEN SUPERAR LOS DIAS ESTABLECIDOS
				} else {

					if ((mes == 4 || mes == 6 || mes == 9 || mes == 11) && dia == 31) { //ESOS MES NO TIENEN ESOS DIAS
						System.out.print("Fecha incorrecta porque DÍA INVÁLIDO, ");
					} else {
						
						if (((any % 4 == 0 && any % 100 != 0) || any % 400 == 0) && mes == 2 && dia > 29) { //AÑO BIFIESTO
							System.out.print("Fecha incorrecta porque DÍA INVÁLIDO, ");
						} else {
							
							if (mes == 2 && dia > 28) {
								System.out.print("Fecha incorrecta porque DÍA INVÁLIDO, ");
							} else {
								System.out.print("¡Fecha correcta!");
							}
						}
					}
				}
			}
		}

        sc.close();
    

	}

}
