package lib;

import java.util.Random;
import java.util.Scanner;

public class Matriceslib {

    static Scanner sc = new Scanner(System.in);
    static Random rand = new Random();

    //////////////////////////////////////
    ///// METODOS DE DE ORDENACIÓN///////
    /////////////////////////////////////

    public static void sortByRowSum(int[][] table, boolean desc) {
		if (table == null || table.length < 2)
			return;

		int n = table.length;
		int[] sumas = new int[n];

		for (int i = 0; i < n; i++) {
			int sumaFila = 0;
			if (table[i] != null) {
				for (int valor : table[i]) {
					sumaFila += valor;
				}
			}
			sumas[i] = sumaFila;
		}

		boolean cambios;
		do {
			cambios = false;
			for (int i = 0; i < n - 1; i++) {

				boolean condicion = desc ? (sumas[i] < sumas[i + 1]) : (sumas[i] > sumas[i + 1]);

				if (condicion) {

					int tempSuma = sumas[i];
					sumas[i] = sumas[i + 1];
					sumas[i + 1] = tempSuma;

					int[] tempFila = table[i];
					table[i] = table[i + 1];
					table[i + 1] = tempFila;

					cambios = true;
				}
			}
		} while (cambios);
	}
    
    
    public static void sortByColumn(int[][] table, int col, boolean desc) {
		if (table == null || table.length < 2)
			return;

		boolean cambios;
		int n = table.length;

		do {
			cambios = false;
			for (int i = 0; i < n - 1; i++) {

				if (col < table[i].length && col < table[i + 1].length) {

					boolean condicion = desc ? (table[i][col] < table[i + 1][col])
							: (table[i][col] > table[i + 1][col]);

					if (condicion) {
						int temp = table[i][col];
						table[i][col] = table[i + 1][col];
						table[i + 1][col] = temp;
						cambios = true;
					}
				}
			}
		} while (cambios);
	}

    /////////////////////////////////////////////
    ///// METODOS DE CALCULO DE VALORES//////////
    /////////////////////////////////////////////

    public static int sumTotal(int[][] table) throws Exception {
        if (table == null) throw new Exception("Matriz nula.");
        int sumaTotal = 0;
        for (int[] fila : table) {
            for (int valor : fila) sumaTotal += valor;
        }
        return sumaTotal;
    }

    public static int sumRows(int[][] table, int row) throws Exception {
        if (table == null || row < 0 || row >= table.length) throw new Exception("Fila fuera de rango.");
        int total = 0;
        for (int valor : table[row]) total += valor;
        return total;
    }

    public static void sumRows(int[] sumaFila, int[][] table) throws Exception {
        if (table == null || sumaFila == null) throw new Exception("Arrays nulos.");
        for (int row = 0; row < table.length; row++) {
            sumaFila[row] = sumRows(table, row);
        }
    }

    public static void sumRows(int[] sumaFila, char[][] table, int col) throws Exception {
        if (table == null || sumaFila == null) throw new Exception("Arrays nulos.");
        for (int row = 0; row < table.length; row++) {
            sumaFila[row] = 0;
            for (int columna = col; columna < table[row].length; columna++) sumaFila[row]++;
        }
    }

    public static void sumColumns(int[][] table, int[] sumColumns) throws Exception {
        if (table == null || sumColumns == null) throw new Exception("Arrays nulos.");
        int numCols = table[0].length;
        for (int j = 0; j < numCols; j++) {
            int total = 0;
            for (int i = 0; i < table.length; i++) {
                if (j < table[i].length) total += table[i][j];
            }
            sumColumns[j] = total;
        }
    }

    public static int sumColumns(int[][] table, int col) throws Exception {
        if (table == null || col < 0) throw new Exception("Parámetros inválidos.");
        int total = 0;
        for (int i = 0; i < table.length; i++) {
            if (col < table[i].length) total += table[i][col];
        }
        return total;
    }

    public static int maxValue(int[][] table) throws Exception {
        if (table == null || table.length == 0) throw new Exception("Matriz vacía.");
        int max = table[0][0];
        for (int[] fila : table) {
            for (int v : fila) if (v > max) max = v;
        }
        return max;
    }

    public static int minValue(int[][] table) throws Exception {
        if (table == null || table.length == 0) throw new Exception("Matriz vacía.");
        int min = table[0][0];
        for (int[] fila : table) {
            for (int v : fila) if (v < min) min = v;
        }
        return min;
    }

    public static boolean exists(int[][] table, int numero) throws Exception {
        if (table == null) throw new Exception("Matriz nula.");
        for (int[] fila : table) {
            for (int v : fila) if (v == numero) return true;
        }
        return false;
    }

    public static int count(int[][] table, int numero) throws Exception {
        if (table == null) throw new Exception("Matriz nula.");
        int cont = 0;
        for (int[] fila : table) {
            for (int v : fila) if (v == numero) cont++;
        }
        return cont;
    }

    public static void getPositions(int[][] tabla, int numero, int[] positions) throws Exception {
        if (tabla == null || positions == null) throw new Exception("Arrays nulos.");
        int p = 0;
        for (int r = 0; r < tabla.length; r++) {
            for (int c = 0; c < tabla[r].length; c++) {
                if (tabla[r][c] == numero && p < positions.length - 1) {
                    positions[p++] = r;
                    positions[p++] = c;
                }
            }
        }
    }

    /////////////////////////////////////////////
    ///// LLENADO E IMPRESIÓN ///////////////////
    /////////////////////////////////////////////

    public static void fillRandom(int[][] table, int range, int row, int col) throws Exception {
        if (table == null) throw new Exception("Matriz nula.");
        for (int r = row; r < table.length; r++) {
            for (int c = (r == row ? col : 0); c < table[r].length; c++) {
                table[r][c] = rand.nextInt(range) + 1;
            }
        }
    }

    public static void fillSequence(int[][] table, int min, int row, int col) throws Exception {
        if (table == null) throw new Exception("Matriz nula.");
        for (int r = row; r < table.length; r++) {
            for (int c = (r == row ? col : 0); c < table[r].length; c++) {
                table[r][c] = min++;
            }
        }
    }

    public static void printMatrix(int[][] tabla) throws Exception {
        if (tabla == null) throw new Exception("Matriz nula.");
        for (int[] fila : tabla) {
            for (int v : fila) System.out.print(v + "\t");
            System.out.println();
        }
    }

    /////////////////////////////////////////////
    ///// FORMATOS DE TABLA (DISPLAY) ///////////
    /////////////////////////////////////////////

    public static void display(int[][] table, String[] rowNames, String[] colNames, String title) throws Exception {
        if (!isValid(table, rowNames, colNames)) throw new Exception("Datos de visualización inválidos.");
        
        int rowWidth = getMaxWidth(rowNames) + 2;
        int[] colWidths = getColWidths(table, colNames);

        printTitleBox(title);
        System.out.printf("%" + rowWidth + "s", "");
        for (int j = 0; j < colNames.length; j++) printCentered(colNames[j], colWidths[j]);
        System.out.println();
        printSeparator(rowWidth, colWidths, '═');

        for (int i = 0; i < table.length; i++) {
            System.out.printf("%-" + rowWidth + "s", rowNames[i]);
            for (int j = 0; j < table[i].length; j++) printCentered(String.valueOf(table[i][j]), colWidths[j]);
            System.out.println();
        }
        printSeparator(rowWidth, colWidths, '═');
    }

    public static void display(int[][] table, String rowPref, String colPref, String title) throws Exception {
        if (table == null) throw new Exception("Matriz nula.");
        String[] rN = new String[table.length];
        for (int i = 0; i < rN.length; i++) rN[i] = rowPref + " " + (i + 1);
        int mC = 0;
        for (int[] r : table) mC = Math.max(mC, r.length);
        String[] cN = new String[mC];
        for (int j = 0; j < mC; j++) cN[j] = colPref + " " + (j + 1);
        display(table, rN, cN, title);
    }

    public static void displayWithRowPrefix(int[][] table, String pref, String[] cols, String title) throws Exception {
        String[] rows = new String[table.length];
        for (int i = 0; i < rows.length; i++) rows[i] = pref + " " + (i+1);
        display(table, rows, cols, title);
    }

    public static void displayWithColPrefix(int[][] table, String[] rows, String pref, String title) throws Exception {
        int mC = 0;
        for (int[] r : table) mC = Math.max(mC, r.length);
        String[] cols = new String[mC];
        for (int j = 0; j < mC; j++) cols[j] = pref + " " + (j+1);
        display(table, rows, cols, title);
    }

    // --- HELPERS AUXILIARES ---

    private static boolean isValid(int[][] t, String[] r, String[] c) {
        return t != null && r != null && c != null && t.length == r.length;
    }

    private static void printCentered(String text, int width) {
        int pad = (width - text.length()) / 2;
        System.out.printf("%" + (pad > 0 ? pad : "") + "s%s%" + (width - text.length() - pad > 0 ? (width - text.length() - pad) : "") + "s", "", text, "");
    }

    private static void printSeparator(int rW, int[] cW, char s) {
        int total = rW;
        for (int w : cW) total += w;
        for (int i = 0; i < total; i++) System.out.print(s);
        System.out.println();
    }

    private static void printTitleBox(String title) {
        if (title == null || title.isEmpty()) return;
        String line = "═".repeat(title.length() + 4);
        System.out.println("\n╔" + line + "╗\n║  " + title.toUpperCase() + "  ║\n╚" + line + "╝");
    }

    private static int getMaxWidth(String[] ss) {
        int max = 0;
        for (String s : ss) if (s.length() > max) max = s.length();
        return max;
    }

    private static int[] getColWidths(int[][] t, String[] cN) {
        int[] ws = new int[cN.length];
        for (int j = 0; j < cN.length; j++) {
            ws[j] = cN[j].length();
            for (int i = 0; i < t.length; i++) {
                if (j < t[i].length) ws[j] = Math.max(ws[j], String.valueOf(t[i][j]).length());
            }
            ws[j] += 3;
        }
        return ws;
    }
}