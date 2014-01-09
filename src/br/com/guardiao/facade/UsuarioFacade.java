package br.com.guardiao.facade;

import java.util.List;

import br.com.guardiao.modelo.Usuario;
import br.com.guardiao.modelo.Usuario;

public interface UsuarioFacade extends BaseFacade<Usuario>{
	public void salva(Usuario p);

	public void remove(Usuario p);
	
	public Usuario procura(Long id);

	public void atualiza(Usuario p);
	
	public List<Usuario> pesquisaUsuarioByNome(String nome);
	
	public boolean autentica(String nome, String senha);
}