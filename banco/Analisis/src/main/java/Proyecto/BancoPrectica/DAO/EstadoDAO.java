package Proyecto.BancoPrectica.DAO;


import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import Proyecto.BancoPractica.Modelo.Estado;
import Proyecto.BancoPractica.Modelo.Persona;



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

	public List<Estado> listar() throws Exception {
		
	    Query query = em.createNativeQuery("SELECT * FROM estado");
	    List<Estado> results = query.getResultList();
	    return results;
}

}