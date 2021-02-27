package clienteBeans;

import java.io.IOException;
import java.util.List;

import javax.ejb.Stateless;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import com.google.gson.Gson;
import com.sun.org.apache.xerces.internal.impl.xpath.regex.ParseException;

import clienteModelo.Libro;
import clienteON.HttpConeccion;



@Named
@Stateless
public class clienteBibliotecaBeans {
	private List<Libro> datos;
	private String reserva;
	private List<Libro> datoCategoria;
	private String categoria;
	

	public List<Libro> getDatoCategoria() {
		return datoCategoria;
	}

	public void setDatoCategoria(List<Libro> datoCategoria) {
		this.datoCategoria = datoCategoria;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	

	public List<Libro> getDatos() {
		return datos;
	}

	public void setDatos(List<Libro> datos) {
		this.datos = datos;
	}

	public String getReserva() {
		return reserva;
	}

	public void setReserva(String reserva) {
		this.reserva = reserva;
	}
	public String reservarCategorioa() throws IOException, org.json.simple.parser.ParseException {
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
