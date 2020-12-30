package Proyecto.BancoPrectica.Negocio;

import javax.ejb.Stateless;
import javax.inject.Inject;

import Proyecto.BancoPractica.Modelo.Usuario;
import Proyecto.BancoPrectica.DAO.UsuarioDAO;

@Stateless
public class LoginON {
	@Inject
	private UsuarioDAO usuario;
	
public Usuario login(String email ,String password) throws Exception {
	
	 if(usuario.loginUsuario(email, password)!=null)
	   return usuario.loginUsuario(email, password);
	 return null;
}
public Usuario registroIngreso() {
	return null;
}
}
