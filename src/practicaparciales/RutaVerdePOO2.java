package practicaparciales;

import gestor.GestorRutaVerde;
import modelo.PuntoRecoleccion;
import reutilizacion.Print;
import reutilizacion.Sc;

public class RutaVerdePOO2 {
    public static void main(String[] args) {

    // [Ref #19] Se usa Sc como objeto instanciable
    Sc entrada = new Sc();

    int cantidad = entrada.leerEnteroPositivo("Ingrese la cantidad de puntos de recoleccion: ");
    GestorRutaVerde gestor = new GestorRutaVerde(cantidad);

    // [Ref #20] Lectura por fases en arreglos temporales
    String[] nombres = new String[cantidad];
    int[] codigos = new int[cantidad];
    String[] tipos = new String[cantidad];
    double[] kilos = new double[cantidad];
    double[] valores = new double[cantidad];

    Sc.llenarTextosNoVacios(nombres, "Ingrese el nombre del punto");
    Sc.llenarEnterosPositivos(codigos, "Ingrese el codigo del punto");
    llenarTipos(entrada, tipos);
    Sc.llenarDecimalesPositivos(kilos, "Ingrese los kilogramos del punto");
    Sc.llenarDecimalesPositivos(valores, "Ingrese el valor pagado por kilogramo del punto");

    // [Ref #21] Con los datos completos se crea cada objeto y se entrega al gestor
    for (int i = 0; i < cantidad; i++) {
        PuntoRecoleccion punto = new PuntoRecoleccion(nombres[i], codigos[i], tipos[i], kilos[i], valores[i]);
        gestor.agregarPunto(punto);
    }

    Print.mostrarMensaje(gestor.generarMensaje());
}

    // [Ref #22] Llena el arreglo de tipos pidiendo el material de cada punto
    private static void llenarTipos(Sc entrada, String[] tipos) {
        for (int i = 0; i < tipos.length; i++) {
            tipos[i] = leerTipoMaterial(entrada, i + 1);
        }
    }

    // [Ref #22] Repite la pregunta hasta que el material sea valido (regla de la clase modelo)
    private static String leerTipoMaterial(Sc entrada, int numero) {
        String mensaje = "Ingrese el tipo de material del punto " + numero + " (plastico, carton o vidrio): ";
        String tipo = entrada.leerLinea(mensaje);
        while (!PuntoRecoleccion.esMaterialValido(tipo)) {
            Print.imprimirConSalto("Tipo invalido. Debe ser plastico, carton o vidrio.");
            tipo = entrada.leerLinea(mensaje);
        }
        return tipo;
    }
}
