package Ezamen.EdisonHuinaizaca.ON;

import java.util.List;

import Ezamen.EdisonHuinaizaca.Modelo.Registro;

public interface RegistroRemoto {
	public boolean registrar(Registro registro)throws Exception;
	public List<Registro> getConsulta();
}
