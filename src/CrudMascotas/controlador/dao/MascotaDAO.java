package CrudMascotas.controlador.dao;

import CrudMascotas.controlador.models.MascotaVO;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MascotaDAO {
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
            String sqlQuery = "SELECT mascotaId, ownerId, nombre, raza, sexo FROM mascota";
            PreparedStatement statement = connection.prepareStatement(sqlQuery);
            // Ejecutar la consulta y procesar los datos
            ResultSet result = statement.executeQuery();
            while (result.next()) {
                long mascotaId = result.getLong("mascotaId");
                long ownerId = result.getLong("ownerId");
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
    public void registrarMascota(MascotaVO mascota) {
        try {
            // Establecemos la conexión
            Connection connection = DriverManager.getConnection(url, user, password);

            // Preparamos la consulta
            String sqlQuery = "INSERT INTO mascota(ownerId, nombre, raza, sexo) VALUES (?, ?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(sqlQuery, Statement.RETURN_GENERATED_KEYS); // Agregado para obtener el ID generado
            statement.setLong(1, mascota.getOwnerId());
            statement.setString(2, mascota.getMascotaNombre());
            statement.setString(3, mascota.getMascotaRaza());
            statement.setString(4, mascota.getMascotaSexo());

            // Ejecutamos la consulta
            statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Método para actualizar una mascota
    public void actualizarMascota(MascotaVO mascota) {
        try {
            // Establecemos la conexión
            Connection connection = DriverManager.getConnection(url, user, password);
            // Preparamos la consulta
            String sqlQuery = "UPDATE mascota SET nombre = ?, raza = ?, sexo = ? WHERE id = ?";


            PreparedStatement statement = connection.prepareStatement(sqlQuery);
            statement.setString(1, mascota.getMascotaNombre());
            statement.setString(2, mascota.getMascotaRaza());
            statement.setString(3, mascota.getMascotaSexo());
            statement.setLong(4, mascota.getOwnerId());
            // Ejecutamos la consulta
            statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Método para consultar una mascota por ID
    public MascotaVO obtenerMascota(long mascotaId) {
        MascotaVO mascota = null;

        try {
            // Creamos la conexión
            Connection connection = DriverManager.getConnection(url, user, password);
            // Preparamos la consulta
            String sqlQuery = "SELECT mascotaId, ownerId, nombre, raza, sexo FROM mascota WHERE mascotaId = ?";
            PreparedStatement statement = connection.prepareStatement(sqlQuery);
            statement.setLong(1, mascotaId);
            // Ejecutamos la consulta
            ResultSet result = statement.executeQuery();
            if (result.next()) {
                long ownerId = result.getLong("ownerId");
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
    public void eliminarMascota(long mascotaId) {
        try {
            // Creamos la conexión
            Connection connection = DriverManager.getConnection(url, user, password);
            // Preparamos la consulta
            String sqlQuery = "DELETE FROM mascota WHERE mascotaId = ?";
            PreparedStatement statement = connection.prepareStatement(sqlQuery);
            statement.setLong(1, mascotaId);
            // Ejecutamos la consulta
            statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
