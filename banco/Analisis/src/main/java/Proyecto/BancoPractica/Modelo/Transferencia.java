package Proyecto.BancoPractica.Modelo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
/**
 * 
 * @author edison
 *
 */
@Entity(name = "Transferencia")
@Table ( name  =  "Transferencia " )
public class Transferencia implements Serializable {

	/**
	 * clase que sera usado como formulario de informacion y sera solisitada segun el sistema lo nesesite
	 */
	private static final long serialVersionUID = 1L;
    @Id
	@GeneratedValue(strategy= GenerationType.AUTO) 
    private int idTrans;
    @Column(name = "monto")
    private Double monto;
    private String numCuentaRT;
    private String numCuentaDP;
    private String tipo;
	public int getIdTrans() {
		return idTrans;
	}
	public void setIdTrans(int idTrans) {
		this.idTrans = idTrans;
	}
	public Double getMonto() {
		return monto;
	}
	public void setMonto(Double monto) {
		this.monto = monto;
	}
	public String getNumCuentaRT() {
		return numCuentaRT;
	}
	public void setNumCuentaRT(String numCuentaRT) {
		this.numCuentaRT = numCuentaRT;
	}
	public String getNumCuentaDP() {
		return numCuentaDP;
	}
	public void setNumCuentaDP(String numCuentaDP) {
		this.numCuentaDP = numCuentaDP;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	@Override
	public String toString() {
		return "Transferencia [idTrans=" + idTrans + ", monto=" + monto + ", numCuentaRT=" + numCuentaRT
				+ ", numCuentaDP=" + numCuentaDP + ", tipo=" + tipo + "]";
	}
	
}