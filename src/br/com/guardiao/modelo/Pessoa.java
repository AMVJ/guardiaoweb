package br.com.guardiao.modelo;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="pessoa", schema="public")
public class Pessoa implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="pessoa_seq", sequenceName="pessoa_cd_pessoa_seq", allocationSize=1)  
    @GeneratedValue(strategy=GenerationType.AUTO, generator="pessoa_seq")
	@Column(name="cd_pessoa")
	private Long cdPessoa;

	@Column(name="nr_cpf")
	private Long nrCpf;

	@Column(name="nr_rg")
	private Long nrRg;
	
	@Column(name="nm_pessoa")
	private String nmPessoa;
	
	@Temporal(TemporalType.DATE)
	@Column(name="dt_nascimento")
	private Date dtNascimento;
	
	@Column(name="ds_endereco")
	private String dsEndereco;

	@Column(name="nr_endereco")
	private Long nrEndereco;
	
	@Column(name="ds_bairro")
	private String dsBairro;

	public Long getCdPessoa() {
		return cdPessoa;
	}

	public void setCdPessoa(Long cdPessoa) {
		this.cdPessoa = cdPessoa;
	}

	public Long getNrCpf() {
		return nrCpf;
	}

	public void setNrCpf(Long nrCpf) {
		this.nrCpf = nrCpf;
	}

	public Long getNrRg() {
		return nrRg;
	}

	public void setNrRg(Long nrRg) {
		this.nrRg = nrRg;
	}

	public String getNmPessoa() {
		return nmPessoa;
	}

	public void setNmPessoa(String nmPessoa) {
		this.nmPessoa = nmPessoa;
	}

	public Date getDtNascimento() {
		return dtNascimento;
	}

	public void setDtNascimento(Date dtNascimento) {
		this.dtNascimento = dtNascimento;
	}

	public String getDsEndereco() {
		return dsEndereco;
	}

	public void setDsEndereco(String dsEndereco) {
		this.dsEndereco = dsEndereco;
	}

	public String getDsBairro() {
		return dsBairro;
	}

	public void setDsBairro(String dsBairro) {
		this.dsBairro = dsBairro;
	}
	
	@Override
	public int hashCode(){
		return this.getNmPessoa().length() * 23;
	}
	
	@Override
	public String toString(){
		return nmPessoa; 
	}

	@Override
	public boolean equals(Object obj){
		if( (obj instanceof Pessoa) && ( ((Pessoa)obj).getNrCpf().equals(this.nrCpf)) ){
			return true; 
		}else{
			return false; 
		}
	}

	public Long getNrEndereco() {
		return nrEndereco;
	}

	public void setNrEndereco(Long nrEndereco) {
		this.nrEndereco = nrEndereco;
	}
	
}
