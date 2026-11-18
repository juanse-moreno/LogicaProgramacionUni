package parcial03;

import reutilizacion.*;

public class EleccionPersonero{
    public static void main(String []args){

        int cantidadVotos = Sc.validarEnteroPositivo("Ingrese cuantos votos se van a recibir: (Mayor que 0)");
        int [] votosPorCandidato = new int [4];
        int votosNulos = registrarVotos(votosPorCandidato, cantidadVotos);

        determinarResultado(votosPorCandidato);
        mostrarVotos(votosPorCandidato, votosNulos);

    }

    public static boolean esCandidatoValido(int voto) {
        boolean valido = voto >= 1 && voto <=4;
        return valido;
    }

    public static int registrarVotos(int [] votosPorCandidato, int cantidadVotos){
        int votosNulos = 0;
        for (int i = 0; i < cantidadVotos; i++){
            int voto = Sc.nextInt("Ingrese el voto " +  (i + 1) + " (Candidato de 1 al 4): ");
            if (esCandidatoValido(voto)){
                votosPorCandidato[voto - 1]++;
            } else {
                votosNulos++;
            }
        }
        return votosNulos;
    }

    public static void determinarResultado(int [] votosPorCandidato){
        int posicionMayor = Sc.buscarPosicionMayorEntero(votosPorCandidato);
        int mayorVotos = votosPorCandidato[posicionMayor];
        int candidatosConMayor = Sc.contarVeces(votosPorCandidato, mayorVotos);
        String resultado = candidatosConMayor > 1 ? "Hay empate en el primer lugar" : "Ganador: candidado " + (posicionMayor + 1);

        Print.imprimirConSalto(resultado);
    }

    public static void mostrarVotos(int [] votosPorCandidato, int votosNulos){
        for (int i = 0; i < votosPorCandidato.length; i++){
            Print.imprimirConSalto("Candidato " + (i + 1) + ": " + votosPorCandidato[i] + " votos.");
        }
        Print.imprimirConSalto("Votos nulos " + votosNulos);
    }

}