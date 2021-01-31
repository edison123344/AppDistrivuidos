package Proyecto.BancoPrectica.DAO;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import Proyecto.BancoPractica.Modelo.RegistroCliente;


@Stateless
public class RegistroClienteDAO {
	@PersistenceContext
	private EntityManager em;

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
