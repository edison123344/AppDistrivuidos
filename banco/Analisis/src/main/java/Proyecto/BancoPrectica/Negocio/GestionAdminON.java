package Proyecto.BancoPrectica.Negocio;


import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import Proyecto.BancoPractica.Modelo.Persona;
import Proyecto.BancoPractica.Modelo.Taza;
import Proyecto.BancoPractica.Modelo.Usuario;
import Proyecto.BancoPrectica.DAO.PersonaDAO;
import Proyecto.BancoPrectica.DAO.TazaDAO;
import Proyecto.BancoPrectica.DAO.UsuarioDAO;

@Stateless
public class GestionAdminON {
	@Inject
	private PersonaDAO personaDAO;
	@Inject
	private UsuarioDAO usuarioDAO;
	@Inject
	private TazaDAO tazaDAO;

	public boolean crearRolPersona(Persona p) throws Exception {
		return personaDAO.insertar(p);
	}

	public Persona Busqueda(int idCedula) throws Exception {
		return personaDAO.buscar(idCedula);
	}
	
	public boolean crearRol(Usuario usuario) throws Exception {
		return usuarioDAO.insertar(usuario);
	}
	public boolean crearTaza(Taza taza) throws Exception {
		return tazaDAO.insertar(taza);
	}
	public List<Taza> listarTaza() throws Exception {

		return tazaDAO.listaTaza();

	}
}
