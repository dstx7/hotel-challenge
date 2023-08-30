package hotel.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.mysql.cj.protocol.Resultset;

import hotel.factory.ConnectionFactory;
import hotel.modelo.Huespedes;

public class HuespedesDAO {
	// guardar (insert), editar (update),listar(select), eliminar(delete)
	// preparar el statement, executar el statement, resulsetear el statement.

	public void guardar() {
		ConnectionFactory connectionFactory = new ConnectionFactory();
		Connection con = connectionFactory.recuperarConexion();

		PreparedStatement pstm;
		try {
			pstm = con.prepareStatement("INSERT INTO huespedes(Nombre, Apellido, Fecha_de_nacimiento, "
					+ "Nacionalidad, Telefono) " + "VALUES (?, ?, ?, ?, ?)", Statement.RETURN_GENERATED_KEYS);
			pstm.setString(1, "Paola");
			pstm.setString(2, "Pabon");
			pstm.setString(3, "1997-11-29");
			pstm.setString(4, "Colombia");
			pstm.setString(5, "123456789");

			pstm.execute();
			pstm.close();

			//Resultset resultSet = pstm.getGeneratedKeys();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	public List<Huespedes> listar() {
		ConnectionFactory connectionFactory = new ConnectionFactory();
		Connection con = connectionFactory.recuperarConexion();
		List<Huespedes> resultado = new ArrayList<Huespedes>() ;
		
		PreparedStatement pstm;
		try {
			pstm = con.prepareStatement("SELECT * FROM huespedes");
			pstm.execute();
			ResultSet resultSet = pstm.getResultSet();
			while(resultSet.next()) {
				resultado.add(new Huespedes(
						resultSet.getInt("Id"),
						resultSet.getString("Nombre"),
						resultSet.getString("Apellido"),
						resultSet.getDate("Fecha_de_nacimiento"),
						resultSet.getString("Nacionalidad"),
						resultSet.getString("Telefono"),
						resultSet.getInt("Id_reserva")));
			}
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return resultado;
	}
	
	public void editar() {
		ConnectionFactory connectionFactory = new ConnectionFactory();
		Connection con = connectionFactory.recuperarConexion();
		try {
			PreparedStatement pstm = con.prepareStatement("UPDATE huespedes SET Nombre = ?,"
					+ "Apellido = ?,"
					+ "Fecha_de_nacimiento = ?,"
					+ "Nacionalidad = ?,"
					+ "Telefono = ? "
					+ "WHERE Id = ?");
			pstm.setString(1, "natalia");
			pstm.setString(2, "garzon");
			pstm.setString(3, "1999-11-29");
			pstm.setString(4, "Colombia");
			pstm.setString(5, "15555");
			pstm.setInt(6, 4);
			
			pstm.execute();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void eliminar() {
		ConnectionFactory connectionFactory = new ConnectionFactory();
		Connection con = connectionFactory.recuperarConexion();
		try {
			PreparedStatement pstm = con.prepareStatement("DELETE FROM huespedes WHERE Id = ?");
			pstm.setInt(1, 6);
			
			pstm.execute();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
