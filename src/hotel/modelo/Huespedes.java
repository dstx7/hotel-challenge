package hotel.modelo;

import java.sql.Date;

public class Huespedes {

	private Integer Id;
	private String Nombre;
	private String Apellido;
	private Date FechaDeNacimiento;
	private String Nacionalidad;
	private String Telefono;
	private Integer IdReserva;
	
	public Huespedes(Integer Id,String nombre, String apellido, Date fechaDeNacimiento, String nacionalidad, String telefono,
			Integer idReserva) {
		this.Id = Id;
		this.Nombre = nombre;
		this.Apellido = apellido;
		this.FechaDeNacimiento = fechaDeNacimiento;
		this.Nacionalidad = nacionalidad;
		this.Telefono = telefono;
		this.IdReserva = idReserva;
	}
	
	public Integer getId() {
		return Id;
	}
	
	public String getNombre() {
		return Nombre;
	}
	
	public void setNombre(String nombre) {
		Nombre = nombre;
	}
	
	public String getApellido() {
		return Apellido;
	}
	
	public void setApellido(String apellido) {
		Apellido = apellido;
	}
	
	public Date getFechaDeNacimiento() {
		return FechaDeNacimiento;
	}
	
	public void setFechaDeNacimiento(Date fechaDeNacimiento) {
		FechaDeNacimiento = fechaDeNacimiento;
	}
	
	public String getNacionalidad() {
		return Nacionalidad;
	}
	
	public void setNacionalidad(String nacionalidad) {
		Nacionalidad = nacionalidad;
	}
	
	public String getTelefono() {
		return Telefono;
	}
	
	public void setTelefono(String telefono) {
		Telefono = telefono;
	}
	
	public Integer getIdReserva() {
		return IdReserva;
	}
	
	public void setIdReserva(Integer idReserva) {
		IdReserva = idReserva;
	}
	
	
	
}
