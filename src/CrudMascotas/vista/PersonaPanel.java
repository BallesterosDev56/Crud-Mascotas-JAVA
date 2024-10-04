package CrudMascotas.vista;

import CrudMascotas.controlador.dao.PersonaDAO;
import CrudMascotas.controlador.models.PersonaVO;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PersonaPanel extends JFrame {
    private JTextField txtId, txtNombre, txtApellido, txtTelefono;
    private JTextArea textAreaConsulta;

    public PersonaPanel() {
        setTitle("Gestionar Dueños");
        setSize(600, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(5, 2));

        // Campos del formulario
        add(new JLabel("ID del Dueño:"));
        txtId = new JTextField();
        add(txtId);

        add(new JLabel("Nombre:"));
        txtNombre = new JTextField();
        add(txtNombre);

        add(new JLabel("Apellido:"));
        txtApellido = new JTextField();
        add(txtApellido);

        add(new JLabel("Teléfono:"));
        txtTelefono = new JTextField();
        add(txtTelefono);

        // Botones para las operaciones
        JButton btnRegistrar = new JButton("Registrar Dueño");
        JButton btnConsultar = new JButton("Consultar Dueños");
        JButton btnDueños = new JButton("Consultar Lista");

        add(btnRegistrar);
        add(btnConsultar);
        add(btnDueños);

        // Área de texto para mostrar consultas
        textAreaConsulta = new JTextArea();
        textAreaConsulta.setEditable(false);
        add(new JScrollPane(textAreaConsulta));

        // Eventos de los botones
        btnRegistrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PersonaDAO personaDAO = new PersonaDAO();

                long documento = Long.parseLong(txtId.getText());
                String nombre = "" + txtNombre.getText() + " " + txtApellido.getText();
                long telefono = Long.parseLong(txtTelefono.getText());
                System.out.println(nombre);

                PersonaVO personaVO = new PersonaVO(documento, nombre, telefono);
                personaDAO.registrarPersona(personaVO);
                mostrarConsulta();
            }
        });

        btnDueños.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mostrarConsulta();
            }
        });

        btnConsultar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }

    private void mostrarConsulta() {
        PersonaDAO personaDAO = new PersonaDAO();
        StringBuilder consulta = new StringBuilder();
        for (PersonaVO persona : personaDAO.obtenerPersonas()) {
            consulta.append(persona.toString()).append("\n");
        }
        textAreaConsulta.setText(consulta.toString());
    }
}
