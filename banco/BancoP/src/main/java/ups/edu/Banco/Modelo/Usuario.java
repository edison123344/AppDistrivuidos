package ups.edu.Banco.Modelo;

import java.io.Serializable;
import java.sql.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;


@Entity(name = "Usuario")
public class Usuario implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name = "idUsuario")
	private int idUsuario;
	@Column(name = "claveUsuario")
	private String passwod;
	@Column(name = "rolUsuario")
	private String tipoUsuario;
	@Column(name = "fechaIngreso")
	private Date fechaHistorial;
	@Column(name = "DatooUsuario")
	private Persona persona;

	public int getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getPasswod() {
		return passwod;
	}

	public void setPasswod(String passwod) {
		this.passwod = passwod;
	}

	public String getTipoUsuario() {
		return tipoUsuario;
	}

	public void setTipoUsuario(String tipoUsuario) {
		this.tipoUsuario = tipoUsuario;
	}

	public Date getFechaHistorial() {
		return fechaHistorial;
	}

	public void setFechaHistorial(Date fechaHistorial) {
		this.fechaHistorial = fechaHistorial;
	}

	public Persona getPersona() {
		return persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}

	@Override
	public String toString() {
		return "Usuario [idUsuario=" + idUsuario + ", passwod=" + passwod + ", tipoUsuario=" + tipoUsuario
				+ ", fechaHistorial=" + fechaHistorial + ", persona=" + persona + ", getIdUsuario()=" + getIdUsuario()
				+ ", getPasswod()=" + getPasswod() + ", getTipoUsuario()=" + getTipoUsuario() + ", getFechaHistorial()="
				+ getFechaHistorial() + ", getPersona()=" + getPersona() + ", getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}

}
