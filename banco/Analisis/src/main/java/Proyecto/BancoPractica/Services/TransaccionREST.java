package Proyecto.BancoPractica.Services;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import Proyecto.BancoPractica.Modelo.Estado;
import Proyecto.BancoPrectica.Negocio.GestionCajeroON;


import java.util.List;


@Path("transacciones")
public class TransaccionREST {
	 @Inject
	 private GestionCajeroON  cajeroON;
	    @POST
		@Path("deposito")
		@Consumes("application/json")
	    @Produces("application/json")
		public Mensaje deposito(Estado estado) throws Exception {
	    	Mensaje m = new Mensaje();
			try { 
				cajeroON.Depocito(estado);
				m.setCode("ok");
				m.setMessage("Retiro exitoso");
				return m;
			} catch (NumberFormatException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return m;
			} 
		}

	    @POST
		@Path("retiro")
	    @Consumes("application/json")
	    @Produces("application/json")
		public Mensaje retiro(Estado estado){
	    	Mensaje m = new Mensaje();
			try {
				cajeroON.Retiro(estado);
				m.setCode("ok");
				m.setMessage("Retiro exitoso");
				return m;
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				m.setCode("ERROR");
				m.setMessage(e.getMessage());
				return m;
			}
			} 	
}
