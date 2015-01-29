package org.jia.ptrack.domain;

import java.util.List;
import java.io.Serializable;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2002</p>
 * <p>Company: </p>
 * @author unascribed
 * @version 1.0
 */

public interface IProjectCoordinator extends Serializable
{

  public Project add(Project project) throws DataStoreException;
  public void remove(String id) throws ObjectNotFoundException,
                                       DataStoreException;
  public void removeAll() throws DataStoreException;
  public Project get(String id) throws ObjectNotFoundException,
                                       DataStoreException;
  public void update(Project project) throws ObjectNotFoundException,
                                             DataStoreException;
  public List getProjects() throws ObjectNotFoundException,
                                         DataStoreException;
  public List getProjects(ProjectColumnType sortColumn) throws ObjectNotFoundException,
                                         DataStoreException;
  public List getProjects(RoleType role) throws ObjectNotFoundException,
                                                DataStoreException;
  public List getProjects(RoleType role, ProjectColumnType sortColumn) throws ObjectNotFoundException,
      DataStoreException;
}
