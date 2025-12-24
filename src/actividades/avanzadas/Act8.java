package actividades.avanzadas;

public class Act8 {
	// ============================================
	// DATOS FIJOS (NO CAMBIAN DURANTE EL PROGRAMA)
	// ============================================

	// DÍAS DE LA SEMANA (5 días fijos)
	String[] diasSemana = {"Lunes", "Martes", "Miércoles", "Jueves", "Viernes"};

	// HORARIOS (6 horas fijas)  
	String[] horas = {"8:00-9:00", "9:00-10:00", "10:00-11:00", "11:00-12:00", "12:00-13:00", "13:00-14:00"};

	// PROFESORES (8 profesores fijos)
	String[] profesores = {
	    "Prof. López",     // Código 1
	    "Prof. Martínez",  // Código 2  
	    "Prof. Rodríguez", // Código 3
	    "Prof. Gómez",     // Código 4
	    "Prof. Sánchez",   // Código 5
	    "Prof. Pérez",     // Código 6
	    "Prof. García",    // Código 7
	    "Prof. Fernández"  // Código 8
	};

	// AULAS (4 aulas fijas - aunque en este ejercicio simplificado
	// no diferenciamos entre aulas, todas son iguales)
	String[] aulas = {"Aula 101", "Aula 102", "Aula 103", "Aula 104"};

	// ============================================
	// DATOS DINÁMICOS (CAMBIAN DURANTE EJECUCIÓN)
	// ============================================

	// MATRIZ PRINCIPAL: reservas[dia][hora]
	// 5 días × 6 horas = 30 slots semanales
	// VALOR: 0 = libre, 1-8 = código de profesor
	int[][] reservas = new int[5][6];

	// CONTADORES para estadísticas (opcional, se pueden calcular cuando se necesiten)
	int[] horasPorProfesor = new int[8];  // Índice 0-7 para profesores 1-8
	int[] ocupacionPorDia = new int[5];   // Índice 0-4 para días 0-4

	// ============================================
	// EJEMPLO DE INICIALIZACIÓN (datos de ejemplo)
	// ============================================

	void inicializarReservasEjemplo() {
	    // Algunas reservas de ejemplo para empezar
	    reservas[0][0] = 1; // Lunes 8:00 - Prof. López (código 1)
	    reservas[0][2] = 4; // Lunes 10:00 - Prof. Gómez (código 4)
	    reservas[0][4] = 6; // Lunes 12:00 - Prof. Pérez (código 6)
	    
	    reservas[1][1] = 2; // Martes 9:00 - Prof. Martínez (código 2)
	    reservas[1][5] = 7; // Martes 13:00 - Prof. García (código 7)
	    
	    reservas[3][0] = 4; // Jueves 8:00 - Prof. Gómez (código 4)
	    reservas[3][3] = 2; // Jueves 11:00 - Prof. Martínez (código 2)
	    
	    reservas[4][1] = 6; // Viernes 9:00 - Prof. Pérez (código 6)
	    reservas[4][4] = 7; // Viernes 12:00 - Prof. García (código 7)
	    
	    // El resto de celdas quedan en 0 (libres)
	}

	// ============================================
	// FUNCIÓN PARA MOSTRAR TABLA (ejemplo)
	// ============================================

	void mostrarTablaReservas() {
	    System.out.println("\nRESERVAS DE AULAS - SEMANA ACTUAL");
	    System.out.println("═══════════════════════════════════════════════");
	    
	    // Encabezado de horas
	    System.out.print("        ");
	    for (String hora : horas) {
	        System.out.printf("%-7s", hora.substring(0, 5)); // Muestra solo "8:00-"
	    }
	    System.out.println();
	    
	    // Filas para cada día
	    for (int dia = 0; dia < 5; dia++) {
	        System.out.printf("%-8s", diasSemana[dia]);
	        
	        for (int hora = 0; hora < 6; hora++) {
	            int codigoProf = reservas[dia][hora];
	            if (codigoProf == 0) {
	                System.out.print("Libre  ");
	            } else {
	                // Mostrar apellido del profesor (primera palabra después de "Prof. ")
	                String nombreCompleto = profesores[codigoProf - 1];
	                String apellido = nombreCompleto.substring(6); // Quita "Prof. "
	                System.out.printf("%-7s", apellido);
	            }
	        }
	        System.out.println();
	    }
	    
	    System.out.println("═══════════════════════════════════════════════");
	    System.out.println("Leyenda: Apellido = Aula reservada por ese profesor");
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
