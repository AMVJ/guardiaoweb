package br.com.guardiao.modelo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="perfil")
public class Perfil implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="cd_perfil")
	private Integer cdPerfil;

	@Column(name="ds_perfil")
	private String dsPerfil;

	public Integer getCdPerfil() {
		return cdPerfil;
	}

	public void setCdPerfil(Integer cdPerfil) {
		this.cdPerfil = cdPerfil;
	}

	public String getDsPerfil() {
		return dsPerfil;
	}

	public void setDsPerfil(String dsPerfil) {
		this.dsPerfil = dsPerfil;
	}
	
}
