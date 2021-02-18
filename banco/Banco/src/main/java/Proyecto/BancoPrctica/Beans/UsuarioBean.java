/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Proyecto.BancoPrctica.Beans;






import java.io.Serializable;
import java.util.List;
import java.util.Date;

//import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import Proyecto.BancoPractica.Modelo.Estado;
import Proyecto.BancoPrectica.Negocio.GestorClienteON;

@Named
@SessionScoped
//@RequestScoped
public class UsuarioBean implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/** Bean properties */
	private String Nombre;
	private String numcuenta;
	private List<Estado> listaEstados;
	private Date fechaInicio;
	private Date fechaTransaccion;
	private String tipo;
	private int id;
	@Inject
	private GestorClienteON clienteON;

	/**
	 * Método que retorna una lista de Estados
	 */
	public String cargarEstado() {
		setListaEstados(clienteON.listaTransacciones(1));
		return "Cliente";
	}

	public String getNombre() {
		return Nombre;
	}

	public void setNombre(String nombre) {
		Nombre = nombre;
	}

	public String getNumcuenta() {
		return numcuenta;
	}

	public void setNumcuenta(String numcuenta) {
		this.numcuenta = numcuenta;
	}

	public List<Estado> getListaEstados() {
		return listaEstados;
	}

	public void setListaEstados(List<Estado> listaEstados) {
		this.listaEstados = listaEstados;
	}

	public Date getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public Date getFechaTransaccion() {
		return fechaTransaccion;
	}

	public void setFechaTransaccion(Date fechaTransaccion) {
		this.fechaTransaccion = fechaTransaccion;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public GestorClienteON getClienteON() {
		return clienteON;
	}

	public void setClienteON(GestorClienteON clienteON) {
		this.clienteON = clienteON;
	}

}
