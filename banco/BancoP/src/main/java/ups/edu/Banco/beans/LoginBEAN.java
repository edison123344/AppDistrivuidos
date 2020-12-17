/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ups.edu.Banco.beans;

import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;

import ups.edu.Banco.Modelo.Usuario;
import ups.edu.Banco.Negocio.LoginON;


public class LoginBEAN {

    private String email;
    private String password;
    Usuario usuario;
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
	 usuario=getLoginON().login(email, password);
	if(email.equals(usuario.getPersona().getCorreo())&& password.equals(usuario.getPasswod())) {
		
	}
	return "login";
}
}
