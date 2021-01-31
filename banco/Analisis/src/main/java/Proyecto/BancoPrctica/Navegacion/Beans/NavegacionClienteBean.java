package Proyecto.BancoPrctica.Navegacion.Beans;


import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

@Named
@SessionScoped
public class NavegacionClienteBean implements Serializable {

	/**
	* 
	*/
	private static final long serialVersionUID = 1L;

	public String Listar() {
		return "Usuario.xhtml";
	}
public String recuperrar() {
	return "recuperacion.xhtml";
}
	public String login() {
		return"Login.xhtml";
	}
public String Historial() {
	return"HistorialUsuario'xhtml";
}
public String CrearPoliza() {
	return"Simulador.xhtml";
}
}