package ups.edu.Banco.Modelo;

import java.io.Serializable;
import java.sql.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;


@Entity(name = "Retiro")
public class Retiro implements Serializable {
	/**
		 * 
		 */
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name = "idRetiro")
	private int idRetiro;
	@Column(name = "tipoTransaccion")
	private String tipo;
	@Column(name = "fechaRetito")
	private Date fechaRetiro;
	@Column(name = "numeroCuenta")
	private Estado estado;
	@Column(name = "retiroMonto")
	private String monto;

	public int getIdRetiro() {
		return idRetiro;
	}

	public void setIdRetiro(int idRetiro) {
		this.idRetiro = idRetiro;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public Date getFechaRetiro() {
		return fechaRetiro;
	}

	public void setFechaRetiro(Date fechaRetiro) {
		this.fechaRetiro = fechaRetiro;
	}

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}

	public String getMonto() {
		return monto;
	}

	public void setMonto(String monto) {
		this.monto = monto;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "Retiro [idRetiro=" + idRetiro + ", tipo=" + tipo + ", fechaRetiro=" + fechaRetiro + ", estado=" + estado
				+ ", monto=" + monto + ", getIdRetiro()=" + getIdRetiro() + ", getTipo()=" + getTipo()
				+ ", getFechaRetiro()=" + getFechaRetiro() + ", getEstado()=" + getEstado() + ", getMonto()="
				+ getMonto() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()="
				+ super.toString() + "]";
	}

}
