package ups.edu.Banco.Modelo;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;


@Entity(name = "Persona")
public class Persona implements Serializable {
	/**
		 * 
		 */
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name = "IdPersona")
	private int id_Persona;
	@Column(name = "nombrePersona")
	private String nombre;
	@Column(name = "apellidoPersona")
	private String apellido;
	@Column(name = "NumTelefono")
	private String telefono;
	@Column(name = "direccionPersona")
	private String direccion;
	@Column(name = "correoPersona")
	private String correo;

	public int getId_Persona() {
		return id_Persona;
	}

	public void setId_Persona(int id_Persona) {
		this.id_Persona = id_Persona;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	@Override
	public String toString() {
		return "Persona [id_Persona=" + id_Persona + ", nombre=" + nombre + ", apellido=" + apellido + ", telefono="
				+ telefono + ", direccion=" + direccion + ", correo=" + correo + ", getId_Persona()=" + getId_Persona()
				+ ", getNombre()=" + getNombre() + ", getApellido()=" + getApellido() + ", getTelefono()="
				+ getTelefono() + ", getDireccion()=" + getDireccion() + ", getCorreo()=" + getCorreo()
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString()
				+ "]";
	}

}
