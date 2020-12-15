package Ezamen.EdisonHuinaizaca.ON;

import java.util.List;

import javax.ejb.Remote;

import Ezamen.EdisonHuinaizaca.Modelo.Registro;

@Remote
public interface registrroRemoto {
	public boolean registrar(Registro registro)throws Exception;
	public List<Registro> getConsulta();
}
