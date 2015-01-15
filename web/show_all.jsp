<%-- 
    Document   : show_all
    Created on : Jan 2, 2015, 10:44:50 PM
    Author     : NgoVietLinh
--%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<f:view>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title><h:outputText value="Project Track-Inbox"/></title>
        <link rel="stylesheet" type="text/css"
              href="stylesheet/stylesheet.css"/>
    </head>
    <body class="page-background">
        <jsp:include page="header.jsp"/>
        <h:form>
            <h:panelGrid headerClass="page-heafer" styleClass="table- background"
                         columns="1" cellpadding="5">
                <f:facet name="header">
                    <h:outputText value="Show all projects"/>
                </f:facet>
                <h:outputText value="Application messages" styleClass="error"/>
                <h:panelGrid columns="5" styleClass="table-background"
                             rowClasses="table-odd-row, table-even-row"
                             cellpadding="3">
                    <h:commandLink styleClass="table-header">
                        <h:outputText value="Project name"/>                        
                    </h:commandLink>
                    <h:commandLink styleClass="table-header">
                        <h:outputText value="Type"/>
                    </h:commandLink>
                    <h:commandLink styleClass="table-header">
                        <h:outputText value="Status"/>
                    </h:commandLink>
                    <h:commandLink styleClass="table-header">
                        <h:outputText value="Waiting for"/>
                    </h:commandLink>
                    <h:panelGroup/>
                    
                    <h:outputText value="Inventory Manager 2.0"/>
                    <h:outputText value="Internal Desktop Application"/>
                    <h:outputText value="Requirements, Analysis"/>
                    <h:outputText value="Bussiness Analyst"/>                    
                    <h:commandLink action="details">
                        <h:outputText value="Details"/>
                    </h:commandLink>
                    
                    <h:outputText value="TimeTracker"/>
                    <h:outputText value="Internal Web Application"/>
                    <h:outputText value="Requirement/Analysis"/>
                    <h:outputText value="Development Manager"/>                                        
                    <h:commandLink action="details">
                        <h:outputText value="Details"/>
                    </h:commandLink>
                </h:panelGrid>
                
            </h:panelGrid>
        </h:form>
    </body>
</html>
</f:view>
