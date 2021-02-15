package Proyecto.BancoPractica.Modelo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name = "Transferencia")
@Table ( name  =  "Transferencia " )
public class Transferencia implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
    @Id
	@GeneratedValue(strategy= GenerationType.AUTO) 
    private int idTrans;
    @Column(name = "monto")
    private int monto;
    private String numCuentaRT;
    private String numCuentaDP;
    private String tipo;
	public int getIdTrans() {
		return idTrans;
	}
	public void setIdTrans(int idTrans) {
		this.idTrans = idTrans;
	}
	public int getMonto() {
		return monto;
	}
	public void setMonto(int monto) {
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
}