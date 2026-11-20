

package parcial03;

import reutilizacion.*;
import practicaparciales.*;

public class EleccionPersonero2 {
    public static void main(String[] args) {

        int cantidadVotos = Sc.validarEnteroPositivo("Ingrese cuantos votos se van a recibir: (Mayor que 0)");
        int[] votosPorCandidato = new int[4];
        int votosNulos = registrarVotos(votosPorCandidato, cantidadVotos);

        determinarResultado(votosPorCandidato);
        mostrarVotos(votosPorCandidato, votosNulos);

    }

    public static boolean esCandidatoValido(int voto) {
        boolean valido = voto >= 1 && voto <= 4;
        return valido;
    }

    public static int registrarVotos(int[] votosPorCandidato, int cantidadVotos) {
        int votosNulos = 0;
        for (int i = 0; i < cantidadVotos; i++) {
            int voto = Sc.nextInt("Ingrese el voto " + (i + 1) + " (Candidato de 1 al 4): ");
            if (esCandidatoValido(voto)) {
                votosPorCandidato[voto - 1]++;
            } else {
                votosNulos++;
            }
        }
        return votosNulos;
    }

    public static void determinarResultado(int[] votosPorCandidato) {
        int posicionMayor = Sc.buscarPosicionMayorEntero(votosPorCandidato);
        int mayorVotos = votosPorCandidato[posicionMayor];
        int candidatosConMayor = Sc.contarVeces(votosPorCandidato, mayorVotos);
        String resultado = candidatosConMayor > 1 ? "Hay empate en el primer lugar" : "Ganador: candidado " + (posicionMayor + 1);

        Print.imprimirConSalto(resultado);
    }

    public static void mostrarVotos(int[] votosPorCandidato, int votosNulos) {

        // 1. Creamos un arreglo de String con el doble de tamaño para guardar pares [Etiqueta, Valor]
        // Más 2 espacios adicionales al final para incluir los "Votos nulos" dentro del mismo formato
        String[] datosEmparejados = new String[(votosPorCandidato.length * 2) + 2];

        // 2. Llenamos el arreglo intercalando el nombre del candidato (posiciones pares)
        // y su cantidad de votos convertida a String (posiciones impares)
        for (int i = 0; i < votosPorCandidato.length; i++) {
            datosEmparejados[i * 2] = "Candidato " + (i + 1);
            datosEmparejados[(i * 2) + 1] = String.valueOf(votosPorCandidato[i]);
        }

        // 3. Agregamos los votos nulos en las últimas dos posiciones del arreglo
        datosEmparejados[datosEmparejados.length - 2] = "Votos nulos";
        datosEmparejados[datosEmparejados.length - 1] = String.valueOf(votosNulos);

        // 4. Llamamos a convertirTextosATexto para imprimir todo emparejado y limpio en una sola línea
        // Salida esperada: [Candidato 1: 1, Candidato 2: 1, Candidato 3: 0, Candidato 4: 0, Votos nulos: 1]
        Print.imprimirConSalto("Resultados detallados: " + RutaVerdeV2.convertirTextosATexto(datosEmparejados));

        // 5. Llamamos a convertirEnterosATexto para mostrar el resumen técnico del arreglo original
        // Salida esperada: [1, 1, 0, 0]
        Print.imprimirConSalto("Conteo bruto (arreglo): " + RutaVerdeV2.convertirEnterosATexto(votosPorCandidato));
    }
}