package Proyecto.BancoPrctica.Beans;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import Proyecto.BancoPrectica.Negocio.GestionCajeroON;
import Proyecto.BancoPractica.Modelo.Poliza;
@Named
@SessionScoped
public class CajeroPolizaBean implements Serializable {

	/**
	* 
	*/
	private static final long serialVersionUID = 1L;
	@Inject
	private GestionCajeroON cajeroON;
	private Poliza poliza;
	
	private String monto;
	private String estado;
	private String plazo;
	
	@PostConstruct
	public void init() {
		poliza =new Poliza();
	
	}

	public String getMonto() {
		return monto;
	}

	public void setMonto(String monto) {
		this.monto = monto;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getPlazo() {
		return plazo;
	}

	public void setPlazo(String plazo) {
		this.plazo = plazo;
	}
	
	public String solisitarPoliza() throws Exception {
		poliza.setMoto(monto);
		poliza.setEstado(estado);
		poliza.setPlazo(plazo);
		cajeroON.solisitudPoliza(poliza); 
		return"CajeroPoliza";
	}
	
}
