/**
   JavaServer Faces in Action example code, Copyright (C) 2004 Kito D. Mann.

   Licensed under the Apache License, Version 2.0 (the "License");
   you may not use this file except in compliance with the License.
   You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

   Unless required by applicable law or agreed to in writing, software
   distributed under the License is distributed on an "AS IS" BASIS,
   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
   See the License for the specific language governing permissions and
   limitations under the License.

**/

package org.jia.ptrack.web;

import java.sql.ResultSet;
import java.util.Map;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIData;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import org.jia.ptrack.domain.*;

/**
 * Version of SelectProjectBean that uses a ResultSetProjectCoordinator instead
 * of the default ProjectCoordinator.
 * @author unascribed
 * @version 1.0
 *
 */

public class SelectProjectResultSetBean  extends BaseBean
{
  private javax.faces.component.UIData projectTable;
  private ProjectColumnType sortColumn;
  private ResultSetProjectCoordinator rsProjectCoordinator;

  public SelectProjectResultSetBean()
  {
    rsProjectCoordinator = (ResultSetProjectCoordinator)
                           getApplication().getVariableResolver().
                           resolveVariable(FacesContext.getCurrentInstance(),
                                           Constants.RESULT_SET_PROJECT_COORDINATOR_KEY);
  }

  public UIData getProjectTable()
  {
    return projectTable;
  }

  public void setProjectTable(UIData projectTable)
  {
    this.projectTable = projectTable;
  }

  public ResultSet getInboxProjects() throws DataStoreException
  {
    return rsProjectCoordinator.getProjects(getVisit().getUser().getRole());
  }

  public ResultSet getAllProjects() throws DataStoreException
  {
     return rsProjectCoordinator.getProjects();
  }

  /**
   * Not implemented for ResultSet implementation.
   * @param actionEvent ActionEvent
   */
  public void sort(ActionEvent actionEvent)
  {
  }

  public String approve()
  {
    return getProject(CommandType.APPROVE);
  }

  public String reject()
  {
    return getProject(CommandType.REJECT);
  }

  public String details()
  {
    return getProject(CommandType.DETAILS);
  }

  protected String getProject(CommandType command)
  {
    FacesContext facesContext = getFacesContext();
    Utils.log(facesContext, "Executing GetProjectForm.getProject(), command = " +
              command);
    Project project = null;
    Map projectMap = (Map)projectTable.getRowData();
    try
    {
      // Retrieve a Project instance from normal ProjectCoordinator to integrate
      // with the rest of the application.
      project = getProjectCoordinator().get(String.valueOf(projectMap.get("id")));
    }
    catch (ObjectNotFoundException e)
    {
      facesContext.addMessage(null,
                              new FacesMessage(FacesMessage.SEVERITY_WARN,
                                               "The project you selected cannot be found",
                                               "The project is no longer in the data store."));
      return Constants.FAILURE_OUTCOME;
    }
    catch (DataStoreException d)
    {
      Utils.reportError(facesContext, "A database error has occrred",
                       "Error loading project", d);
      return Constants.ERROR_OUTCOME;
    }

    if (command == CommandType.APPROVE || command == CommandType.REJECT)
    {
      if (!getStatusCoordinator().
          isValidStateChange(project.getStatus(),
                             command == CommandType.APPROVE))
      {
        Utils.addInvalidStateChangeMessage(facesContext,
                                           command == CommandType.APPROVE);
        return Constants.FAILURE_OUTCOME;
      }
    }

    getVisit().setCurrentProject(project);

    return Constants.SUCCESS_OUTCOME;
  }
}
