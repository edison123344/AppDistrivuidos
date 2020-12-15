package Ezamen.EdisonHuinaizaca.Modelo;

public class Autor {
private int codigo;
private String nombre;
private String apellido;
public int getCodigo() {
	return codigo;
}
public void setCodigo(int codigo) {
	this.codigo = codigo;
}
public String getNombre() {
	return nombre;
}
public void setNombre(String nombre) {
	this.nombre = nombre;
}
public String getApellido() {
	return apellido;
}
public void setApellido(String apellido) {
	this.apellido = apellido;
}
@Override
public String toString() {
	return "Autor [codigo=" + codigo + ", nombre=" + nombre + ", apellido=" + apellido + ", getCodigo()=" + getCodigo()
			+ ", getNombre()=" + getNombre() + ", getApellido()=" + getApellido() + ", getClass()=" + getClass()
			+ ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
}


}
