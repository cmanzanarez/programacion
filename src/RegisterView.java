import javax.swing.*;
import java.awt.*;

public class RegisterView extends JFrame {

    public RegisterView(AuthController controller) {

        setTitle("Registro");
        setSize(400, 350);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        JLabel titulo = new JLabel("Registro de Usuario");
        titulo.setFont(new Font("Arial", Font.BOLD, 20));
        titulo.setBounds(90, 20, 250, 30);

        JLabel usuarioLabel = new JLabel("Usuario:");
        usuarioLabel.setBounds(50, 80, 100, 25);

        JTextField usuarioTxt = new JTextField();
        usuarioTxt.setBounds(150, 80, 180, 25);

        JLabel passLabel = new JLabel("Contraseña:");
        passLabel.setBounds(50, 130, 100, 25);

        JPasswordField passTxt = new JPasswordField();
        passTxt.setBounds(150, 130, 180, 25);

        JLabel emailLabel = new JLabel("Email:");
        emailLabel.setBounds(50, 180, 100, 25);

        JTextField emailTxt = new JTextField();
        emailTxt.setBounds(150, 180, 180, 25);

        JButton registrarBtn = new JButton("Registrar");
        registrarBtn.setBounds(130, 240, 120, 35);

        registrarBtn.addActionListener(e -> {

            String usuario = usuarioTxt.getText();

            String contrasena = String.valueOf(
                    passTxt.getPassword()
            );

            String email = emailTxt.getText();

            controller.registrar(
                    usuario,
                    contrasena,
                    email
            );

            JOptionPane.showMessageDialog(
                    this,
                    "Usuario registrado correctamente"
            );

        });

        add(titulo);
        add(usuarioLabel);
        add(usuarioTxt);
        add(passLabel);
        add(passTxt);
        add(emailLabel);
        add(emailTxt);
        add(registrarBtn);

        setLocationRelativeTo(null);
        setVisible(true);

    }

    public static void main(String[] args) {

        AuthController controller = new AuthController();

        new RegisterView(controller);

    }

}