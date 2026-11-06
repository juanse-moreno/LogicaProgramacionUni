package textosSonArreglos;

import reutilizacion.*;

public class Palindromo {
    public static void main(String[]args){

        String palabra = Sc.nextLine("Escriba una palabra: ");

        if (esPalindromo(palabra)){
            Print.print(palabra + " es palíndromo");
        } else {
            Print.print(palabra + " no es palíndromo");
        }

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
}
