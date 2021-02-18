package Proyecto.BancoPrectica.DAO;

import java.io.Serializable;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import Proyecto.BancoPractica.Modelo.Cuenta;
import Proyecto.BancoPractica.Modelo.Usuario;
/**
 * 
 * @author edison
 *
 */

@Stateless
public class CuentaDAO implements Serializable {
	
		/**
	 * clase que insertara gestiona todos los datos etre el sistema y la vase de datos
	 */
	private static final long serialVersionUID = 1L;
		@PersistenceContext
		private EntityManager em;
		/**
		 * metodo que enviara los datos ala vase de datos 
		 * @param entity
		 * @return tru o fase
		 * @throws Exception
		 */
		//cambiar a String para en biar el mesaje de error
		public boolean Crearcuenta(Cuenta entity) throws Exception {
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
		/**
		 * metodo usado para la vusqueda de la informacion en la base de datos
		 * @param id
		 * @return cuenta
		 * @throws Exception
		 */

		public Cuenta Buscar(String id) throws Exception {
			try {
				System.out.println("Estamos aca");
				return em.find(Cuenta.class, id);
			} catch (Exception e) {
				throw new Exception("Erro leer Alogin " + e.getMessage());
			}
		}
		
}
