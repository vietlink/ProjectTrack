<%-- 
    Document   : reject
    Created on : Jan 2, 2015, 10:44:41 PM
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
            <h:outputText value="ProjectTrack- Reject  a project"/>
        </title>
        <link rel="stylesheet" type="text/css" href="stylesheet/stylesheet.css"/>
    </head>
    <body class="page-background">
        <jsp:include page="header.jsp"/>
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
                            <h:outputText value="Reject a project"/>
                        </f:facet>
                        <h:outputText value="Application messages"
                                      styleClass="error"/>
                    </h:panelGrid>
                </f:facet>
                <%@include file="project_info.jsp" %>
                <%@include file="project_artifacts.jsp" %>
                
                <f:facet name="footer">
                    <h:panelGroup>
                        <%@include file="project_comments.jsp" %>
                        
                        <h:panelGrid columns="2" rowClasses="table-odd-row">
                            <h:commandButton value="Reject" action="reject"/>
                            <h:commandButton value="Cancel" action="cancel" immediate="true"/>
                        </h:panelGrid>
                    </h:panelGroup>
                </f:facet>
            </h:panelGrid>
        </h:form>
    </body>
</html>
</f:view>