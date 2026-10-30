package reutilizacion;

import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.Image;
import java.net.URL;
import java.net.URLConnection;
import javax.imageio.ImageIO;

public class ImagenVentanasXD {

    public static void preguntarYMostrar() {

        String respuesta = Sc.nextLine(
                "¿Mostrar imagenes xD? (si/no):"
        );

        if (respuesta != null && respuesta.trim().replace("í", "i").replace("Í", "I").equalsIgnoreCase("si")) {

            mostrarCincoVentanas("https://img.lightshot.app/ug6OtR7vTUmAIaGlc71w9Q.png");

        }

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
                Print.println("No se pudo interpretar la imagen.");
            }

        } catch (Exception e) {
            Print.println("ERROR: " + e.getMessage());

        }
    }
}
