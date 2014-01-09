package br.com.guardiao.facade;

import java.util.List;

import br.com.guardiao.modelo.Pessoa;

public interface PessoaFacade extends BaseFacade<Pessoa>{
	public void salva(Pessoa p);

	public void remove(Pessoa p);
	
	public Pessoa procura(Long id);

	public void atualiza(Pessoa p);
	
	public List<Pessoa> pesquisaPessoasByNome(String nome);
	
	public boolean autentica(Long cpf, Long rg);
}