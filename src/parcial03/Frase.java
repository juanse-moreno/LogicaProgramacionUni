package parcial03;

import reutilizacion.*;

public class Frase {
    public static void main(String [] args){

        String frase = Sc.nextLine("Ingrese una frase: ");
        int palabras = contarPalabras(frase);
        String primera = obtenerPrimeraPalabra(frase);
        String ultima = obtenerUltimaPalabra(frase);
        boolean palindromo = esPalindromo(primera);
        boolean iguales = primera.equalsIgnoreCase((ultima));

        Print.imprimirConSalto("Cantidad de palabras: " + palabras);
        Print.imprimirConSalto("Primera palabra: " + primera);
        Print.imprimirConSalto("Ultima palabra: " + ultima);
        Print.imprimirConSalto(palindromo ? "La primera palabra es un palíndromo" : "La primera palabra no es un palindromo");
        Print.imprimirConSalto(iguales ? "Primera y última iguales" : "Primera y última diferentes");

        dibujarTriangulo(primera);
    }

    public static int contarPalabras(String frase){
        int palabras = 1;
        for (int i = 0; i < frase.length(); i++){
            if (frase.charAt(i) == ' '){
                palabras ++;
            }
        }
        return palabras;
    }

    public static String obtenerPrimeraPalabra(String frase){
        String primera = "";
        boolean terminada = false;
        for (int i = 0; i < frase.length(); i++){
            char letra = frase.charAt(i);
                if (letra == ' '){
                    terminada = true;
                } else if (!terminada){
                    primera += letra;
                }
        }
        return primera;
    }

    public static String obtenerUltimaPalabra(String frase){
        String ultima = "";
        for (int i = 0; i < frase.length(); i++){
            char letra = frase.charAt(i);

            if (letra == ' '){
                ultima = "";
            } else {
                ultima += letra;
            }
        }
        return ultima;
    }

    public static boolean esPalindromo(String palabra){
        String minuscula = palabra.toLowerCase();
        boolean palindromo = true;
        for (int i = 0; i < minuscula.length() / 2; i++){
            if (minuscula.charAt(i) != minuscula.charAt(minuscula.length() - 1 - i)){
                palindromo = false;
            }
        }
        return palindromo;
    }

    public static void dibujarTriangulo(String palabra){
        for (int fila = 1; fila <= palabra.length(); fila++){
            for (int asterisco = 1; asterisco <= fila; asterisco++){
                Print.imprimirSinSalto("*");
            }
            Print.imprimirSaltoLinea();
        }
    }

}
