package Proyecto.BancoPrectica.DAO;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import Proyecto.BancoPractica.Modelo.RegistroCliente;
/**
 * 
 * @author edison
 *
 */

@Stateless
public class RegistroClienteDAO {
 	/**
	 * clase que insertara gestiona todos los datos etre el sistema y la vase de datos
	 */
	@PersistenceContext
	private EntityManager em;

	/**
	 * inserta los registros del usuario al logearse en la base
	 * @param entity
	 * @return true o false
	 * @throws Exception
	 */
	public boolean insertar(RegistroCliente entity) throws Exception {
		boolean estado = true;
		try {
			em.persist(entity);
			estado = true;
		} catch (Exception e) {
			estado = false;
			throw new Exception("Erro ingreso RegitroCiente" + e.getMessage());

		}

		return estado;
	}
	/**
	 * lista el istorial del usuario segun la clave del usuario
	 * @param clave
	 * @return
	 */
	
	public List<RegistroCliente> listarHistorial(String clave) {

		try {	
		    Query query = em.createNativeQuery("SELECT * FROM  regitrociente , usuario where FK_idUsuario=user_id and password = ?",RegistroCliente.class);	  
		    query.setParameter(1, clave);
		    return  query.getResultList();
	} catch(NoResultException e) {
	    return null;
	  }	
}
}
