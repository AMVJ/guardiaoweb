package br.com.guardiao.facade;

import java.util.List;

import br.com.guardiao.modelo.Camera;

public interface CameraFacade extends BaseFacade<Camera>{
	public void salva(Camera p);

	public void remove(Camera p);
	
	public Camera procura(Long id);

	public void atualiza(Camera p);
	
	public List<Camera> pesquisaCamerasByNome(String nome);
	
	public boolean autentica(Long cpf, Long rg);
}