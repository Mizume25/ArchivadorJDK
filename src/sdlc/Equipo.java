package sdlc;

public class Equipo {
    
    private int id;
    private String nombre;

    // Constructor vacío (Obligatorio para que GSON funcione)
    public Equipo() {}

    // Getters y Setters (Para que el resto del programa pueda leer los datos)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) throws Exception {
    	if(nombre.isEmpty()) throw new Exception ("[Error] - El nombre no puede estar vacio");
        this.nombre = nombre;
    }
}
