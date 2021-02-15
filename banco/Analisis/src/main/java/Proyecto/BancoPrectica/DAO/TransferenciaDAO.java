package Proyecto.BancoPrectica.DAO;

import java.io.Serializable;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import Proyecto.BancoPractica.Modelo.Transferencia;

@Stateless
public class TransferenciaDAO implements Serializable {
	
	/**
 * 
 */
private static final long serialVersionUID = 1L;
	@PersistenceContext
	private EntityManager em;
	//cambiar a String para en biar el mesaje de error
	public void transferir(Transferencia entity) throws Exception {
		
		try {
			em.persist(entity);
			
		} catch (Exception e) {
			
			throw new Exception("Erro en crear transferencia" + e.getMessage());

		}

	}

}
