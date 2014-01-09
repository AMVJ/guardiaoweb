package br.com.guardiao.modelo;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="usuario", schema="public")
public class Usuario implements Serializable {

	private static final long serialVersionUID = 1L;


	@Column(name="nm_login")
	private String nmLogin;

	@Column(name="cd_pessoa")
	private Long pessoa;
	
	@Column(name="ds_senha")
	private String dsSenha;

	@Temporal(TemporalType.DATE)
	@Column(name="dt_cadastro")
	private Date dtCadastro;

	@Column(name="cd_perfil")
	private Long perfil;

	@Id
	@SequenceGenerator(name="usuario_seq", sequenceName="usuario_cd_usuario_seq", allocationSize=1)  
    @GeneratedValue(strategy=GenerationType.AUTO, generator="usuario_seq")
	@Column(name="cd_usuario")
	private Long cdUsuario;

	public Long getCdUsuario() {
		return cdUsuario;
	}

	public void setCdUsuario(Long cdUsuario) {
		this.cdUsuario = cdUsuario;
	}

	public String getNmLogin() {
		return nmLogin;
	}

	public void setNmLogin(String nmLogin) {
		this.nmLogin = nmLogin;
	}

	public String getDsSenha() {
		return dsSenha;
	}

	public void setDsSenha(String dsSenha) {
		this.dsSenha = dsSenha;
	}

	public Date getDtCadastro() {
		return dtCadastro;
	}

	public void setDtCadastro(Date dtCadastro) {
		this.dtCadastro = dtCadastro;
	}

	public Long getPerfil() {
		return perfil;
	}

	public void setPerfil(Long perfil) {
		this.perfil = perfil;
	}

	public Long getPessoa() {
		return pessoa;
	}

	public void setPessoa(Long pessoa) {
		this.pessoa = pessoa;
	}

}
