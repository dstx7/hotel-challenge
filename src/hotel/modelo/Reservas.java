package hotel.modelo;

import java.sql.Date;

public class Reservas {

	private Integer Id;
	private Date FechaEntrada;
	private Date FechaSalida;
	private String Valor;
	private String FormaPago;
	
	public Reservas(Date fechaEntrada, Date fechaSalida, String valor, String formaPago) {
		FechaEntrada = fechaEntrada;
		FechaSalida = fechaSalida;
		Valor = valor;
		FormaPago = formaPago;
	}

	public Date getFechaEntrada() {
		return FechaEntrada;
	}

	public void setFechaEntrada(Date fechaEntrada) {
		FechaEntrada = fechaEntrada;
	}

	public Date getFechaSalida() {
		return FechaSalida;
	}

	public void setFechaSalida(Date fechaSalida) {
		FechaSalida = fechaSalida;
	}

	public String getValor() {
		return Valor;
	}

	public void setValor(String valor) {
		Valor = valor;
	}

	public String getFormaPago() {
		return FormaPago;
	}

	public void setFormaPago(String formaPago) {
		FormaPago = formaPago;
	}

	public Integer getId() {
		return Id;
	}
	
	
	
	
	
}
