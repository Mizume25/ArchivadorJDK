package actividades.avanzadas;
public class Act8 {
    
    // Clase interna ESTÁTICA
    public static class Persona {
        private String nombre;
        private int edad;
        
        public Persona(String nombre, int edad) {
            this.nombre = nombre;
            this.edad = edad;
        }
    }
    
    public static void main(String[] args) {
        // ✅ Ahora funciona
        Persona p = new Persona("Ana", 100);
        
        int edad = p.edad;
        String nombre = p.nombre;
        
        System.out.println(edad);
        System.out.println(nombre);
        
    }
}
