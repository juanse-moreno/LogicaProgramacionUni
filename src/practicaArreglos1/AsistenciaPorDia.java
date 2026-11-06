package practicaArreglos1;

import reutilizacion.*;

public class AsistenciaPorDia {
    public static void main(String[] args) {

        int[][] asistencia = {
                {12, 15, 9, 20, 18},
                {8, 10, 14, 11, 16},
                {20, 18, 17, 19, 22}
        };

        String[] dias = {"lunes", "martes", "miércoles", "jueves", "viernes"};

        int[] totales = totalPorDia(asistencia);

        int totalSemana = 0;
        int mayor = totales[0];
        int posicionMayor = 0;

        Print.ln("Total de asistentes por día:");

        for (int dia = 0; dia < totales.length; dia++) {

            Print.ln("El día " + dias[dia] + " asisitieron: " + totales[dia] + " estudiantes.");

            totalSemana += totales[dia];

            if (totales[dia] > mayor) {
                mayor = totales[dia];
                posicionMayor = dia;
            }
        }

        Print.ln("\nTotal general de la semana: " + totalSemana);

        Print.ln("El día con mayor asistencia fue " + dias[posicionMayor] + " con " + mayor + " asistentes.");
    }

    public static int[] totalPorDia(int[][] asistencia) {

        int[] totales = new int[asistencia[0].length];

        for (int dia = 0; dia < asistencia[0].length; dia++) {

            int total = 0;

            for (int grupo = 0; grupo < asistencia.length; grupo++) {

                total += asistencia[grupo][dia];
            }

            totales[dia] = total;
        }

        return totales;
    }
}
