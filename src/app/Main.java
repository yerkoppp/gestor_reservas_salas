package app;

import conexion.DBManager;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import dao.ReservasDAO;
import dao.UsuariosDAO;
import model.Usuario;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Main {
	static Scanner sc = new Scanner(System.in);
	static boolean continuarMain = true;
	
    public static void main(String[] args) {
        try (Connection conn = DBManager.getConnection()) {
            System.out.println("✅ Conexión exitosa a la base de datos!");
            
        } catch (SQLException e) {
            System.err.println("❌ Error SQL al conectar: " + e.getMessage());
        } catch (IOException e) {
            System.err.println("❌ Error de configuración: " + e.getMessage());
        }
        
        pruebaDAO();
        
        
        mostrarBienvenida();

		do {
			mostrarMenu();
			int opcionMenu = elegirOpcionMenu();
			ejecutarOpcion(opcionMenu);

		} while (continuarMain);
    }
    
    public static void mostrarBienvenida() {
		System.out.println("=".repeat(50));
		System.out.println("-".repeat(6)
				+ " BIENVENIDO AL SISTEMA DE GESTIÓN DE RESERVAS DE SALAS "
				+ "-".repeat(6));
		System.out.println("=".repeat(50));
	}
    
	public static void mostrarMenu() {
		System.out.println("\n" + "-".repeat(22) + " MENÚ " + "-".repeat(22));
		System.out.println("(1) Registrar sala");
		System.out.println("(2) Registrar usuario");
		System.out.println("(3) Hacer reserva");
		System.out.println("(4) Ver reservas");
		System.out.println("(0) Salir");

	}
	
	public static int elegirOpcionMenu() {
		try {
			System.out
					.println("\nIngrese el número de la opción seleccionada: ");
			int opcionSeleccionada = sc.nextInt();
			sc.nextLine();
			return opcionSeleccionada;
		} catch (InputMismatchException e) {
			System.out.println("⚠️ Entrada inválida. Debe ingresar un número.");
			sc.nextLine();
			return 12749;
		}

	}
	
	public static void ejecutarOpcion(int opcion) {
		switch (opcion) {
		case 1: // RESERVAR SALA
			resgitrarSala();
			break;
		case 2: // REGISTRAR USUARIO
			registrarUsuario();
			break;
		case 3: // HACER RESERVA
			hacerReserva();
			break;
		case 4: // VER RESERVAS
			verReservas();
			break;
		case 0: // SALIR DEL PROGRAMA
			continuarMain = false;
			System.out.printf("El programa ha finalizado.\n");
			break;
		case 12749: // NO INGRESO UN NÚMERO (YA SALIO EL MENSAJE)
			break;
		default: // ÓPCION INGRESADA NO ES DE 1 A 9
			System.out.printf("⚠️ Opción no válida, intente nuevamente.\n");
			break;
		}

	}
    
    private static void verReservas() {
		// TODO Auto-generated method stub
		
	}

	private static void hacerReserva() {
		// TODO Auto-generated method stub
		
	}

	private static void registrarUsuario() {
		// TODO Auto-generated method stub
		
		System.out.println("Ingrese los nombres del nuevo usuario: ");
		String nombres = sc.nextLine();
		
		System.out.println("Ingrese los apellidos del nuevo usuario: ");
		String apellidos = sc.nextLine();
		
		System.out.println("Ingrese el run del nuevo usuario: ");
		String run = sc.nextLine();
		
		Usuario nuevoUsuario = new Usuario(nombres, apellidos, run);
		UsuariosDAO usuarioDao = new UsuariosDAO();
		 // 🔹 INSERTAR nuevo usuario
        if (usuarioDao.insertarUsuario(nuevoUsuario)) {
            System.out.println("\n✅ Usuario registrado correctamente.");
        }
		
	}

	private static void resgitrarSala() {
		// TODO Auto-generated method stub
		
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
