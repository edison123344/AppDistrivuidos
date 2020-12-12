package ups.edu.Banco.DAO;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import ups.edu.Banco.Modelo.Deposito;


@Stateless
public class DepositoDAO {
	@Inject
	private EntityManager em;

	public boolean inser(Deposito entity) throws Exception {
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

	public boolean update(Deposito entity) throws Exception {
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

	public Deposito read(int id) throws Exception {
		try {
			System.out.println("Estamos aca");
			return em.find(Deposito.class, id);
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
			throw new Exception("oErro Eliminar Alogin " + e.getMessage());

		}
		return estado;
	}
}
