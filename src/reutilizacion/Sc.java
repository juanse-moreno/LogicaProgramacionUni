
package reutilizacion;

import java.util.Scanner;

public class Sc {

    public static Scanner sc = new Scanner(System.in);

    public static int nextInt(String mensaje) {
        Print.l(mensaje);
        int numero = sc.nextInt();
        sc.nextLine();
        return numero;
    }

    public static double nextDouble(String mensaje) {
        Print.l(mensaje);
        double numero = sc.nextDouble();
        sc.nextLine();
        return numero;
    }

    public static boolean nextBoolean(String mensaje) {
        Print.l(mensaje);
        boolean respuesta = sc.nextBoolean();
        sc.nextLine();
        return respuesta;
    }

    public static String nextLine(String mensaje) {
        Print.l(mensaje);
        return sc.nextLine();
    }

    public static String nextScan() {
        return sc.nextLine();
    }

}
