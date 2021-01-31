package Proyecto.BancoPrectica.Negocio;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.ejb.Stateless;
import javax.inject.Inject;

import Proyecto.BancoPractica.Modelo.Poliza;
import Proyecto.BancoPractica.Modelo.Taza;
import Proyecto.BancoPrectica.DAO.PolizaDAO;
import Proyecto.BancoPrectica.DAO.TazaDAO;

@Stateless
public class GestionPolizaON {
	@Inject
	private PolizaDAO polizaDAO;
	@Inject
	private TazaDAO tazaDAO;
	
	public double calculo;
	public Date fechaC;
	public double total;
public Poliza calcularPoliza(double monto, int dias) throws Exception {
	
	Poliza poliza = new Poliza();
	Taza taza =new Taza();
	taza=tazaDAO.TazaDato(dias);
	calculo=monto*(1/dias)*(taza.getPorsentaje()/100);
	fechaC= sumarDiasAFecha(fechaActual(), dias);
	total=monto+calculo;
	poliza.setEstado("PorAprovar");
	poliza.setMoto(monto);
	poliza.setTotal(total);
	poliza.setGanancia(calculo);
	poliza.setFechaVencimiento(fechaC);
	return poliza;
}
public void GuardarPoliza() {
	
}
public void ActualizarPoliza() {
	
}
public void listarPoliza() {
	
}

public  Date sumarDiasAFecha(Date fecha, int dias){
      if (dias==0) return fecha;
      Calendar calendar = Calendar.getInstance();
      calendar.setTime(fecha); 
      calendar.add(Calendar.DAY_OF_YEAR, dias);  
      return calendar.getTime(); 
}
public  Date fechaActual() throws ParseException {
	Date date = new Date();
    SimpleDateFormat formato = new SimpleDateFormat("HH:mm:ss dd/MM/yyyy");
	String fechaString = formato.format(date); 
	Date miFecha = formato.parse(fechaString); 
	return miFecha;

}
}