package Proyecto.BancoPrctica.Navegacion.Beans;


import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

@Named
@SessionScoped
public class NavegacionAsistente implements Serializable {

	/**
	* 
	*/
	private static final long serialVersionUID = 1L;

	public String Listar() {
		return "AsitentePolizaListar.xhtml";
	}

	
}