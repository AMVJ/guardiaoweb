package br.com.guardiao.dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import br.com.guardiao.modelo.Usuario;

public class UsuarioDAO extends DAO<Usuario> {

	private Logger logger = Logger.getLogger(UsuarioDAO.class);

	public UsuarioDAO(Session session, Class<?> classe) {
		super(session, classe);
	}
	
	public Usuario pesquisaPessoaById(Long idPessoa) {
		logger.info("pesquisaPessoaById : " + idPessoa);
		return (Usuario) session.load(Usuario.class, idPessoa);
	}
	
	public Usuario pesquisaPessoaByNome(String nome) {
		logger.info("pesquisaPessoaByNome : " + nome);
		Criteria c = session.createCriteria(Usuario.class);
		c.add(Restrictions.ilike("nmPessoa", "%" + nome + "%"));

		return (Usuario)c.uniqueResult();
	}
	
	public Usuario pesquisaPessoaByEmail(String email) {
		logger.info("pesquisaPessoaByEmail : " + email);
		Criteria c = session.createCriteria(Usuario.class);
		c.add(Restrictions.ilike("email", email + "%"));

		return (Usuario)c.uniqueResult();
	}
	
	@SuppressWarnings("unchecked")
	public List<Usuario> pesquisaPessoas(String nome){
		Criteria c = session.createCriteria(Usuario.class);
		c.add(Restrictions.ilike("nmPessoa", "%" + nome + "%"));
		c.addOrder(Order.asc("nmPessoa"));
		
		return c.list();
	}
	
	public boolean verificaEmailSenha(String nome, String senha){
		boolean valid = false;
		
		System.out.println("DAO metodo isValidLoginAndPassword...");
		System.out.println("DAO session.isOpen() >>> " + session.isOpen());
		
		Query query = session.createQuery("select p from Usuario p where p.nmLogin = :nome_param and p.dsSenha = :senha_param");
		query.setString("nome_param", nome);
		query.setString("senha_param", senha);
		
		Usuario usuario = (Usuario) query.uniqueResult();

		if(usuario != null){
			valid = true;
		}
	
		System.out.println("DAO Usuario >>> " + usuario);

		return valid; 
	}
	
	/**
	 * Exemplo utilizando HQL 
	 * @param id
	 * @return
	 */
	public Usuario buscaUsuario(Long id){
		Query q = session.createQuery("select p from " + Usuario.class.getName() + " as p where p.id like :id");
		
		q.setParameter("id", id);
		
		return (Usuario)q.uniqueResult();
	}
}