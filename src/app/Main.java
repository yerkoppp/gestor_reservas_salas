package app;

import conexion.DBCreacion;
import conexion.DBManager;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;

import dao.ReservasDAO;
import dao.SalasDAO;
import dao.UsuariosDAO;
import model.Sala;
import model.Reserva;
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
            DBCreacion db = new DBCreacion();
            
        } catch (SQLException e) {
            System.err.println("❌ Error SQL al conectar: " + e.getMessage());
        } catch (IOException e) {
            System.err.println("❌ Error de configuración: " + e.getMessage());
        }
        
        DBCreacion dbCreacion = new DBCreacion();      
        
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
			registrarSala();
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
    	ReservasDAO reservaDao = new ReservasDAO();
    	 System.out.println("\n📋 LISTADO DE RESERVAS:");
         List<Reserva> reservas = reservaDao.listarReservas();
         reservas.forEach(System.out::println);
	}

	private static void hacerReserva() {
		// TODO Auto-generated method stub
		System.out.println("Ingrese su ID de usuario: ");
		int idusuario = sc.nextInt();
		sc.nextLine();
		
		System.out.println("Ingrese el ID de la sala que desea reservar: ");
		int idsala = sc.nextInt();
		sc.nextLine();
		
		System.out.println("Ingrese la fecha que desea reservar (yyyy-mm-dd): ");
		String fechaReserva = sc.nextLine();
	
		Reserva nuevaReserva = new Reserva(idsala, idusuario, Date.valueOf(LocalDate.now()), Date.valueOf(fechaReserva));
		ReservasDAO reservaDao = new ReservasDAO();
		 // 🔹 INSERTAR nuevo usuario
        if (reservaDao.insertarReserva(nuevaReserva)) {
            System.out.println("\n✅ Reserva ingresada correctamente.");
        }
		
	}

	private static void registrarUsuario() {
		// TODO Auto-generated method stub
		Usuario nuevoUsuario = new Usuario();
		String nombres, apellidos, run;
		
		System.out.println("Ingrese los nombres del nuevo usuario: ");
		nombres = sc.nextLine();
		nuevoUsuario.setNombres(nombres);
		
		System.out.println("Ingrese los apellidos del nuevo usuario: ");
		apellidos = sc.nextLine();
		nuevoUsuario.setApellidos(apellidos);
		
		while (true) {
			try {
				System.out.println("Ingrese el run del nuevo usuario: ");
				run = sc.nextLine();
				nuevoUsuario.setRun(run);
				break;
			} catch (IllegalArgumentException e) {
				System.out.println(e.getMessage());
			}

		}
		
		UsuariosDAO usuarioDao = new UsuariosDAO();
		 // 🔹 INSERTAR nuevo usuario
        if (usuarioDao.insertarUsuario(nuevoUsuario)) {
            System.out.println("\n✅ Usuario registrado correctamente.");
        }
        
        int id = usuarioDao.consultarID(nuevoUsuario);
        System.out.println("Su ID de usuario es: "+id);
        nuevoUsuario.setIdusuario(id);
		
	}

	private static void registrarSala() {
		
		while (true) {
			try {
				System.out.println("Ingrese el nombres de la sala: ");
				String nombres = sc.nextLine();
				
				System.out.println("Ingrese la capacidad de la sala: ");
				int apellidos = sc.nextInt();
				sc.nextLine();
				
				
				Sala sala = new Sala(nombres, apellidos);
				SalasDAO salaDAO = new SalasDAO();
				
		        if (salaDAO.insertarSalas(sala)) {
		            System.out.println("\n✅ Sala registrada correctamente.");
		        }
				break;
			} catch (InputMismatchException e) {
				System.out.println("⚠️ Ingrese un número válido.");
				sc.nextLine();
			}
		}
	}
		   
    
    
}
