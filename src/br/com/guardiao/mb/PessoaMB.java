package br.com.guardiao.mb;

import java.io.IOException;
import java.io.Serializable;
import java.util.List;

import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.guardiao.facade.PessoaFacade;
import br.com.guardiao.facade.PessoaFacadeImpl;
import br.com.guardiao.modelo.Pessoa;

public class PessoaMB implements Serializable {
	
	private static final long serialVersionUID = -333995781063775201L;

	private Pessoa pessoa = new Pessoa();
	private String mensagem;
	private Boolean exibeMensagem;
	private Long id;

	public PessoaMB(){
		System.out.println(" >>>>>>>>>>>>>>>>>>>> Contrutor do PESSOA_MB <<<<<<<<<<<<<<<<<<");
		
			this.pessoa = new Pessoa(); 
	}
	
	public String login() throws Exception{
        boolean logado = false;
        HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
        HttpServletResponse rp = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
        HttpServletRequest rq = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
        PessoaFacade pessoaService = new PessoaFacadeImpl();
		
        logado = pessoaService.autentica(this.pessoa.getNrCpf(), this.pessoa.getNrRg());
           
        if(logado){
            session.setAttribute("user", logado);
            rp.sendRedirect(rq.getContextPath() + "/pages/index.jsf");
            return "success";
        }else{
            session.setAttribute("user", null);
            session.removeAttribute("user");
            rp.sendRedirect(rq.getContextPath() + "/pages/login/login.jsf");
            return "failure";
        }
    }
	
	public String logout() {
		HttpServletRequest rq = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
		HttpServletResponse rp = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
		FacesContext facesContext = FacesContext.getCurrentInstance();
		HttpSession session = (HttpSession) facesContext.getExternalContext().getSession(false);
		session.invalidate();
		try {
			rp.sendRedirect(rq.getContextPath() + "/pages/login/login.jsf");
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return "logoutOk";
	}
	
	public String save(){
		PessoaFacade pessoaService = new PessoaFacadeImpl();
		setExibeMensagem(true);				
		try {
			setMensagem("Cidadão criado com sucesso.");
			pessoaService.salva(this.pessoa);
		} catch (Exception e) {
			setMensagem("Cidadão não inserido.");
		}
		this.pessoa = new Pessoa(); 
		return "cadastraSucesso";
	}

	public String delete(){
		PessoaFacade pessoaService = new PessoaFacadeImpl();
		this.pessoa.setCdPessoa(id);
		pessoaService.remove(this.pessoa);
		this.pessoa = new Pessoa(); 
		
		return "removeSucesso";
	}
	
	public String merge(){
		PessoaFacade pessoaService = new PessoaFacadeImpl();
		pessoaService.atualiza(this.pessoa);
		this.pessoa = new Pessoa(); 

		return "atualizaSucesso";
	}
	
	public String load(){
		PessoaFacade pessoaService = new PessoaFacadeImpl();
		this.pessoa = pessoaService.procura(this.id);
		
		return "pesquisaSucesso";
	}

	public String pesquisaByNome(){
		PessoaFacadeImpl pessoaService = new PessoaFacadeImpl();
		this.pessoa = pessoaService.procuraByNome(this.pessoa.getNmPessoa());
		
		return "pesquisaByNomeSucesso";
	}
	
	public List<Pessoa> getPessoas(){
		PessoaFacade pessoaService = new PessoaFacadeImpl();		
		
		return pessoaService.lista();
	}

	public List<Pessoa> getPessoasByNome(){ 
		PessoaFacade pessoaService = new PessoaFacadeImpl();

		List<Pessoa> lista = pessoaService.pesquisaPessoasByNome(this.pessoa.getNmPessoa());
	
		return lista;
	}
	
	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}

	public Boolean getExibeMensagem() {
		return exibeMensagem;
	}

	public void setExibeMensagem(Boolean exibeMensagem) {
		this.exibeMensagem = exibeMensagem;
	}
	
}