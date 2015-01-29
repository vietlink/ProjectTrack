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

package org.jia.ptrack.domain;

import java.text.*;

import java.util.*;

public class MemoryProjectCoordinator
    implements IProjectCoordinator
{
  private Map projects;
  private Map projectsByRoles;

  public MemoryProjectCoordinator()
  {
    try
    {
      projects = new Hashtable();
      projectsByRoles = new Hashtable();

      MemoryStatusCoordinator statusCoordinator = new MemoryStatusCoordinator();
      IStatus status = statusCoordinator.getInitialStatus();
      User user = new User("proj_mgr", "Joe", "Schmoe", "faces",
                           RoleType.PROJECT_MANAGER);
      Date opDate = null;

      Project project = new Project(statusCoordinator.getInitialStatus());
      project.setId("10");
      project.setName("Inventory Manager 2.0");
//    project.setDescription("description");
      project.setInitiatedBy("Rip Van Winkle");
      project.setRequirementsContact("Joan TooBusy");
      project.setRequirementsContactEmail("joan@toobusy.com");
      project.setInitialComments(
        "The first version is horrible and completely unusable. It's time to rewrite it.");
      project.setType(ProjectType.INTERNAL_WEB);
      project.setArtifacts(new ArtifactType[]
                           {ArtifactType.PROPOSAL,
                           ArtifactType.PROJECT_PLAN});

      SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy hh:mma");
      try
      {
        opDate = formatter.parse("04/12/2002 04:30pm");
      }
      catch (Exception e)
      {
        e.printStackTrace();
        opDate = new Date();
      }
      project.changeStatus(opDate, true, user,
                           "Funding has been approved. The users are excited about the prospect of having something they can use.");

      for (int i = 0; i < 10; i++)
      {
        try
        {
          opDate = formatter.parse("08/12/2002 08:30pm");
        }
        catch (Exception e)
        {
          e.printStackTrace();
          opDate = new Date();
        }
        project.changeStatus(opDate, true, user,
                             i +
            " Initial resources have been allocated and a rough plan has been developed.");
      }
      for (int i = 0; i < 10; i++)
      {
        try
        {
          opDate = formatter.parse("08/12/2002 08:30pm");
        }
        catch (Exception e)
        {
          e.printStackTrace();
          opDate = new Date();
        }
        project.changeStatus(opDate, false, user,
                             i + " They all lied!");
      }

      add(project);

      project = new Project(statusCoordinator.getInitialStatus());
      project.setId("20");
      project.setName("Test Project #1");
      project.setDescription("description");
      project.setRequirementsContact("Rick Jones");
      project.setRequirementsContactEmail("jones@nowhere.com");
      project.setType(ProjectType.EXTERNAL_DB);
      project.setArtifacts(new ArtifactType[]
                           {ArtifactType.ARCHITECTURE,
                           ArtifactType.DEPLOYMENT, ArtifactType.MAINTENANCE});
      project.changeStatus(true, user, "blah, blah, blah");
      project.changeStatus(true, user, "blah, blah, blah");
      add(project);

      project = new Project(statusCoordinator.getInitialStatus());
      project.setId("30");
      project.setName("Test Project #2");
//    project.setDescription("This is a description.");
      project.setType(ProjectType.INTERNAL_WEB);
      project.setArtifacts(new ArtifactType[]
                           {ArtifactType.PROPOSAL});
      add(project);
    }
    catch (DataStoreException e)
    {
      e.printStackTrace();
    }
  }

  public Project add(Project project) throws DataStoreException
  {
    synchronized (this)
    {
      if (project.getId() == null)
      {
        project.setId(Integer.toString(projects.size()));
      }
      projects.put(project.getId(), project);
    }
    /*
        if (project.getName().indexOf("add") > -1)
        {
          throw new DataStoreException("This is a silly project!");
        }*/
    update(project);

    return project;
  }

  public void remove(String id) throws ObjectNotFoundException,
      DataStoreException
  {
    synchronized (this)
    {
      Project project = (Project) projects.remove(id);
      if (project != null)
      {
        List projectList = (List) projectsByRoles.get(project.getStatus().
                                                      getRole());
        if (projectList != null)
        {
          projectList.remove(project);
        }
      }
      if (project == null)
      {
        throw new ObjectNotFoundException("No object found with id " + id);
      }
    }
  }

  public void removeAll() throws DataStoreException
  {
    synchronized (this)
    {
      projects.clear();
      projectsByRoles.clear();
    }
  }

  public Project get(String id) throws ObjectNotFoundException,
      DataStoreException
  {
    Project project = (Project) projects.get(id);
    if (project == null)
    {
      throw new ObjectNotFoundException("No object found with id " + id);
    }
    /*
        if (project.getName().indexOf("get") > -1)
        {
          throw new DataStoreException("This is a silly project!");
        }
     */
    return project;
  }

  public void update(Project project) throws ObjectNotFoundException,
      DataStoreException
  {
    synchronized (this)
    {
      projects.values().remove(project);
      projects.put(project.getId(), project);

      Iterator roles = projectsByRoles.keySet().iterator();
      Iterator roleLists = projectsByRoles.values().iterator();
      while (roles.hasNext())
      {
        RoleType role = (RoleType) roles.next();
        List roleList = (List) roleLists.next();
        if (roleList.contains(project))
        {
          if (project.getStatus().getRole().equals(role))
          {
            return; // the role hasn't changed
          }
          else
          {
            roleList.remove(project);
          }
        }
      }
      /*
          if (project.getName().indexOf("update") > -1)
          {
            throw new DataStoreException("This is a silly project!");
          }
       */

      RoleType role = project.getStatus().getRole();
      List projectList = (List) projectsByRoles.get(role);
      if (projectList == null)
      {
        projectList = new ArrayList();
      }
      projectList.add(project);
      projectsByRoles.put(role, projectList);
    }
  }

  protected List getProjectsFromMap(Map projectMap) throws
      ObjectNotFoundException,
      DataStoreException
  {
    List list = new ArrayList(projectMap.values());
/*    if (list.size() == 5)
    {
      throw new DataStoreException("This is a silly project!");
    } */
    if (list.isEmpty())
    {
      throw new ObjectNotFoundException("No projects found.");
    }
    return list;
  }

  public List getProjects() throws ObjectNotFoundException,
      DataStoreException
  {
    return getProjectsFromMap(projects);
  }

  public List getProjects(ProjectColumnType sortColumn) throws
      ObjectNotFoundException,
      DataStoreException
  {
    List projectList = getProjects();
    if (sortColumn != null)
    {
      Collections.sort(projectList, new ProjectComparator(sortColumn));
    }
    return projectList;
  }

  public List getProjects(RoleType role) throws ObjectNotFoundException,
      DataStoreException
  {
    List projectList = (List) projectsByRoles.get(role);
    if (projectList == null)
    {
      throw new ObjectNotFoundException("No projects found for role " + role);
    }
    return new ArrayList(projectList);
  }

  public List getProjects(RoleType role, ProjectColumnType sortColumn) throws
      ObjectNotFoundException,
      DataStoreException
  {
    List projectList = getProjects(role);
    if (sortColumn != null)
    {
      Collections.sort(projectList, new ProjectComparator(sortColumn));
    }
    return projectList;
  }

  private class ProjectComparator
      implements Comparator
  {
    ProjectColumnType sortColumn;

    public ProjectComparator(ProjectColumnType sortColumn)
    {
      this.sortColumn = sortColumn;
    }

    public int compare(Object o1, Object o2)
    {
      Project p1 = (Project) o1;
      Project p2 = (Project) o2;
      if (sortColumn.equals(ProjectColumnType.NAME))
      {
        return p1.getName().toLowerCase().compareTo(p2.getName().toLowerCase());
      }
      else
      if (sortColumn.equals(ProjectColumnType.TYPE))
      {
        return p1.getType().getDescription().compareTo(p2.getType().toString());
      }
      else
      if (sortColumn.equals(ProjectColumnType.STATUS))
      {
        return p1.getStatus().getName().compareTo(p2.getStatus().getName());
      }
      else
      if (sortColumn.equals(ProjectColumnType.ROLE))
      {
        return p1.getStatus().getRole().getDescription().compareTo(
            p2.getStatus().getRole().getDescription());
      }
      else
      {
        throw new IllegalArgumentException("Unsupported column type: " +
                                           sortColumn);
      }
    }
  }
}
