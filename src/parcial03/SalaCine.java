package parcial03;

import reutilizacion.*;

public class SalaCine {
    public static void main(String[] args){

        int filas = Sc.validarEnteroPositivo("Ingrese el número de filas (Mayor que 0): ");
        int columnas = Sc.validarEnteroPositivo("Ingrese el número de columas (Mayor que 0): ");

        int [][] sala = new int[filas][columnas];
        llenarSala(sala);
        dibujarSala(sala);

        int [] libresPorFila = calcularLibresPorFila(sala);
        int totalOcupados = contarOcupados(sala);
        int filasMasLibres = Sc.buscarPosicionMayorEntero(libresPorFila);
        boolean hayFilaLlena = existeFilaLlena(sala);

        mostrarLibresPorFila(libresPorFila);
        Print.imprimirConSalto("Tola de asientos ocupados: " + totalOcupados);
        Print.imprimirConSalto("Fila con más asientos libres: " + (filasMasLibres + 1));
        Print.imprimirConSalto(hayFilaLlena ? "Hay al menos una fila llena" : "No hay filas llenas");

    }

    public static void llenarSala(int[][] sala){
        for (int fila = 0; fila < sala.length; fila++ ){
            for (int columna = 0; columna < sala[fila].length; columna++){
                sala[fila][columna] = Sc.validarEnteroEnRango("Asiento de la fila " + (fila + 1)
                        + ", asiento de la columna " + (columna + 1) + "(1 = ocupado, 0 = disponible): ", 0, 1);
            }
        }
    }
    public static int[] calcularLibresPorFila(int[][] sala){
        int[] libresPorFila = new int[sala.length];
        for (int fila = 0; fila < sala.length; fila++){
            int libres = 0;
            for (int columna = 0; columna < sala[fila].length; columna++){
                if (sala[fila][columna] == 0){
                    libres ++;
                }
            }
            libresPorFila[fila] = libres;
        }
        return libresPorFila;
    }

    public static int contarOcupados(int[][] sala){
        int ocupados = 0;
        for (int fila = 0; fila < sala.length; fila++ ) {
            for (int columna = 0; columna < sala[fila].length; columna++) {
                if (sala[fila][columna] == 1) {
                    ocupados++;
                }
            }
        }
        return ocupados;
    }

    public static boolean esFilaLlena(int[][] sala, int fila){
        boolean filaLlena = true;
        for (int columna = 0; columna < sala[fila].length; columna++){
            if (sala[fila][columna] == 0){
                filaLlena = false;
            }
        }
        return filaLlena;
    }

    public static boolean existeFilaLlena(int[][] sala){
        boolean hayFilaLlena = false;
        for (int fila = 0; fila < sala.length; fila++){
            if (esFilaLlena(sala, fila)){
                hayFilaLlena = true;
            }
        }
        return hayFilaLlena;
    }

    public static void mostrarLibresPorFila(int[] libresPorFila){
        for (int i = 0; i < libresPorFila.length; i++){
            Print.imprimirConSalto("Fila " + (i + 1) + ": " + libresPorFila[i] + " asientos libres");
        }
    }

    public static void dibujarSala(int[][] sala){

        for (int fila = 0; fila < sala.length; fila++){
            for (int columna = 0; columna < sala[fila].length; columna++){
                String simbolo;
                if(sala[fila][columna] == 1){
                    simbolo = "X";
                } else {
                    simbolo = "L";
                }
                Print.imprimirSinSalto(simbolo + " ");
            }
            Print.imprimirSaltoLinea();
        }
    }

}
