package Ezamen.EdisonHuinaizaca.ON;



import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import Ezamen.EdisonHuinaizaca.DAO.RegistroDAO;
import Ezamen.EdisonHuinaizaca.Modelo.Registro;
@Stateless
public class registrarON {
	@Inject
	private RegistroDAO reg;

	public boolean registrar(Registro registro)throws Exception{
		reg.inser(registro);
		return true;
}
	
	public List<Registro> getConsulta(){
		return 	reg.getRegistro();

	}

}
