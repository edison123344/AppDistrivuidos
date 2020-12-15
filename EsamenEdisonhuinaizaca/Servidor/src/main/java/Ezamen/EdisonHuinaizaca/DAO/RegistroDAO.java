package Ezamen.EdisonHuinaizaca.DAO;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import Ezamen.EdisonHuinaizaca.Modelo.Registro;
@Stateless
public class RegistroDAO {
	@Inject
    private EntityManager em;

	public boolean inser(Registro entity) {
		em.persist(entity);
		return true;
	}

	public boolean update(Registro entity) {
		em.merge(entity);
		return true;
	}

	public Registro read(String nombre) {
		Registro registro = em.find(Registro.class,nombre);
		return registro;

	}

	public boolean delete(String nombre) {
		em.remove(read(nombre));
		return true;
	}
	public List<Registro> getRegistro(){
		String jpql="SELECT c FROM Registros c WHERE IdRgistr=?1";
		
		Query q= em.createQuery(jpql, Registro.class);
		q.setParameter(1,1);

		return (List<Registro>)q.getResultList();
		
	}
	


}
