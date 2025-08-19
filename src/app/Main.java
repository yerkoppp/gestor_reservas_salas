package app;

import conexion.DBCreacion;
import conexion.DBManager;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;

import dao.ReservasDAO;
import dao.SalasDAO;
import dao.UsuariosDAO;
import model.Sala;
import model.Reserva;
import model.Usuario;
import model.Validacion;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Main {
	static Scanner sc = new Scanner(System.in);
	static boolean continuarMain = true;

	public static void main(String[] args) {
		try (Connection conn = DBManager.getConnection()) {
			System.out.println("✅ Conexión exitosa a la base de datos!");
			DBCreacion dbCreacion = new DBCreacion();

		} catch (SQLException e) {
			System.err.println("❌ Error SQL al conectar: " + e.getMessage());
		} catch (IOException e) {
			System.err.println("❌ Error de configuración: " + e.getMessage());
		}

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

		Date fecha;
		while (true) {
			System.out.print(
					"Ingrese la fecha que desea reservar (DD/MM/AAAA): ");
			String fechaReserva = sc.nextLine();
			SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
			try {
				Validacion.validarFecha(fechaReserva);
				java.util.Date fechaUtil = formato.parse(fechaReserva); // Devuelve
																		// java.util.Date
				fecha = new Date(fechaUtil.getTime()); // Convertir a
														// java.sql.Date
				break;
			} catch (DateTimeParseException e) {
				System.out.println(
						"Formato inválido. Ejemplo válido: 07/09/2025");
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalArgumentException e) {
				System.out.println(e.getMessage());
			}
		}

		Reserva nuevaReserva = new Reserva(idsala, idusuario,
				Date.valueOf(LocalDate.now()), fecha);
		ReservasDAO reservaDao = new ReservasDAO();
		// 🔹 INSERTAR nuevo usuario
		if (reservaDao.insertarReserva(nuevaReserva)) {
			System.out.println("\n✅ Reserva ingresada correctamente.");
		}

	}

	private static void registrarUsuario() {

		Usuario nuevoUsuario = new Usuario();
		String nombres, apellidos, run;

		while (true) {
			try {
				System.out.println("Ingrese los nombres del nuevo usuario: ");
				nombres = sc.nextLine();
				nuevoUsuario.setNombres(nombres);
				break;
			} catch (IllegalArgumentException e) {
				System.out.println(e.getMessage());
			}
		}

		while (true) {
			try {
				System.out.println("Ingrese los apellidos del nuevo usuario: ");
				apellidos = sc.nextLine();
				nuevoUsuario.setApellidos(apellidos);
				break;
			} catch (IllegalArgumentException e) {
				System.out.println(e.getMessage());
			}
		}

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
		if (!usuarioDao.comprobarUsuario(nuevoUsuario)) {
			if (usuarioDao.insertarUsuario(nuevoUsuario)) {
				System.out.println("\n✅ Usuario registrado correctamente.");
				int id = usuarioDao.consultarID(nuevoUsuario);
				System.out.println("Su ID de usuario es: " + id);
				nuevoUsuario.setIdusuario(id);
			}
		} else {
			System.out.println("El usuario ya existe en la base de dato.");
		}



	}

	private static void registrarSala() {
		Sala nuevaSala = new Sala();
		String nombre;
		int cantidad;

		while (true) {
			try {
				System.out.println("Ingrese el nombres de la sala: ");
				nombre = sc.nextLine();
				nuevaSala.setNombre(nombre);
				break;
			} catch (IllegalArgumentException e) {
				System.out.println(e.getMessage());
			}
		}

		while (true) {
			try {
				System.out.println("Ingrese la capacidad de la sala: ");
				cantidad = sc.nextInt();
				sc.nextLine();
				nuevaSala.setCapacidad(cantidad);

				break;
			} catch (InputMismatchException e) {
				System.out.println("⚠️ Ingrese un número válido.");
				sc.nextLine();
			}
		}

		SalasDAO salaDAO = new SalasDAO();

		if (salaDAO.insertarSalas(nuevaSala)) {
			System.out.println("\n✅ Sala registrada correctamente.");
		}
	}

}
