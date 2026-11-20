package reutilizacion;

public class DibujarFigura {
    //Estética para sustentacion XD
    public static void dibujarPiramide(String palabra){
        for (int fila = 1; fila <= palabra.length(); fila++) {
            for (int esp = 1; esp <= palabra.length() - fila; esp++) {
                Print.imprimirSinSalto(" ");
            }
            for (int asterisco = 1; asterisco <= 2 * fila - 1; asterisco++) {
                Print.imprimirSinSalto("*");
            }
            Print.imprimirSaltoLinea();
        }

    }

    public static void dibujarTriangulo(String palabra){
        for (int fila = 1; fila <= palabra.length(); fila++){
            for (int asterisco = 1; asterisco <= fila; asterisco++){
                Print.imprimirSinSalto("*");
            }
            Print.imprimirSaltoLinea();
        }
    }

}
