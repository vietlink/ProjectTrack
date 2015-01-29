<%-- 
    Document   : project_comments
    Created on : Jan 2, 2015, 10:47:09 PM
    Author     : NgoVietLinh
--%>

<h:panelGrid columns="1" cellpadding="5"
             styleClass="table-background"
             rowClasses="table-odd-row,table-even-row">
  <h:outputLabel for="commentsInput">
    <h:outputText value="Your comments:"/>
  </h:outputLabel>
  <h:inputTextarea id="commentsInput" rows="10" cols="80"
                   value="#{updateProjectBean.comments}"/>
</h:panelGrid>

