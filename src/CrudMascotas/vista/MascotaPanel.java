package CrudMascotas.vista;

import CrudMascotas.controlador.Controlador;
import CrudMascotas.modelo.MascotaDAO;
import CrudMascotas.modelo.MascotaVO;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MascotaPanel extends JFrame {
    Controlador controlador;

    private JTextField ownerIdField, nombreMascotaField, razaField, sexoField;
    private JTextArea textAreaConsulta;
    private JButton btnRegistrar, btnConsultar, btnActualizar, btnEliminar, btnConsultarLista;

    public MascotaPanel() {
        setTitle("Gestión de Mascotas");
        setLayout(null);
        setSize(450, 550);
        setLocationRelativeTo(null);
        setResizable(false);

        JLabel ownerIdLabel = new JLabel("ID del Dueño:");
        ownerIdLabel.setBounds(20, 20, 120, 25);
        add(ownerIdLabel);

        ownerIdField = new JTextField();
        ownerIdField.setBounds(150, 20, 200, 25);
        add(ownerIdField);

        JLabel nombreMascotaLabel = new JLabel("Nombre de la Mascota:");
        nombreMascotaLabel.setBounds(20, 60, 140, 25);
        add(nombreMascotaLabel);

        nombreMascotaField = new JTextField();
        nombreMascotaField.setBounds(150, 60, 200, 25);
        add(nombreMascotaField);

        JLabel razaLabel = new JLabel("Raza:");
        razaLabel.setBounds(20, 100, 100, 25);
        add(razaLabel);

        razaField = new JTextField();
        razaField.setBounds(150, 100, 200, 25);
        add(razaField);

        JLabel sexoLabel = new JLabel("Sexo:");
        sexoLabel.setBounds(20, 140, 100, 25);
        add(sexoLabel);

        sexoField = new JTextField();
        sexoField.setBounds(150, 140, 200, 25);
        add(sexoField);

        textAreaConsulta = new JTextArea();
        JScrollPane scrollPane = new JScrollPane(textAreaConsulta);
        scrollPane.setBounds(20, 180, 350, 200);
        add(scrollPane);

        // Acomodar los botones en pares
        btnRegistrar = new JButton("Registrar");
        btnRegistrar.setBounds(20, 400, 100, 25);
        add(btnRegistrar);

        btnConsultar = new JButton("Consultar");
        btnConsultar.setBounds(130, 400, 100, 25);
        add(btnConsultar);

        btnActualizar = new JButton("Actualizar");
        btnActualizar.setBounds(20, 440, 100, 25);
        add(btnActualizar);

        btnEliminar = new JButton("Eliminar");
        btnEliminar.setBounds(130, 440, 100, 25);
        add(btnEliminar);

        // Hacer que el botón "Consultar Lista" ocupe el espacio de los botones en fila
        btnConsultarLista = new JButton("Consultar Lista");
        btnConsultarLista.setBounds(240, 400, 130, 65);  // Ocupa el espacio de dos botones
        add(btnConsultarLista);

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

    }

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
            controlador.registrarMascota(mascota);
            textAreaConsulta.setText("¡Mascota registrada con éxito!");

        } catch (NumberFormatException ex) {
            textAreaConsulta.setText("Error: El ID del dueño debe ser un número válido.");

        } catch (Exception ex) {
            textAreaConsulta.setText("Error al registrar la mascota: " + ex.getMessage());
        }
    }

    private void consultarMascota() {
        long ownerId = Long.parseLong(ownerIdField.getText());
        MascotaVO mascota = controlador.consultarMascota(ownerId);
        if (mascota != null) {
            textAreaConsulta.setText(mascota.toString());
        } else {
            textAreaConsulta.setText("No hay mascotas para este usuario.");
        }
    }

    private void actualizarMascota() {
        long ownerId = Long.parseLong(ownerIdField.getText());
        String mascotaNombre = nombreMascotaField.getText();
        String mascotaRaza = razaField.getText();
        String mascotaSexo = sexoField.getText();
        MascotaVO mascota = new MascotaVO(ownerId, mascotaNombre, mascotaRaza, mascotaSexo);

        textAreaConsulta.setText(controlador.actualizarMascota(mascota));
    }

    private void eliminarMascota() {
        long ownerId = Long.parseLong(ownerIdField.getText());

        textAreaConsulta.setText(controlador.eliminarMascota(ownerId));
    }

    private void consultarListaMascotas() {
        StringBuilder consulta = new StringBuilder();

        for (MascotaVO mascotaVO : controlador.consultarMascotas()) {
            consulta.append(mascotaVO.toString()).append("\n");
        }
        textAreaConsulta.setText(consulta.toString());
    }

    public void setControlador(Controlador controlador) {
        this.controlador = controlador;
    }
}
