package mayorMenor;

import reutilizacion.*;

public class PracticaAlRevesYMayor {
    public static void main(String[] args) {

        int[] numeros = new int[5];

        for (int i = 0; i < numeros.length; i++) {
            numeros[i] = Sc.nextInt("Ingresa el " + Ordinal.numero(i+1));
        }

        Print.l("Números al revés: ");
        for (int i = numeros.length - 1; i >= 0; i--) {
            Print.l(numeros[i] + " ");
        }

        // Método que nos enseñó la profe
        int mayor = numeros[0];
        for (int i = 1; i < numeros.length; i++) {
            if (numeros[i] > mayor) {
                mayor = numeros[i];
            }
        }

        /* Otro método
        int mayor = numeros[0];
            for (int i : numeros) {
                if (i > mayor) {
                mayor = i;
            }
        }
        */

        /* Otro método
        java.util.Arrays.sort(numeros);
        int mayor = numeros[numeros.length - 1];
        */

        Print.l("\nEl mayor es: " + mayor);

    }
}