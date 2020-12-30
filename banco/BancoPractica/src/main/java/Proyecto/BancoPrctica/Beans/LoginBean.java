/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Proyecto.BancoPrctica.Beans;


import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import Proyecto.BancoPractica.Modelo.Usuario;
import Proyecto.BancoPrectica.Negocio.LoginON;



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
    private LoginON loginON;
  

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


	public LoginON getLoginON() {
		return loginON;
	}


	public void setLoginON(LoginON loginON) {
		this.loginON = loginON;
	}


public String BuscarUsuario() throws Exception {
	Usuario u= getLoginON().login(email, password);
	System.out.println("da"+u.getPassword());
	if(email.equals(u.getPersona().getCorreo())&& password.equals(u.getPassword())) {
		return "cliente";
	}
	FacesMessage msm = new FacesMessage(FacesMessage.SEVERITY_INFO,
			"usuario o contrasena inexistentes","usuario o contrasena inexistentes");
	FacesContext.getCurrentInstance().addMessage(null, msm);
	return null;
}
}
