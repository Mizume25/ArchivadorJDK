package sdlc;

//Imports de ArrayList y list
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class test {
	
	static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		// 1º Lista Principal
		List<Equipo> lista = new ArrayList<>();
		List<Equipo> randomList = new ArrayList<>();
		
		try {
			ConsolaUtils.efectoCarga("Conectando con la base de datos de equipos");
			
			//Creamos el objeto "HandlerData"
			HandlerData Eq = new HandlerData();
			
			lista = Eq.cargarEquipos(); //Construira los equipos
			
			System.out.println("Selección completada.");
			
			
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		
		// 2º For each
		System.out.println("Equipos cargado:");
		
		for (Equipo eq : lista) {
		    System.out.println(eq.getNombre());
		}
		
		int randomNum = 0;
		
		//Escoge un numero random
		System.out.println("==Generar Lista Random de equipos==\n");
		System.out.println("Introduce equipos a analizar + "
				+ "\n Debe haber minimo 5 equipos a analizar"
				+ "\n Debe haber maximo 20 equipos a analizar"
				+ "\n Escribe el numero de equipos:");
		randomNum = sc.nextInt();
		
		
		try {
			
			
			randomList = Service.randomEquipo(lista, randomNum);
			
			System.out.println("Selección completada.");
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		System.out.println("Equipos Random Seleccionados en base al numero " + randomNum);
		for (Equipo eq : randomList) {
			 System.out.println(eq.getNombre());
		}
		
		
		
	}

}
