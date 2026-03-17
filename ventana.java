package graficos;

import javax.swing.*;
import java.awt.*;


public class ventana {

    public static void main(String[] args) {

        JFrame ventana = new JFrame("Casa");
        ventana.setSize(800, 600);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setLocationRelativeTo(null);

        JPanel panel = new JPanel() {
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);

                int w = getWidth();
                int offset = 80;

                g.setColor(new Color(135, 206, 235));
                g.fillRect(0, 0, w, getHeight());

                g.setColor(Color.GREEN);
                g.fillRect(0, 350 + offset, w, 50);

                g.setColor(new Color(139, 69, 19));
                g.fillRect(0, 400 + offset, w, 100);

                int casaW = 300;
                int casaH = 200;
                int casaX = (w - casaW) / 2;
                int casaY = 150 + offset;

                Color cafeClaroCasa = new Color(210, 140, 70);
                g.setColor(cafeClaroCasa);
                g.fillRect(casaX, casaY, casaW, casaH);

                int[] xTecho = {casaX - 10, casaX + casaW / 2, casaX + casaW + 10};
                int[] yTecho = {casaY, casaY - 100, casaY};
                g.setColor(Color.RED);
                g.fillPolygon(xTecho, yTecho, 3);

                int puertaX = casaX + casaW / 2 - 25;
                int puertaY = casaY + 120;

                g.setColor(new Color(101, 67, 33));
                g.fillRect(puertaX, puertaY, 50, 80);

                int ventanaX = casaX + 40;
                int ventanaY = casaY + 50;

                g.setColor(Color.WHITE);
                g.fillRect(ventanaX, ventanaY, 60, 60);

                g.setColor(Color.BLACK);
                g.drawRect(ventanaX, ventanaY, 60, 60);

                g.drawLine(ventanaX + 30, ventanaY, ventanaX + 30, ventanaY + 60);
                g.drawLine(ventanaX, ventanaY + 30, ventanaX + 60, ventanaY + 30);

                int cercaY = 330 + offset;

                Color cafeClaro = new Color(181, 101, 29);
                g.setColor(cafeClaro);

                for (int i = 0; i < puertaX; i += 25) {
                    g.fillRect(i, cercaY, 12, 80);
                    int[] xt = {i - 6, i + 6, i + 18};
                    int[] yt = {cercaY, cercaY - 35, cercaY};
                    g.fillPolygon(xt, yt, 3);
                }

                for (int i = puertaX + 50; i < w; i += 25) {
                    g.fillRect(i, cercaY, 12, 80);
                    int[] xt = {i - 6, i + 6, i + 18};
                    int[] yt = {cercaY, cercaY - 35, cercaY};
                    g.fillPolygon(xt, yt, 3);
                }

                g.fillRect(0, cercaY + 35, puertaX, 8);
                g.fillRect(puertaX + 50, cercaY + 35, w, 8);
            }
        };

        ventana.add(panel);
        ventana.setVisible(true);
    }
}