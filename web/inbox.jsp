<%-- 
    Document   : inbox
    Created on : Jan 2, 2015, 10:43:31 PM
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
                    <h:outputText value="Inbox- approve ỏ reject projects"/>
                </f:facet>
                <h:outputText value="Application messages" styleClass="error"/>
                <h:panelGrid columns="6" styleClass="table-background"
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
                    <h:panelGroup/>
                    <h:panelGroup/>
                    <h:panelGroup/>
                    <h:outputText value="Inventory Manager 2.0"/>
                    <h:outputText value="Internal Desktop Application"/>
                    <h:outputText value="Requirements, Analysis"/>
                    <h:commandLink action="approve">
                        <h:outputText value="Approve"/>
                    </h:commandLink>
                    <h:commandLink action="reject">
                        <h:outputText value="Reject"/>
                    </h:commandLink>
                    <h:commandLink action="details">
                        <h:outputText value="Details"/>
                    </h:commandLink>
                    <h:outputText value="TimeTracker"/>
                    <h:outputText value="Internal Web Application"/>
                    <h:outputText value="Requirement/Analysis"/>
                    <h:commandLink action="approve">
                        <h:outputText value="Approve"/>
                    </h:commandLink>
                    <h:commandLink action="reject">
                        <h:outputText value="Reject"/>
                    </h:commandLink>
                    <h:commandLink action="details">
                        <h:outputText value="Details"/>
                    </h:commandLink>
                </h:panelGrid>
                
            </h:panelGrid>
        </h:form>
    </body>
</html>
</f:view>