package CrudMascotas.vista;

import CrudMascotas.controlador.Controlador;
import CrudMascotas.modelo.PersonaDAO;
import CrudMascotas.modelo.PersonaVO;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PersonaPanel extends JFrame {
    Controlador controlador;

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
        setSize(450, 600);
        setLocationRelativeTo(null);
        setResizable(false);

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

        textAreaResultados = new JTextArea();
        JScrollPane scrollPane = new JScrollPane(textAreaResultados);
        scrollPane.setBounds(20, 200, 350, 200);
        add(scrollPane);

        // Ajuste de los botones para que queden alineados
        btnRegistrar = new JButton("Registrar");
        btnRegistrar.setBounds(20, 470, 150, 25); // Botón "Registrar"
        add(btnRegistrar);

        btnConsultar = new JButton("Consultar");
        btnConsultar.setBounds(180, 470, 150, 25); // Botón "Consultar"
        add(btnConsultar);

        btnActualizar = new JButton("Actualizar");
        btnActualizar.setBounds(20, 500, 150, 25); // Botón "Actualizar"
        add(btnActualizar);

        btnEliminar = new JButton("Eliminar");
        btnEliminar.setBounds(180, 500, 150, 25); // Botón "Eliminar"
        add(btnEliminar);

        btnConsultarLista = new JButton("Consultar Lista");
        btnConsultarLista.setBounds(20, 530, 310, 25); // Botón "Consultar Lista" ocupa toda la fila
        add(btnConsultarLista);

        // Configurar los listeners para los botones
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

    }

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

    private void consultarPersona() {
        PersonaDAO personaDAO = new PersonaDAO();

        long documento = Long.parseLong(txtDocumento.getText());
        PersonaVO persona = personaDAO.obtenerPersona(documento);

        if (persona != null) {
            textAreaResultados.setText("Persona consultada:\n" + persona);
        } else {
            textAreaResultados.setText("La persona no existe.");
        }
    }

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

    private void eliminarPersona() {
        PersonaDAO personaDAO = new PersonaDAO();
        long documento = Long.parseLong(txtDocumento.getText());
        personaDAO.eliminarPersona(documento);
        textAreaResultados.setText("Persona eliminada con éxito.");
    }

    private void mostrarConsulta() {
        PersonaDAO personaDAO = new PersonaDAO();
        StringBuilder consulta = new StringBuilder();
        for (PersonaVO persona : personaDAO.obtenerPersonas()) {
            consulta.append(persona.toString()).append("\n");
        }
        textAreaResultados.setText(consulta.toString());
    }

    public void setControlador(Controlador controlador) {
        this.controlador = controlador;
    }
}
