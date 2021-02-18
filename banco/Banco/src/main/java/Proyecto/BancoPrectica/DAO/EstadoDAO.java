package Proyecto.BancoPrectica.DAO;


import java.util.ArrayList;
//import java.util.Date;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import Proyecto.BancoPractica.Modelo.Estado;


@Stateless
public class EstadoDAO {
	@PersistenceContext
	private EntityManager em;

/*	public boolean inser(Estado entity) throws Exception {
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

	public boolean update(Estado entity) throws Exception {
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

	public Estado read(int id) throws Exception {
		try {
			System.out.println("Estamos aca");
			return em.find(Estado.class, id);
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
	public List<Estado> getEstadoPorDia(int idUsuario, Date fechaInicio, Date fechaFin){
	return null;
			
		
	}*/
	private List<Estado> listaOpc;
	public List<Estado> getEstado(int idUsuario){
		//String jpql="SELECT c FROM Cliente c WHERE tipoDocumento=?1";
		
		//Query q= em.createQuery(jpql, Estado.class);
		//q.setParameter(1,1);
		Estado e =new Estado();
		e.setDeposito(10);
		e.setIdEstado(123);
		e.setTipo("dep");
		e.setSaldo(123);
		 listaOpc = new ArrayList<>();
	        listaOpc.add(e);
	    
	       
         return listaOpc;
		//return (List<Estado>)q.getResultList();
		
	}
}
