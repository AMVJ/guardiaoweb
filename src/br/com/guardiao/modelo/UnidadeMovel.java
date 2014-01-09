package br.com.guardiao.modelo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="unidade_movel")
public class UnidadeMovel implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="cd_unidade_movel")
	private Integer cdUnidadeMovel;

	@Column(name="ds_unidade_movel")
	private String dsUnidadeMovel; 

	@Column(name="ds_placa")
	private String dsPlaca;
	
	@Column(name="nr_unidade_movel")
	private Long nrUnidadeMovel;

	public Integer getCdUnidadeMovel() {
		return cdUnidadeMovel;
	}

	public void setCdUnidadeMovel(Integer cdUnidadeMovel) {
		this.cdUnidadeMovel = cdUnidadeMovel;
	}

	public String getDsUnidadeMovel() {
		return dsUnidadeMovel;
	}

	public void setDsUnidadeMovel(String dsUnidadeMovel) {
		this.dsUnidadeMovel = dsUnidadeMovel;
	}

	public String getDsPlaca() {
		return dsPlaca;
	}

	public void setDsPlaca(String dsPlaca) {
		this.dsPlaca = dsPlaca;
	}

	public Long getNrUnidadeMovel() {
		return nrUnidadeMovel;
	}

	public void setNrUnidadeMovel(Long nrUnidadeMovel) {
		this.nrUnidadeMovel = nrUnidadeMovel;
	}
	
}
