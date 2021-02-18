/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Proyecto.BancoPrctica.Beans;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.annotation.PostConstruct;
import Proyecto.BancoPractica.Modelo.Persona;
import Proyecto.BancoPractica.Modelo.RegistroCliente;

import Proyecto.BancoPractica.Modelo.Taza;
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
	private Persona persona;
	private Usuario usuario;
	
	/**Bean properties*/
	private String nombre;
	private String mail;
	private String telefono;
	private String cedula;
	private String password;
	private String tipo;
	private RegistroCliente registro;
	@PostConstruct
	public void init() {
		persona = new Persona();
		usuario = new Usuario();
		registro = new RegistroCliente();
	}

	
	public Usuario getUsuario() {
		return usuario;
	}
	public String getCedula() {
		return cedula;
	}
	public void setCedula(String cedula) {
		this.cedula = cedula;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	public String ingresarRol() throws Exception {
		persona.setIdCedula(Integer.parseInt(cedula));
		persona.setCorreo(getMail());
		persona.setNombre(getNombre());
		persona.setTelefono(getTelefono());
		adminON.crearRolPersona(persona);
		return "Administrador";
	}

	public String Ingresar() throws Exception {
		ingresarRol();
	    registro.setFecha(fechaActual());
	    registro.setTpo("creado cuenta");
	    registro.setUsuario(usuario);
	    adminON.crearhistorialPersona(registro);
		usuario.setPassword(password);
	    usuario.setTipoUsuario(tipo);
	    usuario.setEstado("Activo");
		persona.setIdCedula(adminON.Busqueda(Integer.parseInt(cedula)).getIdCedula());
		usuario.setPersona(persona);
		adminON.crearRol(usuario);
		return "Administrador";
	}
	public Date fechaActual() throws ParseException {
		Date date = new Date();
	    SimpleDateFormat formato = new SimpleDateFormat("HH:mm:ss dd/MM/yyyy");
		String fechaString = formato.format(date); 
		Date miFecha = formato.parse(fechaString); 
		return miFecha;
	}

}
