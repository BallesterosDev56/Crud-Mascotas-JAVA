    package CrudMascotas.controlador;

    import CrudMascotas.modelo.MascotaDAO;
    import CrudMascotas.modelo.MascotaVO;
    import CrudMascotas.modelo.PersonaDAO;
    import CrudMascotas.modelo.PersonaVO;
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

        public void startApplication() {
            mainFrame.setVisible(true);
        }


        public void mostrarVentanaPersonas() {
            personaPanel.setVisible(true);

        }

        public void mostrarVentanaMascotas() {
            mascotaPanel.setVisible(true);

        }

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

        //consultar todas las mascotas
        public List<MascotaVO> consultarMascotas() {
            return mascotaDAO.obtenerMascotas();
        }

        //consultar una mascota
        public MascotaVO consultarMascota(long ownerId) {
            return mascotaDAO.obtenerMascota(ownerId);
        }

        //registrar una mascota
        public String registrarMascota(MascotaVO mascota) {
            return mascotaDAO.registrarMascota(mascota);
        }

        //consultar una persona
        public PersonaVO consultarPersona(long documento) {
            return personaDAO.obtenerPersona(documento);
        }

        //registrar una persona
        public String registrarPersona(PersonaVO persona) {
            return personaDAO.registrarPersona(persona);
        }

        //actualizar una persona
        public String actualizarPersona(PersonaVO persona) {
            return personaDAO.actualizarPersona(persona);
        }

        //eliminar una persona
        public String eliminarPersona(long documento) {
            return personaDAO.eliminarPersona(documento);
        }

        //consultar todas las personas
        public List<PersonaVO> consultarPersonas() {
            return personaDAO.obtenerPersonas();
        }
    }
