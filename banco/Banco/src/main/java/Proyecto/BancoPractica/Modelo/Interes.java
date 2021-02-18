package Proyecto.BancoPractica.Modelo;

import java.io.Serializable;
import java.sql.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;


@Entity(name = "Interes")
public class Interes implements Serializable {
	/**
		 * 
		 */
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name = "id")
	private int idInteres;
	
	@Column(name = "dias_fin")
	private Date DiaComienso;
	
	@Column(name = "dias_inicio")
	private Date DiaFin;
	
	@Column(name = "Taza_Interes")
	private double Taza;

	public int getIdInteres() {
		return idInteres;
	}

	public void setIdInteres(int idInteres) {
		this.idInteres = idInteres;
	}

	public Date getDiaComienso() {
		return DiaComienso;
	}

	public void setDiaComienso(Date diaComienso) {
		DiaComienso = diaComienso;
	}

	public Date getDiaFin() {
		return DiaFin;
	}

	public void setDiaFin(Date diaFin) {
		DiaFin = diaFin;
	}

	public double getTaza() {
		return Taza;
	}

	public void setTaza(double taza) {
		Taza = taza;
	}

	@Override
	public String toString() {
		return "Interes [idInteres=" + idInteres + ", DiaComienso=" + DiaComienso + ", DiaFin=" + DiaFin + ", Taza="
				+ Taza + ", getIdInteres()=" + getIdInteres() + ", getDiaComienso()=" + getDiaComienso()
				+ ", getDiaFin()=" + getDiaFin() + ", getTaza()=" + getTaza() + ", getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}

}
