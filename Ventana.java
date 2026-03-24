package ventana;

import javax.swing.*;
import java.awt.*;

public class Ventana extends JFrame {

    public Ventana(String titulo, int ancho, int alto) {
        configurarTitulo(titulo);
        configurarTamano(ancho, alto);
        configurarCierre();
    }

    public void configurarVisibilidad(boolean visible) {
        this.setVisible(visible);
    }

    public void configurarTitulo(String titulo) {
        this.setTitle(titulo);
    }

    public void configurarTamano(int ancho, int alto) {
        this.setSize(ancho, alto); 
    }

    public void configurarTamanoMinimo(int ancho, int alto) {
        this.setMinimumSize(new Dimension(ancho, alto));
    }

    public void configurarTamanoMaximo(int ancho, int alto) {
        this.setMaximumSize(new Dimension(ancho, alto));
    }

    public void configurarLayout(LayoutManager layout) {
        this.getContentPane().setLayout(layout);
    }

    public void configurarUbicacion(int x, int y) {
        this.setLocation(x, y);
    }

    public void centrarVentana() {
        this.setLocationRelativeTo(null);
    }

    public void configurarOpacidad(float opacidad) {
        this.setUndecorated(true); 
        this.setOpacity(opacidad);
    }

    public void configurarColorFondo(Color color) {
        this.getContentPane().setBackground(color);
    }

    private void configurarCierre() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> { 
            Ventana v = new Ventana("Mi Ventana", 500, 400);

            v.configurarTamanoMinimo(300, 200);
            v.configurarTamanoMaximo(800, 600);
            v.configurarLayout(new BorderLayout());
            v.centrarVentana();
            v.configurarColorFondo(Color.LIGHT_GRAY);



            v.configurarVisibilidad(true);
        });
    }
}
