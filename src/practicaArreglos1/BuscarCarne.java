package practicaArreglos1;

import reutilizacion.*;

public class BuscarCarne {
    public static void main(String[] args) {

        // Lista de invitados
        int[] carnes = {2201, 2305, 2412, 2518, 2620};

        int buscado = Sc.nextInt("¿Qué carné quieres buscar?\n");

        int posicion = buscarCarne(carnes, buscado);

        if (posicion == -1) {
            Print.print("El carné " + buscado + " no está registrado.");
        } else {
            Print.print("El carné " + buscado + " está registrado en la posición " + (posicion + 1) + ".");
        }
    }

    public static int buscarCarne(int[] carnes, int buscado) {

        for (int i = 0; i < carnes.length; i++) {
            if (carnes[i] == buscado) {
                return i;
            }
        }

        return -1;
    }
}
