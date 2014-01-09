package br.com.guardiao.modelo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="camera")
public class Camera implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="camera_seq", sequenceName="camera_cd_camera_seq", allocationSize=1)  
	@GeneratedValue(strategy=GenerationType.AUTO, generator="camera_seq")
	@Column(name="cd_camera")
	private Long cdCamera;
	
	@Id
	@Column(name="cd_usuario")
	private Long cdUsuario;

	@ManyToOne
	@JoinColumn(name="cd_modelo_camera")
	private ModeloCamera modeloCamera;
	
	@Column(name="nm_camera")
	private String nmCamera;
	
	@Column(name="ds_ftp_camera")
	private String dsFtpCamera;

	@Column(name="nm_login_camera")
	private String nmLoginCamera;
	
	@Column(name="ds_senha_camera")
	private String dsSenhaCamera;

	public Long getCdCamera() {
		return cdCamera;
	}

	public void setCdCamera(Long cdCamera) {
		this.cdCamera = cdCamera;
	}

	public ModeloCamera getModeloCamera() {
		return modeloCamera;
	}

	public void setModeloCamera(ModeloCamera modeloCamera) {
		this.modeloCamera = modeloCamera;
	}

	public String getNmCamera() {
		return nmCamera;
	}

	public void setNmCamera(String nmCamera) {
		this.nmCamera = nmCamera;
	}

	public String getDsFtpCamera() {
		return dsFtpCamera;
	}

	public void setDsFtpCamera(String dsFtpCamera) {
		this.dsFtpCamera = dsFtpCamera;
	}

	public String getNmLoginCamera() {
		return nmLoginCamera;
	}

	public void setNmLoginCamera(String nmLoginCamera) {
		this.nmLoginCamera = nmLoginCamera;
	}

	public String getNmSenhaCamera() {
		return dsSenhaCamera;
	}

	public void setNmSenhaCamera(String nmSenhaCamera) {
		this.dsSenhaCamera = nmSenhaCamera;
	}

	
}
