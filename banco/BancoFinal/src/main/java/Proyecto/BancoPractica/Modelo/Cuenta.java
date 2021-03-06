package Proyecto.BancoPractica.Modelo;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * 
 * @author edison
 *
 */
@Entity(name = "Cuenta")
@Table (name = "Cuenta")
public class Cuenta implements Serializable{
	
	/**
	 * formulario uzado para contener todo lo referente ala poliza ,dependiendo dela nesesidad del sistema
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = " id_cuenta")
	private String numCuenta;
	@Column(name = " Tipo_cuenta")
	private String tipoCuenta;
	@OneToOne
	@JoinColumn(name="`FK_cuenta_id`")
	private Usuario usuario;
	
	//@OneToMany()
	//@JoinColumn(name="estado")
	//private List<Estado> detalles;
	

	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	public String getNumCuenta() {
		return numCuenta;
	}
	public void setNumCuenta(String numCuenta) {
		this.numCuenta = numCuenta;
	}
    //public List<Estado> getDetalles() {
	//	return detalles;
	//}
	//public void setDetalles(List<Estado> detalles) {
	//	this.detalles = detalles;
	//}
	public String getTipoCuenta() {
		return tipoCuenta;
	}
	public void setTipoCuenta(String tipoCuenta) {
		this.tipoCuenta = tipoCuenta;
	}
	@Override
	public String toString() {
		return "Cuenta [numCuenta=" + numCuenta + ", tipoCuenta=" + tipoCuenta + ", usuario=" + usuario + "]";
	}

}