package br.com.guardiao.facade;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;

import br.com.guardiao.dao.CameraDAO;
import br.com.guardiao.modelo.Camera;

public class CameraFacadeImpl implements CameraFacade {

	private static final long serialVersionUID = 1818242808424001885L;
	
	private CameraDAO cameraDAO;
	private SessionFactory sf; 
	private	Session session;
	private Transaction tx;
	
	public void salva(Camera p) {
		sf = new AnnotationConfiguration().configure().buildSessionFactory(); 
		session = sf.openSession();
		tx = session.beginTransaction();
		cameraDAO = new CameraDAO(session, Camera.class);
		
		this.cameraDAO.save(p);
		
		tx.commit();
		session.close();
	}

	public void atualiza(Camera p) {
		sf = new AnnotationConfiguration().configure().buildSessionFactory(); 
		session = sf.openSession();
		tx = session.beginTransaction();
		cameraDAO = new CameraDAO(session, Camera.class);
		
		this.cameraDAO.merge(p);
		
		tx.commit();
		session.close();
	}

	public Camera procura(Long id) {
		sf = new AnnotationConfiguration().configure().buildSessionFactory(); 
		session = sf.openSession();
		tx = session.beginTransaction();
		cameraDAO = new CameraDAO(session, Camera.class);
				
		Camera p = this.cameraDAO.load(id);
		
		tx.commit();
		session.close();
		
		return p;
	}

	public void remove(Camera p) {
		sf = new AnnotationConfiguration().configure().buildSessionFactory(); 
		session = sf.openSession();
		tx = session.beginTransaction();
		cameraDAO = new CameraDAO(session, Camera.class);
		
		this.cameraDAO.delete(p);
		
		tx.commit();
		session.close();
	}

	public List<Camera> lista() {
		sf = new AnnotationConfiguration().configure().buildSessionFactory(); 
		session = sf.openSession();
		tx = session.beginTransaction();
		cameraDAO = new CameraDAO(session, Camera.class);
				
		List<Camera> lista = this.cameraDAO.list();
		
		tx.commit();
		session.close();
		
		return lista;
	}
	
	public List<Camera> pesquisaCamerasByNome(String nome) {
		sf = new AnnotationConfiguration().configure().buildSessionFactory(); 
		session = sf.openSession();
		tx = session.beginTransaction();
		cameraDAO = new CameraDAO(session, Camera.class);
		
		List<Camera> lista = this.cameraDAO.pesquisaCameras(nome);
		tx.commit();
		session.close();
		
		return lista;
	}
	
	public Camera procuraById(Long id){
		sf = new AnnotationConfiguration().configure().buildSessionFactory(); 
		session = sf.openSession();
		tx = session.beginTransaction();
		cameraDAO = new CameraDAO(session, Camera.class);
				
		Camera p = this.cameraDAO.pesquisaCameraById(id);
		
		tx.commit();
		session.close();
		
		return p;
	}
	
	public Camera procuraByNome(String nome){
		sf = new AnnotationConfiguration().configure().buildSessionFactory(); 
		session = sf.openSession();
		tx = session.beginTransaction();
		cameraDAO = new CameraDAO(session, Camera.class);
		
		Camera p = this.cameraDAO.pesquisaCameraByNome(nome);
		
		tx.commit();
		session.close();
		
		return p; 
	}
	
	public Camera procuraByEmail(String email){
		sf = new AnnotationConfiguration().configure().buildSessionFactory(); 
		session = sf.openSession();
		tx = session.beginTransaction();
		cameraDAO = new CameraDAO(session, Camera.class);

		Camera p = this.cameraDAO.pesquisaCameraByEmail(email);
		
		tx.commit();
		session.close();
		
		return p; 
	}
	
/*	public boolean autentica(String email, String senha){
		boolean autenticado; 
		
		sf = new AnnotationConfiguration().configure().buildSessionFactory(); 
		session = sf.openSession();
		tx = session.beginTransaction();
		cameraDAO = new CameraDAO(session, Camera.class);

		autenticado = this.cameraDAO.verificaEmailSenha(email, senha);
		
		tx.commit();
		session.close();
		
		return autenticado; 
	} */

	public boolean autentica(Long cpf, Long rg){
		boolean autenticado; 
		
		sf = new AnnotationConfiguration().configure().buildSessionFactory(); 
		session = sf.openSession();
		tx = session.beginTransaction();
		cameraDAO = new CameraDAO(session, Camera.class);
		
		autenticado = this.cameraDAO.verificaEmailSenha(cpf, rg);
		
		tx.commit();
		session.close();
		
		return autenticado; 
	}
}