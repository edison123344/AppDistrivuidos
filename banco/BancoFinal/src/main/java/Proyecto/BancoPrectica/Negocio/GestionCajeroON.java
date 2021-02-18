package Proyecto.BancoPrectica.Negocio;



import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import Proyecto.BancoPractica.Modelo.Cuenta;
import Proyecto.BancoPractica.Modelo.Estado;
import Proyecto.BancoPractica.Modelo.Persona;
import Proyecto.BancoPractica.Modelo.Poliza;
import Proyecto.BancoPractica.Modelo.RegistroCliente;
import Proyecto.BancoPractica.Modelo.Usuario;
import Proyecto.BancoPractica.Services.Correo;
import Proyecto.BancoPrectica.DAO.CuentaDAO;
import Proyecto.BancoPrectica.DAO.EstadoDAO;
import Proyecto.BancoPrectica.DAO.PersonaDAO;
import Proyecto.BancoPrectica.DAO.PolizaDAO;
import Proyecto.BancoPrectica.DAO.RegistroClienteDAO;
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
	@Inject
	private PolizaDAO polizaDAO;
	@Inject
	private RegistroClienteDAO regitroCienteDAO;
	
	public boolean Depocito(Estado estado) throws Exception {
		return estadoDAO.insertar(CalcularDeposito( estado));
	}
		
	
	public Estado CalcularDeposito(Estado estado) throws Exception {
		Estado anterior= new Estado();
		Estado actual= new Estado();

		anterior=estadoDAO.listarEstadoD(estado.getCuenta().getNumCuenta());
		if (anterior==null) {
			return estado;
		}else {
			actual.setSaldo(estado.getDeposito()+anterior.getSaldo());
			actual.setRetiro(estado.getRetiro());
			actual.setDeposito(estado.getDeposito());
			actual.setTipo(estado.getTipo());		
			actual.setCuenta(estado.getCuenta());
			actual.setFecha(estado.getFecha());
			return actual;
		}
	}
	public boolean Retiro(Estado estado) throws Exception {
		return estadoDAO.insertar(CalcularRetiro( estado));
	}
	public Estado CalcularRetiro(Estado estado) throws Exception {
		Estado anterior= new Estado();
		Estado actual= new Estado();
	
		anterior=estadoDAO.listarEstadoD(estado.getCuenta().getNumCuenta());
		if (anterior==null) {
			return estado;
		}else {
			actual.setSaldo(anterior.getSaldo()-estado.getRetiro());
			actual.setRetiro(estado.getRetiro());
			actual.setDeposito(estado.getDeposito());
			actual.setTipo(estado.getTipo());		
			actual.setCuenta(estado.getCuenta());
			actual.setFecha(estado.getFecha());
			return actual;
		}
	}
	public Cuenta BuscarCuenta(String num) throws Exception {
		return cuentaDAO.Buscar(num);
	}
	public boolean crearRolPersona(Persona p) throws Exception {
		return personaDAO.insertar(p);
	}
	/**
	 * enviar correo
	 * @param usuario
	 * @return
	 * @throws Exception
	 */
	public boolean crearRol(Usuario usuario) throws Exception {
		// correo.correo(usuario);
		return usuarioDAO.insertar(usuario);
	}

	public Persona Busqueda(int idCedula) throws Exception {
		return personaDAO.buscar(idCedula);
	}
	//cabiar para que devuelva el error
	public boolean Crear(Cuenta cuenta) throws Exception {
		return cuentaDAO.Crearcuenta(cuenta);
	}
	public boolean solisitudPoliza(Poliza poliza) throws Exception {
		return polizaDAO.insertar(poliza);
	}
	public boolean crearhistorialPersona(RegistroCliente p) throws Exception {
		return regitroCienteDAO.insertar(p);
	}
	
}
