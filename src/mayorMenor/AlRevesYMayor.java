package mayorMenor;

import reutilizacion.*;

public class AlRevesYMayor {

    public static void main(String[] args) {

        int[] numeros = new int[5];
        for (int i = 0; i < numeros.length; i++) {
            numeros[i] = Sc.nextInt("Introduce el número " + (i + 1) + ": ");
        }

        Print.imprimirSinSalto("Números al revés: ");
        for (int i = numeros.length - 1; i >= 0; i--) {
            Print.imprimirSinSalto(numeros[i] + " ");
        }

        int mayor = numeros[0];
        for (int i = 1; i < numeros.length; i++) {
            if (numeros[i] > mayor) {
                mayor = numeros[i];
            }
        }

        Print.imprimirSinSalto("\nEl mayor es: " + mayor);
    }
}