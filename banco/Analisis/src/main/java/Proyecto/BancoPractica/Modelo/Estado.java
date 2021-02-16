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
/**
 * 
 * @author edison
 *
 */

@Entity(name = "Estado")
public class Estado implements Serializable {

	/**
	 * clase que almasenara temporal mente el formuralio de todo lo referente ala cuenta del usuario i sera requerido segun el requerimiento del sistema
	 */
	private static final long serialVersionUID = 1L;
    @Id
	@GeneratedValue(strategy= GenerationType.AUTO) 
    private int idEstado;
	private Double Saldo;
	@Column(name = "mt_retiro")
    private Double retiro;
	@Column(name = "mt_deposito")
	private Double deposito;
	@Column(name = "tipo")
	private String Tipo;
	@OneToOne
	@JoinColumn(name="PK_cuenta")
	private Cuenta cuenta;
	@Column(name = "registro")
	private Date Fecha;
	
	
	public Cuenta getCuenta() {
		return cuenta;
	}
	public void setCuenta(Cuenta cuenta) {
		this.cuenta = cuenta;
	}
	public Date getFecha() {
		return Fecha;
	}
	public void setFecha(Date fecha) {
		Fecha = fecha;
	}

	public Double getSaldo() {
		return Saldo;
	}
	public void setSaldo(Double saldo) {
		Saldo = saldo;
	}
	public Double getRetiro() {
		return retiro;
	}
	public void setRetiro(Double retiro) {
		this.retiro = retiro;
	}
	public Double getDeposito() {
		return deposito;
	}
	public void setDeposito(Double deposito) {
		this.deposito = deposito;
	}
	public String getTipo() {
		return Tipo;
	}
	public void setTipo(String tipo) {
		Tipo = tipo;
	}
    public int getIdEstado() {
		return idEstado;
	}
	public void setIdEstado(int idEstado) {
		this.idEstado = idEstado;
	}
	@Override
	public String toString() {
		return "Estado [idEstado=" + idEstado + ", Saldo=" + Saldo + ", retiro=" + retiro + ", deposito=" + deposito
				+ ", Tipo=" + Tipo + ", cuenta=" + cuenta + ", Fecha=" + Fecha + "]";
	}

}