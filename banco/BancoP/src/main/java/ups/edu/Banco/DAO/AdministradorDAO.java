package ups.edu.Banco.DAO;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import ups.edu.Banco.Modelo.Administrador;

@Stateless
public class AdministradorDAO {
	
	@Inject
	private EntityManager em;

	public boolean inser(Administrador entity) throws Exception {
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

	public boolean update(Administrador entity) throws Exception {
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

	public Administrador read(int id) throws Exception {
		try {
			System.out.println("Estamos aca");
			return em.find(Administrador.class, id);
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
