package Proyecto.BancoPrctica.Beans;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import Proyecto.BancoPrectica.Negocio.GestionCajeroON;
import Proyecto.BancoPrectica.Negocio.GestionPolizaON;
import Proyecto.BancoPractica.Modelo.Poliza;
@Named
@SessionScoped
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


	public String simularpoliza() throws Exception {
		poliza=gestionPolizaON.calcularPoliza(monto, plazo);
		System.out.println(poliza.toString());
		return"Simulador.xhtml";
	}
	
}
