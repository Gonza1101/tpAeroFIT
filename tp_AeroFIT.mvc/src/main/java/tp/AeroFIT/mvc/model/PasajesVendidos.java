package tp.AeroFIT.mvc.model;

public class PasajesVendidos {

	private String nombre;
	private String apellido;
	private Integer dni;
	private Integer cantPasajesComprado;
	
	public PasajesVendidos(String nombre, String apellido, Integer dni, Integer cantPasajeComprado) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.dni = dni;
		this.cantPasajesComprado = cantPasajeComprado;
	}

	
	// Getter y Setter

	public String getNombre() {
		return nombre;
	}

	public String getApellido() {
		return apellido;
	}


	public void setApellido(String apellido) {
		this.apellido = apellido;
	}


	public void setNombre(String nombreApellido) {
		this.nombre = nombreApellido;
	}

	public Integer getDni() {
		return dni;
	}

	public void setDni(Integer dni) {
		this.dni = dni;
	}

	public Integer getCantPasajesComprado() {
		return cantPasajesComprado;
	}

	public void setCantPasajesComprado(Integer cantPasajesComprado) {
		this.cantPasajesComprado = cantPasajesComprado;
	}
}
