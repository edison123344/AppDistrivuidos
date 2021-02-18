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
	private List<Poliza>listaPoliza;
	private List<Estado> listarEstado;
	private List<RegistroCliente> ListarRegistroClientes;
	private String clave;
	@PostConstruct
	public void init()  {
		 ListarPorFecha(clave);
	}
	
	
	public List<RegistroCliente> getListarRegistroClientes() {
		return ListarRegistroClientes;
	}
	public List<Poliza> getListaPoliza() {
		return listaPoliza;
	}
	public void setListaPoliza(List<Poliza> listaPoliza) {
		this.listaPoliza = listaPoliza;
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
	
	public List<Estado> getListarEstado() {
		return listarEstado;
	}
	public void setListarEstado(List<Estado> listarEstado) {
		this.listarEstado = listarEstado;
	}
	public String ListarPoliza()  {
		//listaPoliza=clienteON.ListarPoliza();
		return "";
	}
	public String ListarPorFecha(String id) {
		System.out.println("desde"+Desde);
		System.out.println("hasta"+Hasta);
		listarEstado=clienteON.listaPorFecha(id, Desde, Hasta);
		return"";
	}

	public String editar(String id ) throws Exception {
		System.out.println(id);
		listarEstado=clienteON.listaTransacciones(id);
		listaPoliza=clienteON.ListarPoliza(id);
		System.out.println("lista");
		return "";
	} 
	public String listarHistorial(String id) {
		ListarRegistroClientes=clienteON.listaHistorial(id);
		return"";
	}

}