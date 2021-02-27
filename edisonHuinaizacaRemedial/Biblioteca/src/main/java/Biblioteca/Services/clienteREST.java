package biblioteca.Services;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;


import biblioteca.Modelo.Libro;
import biblioteca.Negocio.bibliotecaON;
@Path("biblioteca")
public class clienteREST {
	@Inject
	private bibliotecaON bibliotecaON;
	 @GET
	    @Path("listarLibros")
	    @Produces("application/json")
	    public List<Libro> listarSaldo() throws Exception {
		 //System.out.println("datoresivido"+clave);
	    	return bibliotecaON.listarLibros();
	    }
}
