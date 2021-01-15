package Proyecto.BancoPrectica.Negocio;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import Proyecto.BancoPractica.Modelo.Persona;
import Proyecto.BancoPractica.Modelo.Usuario;
import Proyecto.BancoPrectica.DAO.UsuarioDAO;


@Stateless
public class GestionLoginON {

		@Inject
		private UsuarioDAO usuario;
		
	public Usuario login(String email ,String password) throws Exception {	
		   return usuario.listaUsuario(email,password);
	}
	
	
}
