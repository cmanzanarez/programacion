package ventana;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class PanelUsuarios extends JFrame {

    public PanelUsuarios() {
        setTitle("Tabla de Usuarios");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        inicializarComponentes();
    }

    private void inicializarComponentes() {
        JPanel contenedor = new JPanel(new BorderLayout());
        contenedor.setBackground(new Color(52, 73, 94));

        JLabel titulo = new JLabel("Usuarios Registrados");
        titulo.setHorizontalAlignment(JLabel.CENTER);
        titulo.setFont(new Font("Segoe UI", Font.BOLD, 20));
        titulo.setForeground(Color.WHITE);
        titulo.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        String[] columnas = {"ID", "Nombre", "Correo electrónico", "Edad", "Estado"};
        DefaultTableModel modelo = new DefaultTableModel(columnas, 0);

        // Datos fake
        Object[][] datos = {
            {1, "Juan Pérez", "juan@gmail.com", 28, "Activo"},
            {2, "Don pancho", "pancho@gmail.com", 34, "Activo"},
            {3, "Carlos Ruiz", "carlos@gmail.com", 22, "Inactivo"},
            {4, "Ana Torres", "ana@gmail.com", 29, "Activo"},
            {5, "Luis Gómez", "luis@gmail.com", 41, "Inactivo"}
        };

        for (Object[] fila : datos) {
            modelo.addRow(fila);
        }

        JTable tabla = new JTable(modelo);
        tabla.setAutoResizeMode(JTable.AUTO_RESIZE_SUBSEQUENT_COLUMNS);
        tabla.getTableHeader().setReorderingAllowed(false); 

        JScrollPane scroll = new JScrollPane(tabla);
        scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

        contenedor.add(titulo, BorderLayout.NORTH);
        contenedor.add(scroll, BorderLayout.CENTER);

        setContentPane(contenedor);
        this.revalidate();
        this.repaint();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new PanelUsuarios().setVisible(true);
        });
    }
}