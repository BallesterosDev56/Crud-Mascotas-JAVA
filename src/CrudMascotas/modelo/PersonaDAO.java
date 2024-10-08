package CrudMascotas.modelo;

import CrudMascotas.controlador.Controlador;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PersonaDAO {
    private Controlador controlador;

    //datos de la conexion
    private String url;
    private String user;
    private String password;

    public PersonaDAO() {
        url = "jdbc:mysql://localhost:3307/CrudMascotas";
        user = "root";
        password = "";
    }

    //metodo para obtener todos los usuarios
    public List<PersonaVO> obtenerPersonas() {
        List<PersonaVO> personas = new ArrayList<>();

        try {
            //establecemos la conexion
            Connection connection = DriverManager.getConnection(url, user, password);

            //preparar la consulta sql
            String sqlQuery = "SELECT documento, nombre, telefono FROM persona";
            PreparedStatement statement = connection.prepareStatement(sqlQuery);

            //ejecutar la consulta y porcesar los datos
            ResultSet result = statement.executeQuery();
            while (result.next()) {
                long documento = result.getLong("documento");
                String nombre = result.getString("nombre");
                long telefono = result.getLong("telefono");

                //crear un objeto VO y añadirlo a la lista
                PersonaVO personaVO = new PersonaVO(documento, nombre, telefono);
                personas.add(personaVO);
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }
        return personas;

    }

    //metodo para registrar una persona
    public String registrarPersona(PersonaVO personaVO) {
        String message = "";
        try {
            //establecemos la conexion
            Connection connection = DriverManager.getConnection(url, user, password);

            //verificamos que no haya otro usuario registrado con ese id:


            //preparamos la consulta
            String sqlQuery = "INSERT INTO persona(documento, nombre, telefono) VALUES (?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(sqlQuery);
            statement.setLong(1, personaVO.getPersonaId());
            statement.setString(2, personaVO.getPersonaNombre());
            statement.setLong(3, personaVO.getPersonaCel());

            //ejecutamos la consulta
            statement.executeUpdate();
            message = "Persona registrada con éxito";

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return message;
    }

    //metodo para actualizar una persona
    public String actualizarPersona(PersonaVO personaVO) {
        String message = "";
        try {
            //eatablecemos la conexion
            Connection connection = DriverManager.getConnection(url, user, password);

            //preparamos la consulta
            String sqlQuery = "UPDATE persona SET documento = ?, nombre = ?, telefono = ? WHERE documento = ?";
            PreparedStatement statement = connection.prepareStatement(sqlQuery);
            statement.setLong(1, personaVO.getPersonaId());
            statement.setString(2, personaVO.getPersonaNombre());
            statement.setLong(3, personaVO.getPersonaCel());
            statement.setLong(4, personaVO.getPersonaId());

            //ejecutamos la consulta
            statement.executeUpdate();
            message = "Persona actualizada con éxito";

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return message;

    }

    //metodo para consultar una persona por id
    public PersonaVO obtenerPersona(long personaId) {
        PersonaVO returnedPersonaVO = null;

        try {
            //creamos la conexion
            Connection connection = DriverManager.getConnection(url, user, password);

            //preparamos la consulta:
            String sqlQuery = "SELECT documento, nombre, telefono FROM persona WHERE documento = ?";
            PreparedStatement statement = connection.prepareStatement(sqlQuery);
            statement.setLong(1, personaId);

            //ejecutamos la consulta
            ResultSet result = statement.executeQuery();
            while (result.next()) {
                long documento = result.getLong("documento");
                String nombre = result.getString("nombre");
                long telefono = result.getLong("telefono");

                returnedPersonaVO = new PersonaVO(documento, nombre, telefono);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return returnedPersonaVO;
    }

    //metodo para eliminar una persona
    public String eliminarPersona(long documento) {
        String message = "";
        try {
            //creamos la conexion
            Connection connection = DriverManager.getConnection(url, user, password);

            //preparamos la consulta
            String sqlQuery = "DELETE FROM persona WHERE documento = ?";
            PreparedStatement statement = connection.prepareStatement(sqlQuery);
            statement.setLong(1, documento);

            //ejecutamos la consulta
            statement.executeUpdate();
            message = "Persona eliminada exitosamente!";

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return message;
    }

    public void setControlador(Controlador controlador) {
        this.controlador = controlador;
    }

}
