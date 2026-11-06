package arreglosYMatrices;

import reutilizacion.*;

public class MostrarTablaYPromedioNotas {
    public static void main(String[] args){
        double [][] nota={
                //fila:1
                {4.0, 3.8, 5.0},
                // fila: 2
                {2.8, 3.9, 1.0},
                //fila: 3
                {5.0, 4.0, 3.8}
        };

        mostrarTabla(nota);

        Print.ln("\nPromedio por evaluaciones");

        mostrarPromedioColumnas(nota);
    }
    public static void mostrarTabla(double[][] notas){

        for (int fila = 0; fila < notas.length; fila++){
            double suma = 0;

            Print.print("Estudiante " + (fila + 1) + ": ");
            //             Estudiante 1:

            for (int col = 0; col < notas[fila].length; col++) {
                Print.print(notas[fila][col] + " ");
                suma += notas[fila][col];
            }

            double promedio = suma / notas[fila].length;

            Print.ln("Promedio: " + promedio);
        }
    }

    public static void mostrarPromedioColumnas(double[][] notas) {
        int totalFilas = notas.length;         // 3 filas
        int totalColumnas = notas[0].length;   // 3 columnas

        // El bucle externo ahora maneja las columnas
        for (int col = 0; col < totalColumnas; col++) {
            double suma = 0;
            System.out.print("Evaluación " + (col + 1) + ": ");

            // El bucle interno ahora recorre las filas de esa columna
            for (int fila = 0; fila < totalFilas; fila++) {
                System.out.print(notas[fila][col] + " ");
                suma += notas[fila][col];
            }

            double promedio = suma / totalFilas;
            System.out.println("-> Promedio: " + promedio);
        }
    }

}
