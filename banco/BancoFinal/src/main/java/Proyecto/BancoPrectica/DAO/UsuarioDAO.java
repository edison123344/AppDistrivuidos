package Proyecto.BancoPrectica.DAO;


import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import Proyecto.BancoPractica.Modelo.Usuario;
/**
 * 
 * @author edison
 *
 */

@Stateless
public class UsuarioDAO {
	/**
	 * clase que insertara gestiona todos los datos etre el sistema y la vase de datos
	 */
	@PersistenceContext
	private EntityManager em;
/**
 * inserta los detos del usuario ala base de datos
 * @param entity
 * @return true o false
 * @throws Exception
 */
	public boolean insertar(Usuario entity) throws Exception {
		boolean estado = true;
		try {
			em.persist(entity);
			estado = true;
		} catch (Exception e) {
			estado = false;
			throw new Exception("Erro ingreso Alogin " + e.getMessage());

		}

		return estado;
	}
/**
 * lista el usuario segun su clave y pssword
 * @param email
 * @param passwor
 * @return usuario
 * @throws Exception
 */
	public Usuario listaUsuario(String email,String passwor) throws Exception {

	try {	
		    Query query = em.createNativeQuery("SELECT *  FROM usuario u ,persona p WHERE p.correo= ? and u.password = ? ",Usuario.class);
		    query.setParameter(1, email);
		    query.setParameter(2, passwor);
		    return (Usuario) query.getSingleResult();
	} catch(NoResultException e) {
	
	    return null;
	  }
	}
	/**
	 * actualisa el usuario en la vase de datos
	 * @param entity
	 * @throws Exception
	 */
	  public void actualizar(Usuario  entity) throws Exception {
	        try {
	            em.merge(entity);
	        } catch (Exception e) {
	            throw new Exception("Error actualizar " +e.getMessage());
	        }
	    }
/**
 * lista usuario segun su email usado para la recuperacion de claves
 * @param email
 * @return Usuario
 */
	public Usuario  listaUsuarioEmail(String email) {
		try {	
		    Query query = em.createNativeQuery("SELECT *  FROM usuario u ,persona p WHERE p.correo= ? ",Usuario.class);
		    query.setParameter(1, email);
		    return (Usuario) query.getSingleResult();
	} catch(NoResultException e) {
	
	    return null;
	  }
	}

	
}