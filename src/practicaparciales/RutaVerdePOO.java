package practicaparciales;

import gestor.GestorRutaVerde;
import modelo.PuntoRecoleccion;
import reutilizacion.Print;
import reutilizacion.Sc;

// [Ref #18] Clase principal: solo orquesta (pide datos, crea objetos, los entrega al gestor, imprime)
public class RutaVerdePOO {

    public static void main(String[] args) {

        // [Ref #19] Se usa Sc como objeto instanciable
        Sc entrada = new Sc();

        int cantidad = entrada.leerEnteroPositivo("Ingrese la cantidad de puntos de recoleccion: ");
        GestorRutaVerde gestor = new GestorRutaVerde(cantidad);

        // [Ref #20] Se crea un objeto por punto y se entrega al gestor
        for (int i = 0; i < cantidad; i++) {
            Print.imprimirConSalto("--- Punto " + (i + 1) + " ---");
            PuntoRecoleccion punto = leerPunto(entrada);
            gestor.agregarPunto(punto);
        }

        Print.mostrarMensaje(gestor.generarMensaje());
    }

    // [Ref #20] Lectura de un punto completo con las validaciones de Sc
    private static PuntoRecoleccion leerPunto(Sc entrada) {
        String nombre = entrada.leerTextoNoVacio("Ingrese el nombre del punto: ");
        int codigo = entrada.leerEnteroPositivo("Ingrese el codigo del punto: ");
        String tipo = leerTipoMaterial(entrada);
        double kilos = entrada.leerDecimalPositivo("Ingrese los kilogramos del punto: ");
        double valor = entrada.leerDecimalPositivo("Ingrese el valor pagado por kilogramo: ");

        PuntoRecoleccion punto = new PuntoRecoleccion(nombre, codigo, tipo, kilos, valor);
        return punto;
    }

    private static String leerTipoMaterial(Sc entrada) {
        String tipo = entrada.leerLinea("Ingrese el tipo de material (plastico, carton o vidrio): ");
        while (!PuntoRecoleccion.esMaterialValido(tipo)) {
            Print.imprimirConSalto("Tipo invalido. Debe ser plastico, carton o vidrio.");
            tipo = entrada.leerLinea("Ingrese el tipo de material (plastico, carton o vidrio): ");
        }
        return tipo;
    }
}