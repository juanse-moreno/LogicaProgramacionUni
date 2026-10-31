package mayorMenor;

import reutilizacion.*;

public class PracticaArregloAlReves {


    public static void main (String[] args){
        int[] numeros = {20, 10, 30, 40, 50};

        // 50, 40, 30, 20, 10
        //1: 50
        //2:40
        //3: 30
        //....

        mostrarAlReves(numeros);
        mostrarAlReves2(numeros);
        mostrarAlReves3(numeros);
    }
    //Como debía ser según pensé con los comentarios de la profe en el main
    public static void mostrarAlReves(int[] numeros){

        for (int i = numeros.length - 1; i >= 0; i--) {
            Print.ln("Posición " + (numeros.length - i) + ": " + numeros[i]);
        }
    }
    //Como lo hicimos
    public static void mostrarAlReves2(int[] numeros){

        Print.println();
        for (int i = numeros.length - 1; i >= 0; i--) {
            Print.ln("Posición " + i + ": " + numeros[i]);
        }
    }

    //Como lo propuse creyendo que era así según pensé
    public static void mostrarAlReves3(int[] numeros){

        Print.println();
        for (int i = numeros.length - 1; i >= 0; i--) {
            Print.ln("Posición " + (i+1) + ": " + numeros[i]);
        }
    }
}