package textosSonArreglos;

import reutilizacion.*;

public class Capicua {
    public static void main(String[] args){
        int tamaño = Sc.nextInt("Cuántos números vas a ingresar?: ");

        int [] datos = new int [tamaño];

        for (int i = 0; i < datos.length; i++) {
            datos[i] = Sc.nextInt("Ingresa el número para la posición " + i + ": ");
        }

        if (esCapicua(datos)){
            Print.print("El arreglo es capicua");
        } else {
            Print.print("El arreglo no es capicua");
        }
    }

    public static boolean esCapicua(int[] datos){
        boolean esCapicua = true;

        for (int i = 0; i < datos.length / 2; i++){

            if (datos[i] != datos[datos.length - 1 - i]) {
                esCapicua = false;
                break;
            }
        }

        return esCapicua;
    }
}
