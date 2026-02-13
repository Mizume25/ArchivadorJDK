package sdlc;

public class ConsolaUtils {
	
	public static void mostrarCarga(String mensaje) {
	    System.out.print(mensaje);
	    try {
	        for (int i = 0; i < 3; i++) {
	            Thread.sleep(500); // Espera medio segundo
	            System.out.print(".");
	        }
	        System.out.println(" ¡Listo!");
	    } catch (InterruptedException e) {
	        // En programas serios aquí se gestiona la interrupción
	    }
	}
	
	public static void efectoCarga(String mensaje) {
	    System.out.print(mensaje);
	    for (int i = 0; i < 3; i++) {
	        // En lugar de esperar(500), ponemos esto directamente:
	        try {
	            Thread.sleep(500); 
	        } catch (InterruptedException e) {
	            // Ignorar
	        }
	        System.out.print(".");
	    }
	    System.out.println(" ✅");
	}
}
