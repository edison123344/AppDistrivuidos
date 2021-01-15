package Proyecto.BancoPrctica.Beans;



import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
//import javax.faces.application.FacesMessage;
//import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import Proyecto.BancoPractica.Modelo.Cuenta;
import Proyecto.BancoPractica.Modelo.Estado;
import Proyecto.BancoPractica.Modelo.Usuario;
import Proyecto.BancoPrectica.Negocio.GestionLoginON;





@Named
@SessionScoped
public class LoginBean implements Serializable{

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**Bean properties*/
	private String email;
    private String password;
    
    @Inject
    private GestionLoginON loginON;
    private Usuario usuario;
  
	@PostConstruct
	public void init() {
		usuario = new Usuario();
		
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}
    public GestionLoginON getLoginON() {
		return loginON;
	}


	public void setLoginON(GestionLoginON loginON) {
		this.loginON = loginON;
	}


public String Logeo() throws Exception {
	this.usuario =loginON.login(email, password);
	
	
	if (getEmail().equals(usuario.getPersona().getCorreo()) && getPassword().equals(usuario.getPassword())) {
		
		if (usuario.getTipoUsuario().equals("cliente")) {
			
			return "Usuario";
			
		} else if (usuario.getTipoUsuario().equals("Administrado")) {
			
			return "Administrador";
			
		} else if (usuario.getTipoUsuario().equals("cajero")) {
			
			return "Cajero";
		}
	}
	FacesMessage msm = new FacesMessage(FacesMessage.SEVERITY_INFO,
			"usuario o contrasena inexistentes","usuario o contrasena inexistentes");
	FacesContext.getCurrentInstance().addMessage(null, msm);
     return null;
}
}