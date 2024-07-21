    package tp.AeroFIT.mvc.filtro;

import java.io.IOException;
import org.springframework.stereotype.Component;
import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;



@Component
public class Filtro implements Filter {
	
	private Monitor monitor;

	public Filtro() {
		super();
		this.monitor = new Monitor();
	}

	
	
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		//se intercepta los request y response antes de ser mandados al RestController
		this.monitor.doConsulta();
		chain.doFilter(request, response);// chain, continua al RestController
		// TODO despues del Controller 
		this.monitor.exitConsulta();
		
	}
	
	

}