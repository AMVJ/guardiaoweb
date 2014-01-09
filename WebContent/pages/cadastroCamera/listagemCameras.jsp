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
		<a4j:keepAlive beanName="cameraMB" />
			<fieldset><legend>Camera</legend> 

			<rich:dataTable value="#{cameraMB.cameras}" var="lista" rows="10" id="listas" width="100%" cellspacing="0" cellpadding="0" border="1">	
				<h:column>
					<f:facet name="header">
						<h:outputText value="NOME" />
					</f:facet>
					<h:outputText value="#{lista.nmCamera}" />
				</h:column>
	
				<h:column>
					<f:facet name="header">
						<h:outputText value="LOGIN" />
					</f:facet>
					<h:outputText value="#{lista.nmLoginCamera}" />
				</h:column>
	
				<h:column>
					<f:facet name="header">
						<h:outputText value="FTP" />
					</f:facet>
					<h:outputText value="#{lista.dsFtpCamera}" />
				</h:column>

				<h:column>
					<f:facet name="header">
						<h:outputText value="Status" />
					</f:facet>
					<h:commandButton value="teste" action="#{ftpMB.conectarFtp}" >
						 <f:setPropertyActionListener target="#{ftpMB.camera}" value="#{lista}" />
					</h:commandButton>
				</h:column>
			
		 		<f:facet name="footer">
					<rich:datascroller />
				</f:facet>
			</rich:dataTable>
		</fieldset>
				
	</h:form>
</f:view>
</body>
</html>