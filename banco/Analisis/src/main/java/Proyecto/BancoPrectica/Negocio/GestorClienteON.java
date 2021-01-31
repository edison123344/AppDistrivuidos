package Proyecto.BancoPrectica.Negocio;

import java.util.Date;
//import java.util.Date;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

import Proyecto.BancoPractica.Modelo.Estado;
import Proyecto.BancoPractica.Modelo.Poliza;
import Proyecto.BancoPractica.Modelo.RegistroCliente;
import Proyecto.BancoPrectica.DAO.EstadoDAO;
import Proyecto.BancoPrectica.DAO.PolizaDAO;
import Proyecto.BancoPrectica.DAO.RegistroClienteDAO;


@Stateless
public class GestorClienteON {
	@Inject
	private EstadoDAO estado;
	@Inject
	private PolizaDAO polizaDAO;
	@Inject
	private RegistroClienteDAO registroClienteDAO;
	
	
	public List<RegistroCliente> listaHistorial(String clave){
		return registroClienteDAO.listarHistorial(clave);
	}
	////listar usuario pore terminar
	public List<Poliza> ListarPoliza(){
		return polizaDAO.listaPoliza();
	}
	public List<Estado> listaTransacciones(String clave) {
        return estado.listaEstado(clave); 
	}
	public List<Estado> listaPorFecha(String clave,Date desde,Date Hasta) {
        return estado.listaPorFecha(clave,desde, Hasta); 
	}
	
}