package Proyecto.BancoPractica.Modelo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity(name = "taza")
@Table(name = "taza ")
public class Taza implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name = "IdTaza")
	@GeneratedValue(strategy= GenerationType.AUTO) 
	private int IdTaza;
	private double porsentaje;
	private int desde;
	private int hasta;
	@OneToOne
	@JoinColumn(name="`FK_idUsuario`")
	private Usuario usuario ;
	

	public int getIdTaza() {
		return IdTaza;
	}
	public void setIdTaza(int idTaza) {
		IdTaza = idTaza;
	}
	
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	public double getPorsentaje() {
		return porsentaje;
	}
	public void setPorsentaje(double porsentaje) {
		this.porsentaje = porsentaje;
	}
	public int getDesde() {
		return desde;
	}
	public void setDesde(int desde) {
		this.desde = desde;
	}
	public int getHasta() {
		return hasta;
	}
	public void setHasta(int hasta) {
		this.hasta = hasta;
	}
	@Override
	public String toString() {
		return "Taza [IdTaza=" + IdTaza + ", porsentaje=" + porsentaje + ", desde=" + desde + ", hasta=" + hasta
				+ ", usuario=" + usuario + "]";
	}

	
}
