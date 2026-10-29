import java.util.Scanner;

public class Sc {
    public static Scanner sc = new Scanner(System.in);

    public static int nextInt(String mensaje){
        Print.l(mensaje);
        return sc.nextInt();
    }
    public static double nextDouble(String mensaje){
        Print.l(mensaje);
        return sc.nextDouble();
    }
    public static boolean nextBoolean(String mensaje){
        Print.l(mensaje);
        return sc.nextBoolean();
    }
    public static String nextLine(String mensaje){
        Print.l(mensaje);
        return sc.nextLine();
    }
    public static String nextScan(){
        return sc.nextLine();
    }


}