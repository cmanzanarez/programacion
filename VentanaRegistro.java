package ventana;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class VentanaRegistro  extends JFrame {

    public VentanaRegistro (String titulo, int ancho, int alto) {
        setTitle(titulo);
        setSize(ancho, alto);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        inicializarComponentes();
    }

    private void inicializarComponentes() {

        JPanel contenedor = new JPanel(new BorderLayout());
        contenedor.setBackground(new Color(52, 73, 94));

        JLabel titulo = new JLabel("FORMULARIO DE REGISTRO");
        titulo.setHorizontalAlignment(JLabel.CENTER);
        titulo.setFont(new Font("Segoe UI", Font.BOLD, 20));
        titulo.setForeground(Color.WHITE);

        JPanel panel = new JPanel(new GridLayout(6, 1, 10, 10));
        panel.setBackground(new Color(44, 62, 80));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 40, 20, 40));

        Border borde = BorderFactory.createLineBorder(Color.WHITE);

        JLabel lblUsuario = new JLabel("Usuario");
        lblUsuario.setForeground(Color.WHITE);

        JTextField usuario = new JTextField();
        usuario.setBorder(borde);

        JLabel lblBio = new JLabel("Biografía");
        lblBio.setForeground(Color.WHITE);

        JTextArea bio = new JTextArea(3, 20);
        bio.setBorder(borde);
        bio.setBackground(Color.WHITE);
        JScrollPane scrollBio = new JScrollPane(bio);

        JPanel preferencias = new JPanel();
        preferencias.setBackground(new Color(44, 62, 80));
        preferencias.setBorder(BorderFactory.createTitledBorder(borde, "Preferencias", 0, 0, null, Color.WHITE));

        JCheckBox op1 = new JCheckBox("Deportes");
        JCheckBox op2 = new JCheckBox("Música");
        JCheckBox op3 = new JCheckBox("Tecnología");

        JCheckBox[] ops = {op1, op2, op3};
        for (JCheckBox op : ops) {
            op.setBackground(new Color(44, 62, 80));
            op.setForeground(Color.WHITE);
            preferencias.add(op);
        }

        JPanel terminos = new JPanel();
        terminos.setBackground(new Color(44, 62, 80));
        terminos.setBorder(BorderFactory.createTitledBorder(borde, "Términos", 0, 0, null, Color.WHITE));

        JRadioButton aceptar = new JRadioButton("Aceptar");
        JRadioButton rechazar = new JRadioButton("Rechazar");

        ButtonGroup grupo = new ButtonGroup();
        grupo.add(aceptar);
        grupo.add(rechazar);

        JRadioButton[] radios = {aceptar, rechazar};
        for (JRadioButton r : radios) {
            r.setBackground(new Color(44, 62, 80));
            r.setForeground(Color.WHITE);
            terminos.add(r);
        }

        JPanel comboPanel = new JPanel();
        comboPanel.setBackground(new Color(44, 62, 80));
        comboPanel.setBorder(BorderFactory.createTitledBorder(borde, "Nivel", 0, 0, null, Color.WHITE));

        JComboBox<String> combo = new JComboBox<>(new String[]{"Básico", "Intermedio", "Avanzado"});
        comboPanel.add(combo);

        panel.add(lblUsuario);
        panel.add(usuario);
        panel.add(lblBio);
        panel.add(scrollBio);
        panel.add(preferencias);
        panel.add(terminos);

        contenedor.add(titulo, BorderLayout.NORTH);
        contenedor.add(panel, BorderLayout.CENTER);
        contenedor.add(comboPanel, BorderLayout.SOUTH);

        
        this.setContentPane(contenedor);
        this.revalidate();
        this.repaint();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new Ventana("Registro", 500, 500).setVisible(true);
        });
    }
}