package Proyecto.BancoPrectica.DAO;


import javax.ejb.Stateless;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import Proyecto.BancoPractica.Modelo.Usuario;



@Stateless
public class UsuarioDAO {

	@PersistenceContext
	private EntityManager em;

	public boolean inserta(Usuario entity) throws Exception {
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

/*	public boolean update(Usuario entity) throws Exception {
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
	}*/
	public Usuario loginUsuario(String email ,String password) throws Exception {
		
		
	 try {
		
       String jpql = "SELECT * FROM usuario u , persona p \r\n"
        		+ "WHERE  p.correo= :email  and u.passwor = :password";
        Query q = em.createQuery(jpql, Usuario.class);
        q.setParameter("email", email);
        q.setParameter("password", password);
        
        System.out.println(jpql);
        
        
        return (Usuario) q.getSingleResult();
       // edison@gmail
        //123
      
       
       /* Persona p = new Persona();
		p.setCorreo("123");
		
       Usuario es =new Usuario();
       es.setPassword("123");
	   es.setPersona(p);
       return es;*/
     } catch (Exception e) {
         throw new Exception("no existe usuario");
     }
	 
	 }
}
