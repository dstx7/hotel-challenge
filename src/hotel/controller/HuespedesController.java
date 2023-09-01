package hotel.controller;

import java.sql.Connection;
import java.sql.Date;
import java.util.List;

import hotel.dao.HuespedesDAO;
import hotel.factory.ConnectionFactory;
import hotel.modelo.Huespedes;

public class HuespedesController {

	private HuespedesDAO huespedesDAO;

	public HuespedesController() {
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
	
	public List<Huespedes> listarId(Integer Id) {
		return this.huespedesDAO.buscarId(Id);
	}
	
	public void editar(String nombre, String apellido, Date fechaNacimiento, String nacionalidad, String telefono, Integer idReserva, Integer Id) {
		this.huespedesDAO.editar(nombre, apellido, fechaNacimiento, nacionalidad, telefono, idReserva, Id);
	}
	
	public void eliminarr(Integer Id) {
		this.huespedesDAO.eliminar(Id);
	}

}
