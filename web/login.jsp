<%-- 
    Document   : login
    Created on : Jan 2, 2015, 10:43:19 PM
    Author     : NgoVietLinh
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsf/core"
prefix="f"%>
<%@ taglib uri="http://java.sun.com/jsf/html"
prefix="h"%>
<!DOCTYPE html>
<f:view>
<html>
    <head>
        <script type="text/javascript">
            function set_image(button, img){
                button.src=img;
            }
        </script>
        <link rel="stylesheet" type="text/css"
              href="stylesheet/stylesheet.css"/>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title><h:outputText value="Project Track"/></title>
    </head>
    <h:form>
    <body>
        <h:panelGrid columns="2" border="0" cellpadding="3" cellspacing="3">
            <h:graphicImage url="images/login.jpg" title="Welcoome to Project track"
                                    alt="Welcome to Project track" width="149" height="160"/>
            <h:panelGrid columns="3" border="0" cellpadding="5" cellspacing="3"
                         headerClass="login-heading">
                <f:facet name="header">
                    <h:outputText value="Project Track"/>
                </f:facet>
                
                <h:outputLabel for="userNameInput">
                    <h:outputText value="Enter your username:"/>
                </h:outputLabel>
                
                <h:inputText id="userNameInput" size="20" maxlength="30" required="true">
                    <f:validateLength minimum="5" maximum="30"/>
                </h:inputText>
                <h:message for="userNameInput" styleClass="error"/>
                <h:outputLabel for="passwordInput">
                    <h:outputText value="Enter your password:"/>
                </h:outputLabel>
                <h:inputSecret id="passwordInput" size="20" maxlength="30" required="true">
                    <f:validateLength minimum="5" maximum="15"/>
                </h:inputSecret>
                <h:message for="passwordInput" styleClass="error"/>
            
            <h:panelGroup/>
            
            <h:commandButton action="success" 
                             title="Submit" image="images/Submit.gif"
                             onmouseover="set_image(this, 'images/submit_over.gif');"
                             onmouseout="set_image(this, 'images/Submit.gif');"/>
            <h:panelGroup/>
            </h:panelGrid>
        </h:panelGrid>        
    </body>
    </h:form>
</html>

</f:view>