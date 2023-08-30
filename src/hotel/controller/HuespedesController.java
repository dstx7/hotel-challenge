package hotel.controller;

import java.sql.Connection;
import java.util.List;

import hotel.dao.HuespedesDAO;
import hotel.factory.ConnectionFactory;
import hotel.modelo.Huespedes;

public class HuespedesController {

	private HuespedesDAO huespedesDAO;

	public HuespedesController(HuespedesDAO huespedesDAO) {
		ConnectionFactory connectionFactory = new ConnectionFactory();
		Connection con = connectionFactory.recuperarConexion();
		this.huespedesDAO = new HuespedesDAO(con);
	}

	public void guardar(Huespedes huespedes) {
		this.huespedesDAO.guardar(huespedes);
	}
	
	public List<Huespedes> listar() {
		return this.huespedesDAO.listar();
		
	}

}
