package Proyecto.BancoPrectica.DAO;


import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.glassfish.gmbal.GmbalException;

import Proyecto.BancoPractica.Modelo.Taza;
import Proyecto.BancoPractica.Modelo.Usuario;


@Stateless
public class TazaDAO {
	@PersistenceContext
	private EntityManager em;

	public void insertar(Taza entity) throws GmbalException {	
		try {			
			em.persist(entity);	
		} catch (Exception e) {
		
			throw new  GmbalException ("Erro al ingresar Taza  " + e.getMessage());
		}	
	}
	
	
public List<Taza>listaTaza() throws Exception {
	try {
		 Query query = em.createNativeQuery("SELECT * FROM taza",Taza.class);
	     
		 return  query.getResultList();
	     
} catch(NoResultException e) {
    return null;
  }
	

}
public Taza read(int id) throws Exception {
	try {
		
		return em.find(Taza.class, id);
	} catch (Exception e) {
		throw new Exception("Erro leer persona " + e.getMessage());
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
		throw new Exception("oErro Eliminar Alogin " + e.getMessage());

	}
	return estado;
}
public Taza TazaDato(int dias) throws Exception {
	try {
		 Query query = em.createNativeQuery("select * From Taza Where (?>=desde and ?<=hasta )",Taza.class);
		 query.setParameter(1, dias);
		 query.setParameter(2, dias);		 
		 return (Taza) query.getSingleResult();
} catch(NoResultException e) {
    return null;
  }
	

}


}
