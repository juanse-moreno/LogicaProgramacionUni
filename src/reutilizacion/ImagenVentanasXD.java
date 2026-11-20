package reutilizacion;

import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.Image;
import java.net.URL;
import java.net.URLConnection;
import javax.imageio.ImageIO;

public class ImagenVentanasXD {

    public static void preguntarYMostrar() {

        // MODIFICADO: la pregunta ahora ofrece tres opciones (antes era si/no)
        String respuesta = Sc.nextLine(
                "¿Qué imagen quieres ver? (1 = primera, 2 = segunda, 0 = ninguna): "
        );

        // MODIFICADO: ya no se compara con "si", así que se quita el reemplazo de tildes; solo se quitan los espacios
        String decision = "";
        if (respuesta != null) {
            decision = respuesta.trim();
        }

        // MODIFICADO: ahora se compara con "1" (antes con "si")
        if (decision.equals("1")) {

            // SIN CAMBIOS en el enlace: la imagen original pasa a ser la opción 1
            mostrarCincoVentanas("https://img.lightshot.app/ug6OtR7vTUmAIaGlc71w9Q.png");

            // MODIFICADO: ahora se compara con "2" (antes con "no")
        } else if (decision.equals("2")) {

            // SIN CAMBIOS en el enlace: la otra imagen pasa a ser la opción 2
            mostrarCincoVentanas("https://img.lightshot.app/2mf8TgYtTXOPwmfXrPl6hg.jpg");

            // NUEVO: cualquier valor distinto de 0 avisa que la opción no es válida
        } else if (!decision.equals("0")) {

            Print.imprimirConSalto("Opcion no valida. No se muestra ninguna imagen.");

        }
        // NUEVO (sin código): con 0 no entra a ningún bloque y no se muestra nada

    }

    public static void mostrarCincoVentanas(String enlace) {

        try {

            URL url = new URL(enlace);

            URLConnection conexion = url.openConnection();

            conexion.setRequestProperty("User-Agent", "Mozilla/5.0");
            conexion.setConnectTimeout(15000);
            conexion.setReadTimeout(15000);

            Image imagen = ImageIO.read(conexion.getInputStream());

            if (imagen != null) {

                ImageIcon icono = new ImageIcon(imagen);

                for (int i = 0; i < 5; i++) {

                    JFrame ventana = new JFrame("Imagen " + (i + 1));
                    ventana.setDefaultCloseOperation(
                            JFrame.DISPOSE_ON_CLOSE
                    );
                    ventana.setLayout(new BorderLayout());
                    JLabel etiqueta = new JLabel(icono);
                    ventana.add(etiqueta, BorderLayout.CENTER);
                    ventana.pack();
                    ventana.setLocation(50 + (i * 180), 50 + (i * 100));
                    ventana.setVisible(true);
                    ventana.setAlwaysOnTop(true);
                    ventana.toFront();
                    ventana.requestFocus();
                    Thread.sleep(500);
                }

            } else {
                Print.imprimirObjetoConSalto("No se pudo interpretar la imagen.");
            }

        } catch (Exception e) {
            Print.imprimirObjetoConSalto("ERROR: " + e.getMessage());

        }
    }
}
