package CrudMascotas.vista;

import javax.swing.*;
import java.awt.*;

public class Testing extends JFrame {
    private JTextField documentoField;
    private JTextField telefonoField;
    private JTextField nombreField;
    private JTextField GESTIONARPERSONASTextField;
    private JTextArea textArea1;
    private JButton button1;
    private JButton button2;
    private JButton button3;
    private JButton button4;
    private JButton button5;

    public Testing() {
        setTitle("Gestionar Personas");
        setSize(700, 700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Panel principal con GridBagLayout
        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(5, 5, 5, 5); // Espacios entre componentes

        // Campo GESTIONAR PERSONAS (fila 0, columna 1 a 4)
        GESTIONARPERSONASTextField = new JTextField("                                                        GESTIONAR PERSONAS");
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.gridwidth = 4;
        panel.add(GESTIONARPERSONASTextField, gbc);

        // Documento label y field (fila 4, columna 1 y 2)
        JLabel documentoLabel = new JLabel("Documento");
        gbc.gridx = 1;
        gbc.gridy = 4;
        gbc.gridwidth = 1;
        panel.add(documentoLabel, gbc);

        documentoField = new JTextField(15);
        gbc.gridx = 2;
        gbc.gridwidth = 1;
        panel.add(documentoField, gbc);

        // Teléfono label y field (fila 4, columna 3 y 4)
        JLabel telefonoLabel = new JLabel("Telefono");
        gbc.gridx = 3;
        panel.add(telefonoLabel, gbc);

        telefonoField = new JTextField(15);
        gbc.gridx = 4;
        panel.add(telefonoField, gbc);

        // Nombre label y field (fila 7, columna 2 y 3)
        JLabel nombreLabel = new JLabel("Nombre");
        gbc.gridx = 2;
        gbc.gridy = 7;
        panel.add(nombreLabel, gbc);

        nombreField = new JTextField(15);
        gbc.gridx = 3;
        panel.add(nombreField, gbc);

        // Botones (fila 10 y 12)
        button1 = new JButton("Button");
        gbc.gridx = 2;
        gbc.gridy = 10;
        panel.add(button1, gbc);

        button3 = new JButton("Button");
        gbc.gridx = 3;
        panel.add(button3, gbc);

        button2 = new JButton("Button");
        gbc.gridx = 2;
        gbc.gridy = 12;
        panel.add(button2, gbc);

        button4 = new JButton("Button");
        gbc.gridx = 3;
        panel.add(button4, gbc);

        // Botón final (fila 13, columna 2 y 3)
        button5 = new JButton("Button");
        gbc.gridx = 2;
        gbc.gridy = 13;
        gbc.gridwidth = 2;
        panel.add(button5, gbc);

        // TextArea (fila 15, columna 1 a 4)
        textArea1 = new JTextArea(2, 20);
        textArea1.setEditable(false);
        gbc.gridx = 1;
        gbc.gridy = 15;
        gbc.gridwidth = 4;
        gbc.fill = GridBagConstraints.BOTH;
        panel.add(new JScrollPane(textArea1), gbc);

        // Añadir panel al frame
        add(panel);
        setVisible(true);
    }

}
