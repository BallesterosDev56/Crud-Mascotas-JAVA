package CrudMascotas.vista;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainFrame extends JFrame {
    public MainFrame() {
        // Configuraciones de la ventana
        setTitle("Sistema Veterinaria PetConnect");
        setSize(800, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        // Panel de imagen de fondo
        ImageIcon background = new ImageIcon("ruta/a/tu/imagen/fondo.jpg"); // Cambia la ruta a tu imagen
        JLabel backgroundLabel = new JLabel(background);
        backgroundLabel.setLayout(new FlowLayout());

        // Título
        JLabel titleLabel = new JLabel("SISTEMA VETERINARIA PETCONNECT");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        titleLabel.setForeground(Color.WHITE);
        backgroundLabel.add(titleLabel);

        // Botones
        JButton btnGestionarMascotas = new JButton("Gestionar Mascotas");
        JButton btnGestionarDueños = new JButton("Gestionar Dueños");

        btnGestionarMascotas.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Redirigir a MascotaPanel
                new MascotaPanel().setVisible(true);
                dispose(); // Cerrar MainFrame
            }
        });

        btnGestionarDueños.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Redirigir a PersonaPanel
                new PersonaPanel().setVisible(true);
                dispose(); // Cerrar MainFrame
            }
        });

        backgroundLabel.add(btnGestionarMascotas);
        backgroundLabel.add(btnGestionarDueños);
        add(backgroundLabel, BorderLayout.CENTER);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            MainFrame mainFrame = new MainFrame();
            mainFrame.setVisible(true);
        });
    }
}

