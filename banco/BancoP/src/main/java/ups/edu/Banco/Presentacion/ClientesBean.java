package ups.edu.Banco.Presentacion;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import ups.edu.Banco.Modelo.Cuenta;
import ups.edu.Banco.Negocio.GestionAdminON;

@Named
@RequestScoped
public class ClientesBean {

	private Cuenta newCliente;
	@Inject
	private GestionAdminON on;
	
	public  ClientesBean(){
		
		init();
	}
	public void init() {
		
		newCliente=new Cuenta();
	}
	
	public String doGuardar() {
		
		
		System.out.println(newCliente);
		try {
			
			System.out.println("Guardado satisfactorio");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("Error al guardar " +e.getMessage());

			e.printStackTrace();
		}
		return null;
	}
	

}
