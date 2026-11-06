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

            Print.print("Equipo " + (equipo + 1) + ": ");

            for (int partido = 0; partido < goles[equipo].length; partido++) {

                Print.print(goles[equipo][partido] + " ");

                total += goles[equipo][partido];
            }

            double promedio = (double) total / goles[equipo].length;

            Print.ln("-> Total de goles: " + total);
            Print.ln("Promedio de goles por partido: " + promedio + "\n");
        }
    }
}
