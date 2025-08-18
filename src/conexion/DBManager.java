package conexion;

import java.io.InputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class DBManager {
    private static final String CONFIG_FILE = "config.properties";

    public static Connection getConnection() throws SQLException, IOException {
        Properties prop = new Properties();

        // Cargar archivo de configuración desde el classpath
        try (InputStream input = DBManager.class.getClassLoader().getResourceAsStream(CONFIG_FILE)) {
            if (input == null) {
                throw new IOException("Archivo de propiedades no encontrado: " + CONFIG_FILE);
            }
            prop.load(input);
        }

        String dbUrl = prop.getProperty("db.url");
        String dbUser = prop.getProperty("db.user");
        String dbPassword = prop.getProperty("db.password");

        if (dbUrl == null || dbUser == null || dbPassword == null) {
            throw new IllegalArgumentException("Faltan parámetros en config.properties");
        }

        return DriverManager.getConnection(dbUrl, dbUser, dbPassword);
    }
    


}
