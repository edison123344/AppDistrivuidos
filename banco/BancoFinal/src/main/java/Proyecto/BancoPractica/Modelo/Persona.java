package Proyecto.BancoPractica.Modelo;


import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
/**
 * 
 * @author edison
 *
 */
@Entity(name = "`persona`")
@Table ( name  =  "Persona " )
public class Persona implements Serializable {
	/**
	 * clase que sera usado para guardar temporalmente los datos de la persona y sera usada segun el requerimiento del sistema
	 */
	private static final long serialVersionUID = 1L;
	@Id
	private int idCedula;
	@Column(name = "nombre")
	private String nombre;
	@Column(name = "telefono")
	private String telefono;
	@Column(name = "correo")
	private String correo;
	
	public int getIdCedula() {
		return idCedula;
	}

	public void setIdCedula(int idCedula) {
		this.idCedula = idCedula;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	@Override
	public String toString() {
		return "Persona [idCedula=" + idCedula + ", nombre=" + nombre + ", telefono=" + telefono + ", correo=" + correo
				+ "]";
	}


  
}