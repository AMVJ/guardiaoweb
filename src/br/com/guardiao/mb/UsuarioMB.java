package br.com.guardiao.mb;

import java.io.IOException;
import java.io.Serializable;
import java.util.List;

import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.guardiao.facade.UsuarioFacade;
import br.com.guardiao.facade.UsuarioFacadeImpl;
import br.com.guardiao.modelo.Usuario;

public class UsuarioMB implements Serializable {
	
	private static final long serialVersionUID = -333995781063775201L;

	private Usuario usuario = new Usuario();
	private String mensagem;
	private Long id;
	private Boolean exibeMensagem;

	public UsuarioMB(){
		System.out.println(" >>>>>>>>>>>>>>>>>>>> Contrutor do Usuario_MB <<<<<<<<<<<<<<<<<<");
		
			this.usuario = new Usuario(); 
	}
	
	public String login() throws Exception{
        boolean logado = false;
        HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
        HttpServletResponse rp = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
        HttpServletRequest rq = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
        UsuarioFacade UsuarioService = new UsuarioFacadeImpl();
		
        logado = UsuarioService.autentica(this.usuario.getNmLogin(), this.usuario.getDsSenha());
           
        if(logado){
            session.setAttribute("user", logado);
            rp.sendRedirect(rq.getContextPath() + "/pages/index.jsf");
            usuario = new Usuario();
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
		UsuarioFacade usuarioService = new UsuarioFacadeImpl();

		exibeMensagem=true;
		try {
			setMensagem("Usuario criado com sucesso.");
			usuarioService.salva(this.usuario);
		} catch (Exception e) {
			setMensagem("Não foi possivel criar o usuario.");
		}
		
		this.usuario = new Usuario(); 
		return "cadastraSucesso";
	}

	public String delete(){
		UsuarioFacade usuarioService = new UsuarioFacadeImpl();
		this.usuario.setCdUsuario(id);
		usuarioService.remove(this.usuario);
		this.usuario = new Usuario(); 
		
		
		return "removeSucesso";
	}
	
	public String merge(){
		UsuarioFacade UsuarioService = new UsuarioFacadeImpl();
		UsuarioService.atualiza(this.usuario);
		this.usuario = new Usuario(); 

		return "atualizaSucesso";
	}
	
	public String load(){
		UsuarioFacade UsuarioService = new UsuarioFacadeImpl();
		this.usuario = UsuarioService.procura(this.id);
		
		return "pesquisaSucesso";
	}

	public String pesquisaByNome(){
		UsuarioFacadeImpl UsuarioService = new UsuarioFacadeImpl();
		this.usuario = UsuarioService.procuraByNome(this.usuario.getNmLogin());
		
		return "pesquisaByNomeSucesso";
	}
	
	public List<Usuario> getUsuarios(){
		UsuarioFacade UsuarioService = new UsuarioFacadeImpl();		
		
		return UsuarioService.lista();
	}

	public List<Usuario> getUsuariosByNome(){ 
		UsuarioFacade UsuarioService = new UsuarioFacadeImpl();

		List<Usuario> lista = UsuarioService.pesquisaUsuarioByNome(this.usuario.getNmLogin());
	
		return lista;
	}
	
	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario Usuario) {
		this.usuario = Usuario;
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