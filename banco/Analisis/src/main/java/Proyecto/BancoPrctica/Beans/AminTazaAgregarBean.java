package Proyecto.BancoPrctica.Beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import Proyecto.BancoPractica.Modelo.Taza;
import Proyecto.BancoPractica.Modelo.Usuario;
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
	private double datosTaza;
	private int desde;
	private int hasta;
	private List<Taza> listataza;
	/*@PostConstruct
	public void init()  {
		//listataza = new ArrayList<Taza>();
		try {
			listar();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}*/

	public List<Taza> getListataza() {
		return listataza;
	}

	public void setListataza(List<Taza> listataza) {
		this.listataza = listataza;
	}

	public double getDatosTaza() {
		return datosTaza;
	}

	public void setDatosTaza(double datosTaza) {
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
	   Taza taza =new Taza();
		taza.setPorsentaje(datosTaza);
		taza.setDesde(desde);
		taza.setHasta(hasta);
		System.out.println(taza.toString());
		this.adminON.crearTaza(taza);
		
		return"AgregarTazaAdmin.xhtml";
	}
	
	public String Eliminar(int id ) throws Exception {
		adminON.borrar(id);
		listataza = new ArrayList<Taza>();
		listar();
		return "TazaAdministrador";
	}
	public String listar() throws Exception {
		listataza=adminON.listarTaza();
		
	return "TazaAdministrador";
}	
}
