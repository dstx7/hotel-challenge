package hotel.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

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
					resultado.add(new Huespedes(resultSet.getInt("Id"), resultSet.getString("Nombre"),
							resultSet.getString("Apellido"), resultSet.getDate("Fecha_de_nacimiento"),
							resultSet.getString("Nacionalidad"), resultSet.getString("Telefono"),
							resultSet.getInt("Id_reserva")));
				}
			}

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

		return resultado;
	}

	public void editar(String nombre, String apellido, Date fechaNacimiento, String nacionalidad, String telefono,
			Integer idReserva, Integer Id) {

		try {
			String sql = "UPDATE huespedes SET Nombre = ?, Apellido = ?, Fecha_de_nacimiento = ?, Nacionalidad = ?, Telefono = ?, Id_reserva = ?"
					+ " WHERE Id = ?";
			try (PreparedStatement pstm = con.prepareStatement(sql)) {
				pstm.setString(1, nombre);
				pstm.setString(2, apellido);
				pstm.setDate(3, fechaNacimiento);
				pstm.setString(4, nacionalidad);
				pstm.setString(5, telefono);
				pstm.setInt(6, idReserva);
				pstm.setInt(7, Id);

				pstm.execute();
			}

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public void eliminar(Integer Id) {

		try {
			String sql = "DELETE FROM huespedes WHERE Id = ?";

			try (PreparedStatement pstm = con.prepareStatement(sql)) {
				pstm.setInt(1, Id);

				pstm.execute();
			}

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

	}

	public List<Huespedes> buscarId(Integer id) {
		List<Huespedes> resultado = new ArrayList<Huespedes>();
		try {
			String sql = "SELECT * FROM huespedes WHERE Id_reserva = ?";

			try (PreparedStatement pstm = con.prepareStatement(sql)) {
				pstm.setInt(1, id);

				pstm.execute();

				ResultSet resultSet = pstm.getResultSet();
				while (resultSet.next()) {
					resultado.add(new Huespedes(resultSet.getInt("Id"), resultSet.getString("Nombre"),
							resultSet.getString("Apellido"), resultSet.getDate("Fecha_de_nacimiento"),
							resultSet.getString("Nacionalidad"), resultSet.getString("Telefono"),
							resultSet.getInt("Id_reserva")));
				}
			}

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

		return resultado;
	}

}
