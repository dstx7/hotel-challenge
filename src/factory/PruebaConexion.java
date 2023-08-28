package factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class PruebaConexion {

	public static void main(String[] args) throws SQLException {
		
		ConnectionFactory connectionFactory = new ConnectionFactory();
		Connection connection = connectionFactory.recuperarConexion();

		System.out.println("Probando conexion!!");

		connection.close();
		
		System.out.println("Conexión cerrada!!");
	}
}
