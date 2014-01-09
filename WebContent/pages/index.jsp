<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@ taglib prefix="a4j" uri="http://richfaces.org/a4j"%>
<%@ taglib prefix="rich" uri="http://richfaces.org/rich"%>



<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="StyleSheet" type="text/css" href="/jsf/style/estilos.css" media="screen" />
<script type="text/javascript" src="/jsf/resources/jquery.maskedinput-1.2.1.js"></script>
 <style>
        .optionList {
          height:22px;
        }
        .vertical-menu-cell {
            padding:0px 4px 0px 4px;
        }
    
    </style>
</head>

<body>
<f:view>
	<h:form>
		<h:messages styleClass="alertaMensagem" />
		<fieldset style="width:300px;">
			<legend>PRINCIPAL</legend> 
			
			<h:panelGrid styleClass="vertical-menu-cell" columnClasses="optionList" columns="1" cellspacing="0" cellpadding="0">
            <rich:dropDownMenu style="border:1px solid #{a4jSkin.panelBorderColor}" value="Cadastro"
                        submitMode="none" direction="bottom-right" jointPoint="tr">
                <rich:menuItem value="Camera"  action="toCadastraCamera" submitMode="ajax"/>
                <rich:menuItem value="Pessoa"  action="toCadastraPessoa" submitMode="ajax"/>
                <rich:menuItem value="Usuario" action="toCadastraUsuario" submitMode="ajax" target="teste"/>
            </rich:dropDownMenu>
            <rich:dropDownMenu style="border:1px solid #{a4jSkin.panelBorderColor}" value="Consulta"
                        submitMode="none" direction="bottom-right" jointPoint="tr">
                <rich:menuItem value="Pesquisar pessoa" action="toPesquisaPessoa" submitMode="ajax"/>
                <rich:menuItem value="Pesquisar Camera" action="toListagemCamera" submitMode="ajax"/>
            </rich:dropDownMenu>
            <rich:dropDownMenu style="border:1px solid #{a4jSkin.panelBorderColor}" value="FTP"
                        submitMode="none" direction="bottom-right" jointPoint="tr">
                <rich:menuItem value="Conectar" action="toConectarFtp" submitMode="ajax"/>
                <rich:menuItem value="Conectar" action="toListagemCamera" submitMode="ajax"/>
            </rich:dropDownMenu>
			<h:commandLink value="Sair" action="#{pessoaMB.logout}" />
            </h:panelGrid>
			
		</fieldset>
	</h:form>
</f:view>
</body>
</html>