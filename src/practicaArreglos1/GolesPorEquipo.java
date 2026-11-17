package practicaArreglos1;

import reutilizacion.*;

public class GolesPorEquipo {
    public static void main(String[] args) {

        int[][] goles = {
                {2, 0, 1, 3},
                {1, 1, 0, 2},
                {0, 4, 2, 1}
        };

        totalPorEquipo(goles);
    }

    public static void totalPorEquipo(int[][] goles) {

        for (int equipo = 0; equipo < goles.length; equipo++) {

            int total = 0;

            Print.imprimirTextoYRetornar("Equipo " + (equipo + 1) + ": ");

            for (int partido = 0; partido < goles[equipo].length; partido++) {

                Print.imprimirTextoYRetornar(goles[equipo][partido] + " ");

                total += goles[equipo][partido];
            }

            double promedio = (double) total / goles[equipo].length;

            Print.imprimirConSalto("-> Total de goles: " + total);
            Print.imprimirConSalto("Promedio de goles por partido: " + promedio + "\n");
        }
    }
}
