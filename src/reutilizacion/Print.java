package reutilizacion;

// [Ref #4] Print se mantiene como utilidad 100% static: no guarda estado, por eso no necesita constructor ni atributos
public class Print{

    public static String imprimirTextoYRetornar(String msg){
        System.out.print(msg);
        return msg;
    }

    public static void imprimirSaltoLinea(){
        System.out.println();
    }

    public static void imprimirSinSalto(String msg){
        System.out.print(msg);
    }

    public static void imprimirConSalto(String msg){
        System.out.println(msg);
    }

    public static void imprimirObjetoConSalto(Object objeto){
        System.out.println(objeto);
    }

    public static void imprimirObjetoSinSalto(Object objeto) {
        System.out.print(objeto);
    }
    public static void mostrarMensaje(String mensaje) {
        Print.imprimirConSalto(mensaje);
    }
}
