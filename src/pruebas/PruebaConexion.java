package pruebas;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class PruebaConexion {

	public static void main(String[] args) {
		Connection con;
		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost/hotel_alura?useTimeZone=true&serverTimeZone=UTC",
					"root", "admin");
			System.out.println("conexion con db");
			con.close();
			System.out.println("cerrando conexion");
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
}
