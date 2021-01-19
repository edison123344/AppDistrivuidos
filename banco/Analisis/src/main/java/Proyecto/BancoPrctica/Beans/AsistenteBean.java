package Proyecto.BancoPrctica.Beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import Proyecto.BancoPractica.Modelo.Poliza;
import Proyecto.BancoPrectica.Negocio.GestionAsistenteON;

@Named
@SessionScoped
public class AsistenteBean implements Serializable {

	/**
	* 
	*/
	private static final long serialVersionUID = 1L;
	@Inject
	private GestionAsistenteON asistenteON;
	private Poliza polisa;
	private List<Poliza> listaPolizas;
	
	private long idPoliza;//recolector
	
	@PostConstruct
	public void init()  {
		ListarPoliza();
		polisa =new Poliza();
		listaPolizas=asistenteON.ListarPoliza();
	}

public String ListarPoliza()  {
	listaPolizas=asistenteON.ListarPoliza();
	return "AsitentePolizaListar";
}

public List<Poliza> getListaPolizas() {
	return listaPolizas;
}

public void setListaPolizas(List<Poliza> listaPolizas) {
	this.listaPolizas = listaPolizas;
}

public long getIdPoliza() {
	return idPoliza;
}

public void setIdPoliza(long idPoliza) {
	this.idPoliza = idPoliza;
}

public Poliza getPolisa() {
	return polisa;
}

public void setPolisa(Poliza polisa) {
	this.polisa = polisa;
}
public String GuardarActualisacion() throws Exception {

	asistenteON.actulisar(polisa);
	return "AsitentePolizaListar";
}
public String editar(long idPoliza ) {
	return "AsistenteAprobacion?faces-redirect=true&idPoliza="+idPoliza;
}
public String cargarDatosEditar() throws Exception {
	if(idPoliza!=0) {
		polisa=asistenteON.buscar(idPoliza);
	}
	return "";
}
}
