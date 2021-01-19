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


@Entity(name = "Estado")
public class Estado implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
    @Id
	@GeneratedValue(strategy= GenerationType.AUTO) 
    private int idEstado;
	private int Saldo;
	@Column(name = "mt_retiro")
    private int retiro;
	@Column(name = "mt_deposito")
	private int deposito;
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

	public int getSaldo() {
		return Saldo;
	}
	public void setSaldo(int saldo) {
		Saldo = saldo;
	}
	public int getRetiro() {
		return retiro;
	}
	public void setRetiro(int retiro) {
		this.retiro = retiro;
	}
	public int getDeposito() {
		return deposito;
	}
	public void setDeposito(int deposito) {
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

}