package Proyecto.BancoPrctica.Navegacion.Beans;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

@Named
@SessionScoped
public class NavegacionCajeroBean implements Serializable {

	/**
	* 
	*/
	private static final long serialVersionUID = 1L;

	public String CrearCuenta() {
		return "CajeroCuenta.xhtml";
	}

	public String Retiro() {
		return "CajeroRetiro.xhtml";
	}

	public String Deposito() {
		return "CajeroDeposito.xhtml";
	}

}
