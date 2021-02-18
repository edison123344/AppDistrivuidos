package Proyecto.BancoPrectica.DAO;

import java.util.Date;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import Proyecto.BancoPractica.Modelo.Poliza;


/**
 * 
 * @author edison
 *
 */


@Stateless
public class PolizaDAO {
 	/**
	 * clase que insertara gestiona todos los datos etre el sistema y la vase de datos
	 */
	@PersistenceContext
	private EntityManager em;
/**
 * inserta datos de la poliza
 * @param entity
 * @return estado true o false
 * @throws Exception
 */
	public boolean insertar(Poliza entity) throws Exception {
		boolean estado = true;
		try {
			em.persist(entity);
			estado = true;
		} catch (Exception e) {
			estado = false;
			throw new Exception("Erro ingreso logeo " + e.getMessage());

		}

		return estado;
	}
	/**
	 * lista todas las polisas de la base de datos
	 * @return
	 */
	public List<Poliza> listaPoliza() {

		try {	
		    Query query = em.createNativeQuery("SELECT *  FROM poliza ",Poliza.class);
		    return  query.getResultList();
	} catch(NoResultException e) {
	    return null;
	  }	
}
	/**
	 * listar polisa de cliente por id del cliente
	 * @return lista cliente
	 */
	
	
	public List<Poliza> listaPolizaCliente() {

		try {	
		    Query query = em.createNativeQuery("SELECT *  FROM poliza ",Poliza.class);
		    return  query.getResultList();
	} catch(NoResultException e) {
	    return null;
	  }	
}
	/**
	 * busca una polizasa segun el id
	 * @param id
	 * @return poliza
	 * @throws Exception
	 */
	public Poliza buscar(long id) throws Exception {
		try {
			
			return em.find(Poliza.class, id);
		} catch (Exception e) {
			throw new Exception("Error leer persona " + e.getMessage());
		}
	}
	/**
	 * actualisa todos los detos de una polisa en una base
	 * @param poliza
	 * @throws Exception
	 */
    public void actualizar(Poliza poliza) throws Exception {
        try {
            em.merge(poliza);
        } catch (Exception e) {
            throw new Exception("Error actualizar poliza " +e.getMessage());
        }
    }
	public List<Poliza> PolizaCaducada(String id) {

	try {
		    Query query = em.createNativeQuery("SELECT * FROM Poliza WHERE estado= 'caducado'",Poliza.class);
		    query.setParameter(1, id);
		    return query.getResultList();
	} catch(NoResultException e) {
	    return null;
	  }}
		public Poliza listaPolizaDia(Date dia) {

			try {	
			    Query query = em.createNativeQuery("SELECT * FROM Poliza WHERE fechaVencimiento <= ?",Poliza.class);
			    query.setParameter(1, dia);
			    return (Poliza) query.getSingleResult();
		} catch(NoResultException e) {
		    return null;
		  }	
}
}
