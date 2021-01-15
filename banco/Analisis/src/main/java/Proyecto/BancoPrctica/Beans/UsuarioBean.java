package Proyecto.BancoPrctica.Beans;
import java.io.Serializable;
import java.util.List;
import java.util.Date;

//import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;


@Named
@SessionScoped
public class UsuarioBean implements Serializable{ 
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	private String Nombre;
	private String numcuenta;
	private Date fechaInicio;
	private Date fechaTransaccion;
	private String tipo;
	private int id;

	public String getNombre() {
		return Nombre;
	}

	public void setNombre(String nombre) {
		Nombre = nombre;
	}

	public String getNumcuenta() {
		return numcuenta;
	}

	public void setNumcuenta(String numcuenta) {
		this.numcuenta = numcuenta;
	}

	public Date getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public Date getFechaTransaccion() {
		return fechaTransaccion;
	}

	public void setFechaTransaccion(Date fechaTransaccion) {
		this.fechaTransaccion = fechaTransaccion;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}


}