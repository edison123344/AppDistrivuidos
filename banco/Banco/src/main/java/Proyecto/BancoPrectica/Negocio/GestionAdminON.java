package Proyecto.BancoPrectica.Negocio;

import javax.ejb.Stateless;
import javax.inject.Inject;
import Proyecto.BancoPractica.Modelo.Administrador;
import Proyecto.BancoPractica.Modelo.Persona;
import Proyecto.BancoPractica.Modelo.Usuario;
import Proyecto.BancoPrectica.DAO.PersonaDAO;
import Proyecto.BancoPrectica.DAO.UsuarioDAO;
@Stateless
public class GestionAdminON {
	
	@Inject
	private UsuarioDAO usuario;
	@Inject
	private PersonaDAO persona;
	
public  Administrador TazaInters() {
	
	return null;
}
public boolean crearRolUsuario(Usuario usr) throws Exception {	
	return  usuario.inserta(usr);
}
public boolean crearRolPersona(Persona p) throws Exception {
return persona.insertar(p);
}
}
