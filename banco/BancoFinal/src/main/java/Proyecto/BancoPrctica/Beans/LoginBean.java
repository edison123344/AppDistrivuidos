package Proyecto.BancoPrctica.Beans;



import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
//import javax.faces.application.FacesMessage;
//import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
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
int n;
public String Logeo() throws Exception {
	this.usuario =loginON.comprobarEmail(email);
	n++;
	try {
		if(usuario == null) {
			FacesMessage msm = new FacesMessage(FacesMessage.SEVERITY_INFO,
					"Usuario incorecto","Usuario incorecto");
			FacesContext.getCurrentInstance().addMessage(null, msm);
		}
		if (n==3 && usuario != null) {
			FacesMessage msm = new FacesMessage(FacesMessage.SEVERITY_INFO,
					"Su cuenta a sido blokeada","Su cuenta a sido blokeada");
			FacesContext.getCurrentInstance().addMessage(null, msm);
			usuario.setEstado("boqueado");
			loginON.blokeo(usuario);
		}
		
	
		
	if (getEmail().equals(usuario.getPersona().getCorreo()) && getPassword().equals(usuario.getPassword())&&usuario.getEstado().equals("Activo")) {
		
		if (usuario.getTipoUsuario().equals("Usuario")) {
			System.out.println("Sysy"+usuario.getPersona().getCorreo()+"password"+usuario.getPassword()+usuario.getTipoUsuario());	
			return "Usuario.xhtml";
			
		} else if (usuario.getTipoUsuario().equals("Administrado")) {
			
			return "Administrador.xhtml";
			
		} else if (usuario.getTipoUsuario().equals("cajero")) {
			
			return "Cajero.xhtml";
		}
	}
	
	
	}catch(NullPointerException e) {
	FacesMessage msm = new FacesMessage(FacesMessage.SEVERITY_INFO,
			" contrasena inexistentes","contrasena inexistentes");
	FacesContext.getCurrentInstance().addMessage(null, msm);


	}
	
     return "";
	}

}
