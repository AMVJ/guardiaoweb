package br.com.guardiao.pessoa.test;

import static org.junit.Assert.*;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import br.com.guardiao.dao.DAO;
import br.com.guardiao.modelo.Pessoa;

public class PessoaTest{
	private static Pessoa PESSOA_TESTE = new Pessoa();

	SessionFactory sf;
	Session session;
	Transaction tx;
	DAO<Pessoa> dao;

	@Before
	public void runBeforeEveryTest(){
		sf = new AnnotationConfiguration().configure().buildSessionFactory();
		session = sf.openSession();
		tx = session.beginTransaction();
		dao = new DAO<Pessoa>(session, Pessoa.class);
	}

	@After
	public void runAfterEveryTest(){
		tx.commit();
		session.close();
	}

	@Test
	public void testCadastra(){
		PESSOA_TESTE.setNmPessoa("Ramon Melo");
		PESSOA_TESTE.setNrCpf(12345678910L);
		PESSOA_TESTE.setDsEndereco("AAAA 12331231");

		dao.save(PESSOA_TESTE);
	}

	@Test
	public void testProcura() {
		Pessoa buscada; 

		buscada = dao.load(PESSOA_TESTE.getCdPessoa()); 

		assertEquals(PESSOA_TESTE.getCdPessoa(), buscada.getCdPessoa());
		assertEquals(PESSOA_TESTE.getNmPessoa(), buscada.getNmPessoa());
	}

	@Test
	public void testAtualiza(){
		Pessoa buscadoParaAtualizacao;
	    Pessoa buscadoAposAtualizacao;

	    buscadoParaAtualizacao = dao.load(PESSOA_TESTE.getCdPessoa());
	    buscadoParaAtualizacao.setNmPessoa("Nome modificado");

	    dao.merge(buscadoParaAtualizacao); 

	    buscadoAposAtualizacao = dao.load(PESSOA_TESTE.getCdPessoa());
	    assertEquals(buscadoParaAtualizacao.getCdPessoa(), buscadoAposAtualizacao.getCdPessoa());
	}

//	@Test
//	public void testRemove(){
//		Pessoa pessoa = PESSOA_TESTE;
//		pessoa.setId(1l);
//		dao.delete(pessoa);
//	}
}