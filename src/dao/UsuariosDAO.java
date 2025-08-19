package dao;

import conexion.DBManager;
import model.Usuario;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UsuariosDAO {
	
	public UsuariosDAO() {
	}
	    
    // CREATE
    public boolean insertarUsuario(Usuario usuario) {
        String sql = "INSERT INTO usuarios (nombres, apellidos, run) " +
                     "VALUES (?, ?, ?)";
        try (Connection conn = DBManager.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, usuario.getNombres());
            stmt.setString(2, usuario.getApellidos());
            stmt.setString(3, usuario.getRun());

            return stmt.executeUpdate() > 0;

        } catch (SQLException | IOException e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public int consultarID(Usuario usuario) {
    	int idUsuario = 0;
        String sql = "SELECT idusuario FROM usuarios WHERE run=?";
        try (Connection conn = DBManager.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, usuario.getRun());

            try (ResultSet rs = stmt.executeQuery()){
            	
            	if (rs.next()) {
            		idUsuario = rs.getInt("idusuario");
            	}
            }

        } catch (SQLException | IOException e) {
            e.printStackTrace();
        }
        
        return idUsuario;
    }
    
    

    // READ
    public List<Usuario> listarUsuarios() {
        List<Usuario> lista = new ArrayList<>();
        String sql = "SELECT * FROM usuarios";
        try (Connection conn = DBManager.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                lista.add(new Usuario(
                        rs.getString("nombres"),
                        rs.getString("apellidos"),
                        rs.getString("run")
                ));
            }

        } catch (SQLException | IOException e) {
            e.printStackTrace();
        }
        return lista;
    }

    // UPDATE
    public boolean actualizarUsuario(Usuario usuario) {
        String sql = "UPDATE usuarios SET nombres=?, apellidos=?, run=?" +
                     "WHERE idusuario=?";
        try (Connection conn = DBManager.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

        	stmt.setString(1, usuario.getNombres());
            stmt.setString(2, usuario.getApellidos());
            stmt.setString(3, usuario.getRun());
            stmt.setInt(4, usuario.getIdusuario());

            return stmt.executeUpdate() > 0;

        } catch (SQLException | IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    // DELETE
    public boolean eliminarUsuario(int idusuario) {
        String sql = "DELETE FROM usuarios WHERE idusuario=?";
        try (Connection conn = DBManager.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, idusuario);
            return stmt.executeUpdate() > 0;

        } catch (SQLException | IOException e) {
            e.printStackTrace();
            return false;
        }
    }
}
