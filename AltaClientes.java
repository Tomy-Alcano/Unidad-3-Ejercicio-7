import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.*;

public class AltaClientes {

    private static DefaultTableModel modelo;

    public static void cargarDatos() {

        modelo.setRowCount(0);

        try (
                Connection con = Conexion.conectar();

                Statement st = con.createStatement();

                ResultSet rs = st.executeQuery("SELECT * FROM clientes")
        ) {

            while (rs.next()) {

                modelo.addRow(
                        new Object[]{
                                rs.getInt("id"),
                                rs.getString("nombre"),
                                rs.getString("email"),
                                rs.getString("telefono")
                        });
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {

            JFrame ventana = new JFrame("Alta de Clientes");
            ventana.setSize(800, 500);
            ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            ventana.setLocationRelativeTo(null);

            JPanel formulario = new JPanel(new GridLayout(4, 2, 5, 5));
            JTextField txtNombre = new JTextField();
            JTextField txtEmail = new JTextField();
            JTextField txtTelefono = new JTextField();

            JButton btnGuardar = new JButton("Guardar cliente");

            formulario.add(new JLabel("Nombre:"));
            formulario.add(txtNombre);

            formulario.add(new JLabel("Email:"));
            formulario.add(txtEmail);
            formulario.add(new JLabel("Teléfono:"));
            formulario.add(txtTelefono);
            formulario.add(new JLabel(""));
            formulario.add(btnGuardar);

            modelo =
                    new DefaultTableModel(new String[]{"ID", "Nombre", "Email", "Teléfono"}, 0);

            JTable tabla = new JTable(modelo);

            JScrollPane scroll = new JScrollPane(tabla);

            btnGuardar.addActionListener(e -> {

                String nombre = txtNombre.getText().trim();

                String email = txtEmail.getText().trim();

                String telefono = txtTelefono.getText().trim();

                if (nombre.isEmpty() || email.isEmpty() || telefono.isEmpty()) {

                    JOptionPane.showMessageDialog(ventana, "Todos los campos son obligatorios");

                    return;
                }

                try (
                        Connection con = Conexion.conectar();

                        PreparedStatement ps = con.prepareStatement("INSERT INTO clientes(nombre,email,telefono) VALUES (?,?,?)")
                ) {

                    ps.setString(1, nombre);
                    ps.setString(2, email);
                    ps.setString(3, telefono);

                    ps.executeUpdate();

                    cargarDatos();

                    txtNombre.setText("");
                    txtEmail.setText("");
                    txtTelefono.setText("");

                    JOptionPane.showMessageDialog(ventana, "Cliente guardado correctamente");

                } catch (Exception ex) {

                    JOptionPane.showMessageDialog(ventana, ex.getMessage());
                }
            });

            cargarDatos();

            ventana.add(formulario, BorderLayout.NORTH);

            ventana.add(scroll, BorderLayout.CENTER);

            ventana.setVisible(true);
        });
    }
}