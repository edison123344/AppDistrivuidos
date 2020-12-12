package ups.edu.Banco.Modelo;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;


@Entity(name = "Cajero")
public class Cajero implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name = "id")
	private int idCajero;
	@Column(name = "controlReiro")
	private Retiro retiro;
	@Column(name = "controlDeposito")
	private Deposito Deposito;

	public int getIdCajero() {
		return idCajero;
	}

	public void setIdCajero(int idCajero) {
		this.idCajero = idCajero;
	}

	public Retiro getRetiro() {
		return retiro;
	}

	public void setRetiro(Retiro retiro) {
		this.retiro = retiro;
	}

	public Deposito getDeposito() {
		return Deposito;
	}

	public void setDeposito(Deposito deposito) {
		Deposito = deposito;
	}

	@Override
	public String toString() {
		return "Cajero [idCajero=" + idCajero + ", retiro=" + retiro + ", Deposito=" + Deposito + ", getIdCajero()="
				+ getIdCajero() + ", getRetiro()=" + getRetiro() + ", getDeposito()=" + getDeposito() + ", getClass()="
				+ getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}

}
