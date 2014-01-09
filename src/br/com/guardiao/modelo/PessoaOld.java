package br.com.guardiao.modelo;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="pessoa")
public class PessoaOld implements Serializable {
	
	private static final long serialVersionUID = 2174678509151116408L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="pessoa_id")
	private Long id;
	
	@Column(name="nome")
	private String nome; 
	
	@Column(name="email")
	private String email;
	
	@Column(name="senha")
	private String senha;

	@Column(name="cpf")
	private String cpf;
	
	@Temporal(TemporalType.DATE)
	@Column(name="data_nasc")
	private Date dataNascimento;

	@Column(name="tel_cel")
	private String telefoneCelular;

	public void setId(Long id) {
		this.id = id;
	}

	public Long getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		System.out.println("Pessoa >> nome : "  + this.nome);
		
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getTelefoneCelular() {
		return telefoneCelular;
	}

	public void setTelefoneCelular(String telefoneCelular) {
		this.telefoneCelular = telefoneCelular;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	@Override
	public int hashCode(){
		return this.nome.length() * 23;
	}
	
	@Override
	public String toString(){
		return nome; 
	}

	@Override
	public boolean equals(Object obj){
		if( (obj instanceof PessoaOld) && ( ((PessoaOld)obj).getCpf().equals(this.cpf)) ){
			return true; 
		}else{
			return false; 
		}
	}
}