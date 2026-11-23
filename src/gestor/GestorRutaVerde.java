package gestor;

import modelo.PuntoRecoleccion;

// [Ref #10] Clase gestora: encapsula el arreglo de objetos y toda la logica de negocio
public class GestorRutaVerde {

    // [Ref #10] Un solo arreglo de objetos reemplaza los arreglos paralelos
    private PuntoRecoleccion[] puntos;
    private int cantidadActual;

    // [Ref #10] Constructor: define la capacidad de la jornada
    public GestorRutaVerde(int capacidad) {
        this.puntos = new PuntoRecoleccion[capacidad];
        this.cantidadActual = 0;
    }

    // [Ref #11] Recibe un objeto ya construido y lo guarda en la siguiente posicion libre
    public boolean agregarPunto(PuntoRecoleccion punto) {
        boolean agregado = false;
        if (cantidadActual < puntos.length) {
            puntos[cantidadActual] = punto;
            cantidadActual++;
            agregado = true;
        }
        return agregado;
    }

    public int getCantidadActual() {
        return cantidadActual;
    }

    // [Ref #12] Total pagado: cada objeto calcula su valor y el gestor los acumula
    public double calcularTotalPagado() {
        double total = 0;
        for (int i = 0; i < cantidadActual; i++) {
            total += puntos[i].calcularValorPagado();
        }
        return total;
    }

    // [Ref #13] Punto con mas kilogramos (se compara con el getter del objeto)
    public int buscarPosicionMayor() {
        int posicionMayor = -1;
        if (cantidadActual > 0) {
            double mayor = puntos[0].getKilos();
            posicionMayor = 0;
            for (int i = 1; i < cantidadActual; i++) {
                if (puntos[i].getKilos() > mayor) {
                    mayor = puntos[i].getKilos();
                    posicionMayor = i;
                }
            }
        }
        return posicionMayor;
    }

    public String obtenerNombreMayor() {
        int posicion = buscarPosicionMayor();
        String nombre = "Sin datos";
        if (posicion >= 0) {
            nombre = puntos[posicion].getNombre();
        }
        return nombre;
    }

    // [Ref #14] Codigos unicos: ahora la comparacion se hace entre objetos del arreglo
    private boolean yaAparecioAntes(int posicion) {
        boolean aparecio = false;
        for (int j = 0; j < posicion; j++) {
            if (puntos[j].getCodigo() == puntos[posicion].getCodigo()) {
                aparecio = true;
            }
        }
        return aparecio;
    }

    private int contarCodigosUnicos() {
        int cantidadUnicos = 0;
        for (int i = 0; i < cantidadActual; i++) {
            if (!yaAparecioAntes(i)) {
                cantidadUnicos++;
            }
        }
        return cantidadUnicos;
    }

    public int[] generarCodigosUnicos() {
        int[] unicos = new int[contarCodigosUnicos()];
        int indiceEscritura = 0;

        for (int i = 0; i < cantidadActual; i++) {
            if (!yaAparecioAntes(i)) {
                unicos[indiceEscritura] = puntos[i].getCodigo();
                indiceEscritura++;
            }
        }
        return unicos;
    }

    // [Ref #15] Combinacion alternada nombre-tipo: se arma leyendo cada objeto (ya no hay dos arreglos separados)
    public String[] combinarNombresYTipos() {
        String[] combinado = new String[cantidadActual * 2];
        int indiceEscritura = 0;

        for (int i = 0; i < cantidadActual; i++) {
            combinado[indiceEscritura] = puntos[i].getNombre();
            indiceEscritura++;
            combinado[indiceEscritura] = puntos[i].getTipo();
            indiceEscritura++;
        }
        return combinado;
    }

    // [Ref #16] Reportes: el gestor delega el detalle de cada punto al propio objeto
    public String construirDetallePuntos() {
        String detalle = "";
        for (int i = 0; i < cantidadActual; i++) {
            detalle += puntos[i].generarDetalle(i + 1) + "\n";
        }
        return detalle;
    }

    private String convertirEnterosATexto(int[] arreglo) {
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

    private String convertirTextosATexto(String[] arreglo) {
        String texto = "[";
        int i = 0;
        while (i + 1 < arreglo.length) {
            texto += arreglo[i] + ": " + arreglo[i + 1];
            if (i + 2 < arreglo.length) {
                texto += ", ";
            }
            i += 2;
        }
        if (i < arreglo.length) {
            texto += arreglo[i];
        }
        texto += "]";
        return texto;
    }

    // [Ref #17] Mensaje resumen: el gestor orquesta sus propios metodos y devuelve el texto final
    public String generarMensaje() {
        String totalTexto = reutilizacion.Sc.convertirDecimalATexto(calcularTotalPagado());
        String unicosTexto = convertirEnterosATexto(generarCodigosUnicos());
        String combinadoTexto = convertirTextosATexto(combinarNombresYTipos());

        String mensaje = "===== RESUMEN DE LA JORNADA - RUTA VERDE S.A.S. =====\n"
                + construirDetallePuntos()
                + "\nValor total pagado: " + totalTexto
                + "\nPunto con mayor cantidad de kilogramos: " + obtenerNombreMayor()
                + "\nCodigos unicos: " + unicosTexto
                + "\nNombres y tipos de material alternados: " + combinadoTexto;
        return mensaje;
    }
}