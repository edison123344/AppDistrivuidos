package Proyecto.BancoPrectica.Negocio;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
//import java.util.Date;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

import Proyecto.BancoPractica.Modelo.Cuenta;
import Proyecto.BancoPractica.Modelo.Estado;
import Proyecto.BancoPractica.Modelo.Poliza;
import Proyecto.BancoPractica.Modelo.RegistroCliente;
import Proyecto.BancoPractica.Modelo.Transferencia;
import Proyecto.BancoPrectica.DAO.EstadoDAO;
import Proyecto.BancoPrectica.DAO.PolizaDAO;
import Proyecto.BancoPrectica.DAO.RegistroClienteDAO;
import Proyecto.BancoPrectica.DAO.TransferenciaDAO;
/**
 * clase que gestiona los prosesos que puede aser un cliente
 * @author edison
 *
 */

@Stateless
public class GestorClienteON {
	@Inject
	private EstadoDAO estadoDAO;
	@Inject
	private PolizaDAO polizaDAO;
	@Inject
	private RegistroClienteDAO registroClienteDAO;
	@Inject
	private TransferenciaDAO transDAO;
	/**
	 * lista el historial de ingreso del cliente 
	 * @param clave
	 * @return lista historial
	 */
	public List<RegistroCliente> listaHistorial(String clave){
		return registroClienteDAO.listarHistorial(clave);
	}
	////listar usuario pore terminar
	/**
	 * resibe la lista de polizas pertenesientes al cliente logeado
	 * @return lista polizas
	 */
	public List<Poliza> ListarPoliza(){
		return polizaDAO.listaPolizaCliente();
	}
	/**
	 * lista las transacciones segun la clave del usuario
	 * @param clave
	 * @return lista Estados
	 */
	public List<Estado> listaTransacciones(String clave) {
        return estadoDAO.listaEstado(clave); 
	}
	/***
	 * lista los estados segun que fecha se desea imprimir
	 * @param clave
	 * @param desde
	 * @param Hasta
	 * @return lista estados
	 */
	public List<Estado> listaPorFecha(String clave,Date desde,Date Hasta) {
        return estadoDAO.listaPorFecha(clave,desde, Hasta); 
	}
	/**
	 * seccion donde se ase la transferensia de las cuntas y se registra las fechas de transacciones
	 * @param trnsfer
	 * @return mesaje de alerta
	 * @throws Exception
	 */
	public String transferencia(Transferencia trnsfer) throws Exception {
		transDAO.transferir(trnsfer);
		Estado cuenta1 =new Estado();
		Estado cuenta2 =new Estado();

		Cuenta cuentaD =new Cuenta();
		Cuenta cuentaR =new Cuenta();
		if(trnsfer.getTipo().equals("Externo")){
			return"Sudeposito ala cuenta externa fue exitoso ";
		}else {
			cuenta1.setTipo(trnsfer.getTipo());
			cuenta1.setRetiro(trnsfer.getMonto());
			cuenta1.setFecha(fechaActual());
			cuentaR.setNumCuenta(trnsfer.getNumCuentaRT());
			cuenta1.setCuenta(cuentaR);
			boolean est = Retiro(cuenta1);
			if( est ==false) {
				return"Saldo insuficiente";
			}else {
				cuenta2.setTipo(trnsfer.getTipo());
				cuenta2.setDeposito(trnsfer.getMonto());
				cuenta2.setFecha(fechaActual());
				cuentaD.setNumCuenta(trnsfer.getNumCuentaDP());
				cuenta2.setCuenta(cuentaR);
			 return Depocito(cuenta2);
		}}
		
		
       
	}
	public String Depocito(Estado estado) throws Exception {
	     estadoDAO.insertar(CalcularDeposito( estado));	
		return "Deposito exitoso";
	}
		
	/**
	 * metod que calcula el deposito
	 * @param estado
	 * @return
	 * @throws Exception
	 */
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
	/**
	 * inserta los datos preprocesados en la base de datos
	 * @param estado
	 * @return true o false si exite algun error
	 * @throws Exception
	 */
	public boolean Retiro(Estado estado) throws Exception {
		return estadoDAO.insertar(CalcularRetiro( estado));

		 
	}
	/**
	 * metodo que calcula el retiro para las diferewntes cuentas sean externas o internas
	 * @param estado
	 * @return
	 * @throws Exception
	 */
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
	/**
	 * calcula la fecha actual 
	 * @return
	 * @throws ParseException
	 */
	public Date fechaActual() throws ParseException {
		Date date = new Date();
	    SimpleDateFormat formato = new SimpleDateFormat("HH:mm:ss dd/MM/yyyy");
		String fechaString = formato.format(date); 
		Date miFecha = formato.parse(fechaString); 
		return miFecha;
	}
	
	
}