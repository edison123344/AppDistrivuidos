package ups.edu.Banco.Modelo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;


@Entity(name = "Cuenta")
public class Cuenta implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@JoinColumn(name = "idCuenta")
	private int idCuenta;
	@JoinColumn(name = "cuenta")
	private String numCuenta;
	@JoinColumn(name = "infoUsuario")
	private Usuario usuario;
	@JoinColumn(name = "Estadocuenta")
	private Estado estado;
	public int getIdCuenta() {
		return idCuenta;
	}
	public void setIdCuenta(int idCuenta) {
		this.idCuenta = idCuenta;
	}
	public String getNumCuenta() {
		return numCuenta;
	}
	public void setNumCuenta(String numCuenta) {
		this.numCuenta = numCuenta;
	}
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	public Estado getEstado() {
		return estado;
	}
	public void setEstado(Estado estado) {
		this.estado = estado;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public String toString() {
		return "Cuenta [idCuenta=" + idCuenta + ", numCuenta=" + numCuenta + ", usuario=" + usuario + ", estado="
				+ estado + ", getIdCuenta()=" + getIdCuenta() + ", getNumCuenta()=" + getNumCuenta() + ", getUsuario()="
				+ getUsuario() + ", getEstado()=" + getEstado() + ", getClass()=" + getClass() + ", hashCode()="
				+ hashCode() + ", toString()=" + super.toString() + "]";
	}
	
}
