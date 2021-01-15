package Proyecto.BancoPractica.Modelo;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity(name = "Usuario")
@Table ( name  =  "Usuario" )
public class Usuario implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "user_id")
	@GeneratedValue(strategy= GenerationType.AUTO) 
	private int idUsuario;
	private String password;
	
	@Column(name = "tipo")
	private String tipoUsuario;
	
	@Column(name = "fecha_Ingreso")
	private Date fechaHistorial;

	@OneToOne
	@JoinColumn(name="`FK_per_idCedula`")
	private Persona persona;

	public Persona getPersona() {
		return persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}

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

	public Date getFechaHistorial() {
		return fechaHistorial;
	}

	public void setFechaHistorial(Date fechaHistorial) {
		this.fechaHistorial = fechaHistorial;
	}

}
