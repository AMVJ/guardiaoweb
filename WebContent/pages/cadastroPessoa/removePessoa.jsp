<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@ taglib prefix="rich" uri="http://richfaces.ajax4jsf.org/rich"%>
<%@ taglib prefix="a4j" uri="http://richfaces.org/a4j"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<link rel="StyleSheet" type="text/css" href="/jsf/style/estilos.css" media="screen" />
</head>

<body>
<f:view>
	<h:form>
			<fieldset><legend>Remoção de Pessoas</legend> 
			<rich:dataTable value="#{pessoaMB.pessoas}" var="fisica" rows="10" id="fisicas" width="100%" cellspacing="0" cellpadding="0" border="1">	
				<h:column>
					<f:facet name="header">
						<h:outputText value="NOME" />
					</f:facet>
					<h:outputText value="#{fisica.nome}" />
				</h:column>
	
				<h:column>
					<f:facet name="header">
						<h:outputText value="E-MAIL" />
					</f:facet>
					<h:outputText value="#{fisica.email}" />
				</h:column>
	
				<h:column>
					<f:facet name="header">
						<h:outputText value="CPF" />
					</f:facet>
					<h:outputText value="#{fisica.cpf}" />
				</h:column>
			
				<h:column>
					<f:facet name="header">
						<h:outputText value="DATA NASC." />
					</f:facet>
					<h:outputText value="#{fisica.dataNascimento}">
						<f:convertDateTime pattern="dd/MM/yyyy" />
					</h:outputText>
				</h:column>
			 
				<h:column>
					<f:facet name="header">
						<h:outputText value="CELULAR" />
					</f:facet>
					<h:outputText value="#{fisica.telefoneCelular}" />
				</h:column>
	
				<h:column>
					<f:facet name="header">
						<h:outputText value="Exclusão"/>
					</f:facet>
			
					<a4j:commandLink action="#{pessoaMB.delete}" status="sts" reRender="fisicas" >
						<h:outputText value="Excluir"/>
						<f:setPropertyActionListener value="#{fisica.id}" target="#{pessoaMB.id}" />
					</a4j:commandLink>
				</h:column>
	 			
		 		<f:facet name="footer">
					<rich:datascroller />
				</f:facet>
			</rich:dataTable>
			
			 <a4j:region id="regiaoAjax">
			 	<a4j:status id="sts">
	            	<f:facet name="start">
	            		<h:graphicImage value="/images/ajax-loader.gif" />
	               	</f:facet>
	            </a4j:status>
	         </a4j:region>
			
			<h:commandButton value="Voltar" immediate="true" action="toIndex" styleClass="botoes"/>
		</fieldset>
	</h:form>
</f:view>
</body>
</html>