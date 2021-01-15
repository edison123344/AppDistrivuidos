package Proyecto.BancoPractica.Services;

import javax.inject.Inject;
import javax.jws.WebMethod;
import javax.jws.WebService;
import Proyecto.BancoPractica.Modelo.Cuenta;
import Proyecto.BancoPractica.Modelo.Estado;
import Proyecto.BancoPrectica.Negocio.GestionCajeroON;

@WebService
public class CuentaServicesSOAP {
	@Inject
	private GestionCajeroON cajeroON;
	
	@WebMethod
	public boolean Retirar(Estado estado) throws Exception {
		return cajeroON.Retiro(estado);
	}
	@WebMethod
	public boolean Deposita(Estado estado) throws Exception {
		return cajeroON.Depocito(estado);
	}
	@WebMethod
	public Cuenta BuscarCuenta(String cuenta) throws Exception {
		return cajeroON.BuscarCuenta(cuenta);
	}
	@WebMethod
	public int Suma(int a,int b) {
		return a+b;
	}
}
