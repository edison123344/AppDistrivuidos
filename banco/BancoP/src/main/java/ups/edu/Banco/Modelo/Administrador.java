package ups.edu.Banco.Modelo;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;


@Entity(name = "Administrador")
public class Administrador implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name = "idAdmininstrador")
	private int idAdmin;
	@Column(name = "modInteres")
	private Interes inters;
	@Column(name = "DatosAdmin")
	private Usuario usuario;
	@Column(name = "estadoAdmin")
	private String estado;

	public int getIdAdmin() {
		return idAdmin;
	}

	public void setIdAdmin(int idAdmin) {
		this.idAdmin = idAdmin;
	}

	public Interes getInters() {
		return inters;
	}

	public void setInters(Interes inters) {
		this.inters = inters;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	@Override
	public String toString() {
		return "Administrador [idAdmin=" + idAdmin + ", inters=" + inters + ", usuario=" + usuario + ", estado="
				+ estado + ", getIdAdmin()=" + getIdAdmin() + ", getInters()=" + getInters() + ", getUsuario()="
				+ getUsuario() + ", getEstado()=" + getEstado() + ", getClass()=" + getClass() + ", hashCode()="
				+ hashCode() + ", toString()=" + super.toString() + "]";
	}

}
