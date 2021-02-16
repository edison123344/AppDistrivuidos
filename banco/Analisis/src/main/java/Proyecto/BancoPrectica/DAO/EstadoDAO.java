package Proyecto.BancoPrectica.DAO;

import java.util.Date;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import Proyecto.BancoPractica.Modelo.Estado;
import Proyecto.BancoPractica.Modelo.Persona;
import Proyecto.BancoPractica.Modelo.Usuario;

/**
 * 
 * @author edison
 *
 */

@Stateless
public class EstadoDAO {
	/**
	 * clase que insertara gestiona todos los datos etre el sistema y la vase de datos
	 */
	@PersistenceContext
	private EntityManager em;
/**
 * insertaa datos del estado ala base de datos
 * @param entity
 * @return estado
 * @throws Exception
 */
	public boolean insertar(Estado entity) throws Exception {
		boolean estado = true;
		try {
			em.persist(entity);
			estado = true;
		} catch (Exception e) {
			estado = false;
			throw new Exception("Erro ingreso Estado" + e.getMessage());

		}

		return estado;
	}
/**
 * busca ls datos de estado
 * @param id
 * @return
 * @throws Exception
 */
	public Estado read(int id) throws Exception {
		try {
			System.out.println("Estamos aca");
			return em.find(Estado.class, id);
		} catch (Exception e) {
			throw new Exception("Erro leer Alogin " + e.getMessage());
		}
	}
	/**
	 * lista todos los datos del estado segun su clave 
	 * @param clave
	 * @return lista de estado
	 */

	public List<Estado> listaEstado(String clave) {

		try {	
		    Query query = em.createNativeQuery("SELECT * FROM estado, cuenta ,usuario where PK_cuenta=id_cuenta and FK_cuenta_id = user_id and password=?",Estado.class);
		    query.setParameter(1, clave);
		    return  query.getResultList();
	} catch(NoResultException e) {
	    return null;
	  }	
}
	/**
	 * lista el estado segun la fecha de inicio y fin 
	 * @param clave
	 * @param desde
	 * @param hasta
	 * @return lista de estados segun la fecha
	 */
	public List<Estado> listaPorFecha(String clave ,Date desde ,Date hasta ) {

		try {	
		    Query query = em.createNativeQuery("SELECT * FROM estado, cuenta ,usuario where PK_cuenta=id_cuenta and FK_cuenta_id = user_id and password = ? and registro BETWEEN ? AND ?",Estado.class);
		    query.setParameter(1, clave);
		    query.setParameter(2, desde);
		    query.setParameter(3, hasta);
		    return  query.getResultList();
	} catch(NoResultException e) {
	    return null;
	  }	
		
	}
	/**
	 * lista el estado segun el ide de cuenta 
	 * @param cuenta
	 * @return
	 * @throws Exception
	 */
		public Estado listarEstadoD(String cuenta) throws Exception {

			try {	
				    Query query = em.createNativeQuery("select * from estado  where  idEstado=(select max(idEstado) from estado,cuenta where PK_cuenta=?) ",Estado.class);
				    query.setParameter(1, cuenta);
				   
				    return (Estado) query.getSingleResult();
			} catch(NoResultException e) {
			
			    return null;
			  }
		}
		/**
		 * lista todos los estados de todas las cuentas (clase prueba de funcionamiento)
		 * @return lista estado
		 */
		public List<Estado> listaPrueva() {

				try {	
				    Query query = em.createNativeQuery("SELECT * FROM estado",Estado.class);
				    List<Estado> aux=query.getResultList();
				    return  aux;
			} catch(NoResultException e) {
			    return null;
			  }	
		}	
/**
 * 
 * @param clave
 * @return
 */
		public Estado estadobusqueda(String clave) {

			try {	
			    Query query = em.createNativeQuery("SELECT * FROM estado, cuenta ,usuario where PK_cuenta=id_cuenta and FK_cuenta_id = user_id and password=?",Estado.class);
			    query.setParameter(1, clave);
			    return (Estado) query.getSingleResult();
		} catch(NoResultException e) {
		    return null;
		  }	
	}

}