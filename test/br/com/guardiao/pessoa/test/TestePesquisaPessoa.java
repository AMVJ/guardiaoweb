package br.com.guardiao.pessoa.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;

import br.com.guardiao.dao.PessoaDAO;
import br.com.guardiao.modelo.Pessoa;

public class TestePesquisaPessoa{
	public static void main(String[] args) {
		SessionFactory sf= new AnnotationConfiguration().configure().buildSessionFactory(); 
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		
		PessoaDAO pessoaDAO = new PessoaDAO(session, Pessoa.class);

		for(Pessoa p : pessoaDAO.pesquisaPessoas("")){
			System.out.println(p);
		}

		tx.commit();
		session.close();
	}
}