package pruebas_kata5;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InsertarDatosTabla {

	public static void main(String[] args) {
		InsertarDatosTabla idt = new InsertarDatosTabla();
		// Se insertar 3 nuevas l�neas
		idt.insert("abc@ulpgc.es");
		idt.insert("xyz@ull.es");
		idt.insert("def123@gmail.com");
	}
	
	
	private Connection connect() {
		// Cadena de conexi�n SQLite
		String url = "jdbc:sqlite:mail.db";
		Connection conn = null;
		
		try {
			conn = DriverManager.getConnection(url);
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return conn;
	}
	
	// M�todo para insertar datos en la tabla direcc_email
	public void insert(String email) {
		String sql = "INSERT INTO direcc_email(direccion) VALUES(?)";
		
		try (Connection conn = this.connect();
		PreparedStatement pstmt = conn.prepareStatement(sql)) {
			
			pstmt.setString(1, email);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

}
