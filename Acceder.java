import java.awt.EventQueue;
import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.Color;

public class Acceder extends JFrame {

    JPanel contentPane;
    JTextField txtUsuario;
    JPasswordField txtPassword;
    JTextArea txtBio;
    JCheckBox Opcion1, Opcion2, Terminos;
    JButton Acceder, Crear;

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                Acceder frame = new Acceder();
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public Acceder() {
        setTitle("Formulario");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 400, 400);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(128, 128, 192));
        contentPane.setLayout(null);
        setContentPane(contentPane);

        JLabel Usuario = new JLabel("Usuario:");
        Usuario.setBounds(20, 20, 100, 20);
        contentPane.add(Usuario);

        txtUsuario = new JTextField();
        txtUsuario.setBounds(93, 18, 200, 25);
        contentPane.add(txtUsuario);

        JLabel Contraseña = new JLabel("Contraseña:");
        Contraseña.setBounds(20, 60, 100, 20);
        contentPane.add(Contraseña);

        txtPassword = new JPasswordField();
        txtPassword.setBounds(93, 56, 200, 25);
        contentPane.add(txtPassword);

        JLabel Bio = new JLabel("Bio:");
        Bio.setBounds(20, 100, 100, 20);
        contentPane.add(Bio);

        txtBio = new JTextArea();
        txtBio.setBounds(93, 98, 200, 50);
        contentPane.add(txtBio);

        Opcion1 = new JCheckBox("Recordarme");
        Opcion1.setBounds(93, 184, 100, 20);
        contentPane.add(Opcion1);

        Opcion2 = new JCheckBox("Mantener la sesión");
        Opcion2.setBounds(195, 184, 150, 20);
        contentPane.add(Opcion2);

        Terminos = new JCheckBox("Aceptar términos");
        Terminos.setBounds(95, 220, 200, 20);
        contentPane.add(Terminos);

        Acceder = new JButton("Acceder");
        Acceder.setBounds(58, 263, 120, 30);
        contentPane.add(Acceder);

        Crear = new JButton("Crear cuenta");
        Crear.setBounds(202, 263, 140, 30);
        Crear.setEnabled(false); 
        contentPane.add(Crear);

        JLabel lblNewLabel = new JLabel("Preferencias");
        lblNewLabel.setBounds(150, 161, 100, 14);
        contentPane.add(lblNewLabel);

       
        Terminos.addActionListener(e -> {
            Crear.setEnabled(Terminos.isSelected());
        });

       
        Acceder.addActionListener(e -> {
            String usuario = txtUsuario.getText();
            String password = new String(txtPassword.getPassword());

           
            String usuarioCorrecto = "cereno@gmail.com";
            String passwordCorrecto = "123456";

            boolean correcto = usuario.equals(usuarioCorrecto) && password.equals(passwordCorrecto);

           
            txtUsuario.setBorder(new LineBorder(correcto ? Color.GREEN : Color.RED, 2));
            txtPassword.setBorder(new LineBorder(correcto ? Color.GREEN : Color.RED, 2));

            if (correcto) {
                JOptionPane.showMessageDialog(this, "Bienvenido usuario");
            } else {
                JOptionPane.showMessageDialog(this, "Error: usuario o contraseña incorrectos");
            }
        });

      
        Crear.addActionListener(e -> {
        	String usuario = txtUsuario.getText().trim();
        	String password = new String(txtPassword.getPassword()).trim();
            String bio = txtBio.getText();

            boolean u = !usuario.isEmpty() && !usuario.contains(" ");
            boolean p = password.length() >= 6 && !password.contains(" ");
            boolean b = bio.isEmpty() || bio.length() >= 5;
            boolean pref = Opcion1.isSelected() || Opcion2.isSelected();
            boolean t = Terminos.isSelected();

            txtUsuario.setBorder(new LineBorder(u ? Color.GREEN : Color.RED, 2));
            txtPassword.setBorder(new LineBorder(p ? Color.GREEN : Color.RED, 2));
            txtBio.setBorder(new LineBorder(b ? Color.GREEN : Color.RED, 2));

            Opcion1.setForeground(pref ? Color.BLACK : Color.RED);
            Opcion2.setForeground(pref ? Color.BLACK : Color.RED);
            Terminos.setForeground(t ? Color.BLACK : Color.BLACK);

            if (u && p && b && pref && t) {
                JOptionPane.showMessageDialog(this, "Registro exitoso");
            }
        });
    }
}
