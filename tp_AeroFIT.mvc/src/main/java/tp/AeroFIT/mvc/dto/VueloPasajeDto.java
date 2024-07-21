package tp.AeroFIT.mvc.dto;


import java.time.LocalDate;

import tp.AeroFIT.mvc.model.PasajesVendidos;
import tp.AeroFIT.mvc.model.Vuelo;

public class VueloPasajeDto {

	private Integer vid;
	private Integer capacidadMax;
	private LocalDate fechaVuelo;
	private String nombre;
	private String apellido;
	private Integer dni;
	private Integer cantPasajesComprado;
	
	

	public VueloPasajeDto() {}
	
	public VueloPasajeDto(Integer vid, Integer capacidadMax, LocalDate fechaVuelo, String nombre, String apellido, Integer dni, Integer cantPasajesComprado ) {
		this.vid = vid;
		this.capacidadMax = capacidadMax;
		this.fechaVuelo = fechaVuelo;
		this.nombre = nombre;
		this.apellido = apellido;
		this.dni = dni;
		this.cantPasajesComprado = cantPasajesComprado;
	
	}
	
	//  to Model
	
	public Vuelo vueloToModel() {
		Vuelo nuevoVuelo = new Vuelo(this.vid, this.capacidadMax, this.fechaVuelo);
		return nuevoVuelo;
	}
	
	public PasajesVendidos ventaPasajeroToModel() {
		PasajesVendidos nuevoPasajero = new PasajesVendidos(this.nombre, this.apellido, this.dni,this.cantPasajesComprado);
		return nuevoPasajero;
	}

	public Integer getVid() {
		return vid;
	}

	public void setVid(Integer vid) {
		this.vid = vid;
	}

	public Integer getCapacidadMax() {
		return capacidadMax;
	}

	public void setCapacidadMax(Integer capacidadMax) {
		this.capacidadMax = capacidadMax;
	}

	public LocalDate getFechaVuelo() {
		return fechaVuelo;
	}

	public void setFechaVuelo(LocalDate fechaVuelo) {
		this.fechaVuelo = fechaVuelo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
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

	// Getter Setter
	
}
