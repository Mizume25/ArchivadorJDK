package sdlc;

//Imports de Gson
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

//Imports para la gestion de archivos
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

//Imports para las estructura de datos
import java.lang.reflect.Type;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

//Import classe Random
import java.util.Random;

public class HandlerData {

	// Constante declarada: Java busca desde la raiz del proyecto
	private static final String NOMBRE_EQUIPOS = "src/lib/equipos.json";

	// Declaramos el objecto GSON
	private Gson gson;

	// Builder
	public HandlerData() {
		// PrettyPrinting para que el JSON de salida sea legible (con saltos de línea)
		this.gson = new GsonBuilder().setPrettyPrinting().create();
	}

	// 2. Construir lista de objectos del json
	public List<Equipo> cargarEquipos() throws Exception {

		List<Equipo> lista;

		// Objecto de la classe Filreader lee el archivo en formato UTF-8
		try (FileReader reader = new FileReader(NOMBRE_EQUIPOS, StandardCharsets.UTF_8)) {

			// Guardamos tipos
			Type listType = new TypeToken<ArrayList<Equipo>>() {
			}.getType();

			lista = gson.fromJson(reader, listType);

			if (lista == null)
				throw new Exception("[Error]: - La lista de nombres está vacía");

			// Retornamos lista
			return lista;

		} catch (IOException e) {
			System.err.println("[Error]: No se encontró " + NOMBRE_EQUIPOS);
			throw e;
		}

	}

	
}
