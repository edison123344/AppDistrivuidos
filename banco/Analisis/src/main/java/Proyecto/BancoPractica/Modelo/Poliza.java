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
	private String estado;
	private Date fechaVencimiento;
    private Double moto;
	private Double Total;
	private Double Ganancia;
	//private Usuario usuario;
	public long getIdPoliza() {
		return IdPoliza;
	}
	public void setIdPoliza(long idPoliza) {
		IdPoliza = idPoliza;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public Date getFechaVencimiento() {
		return fechaVencimiento;
	}
	public void setFechaVencimiento(Date fechaVencimiento) {
		this.fechaVencimiento = fechaVencimiento;
	}
	public Double getMoto() {
		return moto;
	}
	public void setMoto(Double moto) {
		this.moto = moto;
	}
	public Double getTotal() {
		return Total;
	}
	public void setTotal(Double total) {
		Total = total;
	}
	public Double getGanancia() {
		return Ganancia;
	}
	public void setGanancia(Double ganancia) {
		Ganancia = ganancia;
	}
	@Override
	public String toString() {
		return "Poliza [IdPoliza=" + IdPoliza + ", estado=" + estado + ", fechaVencimiento=" + fechaVencimiento
				+ ", moto=" + moto + ", Total=" + Total + ", Ganancia=" + Ganancia + "]";
	}



}
