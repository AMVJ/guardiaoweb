package br.com.guardiao.facade;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;

import br.com.guardiao.dao.UsuarioDAO;
import br.com.guardiao.modelo.Usuario;import br.com.guardiao.modelo.Usuario;


public class UsuarioFacadeImpl implements UsuarioFacade {

	private static final long serialVersionUID = 1818242808424001885L;
	
	private UsuarioDAO usuarioDAO;
	private SessionFactory sf; 
	private	Session session;
	private Transaction tx;
	
	public void salva(Usuario p) {
		sf = new AnnotationConfiguration().configure().buildSessionFactory(); 
		session = sf.openSession();
		tx = session.beginTransaction();
		usuarioDAO = new UsuarioDAO(session, Usuario.class);
		
		this.usuarioDAO.save(p);
		
		tx.commit();
		session.close();
	}

	public void atualiza(Usuario p) {
		sf = new AnnotationConfiguration().configure().buildSessionFactory(); 
		session = sf.openSession();
		tx = session.beginTransaction();
		usuarioDAO = new UsuarioDAO(session, Usuario.class);
		
		this.usuarioDAO.merge(p);
		
		tx.commit();
		session.close();
	}

	public Usuario procura(Long id) {
		sf = new AnnotationConfiguration().configure().buildSessionFactory(); 
		session = sf.openSession();
		tx = session.beginTransaction();
		usuarioDAO = new UsuarioDAO(session, Usuario.class);
				
		Usuario p = this.usuarioDAO.load(id);
		
		tx.commit();
		session.close();
		
		return p;
	}

	public void remove(Usuario p) {
		sf = new AnnotationConfiguration().configure().buildSessionFactory(); 
		session = sf.openSession();
		tx = session.beginTransaction();
		usuarioDAO = new UsuarioDAO(session, Usuario.class);
		
		this.usuarioDAO.delete(p);
		
		tx.commit();
		session.close();
	}

	public List<Usuario> lista() {
		sf = new AnnotationConfiguration().configure().buildSessionFactory(); 
		session = sf.openSession();
		tx = session.beginTransaction();
		usuarioDAO = new UsuarioDAO(session, Usuario.class);
				
		List<Usuario> lista = this.usuarioDAO.list();
		
		tx.commit();
		session.close();
		
		return lista;
	}
	
	public List<Usuario> pesquisaUsuarioByNome(String nome) {
		sf = new AnnotationConfiguration().configure().buildSessionFactory(); 
		session = sf.openSession();
		tx = session.beginTransaction();
		usuarioDAO = new UsuarioDAO(session, Usuario.class);
		
		List<Usuario> lista = this.usuarioDAO.pesquisaPessoas(nome);
		tx.commit();
		session.close();
		
		return lista;
	}
	
	public Usuario procuraById(Long id){
		sf = new AnnotationConfiguration().configure().buildSessionFactory(); 
		session = sf.openSession();
		tx = session.beginTransaction();
		usuarioDAO = new UsuarioDAO(session, Usuario.class);
				
		Usuario p = this.usuarioDAO.pesquisaPessoaById(id);
		
		tx.commit();
		session.close();
		
		return p;
	}
	
	public Usuario procuraByNome(String nome){
		sf = new AnnotationConfiguration().configure().buildSessionFactory(); 
		session = sf.openSession();
		tx = session.beginTransaction();
		usuarioDAO = new UsuarioDAO(session, Usuario.class);
		
		Usuario p = this.usuarioDAO.pesquisaPessoaByNome(nome);
		
		tx.commit();
		session.close();
		
		return p; 
	}
	
	public Usuario procuraByEmail(String email){
		sf = new AnnotationConfiguration().configure().buildSessionFactory(); 
		session = sf.openSession();
		tx = session.beginTransaction();
		usuarioDAO = new UsuarioDAO(session, Usuario.class);

		Usuario p = this.usuarioDAO.pesquisaPessoaByEmail(email);
		
		tx.commit();
		session.close();
		
		return p; 
	}
	
	public boolean autentica(String nome, String senha){
		boolean autenticado; 
		
		sf = new AnnotationConfiguration().configure().buildSessionFactory(); 
		session = sf.openSession();
		tx = session.beginTransaction();
		usuarioDAO = new UsuarioDAO(session, Usuario.class);

		autenticado = this.usuarioDAO.verificaEmailSenha(nome, senha);
		
		tx.commit();
		session.close();
		
		return autenticado; 
	} 
}