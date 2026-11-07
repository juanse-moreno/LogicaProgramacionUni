package ejercicio1DetectivePalabras;

import java.util.Scanner;

public class DetectivePalabras {
    public static void main(String [] args){

        Scanner sc = new Scanner(System.in);
        System.out.print("Ingrese la cantidad de palabras que va a analizar: ");
        int cantidadPalabras = sc.nextInt();
        sc.nextLine();

        String [] palabra = new String[cantidadPalabras];

        for (int i = 0; i < cantidadPalabras; i++){
            System.out.print("Ingrese la palabra: ");
            palabra[i] = sc.nextLine();
        }

        int contadorPalindromo = 0;

        String palabraMayor = palabra[0];
        int maxVocales = contarVocales(palabra[0]);

        for (int i = 0; i < cantidadPalabras; i++){
            int vocales = contarVocales(palabra[i]);

            if (esPalindromo(palabra[i])){
                System.out.println("La palabra " + palabra[i] + " tiene " + vocales + " vocales y es palindromo");

                contadorPalindromo ++;
            } else {
                System.out.println("La palabra " + palabra[i] + " tiene " + vocales + " vocales y no es palindromo");
            }
            if (vocales > maxVocales){
                maxVocales = vocales;
                palabraMayor = palabra[i];
            }
        }
        System.out.println("La cantidad de palindromos es: " + contadorPalindromo);
        System.out.println("La palabra con mayores vocales es: " + palabraMayor);

        System.out.print("Ingrese la palabra que desea buscar: ");
        String buscado = sc.nextLine();

        int posicion = buscar(palabra, buscado);

        if (posicion == -1){
            System.out.println("La palabra " + buscado + " no está en el arreglo.");
        } else {
            System.out.println("La palabra " + buscado + " está en la posición " + (posicion +1) + "." );
        }
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

    public static int buscar (String [] palabra, String buscado ){
        for (int i = 0; i < palabra.length; i++){

            if (palabra[i].equalsIgnoreCase(buscado)){
                return i;
            }
        } return -1;
    }
}