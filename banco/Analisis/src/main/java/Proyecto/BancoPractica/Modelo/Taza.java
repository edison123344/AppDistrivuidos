package Proyecto.BancoPractica.Modelo;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name = "taza")
@Table(name = "taza ")
public class Taza implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long IdTaza;
	private int porsentaje;
	private int desde;
	private int hasta;
	//@OneToOne
	//@JoinColumn(name="`FK_idUsuario`")
	//private Usuario usuario ;
	
	public int getDesde() {
		return desde;
	}
	public long getIdTaza() {
		return IdTaza;
	}
	public void setIdTaza(long idTaza) {
		IdTaza = idTaza;
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
	public int getPorsentaje() {
		return porsentaje;
	}
	public void setPorsentaje(int porsentaje) {
		this.porsentaje = porsentaje;
	}
	
}
