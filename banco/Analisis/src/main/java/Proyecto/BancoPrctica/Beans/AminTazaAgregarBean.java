package Proyecto.BancoPrctica.Beans;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import Proyecto.BancoPractica.Modelo.Taza;
import Proyecto.BancoPrectica.Negocio.GestionAdminON;

@Named
@SessionScoped
public class AminTazaAgregarBean implements Serializable {

	/**
	* 
	*/
	private static final long serialVersionUID = 1L;
	@Inject
	private GestionAdminON adminON;
	private Taza taza;
	private String idTaza;//parametro de identificacion
	private int datosTaza;
	private int desde;
	private int hasta;
	
	@PostConstruct
	public void init() {
		taza=new Taza();
	}

	public String getIdTaza() {
		return idTaza;
	}

	public void setIdTaza(String idTaza) {
		this.idTaza = idTaza;
	}

	public int getDatosTaza() {
		return datosTaza;
	}

	public void setDatosTaza(int datosTaza) {
		this.datosTaza = datosTaza;
	}

	public int getDesde() {
		return desde;
	}

	public void setDesde(int desde) {
		this.desde = desde;
	}

	public int getHasta() {
		return hasta;
	}

	public void setHasta(int hasta) {
		this.hasta = hasta;
	}
	public String IngresoTaza() throws Exception {
		taza.setPorsentaje(datosTaza);
		taza.setDesde(desde);
		taza.setHasta(hasta);			
		adminON.crearTaza(taza);
		
		return"AgregarTazaAdmin";
	}
	public String editar(String idTaza ) {
		
		return "AgregarTazaAdmin";
	}
	public String cargarDatos() {
		return null;
	}
}
