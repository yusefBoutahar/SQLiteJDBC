package pruebas_kata5;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SelectAll_FromTable {
	
	public void selectAll() {
		String sql = "SELECT * FROM PEOPLE";
		
		try (Connection conn = this.connect();
			 Statement stmt = conn.createStatement();
			 ResultSet rs = stmt.executeQuery(sql)){
			
			// Bucle sobre el conjunto de resgistros.
			while(rs.next()) {
				System.out.println( rs.getInt("id") + "\t" +
									rs.getString("Name") + "\t" +
									rs.getString("Apellidos") + "\t" +
									rs.getString("Departamento") + "\t");

			}
					
		} catch(SQLException e) {
			System.out.println(e.getMessage());
		}
	}
	
	// Se conecta a la BD y se devuelve un objeto Connection
	private Connection connect() {
		// SQLite connection String
		String url = "jdbc:sqlite:C:Prueba.db";
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(url);
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return conn;
	}
	
}




