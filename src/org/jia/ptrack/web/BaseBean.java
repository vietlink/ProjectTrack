package org.jia.ptrack.web;

import java.io.Serializable;
import javax.faces.context.FacesContext;

import org.jia.ptrack.domain.*;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2002</p>
 * <p>Company: </p>
 * @author unascribed
 * @version 1.0
 *
 */

public class BaseBean implements Serializable
{
  private Visit visit;
  private IProjectCoordinator projectCoordinator;
  private IStatusCoordinator statusCoordinator;
  private IUserCoordinator userCoordinator;

  public BaseBean()
  {
  }

  // Faces objects

  public FacesContext getFacesContext()
  {
    return FacesContext.getCurrentInstance();
  }

  public javax.faces.application.Application getApplication()
  {
    return getFacesContext().getApplication();
  }

  // Application objects

  public Visit getVisit()
  {
    return visit;
  }

  public void setVisit(Visit visit)
  {
    this.visit = visit;
  }

  // Accessors for business objects

  public IProjectCoordinator getProjectCoordinator()
  {
    return projectCoordinator;
  }

  public void setProjectCoordinator(IProjectCoordinator projectCoordinator)
  {
    this.projectCoordinator = projectCoordinator;
  }

  public IStatusCoordinator getStatusCoordinator()
  {
    return statusCoordinator;
  }

  public void setStatusCoordinator(IStatusCoordinator statusCoordinator)
  {
    this.statusCoordinator = statusCoordinator;
  }

  public IUserCoordinator getUserCoordinator()
  {
    return userCoordinator;
  }

  public void setUserCoordinator(IUserCoordinator userCoordinator)
  {
    this.userCoordinator = userCoordinator;
  }

  // Common action methods

  public String cancel()
  {
    if (getVisit().getAuthenticationBean().isReadOnly())
    {
      return Constants.CANCEL_READONLY_OUTCOME;
    }
    else
    {
      return Constants.CANCEL_READWRITE_OUTCOME;
    }
  }
}
