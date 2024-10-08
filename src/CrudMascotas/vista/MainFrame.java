package CrudMascotas.vista;

import CrudMascotas.controlador.Controlador;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainFrame extends JFrame {
    Controlador controlador;

    private JButton btnGestionarPersonas;
    private JButton btnGestionarMascotas;

    public MainFrame() {
        setTitle("Clínica Veterinaria - Ventana Principal");
        setSize(600, 400); // Aumentar el tamaño de la ventana
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null); // Centrar ventana
        setLayout(null);

        // Establecer un color de fondo suave
        getContentPane().setBackground(new Color(240, 248, 255)); // Color suave (AliceBlue)

        // Modificar el estilo del título
        JLabel lblTitulo = new JLabel("Gestión de Personas y Mascotas", SwingConstants.CENTER);
        lblTitulo.setFont(new Font("Arial", Font.BOLD, 30)); // Aumentar el tamaño del título
        lblTitulo.setBounds(50, 30, 500, 30); // Aumentar el tamaño del área
        add(lblTitulo);

        // Estilo de botones
        btnGestionarPersonas = new JButton("Gestionar Personas");
        btnGestionarPersonas.setFont(new Font("Arial", Font.PLAIN, 16));
        btnGestionarPersonas.setBounds(100, 300, 200, 40); // Aumentar el tamaño y colocar en la parte inferior
        add(btnGestionarPersonas);

        btnGestionarMascotas = new JButton("Gestionar Mascotas");
        btnGestionarMascotas.setFont(new Font("Arial", Font.PLAIN, 16));
        btnGestionarMascotas.setBounds(320, 300, 200, 40); // Aumentar el tamaño y colocar en la parte inferior
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
        controlador.mostrarVentanaPersonas();
    }

    private void abrirVentanaGestionarMascotas() {
        controlador.mostrarVentanaMascotas();
    }

    public void setControlador(Controlador controlador) {
        this.controlador = controlador;
    }
}
