package hotel.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import hotel.factory.ConnectionFactory;
import hotel.modelo.Huespedes;

public class HuespedesDAO {
	// guardar (insert), editar (update),listar(select), eliminar(delete)
	// preparar el statement, executar el statement, resulsetear el statement.

	private Connection con;

	public HuespedesDAO(Connection con) {
		this.con = con;
	}

	public void guardar(Huespedes huespedes) {

		try {
			String sql = "INSERT INTO huespedes(Nombre, Apellido, Fecha_de_nacimiento,Nacionalidad, Telefono, IdReserva)"
					+ " VALUES (?, ?, ?, ?, ?, ?)";

			try (PreparedStatement pstm = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
				pstm.setString(1, huespedes.getNombre());
				pstm.setString(2, huespedes.getApellido());
				pstm.setDate(3, huespedes.getFechaDeNacimiento());
				pstm.setString(4, huespedes.getNacionalidad());
				pstm.setString(5, huespedes.getTelefono());
				pstm.setInt(6, huespedes.getIdReserva());

				pstm.execute();

				try (ResultSet resultSet = pstm.getGeneratedKeys()) {
					while (resultSet.next()) {
						huespedes.setId(resultSet.getInt(1));
					}
				}

			}

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

	}

	public List<Huespedes> listar() {
		List<Huespedes> resultado = new ArrayList<Huespedes>();

		try {
			String sql = "SELECT * FROM huespedes";

			try (PreparedStatement pstm = con.prepareStatement(sql)) {
				pstm.execute();
				ResultSet resultSet = pstm.getResultSet();
				while (resultSet.next()) {
					resultado.add(new Huespedes(resultSet.getInt("Id"),
							resultSet.getString("Nombre"),
							resultSet.getString("Apellido"),
							resultSet.getDate("Fecha_de_nacimiento"),
							resultSet.getString("Nacionalidad"),
							resultSet.getString("Telefono"),
							resultSet.getInt("Id_reserva")));
				}
			}

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

		return resultado;
	}

	public void editar() {
		ConnectionFactory connectionFactory = new ConnectionFactory();
		Connection con = connectionFactory.recuperarConexion();
		try {
			PreparedStatement pstm = con.prepareStatement("UPDATE huespedes SET Nombre = ?," + "Apellido = ?,"
					+ "Fecha_de_nacimiento = ?," + "Nacionalidad = ?," + "Telefono = ? " + "WHERE Id = ?");
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
