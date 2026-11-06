package textosSonArreglos;

import reutilizacion.*;

public class Contrasena {
    public static void main (String[]args){
        String clave = "Java";
        String intento = Sc.nextLine("Escribe la clave: ");

        Print.ln("Con ==: " + (intento == clave));
        Print.ln("Con equals: " + (intento.equals(clave)));
        Print.ln("Con equalsIgnoreCase: " + (intento.equalsIgnoreCase(clave)));

        if (intento.equalsIgnoreCase(clave)) {
            Print.print("Acceso concedido");
        } else {
            Print.print("Clave incorrecta");
        }

    }
}
