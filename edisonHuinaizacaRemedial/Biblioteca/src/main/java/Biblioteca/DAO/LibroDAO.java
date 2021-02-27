package biblioteca.DAO;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;


import biblioteca.Modelo.Libro;


@Stateless
public class LibroDAO {
	@PersistenceContext
	private EntityManager em;
	
	public boolean CrearLibro(Libro entity) throws Exception {
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

	  public void actualizar(Libro  entity) throws Exception {
	        try {
	            em.merge(entity);
	        } catch (Exception e) {
	            throw new Exception("Error actualizar " +e.getMessage());
	        }
	    }

	  public Libro listarAnterior(int id) throws Exception {
			try {
				System.out.println("Estamos aca");
				return em.find(Libro.class, id);
			} catch (Exception e) {
				throw new Exception("Erro listar provedor" + e.getMessage());
			}
		}
	  /**
	   * lista todos los productos de fereteria
	   * @return
	   */
	public List<Libro> listaProducto() {

		try {	
		    Query query = em.createNativeQuery("SELECT *  FROM Libro ",Libro.class);
		    return  query.getResultList();
	} catch(NoResultException e) {
	    return null;
	  }	
}
	
}
