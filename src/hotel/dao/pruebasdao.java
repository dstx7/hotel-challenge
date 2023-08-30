package hotel.dao;

import java.util.List;

import hotel.modelo.Huespedes;

public class pruebasdao {
	public static void main(String[] args) {

		HuespedesDAO huespedesDAO = new HuespedesDAO();
		huespedesDAO.guardar();
		imprimir();

		huespedesDAO.editar();
		imprimir();

		huespedesDAO.eliminar();
		imprimir();

	}

	public static void imprimir() {
		HuespedesDAO huespedesDAO = new HuespedesDAO();
		List<Huespedes> huesped = huespedesDAO.listar();
		for (Huespedes huespedes : huesped) {
			System.out.println(huespedes.getId() + " " + huespedes.getNombre() + " " + huespedes.getApellido() + " "
					+ huespedes.getFechaDeNacimiento() + " " + huespedes.getNacionalidad() + " "
					+ huespedes.getTelefono() + " " + huespedes.getIdReserva());
		}
	}
}
 