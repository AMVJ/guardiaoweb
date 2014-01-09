package br.com.guardiao.dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import br.com.guardiao.modelo.Camera;

public class CameraDAO extends DAO<Camera> {

	private Logger logger = Logger.getLogger(CameraDAO.class);

	public CameraDAO(Session session, Class<?> classe) {
		super(session, classe);
	}
	
	public Camera pesquisaCameraById(Long idCamera) {
		logger.info("pesquisaCameraById : " + idCamera);
		return (Camera) session.load(Camera.class, idCamera);
	}
	
	public Camera pesquisaCameraByNome(String nome) {
		logger.info("pesquisaCameraByNome : " + nome);
		Criteria c = session.createCriteria(Camera.class);
		c.add(Restrictions.ilike("nmCamera", "%" + nome + "%"));

		return (Camera)c.uniqueResult();
	}
	
	public Camera pesquisaCameraByEmail(String email) {
		logger.info("pesquisaCameraByEmail : " + email);
		Criteria c = session.createCriteria(Camera.class);
		c.add(Restrictions.ilike("email", email + "%"));

		return (Camera)c.uniqueResult();
	}
	
	@SuppressWarnings("unchecked")
	public List<Camera> pesquisaCameras(String nome){
		Criteria c = session.createCriteria(Camera.class);
		c.add(Restrictions.ilike("nmCamera", "%" + nome + "%"));
		c.addOrder(Order.asc("nmCamera"));
		
		return c.list();
	}
	
	public boolean verificaEmailSenha(Long cpf, Long rg){
		boolean valid = false;
		
		System.out.println("DAO metodo isValidLoginAndPassword...");
		System.out.println("DAO session.isOpen() >>> " + session.isOpen());
		
		Query query = session.createQuery("select p from Camera p where p.nrCpf = :cpf_param and p.nrRg = :rg_param");
		query.setLong("cpf_param", cpf);
		query.setLong("rg_param", rg);
		
		Camera camera = (Camera) query.uniqueResult();

		if(camera != null){
			valid = true;
		}
	
		System.out.println("DAO Camera >>> " + camera);

		return valid; 
	}
	
	/**
	 * Exemplo utilizando HQL 
	 * @param id
	 * @return
	 */
	public Camera buscaCamera(Long id){
		Query q = session.createQuery("select p from " + Camera.class.getName() + " as p where p.id like :id");
		
		q.setParameter("id", id);
		
		return (Camera)q.uniqueResult();
	}
}