package actividades.basico;
import java.util.Scanner;
import java.util.Random;

public class Act13 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        
        // Variables para llevar control de las caras que ya salieron
        boolean cara1 = false;
        boolean cara2 = false;
        boolean cara3 = false;
        boolean cara4 = false;
        boolean cara5 = false;
        boolean cara6 = false;
        
        int intentos = 0;
        int numeroDado;
        
        System.out.println("=== JUEGO DEL DADO COMPLETO ===");
        System.out.println("Objetivo: Obtener todas las caras del 1 al 6");
        System.out.println("Presiona Enter después de cada lanzamiento...");
        System.out.println("=================================");
        
        // Bucle principal hasta tener todas las caras
        while (!(cara1 && cara2 && cara3 && cara4 && cara5 && cara6)) {
            intentos++;
            
            // Generar número aleatorio de 1 a 6
            numeroDado = random.nextInt(6) + 1;
            
            // Marcar la cara obtenida como conseguida
            switch (numeroDado) {
                case 1:
                    cara1 = true;
                    break;
                case 2:
                    cara2 = true;
                    break;
                case 3:
                    cara3 = true;
                    break;
                case 4:
                    cara4 = true;
                    break;
                case 5:
                    cara5 = true;
                    break;
                case 6:
                    cara6 = true;
                    break;
            }
            
            // Mostrar las caras que faltan
            System.out.print("Caras que te faltan: ");
            
            if (!cara1) {
                System.out.print("1 ");
            }
            if (!cara2) {
                System.out.print("2 ");
            }
            if (!cara3) {
                System.out.print("3 ");
            }
            if (!cara4) {
                System.out.print("4 ");
            }
            if (!cara5) {
                System.out.print("5 ");
            }
            if (!cara6) {
                System.out.print("6 ");
            }
            
            // Verificar si ya tenemos todas
            if (cara1 && cara2 && cara3 && cara4 && cara5 && cara6) {
                System.out.println("NINGUNA - ¡COMPLETADO!");
            } else {
                System.out.println(); // Salto de línea
            }
            
            // Esperar a que el usuario presione Enter
            System.out.println("\nPresiona Enter para continuar...");
            scanner.nextLine();
        }
        
        // Mensaje final
        System.out.println("\n=================================");
        System.out.println("¡FELICIDADES! Has completado todas las caras");
        System.out.println("Total de lanzamientos: " + intentos);
        System.out.println("=================================");
        
        scanner.close();
    }
}
