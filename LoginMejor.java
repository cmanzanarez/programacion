package ventana;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class LoginMejor extends JFrame {

    public LoginMejor() {
        setTitle("Login Moderno");
        setSize(450, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        inicializarComponentes();
    }

    private void inicializarComponentes() {
        JPanel fondo = new JPanel();
        fondo.setLayout(null);
        fondo.setBackground(new Color(52, 73, 94));
        setContentPane(fondo);

        JLabel lblTitulo = new JLabel("Bienvenido");
        lblTitulo.setBounds(90, 30, 300, 50);
        lblTitulo.setFont(new Font("Segoe UI", Font.BOLD | Font.ITALIC, 28));
        lblTitulo.setForeground(Color.WHITE);
        fondo.add(lblTitulo);

        JTextField usuario = new JTextField();
        usuario.setBounds(75, 100, 300, 35);
        usuario.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        fondo.add(usuario);

        JPasswordField password = new JPasswordField();
        password.setBounds(75, 150, 300, 35);
        password.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        fondo.add(password);

        JButton btnLogin = new JButton("LOGIN");
        btnLogin.setBounds(75, 210, 300, 40);
        btnLogin.setFont(new Font("Segoe UI", Font.BOLD, 16));
        btnLogin.setBackground(new Color(52, 152, 219));
        btnLogin.setForeground(Color.WHITE);
        btnLogin.setBorder(BorderFactory.createEmptyBorder());
        btnLogin.setFocusPainted(false);
        btnLogin.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent e) { btnLogin.setBackground(new Color(41, 128, 185)); }
            public void mouseExited(MouseEvent e) { btnLogin.setBackground(new Color(52, 152, 219)); }
        });
        fondo.add(btnLogin);

        JButton btnSignUp = new JButton("SIGN UP");
        btnSignUp.setBounds(75, 270, 300, 40);
        btnSignUp.setFont(new Font("Segoe UI", Font.ITALIC, 14));
        btnSignUp.setBackground(new Color(231, 76, 60));
        btnSignUp.setForeground(Color.WHITE);
        btnSignUp.setBorder(BorderFactory.createEmptyBorder());
        btnSignUp.setFocusPainted(false);
        btnSignUp.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent e) { btnSignUp.setBackground(new Color(192, 57, 43)); }
            public void mouseExited(MouseEvent e) { btnSignUp.setBackground(new Color(231, 76, 60)); }
        });
        fondo.add(btnSignUp);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new LoginMejor().setVisible(true));
    }
}