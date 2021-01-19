package Proyecto.BancoPrctica.Beans;
import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import Proyecto.BancoPractica.Modelo.Estado;
import Proyecto.BancoPractica.Modelo.Poliza;
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
	
	private List<Poliza> listaPolizas;
	private List<Estado> listarEstado;
	//@PostConstruct
	//public void init()  {
		//ListarEstadoCuenta();
	//}
	public List<Poliza> getListaPolizas() {
		return listaPolizas;
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
	
	public String ListarEstadoCuenta()  {
		listarEstado=clienteON.listaTransacciones();
				System.out.println("lista");
	
		return "Usuario";
	}
}