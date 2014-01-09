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
		<a4j:keepAlive beanName="pessoaMB" />
		<h:messages/>
	
		 <fieldset>
	        <legend>Pesquisa de Pessoas</legend>
			<h:panelGrid columns="2">
			
			    <h:outputLabel for="nomeLabel" value="Digite o nome: " />
				<h:inputText id="nomeInput" value="#{pessoaMB.pessoa.nmPessoa}" style=" width : 321px;" />

				<h:commandButton value="Pesquisar" action="#{pessoaMB.pesquisaByNome}" styleClass="botoes"/>
				<h:commandButton value="Voltar" immediate="true" action="toIndex" styleClass="botoes"/>
    		</h:panelGrid>
			
			<h:panelGrid columns="2" id="panelGridInputs">
				<h:outputLabel for="nome" value="Nome "  />
				<h:inputText id="nome" readonly="true" value="#{pessoaMB.pessoa.nmPessoa}" style=" width : 254px;"/>
				
				<h:outputLabel for="endereco" value="Endereço "  />
				<h:inputText id="endereco" readonly="true" value="#{pessoaMB.pessoa.dsEndereco}" style=" width : 249px;"/>
				
				<h:outputLabel for="cpf" value="CPF "  />
				<h:inputText id="cpf" readonly="true" validatorMessage="CPF inválido!" value="#{pessoaMB.pessoa.nrCpf}" size="60" style=" width : 106px;"/>
				
			</h:panelGrid>
	    </fieldset>
	</h:form>
</f:view>
</body>
</html>
