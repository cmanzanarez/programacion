package ventana;

import javax.swing.*;
import java.awt.event.ActionListener;

public class VentanaConMenu extends JFrame {

    public VentanaConMenu() {
        setTitle("Menú Simple");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        inicializarMenu();
    }

    private void inicializarMenu() {
        JMenuBar menuBar = new JMenuBar();

        JMenu menuArchivo = new JMenu("Archivo");

        JMenuItem menuAbrir = new JMenuItem("Abrir");
        menuAbrir.addActionListener(e -> JOptionPane.showMessageDialog(this, "Has seleccionado Abrir"));

        JMenuItem menuNuevo = new JMenuItem("Nuevo");
        menuNuevo.addActionListener(e -> JOptionPane.showMessageDialog(this, "Has seleccionado Nuevo"));

        menuArchivo.add(menuAbrir);
        menuArchivo.add(menuNuevo);

        menuBar.add(menuArchivo);
        setJMenuBar(menuBar);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new VentanaConMenu().setVisible(true));
    }
}