package actividades.avanzadas;

import java.util.Scanner;

public class Demo {
    // DECLARAMOS SCANNER
    static Scanner sc = new Scanner(System.in);

    // 1º Funcion que incializa en valores vacios una matriz de Strings
    public static void inicializarTabla(String[][] tabla) {
        // RECORREMOS LA TABLA PARA DAR FORMATO
        for (int i = 0; i < tabla.length; i++) {

            for (int j = 0; j < tabla.length; j++) {
                tabla[i][j] = " ";
            }
            System.out.println();
        }
    }

    // 2º Funcion que le da formato de tabla
    public static void formatotabla(String[][] tabla) {
        // RECORREMOS LA TABLA PARA DAR FORMATO
        for (int i = 0; i < tabla.length; i++) {

            for (int j = 0; j < tabla.length; j++) {

                System.out.print("|" + tabla[i][j] + "|");
            }
            System.out.println();
        }
    }

    // 2º Inicializamos el menu Principal
    public static int menuPrincipal(boolean[] opciones, String jugador) {

        // Todas las opciones estan disponibles
        System.out.println("Menu de opciones de " + jugador + ":");

        for (int i = 0; i < opciones.length; i++) {
            if (opciones[i]) {
                System.out.print(" " + (i + 1) + ". Casilla");

                if ((i + 1) % 3 == 0) {
                    System.out.println();
                }
            }
        }

        System.out.println("\nEscoge una opcion: ");
        return sc.nextInt();

    }

    // 3º Actualizamos menus y devolvemos un false al array de booleans
    public static boolean actualizarMenu(boolean[] opciones, int opcion) {

        return opciones[opcion - 1] = false;
    }

    // 4º Funcion que introduce valor del jugador en la tabla
    public static void accionJugador(String[][] tabla, int opcion, String jugador) {

        switch (opcion) {
            case 1:
                if (tabla[0][0].contains(" "))
                    tabla[0][0] = jugador;

                // Opcion B: if tabla[0][0].equalObjecto(" ") pero no es lo mismo
                break;
            case 2:
                if (tabla[0][1].contains(" "))
                    tabla[0][1] = jugador;
                break;
            case 3:
                if (tabla[0][2].contains(" "))
                    tabla[0][2] = jugador;
                break;
            case 4:
                if (tabla[1][0].contains(" "))
                    tabla[1][0] = jugador;
                break;
            case 5:
                if (tabla[1][1].contains(" "))
                    tabla[1][1] = jugador;
                break;
            case 6:
                if (tabla[1][2].contains(" "))
                    tabla[1][2] = jugador;
                break;
            case 7:
                if (tabla[2][0].contains(" "))
                    tabla[2][0] = jugador;
                break;
            case 8:
                if (tabla[2][1].contains(" "))
                    tabla[2][1] = jugador;
                break;
            case 9:
                if (tabla[2][2].contains(" "))
                    tabla[2][2] = jugador;
                break;
            default:
                break;
        }

    }

    // 5º Funcion de inicio
    public static int menuInicio() {
        int n;

        do {

            System.out.println("¿Quien empieza?" +
                    "\n1. Jugador X" +
                    "\n2. Jugador O" +
                    "\nEscoge jugador [1-2]:");
            n = sc.nextInt();

        } while (n != 1 && n != 2);

        return (n - 1);

    }

    // 6º Funcion comprueba filas
    public static boolean comprobarfilas(String[][] tabla, String jugador) {

        boolean comprobacion = false;
        for (int i = 0; i < tabla.length; i++) {
            if (tabla[i][0].equals(jugador) && tabla[i][1].equals(jugador) && tabla[i][2].equals(jugador)) {
                comprobacion = true; // ¡3 en raya encontrado!
            }
        }

        return comprobacion;
    }

    // 7º Funcion que comprueba Columnas
    public static boolean comprobarColumnas(String[][] tabla, String jugador) {
        boolean comprobacion = false;
        for (int j = 0; j < tabla.length; j++) {
            if (tabla[0][j].equals(jugador) && tabla[1][j].equals(jugador) && tabla[2][j].equals(jugador)) {
                comprobacion = true; // ¡3 en raya encontrado!
            }
        }

        return comprobacion;

    }

    // 8º Funcion que comprueba Diagonal normal
    public static boolean comprobarDiagonal(String[][] tabla, String jugador) {
        boolean comprobacion = false;

        if (tabla[0][0].equals(jugador) && tabla[1][1].equals(jugador)
                && tabla[2][2].equals(jugador)) {
            comprobacion = true;
        }

        return comprobacion;

    }

    // 9º Funcion que comprueba Diagonal Reversa
    public static boolean comprobarDiagonalReversa(String[][] tabla, String jugador) {
        boolean comprobacion = false;

        if (tabla[0][2].equals(jugador) && tabla[1][1].equals(jugador)
                && tabla[2][0].equals(jugador)) {
            comprobacion = true;
        }

        return comprobacion;

    }

    // 9º Funcion que comprueba 3 en raya
    public static boolean tresEnRaya(String[][] tabla, String jugador) {

        return comprobarfilas(tabla, jugador) || comprobarColumnas(tabla, jugador)
                || comprobarDiagonal(tabla, jugador) || comprobarDiagonalReversa(tabla, jugador);

    }

    public static void main(String[] args) {
        // Matriz de 3 en raya

        // DECLARAMOS VARIABLES
        String[][] tabla = new String[3][3];
        boolean[] opciones = new boolean[9];
        int[] valoresRepetidos = new int[9];
        String[] jugador = { "X", "O" };
        int i = 0;
        int turno;
        boolean ganador;
        int opcion;


        // INICIALIZAMOS VARIABLES
        for (int j = 0; j < opciones.length; j++) {
            opciones[j] = true;
        }

        inicializarTabla(tabla);
        turno = 0;
        ganador = false;
        opcion = 0;

        // Menu del Juego
        System.out.println("==Demo 3 en raya==");
        i = menuInicio();
        do {

            formatotabla(tabla); //Mostramos tabla

            System.out.println(); // Salto de linea

            System.out.println("\n Turno " + (turno+1)); //Mostramos turno

            opcion = menuPrincipal(opciones, jugador[i]); // Mostramos menu de opciones

            //Comprobamos que en ningun momento excedra el limite de 9
            if (opcion > 9 || opcion < 1) {
                System.out.println("Solo existen 9 operaciones");
            } else {

                actualizarMenu(opciones, opcion); // Actualizamos Menu

                accionJugador(tabla, opcion, jugador[i]); //Ejecutamos accion del jugador

                //Comprobamos valores repetidos
                if (valoresRepetidos[opcion - 1] != opcion) {

                    turno++;    //Avanzamos turno

                    //Comprobamos solo en caso de tener mas o igual a 5
                    if (turno >= 5) {

                        ganador = tresEnRaya(tabla, jugador[i]);

                    }

                    i = i < 1 ? i + 1 : i - 1;  //Cambiamos jugador

                    //Guardamos los valores utilizados
                    valoresRepetidos[opcion - 1] = opcion;

                } else {
                    System.out.println("\n Hay valores repetidos");
                }



            }

        } while (turno < 9 && !ganador);    //ejecuta mientras no se acaben los turnos o no haya ganador

        //Cambiamos ultimo jugador
        i = i < 1 ? i + 1 : i - 1;

        //Mostramos tabla resultante
        formatotabla(tabla);

        //Mostramos Resultados
        System.out.println();
        if (!ganador) {
            System.out.println("Empate!");
        } else {
            System.out.println("3 en raya! el ganador es " + jugador[i] + " en tan solo " + turno + " turnos !");
        }

    }
}

