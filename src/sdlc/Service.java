package sdlc;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class Service {

	// FUNCIONES DE LÓGICA Y EDICION

	public static List<Equipo> randomEquipo(List<Equipo> lista, int numUsuario) throws Exception {

		if (lista == null)
			throw new Exception("[Error] - No puede haber listas vacias");

		if (numUsuario < 5 || numUsuario > 20)
			throw new Exception("[Error] - Hay un problema con la cantidad de equipos solicitados");

		// Creamos un objeto Random
		Random rand = new Random();
		List<Equipo> otraLista = new ArrayList<>();

		// LLenamos otra lista
		while (otraLista.size() < numUsuario) {

			// Obtenemos un random en el espacio de lista
			int idRandom = rand.nextInt(20) + 1;

			// Creamos un objeto del id unico
			Equipo eq = lista.get(idRandom);

			// Solo si no contiene al equipo, lo añadiremos
			if (!otraLista.contains(idRandom))
				otraLista.add(eq);

		}

		// Retornamos la lista
		return otraLista;

	}
	
	
	
}
