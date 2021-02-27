package biblioteca.Services;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
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
	 
	 @POST
		@Path("reserva")
		@Consumes("application/json")
	    @Produces("application/json")
		public Mensaje Transferencia(Libro trans) throws Exception {
	    	Mensaje m = new Mensaje();
			try { 
				Libro preserva =new Libro();
				Libro reservado = new Libro();
				preserva=bibliotecaON.busqueda(trans.getNombre());
				
				reservado.setAutor(preserva.getAutor());
				reservado.setCategoria(preserva.getCategoria());
				reservado.setEstado("reservado");
				reservado.setId(preserva.getId());
				reservado.setNombre(preserva.getNombre());
				reservado.setNumero(preserva.getNumero()-1);
				bibliotecaON.reserva(reservado);
				
				//gestionProvedorON.insertar(trans);
				System.out.println(trans.getNombre());
				m.setCode("ok");
				m.setMessage("transferencia exitosa");
				return m;
			} catch (NumberFormatException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return m;
			} 
}
	 @GET
	    @Path("listarCategoria")
	    @Produces("application/json")
	    public List<Libro> listarcategoria(@QueryParam("categoria")String categoria) throws Exception {
		 //System.out.println("datoresivido"+clave);
	    	return bibliotecaON.listarLibrosCategoria(categoria);
	    }
}
