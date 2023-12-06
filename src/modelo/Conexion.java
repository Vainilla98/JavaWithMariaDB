package modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
	private static Conexion instancia = null;
	private Connection conexion = null;

	private Conexion() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conexion = DriverManager.getConnection("jdbc:mysql://localhost/metro", "root", "");
		} catch (ClassNotFoundException | SQLException e) {
			System.out.println(e.getLocalizedMessage());
			System.exit(100);
		}
	}

	public static Connection getConexion() {
		if (instancia == null) {
			instancia = new Conexion();
		}
		return instancia.conexion;
	}
	public static void closeConexion() throws SQLException {
		instancia.conexion.close();
		instancia.conexion = null;
		instancia = null;
		
	}
}
