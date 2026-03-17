package lib;

import java.util.Random;
import java.util.Scanner;

public class Arraylib {

    static Scanner sc = new Scanner(System.in);
    static Random rand = new Random();

    /////////////////////////////////////////////
    ///// METODOS DE LLENADO DE DATOS////////////
    /////////////////////////////////////////////

    public static void fillInput(String text, int[] num) throws Exception {
        if (num == null) throw new Exception("El array de enteros no puede ser nulo.");
        if (text == null || text.isEmpty()) throw new Exception("El texto de indicación no puede estar vacío.");
        
        System.out.print(text + ":");
        for (int i = 0; i < num.length; i++) {
            num[i] = sc.nextInt();
        }
        System.out.println(); 
    }

    public static void fillInput(String text, double[] num) throws Exception {
        if (num == null) throw new Exception("El array de doubles no puede ser nulo.");
        if (text == null || text.isEmpty()) throw new Exception("El texto de indicación no puede estar vacío.");
        
        System.out.print(text + ":");
        for (int i = 0; i < num.length; i++) {
            num[i] = sc.nextDouble();
        }
        System.out.println(); 
    }

    public static void fillRandom(int[] array, int numberRange) throws Exception {
        if (array == null || array.length == 0) throw new Exception("Array no válido para llenar con aleatorios.");
        if (numberRange <= 0) throw new Exception("El rango para aleatorios debe ser mayor que 0.");
        
        for (int i = 0; i < array.length; i++) {
            array[i] = rand.nextInt(numberRange) + 1;
        }
    }
    
    public static void fillSequence(int[] array, int secuencia) throws Exception {
        if (array == null) throw new Exception("El array de destino es nulo.");
        if (secuencia < 0) throw new Exception("La secuencia no puede ser negativa.");
        
        int i = array.length - 1;
        int temp = secuencia;
        
        while (temp > 0 && i >= 0) {
            array[i] = temp % 10; 
            temp /= 10; 
            i--; 
        }
    }
    
    public static int[] computeArray(int sequence) throws Exception {
        int size = computeSize(sequence);
        int[] result = new int[size];
        fillSequence(result, sequence);
        return result; 
    }
    
    /////////////////////////////////////////////
    ///// METODOS MANIPULACION DE ARRAYS/////////
    /////////////////////////////////////////////

    public static int [] reverse(int[] array) throws Exception {
        if (array == null) throw new Exception("No se puede invertir un array nulo.");
        
        int [] arr = new int [array.length]; 
        int j = arr.length - 1; 
        
        for (int i = 0; i < array.length; i++) {
            arr[j] = array[i]; 
            j--; 
        }
        return arr;
    }

    public static boolean exists(int[] array, int find) throws Exception {
        if (array == null) throw new Exception("El array de búsqueda es nulo.");
        
        for (int i = 0; i < array.length; i++) {
            if (array[i] == find) return true;
        }
        return false;
    }
    
    /////////////////////////////////////////////
    ///// METODOS DE CALCULO Y ESTADISTICA///////
    /////////////////////////////////////////////
    
    public static int computeSize(int n) {
        if(n == 0) return 1;
        int cont = 0; 
        long sequence = Math.abs((long)n);
        
        while (sequence > 0) {
            cont++; 
            sequence = sequence / 10; 
        }
        return cont;
    }

    public static int cont (int[] array, int find) throws Exception {
        if (array == null) throw new Exception("Array nulo en la operación de conteo.");
        
        int cont = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == find) cont++;
        }
        return cont;
    }

    public static int sumTotal(int[] array) throws Exception {
        if (array == null || array.length == 0) throw new Exception("No se puede sumar un array nulo o vacío.");
        
        int sumValue = 0;
        for (int i = 0; i < array.length; i++) {
            sumValue += array[i];
        }
        return sumValue;
    }

    public static double avgArray(double[] array) throws Exception {
        if (array == null || array.length == 0) throw new Exception("No se puede calcular el promedio de un array nulo o vacío.");
        
        double suma = 0;
        for (double val : array) suma += val;
        return (suma / array.length);
    }

    public static double maxValue(double[] array) throws Exception {
        if (array == null || array.length == 0) throw new Exception("Array nulo o vacío al buscar valor máximo.");

        double valorMax = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] > valorMax) valorMax = array[i];
        }
        return valorMax;
    }
    
    public static int maxValue(int[] array) throws Exception {
        if (array == null || array.length == 0) throw new Exception("Array nulo o vacío al buscar valor máximo.");
      
        int valorMax = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] > valorMax) valorMax = array[i];
        }
        return valorMax;
    }
    
    public static int minValue(int[] array) throws Exception {
        if (array == null || array.length == 0) throw new Exception("Array nulo o vacío al buscar valor mínimo."); 

        int min = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] < min) min = array[i]; 
        }
        return min; 
    }
    
    /////////////////////////////////////////////
    ///// METODOS DE IMPRESIÓN //////////////////
    /////////////////////////////////////////////
   
    public static void printArray(int[] num) throws Exception {
        if (num == null) throw new Exception("No se puede imprimir un array nulo.");
        
        System.out.print("[");
        for (int i = 0; i < num.length; i++) {
            System.out.print(num[i]);
            if (i < num.length - 1) System.out.print(", ");
        }
        System.out.println("]");
    }

    public static void printArray(String[] text) throws Exception {
        if (text == null) throw new Exception("No se puede imprimir un array de Strings nulo.");

        System.out.print("[");
        for (int i = 0; i < text.length; i++) {
            System.out.print(text[i]);
            if (i < text.length - 1) System.out.print(", ");
        }
        System.out.println("]");
    }

    public static void printArray(double[] array, int decimals) throws Exception {
        if (array == null) throw new Exception("Array de doubles nulo.");
        if (decimals < 0) throw new Exception("El número de decimales no puede ser negativo.");

        String format = "%." + decimals + "f ";
        for (double value : array) {
            System.out.printf(format, value);
        }
        System.out.println(); 
    }

    public static void printArray(int[] array, String text) throws Exception {
        if (array == null) throw new Exception("Array nulo.");
        
        for (int i = 0; i < array.length; i++) {
            System.out.printf("%s%d: %d€%n", text, (i + 1), array[i]);
        }
    }

    public static void printArray(int[] array, String[] listNames, String text) throws Exception {
        if (array == null || listNames == null) throw new Exception("Arrays nulos en impresión personalizada.");
        if (array.length != listNames.length) throw new Exception("Los arrays de datos y nombres deben tener el mismo tamaño.");
        
        for (int i = 0; i < array.length; i++) {
            System.out.printf("%s%s: %d€%n", text, listNames[i], array[i]);
        }
    }

    public static void printArray(double[] values, String prefix, int decimals) throws Exception {
        if (values == null) throw new Exception("Valores nulos.");
        if (prefix == null) throw new Exception("Prefijo nulo.");
        
        String format = "%s #%d: %." + decimals + "f%n";
        for (int i = 0; i < values.length; i++) {
            System.out.printf(format, prefix, (i + 1), values[i]);
        }
    }

    public static void printArray(double[] array, String titulo) throws Exception {
        if (array == null) throw new Exception("Array nulo.");
        
        for (int i = 0; i < array.length; i++) {
            System.out.printf("%s%d [%.2f%%] ", titulo, (i + 1), array[i]);
            for (int j = 0; j < (int)array[i]; j++) {
                System.out.print("*");
            }
            System.out.println(); 
        }
    }
}