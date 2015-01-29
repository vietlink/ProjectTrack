<%-- 
    Document   : project_info
    Created on : Jan 2, 2015, 10:47:21 PM
    Author     : NgoVietLinh
--%>

<h:outputText value="Name:"/>
<h:outputText value="#{visit.currentProject.name}"
              styleClass="project-data"/>         <!>

<h:outputText value="Type:"/>
<h:outputText value="#{visit.currentProject.type}"
              styleClass="project-data"/>   <!>

<h:outputText value="Initiated by:"/>
<h:outputText value="#{visit.currentProject.initiatedBy}"
              styleClass="project-data"/>    <!>

<h:outputText value="Requirements contact:"/>
<h:outputText value="#{visit.currentProject.requirementsContact}"
              styleClass="project-data"/>    <!>

<h:outputText value="Requirements contact e-mail:"/>
<h:outputText value="#{visit.currentProject.requirementsContactEmail}"
              styleClass="project-data"/>    <!>

<h:outputText value="Initial comments:"/>
<h:outputText value="#{visit.currentProject.initialComments}"
              styleClass="project-data"/>    <!>
