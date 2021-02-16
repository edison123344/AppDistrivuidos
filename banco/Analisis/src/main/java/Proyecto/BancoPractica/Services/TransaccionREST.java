package Proyecto.BancoPractica.Services;
/**
 * clase  que ara las transacciones de tipo res con el dispositivo movil
 */
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import Proyecto.BancoPractica.Modelo.Transferencia;
import Proyecto.BancoPractica.Modelo.Estado;
import Proyecto.BancoPractica.Modelo.Poliza;
import Proyecto.BancoPractica.Modelo.Usuario;

import Proyecto.BancoPrectica.Negocio.GestorClienteON;

import java.util.Date;
import java.util.List;
/**
 * 
 * @author edison
 *
 */

@Path("transacciones")
public class TransaccionREST {

	 @Inject
	 private GestorClienteON clienteON;
	 
		private List<Poliza>listaPoliza;
		private List<Estado> listarEstado;
		/**
		 * resive la informasion de una transferencia echa por la parate movil del sistema
		 * @param trans
		 * @return mensaje
		 * @throws Exception
		 */
	    @POST
		@Path("transferencia")
		@Consumes("application/json")
	    @Produces("application/json")
		public Mensaje Transferencia(Transferencia trans) throws Exception {
	    	Mensaje m = new Mensaje();
			try { 
				System.out.println(clienteON.transferencia(trans));
				m.setCode("ok");
				m.setMessage("transferencia exitosa");
				return m;
			} catch (NumberFormatException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return m;
			} 
		}

	   /**
	    * metodo que enviara el correo y el pasword del usuario para retonar el usuario de esta cuenta
	    * @param clave
	    * @param correo
	    * @return retorna el usuario
	    */
	    @GET
	    @Path("logeo")
	    @Produces("application/json")
	    @Consumes("application/json")
	    public Usuario loging (@QueryParam("clave")String clave,@QueryParam("correo")String correo) {
	    	System.out.println("clave"+clave+"correo"+correo);
	    	return null;
	    }
	    /**
	     * Lista el estado de la cuenta que contenda las transacciones del usuario
	     * @param Id
	     * @return lista dela cuenta
	     */
	    @GET
	    @Path("listarEstado")
	    @Produces("application/json")
	    //@Consumes("application/json")
	    public List<Estado> listarSaldo(@QueryParam("clave")String clave) {

	    	try { 
	    		System.out.println("clave"+clave);
				listarEstado=clienteON.prueba();
				
				return listarEstado;
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return null;
			} 
	    }
	    //wxZpI
	    /**
	     * lista todas las polizas que tiene el usuario
	     * @param Id
	     * @return lista de usuario
	     */
	    @GET
	    @Path("listarPoliza")
	    @Produces("application/json")
	    public List<Poliza> listarPoliza(@QueryParam("clave")String clave) {
	    	try { 
	    		System.out.println("clave"+clave);
	    		listaPoliza=clienteON.PruebaPoliza();
				
				return listaPoliza;
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return null;
			} 
	    }
	  
	    /**
	     * metodo que se usarra para recuperrar la clave del usuario
	     * @param correo
	     * @return aprovacion o denegacion dela actualisacion
	     */
	    @GET
		@Path("recuperar")
	    @Produces("application/json")
	    @Consumes("application/json")
		public Mensaje recuperarclave(@QueryParam("correo")String correo) {
	    	Mensaje m = new Mensaje();
			try {
				System.out.println("correo"+correo);
				//desbloquear 
				//clienteON.recuperacion(correo);
				m.setCode("ok");
				m.setMessage("Actualizado");
				return m;
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				m.setCode("ERROR");
				m.setMessage(e.getMessage());
				return m;
			}
			}

		public List<Estado> getListarEstado() {
			return listarEstado;
		}

		public void setListarEstado(List<Estado> listarEstado) {
			this.listarEstado = listarEstado;
		}

		
	    
}
