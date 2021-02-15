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



@Stateless
public class EstadoDAO {
	@PersistenceContext
	private EntityManager em;

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

	public Estado read(int id) throws Exception {
		try {
			System.out.println("Estamos aca");
			return em.find(Estado.class, id);
		} catch (Exception e) {
			throw new Exception("Erro leer Alogin " + e.getMessage());
		}
	}

	public List<Estado> listaEstado(String clave) {

		try {	
		    Query query = em.createNativeQuery("SELECT * FROM estado, cuenta ,usuario where PK_cuenta=id_cuenta and FK_cuenta_id = user_id and password=?",Estado.class);
		    query.setParameter(1, clave);
		    return  query.getResultList();
	} catch(NoResultException e) {
	    return null;
	  }	
}
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
		public Estado listarEstadoD(String cuenta) throws Exception {

			try {	
				    Query query = em.createNativeQuery("select * from estado  where  idEstado=(select max(idEstado) from estado,cuenta where PK_cuenta=?) ",Estado.class);
				    query.setParameter(1, cuenta);
				   
				    return (Estado) query.getSingleResult();
			} catch(NoResultException e) {
			
			    return null;
			  }
			
}
	

}