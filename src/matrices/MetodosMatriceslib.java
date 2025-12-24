package matrices;

import java.util.Random;
import java.util.Scanner;

public class MetodosMatriceslib {
    // PUBLIC SCANNER
    static Scanner sc = new Scanner(System.in);
    static Random rand = new Random();

    // ============================================
    // SECCIÓN 1: MÉTODOS DE ENTRADA/SALIDA (I/O)
    // ============================================

    // MÉTODO: LLENA LA MATRIZ AUTOMATICAMENTE CON NUMEROS RANDOM
    // PARÁMETROS: 1 matriz int
    public static void llenarMatrizRandom(int[][] tabla, int rangoRandom, int fil, int col) {
        for (int fila = fil; fila < tabla.length; fila++) {
            for (int columna = col; columna < tabla[fila].length; columna++) {
                tabla[fila][columna] = rand.nextInt(rangoRandom);
            }
        }
    }

    // MÉTODO: LLENA LA PRIMERA COLUMNA CON NUMEROS AUTOINCREMENTADOS QUE REPRESENTAN ID'S
    // PARÁMETROS: 1 matriz int
    public static void idsAutoIncrementadas(int[][] tabla) {
        int id = 1;
        
        for (int i = 0; i < tabla.length; i++) {
            tabla[i][0] = id;
            id++;
        }
    }

    // ============================================
    // SECCIÓN 2: MÉTODOS DE MOSTRAR DATOS
    // ============================================

    // MÉTODO: IMPRIME LA MATRIZ COMPLETA
    // PARÁMETROS: 1 matriz de int
    public static void mostrarMatriz(int[][] tabla) {
        for (int fila = 0; fila < tabla.length; fila++) {
            for (int columna = 0; columna < tabla[fila].length; columna++) {
                System.out.print(tabla[fila][columna] + " ");
            }
            System.out.println();
        }
    }

    // MÉTODO: IMRPIME MATRIZ CON 2 LISTAS DE NOMBRES QUE REPRESENTAN FILAS Y COLUMNAS
    // PARÁMETROS: MATRIZ, ARRAY NOMBREFILAS, ARRAY NOMBRE COLUMNAS, STRING TITULO PRINCIPAL
    public static void mostrarTablaNombre(int[][] tabla, String[] nombresFilas, String[] nombresColumnas, String tituloTabla) {
        int margenDerecho = 2;
        int margenIzquierdo = 1;
        
        int anchoFilas = 0;
        for (String nombre : nombresFilas) {
            if (nombre.length() > anchoFilas) {
                anchoFilas = nombre.length();
            }
        }
        anchoFilas += margenDerecho;
        
        int numColumnas = nombresColumnas.length;
        int[] anchosColumnas = new int[numColumnas];
        
        for (int j = 0; j < numColumnas; j++) {
            anchosColumnas[j] = nombresColumnas[j].length();
        }
        
        for (int i = 0; i < tabla.length; i++) {
            for (int j = 0; j < numColumnas; j++) {
                String valorStr = String.valueOf(tabla[i][j]);
                if (valorStr.length() > anchosColumnas[j]) {
                    anchosColumnas[j] = valorStr.length();
                }
            }
        }
        
        for (int j = 0; j < numColumnas; j++) {
            anchosColumnas[j] += margenIzquierdo + margenDerecho;
        }
        
        System.out.println("\n╔══════════════════════════════════════════╗");
        System.out.println("║         " + tituloTabla + "         ║");
        System.out.println("╚══════════════════════════════════════════╝\n");
        
        System.out.printf("%" + anchoFilas + "s", "");
        
        for (int j = 0; j < numColumnas; j++) {
            String nombreColumna = nombresColumnas[j];
            int espaciosIzq = (anchosColumnas[j] - nombreColumna.length()) / 2;
            int espaciosDer = anchosColumnas[j] - nombreColumna.length() - espaciosIzq;
            
            System.out.printf("%" + espaciosIzq + "s%s%" + espaciosDer + "s", "", nombreColumna, "");
        }
        System.out.println();
        
        int totalAncho = anchoFilas;
        for (int ancho : anchosColumnas) {
            totalAncho += ancho;
        }
        
        for (int k = 0; k < totalAncho; k++) {
            System.out.print("═");
        }
        System.out.println();
        
        for (int i = 0; i < tabla.length; i++) {
            System.out.printf("%-" + anchoFilas + "s", nombresFilas[i]);
            
            for (int j = 0; j < numColumnas; j++) {
                String valorStr = String.valueOf(tabla[i][j]);
                int espaciosIzq = (anchosColumnas[j] - valorStr.length()) / 2;
                int espaciosDer = anchosColumnas[j] - valorStr.length() - espaciosIzq;
                
                System.out.printf("%" + espaciosIzq + "s%s%" + espaciosDer + "s", "", valorStr, "");
            }
            System.out.println();
        }
        
        for (int k = 0; k < totalAncho; k++) {
            System.out.print("═");
        }
        System.out.println("\n");
    }

    // MÉTODO: MOSTRAR MATRIZ CON FORMATO DE TABLA CON INCREMENTADOS DE FILAS Y ESTUDIANTES
    // PARÁMETROS: MATRIZ, STRING PREFIJO FILAS, STRING PREFIJO COLUMNAS, TITULO
    public static void mostrarTablaPrefijos(int[][] tabla, String prefijoFila, String prefijoColumna, String encabezado) {
        int numFilas = tabla.length;
        int numColumnas = tabla[0].length;
        
        String ejemploFila = prefijoFila + " " + numFilas;
        int anchoFila = ejemploFila.length() + 2;
        
        int anchoColumna = 8;
        
        System.out.printf("%-" + anchoFila + "s", encabezado);
        
        for (int j = 0; j < numColumnas; j++) {
            System.out.printf("%-" + anchoColumna + "s", prefijoColumna + " " + (j + 1));
        }
        System.out.println();
        
        int totalAncho = anchoFila + (numColumnas * anchoColumna);
        for (int k = 0; k < totalAncho; k++) {
            System.out.print("-");
        }
        System.out.println();
        
        for (int i = 0; i < numFilas; i++) {
            System.out.printf("%-" + anchoFila + "s", prefijoFila + " " + (i + 1));
            
            for (int j = 0; j < numColumnas; j++) {
                System.out.printf("%-" + anchoColumna + "d", tabla[i][j]);
            }
            System.out.println();
        }
    }

    // MÉTODO: PREFIJOS AUTOINCREMENTADOS EN FILAS + LISTA DE NOMBRES EN COLUMNAS
    // PARÁMETROS: MATRIZ, STRING PREFIJO FILA, ARRAY NOMBRES COLUMNAS, STRING TITULO TABLA
    public static void mostrarTablaPrefijoFilas(int[][] tabla, String prefijoFila, String[] nombresColumnas, String tituloTabla) {
        if (tabla == null || nombresColumnas == null) {
            System.out.println("Error: Datos nulos");
            return;
        }
        
        int numFilas = tabla.length;
        int numColumnas = tabla[0].length;
        
        if (nombresColumnas.length != numColumnas) {
            System.out.println("Error: Número de nombres de columnas no coincide");
            return;
        }
        
        String ejemploFila = prefijoFila + " " + numFilas;
        int anchoFila = ejemploFila.length() + 2;
        
        int[] anchosColumnas = new int[numColumnas];
        int margenColumna = 2;
        
        for (int j = 0; j < numColumnas; j++) {
            anchosColumnas[j] = nombresColumnas[j].length() + margenColumna;
        }
        
        for (int i = 0; i < numFilas; i++) {
            for (int j = 0; j < numColumnas; j++) {
                String valorStr = String.valueOf(tabla[i][j]);
                if (valorStr.length() + margenColumna > anchosColumnas[j]) {
                    anchosColumnas[j] = valorStr.length() + margenColumna;
                }
            }
        }
        
        if (tituloTabla != null && !tituloTabla.isEmpty()) {
            System.out.println("\n" + tituloTabla);
        }
        
        System.out.printf("%-" + anchoFila + "s", " ");
        
        for (int j = 0; j < numColumnas; j++) {
            System.out.printf("%-" + anchosColumnas[j] + "s", nombresColumnas[j]);
        }
        System.out.println();
        
        int totalAncho = anchoFila;
        for (int ancho : anchosColumnas) {
            totalAncho += ancho;
        }
        
        for (int k = 0; k < totalAncho; k++) {
            System.out.print("-");
        }
        System.out.println();
        
        for (int i = 0; i < numFilas; i++) {
            System.out.printf("%-" + anchoFila + "s", prefijoFila + " " + (i + 1));
            
            for (int j = 0; j < numColumnas; j++) {
                System.out.printf("%-" + anchosColumnas[j] + "d", tabla[i][j]);
            }
            System.out.println();
        }
        
        for (int k = 0; k < totalAncho; k++) {
            System.out.print("-");
        }
        System.out.println();
    }

    // MÉTODO: LISTA DE NOMBRES EN FILAS + PREFIJOS AUTOINCREMENTADOS EN COLUMNAS
    // PARÁMETROS: MATRIZ, ARRAY NOMBRES FILAS, STRING PREFIJO COLUMNA, STRING TITULO TABLA
    public static void mostrarTablaPrefijoColumnas(int[][] tabla, String[] nombresFilas, String prefijoColumna, String tituloTabla) {
        if (tabla == null || nombresFilas == null) {
            System.out.println("Error: Datos nulos");
            return;
        }
        
        int numFilas = tabla.length;
        int numColumnas = tabla[0].length;
        
        if (nombresFilas.length != numFilas) {
            System.out.println("Error: Número de nombres de filas no coincide");
            return;
        }
        
        int anchoFila = 0;
        int margenFila = 2;
        
        for (String nombre : nombresFilas) {
            if (nombre.length() + margenFila > anchoFila) {
                anchoFila = nombre.length() + margenFila;
            }
        }
        
        String ejemploColumna = prefijoColumna + " " + numColumnas;
        int anchoColumnaBase = ejemploColumna.length() + 2;
        
        int anchoPorDatos = 0;
        for (int i = 0; i < numFilas; i++) {
            for (int j = 0; j < numColumnas; j++) {
                String valorStr = String.valueOf(tabla[i][j]);
                if (valorStr.length() + 2 > anchoPorDatos) {
                    anchoPorDatos = valorStr.length() + 2;
                }
            }
        }
        
        int anchoColumna = Math.max(anchoColumnaBase, anchoPorDatos);
        
        if (tituloTabla != null && !tituloTabla.isEmpty()) {
            System.out.println("\n" + tituloTabla);
        }
        
        System.out.printf("%-" + anchoFila + "s", " ");
        
        for (int j = 0; j < numColumnas; j++) {
            System.out.printf("%-" + anchoColumna + "s", prefijoColumna + " " + (j + 1));
        }
        System.out.println();
        
        int totalAncho = anchoFila + (numColumnas * anchoColumna);
        for (int k = 0; k < totalAncho; k++) {
            System.out.print("-");
        }
        System.out.println();
        
        for (int i = 0; i < numFilas; i++) {
            System.out.printf("%-" + anchoFila + "s", nombresFilas[i]);
            
            for (int j = 0; j < numColumnas; j++) {
                System.out.printf("%-" + anchoColumna + "d", tabla[i][j]);
            }
            System.out.println();
        }
        
        for (int k = 0; k < totalAncho; k++) {
            System.out.print("-");
        }
        System.out.println();
    }

    // ============================================
    // SECCIÓN 3: MÉTODOS DE ORDENACIÓN
    // ============================================

    // MÉTODO: ORDENAR FILAS DE MATRIZ ASCENDENTE
    // PARÁMETROS: 1 matriz int
    public static void ordenarFilasMatrizAscendente(int[][] tabla) {
        if (tabla == null || tabla.length == 0) {
            return;
        }
        
        int n = tabla.length;
        int m = tabla[0].length;
        
        if (m < 2) {
            System.out.println("Error: La matriz debe tener al menos 2 columnas");
            return;
        }
        
        for (int i = 1; i < n; i++) {
            if (tabla[i].length != m) {
                System.out.println("Error: Las filas no tienen la misma longitud");
                return;
            }
        }
        
        int[] sumas = new int[n];
        
        for (int i = 0; i < n; i++) {
            int sumaFila = 0;
            for (int j = 1; j < m; j++) {
                sumaFila += tabla[i][j];
            }
            sumas[i] = sumaFila;
            
        }
        
        boolean cambios;
        do {
            cambios = false;
            for (int i = 0; i < n - 1; i++) {
                if (sumas[i] > sumas[i + 1]) {
                    int tempSuma = sumas[i];
                    sumas[i] = sumas[i + 1];
                    sumas[i + 1] = tempSuma;
                    
                    int[] tempFila = tabla[i];
                    tabla[i] = tabla[i + 1];
                    tabla[i + 1] = tempFila;
                    
                    cambios = true;
                }
            }
        } while (cambios);
        
        
    }

    // MÉTODO: ORDENAR FILAS DE MATRIZ DESCENDENTE
    // PARÁMETROS: 1 matriz int
    public static void ordenarFilasMatrizDescendente(int[][] tabla) {
        int n = tabla.length;
        int m = tabla[0].length;
        
        int[] sumas = new int[n];
        
        for (int i = 0; i < n; i++) {
            int sumaFila = 0;
            for (int j = 0; j < m; j++) {
                sumaFila += tabla[i][j];
            }
            sumas[i] = sumaFila;
        }
        
        boolean cambios;
        do {
            cambios = false;
            for (int i = 0; i < n - 1; i++) {
                if (sumas[i] < sumas[i + 1]) {
                    int tempSuma = sumas[i];
                    sumas[i] = sumas[i + 1];
                    sumas[i + 1] = tempSuma;
                    
                    int[] tempFila = tabla[i];
                    tabla[i] = tabla[i + 1];
                    tabla[i + 1] = tempFila;
                    
                    cambios = true;
                }
            }
        } while (cambios);
    }
    
 

    // MÉTODO: ORDENAR COLUMNA DE MATRIZ DESCENDENTE
    // PARÁMETROS: 1 matriz int, int columna
    public static void ordenarColumnaMatrizDescendente(int[][] tabla, int col) {
        boolean cambios;
        
        do {
            cambios = false;
            int filas = tabla.length - 1;
            int j = tabla.length - 2;
            
            while (j >= 0) {
                if (tabla[filas][col] > tabla[j][col]) {
                    int temp = tabla[filas][col];
                    tabla[filas][col] = tabla[j][col];
                    tabla[j][col] = temp;
                    
                    cambios = true;
                }
                
                filas--;
                j--;
            }
        } while (cambios);
    }

    // ============================================
    // SECCIÓN 4: CÁLCULOS MATEMÁTICOS
    // ============================================

    // SECCIÓN 4.1: CÁLCULOS ARITMÉTICOS

    // MÉTODO: SUMA TOTAL DE TODA LA MATRIZ COMPLETA
    // PARÁMETROS: 1 matriz int
    public static int sumaTotalMatriz(int[][] tabla) {
        int sumaTotal = 0;
        for (int fila = 0; fila < tabla.length; fila++) {
            for (int columna = 0; columna < tabla[fila].length; columna++) {
                sumaTotal += tabla[fila][columna];
            }
        }
        return sumaTotal;
    }

    // MÉTODO: SUMA FILAS DESDE LA COLUMNA DESEADA
    // PARÁMETROS: 1 array int, 1 matriz int, int columna
    public static void sumaFilasMatriz(int[] sumaFila, int[][] tabla, int col) {
        for (int fila = 0; fila < tabla.length; fila++) {
            sumaFila[fila] = 0;
            
            for (int columna = col; columna < tabla[fila].length; columna++) {
                sumaFila[fila] += tabla[fila][columna];
            }
        }
    }
    
	// MÉTODO: SUMA FILAS DESDE LA COLUMNA DESEADA
    // PARÁMETROS: 1 array int, 1 matriz int, int columna
    public static int sumaFilaMatriz( int[][] tabla, int fil) {
    	int sumaTotal = 0;
    	int filmax = fil + 1;
    	for (int fila = fil; fila < filmax; fila++) {
    		
    		sumaTotal = 0;
            
            for (int columna = 0; columna < tabla[fila].length; columna++) {
            	
            	sumaTotal += tabla[fila][columna];
            }
        }
    	
    	return sumaTotal;
    }
    // MÉTODO: SUMA COLUMNAS DE UNA MATRIZ
    // PARÁMETROS: 1 array int, 1 matriz int, int columna inicio, int máximo columnas
    public static void sumaColumnasMatriz(int[] sumaColumnas, int[][] tabla, int col, int maxColumnas) {
        for (int columna = col; columna < maxColumnas; columna++) {
            for (int fila = 0; fila < tabla.length; fila++) {
                if (columna < tabla[fila].length) {
                    sumaColumnas[columna] += tabla[fila][columna];
                }
            }
        }
    }

    // MÉTODO: SUMA UNA COLUMNA ESPECÍFICA DE UNA MATRIZ
    // PARÁMETROS: 1 matriz int, int columna
    public static int sumaColumnaMatriz(int[][] tabla, int col) {
        int sumaTotal = 0;
        int maxCol = col + 1;
        
        for (int columna = col; columna < maxCol; columna++) {
            for (int fila = 0; fila < tabla.length; fila++) {
                if (columna < tabla[fila].length) {
                    sumaTotal += tabla[fila][columna];
                }
            }
        }
        
        return sumaTotal;
    }

    // SECCIÓN 4.2: CÁLCULOS ESTADÍSTICOS

    // MÉTODO: ENCUENTRA EL VALOR MÁXIMO DE UNA MATRIZ COMPLETA
    // PARÁMETROS: 1 matriz int
    public static int valorMaxMatriz(int[][] tabla) {
        int valorMaximo = tabla[0][0];
        
        for (int filas = 0; filas < tabla.length; filas++) {
            for (int columnas = 0; columnas < tabla[filas].length; columnas++) {
                if (valorMaximo < tabla[filas][columnas]) {
                    valorMaximo = tabla[filas][columnas];
                }
            }
        }
        return valorMaximo;
    }

    // MÉTODO: ENCUENTRA EL VALOR MÍNIMO DE UNA MATRIZ COMPLETA
    // PARÁMETROS: 1 matriz int
    public static int valorMinMatriz(int[][] tabla) {
        int valorMinimo = tabla[0][0];
        
        for (int filas = 0; filas < tabla.length; filas++) {
            for (int columnas = 0; columnas < tabla[filas].length; columnas++) {
                if (valorMinimo > tabla[filas][columnas]) {
                    valorMinimo = tabla[filas][columnas];
                }
            }
        }
        return valorMinimo;
    }

    // MÉTODO: ENCUENTRA EL VALOR MÁXIMO DE UNA FILA
    // PARÁMETROS: 1 matriz int
    public static int valorMaxFila(int[][] tabla,int fil) {
    	
        int valorMaximo = tabla[fil][0];
        int maxFila = fil + 1;
        for (int filas = 0; filas < maxFila; filas++) {
        	
            for (int columnas = 0; columnas < tabla[filas].length; columnas++) {
            	
                if (valorMaximo < tabla[filas][columnas]) {
                    valorMaximo = tabla[filas][columnas];
                }
            }
        }
        return valorMaximo;
    }
    // MÉTODO: ENCUENTRA EL VALOR MÍNIMO DE UNA FILA
    // PARÁMETROS: 1 matriz int
    public static int valorMinFila(int[][] tabla,int fil) {
    	
        int valorMinimo = tabla[fil][0];
        int maxFila = fil + 1;
        for (int filas = 0; filas < maxFila; filas++) {
        	
            for (int columnas = 0; columnas < tabla[filas].length; columnas++) {
            	
                if (valorMinimo > tabla[filas][columnas]) {
                	valorMinimo = tabla[filas][columnas];
                }
            }
        }
        return valorMinimo;
    }
    
    // MÉTODO: ENCUENTRA EL VALOR MÁXIMO DE UNA FILA
    // PARÁMETROS: 1 matriz int
    public static int valorMaxColumna(int[][] tabla,int col) {
    	
        int valorMaximo = tabla[0][col];
        int maxCol = col + 1;
        for (int filas = 0; filas < tabla.length; filas++) {
        	
            for (int columnas = col; columnas < maxCol; columnas++) {
            	
                if (valorMaximo < tabla[filas][columnas]) {
                    valorMaximo = tabla[filas][columnas];
                }
            }
        }
        return valorMaximo;
    }
    
    // MÉTODO: ENCUENTRA EL VALOR MÁXIMO DE UNA FILA
    // PARÁMETROS: 1 matriz int
    public static int valorMinColumna(int[][] tabla,int col) {
    	
        int valorMin = tabla[0][col];
        int maxCol = col + 1;
        for (int filas = 0; filas < tabla.length; filas++) {
        	
            for (int columnas = col; columnas < maxCol; columnas++) {
            	
                if (valorMin > tabla[filas][columnas]) {
                	valorMin = tabla[filas][columnas];
                }
            }
        }
        return valorMin;
    }

    // ============================================
    // SECCIÓN 5: CONSULTA Y MANIPULACIONES DE MATRIZ
    // ============================================

    // MÉTODO: DETERMINA SI UN NÚMERO EXISTE EN LA MATRIZ O NO
    // PARÁMETROS: 1 matriz int, int número
    public static boolean buscarNumeroMatriz(int[][] tabla, int numero) {
        for (int filas = 0; filas < tabla.length; filas++) {
            for (int columnas = 0; columnas < tabla[filas].length; columnas++) {
                if (tabla[filas][columnas] == numero) {
                    return true;
                }
            }
        }
        return false;
    }

    // MÉTODO: CUENTA LAS VECES QUE APARECE UN NÚMERO REPETIDO
    // PARÁMETROS: 1 matriz int, int número
    public static int numeroRepetidoMatriz(int[][] tabla, int numero) {
        int contador = 0;
        
        for (int filas = 0; filas < tabla.length; filas++) {
            for (int columnas = 0; columnas < tabla[filas].length; columnas++) {
                if (tabla[filas][columnas] == numero) {
                    contador++;
                }
            }
        }
        return contador;
    }

    // MÉTODO: CUENTA LAS POSICIONES QUE APARECE UN NÚMERO REPETIDO
    // PARÁMETROS: 1 matriz int, int número, 1 array int posiciones
    public static void posicionesNumeroMatriz(int[][] tabla, int numero, int[] numPosiciones) {
        int i = 0;
        int j = 1;
        
        for (int filas = 0; filas < tabla.length; filas++) {
            for (int columnas = 0; columnas < tabla[filas].length; columnas++) {
                if (tabla[filas][columnas] == numero) {
                    numPosiciones[i] = filas;
                    numPosiciones[j] = columnas;
                    i += 2;
                    j += 2;
                }
            }
        }
    }

    // MÉTODO: INVERTIR MATRIZ HORIZONTALMENTE
    // PARÁMETROS: 1 matriz int origen, 1 matriz int destino
    public static void invertirHorizontal(int[][] tabla, int[][] tablaInvertida) {
        int filas = tabla.length;
        int columnas = tabla[0].length;
        
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                tablaInvertida[i][columnas - 1 - j] = tabla[i][j];
            }
        }
    }
}