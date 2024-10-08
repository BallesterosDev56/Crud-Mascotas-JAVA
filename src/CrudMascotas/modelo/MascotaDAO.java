package CrudMascotas.modelo;

import CrudMascotas.controlador.Controlador;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MascotaDAO {
    Controlador controlador;

    // Datos de la conexión
    private String url;
    private String user;
    private String password;

    public MascotaDAO() {
        url = "jdbc:mysql://localhost:3307/CrudMascotas";
        user = "root";
        password = "";
    }

    // Método para obtener todas las mascotas
    public List<MascotaVO> obtenerMascotas() {
        List<MascotaVO> mascotas = new ArrayList<>();

        try {
            // Establecemos la conexión
            Connection connection = DriverManager.getConnection(url, user, password);
            // Preparar la consulta SQL
            String sqlQuery = "SELECT id, nombre, raza, sexo, idDueño FROM mascota";
            PreparedStatement statement = connection.prepareStatement(sqlQuery);
            // Ejecutar la consulta y procesar los datos
            ResultSet result = statement.executeQuery();
            while (result.next()) {
                long mascotaId = result.getLong("id");
                long ownerId = result.getLong("idDueño");
                String nombre = result.getString("nombre");
                String raza = result.getString("raza");
                String sexo = result.getString("sexo");

                // crear un objeto VO y añadirlo a la lista
                MascotaVO mascota = new MascotaVO(ownerId, nombre, raza, sexo);
                mascotas.add(mascota);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return mascotas;
    }

    // Método para registrar una mascota
    public String registrarMascota(MascotaVO mascota) {
        String message = "";
        try {
            // Establecemos la conexión
            Connection connection = DriverManager.getConnection(url, user, password);

            // Preparamos la consulta
            String sqlQuery = "INSERT INTO mascota(nombre, raza, sexo,  idDueño ) VALUES (?, ?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(sqlQuery, Statement.RETURN_GENERATED_KEYS); // Agregado para obtener el ID generado

            statement.setString(1, mascota.getMascotaNombre());
            statement.setString(2, mascota.getMascotaRaza());
            statement.setString(3, mascota.getMascotaSexo());
            statement.setLong(4, mascota.getOwnerId());

            // Ejecutamos la consulta
            statement.executeUpdate();
            message = "consulta exitosa";
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return message;
    }

    // Método para actualizar una mascota
    public String actualizarMascota(MascotaVO mascota) {
        String message = "";
        try {
            // Establecemos la conexión
            Connection connection = DriverManager.getConnection(url, user, password);
            // Preparamos la consulta
            String sqlQuery = "UPDATE mascota SET nombre = ?, raza = ?, sexo = ? WHERE idDueño = ?";


            PreparedStatement statement = connection.prepareStatement(sqlQuery);
            statement.setString(1, mascota.getMascotaNombre());
            statement.setString(2, mascota.getMascotaRaza());
            statement.setString(3, mascota.getMascotaSexo());
            statement.setLong(4, mascota.getOwnerId());
            // Ejecutamos la consulta
            statement.executeUpdate();
            message = "Actualización exitosa!";

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return message;
    }

    // Método para consultar una mascota por ID
    public MascotaVO obtenerMascota(long mascotaId) {
        MascotaVO mascota = null;

        try {
            // Creamos la conexión
            Connection connection = DriverManager.getConnection(url, user, password);
            // Preparamos la consulta
            String sqlQuery = "SELECT id, nombre, raza, sexo, idDueño FROM mascota WHERE idDueño = ?";
            PreparedStatement statement = connection.prepareStatement(sqlQuery);
            statement.setLong(1, mascotaId);
            // Ejecutamos la consulta
            ResultSet result = statement.executeQuery();
            if (result.next()) {
                long ownerId = result.getLong("idDueño");
                String nombre = result.getString("nombre");
                String raza = result.getString("raza");
                String sexo = result.getString("sexo");

                mascota = new MascotaVO(ownerId, nombre, raza, sexo);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return mascota;
    }

    // Método para eliminar una mascota
    public String eliminarMascota(long mascotaId) {
        String message = "";
        try {
            // Creamos la conexión
            Connection connection = DriverManager.getConnection(url, user, password);
            // Preparamos la consulta
            String sqlQuery = "DELETE FROM mascota WHERE id = ?";
            PreparedStatement statement = connection.prepareStatement(sqlQuery);
            statement.setLong(1, mascotaId);
            // Ejecutamos la consulta
            statement.executeUpdate();

            message = "Eliminación exitosa";

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return message;
    }

    public void setControlador(Controlador controlador) {
        this.controlador = controlador;
    }
}
