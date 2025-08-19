package dao;

import conexion.DBManager;
import model.Venta;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ReservasDAO {
	
	public ReservasDAO() {
	}
	    
    // CREATE
    public boolean insertarUsuario(Venta venta) {
        String sql = "INSERT INTO ventas (idventa, comprador, vendedor, cantarticulos, subtotal, impuesto, total) " +
                     "VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (Connection conn = DBManager.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, venta.getIdVenta());
            stmt.setString(2, venta.getComprador());
            stmt.setString(3, venta.getVendedor());
            stmt.setInt(4, venta.getCantArticulos());
            stmt.setDouble(5, venta.getSubtotal());
            stmt.setDouble(6, venta.getImpuesto());
            stmt.setDouble(7, venta.getTotal());

            return stmt.executeUpdate() > 0;

        } catch (SQLException | IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    // READ
    public List<Venta> listarVentas() {
        List<Venta> lista = new ArrayList<>();
        String sql = "SELECT * FROM ventas";
        try (Connection conn = DBManager.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                lista.add(new Venta(
                        rs.getInt("idventa"),
                        rs.getString("comprador"),
                        rs.getString("vendedor"),
                        rs.getInt("cantarticulos"),
                        rs.getDouble("subtotal"),
                        rs.getDouble("impuesto"),
                        rs.getDouble("total")
                ));
            }

        } catch (SQLException | IOException e) {
            e.printStackTrace();
        }
        return lista;
    }

    // UPDATE
    public boolean actualizarVenta(Venta venta) {
        String sql = "UPDATE ventas SET comprador=?, vendedor=?, cantarticulos=?, subtotal=?, impuesto=?, total=? " +
                     "WHERE idventa=?";
        try (Connection conn = DBManager.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, venta.getComprador());
            stmt.setString(2, venta.getVendedor());
            stmt.setInt(3, venta.getCantArticulos());
            stmt.setDouble(4, venta.getSubtotal());
            stmt.setDouble(5, venta.getImpuesto());
            stmt.setDouble(6, venta.getTotal());
            stmt.setInt(7, venta.getIdVenta());

            return stmt.executeUpdate() > 0;

        } catch (SQLException | IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    // DELETE
    public boolean eliminarVenta(int idVenta) {
        String sql = "DELETE FROM ventas WHERE idventa=?";
        try (Connection conn = DBManager.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, idVenta);
            return stmt.executeUpdate() > 0;

        } catch (SQLException | IOException e) {
            e.printStackTrace();
            return false;
        }
    }
}
