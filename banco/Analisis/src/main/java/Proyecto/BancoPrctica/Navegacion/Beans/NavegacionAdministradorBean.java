package Proyecto.BancoPrctica.Navegacion.Beans;


import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

@Named
@SessionScoped
public class NavegacionAdministradorBean implements Serializable {

	/**
	* 
	*/
	private static final long serialVersionUID = 1L;

	public String AgrearUsuario () {
		return "Administrador.xhtml";
	}
	public String AgrearTaza () {
		return "AgregarTazaAdmin.xhtml";
	}
	public String listarTaza() {
		return"TazaAdministrador.xhtml";
	}
}