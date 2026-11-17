package textosSonArreglos;

import reutilizacion.*;

public class Contrasena {
    public static void main (String[]args){
        String clave = "Java";
        String intento = Sc.nextLine("Escribe la clave: ");

        Print.imprimirConSalto("Con ==: " + (intento == clave));
        Print.imprimirConSalto("Con equals: " + (intento.equals(clave)));
        Print.imprimirConSalto("Con equalsIgnoreCase: " + (intento.equalsIgnoreCase(clave)));

        if (intento.equalsIgnoreCase(clave)) {
            Print.imprimirTextoYRetornar("Acceso concedido");
        } else {
            Print.imprimirTextoYRetornar("Clave incorrecta");
        }

    }
}
