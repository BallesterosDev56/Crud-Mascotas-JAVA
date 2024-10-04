package CrudMascotas.vista;

import CrudMascotas.controlador.dao.PersonaDAO;
import CrudMascotas.controlador.models.PersonaVO;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PersonaPanel extends JFrame {
    private JTextField documentoField;
    private JTextField telefonoField;
    private JTextField nombreField;
    private JTextField apellidoField;
    private JTextArea textArea1;
    private JButton btnRegistrar;
    private JButton btnConsultar;
    private JButton btnLista;

    public PersonaPanel() {
        setTitle("Gestionar Personas");
        setSize(700, 700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Panel principal con GridBagLayout
        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(5, 5, 5, 5);

        // Campo GESTIONAR PERSONAS (fila 0, columna 1 a 4)
        JTextField GESTIONARPERSONASTextField = new JTextField("                                                        GESTIONAR PERSONAS");
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.gridwidth = 4;
        panel.add(GESTIONARPERSONASTextField, gbc);

        // Documento label y field
        JLabel documentoLabel = new JLabel("Documento:");
        gbc.gridx = 1;
        gbc.gridy = 4;
        gbc.gridwidth = 1;
        panel.add(documentoLabel, gbc);

        documentoField = new JTextField(15);
        gbc.gridx = 2;
        panel.add(documentoField, gbc);

        // Teléfono label y field
        JLabel telefonoLabel = new JLabel("Teléfono:");
        gbc.gridx = 3;
        panel.add(telefonoLabel, gbc);

        telefonoField = new JTextField(15);
        gbc.gridx = 4;
        panel.add(telefonoField, gbc);

        // Nombre label y field
        JLabel nombreLabel = new JLabel("Nombre:");
        gbc.gridx = 1;
        gbc.gridy = 7;
        panel.add(nombreLabel, gbc);

        nombreField = new JTextField(15);
        gbc.gridx = 2;
        panel.add(nombreField, gbc);

        // Apellido label y field
        JLabel apellidoLabel = new JLabel("Apellido:");
        gbc.gridx = 3;
        panel.add(apellidoLabel, gbc);

        apellidoField = new JTextField(15);
        gbc.gridx = 4;
        panel.add(apellidoField, gbc);

        // Botones
        btnRegistrar = new JButton("Registrar Dueño");
        gbc.gridx = 2;
        gbc.gridy = 10;
        panel.add(btnRegistrar, gbc);

        btnConsultar = new JButton("Consultar Dueños");
        gbc.gridx = 3;
        panel.add(btnConsultar, gbc);

        btnLista = new JButton("Consultar Lista");
        gbc.gridx = 2;
        gbc.gridy = 12;
        panel.add(btnLista, gbc);

        // TextArea para mostrar consultas
        textArea1 = new JTextArea(5, 20);
        textArea1.setEditable(false);
        gbc.gridx = 1;
        gbc.gridy = 15;
        gbc.gridwidth = 4;
        gbc.fill = GridBagConstraints.BOTH;
        panel.add(new JScrollPane(textArea1), gbc);

        // Añadir panel al frame
        add(panel);
        setVisible(true);

        // Acciones de los botones
        btnRegistrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                registrarPersona();
            }
        });

        btnConsultar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mostrarConsulta();
            }
        });

        btnLista.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mostrarConsulta();
            }
        });
    }

    // Método para registrar una persona
    private void registrarPersona() {
        PersonaDAO personaDAO = new PersonaDAO();

        try {
            long documento = Long.parseLong(documentoField.getText());
            String nombreCompleto = nombreField.getText() + " " + apellidoField.getText();
            long telefono = Long.parseLong(telefonoField.getText());

            PersonaVO personaVO = new PersonaVO(documento, nombreCompleto, telefono);
            personaDAO.registrarPersona(personaVO);
            mostrarConsulta(); // Actualizamos la lista
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Error en los datos ingresados. Verifica los campos.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    // Método para mostrar la lista de personas
    private void mostrarConsulta() {
        PersonaDAO personaDAO = new PersonaDAO();
        StringBuilder consulta = new StringBuilder();
        for (PersonaVO persona : personaDAO.obtenerPersonas()) {
            consulta.append(persona.toString()).append("\n");
        }
        textArea1.setText(consulta.toString());
    }

}
