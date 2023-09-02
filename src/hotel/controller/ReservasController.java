package hotel.controller;

import java.sql.Connection;
import java.sql.Date;
import java.util.List;

import hotel.dao.ReservasDAO;
import hotel.factory.ConnectionFactory;
import hotel.modelo.Reservas;

public class ReservasController {
	
	private ReservasDAO reservasDAO;

	public ReservasController() {
		ConnectionFactory connectionFactory = new ConnectionFactory();
		Connection con = connectionFactory.recuperarConexion();
		this.reservasDAO = new ReservasDAO(con);
	}
	
	public void guardar(Reservas reservas) {
		this.reservasDAO.guardar(reservas);
	}
	
	public List<Reservas> listar() {
		return this.reservasDAO.listar();
	}
	
	public List<Reservas> listarId(Integer Id) {
		return this.reservasDAO.listarId(Id);
	}
	
	public void editar(Integer Id,Date FechaEntrada,Date FechaSalida,String Valor,String FormaPago) {
		this.reservasDAO.editar(Id,FechaEntrada,FechaSalida,Valor,FormaPago );
	}
	
	public void eliminar(Integer Id) {
		this.reservasDAO.eliminar(Id);
		
	}
	
	
}
