package modelo;

import reutilizacion.Sc;

// [Ref #5] Clase modelo: cada objeto representa UN punto de recoleccion (reemplaza los 5 arreglos paralelos)
public class PuntoRecoleccion {

    // [Ref #5] Atributos privados de instancia (encapsulamiento, sin static)
    private String nombre;
    private int codigo;
    private String tipo;
    private double kilos;
    private double valorPorKilo;

    // [Ref #5] Constructor: crea el objeto ya completo y con el tipo normalizado
    public PuntoRecoleccion(String nombre, int codigo, String tipo, double kilos, double valorPorKilo) {
        this.nombre = nombre;
        this.codigo = codigo;
        this.tipo = normalizarTipo(tipo);
        this.kilos = kilos;
        this.valorPorKilo = valorPorKilo;
    }

    // [Ref #6] Getters y setters: unica puerta de acceso a los atributos privados
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getTipo() {
        return tipo;
    }

    // [Ref #6] El setter protege el estado: solo acepta materiales validos
    public void setTipo(String tipo) {
        if (esMaterialValido(tipo)) {
            this.tipo = normalizarTipo(tipo);
        }
    }

    public double getKilos() {
        return kilos;
    }

    public void setKilos(double kilos) {
        this.kilos = kilos;
    }

    public double getValorPorKilo() {
        return valorPorKilo;
    }

    public void setValorPorKilo(double valorPorKilo) {
        this.valorPorKilo = valorPorKilo;
    }

    // [Ref #7] Comportamiento propio: el objeto sabe cuanto se pago por su recoleccion
    public double calcularValorPagado() {
        return kilos * valorPorKilo;
    }

    // [Ref #8] Comportamiento propio: el objeto sabe describirse a si mismo
    public String generarDetalle(int numero) {
        String detalle = "Punto " + numero + ": " + nombre
                + " | Codigo: " + codigo
                + " | Material: " + tipo
                + " | Kilogramos: " + Sc.convertirDecimalATexto(kilos)
                + " | Valor por kilogramo: " + Sc.convertirDecimalATexto(valorPorKilo);
        return detalle;
    }

    // [Ref #9] Metodos static: reglas de la clase (no dependen de un punto concreto) y se usan antes de crear el objeto
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

    public static String normalizarTipo(String tipo) {
        String normalizado = "";
        if (tipo.equalsIgnoreCase("plastico") || tipo.equalsIgnoreCase("plástico")) {
            normalizado = "plastico";
        } else if (tipo.equalsIgnoreCase("carton") || tipo.equalsIgnoreCase("cartón")) {
            normalizado = "carton";
        } else if (tipo.equalsIgnoreCase("vidrio")) {
            normalizado = "vidrio";
        }
        return normalizado;
    }
}