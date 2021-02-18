package Proyecto.BancoPractica.Modelo;

import java.io.Serializable;
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
	@Column(name = "User_id")
	private int idUsuario;
	
	@Column(name = " persona_per_id")
	private Persona persona;
	
	@Column(name = "passwor")
	private String password;
	
	@Column(name = "tipo")
	private String tipoUsuario;
	
	//@Column(name = "fechaIngreso")
	//private Date fechaHistorial;


	public int getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String passwod) {
		this.password = passwod;
	}

	public String getTipoUsuario() {
		return tipoUsuario;
	}

	public void setTipoUsuario(String tipoUsuario) {
		this.tipoUsuario = tipoUsuario;
	}

/*	public Date getFechaHistorial() {
		return fechaHistorial;
	}

	public void setFechaHistorial(Date fechaHistorial) {
		this.fechaHistorial = fechaHistorial;
	}*/

	public Persona getPersona() {
		return persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}

}
