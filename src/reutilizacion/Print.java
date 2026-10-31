package reutilizacion;

public class Print{

    public static String print(String msg){
        System.out.print(msg);
        return msg;
    }

    public static void println(){
        System.out.println();
    }

    public static void l(String msg){
        System.out.print(msg);
    }

    public static void ln(String msg){
        System.out.println(msg);
    }

    public static void objectoln(Object objeto){
        System.out.println(objeto);
    }

    public static void objectol(Object objeto) {
        System.out.print(objeto);
    }
}