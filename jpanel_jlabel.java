package ventana;

import javax.swing.*;
import java.awt.*;

public class jpanel_jlabel extends JFrame {

    public jpanel_jlabel(String titulo, int ancho, int alto) {
        setTitle(titulo);
        setSize(ancho, alto);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        inicializarComponentes();
    }

    private void inicializarComponentes() {
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        panel.setBackground(new Color(30, 144, 255));

        JLabel titulo = new JLabel("Titulo");
        titulo.setHorizontalAlignment(JLabel.CENTER);
        titulo.setFont(new Font("Arial", Font.BOLD, 24));
        titulo.setForeground(Color.WHITE);

        panel.add(titulo, BorderLayout.CENTER);
        add(panel);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            jpanel_jlabel v = new jpanel_jlabel("Ejemplo JLabel", 500, 300);
            v.setLocationRelativeTo(null);
            v.setVisible(true);
        });
    }
}