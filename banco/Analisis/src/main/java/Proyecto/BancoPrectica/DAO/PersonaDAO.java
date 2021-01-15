package Proyecto.BancoPrectica.DAO;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import Proyecto.BancoPractica.Modelo.Persona;

@Stateless
public class PersonaDAO {

	@PersistenceContext
	private EntityManager em;

	public boolean insertar(Persona entity) throws Exception {
		boolean estado = true;
		try {
			em.persist(entity);
			estado = true;
		} catch (Exception e) {
			estado = false;
			throw new Exception("Erro ingreso logeo " + e.getMessage());

		}

		return estado;
	}
	public Persona read(int id) throws Exception {
		try {
			
			return em.find(Persona.class, id);
		} catch (Exception e) {
			throw new Exception("Erro leer persona " + e.getMessage());
		}
	}
	public Persona buscar(int idCedula) throws Exception {
		try {
			return em.find(Persona.class, idCedula);
		} catch (Exception e) {
			throw new Exception("Erro leer Alogin " + e.getMessage());
		}
	}


	public List<Persona>listaPersona() throws Exception {

		
	    Query nativeQuery = em.createNativeQuery("SELECT nombre FROM persona");
	     
	    List<Persona> results = nativeQuery.getResultList();
	     
	    return results;
	

}
}
