package arreglosYMatrices;

import reutilizacion.*;

public class ContarEdades {
    public static void main(String[] args){
        int[] edades  = {18, 20 ,18 , 25, 18, 30};

        int valor = Sc.nextInt("Qué edad quieres contar?\n");

        int veces = contarVeces(edades, valor);

        Print.print("La edad " + valor + " aparece " + veces + " veces.");
    }

    public static int contarVeces (int[] datos, int valor){
        int contador = 0;

        for (int i = 0; i < datos.length; i++){
            if (datos[i] == valor){
                contador++;
            }
        } return contador;
    }
}
