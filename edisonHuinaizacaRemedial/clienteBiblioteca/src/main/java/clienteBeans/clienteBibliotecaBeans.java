package clienteBeans;

import java.io.IOException;

import javax.ejb.Stateless;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import clienteModelo.Libro;
import clienteON.HttpConeccion;



@Named
@Stateless
public class clienteBibliotecaBeans {
	private String datos;
	private String reserva;
	private String datoCategoria;
	private String categoria;
	
	public String getDatoCategoria() {
		return datoCategoria;
	}

	public void setDatoCategoria(String datoCategoria) {
		this.datoCategoria = datoCategoria;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

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
	public String reservarCategorioa() throws IOException {
		datoCategoria=HttpConeccion.categoriaGET(categoria);
		return"";
	}
	
	public String reservar() throws IOException {
		Libro libro =new Libro();
		libro.setNombre(reserva);
		if (HttpConeccion.sendPOST(libro)!=null) {
		 FacesMessage msm = new FacesMessage(FacesMessage.SEVERITY_INFO,
					"Reserva exitosa","OK");
			FacesContext.getCurrentInstance().addMessage(null, msm);
		return"";
		}else {
			 FacesMessage msm = new FacesMessage(FacesMessage.SEVERITY_INFO,
						"error","error");
				FacesContext.getCurrentInstance().addMessage(null, msm);
			return "";
		}
	}

	public String lista() throws IOException {
		datos=HttpConeccion.sendGET();
		
		return"";
	}
}
