package prueba1;

import reutilizacion.*;

public class ArreglosClase1 {

    public static void main(String[] args) {

        double[] notas = new double[5];

        String[] top = {
                "Torta de chocolate",
                "Helado",
                "Muffin",
                "Ensalada de frutas",
                "Malteada"
        };

        Print.println("CÓDIGO 1");
        mostrarTop(top);

        Print.println("CÓDIGO 2");
        leerNotas(notas);
        mostrarResumen(notas);

        ImagenVentanasXD.preguntarYMostrar();
    }

    public static void mostrarTop(String[] top) {

        Print.print("Mi top " + top.length + " de postres\n");

        for (int i = 1; i <= top.length; i++) {

            Print.println(i + ". " + top[i - 1]);

        }

    }

    public static void leerNotas(double[] notas) {

        for (int i = 0; i < notas.length; i++) {

            notas[i] = Sc.nextDouble("Primer nota del estudiante " + (i + 1) + " : ");

        }

    }

    public static void mostrarResumen(double[] notas) {

        double suma = 0;
        int aprobados = 0;

        for (int i = 0; i < notas.length; i++) {

            suma += notas[i];

            if (notas[i] >= 3.0) {

                aprobados++;

            }

        }

        double promedio = suma / notas.length;

        Print.println("Promedio del grupo: " + promedio);

        Print.println("Aprobados: " + aprobados + " de " + notas.length);

    }

}
