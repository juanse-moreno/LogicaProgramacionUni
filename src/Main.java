import java.util.*;

public class Main {
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);

        /*
        String testMessage = " Hola me llamo Sebastian ".trim().replaceFirst(" ", ", ");
                                                // trim se entiende, quita los espacios al inicio y al final
                                                // y el replace por lo general reemplaza aquella coincidencia que encuentra
                                                // según los argumentos que se le indican pero al usar First reemplaza sólo la primera coincidencia
        System.out.println(testMessage);
        */
        final String NAME = "Sebastian", SURNAME = "Moreno";
        System.out.print("Ingresar edad: ");
        int age = sc.nextInt();
        double heigth = 1.75;
        boolean ofAge = age >= 18;


        // String testNewLine = "alo policía%nxd"; // Aquí se imprime como contenido el %n
        // String testNewLine = "alo policia\nxd";
        // System.out.println(testNewLine);

        System.out.println(String.format("Hola, me llamo %s %s." +
                                        "%nTengo %d años y mido %.2f." +
                                        "%nY %5$s soy mayor de edad.", NAME, SURNAME, age, heigth, ofAge ? "sí" : "no").trim());
                            // String format recibe los argumentos y el %letra está definida por java
                            // %c para caracteres - %s para cadenas de texto - %d para enteros
                            // %f para decimales - %b para booleanos %t para hora y fecha
                            // %n para salto de linea(sólo dentro de .format)
                            // %% = necesario si se necesita mostrar literalmente el símbolo de porcentaje %

        // System.out.println(String.format("Hola, me llamo %4$S %3$s, tengo %d y mido %.2f.", age, heigth, SURNAME, NAME));
        // String format también se puede usar con letras mayúsculas para dar el formato mostrando resultados en MAYÚSCULAS
        // Además puede llamar de manera no secuencial sus argumentos %N° de argumento$letra - Pero:
        // Obliga a darles posición a todos los argumentos dependiendo en el orden que se agregan =
                    // System.out.println(String.format("Hola, me llamo %2$S %1$s, tengo %3$d y mido %4$.2f.", SURNAME, NAME, age, heigth));

        /*
        Integer b = 128;
        Integer a = 128;

        System.out.println();
        System.out.println(b == a); // == compara ubicación en cache
        System.out.println(b.equals(a)); // equals compara contenido

        */
    }
}
