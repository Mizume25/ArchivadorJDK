package OOP.basic;

public class Persona {
    private String nombre;
    private int edad;
    public Persona(String nombreEntrante, int edadEntrante) {
        this.nombre = nombreEntrante;
        this.edad = edadEntrante;
    }

    public String getName(){
        return this.nombre.toUpperCase();
    }
    public void saludar() {
        System.out.println("Hola, mi nombre es " + this.nombre + " y tengo " + this.edad + " años.");
    }
}


