package biblioteca.DAO;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;


import biblioteca.Modelo.Autor;

@Stateless
public class AutorDAO {
	
	@PersistenceContext
	private EntityManager em;
	public boolean CrearAutor(Autor entity) throws Exception {
		boolean estado = true;
		try {
			em.persist(entity);
			estado = true;
		} catch (Exception e) {
			estado = false;
			throw new Exception("Erro en crear cuenta " + e.getMessage());

		}

		return estado;
	}
	public Autor listarAnterior(int id) throws Exception {
		try {
			System.out.println("Estamos aca");
			return em.find(Autor.class, id);
		} catch (Exception e) {
			throw new Exception("Erro listar provedor" + e.getMessage());
		}
	}
	public Autor busqueda(String id) {

		try {
			    Query query = em.createNativeQuery("SELECT * FROM autor WHERE nombre= ?",Autor.class);
			    query.setParameter(1, id);
			    return  (Autor) query.getSingleResult();
		} catch(NoResultException e) {
		    return null;
		  }}
}
