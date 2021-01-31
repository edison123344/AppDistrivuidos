package Proyecto.BancoPrctica.Beans;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import Proyecto.BancoPractica.Modelo.Cuenta;
import Proyecto.BancoPractica.Modelo.Estado;
import Proyecto.BancoPractica.Modelo.Persona;
import Proyecto.BancoPractica.Modelo.RegistroCliente;
import Proyecto.BancoPractica.Modelo.Usuario;
import Proyecto.BancoPrectica.Negocio.GestionCajeroON;

@Named
@SessionScoped
public class CajeroBean  implements Serializable {

	/**
	* 
	*/
	private static final long serialVersionUID = 1L;
	@Inject
	private GestionCajeroON cajeroON;
	
	private Cuenta cuenta;
	private Estado estado;
	private Persona persona;
	private Usuario usuario;
	private RegistroCliente registro;
	/**Bean properties*/
	private String NumeroCuenta;
	private String monto;
	private String nombre;
	private String mail;
	private String telefono;
	private String cedula;
	private String password;
	private String tipo;
	private Date Fecha;
	
	
	@PostConstruct
	public void init() {
		cuenta = new Cuenta();
		estado =new Estado();
		persona = new Persona();
		usuario = new Usuario();
		registro = new RegistroCliente();
	}
	
	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
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

	public String getCedula() {
		return cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
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

	public Date getFecha() {
		return Fecha;
	}
	public void setFecha(Date fecha) {
		Fecha = fecha;
	}
	public Cuenta getCuenta() {
		return cuenta;
	}
	public void setCuenta(Cuenta cuenta) {
		this.cuenta = cuenta;
	}
	public String getNumeroCuenta() {
		return NumeroCuenta;
	}
	public void setNumeroCuenta(String numeroCuenta) {
		NumeroCuenta = numeroCuenta;
	}
	public String getMonto() {
		return monto;
	}
	public void setMonto(String monto) {
		this.monto = monto;
	}
	
	public String Depositar() throws Exception {
		cuenta.setNumCuenta(getNumeroCuenta());
		estado.setCuenta(cuenta);
		estado.setFecha(fechaActual());
		estado.setDeposito(Integer.parseInt(getMonto()));
		estado.setTipo("Deposito");
	    cajeroON.Depocito(estado);
		return "cajero";
	}
	public Date fechaActual() throws ParseException {
		Date date = new Date();
	    SimpleDateFormat formato = new SimpleDateFormat("HH:mm:ss dd/MM/yyyy");
		String fechaString = formato.format(date); 
		Date miFecha = formato.parse(fechaString); 
		return miFecha;
	}
	public String Retirar() throws Exception {
		cuenta.setNumCuenta(getNumeroCuenta());
		estado.setCuenta(cuenta);
		estado.setFecha(fechaActual());
		estado.setRetiro(Integer.parseInt(getMonto()));
		estado.setTipo("Retiro");
	    cajeroON.Retiro(estado);
		return "cajero";
	}
	public String ingresarRol() throws Exception {
		persona.setIdCedula(Integer.parseInt(cedula));
		persona.setCorreo(getMail());
		persona.setNombre(getNombre());
		persona.setTelefono(getTelefono());
		cajeroON.crearRolPersona(persona);
		return "CajeroCuenta";
	}
	public String crearCuenta() throws Exception {
			ingresarRol();
			usuario.setPassword(aleatorios());
		    usuario.setTipoUsuario("Usuario");
		    usuario.setEstado("Activo");				    
			persona.setIdCedula(cajeroON.Busqueda(Integer.parseInt(cedula)).getIdCedula());
			usuario.setPersona(persona);
			cajeroON.crearRol(usuario);
			cuenta.setUsuario(usuario);
			cuenta.setNumCuenta(cedula+aleatorios());		
			cuenta.setTipoCuenta(tipo);
			cajeroON.Crear(cuenta);
		    registro.setFecha(fechaActual());
		    registro.setTpo("Activo");
		    registro.setUsuario(usuario);
		    cajeroON.crearhistorialPersona(registro);
		return "CajeroCuenta";
	}
	//pasar metodo al paquete negosio  para la contrasena
	
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
