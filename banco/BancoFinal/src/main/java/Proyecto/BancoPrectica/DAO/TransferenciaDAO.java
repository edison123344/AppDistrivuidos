package Proyecto.BancoPrectica.DAO;

import java.io.Serializable;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import Proyecto.BancoPractica.Modelo.Transferencia;
/**
 * 
 * @author edison
 *
 */
@Stateless
public class TransferenciaDAO implements Serializable {
	
 	/**
	 * clase que insertara gestiona todos los datos etre el sistema y la vase de datos
	 */
private static final long serialVersionUID = 1L;
	@PersistenceContext
	private EntityManager em;
	//cambiar a String para en biar el mesaje de error
	/**
	 * inserta la transferensia del cajero o cliente 
	 * @param entity
	 * @throws Exception
	 */
	public void transferir(Transferencia entity) throws Exception {
		
		try {
			em.persist(entity);
			
		} catch (Exception e) {
			
			throw new Exception("Erro en crear transferencia" + e.getMessage());

		}

	}

}
