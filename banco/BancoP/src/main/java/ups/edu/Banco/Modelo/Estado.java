package ups.edu.Banco.Modelo;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;


@Entity(name = "Estado")
public class Estado  implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name = "idEstado")
	private int idEstado;
	@Column(name = "tipoTrasaccion")
	private String tipoTrasaccion;
	@Column(name = "saldoActual")
	private double Saldo;
	@Column(name = "TipoRetiro")
	private Retiro retiro;
	@Column(name = "TipoDeposito")
	private Deposito deposito;
	public int getIdEstado() {
		return idEstado;
	}
	public void setIdEstado(int idEstado) {
		this.idEstado = idEstado;
	}
	public String getTipoTrasaccion() {
		return tipoTrasaccion;
	}
	public void setTipoTrasaccion(String tipoTrasaccion) {
		this.tipoTrasaccion = tipoTrasaccion;
	}
	public double getSaldo() {
		return Saldo;
	}
	public void setSaldo(double saldo) {
		Saldo = saldo;
	}
	public Retiro getRetiro() {
		return retiro;
	}
	public void setRetiro(Retiro retiro) {
		this.retiro = retiro;
	}
	public Deposito getDeposito() {
		return deposito;
	}
	public void setDeposito(Deposito deposito) {
		this.deposito = deposito;
	}
	@Override
	public String toString() {
		return "Estado [idEstado=" + idEstado + ", tipoTrasaccion=" + tipoTrasaccion + ", Saldo=" + Saldo + ", retiro="
				+ retiro + ", deposito=" + deposito + ", getIdEstado()=" + getIdEstado() + ", getTipoTrasaccion()="
				+ getTipoTrasaccion() + ", getSaldo()=" + getSaldo() + ", getRetiro()=" + getRetiro()
				+ ", getDeposito()=" + getDeposito() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ ", toString()=" + super.toString() + "]";
	}

}
