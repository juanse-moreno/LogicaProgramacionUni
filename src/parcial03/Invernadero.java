package parcial03;

import reutilizacion.*;

public class Invernadero {
    public static void main(String[] args) {
        int cantidad = Sc.validarEnteroPositivo("Ingrese cuantas lecturas se van a registrar (Mayor que 0): ");

        double [] temperaturas = new double[cantidad];
        llenarTemperaturas(temperaturas);

        double promedio = Sc.calcularPromedioDecimales(temperaturas);
        int sobrePromedio = Sc.contarMayoresQueDecimal(temperaturas,promedio);
        int posicionMayor = Sc.buscarPosicionMayorDecimal(temperaturas);
        boolean simetrico = esSimetrico(temperaturas);

        Print.imprimirConSalto("Promedio de las temperaturas: " + promedio);
        Print.imprimirConSalto("Lecturas por encima del promedio: " + sobrePromedio);
        Print.imprimirConSalto("Posición de la lectura más alta: " + (posicionMayor + 1));
        Print.imprimirConSalto(simetrico ? "Perfil simétrico" : "Perfil irregular");
    }

    // La lectura se repite dentro del for: el índice no avanza hasta que sea válida
    public static void llenarTemperaturas(double[] temperaturas){
        for (int i = 0; i < temperaturas.length; i++){
            temperaturas[i] = Sc.validarDecimalEnRango("Ingrese la temperatura " + (i + 1) + " entre -10 y 60): ",-10, 60);
        }
    }

    public static boolean esSimetrico(double [] arreglo){
        boolean simetrico = true;
        for (int i = 0; i < arreglo.length / 2; i++){
            if (arreglo[i] != arreglo[arreglo.length - 1 - i]){
                simetrico = false;
            }
        }
        return simetrico;
    }

}