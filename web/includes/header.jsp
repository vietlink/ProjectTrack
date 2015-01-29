<%-- 
    Document   : header
    Created on : Jan 2, 2015, 10:43:39 PM
    Author     : NgoVietLinh
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@taglib uri="jsf-in-action-components" prefix="jia" %>
<!DOCTYPE html>
<html>
    <f:subview id="header">
        <h:form>
            <h:panelGrid columns="3" cellpadding="0" cellspacing="0"
                         styleClass="header" width="100%">
                <jia:navigatorToolbar id="header"
                                      layout="horizontal"
                                      headerClass="header-header"
                                      itemClass="header-command"
                                      selectedItemClass="headr-command"
                                      iconClass="header-icon"
                                      immediate="false">
                    <f:facet name="header">
                        <h:outputText value="Project track:"/>
                    </f:facet>
                    <jia:navigatorItem name="inbox" label="Inbox"
                                       icon="images/inbox.gif"
                                       action="inbox"
                                       disabled="#{!authenticationBean.inboxAuthorized}"/>
                    <jia:navigatorItem name="showAll" label="Show all"
                                       icon="images/show_all.gif"
                                       action="show_all"/>
                    <jia:navigatorItem name="createNew" label="Create new"
                                       icon="images/create_new.gif"
                                       action="#{createProjectBean.create}"
                                       disabled="#{!authenticationBean.createNewAuthorized}"/>
                    <jia:navigatorItem name="logout" label="Log out"
                                       icon="images/logout.gif"
                                       action="#{authenticationBean.logout}"/>
                </jia:navigatorToolbar>
               
               <%-- <h:panelGrid id="header" columns="9" cellpadding="4" cellspacing="4"
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
                </h:panelGrid>--%>
                <h:panelGroup>
                    <h:outputLabel for="languageSelect">
                        <h:outputText value="Language:" styleClass="language-select"/>
                    </h:outputLabel>
                    <h:selectOneListbox id="languageSelect"
                                        size="1" styleClass="language-select" value="#{visit.locale}">
                        <f:selectItem value="#{visit.supportLocaleItems}"/>
                    </h:selectOneListbox>
                    <h:commandButton value="Go!"
                                     styleClass="language-select-button"/>
                </h:panelGroup>
                <h:outputText value="#{visit.user.login}" styleClass="user-name"/>
            </h:panelGrid>
        </h:form>
    </f:subview>
</html>
