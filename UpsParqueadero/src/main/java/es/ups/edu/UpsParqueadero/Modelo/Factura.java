package es.ups.edu.UpsParqueadero.Modelo;

import java.sql.Date;

public class Factura {
	private int numero;
	private Date fechEmicion;
	private Cliente Cliente;
	private double valorTotal;
	private Ticket Tiket;
	
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	public Date getFechEmicion() {
		return fechEmicion;
	}
	public void setFechEmicion(Date fechEmicion) {
		this.fechEmicion = fechEmicion;
	}
	public Cliente getCliente() {
		return Cliente;
	}
	public void setCliente(Cliente cliente) {
		Cliente = cliente;
	}
	public double getValorTotal() {
		return valorTotal;
	}
	public void setValorTotal(double valorTotal) {
		this.valorTotal = valorTotal;
	}
	public Ticket getTiket() {
		return Tiket;
	}
	public void setTiket(Ticket tiket) {
		Tiket = tiket;
	}

}
