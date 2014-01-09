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
	
		<h:panelGrid columns="1" rendered="#{pessoaMB.exibeMensagem}" >
			<h:outputLabel id="oplMensagem" value="#{pessoaMB.mensagem}" styleClass="alertaMensagem" />
		</h:panelGrid>
		 <fieldset>
	        <legend>Cadastro de Pessoa</legend>
		        <a4j:region id="regiaoAjax">
					<a4j:status id="sts">
	                    <f:facet name="start">
	            		     <h:graphicImage value="/images/ajax-loader.gif" />
	               		</f:facet>
	                </a4j:status>
	            </a4j:region>
	        
				<h:panelGrid columns="2" id="inputs">
					<h:outputLabel for="nome" value="Nome "  />
					<h:inputText id="nome" value="#{pessoaMB.pessoa.nmPessoa}" styleClass="edit" size="40" />

					<h:outputLabel for="endereco" value="Endereço "  />
					<h:inputText id="endereco" value="#{pessoaMB.pessoa.dsEndereco}" required="true" requiredMessage="Campo endereço obrigatório!" styleClass="edit" size="100">
					</h:inputText>

					<h:outputLabel for="rg" value="RG "  />
					<h:inputText id="rg" value="#{pessoaMB.pessoa.nrRg}" required="true" requiredMessage="Campo RG obrigatório!" styleClass="edit" size="30"/>
						
					<h:outputLabel for="cpf" value="CPF "  />
					<h:inputText id="cpf" value="#{pessoaMB.pessoa.nrCpf}" styleClass="edit" size="11">
					</h:inputText>

					<h:outputLabel for="dataNasc" value="Data Nascimento "  />
					<rich:calendar datePattern="dd/MM/yyyy" value="#{pessoaMB.pessoa.dtNascimento}" style="width:200px" styleClass="edit" />  

					<h:commandButton value="Inserir" action="#{pessoaMB.save}"  styleClass="botoes"/>
					<a4j:commandButton value="Voltar" immediate="true" action="toIndex" styleClass="botoes"/>
		    	</h:panelGrid>
		    </fieldset>
	</h:form>
</f:view>
</body>
</html>