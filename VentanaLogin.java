package ventana;

import javax.swing.*;
import java.awt.*;

public class VentanaLogin extends JFrame {

    public VentanaLogin() {
        setTitle("Login");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        inicializarComponentes();
    }

    private void inicializarComponentes() {
        JPanel contenedor = new JPanel();
        contenedor.setLayout(new BorderLayout());
        contenedor.setBackground(new Color(44, 62, 80));

        JPanel panelTitulo = new JPanel();
        panelTitulo.setBackground(new Color(52, 73, 94));

        JLabel titulo = new JLabel("ACCEDER");
        titulo.setFont(new Font("Segoe UI", Font.BOLD, 20));
        titulo.setForeground(Color.WHITE);

        panelTitulo.add(titulo);

        JPanel panelFormulario = new JPanel();
        panelFormulario.setLayout(new GridLayout(4, 1, 10, 10));
        panelFormulario.setBorder(BorderFactory.createEmptyBorder(20, 40, 20, 40));
        panelFormulario.setBackground(new Color(44, 62, 80));

        JTextField usuario = new JTextField();
        usuario.setFont(new Font("Segoe UI", Font.PLAIN, 14));

        JPasswordField password = new JPasswordField();
        password.setFont(new Font("Segoe UI", Font.PLAIN, 14));

        JCheckBox recordar = new JCheckBox("Recordarme");
        recordar.setForeground(Color.WHITE);
        recordar.setBackground(new Color(44, 62, 80));
        recordar.setFont(new Font("Segoe UI", Font.PLAIN, 12));

        JButton boton = new JButton("Acceder");
        boton.setFont(new Font("Segoe UI", Font.BOLD, 14));
        boton.setBackground(new Color(52, 152, 219));
        boton.setForeground(Color.WHITE);
        boton.setFocusPainted(false);

        panelFormulario.add(new JLabel("Usuario"));
        panelFormulario.add(usuario);
        panelFormulario.add(new JLabel("Contraseña"));
        panelFormulario.add(password);

        JPanel panelOpciones = new JPanel(new BorderLayout());
        panelOpciones.setBackground(new Color(44, 62, 80));
        panelOpciones.add(recordar, BorderLayout.WEST);

        JPanel panelBoton = new JPanel();
        panelBoton.setBackground(new Color(44, 62, 80));
        panelBoton.add(boton);

        contenedor.add(panelTitulo, BorderLayout.NORTH);
        contenedor.add(panelFormulario, BorderLayout.CENTER);
        contenedor.add(panelOpciones, BorderLayout.WEST);
        contenedor.add(panelBoton, BorderLayout.SOUTH);

        add(contenedor);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new VentanaLogin().setVisible(true);
        });
    }
}