package hotel.factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class ConnectionFactory {
	
	private DataSource datasource;
	
	public ConnectionFactory() {
		ComboPooledDataSource comboPooledDataSource = new ComboPooledDataSource();
		comboPooledDataSource.setJdbcUrl("jdbc:mysql://localhost/hotel_alura?useTimeZone=true&serverTimeZone=UTC");
		comboPooledDataSource.setUser("root");
		comboPooledDataSource.setPassword("admin");
		
		comboPooledDataSource.setMaxConnectionAge(2);
		comboPooledDataSource.setMaxIdleTime(10);
		
		this.datasource = comboPooledDataSource;
	}
	
	public Connection recuperarConexion() {
		try {
			//System.out.println("Probando conexion!!");
			return this.datasource.getConnection();
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	
}
