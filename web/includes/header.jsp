<%-- 
    Document   : header
    Created on : Jan 2, 2015, 10:43:39 PM
    Author     : NgoVietLinh
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<!DOCTYPE html>
<html>
    <!--
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    
    <body>
        <h1>Hello World!</h1>
    </body>
    -->
    <f:subview id="header">
        <h:form>
            <h:panelGrid columns="3" cellpadding="0" cellspacing="0"
                         styleClass="header" width="100%">
                <h:panelGrid id="header" columns="9" cellpadding="4" cellspacing="4"
                             border="0">
                    <h:outputText value="Project Track" styleClass="header-header"/>
                    <h:commandLink action="inbox">
                        <h:graphicImage url="images/inbox.gif" styleClass="header-icon"
                                        alt="inbox"/>
                        <h:outputText value="Inbox" styleClass="header-command"/>
                    </h:commandLink>
                    <h:commandLink action="show_all">
                        <h:graphicImage url="images/show_all.gif"
                                        styleClass="header-icon" alt="Show all Projects"/>
                        <h:outputText value="Show all" styleClass="header-command"/>                                                
                    </h:commandLink>
                    <h:commandLink action="create">
                        <h:graphicImage url="images/create.gif" styleClass="header-icon"
                                        alt="Create new Project"/>
                        <h:outputText value="Create new" styleClass="header-command"/>
                    </h:commandLink>
                    <h:commandLink>
                        <h:graphicImage url="images/logout.gif" styleClass="header-icon"
                                        alt="Logout"/>
                        <h:outputText value="Logout" styleClass="header-command"/>
                    </h:commandLink>
                </h:panelGrid>
                <h:panelGroup>
                    <h:outputLabel for="languageSelect">
                        <h:outputText value="Language:" styleClass="language-select"/>
                    </h:outputLabel>
                    <h:selectOneListbox id="languageSelect"
                                        size="1" styleClass="language-select">
                        <f:selectItem itemLabel="English" itemValue="English"/>
                        <f:selectItem itemLabel="Russian" itemValue="Russian"/>
                    </h:selectOneListbox>
                    <h:commandButton value="Go!"
                                     styleClass="language-select-button"/>
                </h:panelGroup>
                <h:outputText value="proj_mgr" styleClass="user-name"/>
            </h:panelGrid>
        </h:form>
    </f:subview>
</html>
