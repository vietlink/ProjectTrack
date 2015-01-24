<%-- 
    Document   : details
    Created on : Jan 2, 2015, 10:44:01 PM
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
        <title><h:outputText value="ProjectTrack- Project Details"/></title>
        <link rel="stylesheet" type="text/css" href="stylesheet/stylesheet.css"/>
    </head>
    <body class="page-background">
        <jsp:include page="header.jsp"/>
        <h:form>
            <h:panelGrid columns="2" id="projectPanel" cellpadding="5"
                         footerClass="project-backrgound"
                         columnClasses=", project-data"
                         styleClass="project-background"
                         rowClasses="project-row">
                <f:facet name="header">
                    <h:panelGrid columns="1" width="100%"
                                 cellpadding="3"
                                 styleClass="project-background"
                                 rowClasses="page-header">
                        <h:outputText value="Project details"/>
                    </h:panelGrid>
                </f:facet>
                <%@include file="project_info.jsp" %>
                <h:outputText value="Completed artifact: "/>
                <h:panelGrid columns="1"
                             rowClasses="project-data"
                             cellpadding="0" cellspacing="0">
                    <h:outputText value="Proposal document"/>
                    <h:outputText value="Project plan"/>
                </h:panelGrid>
                <f:facet name="footer">
                    <h:panelGroup>
                        <h:panelGrid columns="1" cellpadding="5"
                                     styleClass="table-background">
                            <f:facet name="header">                                
                                <h:outputText value="History: " styleClass="table-header"/>
                            </f:facet>
                            <h:panelGrid columns="1" width="100%" border="1" styleClass="table-even-row">
                                <h:panelGrid columns="3" cellpadding="7" styleClass="table-even-row">
                                    <h:outputText value="Tuesday, March 4, 2003 04:30 PM"/>
                                    <h:outputText value="Proposal-> Planning"/>
                                    <h:outputText value="(Project Manager)"/>
                                </h:panelGrid>
                                <h:panelGrid columns="1" cellpadding="3"
                                             styleClass="table-odd-row" width="100%">
                                    <h:outputText value="Comments: "/>
                                    <h:outputText value="Fudning has been approved. The user 
                                                  are prospect of having somethinig they can use" styleClass="project-data"/>
                                </h:panelGrid>
                            </h:panelGrid>
                            <h:panelGrid columns="1" width="100%" border="1" styleClass="table-even-row">
                                <h:panelGrid columns="3" cellpadding="7" styleClass="table-even-row">
                                    <h:outputText value="Monday, August 11, 2003 08:30 PM"/>
                                    <h:outputText value="Planning -> Requirements/Analysis"/>
                                    <h:outputText value="(Project manager)"/>
                                </h:panelGrid>
                                <h:panelGrid columns="1" cellpadding="3" styleClass="table-odd-row" width="100%">
                                    <h:outputText value="Comments: "/>
                                    <h:outputText value="Initial resources has been allocated and a rough plan has beed 
                                                  developed" styleClass="project-data"/>
                                </h:panelGrid>
                            </h:panelGrid>
                        </h:panelGrid>
                        <h:commandButton value="OK" action="inbox" style="margin-top: 5px"/>
                    </h:panelGroup>
                </f:facet>
            </h:panelGrid>
        </h:form>
    </body>
</html>
</f:view>