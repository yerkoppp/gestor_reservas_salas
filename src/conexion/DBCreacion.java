package conexion;


import java.io.IOException;
import java.sql.*;

public class DBCreacion {

	public DBCreacion() {
		crearTablaSalas();
		crearTablaUsuarios();
		crearTablaReservas();
	}

	private void crearTablaSalas() {
		// DDL (Data Definition Language) - Define la estructura de la tabla
		String sql = """
				    CREATE TABLE IF NOT EXISTS salas (
				        idsala INT AUTO_INCREMENT PRIMARY KEY,  -- Clave primaria que se incrementa automáticamente
				        nombre VARCHAR (30) NOT NULL,           -- Contenido del mensaje (obligatorio)
				        capacidad INT 							-- Capacidad de la sala
				    )
				""";

		// try-with-resources: Garantiza que el Statement se cierre automáticamente
		try (Connection conn = DBManager.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
			// Statement se usa para ejecutar SQL estático (sin parámetros)
			stmt.execute(sql);

		} catch (SQLException | IOException e) {
			System.err.println("Error al crear tabla: " + e.getMessage());
		}
	}

	private void crearTablaUsuarios() {
		// DDL (Data Definition Language) - Define la estructura de la tabla
		String sql = """
				    CREATE TABLE IF NOT EXISTS usuarios (
				        idusuario INT AUTO_INCREMENT PRIMARY KEY,  -- Clave primaria que se incrementa automáticamente
				        nombres VARCHAR (50) NOT NULL, --
				        apellidos VARCHAR (50) NOT NULL, --
				        run VARCHAR (12) NOT NULL --
				    )
				""";

		// try-with-resources: Garantiza que el Statement se cierre automáticamente
		try (Connection conn = DBManager.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
			// Statement se usa para ejecutar SQL estático (sin parámetros)
			stmt.execute(sql);

		} catch (SQLException | IOException e) {
			System.err.println("Error al crear tabla: " + e.getMessage());
		}
	}

	private void crearTablaReservas() {
		// DDL (Data Definition Language) - Define la estructura de la tabla
		String sql = """
				    CREATE TABLE IF NOT EXISTS reservas (
				        idreservas INT AUTO_INCREMENT PRIMARY KEY,  -- Clave primaria que se incrementa automáticamente
				        salas_idsala INT NOT NULL, --
				        usuarios_idusuario INT NOT NULL,
				        fecha_creacion DATE NOT NULL,	-- Fecha y hora del registro (obligatorio)
				        fecha_reserva DATE NOT NULL,       -- Fecha y hora de la reserva (obligatorio)
				        observacion TEXT,              -- Contenido del mensaje
				        CONSTRAINT reservas_salas FOREIGN KEY (salas_idsala) REFERENCES salas (idsala),
				        CONSTRAINT reservas_usuario FOREIGN KEY (usuarios_idusuario) REFERENCES usuarios (idusuario)
				    )
				""";

		// try-with-resources: Garantiza que el Statement se cierre automáticamente
		try (Connection conn = DBManager.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
			// Statement se usa para ejecutar SQL estático (sin parámetros)
			stmt.execute(sql);

		} catch (SQLException | IOException e) {
			System.err.println("Error al crear tabla: " + e.getMessage());
		}
	}

}
