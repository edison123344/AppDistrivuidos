package Proyecto.BancoPrectica.Negocio;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.ejb.Stateless;
import javax.inject.Inject;

import Proyecto.BancoPractica.Modelo.RegistroCliente;
import Proyecto.BancoPractica.Modelo.Usuario;
import Proyecto.BancoPractica.Modelo.Poliza;
import Proyecto.BancoPractica.Services.Correo;
import Proyecto.BancoPrectica.DAO.PolizaDAO;
import Proyecto.BancoPrectica.DAO.RegistroClienteDAO;
import Proyecto.BancoPrectica.DAO.UsuarioDAO;
/**
 * 
 * @author edison
 *
 */

@Stateless
public class GestionLoginON {
/**
 * clase usada para la gestion de todo loque es login redireccionamiento de cuentas y recuperacion de cuenta entre otras opciones detalladas en la clase
 */
		@Inject
		private UsuarioDAO usuarioDAO;
		@Inject
		private RegistroClienteDAO registroDAO;
		@Inject
		private Correo correo;
		@Inject
		private PolizaDAO polizaDAO;
		/**
		 * metodo que verificara si existe el usuario solisitado
		 * @param email
		 * @param password
		 * @return usuario solisitado
		 * @throws Exception
		 */
	public Usuario login(String email ,String password) throws Exception {

		Usuario usuario = new Usuario();
		usuario=usuarioDAO.listaUsuario(email,password);
		if(usuario!=null) {
		   return usuario;
		}else {
			
		return null;
		
		}
	}
	/**
	 * metodo usado como una se gunda comprobasion de usuario
	 * @param email
	 * @return usuario
	 * @throws Exception
	 */
	public Usuario comprobarEmail(String email ) throws Exception {

		Usuario usuario = new Usuario();
		usuario=usuarioDAO.listaUsuarioEmail(email);
		actualisarPoliza();
		if(usuario!=null) {
		   return usuario;
		}else {
			
		return null;
		
		}
		
	}
	
	/**
	 * metodo que bloqueara al usuario si cometetres errores
	 * @param usuario
	 * @throws Exception
	 */
	public void blokeo(Usuario usuario) throws Exception {
	    usuarioDAO.actualizar(usuario);
		usuario.getPersona().getCorreo();
		RegistroCliente registroCiente =new RegistroCliente();
		registroCiente.setFecha(fechaActual());
        registroCiente.setTpo("bokeado");
        registroCiente.setUsuario(usuario);
        registroDAO.insertar(registroCiente);
		String Mensaje= "correo bloqueado";
		
		correo.correoGeneral(usuario.getPersona().getCorreo(), Mensaje);
	
	}
	/**
	 * metodo usado para la recuperacion de la clave y envio del la nueva clave al correo
	 * @param usuario
	 * @throws Exception
	 */
	public void recuperarClave(Usuario usuario) throws Exception {
		
	    usuarioDAO.actualizar(usuario);
	    usuario.getPersona().getCorreo();
		RegistroCliente registroCiente =new RegistroCliente();
		registroCiente.setFecha(fechaActual());
        registroCiente.setTpo("Activado");
        registroCiente.setUsuario(usuario);
        registroDAO.insertar(registroCiente);
		//String Mensaje= "correo Activado";
		
		//correo.correoGeneral(usuario.getPersona().getCorreo(), Mensaje);
	}
	/**
	 * imprime fecha actual del sistema 
	 * @return fecha actual
	 * @throws ParseException
	 */
	public Date fechaActual() throws ParseException {
		Date date = new Date();
	    SimpleDateFormat formato = new SimpleDateFormat("HH:mm:ss dd/MM/yyyy");
		String fechaString = formato.format(date); 
		Date miFecha = formato.parse(fechaString); 
		return miFecha;
	}
	/**
	 * metodo que buscara las polisas y las actualisara a caducada para luego ser depositadas en la cuenta del usuario
	 * @throws Exception 
	 */
	private void actualisarPoliza() throws Exception {
		// TODO Auto-generated method stub
		Poliza poliza =new Poliza();
		poliza=polizaDAO.listaPolizaDia(fechaActual());
		//Aprovado
		if(poliza!=null && poliza.getEstado().equals("Aprobado")) {
		poliza.setEstado("caducada");
		polizaDAO.actualizar(poliza);
			}
	}
}
