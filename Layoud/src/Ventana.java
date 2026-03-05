import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Ventana extends JFrame implements ActionListener {

    JTextField txtCapital, txtTiempo, txtTasa;
    JTextField txtInteres, txtMonto;
    JButton btnCalcular, btnCancelar;

    public Ventana() {

        setTitle("Calculadora de Interes");
        setSize(400,300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setLayout(new BorderLayout());

    
        JLabel titulo = new JLabel("interés", JLabel.CENTER);
        titulo.setFont(new Font("Arial", Font.BOLD, 18));
        add(titulo, BorderLayout.NORTH);

       
        JPanel panelDatos = new JPanel();
        panelDatos.setLayout(new GridLayout(3,2,5,5));

        panelDatos.add(new JLabel("Capital:"));
        txtCapital = new JTextField();
        panelDatos.add(txtCapital);

        panelDatos.add(new JLabel("Tiempo:"));
        txtTiempo = new JTextField();
        panelDatos.add(txtTiempo);

        panelDatos.add(new JLabel("Tasa (%):"));
        txtTasa = new JTextField();
        panelDatos.add(txtTasa);

        add(panelDatos, BorderLayout.CENTER);

        JPanel panelResultados = new JPanel();
        panelResultados.setLayout(new GridLayout(2,2,5,5));

        panelResultados.add(new JLabel("Interés:"));
        txtInteres = new JTextField();
        txtInteres.setEditable(false);
        panelResultados.add(txtInteres);

        panelResultados.add(new JLabel("Monto Total:"));
        txtMonto = new JTextField();
        txtMonto.setEditable(false);
        panelResultados.add(txtMonto);

        add(panelResultados, BorderLayout.SOUTH);

        setVisible(true);
        JPanel panelBotones = new JPanel();
        panelBotones.setLayout(new FlowLayout());

        btnCalcular = new JButton("Calcular", new ImageIcon("calcular.png"));
        btnCancelar = new JButton("Cancelar", new ImageIcon("cancelar.png"));

        btnCalcular.addActionListener(this);
        btnCancelar.addActionListener(this);

        panelBotones.add(btnCalcular);
        panelBotones.add(btnCancelar);

        add(panelBotones, BorderLayout.WEST);

        
    }

 
    public void actionPerformed(ActionEvent e) {

        if(e.getSource() == btnCalcular){

            double capital = Double.parseDouble(txtCapital.getText());
            double tiempo = Double.parseDouble(txtTiempo.getText());
            double tasa = Double.parseDouble(txtTasa.getText());

            double interes = capital * tasa * tiempo / 100;
            double monto = capital + interes;

            txtInteres.setText(String.valueOf(interes));
            txtMonto.setText(String.valueOf(monto));
        }

        if(e.getSource() == btnCancelar){
            txtCapital.setText("");
            txtTiempo.setText("");
            txtTasa.setText("");
            txtInteres.setText("");
            txtMonto.setText("");
        }
    }

    public static void main(String[] args) {
        new Ventana();
    }
}
