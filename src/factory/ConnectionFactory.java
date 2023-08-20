package factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	
	public ConnectionFactory() throws SQLException {
	Connection con = DriverManager.getConnection("jdbc:mysql://localhost/hotel_alura?useTimeZone=true&serverTimeZone=UTC",
			"root",
			"admin");
	
	System.out.println("conexion con db");
	con.close();
	}
}
