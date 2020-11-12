package es.ups.edu.UpsParqueadero.Modelo;

import java.sql.Date;

public class CierreDiaHora {
private int idCierre;
private Date Fecha;
private int hora;
private double total;
private int numeroVehiculo;

public int getIdCierre() {
	return idCierre;
}
public void setIdCierre(int idCierre) {
	this.idCierre = idCierre;
}
public Date getFecha() {
	return Fecha;
}
public void setFecha(Date fecha) {
	Fecha = fecha;
}
public int getHora() {
	return hora;
}
public void setHora(int hora) {
	this.hora = hora;
}
public double getTotal() {
	return total;
}
public void setTotal(double total) {
	this.total = total;
}
public int getNumeroVehiculo() {
	return numeroVehiculo;
}
public void setNumeroVehiculo(int numeroVehiculo) {
	this.numeroVehiculo = numeroVehiculo;
}


}
