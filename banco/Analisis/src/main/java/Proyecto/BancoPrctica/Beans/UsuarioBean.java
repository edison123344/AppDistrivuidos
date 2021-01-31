package Proyecto.BancoPrctica.Beans;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import Proyecto.BancoPractica.Modelo.Estado;
import Proyecto.BancoPractica.Modelo.Poliza;
import Proyecto.BancoPractica.Modelo.RegistroCliente;
import Proyecto.BancoPrectica.Negocio.GestorClienteON;


@Named
@SessionScoped
public class UsuarioBean implements Serializable{ 
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Inject
	private GestorClienteON clienteON;
	private Date Desde;
	private Date Hasta;
	private List<Poliza> listaPolizas;
	private List<Estado> listarEstado;
	private List<RegistroCliente> ListarRegistroClientes;
	//@PostConstruct
	//public void init()  {
		
	//}
	
	public List<Poliza> getListaPolizas() {
		return listaPolizas;
	}
	public List<RegistroCliente> getListarRegistroClientes() {
		return ListarRegistroClientes;
	}
	public void setListarRegistroClientes(List<RegistroCliente> listarRegistroClientes) {
		ListarRegistroClientes = listarRegistroClientes;
	}
	public Date getDesde() {
		return Desde;
	}
	public void setDesde(Date desde) {
		Desde = desde;
	}
	public Date getHasta() {
		return Hasta;
	}
	public void setHasta(Date hasta) {
		Hasta = hasta;
	}
	public void setListaPolizas(List<Poliza> listaPolizas) {
		this.listaPolizas = listaPolizas;
	}
	public List<Estado> getListarEstado() {
		return listarEstado;
	}
	public void setListarEstado(List<Estado> listarEstado) {
		this.listarEstado = listarEstado;
	}
	public String ListarPoliza()  {
		listaPolizas=clienteON.ListarPoliza();
		return "";
	}
	public String ListarPorFecha(String id) {
		System.out.println("desde"+Desde);
		System.out.println("hasta"+Hasta);
		listarEstado=clienteON.listaPorFecha(id, Desde, Hasta);
		return"";
	}

	public String editar(String id ) {
		System.out.println(id);
		listarEstado=clienteON.listaTransacciones(id);
		System.out.println("lista");
		return "";
	} 
	public String listarHistorial(String id) {
		ListarRegistroClientes=clienteON.listaHistorial(id);
		return"";
	}

}