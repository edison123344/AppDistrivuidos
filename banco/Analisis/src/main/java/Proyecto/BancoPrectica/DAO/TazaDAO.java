package Proyecto.BancoPrectica.DAO;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import Proyecto.BancoPractica.Modelo.Taza;

@Stateless
public class TazaDAO {
	@PersistenceContext
	private EntityManager em;

	public boolean insertar(Taza entity) throws Exception {
		boolean estado = true;
		try {
			
			em.persist(entity);
			estado = true;
		} catch (Exception e) {
			estado = false;
			throw new Exception("Erro al ingresar dato Taza " + e.getMessage());
		}
		return estado;
	}
	
public List<Taza>listaTaza() throws Exception {
	try {
		 Query query = em.createNativeQuery("SELECT nombre FROM taza",Taza.class);
	     
		 return  query.getResultList();
	     
} catch(NoResultException e) {
    return null;
  }
	

}
}
