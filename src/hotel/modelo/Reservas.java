package hotel.modelo;

import java.sql.Date;

public class Reservas {

	private Integer Id;
	private Date FechaEntrada;
	private Date FechaSalida;
	private String Valor;
	private String FormaPago;
	
	public Reservas(Integer Id, Date fechaEntrada, Date fechaSalida, String valor, String formaPago) {
		this.Id = Id;
		this.FechaEntrada = fechaEntrada;
		this.FechaSalida = fechaSalida;
		this.Valor = valor;
		this.FormaPago = formaPago;
	}
	
	public Integer getId() {
		return Id;
	}

	public void setId(Integer id) {
		Id = id;
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

	
	
	
	
	
	
}
