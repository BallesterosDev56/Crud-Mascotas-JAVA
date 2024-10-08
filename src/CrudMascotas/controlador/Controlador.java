package CrudMascotas.controlador;

import CrudMascotas.modelo.MascotaDAO;
import CrudMascotas.modelo.MascotaVO;
import CrudMascotas.modelo.PersonaDAO;
import CrudMascotas.vista.MainFrame;
import CrudMascotas.vista.MascotaPanel;
import CrudMascotas.vista.PersonaPanel;

import java.util.List;

public class Controlador {
    private MainFrame mainFrame;
    private MascotaPanel mascotaPanel;
    private PersonaPanel personaPanel;
    private MascotaDAO mascotaDAO;
    private PersonaDAO personaDAO;

    public void setMainFrame(MainFrame mainFrame) {
        this.mainFrame = mainFrame;
    }

    public void setMascotaPanel(MascotaPanel mascotaPanel) {
        this.mascotaPanel = mascotaPanel;
    }

    public void setPersonaPanel(PersonaPanel personaPanel) {
        this.personaPanel = personaPanel;
    }

    public void setMascotaDAO(MascotaDAO mascotaDAO) {
        this.mascotaDAO = mascotaDAO;
    }

    public void setPersonaDAO(PersonaDAO personaDAO) {
        this.personaDAO = personaDAO;
    }

    //operaciones:

    //actualizar una mascota
    public String actualizarMascota(MascotaVO mascota) {
        return mascotaDAO.actualizarMascota(mascota);
    }

    //eliminar una mascota
    public String eliminarMascota(long ownerId) {
        return mascotaDAO.eliminarMascota(ownerId);
    }

    public List<MascotaVO> consultarMascotas() {
        return mascotaDAO.obtenerMascotas();
    }

    public MascotaVO consultarMascota(long ownerId) {
        return mascotaDAO.obtenerMascota(ownerId);
    }
}
