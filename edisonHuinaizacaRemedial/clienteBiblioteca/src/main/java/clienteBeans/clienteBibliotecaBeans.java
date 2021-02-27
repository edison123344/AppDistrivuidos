package clienteBeans;

import java.io.IOException;

import javax.ejb.Stateless;
import javax.inject.Named;

import clienteModelo.Libro;
import clienteON.HttpConeccion;



@Named
@Stateless
public class clienteBibliotecaBeans {
	private String datos;
	private String reserva;
	
	public String getDatos() {
		return datos;
	}

	public void setDatos(String datos) {
		this.datos = datos;
	}

	public String getReserva() {
		return reserva;
	}

	public void setReserva(String reserva) {
		this.reserva = reserva;
	}
	public String reservar() throws IOException {
		Libro libro =new Libro();
		libro.setNombre(reserva);
		HttpConeccion.sendPOST(libro);
		return"";
	}

	public String lista() throws IOException {
		datos=HttpConeccion.sendGET();
		
		return"";
	}
}
