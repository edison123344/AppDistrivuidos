package Ezamen.EdisonHuinaizaca.DAO;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import Ezamen.EdisonHuinaizaca.Modelo.Autor;
@Stateless

public class AutorDAO {
	@Inject
    private EntityManager em;

	public boolean inser(Autor entity) {
		em.persist(entity);
		return true;
	}

	public boolean update(Autor entity) {
		em.merge(entity);
		return true;
	}

	public Autor read(int id) {
		Autor autor = em.find(Autor.class, id);
		return autor;

	}

	public boolean delete(int id) {
		em.remove(read(id));
		return true;
	}

}
