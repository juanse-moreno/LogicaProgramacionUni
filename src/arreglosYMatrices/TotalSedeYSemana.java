package arreglosYMatrices;

import reutilizacion.*;

public class TotalSedeYSemana {
    public static void main(String [] args){
        int[][] ventas = {
                {10, 29, 30, 40},
                {5, 15, 25, 35},
                {8, 12, 16, 28}
        };

        totalPorSede(ventas);
        totalPorSemana(ventas);
    }

    public static void totalPorSede(int[][] ventas) {
        for (int sede = 0; sede < ventas.length; sede++) {
            int total = 0;

            System.out.print("Sede " + (sede + 1) + ": ");

            for (int semana = 0; semana < ventas[sede].length; semana++) {
                System.out.print(ventas[sede][semana] + " ");

                total += ventas[sede][semana];
            }

            System.out.println("-> Total: " + total);
        }
    }

    public static void totalPorSemana(int[][] ventas) {
        for (int semana = 0; semana < ventas[0].length; semana++) {
            int total = 0;

            for (int sede = 0; sede < ventas.length; sede++) {
                total += ventas[sede][semana];
            }

            System.out.println("Semana " + (semana + 1) + ": " + total);
        }
    }
}
