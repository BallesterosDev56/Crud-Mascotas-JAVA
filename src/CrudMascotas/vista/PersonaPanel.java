package CrudMascotas.vista;

import CrudMascotas.controlador.dao.PersonaDAO;
import CrudMascotas.controlador.models.PersonaVO;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PersonaPanel extends JFrame {
    private JTextField txtDocumento;
    private JTextField txtNombre;
    private JTextField txtApellido;
    private JTextField txtTelefono;
    private JTextArea textAreaResultados;
    private JButton btnRegistrar;
    private JButton btnConsultar;
    private JButton btnActualizar;
    private JButton btnEliminar;
    private JButton btnConsultarLista;

    public PersonaPanel() {
        setTitle("Gestión de Personas");
        setLayout(null);
        setSize(700, 700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);

        // Labels y campos de texto
        JLabel lblDocumento = new JLabel("Documento:");
        lblDocumento.setBounds(20, 20, 100, 25);
        add(lblDocumento);

        txtDocumento = new JTextField();
        txtDocumento.setBounds(140, 20, 200, 25);
        add(txtDocumento);

        JLabel lblNombre = new JLabel("Nombre:");
        lblNombre.setBounds(20, 60, 100, 25);
        add(lblNombre);

        txtNombre = new JTextField();
        txtNombre.setBounds(140, 60, 200, 25);
        add(txtNombre);

        JLabel lblApellido = new JLabel("Apellido:");
        lblApellido.setBounds(20, 100, 100, 25);
        add(lblApellido);

        txtApellido = new JTextField();
        txtApellido.setBounds(140, 100, 200, 25);
        add(txtApellido);

        JLabel lblTelefono = new JLabel("Teléfono:");
        lblTelefono.setBounds(20, 140, 100, 25);
        add(lblTelefono);

        txtTelefono = new JTextField();
        txtTelefono.setBounds(140, 140, 200, 25);
        add(txtTelefono);

        // TextArea para resultados
        textAreaResultados = new JTextArea();
        JScrollPane scrollPane = new JScrollPane(textAreaResultados);
        scrollPane.setBounds(20, 200, 350, 100);
        add(scrollPane);

        // Botones
        btnRegistrar = new JButton("Registrar");
        btnRegistrar.setBounds(20, 320, 100, 25);
        add(btnRegistrar);

        btnConsultar = new JButton("Consultar");
        btnConsultar.setBounds(130, 320, 100, 25);
        add(btnConsultar);

        btnActualizar = new JButton("Actualizar");
        btnActualizar.setBounds(240, 320, 100, 25);
        add(btnActualizar);

        btnEliminar = new JButton("Eliminar");
        btnEliminar.setBounds(20, 350, 100, 25);
        add(btnEliminar);

        btnConsultarLista = new JButton("Consultar Lista");
        btnConsultarLista.setBounds(130, 350, 150, 25);
        add(btnConsultarLista);

        // Acciones de los botones
        btnRegistrar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                registrarPersona();
            }
        });

        btnConsultar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                consultarPersona();
            }
        });

        btnActualizar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                actualizarPersona();
            }
        });

        btnEliminar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                eliminarPersona();
            }
        });

        btnConsultarLista.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                mostrarConsulta();
            }
        });

        setVisible(true);
    }

    // Método para registrar una persona
    private void registrarPersona() {
        PersonaDAO personaDAO = new PersonaDAO();
        try {
            long documento = Long.parseLong(txtDocumento.getText());
            String nombreCompleto = txtNombre.getText() + " " + txtApellido.getText();
            long telefono = Long.parseLong(txtTelefono.getText());

            PersonaVO personaVO = new PersonaVO(documento, nombreCompleto, telefono);
            personaDAO.registrarPersona(personaVO);
            textAreaResultados.setText("Persona registrada con éxito:\n" + personaVO);
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Error en los datos ingresados. Verifica los campos.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    // Método para consultar una persona
    private void consultarPersona() {
        PersonaDAO personaDAO = new PersonaDAO();
        long documento = Long.parseLong(txtDocumento.getText());
//        if (persona != null) {
//
//            textAreaResultados.setText("Persona consultada:\n" + persona);
//        } else {
//            textAreaResultados.setText("La persona no existe.");
//        }
    }

    // Método para actualizar una persona
    private void actualizarPersona() {
        PersonaDAO personaDAO = new PersonaDAO();
        try {
            long documento = Long.parseLong(txtDocumento.getText());
            String nombreCompleto = txtNombre.getText() + " " + txtApellido.getText();
            long telefono = Long.parseLong(txtTelefono.getText());

            PersonaVO personaVO = new PersonaVO(documento, nombreCompleto, telefono);
            personaDAO.actualizarPersona(personaVO);
            textAreaResultados.setText("Persona actualizada con éxito:\n" + personaVO);
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Error en los datos ingresados. Verifica los campos.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    // Método para eliminar una persona
    private void eliminarPersona() {
        PersonaDAO personaDAO = new PersonaDAO();
        long documento = Long.parseLong(txtDocumento.getText());

        textAreaResultados.setText("Persona eliminada con éxito.");
    }

    // Método para mostrar la lista de personas
    private void mostrarConsulta() {
        PersonaDAO personaDAO = new PersonaDAO();
        StringBuilder consulta = new StringBuilder();
        for (PersonaVO persona : personaDAO.obtenerPersonas()) {
            consulta.append(persona.toString()).append("\n");
        }
        textAreaResultados.setText(consulta.toString());
    }
}
