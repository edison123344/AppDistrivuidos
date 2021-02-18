package Proyecto.BancoPrectica.Negocio;

//import java.util.Date;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import Proyecto.BancoPractica.Modelo.Cuenta;
import Proyecto.BancoPractica.Modelo.Estado;
import Proyecto.BancoPrectica.DAO.EstadoDAO;

@Stateless
public class GestorClienteON {
	@Inject
	private EstadoDAO estado;

	public Cuenta controlRegistro() {
		return null;
	}
/*
	public List<Estado> obtenerTransaccionesCuenta(int idUsuario, Date fechaInicio, Date fechaFin) {

		return estado.getEstadoPorDia(idUsuario, fechaInicio, fechaFin);

	}*/

	public List<Estado> listaTransacciones(int idUsuario) {

		return estado.getEstado(idUsuario);

	}
}