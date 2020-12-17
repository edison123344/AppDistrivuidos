package ups.edu.Banco.DAO;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import ups.edu.Banco.Modelo.Usuario;


@Stateless
public class UsuarioDAO {
	@SuppressWarnings("cdi-ambiguous-dependency")
	@Inject
	private EntityManager em;

	public boolean inser(Usuario entity) throws Exception {
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

	public boolean update(Usuario entity) throws Exception {
		boolean estado = true;
		try {
			em.merge(entity);
			estado = true;
		} catch (Exception e) {
			estado = false;
			throw new Exception("Erro actualizar Alogin " + e.getMessage());
		}
		return estado;
	}

	public Usuario read(int id) throws Exception {
		try {
			System.out.println("Ingreso");
			return em.find(Usuario.class, id);
		} catch (Exception e) {
			throw new Exception("Erro leer Alogin " + e.getMessage());
		}
	}

	public boolean delite(int id) throws Exception {
		boolean estado = true;
		try {
			System.out.println("borrando");
			em.remove(read(id));
			estado = true;
		} catch (Exception e) {
			estado = false;
			throw new Exception("Error Eliminar Alogin " + e.getMessage());

		}
		return estado;
	}
	public Usuario loginUsuario(String email ,String password) throws Exception {
	 try {
         String jpql = "SELECT a FROM Usuario u , Persona p FROM u.persona.idPersona=p.id and email= :email and password=:password ";
         Query q = em.createQuery(jpql, Usuario.class);
         q.setParameter("email", email);
         q.setParameter("password", password);
         return (Usuario) q.getSingleResult();
        
     } catch (Exception e) {
         throw new Exception("no existe usuario");
     }
	 
	 }
}
