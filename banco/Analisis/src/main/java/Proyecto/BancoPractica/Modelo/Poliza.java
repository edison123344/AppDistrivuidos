package Proyecto.BancoPractica.Modelo;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name = "poliza")
@Table(name = "poliza ")
public class Poliza implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long IdPoliza;
	private String moto;
	private String estado;
	private String plazo;
	private Date fechaVencimiento;
	public long getIdPoliza() {
		return IdPoliza;
	}
	public void setIdPoliza(long idPoliza) {
		IdPoliza = idPoliza;
	}
	public String getMoto() {
		return moto;
	}
	public void setMoto(String moto) {
		this.moto = moto;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public String getPlazo() {
		return plazo;
	}
	public void setPlazo(String plazo) {
		this.plazo = plazo;
	}
	
	public Date getFechaVencimiento() {
		return fechaVencimiento;
	}
	public void setFechaVencimiento(Date fechaVencimiento) {
		this.fechaVencimiento = fechaVencimiento;
	}
	@Override
	public String toString() {
		return "Poliza [IdPoliza=" + IdPoliza + ", moto=" + moto + ", estado=" + estado + ", plazo=" + plazo + "]";
	}


}
