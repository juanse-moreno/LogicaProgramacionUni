
package reutilizacion;

import java.util.Scanner;

public class Sc {

    public static Scanner sc = new Scanner(System.in);

    public static int nextInt(String mensaje) {
        String texto = quitarEspaciosExtremos(nextLine(mensaje));
        while (!esEnteroValido(texto)) {
            Print.imprimirConSalto("Dato invalido. Debe ingresar un numero entero.");
            texto = quitarEspaciosExtremos(nextLine(mensaje));
        }
        int numero = convertirTextoAEntero(texto);
        return numero;
    }

    public static double nextDouble(String mensaje) {
        String texto = quitarEspaciosExtremos(nextLine(mensaje));
        while (!esDecimalValido(texto)) {
            Print.imprimirConSalto("Dato invalido. Debe ingresar un numero decimal (ejemplo: 12.5 o 12,5).");
            texto = quitarEspaciosExtremos(nextLine(mensaje));
        }
        double numero = convertirTextoADecimal(texto);
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

    // REUTILIZACIÓN SEGÚN CODIFICACIÓN ÚLTIMO PARCIAL
    // funcion para validar un entero dentro de un rango (incluyendo extremos)
    public static int validarEnteroEnRango(String mensaje, int minimo, int maximo) {
        int numero = nextInt(mensaje);
        while (numero < minimo || numero > maximo) {
            Print.imprimirConSalto("Dato invalido. Debe estar entre " + minimo + " y " + maximo + ".");
            numero = nextInt(mensaje);
        }
        return numero;
    }

    // REUTILIZACIÓN SEGÚN CODIFICACIÓN ÚLTIMO PARCIAL
    // funcion para validar un decimal dentro de un rango (incluyendo extremos)
    public static double validarDecimalEnRango(String mensaje, double minimo, double maximo){
        double numero = Sc.nextDouble(mensaje);
        while (numero < -10 || numero > 60){
            numero = Sc.nextDouble("Lectura invalida. " + mensaje);
        }
        return numero;
    }

    // REUTILIZACIÓN SEGÚN CODIFICACIÓN ÚLTIMO PARCIAL
    // funcion para validar un entero dentro de un rango (incluyendo extremos)
    public static int contarMayoresQueDecimal(double [] arreglo, double valor){
        int contador = 0;
        for (int i = 0; i < arreglo.length; i++){
            if (arreglo[i] > valor){
                contador++;
            }
        }
        return contador;
    }

    // REUTILIZACIÓN SEGÚN CODIFICACIÓN ÚLTIMO PARCIAL
    public static double calcularPromedioDecimales(double [] arreglo){
        double suma = 0;
        for (int i = 0; i < arreglo.length; i++){
            suma += arreglo[i];
        }
        return suma / arreglo.length;
    }

    // REUTILIZACIÓN SEGÚN CODIFICACIÓN ÚLTIMO PARCIAL
    public static int contarVeces (int[] arreglo, int numero){
        int contador = 0;

        for (int i = 0; i < arreglo.length; i++){
            if (arreglo[i] == numero){
                contador++;
            }
        } return contador;
    }

    // REUTILIZACIÓN SEGÚN CODIFICACIÓN ÚLTIMO PARCIAL
    public static int buscarPosicionMayorEntero(int [] arreglo){
        int mayor = arreglo[0];
        int posicionMayor = 0;
        for (int i = 0; i < arreglo.length; i++){
            if (arreglo[i] > mayor){
                mayor = arreglo[i];
                posicionMayor = i;
            }

        }

        return posicionMayor;

    }
    // REUTILIZACIÓN SEGÚN CODIFICACIÓN ÚLTIMO PARCIAL
    public static int buscarPosicionMayorDecimal(double [] arreglo){
        double mayor = arreglo[0];
        int posicionMayor = 0;
        for (int i = 0; i < arreglo.length; i++){
            if (arreglo[i] > mayor){
                mayor = arreglo[i];
                posicionMayor = i;
            }

        }

        return posicionMayor;

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

    // función nueva (repasar luego)
    public static String convertirDecimalATexto(double valor) {
        long centavos = (long) (valor * 100 + 0.5);
        long parteEntera = centavos / 100;
        long parteDecimal = centavos % 100;
        String texto = parteEntera + ".";
        if (parteDecimal < 10) {
            texto += "0";
        }
        texto += parteDecimal;
        return texto;
    }

    // FUNCIONES PERSONALES CREADAS Y ADAPTADAS CON LA PRÁCTICA PARA EVITAR USO DE MÉTODOS NATIVOS DE JAVA
    // Y PARA COMPRENDER EL FUNCIONAMIENTO DE ESTOS ÚLTIMOS
    // Quita los espacios del inicio y del final (equivale a trim)
    public static String quitarEspaciosExtremos(String texto) {
        int inicio = 0;
        while (inicio < texto.length() && texto.charAt(inicio) == ' ') {
            inicio++;
        }
        int fin = texto.length() - 1;
        while (fin >= inicio && texto.charAt(fin) == ' ') {
            fin--;
        }
        String limpio = texto.substring(inicio, fin + 1);
        return limpio;
    }

    // Dice si un caracter es un digito del 0 al 9
    public static boolean esDigito(char caracter) {
        boolean digito = caracter >= '0' && caracter <= '9';
        return digito;
    }

    // Valida un entero: signo '-' opcional y de 1 a 9 digitos
    public static boolean esEnteroValido(String texto) {
        boolean valido = true;
        int inicio = 0;
        if (texto.length() > 0 && texto.charAt(0) == '-') {
            inicio = 1;
        }
        int cantidadDigitos = texto.length() - inicio;
        if (cantidadDigitos < 1 || cantidadDigitos > 9) {
            valido = false;
        }
        for (int i = inicio; i < texto.length(); i++) {
            if (!esDigito(texto.charAt(i))) {
                valido = false;
            }
        }
        return valido;
    }

    // Valida un decimal: signo '-' opcional, digitos y un solo separador (. o ,)
    public static boolean esDecimalValido(String texto) {
        boolean valido = true;
        int inicio = 0;
        if (texto.length() > 0 && texto.charAt(0) == '-') {
            inicio = 1;
        }
        int cantidadDigitos = 0;
        int cantidadSeparadores = 0;
        for (int i = inicio; i < texto.length(); i++) {
            char caracter = texto.charAt(i);
            if (esDigito(caracter)) {
                cantidadDigitos++;
            } else if (caracter == '.' || caracter == ',') {
                cantidadSeparadores++;
            } else {
                valido = false;
            }
        }
        if (cantidadDigitos < 1 || cantidadDigitos > 15 || cantidadSeparadores > 1) {
            valido = false;
        }
        return valido;
    }

    // Convierte un texto ya validado a int (equivale a Integer.parseInt)
    public static int convertirTextoAEntero(String texto) {
        int numero = 0;
        int inicio = 0;
        boolean negativo = false;
        if (texto.charAt(0) == '-') {
            negativo = true;
            inicio = 1;
        }
        for (int i = inicio; i < texto.length(); i++) {
            int digito = texto.charAt(i) - '0';
            numero = numero * 10 + digito;
        }
        if (negativo) {
            numero = -numero;
        }
        return numero;
    }

    // Convierte un texto ya validado a double (equivale a Double.parseDouble)
    public static double convertirTextoADecimal(String texto) {
        double parteEntera = 0;
        double parteDecimal = 0;
        double divisor = 1;
        boolean negativo = false;
        boolean pasoSeparador = false;
        int inicio = 0;
        if (texto.charAt(0) == '-') {
            negativo = true;
            inicio = 1;
        }
        for (int i = inicio; i < texto.length(); i++) {
            char caracter = texto.charAt(i);
            if (caracter == '.' || caracter == ',') {
                pasoSeparador = true;
            } else {
                int digito = caracter - '0';
                if (pasoSeparador) {
                    parteDecimal = parteDecimal * 10 + digito;
                    divisor = divisor * 10;
                } else {
                    parteEntera = parteEntera * 10 + digito;
                }
            }
        }
        double numero = parteEntera + parteDecimal / divisor;
        if (negativo) {
            numero = -numero;
        }
        return numero;
    }

}
