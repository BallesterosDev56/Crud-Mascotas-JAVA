package CrudMascotas;


import CrudMascotas.controlador.Controlador;
import CrudMascotas.modelo.MascotaDAO;
import CrudMascotas.modelo.PersonaDAO;
import CrudMascotas.vista.MainFrame;
import CrudMascotas.vista.MascotaPanel;
import CrudMascotas.vista.PersonaPanel;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {

        Controlador controlador = new Controlador();

        MainFrame mainFrame = new MainFrame();
        MascotaPanel mascotaPanel = new MascotaPanel();
        PersonaPanel personaPanel = new PersonaPanel();
        MascotaDAO mascotaDAO = new MascotaDAO();
        PersonaDAO personaDAO = new PersonaDAO();

        //seteamos las relaciones
        controlador.setMainFrame(mainFrame);
        controlador.setMascotaPanel(mascotaPanel);
        controlador.setPersonaPanel(personaPanel);
        controlador.setMascotaDAO(mascotaDAO);
        controlador.setPersonaDAO(personaDAO);

        mainFrame.setControlador(controlador);
        mascotaPanel.setControlador(controlador);
        personaPanel.setControlador(controlador);
        mascotaDAO.setControlador(controlador);
        personaDAO.setControlador(controlador);

        SwingUtilities.invokeLater(()-> {
            mainFrame.setVisible(true);
        });
    }
}