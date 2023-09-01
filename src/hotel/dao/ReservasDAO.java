package hotel.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import hotel.modelo.Reservas;

public class ReservasDAO {

	private Connection con;

	public ReservasDAO(Connection con) {
		this.con = con;
	}

	public void guardar(Reservas reservas) {

		try {
			String sql = "INSERT INTO reservas(FechaEntrada, FechaSalida, Valor, FormaPago)" + " VALUES(? ,? ,? ,?)";

			try (PreparedStatement pstm = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
				pstm.setDate(1, reservas.getFechaEntrada());
				pstm.setDate(2, reservas.getFechaSalida());
				pstm.setString(3, reservas.getValor());
				pstm.setString(4, reservas.getFormaPago());

				pstm.execute();

				try (ResultSet resultSet = pstm.getGeneratedKeys()) {
					while (resultSet.next()) {
						reservas.setId(resultSet.getInt(1));
					}
				}

			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

	}

	public List<Reservas> listar() {

		try {
			String sql = "SELECT * FROM reservas";
			ArrayList<Reservas> resultado = new ArrayList<>();
			try (PreparedStatement pstm = con.prepareStatement(sql)) {

				pstm.execute();
				try (ResultSet resultSet = pstm.getResultSet()) {
					while (resultSet.next()) {
						resultado.add(new Reservas(resultSet.getInt("Id"), resultSet.getDate("FechaEntrada"),
								resultSet.getDate("FechaSalida"), resultSet.getString("Valor"),
								resultSet.getString("FormaPago")));
					}
				}
			}

			return resultado;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

	}

	public List<Reservas> listarId(Integer Id) {
		try {
			String sql = "SELECT * FROM reservas WHERE Id = ?";
			ArrayList<Reservas> resultado = new ArrayList<>();
			try (PreparedStatement pstm = con.prepareStatement(sql)) {
				pstm.setInt(1, Id);
				pstm.execute();
				try (ResultSet resultSet = pstm.getResultSet()) {
					while (resultSet.next()) {
						resultado.add(new Reservas(resultSet.getInt("Id"), resultSet.getDate("FechaEntrada"),
								resultSet.getDate("FechaSalida"), resultSet.getString("Valor"),
								resultSet.getString("FormaPago")));
					}
				}
			}

			return resultado;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public void editar(Integer Id, Date FechaEntrada, Date FechaSalida, String Valor, String FormaPago) {
		try {
			String sql = "UPDATE reservas SET FechaEntrada = ? ,FechaSalida = ? ,Valor = ? ,FormaPago= ? WHERE Id = ? ";
			try (PreparedStatement pstm = con.prepareStatement(sql)) {
				pstm.setDate(1, FechaEntrada);
				pstm.setDate(2, FechaSalida);
				pstm.setString(3, Valor);
				pstm.setString(4, FormaPago);
				pstm.setInt(5, Id);

				pstm.execute();
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

	}

	public void eliminar(Integer Id) {
		try {
			String sql = "DELETE FROM reservas WHERE Id = ?";
			try (PreparedStatement pstm = con.prepareStatement(sql)) {
				pstm.setInt(1, Id);
				pstm.execute();
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

	}

}
