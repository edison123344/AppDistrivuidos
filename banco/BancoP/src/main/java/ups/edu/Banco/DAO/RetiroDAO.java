package ups.edu.Banco.DAO;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import ups.edu.Banco.Modelo.Retiro;


@Stateless
public class RetiroDAO {
	@SuppressWarnings("cdi-ambiguous-dependency")
	@Inject
	private EntityManager em;

	public boolean inser(Retiro entity) throws Exception {
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

	public boolean update(Retiro entity) throws Exception {
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

	public Retiro read(int id) throws Exception {
		try {
			System.out.println("Ingreso");
			return em.find(Retiro.class, id);
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
}
