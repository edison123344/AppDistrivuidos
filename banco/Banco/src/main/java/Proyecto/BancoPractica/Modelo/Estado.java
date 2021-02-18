package Proyecto.BancoPractica.Modelo;

import java.io.Serializable;
import java.util.Date;

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
	@Column(name = "idestado")
	private int idEstado;
	@Column(name = "saldocuenta")
	private int Saldo;
	@Column(name = "monto_retiro")
	private int retiro;
	@Column(name = "monto_deposito")
	private int deposito;
	@Column(name = "tipo")
	private String Tipo;
	
	
	
	@Column(name = "registro")
	private Date Fecha;
	public Date getFecha() {
		return Fecha;
	}
	public void setFecha(Date fecha) {
		Fecha = fecha;
	}
	private Persona persona;
	
	public int getIdEstado() {
		return idEstado;
	}
	public void setIdEstado(int idEstado) {
		this.idEstado = idEstado;
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
	public Persona getPersona() {
		return persona;
	}
	public void setPersona(Persona persona) {
		this.persona = persona;
	}


}
