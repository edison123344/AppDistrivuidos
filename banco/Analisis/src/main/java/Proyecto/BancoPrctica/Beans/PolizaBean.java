package Proyecto.BancoPrctica.Beans;

import java.io.IOException;
import java.io.Serializable;
import java.util.List;

import javax.annotation.ManagedBean;
import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import org.apache.maven.shared.utils.io.IOUtil;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.UploadedFile;

import Proyecto.BancoPrectica.Negocio.GestionCajeroON;
import Proyecto.BancoPrectica.Negocio.GestionPolizaON;
import Proyecto.BancoPractica.Modelo.Poliza;
@Named
@SessionScoped
@ManagedBean

public class PolizaBean implements Serializable {

	/**
	* 
	*/
	private static final long serialVersionUID = 1L;
	@Inject
	private GestionPolizaON gestionPolizaON;
	private Poliza poliza;
	private double monto;
	private int plazo;
	private List<Poliza>listaPoliza;
	String archivo;
	byte[] contenido;
	public List<Poliza> getListaPoliza() {
		return listaPoliza;
	}

	public void setListaPoliza(List<Poliza> listaPoliza) {
		this.listaPoliza = listaPoliza;
	}

	public double getMonto() {
		return monto;
	}

	public void setMonto(double monto) {
		this.monto = monto;
	}

	public int getPlazo() {
		return plazo;
	}

	public void setPlazo(int plazo) {
		this.plazo = plazo;
	}


	public Poliza getPoliza() {
		return poliza;
	}

	public void setPoliza(Poliza poliza) {
		this.poliza = poliza;
	}

	public String simularpoliza() throws Exception {
		poliza=gestionPolizaON.calcularPoliza(monto, plazo);
		
		return"Simulador.xhtml";
	}
	public String Guardar(Poliza poliza) throws Exception {
		gestionPolizaON.GuardarPoliza(poliza);
		return"";
	}

}
