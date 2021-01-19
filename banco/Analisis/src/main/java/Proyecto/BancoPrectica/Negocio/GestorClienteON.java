package Proyecto.BancoPrectica.Negocio;

//import java.util.Date;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

import Proyecto.BancoPractica.Modelo.Estado;
import Proyecto.BancoPractica.Modelo.Poliza;
import Proyecto.BancoPrectica.DAO.EstadoDAO;
import Proyecto.BancoPrectica.DAO.PolizaDAO;


@Stateless
public class GestorClienteON {
	@Inject
	private EstadoDAO estado;
	@Inject
	private PolizaDAO polizaDAO;
	
	////listar usuario pore terminar
	public List<Poliza> ListarPoliza(){
		return polizaDAO.listaPoliza();
	}
	public List<Estado> listaTransacciones() {
        return estado.listaEstado(); 
	}
}