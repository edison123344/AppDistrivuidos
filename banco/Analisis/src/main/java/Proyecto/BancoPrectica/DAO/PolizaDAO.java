package Proyecto.BancoPrectica.DAO;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import Proyecto.BancoPractica.Modelo.Poliza;




@Stateless
public class PolizaDAO {
	@PersistenceContext
	private EntityManager em;

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
	public Poliza buscar(long id) throws Exception {
		try {
			
			return em.find(Poliza.class, id);
		} catch (Exception e) {
			throw new Exception("Error leer persona " + e.getMessage());
		}
	}
    public void actualizar(Poliza poliza) throws Exception {
        try {
            em.merge(poliza);
        } catch (Exception e) {
            throw new Exception("Error actualizar poliza " +e.getMessage());
        }
    }
}
