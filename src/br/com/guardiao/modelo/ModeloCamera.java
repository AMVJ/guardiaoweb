package br.com.guardiao.modelo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="modelo_camera")
public class ModeloCamera implements Serializable {

private static final long serialVersionUID = 1L;

@Id
@SequenceGenerator(name="modelo_camera_seq", sequenceName="modelo_camera_cd_modelo_camera_seq", allocationSize=1)  
@GeneratedValue(strategy=GenerationType.AUTO, generator="modelo_camera_seq")
@Column(name="cd_modelo_camera")
private Long cdModeloCamera;

@Column(name="ds_modelo_camera")
private String dsModeloCamera; 

@Column(name="ds_fabricante")
private String dsFabricante;

public Long getCdModeloCamera() {
	return cdModeloCamera;
}

public void setCdModeloCamera(Long cdModeloCamera) {
	this.cdModeloCamera = cdModeloCamera;
}

public String getDsModeloCamera() {
	return dsModeloCamera;
}

public void setDsModeloCamera(String dsModeloCamera) {
	this.dsModeloCamera = dsModeloCamera;
}

public String getDsFabricante() {
	return dsFabricante;
}

public void setDsFabricante(String dsFabricante) {
	this.dsFabricante = dsFabricante;
} 

}
