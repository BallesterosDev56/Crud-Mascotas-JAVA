package CrudMascotas.vista;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainFrame extends JFrame {

    private JButton btnGestionarPersonas;
    private JButton btnGestionarMascotas;


    public MainFrame() {
        setTitle("Clínica Veterinaria - Ventana Principal");
        setLayout(null);
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);

        JLabel lblTitulo = new JLabel("Gestión de Personas y Mascotas");
        lblTitulo.setBounds(100, 20, 250, 25);
        add(lblTitulo);

        btnGestionarPersonas = new JButton("Gestionar Personas");
        btnGestionarPersonas.setBounds(100, 80, 200, 30);
        add(btnGestionarPersonas);

        btnGestionarMascotas = new JButton("Gestionar Mascotas");
        btnGestionarMascotas.setBounds(100, 130, 200, 30);
        add(btnGestionarMascotas);

        // Acciones de los botones
        btnGestionarPersonas.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                abrirVentanaGestionarPersonas();
            }
        });

        btnGestionarMascotas.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                abrirVentanaGestionarMascotas();
            }
        });
    }

    private void abrirVentanaGestionarPersonas() {
        PersonaPanel personaPanel = new PersonaPanel();
        personaPanel.setVisible(true);

    }

    private void abrirVentanaGestionarMascotas() {
        MascotaPanel mascotaPanel = new MascotaPanel();
        mascotaPanel.setVisible(true);

    }

}

