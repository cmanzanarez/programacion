package ventana;

import javax.swing.*;
import java.awt.*;

public class VentanaConLogo extends JFrame {

    public VentanaConLogo() {
        setTitle("Mi Aplicación con Identidad Visual");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        inicializarComponentes();
    }

    private void inicializarComponentes() {
      
        JPanel panel = new JPanel();
        panel.setBackground(new Color(52, 152, 219));
        panel.setLayout(new BorderLayout());

        
        ImageIcon logoIcon = new ImageIcon(getClass().getResource("/imagenes/gengar.webp"));
        JLabel lblLogo = new JLabel(logoIcon);
        lblLogo.setHorizontalAlignment(JLabel.CENTER);
        panel.add(lblLogo, BorderLayout.CENTER);

       
        setContentPane(panel);

       
        Image iconoVentana = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/imagenes/kk.webp"));
        setIconImage(iconoVentana);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new VentanaConLogo().setVisible(true));
    }
}