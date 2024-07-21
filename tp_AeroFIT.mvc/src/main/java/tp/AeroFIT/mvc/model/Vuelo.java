package tp.AeroFIT.mvc.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


public class Vuelo {
	private Integer vid;
	private Integer capacidadMax;
	private LocalDate fechaVuelo;
	private List <PasajesVendidos> listaVenta;
	
	public Vuelo(Integer vid, Integer capacidadMax, LocalDate fechaVuelo) {
		
		this.vid = vid;
		this.capacidadMax = capacidadMax;
		this.fechaVuelo = fechaVuelo;
		this.listaVenta = new ArrayList<>();
		
	}
	
	public Integer pasajesVendidos() {
		Integer totalPasajes = 0;
		for(PasajesVendidos pasajero : this.listaVenta) {
			totalPasajes += pasajero.getCantPasajesComprado();
		}
		return totalPasajes;
	}
	
	public Integer pasajesDisponibles() {
		
		return this.capacidadMax - this.pasajesVendidos();
	}
	
	public void addPasajeVendido(PasajesVendidos pasajeVendido) {

		this.listaVenta.add(pasajeVendido);	
	}
	
	// Getter - Setter

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

	public List<PasajesVendidos> getListaVenta() {
		return listaVenta;
	}

}
