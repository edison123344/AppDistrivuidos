package Ezamen.EdisonHuinaizaca.Modelo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity(name = "Registros")
public class Registro implements Serializable {
	/**
		 * 
		 */
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name="IdRgistr")
	private int id;
	@Column(name="nombre_Libro")
	private String nomLibro;
	@Column(name="editLibro")
	private String editorial;
	@OneToOne
	@Column(name="nombre")
	private Autor autor;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNomLibro() {
		return nomLibro;
	}

	public void setNomLibro(String nomLibro) {
		this.nomLibro = nomLibro;
	}

	public String getEditorial() {
		return editorial;
	}

	public void setEditorial(String editorial) {
		this.editorial = editorial;
	}

	public Autor getAutor() {
		return autor;
	}

	public void setAutor(Autor autor) {
		this.autor = autor;
	}

	@Override
	public String toString() {
		return "Registro [id=" + id + ", nomLibro=" + nomLibro + ", editorial=" + editorial + ", autor=" + autor
				+ ", getId()=" + getId() + ", getNomLibro()=" + getNomLibro() + ", getEditorial()=" + getEditorial()
				+ ", getAutor()=" + getAutor() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ ", toString()=" + super.toString() + "]";
	}

}
