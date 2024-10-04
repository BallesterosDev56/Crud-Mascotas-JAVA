package CrudMascotas.vista;

import CrudMascotas.controlador.dao.MascotaDAO;
import CrudMascotas.controlador.models.MascotaVO;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MascotaPanel extends JFrame {
    private JTextField ownerIdField, nombreMascotaField, razaField, sexoField;
    private JTextArea textAreaConsulta;
    private JButton btnRegistrar, btnConsultar, btnActualizar, btnEliminar, btnConsultarLista;

    public MascotaPanel() {
        setTitle("Gestión de Mascotas");
        setLayout(null);
        setSize(700, 700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Centra la ventana en la pantalla
        setResizable(false);

        // Etiqueta y campo para el ID del Dueño
        JLabel ownerIdLabel = new JLabel("ID del Dueño:");
        ownerIdLabel.setBounds(20, 20, 120, 25);
        add(ownerIdLabel);

        ownerIdField = new JTextField();
        ownerIdField.setBounds(150, 20, 200, 25);
        add(ownerIdField);

        // Etiqueta y campo para el Nombre de la Mascota
        JLabel nombreMascotaLabel = new JLabel("Nombre de la Mascota:");
        nombreMascotaLabel.setBounds(20, 60, 140, 25);
        add(nombreMascotaLabel);

        nombreMascotaField = new JTextField();
        nombreMascotaField.setBounds(150, 60, 200, 25);
        add(nombreMascotaField);

        // Etiqueta y campo para la Raza
        JLabel razaLabel = new JLabel("Raza:");
        razaLabel.setBounds(20, 100, 100, 25);
        add(razaLabel);

        razaField = new JTextField();
        razaField.setBounds(150, 100, 200, 25);
        add(razaField);

        // Etiqueta y campo para el Sexo
        JLabel sexoLabel = new JLabel("Sexo:");
        sexoLabel.setBounds(20, 140, 100, 25);
        add(sexoLabel);

        sexoField = new JTextField();
        sexoField.setBounds(150, 140, 200, 25);
        add(sexoField);

        // Área de texto para mostrar mensajes (como confirmación o errores)
        textAreaConsulta = new JTextArea();
        JScrollPane scrollPane = new JScrollPane(textAreaConsulta);
        scrollPane.setBounds(20, 180, 350, 100);
        add(scrollPane);

        // Botón para registrar la mascota
        btnRegistrar = new JButton("Registrar");
        btnRegistrar.setBounds(20, 300, 100, 25);
        add(btnRegistrar);

        // Botón para consultar una mascota
        btnConsultar = new JButton("Consultar");
        btnConsultar.setBounds(130, 300, 100, 25);
        add(btnConsultar);

        // Botón para actualizar una mascota
        btnActualizar = new JButton("Actualizar");
        btnActualizar.setBounds(240, 300, 100, 25);
        add(btnActualizar);

        // Botón para eliminar una mascota
        btnEliminar = new JButton("Eliminar");
        btnEliminar.setBounds(20, 330, 100, 25);
        add(btnEliminar);

        // Botón para consultar lista de mascotas
        btnConsultarLista = new JButton("Consultar Lista");
        btnConsultarLista.setBounds(130, 330, 150, 25);
        add(btnConsultarLista);

        // Eventos para cada botón
        btnRegistrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                registrarMascota();
            }
        });

        btnConsultar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                consultarMascota();
            }
        });

        btnActualizar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                actualizarMascota();
            }
        });

        btnEliminar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                eliminarMascota();
            }
        });

        btnConsultarLista.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                consultarListaMascotas();
            }
        });

        setVisible(true);
    }

    // Implementaciones de cada acción de los botones
    private void registrarMascota() {
        try {
            long ownerId = Long.parseLong(ownerIdField.getText());
            String mascotaNombre = nombreMascotaField.getText();
            String mascotaRaza = razaField.getText();
            String mascotaSexo = sexoField.getText();

            if (mascotaNombre.isEmpty() || mascotaRaza.isEmpty() || mascotaSexo.isEmpty()) {
                textAreaConsulta.setText("Por favor, complete todos los campos.");
                return;
            }

            MascotaVO mascota = new MascotaVO(ownerId, mascotaNombre, mascotaRaza, mascotaSexo);
            MascotaDAO mascotaDAO = new MascotaDAO();
            mascotaDAO.registrarMascota(mascota);
            textAreaConsulta.setText("¡Mascota registrada con éxito!");
        } catch (NumberFormatException ex) {
            textAreaConsulta.setText("Error: El ID del dueño debe ser un número válido.");
        } catch (Exception ex) {
            textAreaConsulta.setText("Error al registrar la mascota: " + ex.getMessage());
        }
    }

    private void consultarMascota() {
        // Implementación del método para consultar
    }

    private void actualizarMascota() {
        // Implementación del método para actualizar
    }

    private void eliminarMascota() {
        // Implementación del método para eliminar
    }

    private void consultarListaMascotas() {
        // Implementación del método para consultar la lista
    }
}
