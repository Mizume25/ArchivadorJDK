package actividades.avanzadas;
import java.util.Arrays;
import java.util.Scanner;

public class Act8 {
    static Scanner scr = new Scanner(System.in);        //Scanner como variable de classe
    
    public static boolean cartasEntrada(String [] valores_cartas,String []palos_cartas) {
    	
    	//DECLARACION DE VARIABLE
    	boolean verificador;
    	int i;
    	
    	//INICIALIZAMOS VARIRABLES
    	verificador = true;
    	i = 0;
    	
        do {
            
            valores_cartas[i] = scr.next().toLowerCase();		//ESCRIBIMOS NUMERO
            
            if (valores_cartas[i].equals("0")) {
            	verificador = false;
            	break;
			}
            
            if (verificador) {
            palos_cartas[i] = scr.next().toLowerCase();			//ESCRIBIMOS VALOR CARTA	
			}
         
             
            i++;
        } while (verificador);
        
        return verificador;
        
    }
    //1º FUNCION QUE TRADUCE VALORES DEL USUARIO
    public static int [] valoresAnumeros (String [] valores_cartas, int [] valores_numericos){
    
        // Switch para que vea todas las situaciones
        for (int i = 0; i < valores_cartas.length; i++) {

             switch(valores_cartas[i]) {
                case "2": 
                valores_numericos[i] = 2;
                break;
                case "3": 
                valores_numericos[i] = 3;
                break;
                case "4": 
                valores_numericos[i] = 4;
                break;
                case "5": 
                valores_numericos[i] = 5;
                break;
                case "6": 
                valores_numericos[i] = 6;
                break;
                case "7": 
                valores_numericos[i] = 7;
                break;
                case "8": 
                valores_numericos[i] = 8;
                break;
                case "9": 
                valores_numericos[i] = 9;
                break;
                case "10": 
                valores_numericos[i] = 10;
                break;
                case "j": 
                valores_numericos[i] = 11;
                break;
                case "q": 
                valores_numericos[i] = 12;
                break;
                case "k": 
                valores_numericos[i] = 13;
                break;
                case "a": 
                valores_numericos[i] = 14;
                break;
                
             }


        }

        return valores_numericos;
  }

   //2º Funcion para saber si es una escalera de color o no
  public static int numeroFalta (int [] valores_numerico){
	  
	  //ORDENAMOS EL ARRAY
	  Arrays.sort(valores_numerico);
	  int i;
	  int numFalta;
	  boolean salir; 
	  boolean numConsecutivo;
	  
	  salir = false;
	  numConsecutivo = true;
	  i = 0;
	  numFalta = 0;
	  
	  	do {
	  		
	  		
	  		
	  		if (valores_numerico[i + 1] - valores_numerico[i] != 1) {
	  			
	  			numConsecutivo = false;
	  			
	  			if (valores_numerico[i + 1] - valores_numerico[i] == 2) {	
	  				numFalta = valores_numerico[i] + 1;						//VALOR SERA NUMERO CONSECUTIVO DE LA DIFERENCIA
	  				salir = true;
				} else {
					
					numFalta = 0;											//VALOR ES 0 PORQUE SI NO ES CONSCUTIVO DE 1 O 2 NO SE PUEDE HACER ESCALERA DE COLOR
	  				salir = true;
					
				}
	  			
			}
	  		
	  		i++;
			
		} while (i < valores_numerico.length - 1|| !salir);	//Aumenta hasta la penultima posicion
	  	
	  	if (numConsecutivo) {
	  		numFalta = valores_numerico[3] + 1;								//SI TODOS LOS VALORES SON CONSECUTIVOS EL NUMERO QUE FALTA ES EL VALOR CONSECUTIVO DEL ULTIMO
		}
	  	
	  	return numFalta;
	 
  }

   // 3 FUNCION QUE RETORNA UN BOLLEAN DE IGUALES

  public static boolean tipoCartas(String [] palos_cartas){
    return palos_cartas[0].equals(palos_cartas[1]) && palos_cartas[2].equals(palos_cartas[3]);
  }

  
    public static void main(String[] args) {
    	
    //DECLARACION DE VARIABLES
    boolean salir;
    int numeroFalta;   
    boolean palosIguales;
    boolean verificador;
    String letraFalta;
    
    //INICIALIZAMOS 3 ARRAYS 2 PARA EL USUARIO Y UNO DE TRADUTOR
    String [] valores_cartas = new String[4];   //ARRAY DE LOS VALORES DEL USUARIO
    int [] valores_numericos = new int [4];     //VALORES  NUMERICOS DE LOS DATOS DE ENRADA
    String [] palos_cartas = new String[4];     //ARRAY DE PALOS QUE EMPLEA LA SECUENCIA

    
    //INICIALIZAMOS VARIABLE
    numeroFalta = 0;                        
    palosIguales = false;   
    letraFalta = "";                     
    
    salir = false;
    do {

    	verificador = cartasEntrada(valores_cartas, palos_cartas);
    	
    	if (!verificador) {
			
    		salir = true;
    		
		} else {

        valores_numericos = valoresAnumeros(valores_cartas, valores_numericos); //TRADUCIMOS VALORES

        numeroFalta = numeroFalta(valores_numericos);

        if (numeroFalta > 10) {
        switch (numeroFalta) {
            case 11:
                letraFalta = "J";
                break;
            case 12:
                letraFalta = "Q";
                break;
            case 13:
                letraFalta = "K";
                break;
            case 14: 
                letraFalta = "A";
                break;
            default:
                break;
        }
    }

        palosIguales = tipoCartas(palos_cartas);    //Comparamos los distintos tipos


        if (!palosIguales) {
        	
        System.out.println("NADA");     
        
        } else if(numeroFalta == 0){
        	
        System.out.println("NADA");  
        
        } else if (numeroFalta > 10){
        	
        System.out.println(letraFalta.toUpperCase() + " " + palos_cartas[0].toUpperCase());
        
         } else {
        System.out.println(numeroFalta + " " + palos_cartas[0].toUpperCase());
        }
     
	}
        
    } while (!salir);
    
    
    

    }
}
