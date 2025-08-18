package app;

import conexion.DBManager;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import dao.ReservasDAO;
import model.Venta;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        try (Connection conn = DBManager.getConnection()) {
            System.out.println("✅ Conexión exitosa a la base de datos!");
            
        } catch (SQLException e) {
            System.err.println("❌ Error SQL al conectar: " + e.getMessage());
        } catch (IOException e) {
            System.err.println("❌ Error de configuración: " + e.getMessage());
        }
        
        pruebaDAO();
    }
    
    
    public static void pruebaDAO() {
    	
    	 ReservasDAO dao = new ReservasDAO();

    	 
    	 /*
         // 🔹 LISTAR todas las ventas
         System.out.println("\n📋 LISTADO DE VENTAS:");
         List<Venta> ventas = dao.listarVentas();
         ventas.forEach(System.out::println);

         // 🔹 INSERTAR nueva venta
         Venta nueva = new Venta(10, "CARLOS", "MARÍA PÉREZ", 3, 1500, 100, 1600);
         if (dao.insertarVenta(nueva)) {
             System.out.println("\n✅ Venta insertada correctamente.");
         }

         // 🔹 ACTUALIZAR una venta
         Venta actualizada = new Venta(10, "CARLOS ACTUALIZADO", "MARÍA PÉREZ", 4, 2000, 150, 2150);
         if (dao.actualizarVenta(actualizada)) {
             System.out.println("\n✏ Venta actualizada correctamente.");
         }

         // 🔹 ELIMINAR una venta
         if (dao.eliminarVenta(10)) {
             System.out.println("\n🗑 Venta eliminada correctamente.");
         }*/
    }
    
    
    
    
}
