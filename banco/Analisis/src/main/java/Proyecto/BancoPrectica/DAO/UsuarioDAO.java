package Proyecto.BancoPrectica.DAO;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import Proyecto.BancoPractica.Modelo.Persona;
import Proyecto.BancoPractica.Modelo.Usuario;


@Stateless
public class UsuarioDAO {

	@PersistenceContext
	private EntityManager em;

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
	public Usuario listaUsuario(String email,String passwor) throws Exception {

	try {	
		    Query query = em.createNativeQuery("SELECT *  FROM usuario u ,persona p WHERE p.correo= ? and u.password = ? ",Usuario.class);
		    query.setParameter(1, email);
		    query.setParameter(2, passwor);
		    return (Usuario) query.getSingleResult();
		   // List<Usuario> results = query.getResultList();
		   // return results;
	} catch(NoResultException e) {
	    return null;
	  }

}
}