package arreglosYMatrices;

import reutilizacion.*;

public class ContarEdades {
    public static void main(String[] args){
        int[] edades  = {18, 20 ,18 , 25, 18, 30};

        int valor = Sc.nextInt("Qué edad quieres contar?\n");

        int veces = Sc.contarVeces(edades, valor);

        Print.imprimirTextoYRetornar("La edad " + valor + " aparece " + veces + " veces.");
    }


}
