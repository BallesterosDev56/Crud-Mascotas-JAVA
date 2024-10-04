package CrudMascotas.vista;

import CrudMascotas.controlador.dao.MascotaDAO;
import CrudMascotas.controlador.models.MascotaVO;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MascotaPanel extends JFrame {
    private JTextField txtOwnerId, txtNombre, txtRaza, txtSexo;
    private JTextArea textAreaConsulta;

    public MascotaPanel() {
        setTitle("Gestionar Mascotas");
        setSize(600, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(5, 2));

        // Campos del formulario
        add(new JLabel("ID del Dueño:"));
        txtOwnerId = new JTextField();
        add(txtOwnerId);

        add(new JLabel("Nombre de la Mascota:"));
        txtNombre = new JTextField();
        add(txtNombre);

        add(new JLabel("Raza:"));
        txtRaza = new JTextField();
        add(txtRaza);

        add(new JLabel("Sexo:"));
        txtSexo = new JTextField();
        add(txtSexo);

        // Botones para las operaciones
        JButton btnRegistrar = new JButton("Registrar Mascota");
        JButton btnConsultar = new JButton("Consultar Mascotas");

        add(btnRegistrar);
        add(btnConsultar);

        // Área de texto para mostrar consultas
        textAreaConsulta = new JTextArea();
        textAreaConsulta.setEditable(false);
        add(new JScrollPane(textAreaConsulta));

        // Eventos de los botones:

        //registrar mascota
        btnRegistrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MascotaDAO mascotaDAO = new MascotaDAO();

                long ownerId = Long.parseLong(txtOwnerId.getText());
                String mascotaNombre = txtNombre.getText();
                String mascotaRaza = txtRaza.getText();
                String mascotaSexo = txtSexo.getText();

                MascotaVO mascota = new MascotaVO(ownerId, mascotaNombre, mascotaRaza, mascotaSexo);
                mascotaDAO.registrarMascota(mascota);
                mostrarConsulta();
            }
        });

        //consultar mascota
        btnConsultar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mostrarConsulta();
            }
        });
    }

    private void mostrarConsulta() {
        MascotaDAO mascotaDAO = new MascotaDAO();
        StringBuilder consulta = new StringBuilder();
        for (MascotaVO mascota : mascotaDAO.obtenerMascotas()) {
            consulta.append(mascota.toString()).append("\n");
        }
        textAreaConsulta.setText(consulta.toString());
    }
}
