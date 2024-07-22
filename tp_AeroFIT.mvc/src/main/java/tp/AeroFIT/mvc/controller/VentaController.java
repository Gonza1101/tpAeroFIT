package tp.AeroFIT.mvc.controller;



import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import java.util.Collection;


import tp.AeroFIT.mvc.dto.VueloPasajeDto;
import tp.AeroFIT.mvc.model.Vuelo;
import tp.AeroFIT.mvc.store.StoreVuelo;
import tp.AeroFIT.mvc.dto.MensajeDto;



@RestController("/aerofit")
public class VentaController {
	
	@GetMapping("/vuelosDisponibles")
	public Collection<Vuelo> vuelosDisponibles(){
		
		return StoreVuelo.getInstance().vuelosDisponibles();
	}
	
	@GetMapping("/obtenerVuelvo/{idVuelo}")
	public Vuelo findById(@PathVariable Integer idVuelo) {
		
		return StoreVuelo.getInstance().findById(idVuelo);
	}
	
	@PostMapping("/agregarVuelo")
	public MensajeDto addVuelo(@RequestBody VueloPasajeDto vueloPasajeDto ) {
		
		return StoreVuelo.getInstance().addVuelo( vueloPasajeDto.vueloToModel() ) ;
	}
	
	// TODO Compra de Pasaje esta compra tiene que ser en exclusion mutua posible semaphoro 
	
	@PostMapping("/comprarVuelo")
	public MensajeDto buyPasajeVuelo(@RequestBody VueloPasajeDto pasajeAComprar) {
		
		return StoreVuelo.getInstance().buyPasajeVuelo(pasajeAComprar );
		
	 
	}
	
}
