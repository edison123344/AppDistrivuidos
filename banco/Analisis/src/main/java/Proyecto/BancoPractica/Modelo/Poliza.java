package Proyecto.BancoPractica.Modelo;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
/**
 * 
 * @author edison
 *
 */
@Entity(name = "poliza")
@Table(name = "poliza ")
public class Poliza implements Serializable {
	/**
	 * clase que almasenara temporal mente los datos de la poliza y sera usada segun el requerimiento del sistema
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO) 
    private int idPoliza;
	private String estado;
	private Date fechaVencimiento;
    private Double moto;
	private Double Total;
	private Double Ganancia;
	private Usuario usuario;
	
	public String getEstado() {
		return estado;
	}
	public int getIdPoliza() {
		return idPoliza;
	}
	public void setIdPoliza(int idPoliza) {
		this.idPoliza = idPoliza;
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
	
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	@Override
	public String toString() {
		return "Poliza [IdPoliza=" + idPoliza + ", estado=" + estado + ", fechaVencimiento=" + fechaVencimiento
				+ ", moto=" + moto + ", Total=" + Total + ", Ganancia=" + Ganancia + "]";
	}



}
