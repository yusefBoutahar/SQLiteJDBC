package pruebas_kata5;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class CrearTabla {
	public static void createNewTable() {
		// Cadena de conexi�n SQLite
		String url = "jdbc:sqlite:mail.db";
		// Instrucci�n SQL para crear nueva tabla
		String sql = "CREATE TABLE IF NOT EXISTS direcc_email (\n"
						+ " id integer PRIMARY KEY AUTOINCREMENT,\n"
							+ " direccion text NOT NULL);";
		
		try (Connection conn = DriverManager.getConnection(url);
				Statement stmt = conn.createStatement()) {
			// Se crea la nueva tabla
			stmt.execute(sql);
			System.out.println("Tabla creada");
		
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}
	
	public static void main(String[] args) {
		createNewTable();
	}
}
