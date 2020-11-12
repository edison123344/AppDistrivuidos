package es.ups.edu.UpsParqueadero.Modelo;

import java.sql.Date;

public class Ticket {
private int codigo;
private Date fecha_Ingreso;
private Date fecha_Salida;
private int tiempo;
private Vehiculo Vehiculo;

public int getCodigo() {
	return codigo;
}
public void setCodigo(int codigo) {
	this.codigo = codigo;
}
public Date getFecha_Ingreso() {
	return fecha_Ingreso;
}
public void setFecha_Ingreso(Date fecha_Ingreso) {
	this.fecha_Ingreso = fecha_Ingreso;
}
public Date getFecha_Salida() {
	return fecha_Salida;
}
public void setFecha_Salida(Date fecha_Salida) {
	this.fecha_Salida = fecha_Salida;
}
public int getTiempo() {
	return tiempo;
}
public void setTiempo(int tiempo) {
	this.tiempo = tiempo;
}
public Vehiculo getVehiculo() {
	return Vehiculo;
}
public void setVehiculo(Vehiculo vehiculo) {
	Vehiculo = vehiculo;
}


}
