package practicaArreglos1;

import reutilizacion.*;

public class ContarNota {
    public static void main(String[] args) {

        // Notas de las evaluaciones
        int[] notas = {5, 3, 4, 5, 2, 5, 4, 3};

        int valor = Sc.nextInt("¿Qué nota quieres contar?\n");

        int veces = contarNota(notas, valor);

        Print.print("La nota " + valor + " aparece " + veces + " veces.");
    }

    public static int contarNota(int[] datos, int valor) {

        int contador = 0;

        for (int i = 0; i < datos.length; i++) {
            if (datos[i] == valor) {
                contador++;
            }
        }

        return contador;
    }
}
