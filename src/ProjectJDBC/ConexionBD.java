
package ProjectJDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionBD {
   private static final String URL = "jdbc:mysql://localhost:3308/kd_electronics";
    private static final String USUARIO = "root";
    private static final String PASSWORD = "Laura307.";

    public static Connection conectar() throws SQLException {
        return DriverManager.getConnection(URL, USUARIO, PASSWORD);
    }

    public static void probarConexion() {
        try (Connection conn = conectar()) {
            if (conn != null) {
                System.out.println("✅ Conexión exitosa a la base de datos.");
            }
        } catch (SQLException e) {
            System.out.println("❌ Error al conectar a la base de datos:");
            System.out.println(e.getMessage());
        }
    }
}

