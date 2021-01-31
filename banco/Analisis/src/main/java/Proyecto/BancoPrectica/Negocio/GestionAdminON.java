package Proyecto.BancoPrectica.Negocio;


import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import Proyecto.BancoPractica.Modelo.Persona;
import Proyecto.BancoPractica.Modelo.RegistroCliente;
import Proyecto.BancoPractica.Modelo.Taza;
import Proyecto.BancoPractica.Modelo.Usuario;
import Proyecto.BancoPrectica.DAO.PersonaDAO;
import Proyecto.BancoPrectica.DAO.RegistroClienteDAO;
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
	@Inject
	private RegistroClienteDAO regitroCienteDAO;

	public boolean crearRolPersona(Persona p) throws Exception {
		return personaDAO.insertar(p);
	}
	public boolean crearhistorialPersona(RegistroCliente p) throws Exception {
		return regitroCienteDAO.insertar(p);
	}

	public Persona Busqueda(int idCedula) throws Exception {
		return personaDAO.buscar(idCedula);
	}
	
	public boolean crearRol(Usuario usuario) throws Exception {
		return usuarioDAO.insertar(usuario);
	}
	public boolean borrar(int id) throws Exception {
		return tazaDAO.delite(id);
	}
	public void crearTaza(Taza taza) throws Exception {
	     tazaDAO.insertar(taza);
		
	}
	public List<Taza> listarTaza() throws Exception {

		return tazaDAO.listaTaza();

	}
}
