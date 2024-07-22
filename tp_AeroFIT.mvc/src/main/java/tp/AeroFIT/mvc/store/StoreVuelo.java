package tp.AeroFIT.mvc.store;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;

import tp.AeroFIT.mvc.dto.*;
import tp.AeroFIT.mvc.model.*;

public class StoreVuelo {
	
	private static StoreVuelo INSTANCE;
	
	private Collection<Vuelo> storeVuelo;
	private MensajeDto mensajeDto;
	
	private Vuelo vuelo1 = new Vuelo(323,125, LocalDate.of(2024, 10, 7));
	private Vuelo vuelo2 = new Vuelo(420,50, LocalDate.of(2024, 9, 8));
	private Vuelo vuelo3 = new Vuelo(123,50, LocalDate.of(2024, 8, 9));
	
	public StoreVuelo() {
		this.storeVuelo = new ArrayList<>();
		this.setMensajeDto(new MensajeDto());
		this.agregarVuelo();
	}
	
	public static StoreVuelo getInstance() {
		if (INSTANCE == null) {
			INSTANCE = new StoreVuelo();
		}
		return INSTANCE;
	}
	
	public Collection<Vuelo> findAll(){
		return this.storeVuelo;
	}
	
	public void agregarVuelo() {
		this.addVuelo(vuelo1);
		this.addVuelo(vuelo2);
		this.addVuelo(vuelo3);
	}
	//Buscar vuelo por vid
	public synchronized Vuelo findById(Integer id) {
		
		return this.storeVuelo.stream()
								.filter(i-> i.getVid().equals(id))
								.findFirst()
								.orElse(null);
	}
	// Agrega Vuelo Nuevo
	public synchronized MensajeDto addVuelo(Vuelo nuevoVuelo) {
		if( this.findById(nuevoVuelo.getVid()) == null ) {
			this.storeVuelo.add(nuevoVuelo);
			MensajeDto.getInstance().setMensaje("Se Cargo El Vuelo id: "+ nuevoVuelo.getVid());
			return MensajeDto.getInstance();
		}else {
			 MensajeDto.getInstance().setMensaje("El Vuelo ya Existe");
			return MensajeDto.getInstance();
		}
	}
	
	// Elimina Vuelo de la lista
	public synchronized MensajeDto deleteVuelo(Integer id) {
		
		if (!(this.findById(id) == null)) {
			this.storeVuelo.remove(this.findById(id));
			MensajeDto.getInstance().setMensaje("Se elimino el Vuelo");
			return MensajeDto.getInstance();
		}else
			MensajeDto.getInstance().setMensaje("N existe un vuelo con es Vuelo_Id");
			return MensajeDto.getInstance();	}
	
	// Busqueda Vuelo Disponible
	public synchronized Collection<Vuelo> vuelosDisponibles(){
		
		return this.storeVuelo;
		
	}
	
	//TODO traer el vuelo con id y agregar pasajeComprado.
	public synchronized MensajeDto buyPasajeVuelo ( VueloPasajeDto pasajeAComprar) {
		
		if( pasajeAComprar.getCantPasajesComprado() < this.findById(pasajeAComprar.getVid()).pasajesDisponibles()) {
			PasajesVendidos pasajero = pasajeAComprar.ventaPasajeroToModel();
			this.findById(pasajeAComprar.getVid()).addPasajeVendido(pasajero);
			MensajeDto.getInstance().setMensaje("Pasajes Comprados");
			return MensajeDto.getInstance();
		}else{
			MensajeDto.getInstance().setMensaje("No hay Pasajes Disponibles");
			return MensajeDto.getInstance();
		}
		
		
		
	}

	public MensajeDto getMensajeDto() {
		return mensajeDto;
	}

	public void setMensajeDto(MensajeDto mensajeDto) {
		this.mensajeDto = mensajeDto;
	}
		
}
