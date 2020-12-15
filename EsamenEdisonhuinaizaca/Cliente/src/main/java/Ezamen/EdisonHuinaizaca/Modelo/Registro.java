package Ezamen.EdisonHuinaizaca.Modelo;

public class Registro {
private int id;
private String nomLibro;
private String editorial;
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
