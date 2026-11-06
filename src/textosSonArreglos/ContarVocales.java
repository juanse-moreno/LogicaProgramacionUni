package textosSonArreglos;

import reutilizacion.*;

public class ContarVocales {
    public static void main(String[] args) {
        String palabra = Sc.nextLine("Escribe una palabra\n");
        int vocales = contarVocales(palabra);
        Print.print("La palabra " + palabra + " tiene " + vocales + " vocales.");
    }

    public static int contarVocales(String palabra) {
        int contador = 0;
        String minuscula = palabra.toLowerCase();

        for (int i = 0; i < minuscula.length(); i++) {
            char letra = minuscula.charAt(i);

            if (letra == 'a' || letra == 'e' || letra == 'i' || letra == 'o' || letra == 'u') {
                contador++;
            }
        }
        return contador;
    }
}
