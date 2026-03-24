package ventana;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Calculadora extends JFrame implements ActionListener {

    private JTextField pantalla;
    private String operacion = "";
    private double resultado = 0;
    private String operadorActual = "";

    public Calculadora() {
        setTitle("Calculadora");
        setSize(300, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        inicializarComponentes();
    }

    private void inicializarComponentes() {
        JPanel contenedor = new JPanel(new BorderLayout());
        contenedor.setBackground(Color.DARK_GRAY);

        pantalla = new JTextField();
        pantalla.setFont(new Font("Segoe UI", Font.BOLD, 24));
        pantalla.setHorizontalAlignment(JTextField.RIGHT);
        pantalla.setEditable(false);
        pantalla.setBackground(Color.BLACK);
        pantalla.setForeground(Color.WHITE);
        pantalla.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        contenedor.add(pantalla, BorderLayout.NORTH);

        JPanel panelBotones = new JPanel(new GridLayout(5, 4, 5, 5));
        panelBotones.setBackground(Color.DARK_GRAY);
        String[] botones = {
            "CE", "", "", "/",
            "7", "8", "9", "*",
            "4", "5", "6", "-",
            "1", "2", "3", "+",
            "0", "0", ".", "="
        };

        for (String texto : botones) {
            JButton boton = new JButton(texto);
            boton.setFont(new Font("Segoe UI", Font.BOLD, 18));

            if (texto.equals("") ) {
                boton.setEnabled(false);
            } else if ("0123456789.".contains(texto)) {
                boton.setBackground(Color.LIGHT_GRAY);
            } else if (texto.equals("CE")) {
                boton.setBackground(Color.ORANGE);
            } else {
                boton.setBackground(Color.CYAN);
            }

            boton.setForeground(Color.BLACK);
            boton.addActionListener(this);
            panelBotones.add(boton);
        }

        contenedor.add(panelBotones, BorderLayout.CENTER);
        add(contenedor);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String comando = ((JButton)e.getSource()).getText();

        if ("0123456789.".contains(comando)) {
            pantalla.setText(pantalla.getText() + comando);
        } else if (comando.equals("CE")) {
            pantalla.setText("");
            resultado = 0;
            operadorActual = "";
        } else if (comando.equals("=")) {
            calcularResultado();
            operadorActual = "";
        } else { 
            if (!pantalla.getText().isEmpty()) {
                if (!operadorActual.isEmpty()) {
                    calcularResultado();
                } else {
                    resultado = Double.parseDouble(pantalla.getText());
                }
                operadorActual = comando;
                pantalla.setText("");
            }
        }
    }

    private void calcularResultado() {
        if (operadorActual.isEmpty() || pantalla.getText().isEmpty()) return;
        double valor = Double.parseDouble(pantalla.getText());
        switch (operadorActual) {
            case "+": resultado += valor; break;
            case "-": resultado -= valor; break;
            case "*": resultado *= valor; break;
            case "/": resultado /= valor; break;
        }
        pantalla.setText(String.valueOf(resultado));
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new Calculadora().setVisible(true);
        });
    }
}