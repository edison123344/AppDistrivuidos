package Proyecto.BancoPrectica.Negocio;



import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import Proyecto.BancoPractica.Modelo.Cuenta;
import Proyecto.BancoPractica.Modelo.Estado;
import Proyecto.BancoPractica.Modelo.Persona;
import Proyecto.BancoPractica.Modelo.Usuario;
import Proyecto.BancoPractica.Services.Correo;
import Proyecto.BancoPrectica.DAO.CuentaDAO;
import Proyecto.BancoPrectica.DAO.EstadoDAO;
import Proyecto.BancoPrectica.DAO.PersonaDAO;
import Proyecto.BancoPrectica.DAO.UsuarioDAO;
////craptar los errores 
@Stateless
public class GestionCajeroON {
	
	@Inject
	private EstadoDAO estadoDAO;
	@Inject
	private CuentaDAO cuentaDAO;
	@Inject
	private PersonaDAO personaDAO;
	
	@Inject
	private UsuarioDAO usuarioDAO;
	@Inject
	private Correo correo;

	public boolean Depocito(Estado estado) throws Exception {
		return estadoDAO.insertar(estado);
	}
		
	public Cuenta BuscarCuenta(String num) throws Exception {
		return cuentaDAO.Buscar(num);
	}
	
	public boolean Retiro(Estado estado) throws Exception {
		return estadoDAO.insertar(estado);
	}
	public boolean crearRolPersona(Persona p) throws Exception {
		return personaDAO.insertar(p);
	}
	public boolean crearRol(Usuario usuario) throws Exception {
		 correo.correo(usuario);
		return usuarioDAO.insertar(usuario);
	}
	public List<Estado> listado() throws Exception {
		return estadoDAO.listar();
	}
	public Persona Busqueda(int idCedula) throws Exception {
		return personaDAO.buscar(idCedula);
	}
	//cabiar para que devuelva el error
	public boolean Crear(Cuenta cuenta) throws Exception {
		return cuentaDAO.Crearcuenta(cuenta);
	}
	
}
