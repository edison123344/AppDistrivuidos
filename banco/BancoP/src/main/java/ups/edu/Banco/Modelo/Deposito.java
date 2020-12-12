package ups.edu.Banco.Modelo;

import java.io.Serializable;
import java.sql.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "Deposito")
public class Deposito implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name = "idDepocito")
	private int idDepocito;
	@Column(name = "fechaDepocito")
	private Date fechaDepocito;
	@Column(name = "cantidaDep")
	private double monto;
	@Column(name = "Saldo")
	private Estado estado;
	@Column(name = "DatoDep")
	private Persona persona;
	@Column(name = "tipoTransaccion")
	private String transaccion;
	@Column(name = "NumCuenta")
	private Usuario usuario;

	public int getIdDepocito() {
		return idDepocito;
	}

	public void setIdDepocito(int idDepocito) {
		this.idDepocito = idDepocito;
	}

	public Date getFechaDepocito() {
		return fechaDepocito;
	}

	public void setFechaDepocito(Date fechaDepocito) {
		this.fechaDepocito = fechaDepocito;
	}

	public double getMonto() {
		return monto;
	}

	public void setMonto(double monto) {
		this.monto = monto;
	}

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}

	public Persona getPersona() {
		return persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}

	public String getTransaccion() {
		return transaccion;
	}

	public void setTransaccion(String transaccion) {
		this.transaccion = transaccion;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "Deposito [idDepocito=" + idDepocito + ", fechaDepocito=" + fechaDepocito + ", monto=" + monto
				+ ", estado=" + estado + ", persona=" + persona + ", transaccion=" + transaccion + ", usuario="
				+ usuario + ", getIdDepocito()=" + getIdDepocito() + ", getFechaDepocito()=" + getFechaDepocito()
				+ ", getMonto()=" + getMonto() + ", getEstado()=" + getEstado() + ", getPersona()=" + getPersona()
				+ ", getTransaccion()=" + getTransaccion() + ", getUsuario()=" + getUsuario() + ", getClass()="
				+ getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}

}
