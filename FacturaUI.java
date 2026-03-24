import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class FacturaUI extends JFrame {

    public FacturaUI() {
        setTitle("Sistema de Facturación");
        setSize(900, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(10, 10));

        // panel principal
        JPanel panelPrincipal = new JPanel();
        panelPrincipal.setLayout(new BoxLayout(panelPrincipal, BoxLayout.Y_AXIS));
        add(panelPrincipal);

      //Esto es pa los datos de los clientes
        JPanel clientePanel = new JPanel(new GridLayout(2, 4, 10, 10));
        clientePanel.setBorder(new TitledBorder("Datos del Cliente"));

        clientePanel.add(new JLabel("Nombre:"));
        clientePanel.add(new JTextField());
        clientePanel.add(new JLabel("Apellido:"));
        clientePanel.add(new JTextField());

        clientePanel.add(new JLabel("Teléfono:"));
        clientePanel.add(new JTextField());
        clientePanel.add(new JLabel("Correo:"));
        clientePanel.add(new JTextField());

        panelPrincipal.add(clientePanel);

        // Datos de capturas :v
        JPanel facturaPanel = new JPanel(new GridLayout(1, 4, 10, 10));
        facturaPanel.setBorder(new TitledBorder("Datos de Factura"));

        facturaPanel.add(new JLabel("No. Factura:"));
        facturaPanel.add(new JTextField());
        facturaPanel.add(new JLabel("Fecha:"));
        facturaPanel.add(new JTextField());

        panelPrincipal.add(facturaPanel);

       //Encabezado de la tabla
        JPanel headerTabla = new JPanel(new BorderLayout());

        JLabel titulo = new JLabel("📄 Listado de Facturas");
        headerTabla.add(titulo, BorderLayout.WEST);

        JPanel botones = new JPanel();
        botones.add(new JButton("➕ Añadir"));
        botones.add(new JButton("❌ Eliminar"));

        headerTabla.add(botones, BorderLayout.EAST);

        panelPrincipal.add(headerTabla);

      //La tabla
        String[] columnas = {"Producto", "Cantidad", "Valor", "Subtotal"};
        DefaultTableModel modelo = new DefaultTableModel(columnas, 0);

        JTable tabla = new JTable(modelo);
        JScrollPane scroll = new JScrollPane(tabla);

        panelPrincipal.add(scroll);

        //Resultados
        JPanel totalesPanel = new JPanel(new GridLayout(5, 2, 10, 10));

        totalesPanel.add(new JLabel("Subtotal:"));
        totalesPanel.add(new JTextField());

        totalesPanel.add(new JLabel("% Descuento:"));
        totalesPanel.add(new JTextField());

        totalesPanel.add(new JLabel("IVA:"));
        totalesPanel.add(new JTextField());

        totalesPanel.add(new JLabel("Total Factura:"));
        totalesPanel.add(new JTextField());

        panelPrincipal.add(totalesPanel);

     //boton
        JPanel footer = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        footer.add(new JButton("Finalizar Factura"));

        panelPrincipal.add(footer);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new FacturaUI().setVisible(true);
        });
    }
}
