package br.com.guardiao.mb;

import java.io.IOException;
import java.io.Serializable;
import java.util.List;

import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.guardiao.facade.CameraFacade;
import br.com.guardiao.facade.CameraFacadeImpl;
import br.com.guardiao.modelo.Camera;

public class CameraMB implements Serializable {
	
	private static final long serialVersionUID = -333995781063775201L;

	private Camera camera = new Camera();
	private String mensagem;
	private Boolean exibeMensagem;
	private Long id;

	public CameraMB(){
		System.out.println(" >>>>>>>>>>>>>>>>>>>> Contrutor do CAMERA_MB <<<<<<<<<<<<<<<<<<");
		
			this.camera = new Camera(); 
	}
	
	public String save(){
		CameraFacade cameraService = new CameraFacadeImpl();
		setExibeMensagem(true);				
		try {
			setMensagem("Camera cadastrada com sucesso.");
			cameraService.salva(this.camera);
		} catch (Exception e) {
			setMensagem("Camera não inserida.");
		}
		this.camera = new Camera(); 
		return "cadastraSucesso";
	}

	public String delete(){
		CameraFacade cameraService = new CameraFacadeImpl();
		this.camera.setCdCamera(id);
		cameraService.remove(this.camera);
		this.camera = new Camera(); 
		
		return "removeSucesso";
	}
	
	public String merge(){
		CameraFacade cameraService = new CameraFacadeImpl();
		cameraService.atualiza(this.camera);
		this.camera = new Camera(); 

		return "atualizaSucesso";
	}
	
	public String load(){
		CameraFacade cameraService = new CameraFacadeImpl();
		this.camera = cameraService.procura(this.id);
		
		return "pesquisaSucesso";
	}

	public String pesquisaByNome(){
		CameraFacadeImpl cameraService = new CameraFacadeImpl();
		this.camera = cameraService.procuraByNome(this.camera.getNmCamera());
		
		return "pesquisaByNomeSucesso";
	}
	
	public List<Camera> getCameras(){
		CameraFacade cameraService = new CameraFacadeImpl();		
		
		return cameraService.lista();
	}

	public List<Camera> getCamerasByNome(){ 
		CameraFacade cameraService = new CameraFacadeImpl();

		List<Camera> lista = cameraService.pesquisaCamerasByNome(this.camera.getNmCamera());
	
		return lista;
	}
	
	public Camera getCamera() {
		return camera;
	}

	public void setCamera(Camera camera) {
		this.camera = camera;
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