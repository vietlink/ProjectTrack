<%-- 
    Document   : project_artifacts
    Created on : Jan 2, 2015, 10:46:25 PM
    Author     : NgoVietLinh
--%>
<h:outputLabel for="artifactSelect">
  <h:outputText value="Completed artifacts:"/>
</h:outputLabel>
<h:selectManyCheckbox id="artifactSelect" layout="pageDirection"
                      styleClass="project-input"
                      value="#{visit.currentProject.artifacts}"
                      converter="ArtifactType">
  <f:selectItems value="#{selectItems.artifacts}"/>
</h:selectManyCheckbox>
