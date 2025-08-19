package dao;


import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import conexion.DBManager;
import model.Sala;

public class SalasDAO {
	
	public SalasDAO() {
	}
	    
    // CREATE
    public boolean insertarSalas(Sala sala) {
        String sql = "INSERT INTO salas (nombre, capacidad) " +
                     "VALUES (?, ?)";
        try (Connection conn = DBManager.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, sala.getNombre());  // Primer ? (índice 1)
            stmt.setInt(2, sala.getCapacidad());       // Segundo ? (índice 2)

            return stmt.executeUpdate() > 0;

        } catch (SQLException | IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    // READ
    public List<Sala> listarSlas() {
        List<Sala> lista = new ArrayList<>();
        String sql = "SELECT * FROM salas";
        try (Connection conn = DBManager.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                lista.add(new Sala(
                        rs.getString("nombre"),
                        rs.getInt("capacidad")
                ));
            }

        } catch (SQLException | IOException e) {
            e.printStackTrace();
        }
        return lista;
    }

    // UPDATE
    public boolean actualizarSala(Sala sala) {
        String sql = "UPDATE usuarios SET nombre=?, capacidad=?" +
                     "WHERE idsala=?";
        try (Connection conn = DBManager.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

        	stmt.setString(1, sala.getNombre());
            stmt.setInt(2, sala.getCapacidad());

            return stmt.executeUpdate() > 0;

        } catch (SQLException | IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    // DELETE
    public boolean eliminarSala(int idSala) {
        String sql = "DELETE FROM salas WHERE idsala=?";
        try (Connection conn = DBManager.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, idSala);
            return stmt.executeUpdate() > 0;

        } catch (SQLException | IOException e) {
            e.printStackTrace();
            return false;
        }
    }

}
