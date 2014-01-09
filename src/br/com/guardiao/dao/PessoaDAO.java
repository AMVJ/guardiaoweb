package br.com.guardiao.dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import br.com.guardiao.modelo.Pessoa;

public class PessoaDAO extends DAO<Pessoa> {

	private Logger logger = Logger.getLogger(PessoaDAO.class);

	public PessoaDAO(Session session, Class<?> classe) {
		super(session, classe);
	}
	
	public Pessoa pesquisaPessoaById(Long idPessoa) {
		logger.info("pesquisaPessoaById : " + idPessoa);
		return (Pessoa) session.load(Pessoa.class, idPessoa);
	}
	
	public Pessoa pesquisaPessoaByNome(String nome) {
		logger.info("pesquisaPessoaByNome : " + nome);
		Criteria c = session.createCriteria(Pessoa.class);
		c.add(Restrictions.ilike("nmPessoa", "%" + nome + "%"));

		return (Pessoa)c.uniqueResult();
	}
	
	public Pessoa pesquisaPessoaByEmail(String email) {
		logger.info("pesquisaPessoaByEmail : " + email);
		Criteria c = session.createCriteria(Pessoa.class);
		c.add(Restrictions.ilike("email", email + "%"));

		return (Pessoa)c.uniqueResult();
	}
	
	@SuppressWarnings("unchecked")
	public List<Pessoa> pesquisaPessoas(String nome){
		Criteria c = session.createCriteria(Pessoa.class);
		c.add(Restrictions.ilike("nmPessoa", "%" + nome + "%"));
		c.addOrder(Order.asc("nmPessoa"));
		
		return c.list();
	}
	
	public boolean verificaEmailSenha(Long cpf, Long rg){
		boolean valid = false;
		
		System.out.println("DAO metodo isValidLoginAndPassword...");
		System.out.println("DAO session.isOpen() >>> " + session.isOpen());
		
		Query query = session.createQuery("select p from Pessoa p where p.nrCpf = :cpf_param and p.nrRg = :rg_param");
		query.setLong("cpf_param", cpf);
		query.setLong("rg_param", rg);
		
		Pessoa pessoa = (Pessoa) query.uniqueResult();

		if(pessoa != null){
			valid = true;
		}
	
		System.out.println("DAO Pessoa >>> " + pessoa);

		return valid; 
	}
	
	/**
	 * Exemplo utilizando HQL 
	 * @param id
	 * @return
	 */
	public Pessoa buscaPessoa(Long id){
		Query q = session.createQuery("select p from " + Pessoa.class.getName() + " as p where p.id like :id");
		
		q.setParameter("id", id);
		
		return (Pessoa)q.uniqueResult();
	}
}