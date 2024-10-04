package CrudMascotas;


import CrudMascotas.vista.Testing;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Testing());
    }
}