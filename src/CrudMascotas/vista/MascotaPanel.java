package CrudMascotas.vista;

import CrudMascotas.controlador.dao.MascotaDAO;
import CrudMascotas.controlador.models.MascotaVO;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MascotaPanel extends JFrame {
    private JTextField ownerIdField, nombreMascotaField, razaField, sexoField;
    private JButton btnRegistrar;
    private JTextArea textAreaConsulta;

    public MascotaPanel() {
        setTitle("Registrar Mascota");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Centra la ventana en la pantalla

        // Panel principal con GridBagLayout para organizar los componentes
        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(5, 5, 5, 5); // Espacios entre componentes

        // Etiqueta y campo para el ID del Dueño
        JLabel ownerIdLabel = new JLabel("ID del Dueño:");
        gbc.gridx = 0;
        gbc.gridy = 0;
        panel.add(ownerIdLabel, gbc);

        ownerIdField = new JTextField(15);
        gbc.gridx = 1;
        panel.add(ownerIdField, gbc);

        // Etiqueta y campo para el Nombre de la Mascota
        JLabel nombreMascotaLabel = new JLabel("Nombre de la Mascota:");
        gbc.gridx = 0;
        gbc.gridy = 1;
        panel.add(nombreMascotaLabel, gbc);

        nombreMascotaField = new JTextField(15);
        gbc.gridx = 1;
        panel.add(nombreMascotaField, gbc);

        // Etiqueta y campo para la Raza
        JLabel razaLabel = new JLabel("Raza:");
        gbc.gridx = 0;
        gbc.gridy = 2;
        panel.add(razaLabel, gbc);

        razaField = new JTextField(15);
        gbc.gridx = 1;
        panel.add(razaField, gbc);

        // Etiqueta y campo para el Sexo
        JLabel sexoLabel = new JLabel("Sexo:");
        gbc.gridx = 0;
        gbc.gridy = 3;
        panel.add(sexoLabel, gbc);

        sexoField = new JTextField(15);
        gbc.gridx = 1;
        panel.add(sexoField, gbc);

        // Botón para registrar la mascota
        btnRegistrar = new JButton("Registrar Mascota");
        gbc.gridx = 1;
        gbc.gridy = 4;
        panel.add(btnRegistrar, gbc);

        // Área de texto para mostrar mensajes (como confirmación o errores)
        textAreaConsulta = new JTextArea(5, 20);
        textAreaConsulta.setEditable(false);
        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.BOTH;
        panel.add(new JScrollPane(textAreaConsulta), gbc);

        // Evento para el botón de registrar
        btnRegistrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MascotaDAO mascotaDAO = new MascotaDAO();
                try {
                    long ownerId = Long.parseLong(ownerIdField.getText());
                    String mascotaNombre = nombreMascotaField.getText();
                    String mascotaRaza = razaField.getText();
                    String mascotaSexo = sexoField.getText();
                    System.out.println(ownerId);
                    if (mascotaNombre.isEmpty() || mascotaRaza.isEmpty() || mascotaSexo.isEmpty()) {
                        textAreaConsulta.setText("Por favor, complete todos los campos.");
                        return;
                    }

                    MascotaVO mascota = new MascotaVO(ownerId, mascotaNombre, mascotaRaza, mascotaSexo);
                    mascotaDAO.registrarMascota(mascota);
                    textAreaConsulta.setText("¡Mascota registrada con éxito!");
                } catch (NumberFormatException ex) {
                    textAreaConsulta.setText("Error: El ID del dueño debe ser un número válido.");
                } catch (Exception ex) {
                    textAreaConsulta.setText("Error al registrar la mascota: " + ex.getMessage());
                }
            }
        });

        // Añadir panel al frame
        add(panel);
        setVisible(true);
    }

}
