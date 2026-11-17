package practicaparciales;

import reutilizacion.*;

public class RutaVerde {

    public static void main(String[] args) {

        int cantidad = Sc.validarEnteroPositivo("Ingrese la cantidad de puntos de recoleccion: ");

        String[] nombres = new String[cantidad];
        int[] codigos = new int[cantidad];
        String[] tipos = new String[cantidad];
        double[] kilos = new double[cantidad];
        double[] valores = new double[cantidad];

        Sc.llenarTextosNoVacios(nombres, "Ingrese el nombre del punto");
        Sc.llenarEnterosPositivos(codigos, "Ingrese el codigo del punto");
        llenarTipos(tipos);
        Sc.llenarDecimalesPositivos(kilos, "Ingrese los kilogramos del punto");
        Sc.llenarDecimalesPositivos(valores, "Ingrese el valor pagado por kilogramo del punto");

        double totalPagado = calcularTotalPagado(kilos, valores);

        int posicionMayor = buscarPosicionMayor(kilos);
        String nombreMayor = obtenerNombreMayor(nombres, posicionMayor);

        int[] codigosUnicos = generarCodigosUnicos(codigos);
        String[] combinado = combinarNombresYTipos(nombres, tipos);

        String detallePuntos = construirDetallePuntos(nombres, codigos, tipos, kilos, valores);
        String unicosTexto = convertirEnterosATexto(codigosUnicos);
        String combinadoTexto = convertirTextosATexto(combinado);

        String mensaje = generarMensaje(detallePuntos, totalPagado, nombreMayor,
                unicosTexto, combinadoTexto);

        Print.mostrarMensaje(mensaje);
    }

    public static boolean esMaterialValido(String tipo) {
        boolean valido = false;
        boolean esPlastico = tipo.equalsIgnoreCase("plastico") || tipo.equalsIgnoreCase("plástico");
        boolean esCarton = tipo.equalsIgnoreCase("carton") || tipo.equalsIgnoreCase("cartón");
        boolean esVidrio = tipo.equalsIgnoreCase("vidrio");

        if (esPlastico || esCarton || esVidrio) {
            valido = true;
        }
        return valido;
    }

    public static String leerTipoMaterialValido(String mensaje) {
        String tipo = Sc.nextLine(mensaje);
        while (!esMaterialValido(tipo)) {
            Print.imprimirConSalto("Tipo invalido. Debe ser plastico, carton o vidrio.");
            tipo = Sc.nextLine(mensaje);
        }
        return tipo;
    }

    public static void llenarTipos(String[] tipos) {
        for (int i = 0; i < tipos.length; i++) {
            tipos[i] = leerTipoMaterialValido("Ingrese el tipo de material del punto "
                    + (i + 1) + " (plastico, carton o vidrio): ");
        }
    }

    public static double calcularTotalPagado(double[] kilos, double[] valores) {
        double total = 0;
        for (int i = 0; i < kilos.length; i++) {
            total += kilos[i] * valores[i];
        }
        return total;
    }

    public static int buscarPosicionMayor(double[] kilos) {
        double mayor = kilos[0];
        int posicionMayor = 0;
        for (int i = 1; i < kilos.length; i++) {
            if (kilos[i] > mayor) {
                mayor = kilos[i];
                posicionMayor = i;
            }
        }
        return posicionMayor;
    }

    public static String obtenerNombreMayor(String[] nombres, int posicionMayor) {
        String nombreMayor = nombres[posicionMayor];
        return nombreMayor;
    }

    public static boolean yaAparecioAntes(int[] codigos, int posicion) {
        boolean aparecio = false;
        for (int j = 0; j < posicion; j++) {
            if (codigos[j] == codigos[posicion]) {
                aparecio = true;
            }
        }
        return aparecio;
    }

    public static int contarCodigosUnicos(int[] codigos) {
        int cantidadUnicos = 0;
        for (int i = 0; i < codigos.length; i++) {
            if (!yaAparecioAntes(codigos, i)) {
                cantidadUnicos++;
            }
        }
        return cantidadUnicos;
    }

    public static int[] generarCodigosUnicos(int[] codigos) {
        int tamano = contarCodigosUnicos(codigos);
        int[] unicos = new int[tamano];
        int indiceEscritura = 0;

        for (int i = 0; i < codigos.length; i++) {
            if (!yaAparecioAntes(codigos, i)) {
                unicos[indiceEscritura] = codigos[i];
                indiceEscritura++;
            }
        }
        return unicos;
    }

    public static String[] combinarNombresYTipos(String[] nombres, String[] tipos) {
        int tamano = nombres.length + tipos.length;
        String[] combinado = new String[tamano];
        int indiceEscritura = 0;

        for (int i = 0; i < nombres.length; i++) {
            combinado[indiceEscritura] = nombres[i];
            indiceEscritura++;
            combinado[indiceEscritura] = tipos[i];
            indiceEscritura++;
        }
        return combinado;
    }

    public static String convertirEnterosATexto(int[] arreglo) {
        String texto = "[";
        for (int i = 0; i < arreglo.length; i++) {
            texto += arreglo[i];
            if (i < arreglo.length - 1) {
                texto += ", ";
            }
        }
        texto += "]";
        return texto;
    }

    public static String convertirTextosATexto(String[] arreglo) {
        String texto = "[";
        for (int i = 0; i < arreglo.length; i++) {
            texto += arreglo[i];
            if (i < arreglo.length - 1) {
                texto += ", ";
            }
        }
        texto += "]";
        return texto;
    }

    public static String construirDetallePuntos(String[] nombres, int[] codigos,
                                                String[] tipos, double[] kilos, double[] valores) {
        String detalle = "";
        for (int i = 0; i < nombres.length; i++) {
            detalle += "Punto " + (i + 1) + ": " + nombres[i]
                    + " | Codigo: " + codigos[i]
                    + " | Material: " + tipos[i]
                    + " | Kilogramos: " + kilos[i]
                    + " | Valor por kilogramo: " + valores[i] + "\n";
        }
        return detalle;
    }

    public static String generarMensaje(String detallePuntos, double totalPagado,
                                        String nombreMayor, String unicosTexto, String combinadoTexto) {
        String mensaje = "===== RESUMEN DE LA JORNADA - RUTA VERDE S.A.S. =====\n"
                + detallePuntos
                + "\nValor total pagado: " + totalPagado
                + "\nPunto con mayor cantidad de kilogramos: " + nombreMayor
                + "\nCodigos unicos: " + unicosTexto
                + "\nNombres y tipos de material alternados: " + combinadoTexto;
        return mensaje;
    }

}