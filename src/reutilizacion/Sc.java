
package reutilizacion;

import java.util.Scanner;

public class Sc {

    public static Scanner sc = new Scanner(System.in);

    public static int nextInt(String mensaje) {
        Print.imprimirSinSalto(mensaje);
        int numero = sc.nextInt();
        sc.nextLine();
        return numero;
    }

    public static double nextDouble(String mensaje) {
        Print.imprimirSinSalto(mensaje);
        double numero = sc.nextDouble();
        sc.nextLine();
        return numero;
    }

    public static boolean nextBoolean(String mensaje) {
        Print.imprimirSinSalto(mensaje);
        boolean respuesta = sc.nextBoolean();
        sc.nextLine();
        return respuesta;
    }

    public static String nextLine(String mensaje) {
        Print.imprimirSinSalto(mensaje);
        return sc.nextLine();
    }

    public static String nextScan() {
        return sc.nextLine();
    }
    // Función para validar un entero positivo
    public static int validarEnteroPositivo(String mensaje) {
        int numero = nextInt(mensaje);
        while (numero <= 0) {
            Print.imprimirConSalto("Dato invalido. Debe ser un entero positivo.");
            numero = nextInt(mensaje);
        }
        return numero;
    }

    // Función para validar un decimal positivo
    public static double validarDecimalPositivo(String mensaje) {
        double numero = nextDouble(mensaje);
        while (numero <= 0) {
            Print.imprimirConSalto("Dato invalido. Debe ser un decimal positivo.");
            numero = nextDouble(mensaje);
        }
        return numero;
    }

    // Función para validar un texto no vacío
    public static String validarTextoNoVacio(String mensaje) {
        String texto = nextLine(mensaje);
        while (texto.length() == 0) {
            Print.imprimirConSalto("Dato invalido. El texto no puede estar vacio.");
            texto = nextLine(mensaje);
        }
        return texto;
    }

    // Función para llenar un arreglo de textos no vacíos
    public static void llenarTextosNoVacios(String[] arreglo, String etiqueta) {
        for (int i = 0; i < arreglo.length; i++) {
            arreglo[i] = validarTextoNoVacio(etiqueta + " " + (i + 1) + ": ");
        }
    }

    // Función para llenar un arreglo de enteros positivos
    public static void llenarEnterosPositivos(int[] arreglo, String etiqueta) {
        for (int i = 0; i < arreglo.length; i++) {
            arreglo[i] = validarEnteroPositivo(etiqueta + " " + (i + 1) + ": ");
        }
    }

    // Función para llenar un arreglo de decimales positivos
    public static void llenarDecimalesPositivos(double[] arreglo, String etiqueta) {
        for (int i = 0; i < arreglo.length; i++) {
            arreglo[i] = validarDecimalPositivo(etiqueta + " " + (i + 1) + ": ");
        }
    }

}
