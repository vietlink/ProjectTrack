<%-- 
    Document   : approve
    Created on : Jan 2, 2015, 10:44:10 PM
    Author     : NgoVietLinh
--%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<f:view>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>
            <h:outputText value="ProjectTrack- Approve a project"/>
        </title>
        <link rel="stylesheet" type="text/css" href="stylesheet/stylesheet.css"/>
    </head>
    <body class="page-background">
        <jsp:include page="includes/header.jsp"/>
        <h:form>
            <h:panelGrid columns="2" cellpadding="5"
                         headerClass="page-header"
                         footerClass="project-background"
                         styleClass="project-background"
                         rowClasses="project-row">
                <f:facet name="header">
                    <h:panelGrid columns="1" 
                                 width="100%" cellpadding="3"
                                 styleClass="project-background"
                                 headerClass="page-header">
                        <f:facet name="header">
                            <h:outputText value="Approve a project"/>
                        </f:facet>
                        <h:outputText value="Application messages"
                                      styleClass="error"/>
                    </h:panelGrid>
                </f:facet>
                <h:outputText value="Name: "/>
                <h:outputText value="Inventory Manager 2.0"
                              styleClass="project-data"/>
                <h:outputText value="Type"/>
                <h:outputText value="Internal web application"
                              styleClass="project-data"/>
                <h:outputText value="Requirements contact:"/>
                <h:outputText value="Joan TooBusy"
                            styleClass="project-data"/>
                <h:outputText value="Requirements contact e-mail:"/>
                <h:outputText value="toobusy@deathmarch.com"
                        styleClass="project-data"/>
                <h:outputText value="Initial comments:"/>
                <h:outputText value="The first version
                                is horrible and completely unusable.
                                It's time to rewrite it."
                                styleClass="project-data"/>
                <h:outputLabel for="artifactSelect">
                    <h:outputText value="Completed artifact"/>
                </h:outputLabel>
                <h:selectManyCheckbox id="artifactSelect" layout="pageDirection"
                                      styleClass="project-input">
                    <f:selectItem itemValue="0" itemLabel="Proposal document"/>
                    <f:selectItem itemValue="1" itemLabel="Reuirements document"/>
                    <f:selectItem itemValue="2" itemLabel="Architecture specification"/>
                    <f:selectItem itemValue="3" itemLabel="Test plan"/>
                    <f:selectItem itemValue="4" itemLabel="Deploument guideline"/>
                    <f:selectItem itemValue="5" itemLabel="Maintainance documentation"/>
                    <f:selectItem itemValue="6" itemLabel="User documentation"/>
                </h:selectManyCheckbox>
                <f:facet name="footer">
                    <h:panelGroup>
                        <h:panelGrid columns="1" cellpadding="5"
                                     styleClass="table-background"
                                     rowClasses="table-odd-row, table-even-row">
                            <h:outputLabel for="commentsInput">
                                <h:outputText value="Your comment:"/>
                            </h:outputLabel>
                            <h:inputTextarea id="commentsInput" rows="10" cols="80"/>
                        </h:panelGrid>
                        
                        <h:panelGrid columns="2" rowClasses="table-odd-row">
                            <h:commandButton value="Approve" action="approve"/>
                            <h:commandButton value="Cancel" action="cancel" immediate="true"/>
                        </h:panelGrid>
                    </h:panelGroup>
                </f:facet>
            </h:panelGrid>
        </h:form>
    </body>
</html>
</f:view>