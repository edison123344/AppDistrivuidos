package Proyecto.BancoPrectica.Negocio;

import java.sql.SQLException;
import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import Proyecto.BancoPractica.Modelo.Poliza;
import Proyecto.BancoPrectica.DAO.PolizaDAO;

@Stateless
public class GestionAsistenteON {
	@Inject
	private PolizaDAO polizaDAO;
	
	
	public List<Poliza> ListarPoliza(){
		return polizaDAO.listaPoliza();
	}
	public Poliza buscar(long id) throws Exception {
		return polizaDAO.buscar(id);
	}
	public void actulisar(Poliza poliza) throws Exception {
		try {
		if (buscar(poliza.getIdPoliza())==null) {
		System.out.println("Poliza Inexistente");
		}else {
			polizaDAO.actualizar(poliza);
		}
			
		}catch(SQLException e) {
			e.printStackTrace();
			throw new Exception("Error actualisar");
		}
	}
}
