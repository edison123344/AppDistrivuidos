package Proyecto.BancoPrectica.Negocio;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.ejb.Stateless;
import javax.inject.Inject;

import Proyecto.BancoPractica.Modelo.RegistroCliente;
import Proyecto.BancoPractica.Modelo.Usuario;
import Proyecto.BancoPractica.Services.Correo;
import Proyecto.BancoPrectica.DAO.RegistroClienteDAO;
import Proyecto.BancoPrectica.DAO.UsuarioDAO;


@Stateless
public class GestionLoginON {

		@Inject
		private UsuarioDAO usuarioDAO;
		@Inject
		private RegistroClienteDAO registroDAO;
		@Inject
		private Correo correo;
		
	public Usuario login(String email ,String password) throws Exception {

		Usuario usuario = new Usuario();
		usuario=usuarioDAO.listaUsuario(email,password);
		if(usuario!=null) {
		   return usuario;
		}else {
			
		return null;
		
		}
	}
	public Usuario comprobarEmail(String email ) throws Exception {

		Usuario usuario = new Usuario();
		usuario=usuarioDAO.listaUsuarioEmail(email);
		if(usuario!=null) {
		   return usuario;
		}else {
			
		return null;
		
		}
	}
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
	
	public Date fechaActual() throws ParseException {
		Date date = new Date();
	    SimpleDateFormat formato = new SimpleDateFormat("HH:mm:ss dd/MM/yyyy");
		String fechaString = formato.format(date); 
		Date miFecha = formato.parse(fechaString); 
		return miFecha;
	}
	
}
