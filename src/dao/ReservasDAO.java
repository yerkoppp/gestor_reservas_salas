package dao;

import conexion.DBManager;
import model.Reserva;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ReservasDAO {
	
	public ReservasDAO() {
	}
	    
    // CREATE
    public boolean insertarReserva(Reserva reserva) {
        String sql = "INSERT INTO reservas (salas_idsala, usuarios_idusuario, fecha_creacion, fecha_reserva) " +
                     "VALUES (?, ?, ?, ?)";
        try (Connection conn = DBManager.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, reserva.getIdsala());
            stmt.setInt(2, reserva.getIdusuario());
            stmt.setDate(3, reserva.getFechaCreacion());
            stmt.setDate(4, reserva.getFechaReserva());


            return stmt.executeUpdate() > 0;

        } catch (SQLException | IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    // READ
    public List<Reserva> listarReservas() {
        List<Reserva> lista = new ArrayList<>();
        String sql = "SELECT * FROM reservas";
        try (Connection conn = DBManager.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                lista.add(new Reserva(
                        rs.getInt("salas_idsala"),
                        rs.getInt("usuarios_idusuario"),
                        rs.getDate("fecha_creacion"),
                        rs.getDate("fecha_reserva")
                ));
            }

        } catch (SQLException | IOException e) {
            e.printStackTrace();
        }
        return lista;
    }

    // UPDATE
    public boolean actualizarReserva(Reserva reserva) {
        String sql = "UPDATE reservas SET salas_idsala=?, usuarios_idusuario=?, fecha_creacion=?, fecha_reserva=?" +
                     "WHERE idreserva=?";
        try (Connection conn = DBManager.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

        	stmt.setInt(1, reserva.getIdsala());
            stmt.setInt(2, reserva.getIdusuario());
            stmt.setDate(3, reserva.getFechaCreacion());
            stmt.setDate(4, reserva.getFechaReserva());
            stmt.setInt(5, reserva.getIdreserva());

            return stmt.executeUpdate() > 0;

        } catch (SQLException | IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    // DELETE
    public boolean eliminarReserva(int idreserva) {
        String sql = "DELETE FROM reservas WHERE idreserva=?";
        try (Connection conn = DBManager.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, idreserva);
            return stmt.executeUpdate() > 0;

        } catch (SQLException | IOException e) {
            e.printStackTrace();
            return false;
        }
    }
}
