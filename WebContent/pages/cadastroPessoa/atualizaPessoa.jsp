<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@ taglib prefix="rich" uri="http://richfaces.ajax4jsf.org/rich"%>
<%@ taglib prefix="a4j" uri="http://richfaces.org/a4j"%>
<%@ taglib prefix="stella" uri="http://stella.caelum.com.br/faces"%>

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
		<a4j:keepAlive beanName="pessoaMB" />
			<fieldset><legend>Atualização de Dados</legend> 

			<rich:dataTable value="#{pessoaMB.pessoas}" var="fisica" rows="10" id="fisicas" width="100%" cellspacing="0" cellpadding="0" border="1">	
				<h:column>
					<f:facet name="header">
						<h:outputText value="NOME" />
					</f:facet>
					<h:outputText value="#{fisica.nmPessoa}" />
				</h:column>
	
				<h:column>
					<f:facet name="header">
						<h:outputText value="CPF" />
					</f:facet>
					<h:outputText value="#{fisica.dsEndereco}" />
				</h:column>
	
				<h:column>
					<f:facet name="header">
						<h:outputText value="CPF" />
					</f:facet>
					<h:outputText value="#{fisica.nrCpf}" />
				</h:column>
			
				<h:column>
					<f:facet name="header">
						<h:outputText value="RG" />
					</f:facet>
					<h:outputText value="#{fisica.nrRg}">
					</h:outputText>
				</h:column>
	
		 		<f:facet name="footer">
					<rich:datascroller />
				</f:facet>
			</rich:dataTable>
			
			<rich:messages/>
			
    	    <a4j:region id="regiaoAjax">
			 	<a4j:status id="sts">
	            	<f:facet name="start">
	            		<h:graphicImage value="/images/ajax-loader.gif" />
	               	</f:facet>
	            </a4j:status>
	        </a4j:region>

			<h:panelGrid columns="2" id="panelGridInputs">
				<h:outputLabel for="nome" value="Nome "  />
				<h:inputText id="nome" value="#{pessoaMB.pessoa.nmPessoa}" style=" width : 254px;"/>
				
				<h:outputLabel for="endereco" value="Endereço "  />
				<h:inputText id="endereco" value="#{pessoaMB.pessoa.dsEndereco}" style=" width : 249px;">
				</h:inputText>
				
				<h:outputLabel for="cpf" value="CPF "  />
				<h:inputText id="cpf" value="#{pessoaMB.pessoa.nrCpf}" size="60" style=" width : 106px;">
				</h:inputText>
				
				<h:outputLabel for="rg" value="RG "  />
				<h:inputSecret id="rg" value="#{pessoaMB.pessoa.nrRg}" size="30"/>
				
				<a4j:commandButton value="Atualizar" action="#{pessoaMB.merge}" styleClass="botoes" status="sts" reRender="fisicas"/>
				<a4j:commandButton value="Voltar" immediate="true" action="toIndex" styleClass="botoes"/>
			</h:panelGrid>
		</fieldset>
				
	</h:form>
</f:view>
</body>
</html>