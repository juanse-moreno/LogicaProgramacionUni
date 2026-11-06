package arreglosYMatrices;

import reutilizacion.*;

public class BuscarNumero {
    public static void main(String[] args){

        // Buscar un Numero
        // busqueda lineal: Buscar casillero por casillero hasta encontrar lo que se necesita o hasta llegar al final
        // Valor centinela -1: Valor que no puede ser índice real significa que no existe
        // Return dentro de un ciclo termina cuando encuentra
        int [] numeros = {12, 7, 25, 3, 18};

        int buscado = Sc.nextInt("¿Qué número quieres buscar ?\n"); //6

        int posicion = buscar (numeros, buscado);

        if (posicion == -1){
            Print.print("El número " + buscado + " no está en el arreglo.");
        } else {
            Print.print("El número " + buscado + " está en la posición " + (posicion +1) + "." );

        }
    }

    public static int buscar (int[] numeros, int buscado ){
        for (int i = 0; i < numeros.length; i++){
            if (numeros[i] == buscado){
                return i;
            }
        } return -1;
    }
}
