package Proyecto.BancoPrectica.DAO;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import Proyecto.BancoPractica.Modelo.Persona;
/**
 * 
 * @author edison
 *
 */
@Stateless
public class PersonaDAO {
 	/**
	 * clase que insertara gestiona todos los datos etre el sistema y la vase de datos
	 */
 
	@PersistenceContext
	private EntityManager em;
/**
 * inserta los datos Persona ala base de datos 
 * @param entity
 * @return true o false
 * @throws Exception
 */
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
	/**
	 * busca datos persona de la base de datos seguin id
	 * @param id
	 * @return Persona
	 * @throws Exception
	 */
	public Persona read(int id) throws Exception {
		try {
			
			return em.find(Persona.class, id);
		} catch (Exception e) {
			throw new Exception("Erro leer persona " + e.getMessage());
		}
	}
	/**
	 * busca datos persona de la base de datos seguin la cedula
	 * @param id
	 * @return Persona
	 * @throws Exception
	 */
	public Persona buscar(int idCedula) throws Exception {
		try {
			return em.find(Persona.class, idCedula);
		} catch (Exception e) {
			throw new Exception("Erro leer Alogin " + e.getMessage());
		}
	}
/**
 * lista losdatos de person
 * @return lista persona
 * @throws Exception
 */

	public List<Persona>listaPersona() throws Exception {

		
	    Query nativeQuery = em.createNativeQuery("SELECT nombre FROM persona");
	     
	    List<Persona> results = nativeQuery.getResultList();
	     
	    return results;
	

}
}
