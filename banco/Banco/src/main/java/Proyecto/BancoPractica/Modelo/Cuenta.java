package Proyecto.BancoPractica.Modelo;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import java.util.List;

@Entity(name = "cuenta")
public class Cuenta implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@JoinColumn(name = " idcuenta")
	private int idCuenta;
	@JoinColumn(name = "numerocuenta")
	private String numCuenta;
	@JoinColumn(name = " usuario_user_id")
	private Usuario usuario;
	@OneToMany
	@JoinColumn(name = "estado_idestado")
	private List<Estado> detalles;
	
	public List<Estado> getDetalles() {
		return detalles;
	}
	public void setDetalles(List<Estado> detalles) {
		this.detalles = detalles;
	}

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

	

}
