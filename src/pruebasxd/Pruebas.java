package pruebasxd;

import reutilizacion.*;

import javax.swing.*;
import java.net.URL;
import java.net.URLConnection;
import java.awt.Image;
import java.awt.BorderLayout;
import javax.imageio.ImageIO;

public class Pruebas {

    public static void main(String[] args) {

        double[] notas = new double[5];

        String[] top = {
                "Torta de chocolate",
                "Helado",
                "Muffin",
                "Ensalada de frutas",
                "Malteada"
        };

        Print.println("CÓDIGO 1");
        mostrarTop(top);

        Print.println("CÓDIGO 2");
        leerNotas(notas);
        mostrarResumen(notas);

        String respuesta = Sc.nextLine("¿Quieres que se muestren las ventanas? (si/no):");

        if (respuesta != null && respuesta.trim().equalsIgnoreCase("si")) {

            try {

                URL url = new URL("https://img.lightshot.app/ug6OtR7vTUmAIaGlc71w9Q.png");

                URLConnection conexion = url.openConnection();

                conexion.setRequestProperty("User-Agent", "Mozilla/5.0");
                conexion.setConnectTimeout(15000);
                conexion.setReadTimeout(15000);

                Image imagen = ImageIO.read(conexion.getInputStream());

                if (imagen != null) {

                    ImageIcon icono = new ImageIcon(imagen);

                    // Abrir 5 ventanas
                    for (int i = 0; i < 5; i++) {

                        JFrame ventana = new JFrame("Imagen " + (i + 1));

                        ventana.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

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

                JOptionPane.showMessageDialog(
                        null,
                        "Error al cargar imagen: " + e.getMessage(),
                        "Error al cargar imagen",
                        JOptionPane.ERROR_MESSAGE
                );

            }

        }

    }

    public static void mostrarTop(String[] top) {

        Print.print("Mi top " + top.length + " de postres\n");

        for (int i = 1; i <= top.length; i++) {

            Print.println(i + ". " + top[i - 1]);

        }

    }

    public static void leerNotas(double[] notas) {

        for (int i = 0; i < notas.length; i++) {

            notas[i] = Sc.nextDouble("Primer nota del estudiante " + (i + 1) + " : ");

        }

    }

    public static void mostrarResumen(double[] notas) {

        double suma = 0;
        int aprobados = 0;

        for (int i = 0; i < notas.length; i++) {

            suma += notas[i];

            if (notas[i] >= 3.0) {

                aprobados++;

            }

        }

        double promedio = suma / notas.length;

        Print.println("Promedio del grupo: " + promedio);

        Print.println("Aprobados: " + aprobados + " de " + notas.length);

    }

}
