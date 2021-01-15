package Proyecto.BancoPrectica.DAO;

import java.io.Serializable;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import Proyecto.BancoPractica.Modelo.Cuenta;


@Stateless
public class CuentaDAO implements Serializable {
	
		/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
		@PersistenceContext
		private EntityManager em;
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

		public Cuenta Buscar(String id) throws Exception {
			try {
				System.out.println("Estamos aca");
				return em.find(Cuenta.class, id);
			} catch (Exception e) {
				throw new Exception("Erro leer Alogin " + e.getMessage());
			}
		}


}
