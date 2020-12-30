/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Proyecto.BancoPrctica.Beans;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.annotation.PostConstruct;
import Proyecto.BancoPractica.Modelo.Persona;
import Proyecto.BancoPractica.Modelo.Usuario;
import Proyecto.BancoPrectica.Negocio.GestionAdminON;


@Named
@SessionScoped
public class AdministradorBean implements Serializable {

	 /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Inject
	private GestionAdminON adminON;
	private Usuario usuario;
	private Persona persona;
	
	@PostConstruct
	public void init() {
		usuario = new Usuario();
		persona = new Persona();
	}
	
	public String ingresarUsuario() throws Exception {
	/*	usuario =new Usuario();
	
	 usuario.setIdUsuario(5);
	 usuario.setPassword("123");
	 persona.setId_Persona(2);
	 usuario.setTipoUsuario("cliente");
	 usuario.setPersona(persona);
	 System.out.println( adminON.crearRolUsuario(usuario));*/
	return  "Administrador";
	}
	
	public String ingresarPersona() throws Exception {
	 
        persona.setId_Persona(4);
		persona.setNombre("juan");
		persona.setCorreo("q1");
		persona.setTelefono("12131312");
		 System.out.println( adminON.crearRolPersona(persona));
		 
		return  "Administrador";
		}
}
