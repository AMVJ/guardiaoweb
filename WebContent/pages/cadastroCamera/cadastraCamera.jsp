<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@ taglib prefix="rich" uri="http://richfaces.ajax4jsf.org/rich"%>
<%@ taglib prefix="stella" uri="http://stella.caelum.com.br/faces"%>
<%@ taglib prefix="a4j" uri="http://richfaces.org/a4j"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<link rel="StyleSheet" type="text/css" href="/jsf/style/estilos.css" media="screen" />
	<script type="text/javascript" src="/jsf/resources/jquery.maskedinput-1.2.1.js"></script>
</head>

<body>
<f:view>
	<h:form>
		<rich:messages/>
	
		<h:panelGrid columns="1" rendered="#{cameraMB.exibeMensagem}" >
			<h:outputLabel id="oplMensagem" value="#{cameraMB.mensagem}" styleClass="alertaMensagem" />
		</h:panelGrid>
		 <fieldset>
	        <legend>Cadastro de Camera</legend>
		        <a4j:region id="regiaoAjax">
					<a4j:status id="sts">
	                    <f:facet name="start">
	            		     <h:graphicImage value="/images/ajax-loader.gif" />
	               		</f:facet>
	                </a4j:status>
	            </a4j:region>
	        
				<h:panelGrid columns="2" id="inputs">
					<h:outputLabel for="nome" value="Nome "  />
					<h:inputText id="nome" value="#{cameraMB.camera.nmCamera}" styleClass="edit" size="40" requiredMessage="Nome é campo obrigatório!" />

					<h:outputLabel for="login" value="Login "  />
					<h:inputText id="login" value="#{cameraMB.camera.nmLoginCamera}" required="true" requiredMessage="Login é campo obrigatório!" styleClass="edit" size="100">
					</h:inputText>

					<h:outputLabel for="senha" value="Senha "  />
					<h:inputSecret id="senha" value="#{cameraMB.camera.nmSenhaCamera}" required="true" requiredMessage="Senha é campo obrigatório!" styleClass="edit" size="30"/>
						
					<h:outputLabel for="ftp" value="FTP "  />
					<h:inputText id="ftp" value="#{cameraMB.camera.dsFtpCamera}" required="FTP é campo obrigatório!" styleClass="edit" size="11">
					</h:inputText>

					<h:commandButton value="Inserir" action="#{cameraMB.save}"  styleClass="botoes"/>
					<a4j:commandButton value="Voltar" immediate="true" action="toIndex" styleClass="botoes"/>
		    	</h:panelGrid>
		    </fieldset>
	</h:form>
</f:view>
</body>
</html>