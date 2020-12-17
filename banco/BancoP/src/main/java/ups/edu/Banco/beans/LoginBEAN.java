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

import ups.edu.Banco.Negocio.LoginON;


public class LoginBEAN {

    private String cedula;
    private String password;

    @Inject
    private LoginON loginON;

    public LoginBEAN() {
    }

    @PostConstruct
    public void init() {
        cedula = "123";
        password= "0225";

    }
    /**
     * Permite guardar el login desde la vista, 
     * Consume la logica de los objetos de negocios.
     * @return
     */
    public String guardarLogin() {
		return cedula;
    

     
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

  

}
