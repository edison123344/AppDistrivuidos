package Proyecto.BancoPractica.Modelo;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
/**
 * 
 * @author edison
 *
 */
@Entity(name = "RegistroCliente")
@Table ( name  =  "RegistroCliente" )
public class RegistroCliente implements Serializable {
	/**
	 * clase que almasenara todos los registros del usuario y sera usada segun el sistema lo requiera
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy= GenerationType.AUTO) 
private int idRegistro;
private Date fecha;
private String tpo;
@OneToOne
@JoinColumn(name="`FK_idUsuario`")
private Usuario usuario;
public int getIdRegistro() {
	return idRegistro;
}
public void setIdRegistro(int idRegistro) {
	this.idRegistro = idRegistro;
}
public Date getFecha() {
	return fecha;
}
public void setFecha(Date fecha) {
	this.fecha = fecha;
}
public String getTpo() {
	return tpo;
}
public void setTpo(String tpo) {
	this.tpo = tpo;
}
public Usuario getUsuario() {
	return usuario;
}
public void setUsuario(Usuario usuario) {
	this.usuario = usuario;
}

}
