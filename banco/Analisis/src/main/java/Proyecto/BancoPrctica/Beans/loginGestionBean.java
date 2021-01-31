package Proyecto.BancoPrctica.Beans;

import java.io.Serializable;
import java.util.Random;

import javax.annotation.PostConstruct;
import javax.ejb.Stateless;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import Proyecto.BancoPractica.Modelo.Usuario;
import Proyecto.BancoPrectica.Negocio.GestionLoginON;
@Named
@Stateless
public class loginGestionBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String correo;
	private Usuario usuario;
	@Inject
	private GestionLoginON loginON;

	@PostConstruct
	public void init() {
		usuario = new Usuario();

	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String recuperacion() throws Exception {
		usuario = loginON.comprobarEmail(getCorreo());
		if(usuario == null) {
			FacesMessage msm = new FacesMessage(FacesMessage.SEVERITY_INFO,
					"Usuario incorecto","Usuario incorecto");
			FacesContext.getCurrentInstance().addMessage(null, msm);
		}
		if(usuario != null) {
			
		usuario.setEstado("Activo");
		usuario.setPassword(aleatorios());
	
		System.out.println("tipooooo"+usuario.getTipoUsuario());
		//loginON.recuperarClave(usuario);
		FacesMessage msm = new FacesMessage(FacesMessage.SEVERITY_INFO,
				"usuario recuperado su clave a sido enviada al correo","usuario recuperado su clave a sido enviada al correo");
		FacesContext.getCurrentInstance().addMessage(null, msm);
		}
		return "";
	}
	public String aleatorios() {	
		 String banco = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
		     Random rand = new Random();
		     StringBuilder buf = new StringBuilder();
		     for (int i=0; i<5; i++) {
		       buf.append(banco.charAt(rand.nextInt(banco.length())));
		     }
		     return buf.toString();	
	}
	
}
