package org.jia.ptrack.web;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import org.jia.ptrack.domain.*;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2002</p>
 * <p>Company: </p>
 * @author unascribed
 * @version 1.0
 */

public class AuthenticationBean extends BaseBean
{
  private String loginName;
  private String password;

  public AuthenticationBean()
  {
  }

  public void setLoginName(String loginName)
  {
    this.loginName = loginName;
  }

  public String getLoginName()
  {
    return loginName;
  }

  public void setPassword(String password)
  {
    this.password = password;
  }

  public String getPassword()
  {
    return password;
  }

  public String login()
  {
    FacesContext facesContext = getFacesContext();
    Utils.log(facesContext, "Executing AuthenticationBean.getUser()");

    User newUser = null;
    try
    {
      newUser = getUserCoordinator().getUser(loginName, password);
    }
    catch (ObjectNotFoundException e)
    {
      facesContext.addMessage(null,
                              Utils.getMessage("BadLogin", null,
                                               FacesMessage.SEVERITY_INFO));

  /*      facesContext.addMessage(null,
                              new FacesMessage(FacesMessage.SEVERITY_WARN,
                              "Incorrect name or password.", "")); */
      return Constants.FAILURE_OUTCOME;
    }
    catch (DataStoreException d)
    {
       Utils.reportError(facesContext, "ErrorLoadingUser", d);

  /*      Utils.reportError(facesContext, "A database error has occurred.",
                                       "Error loading User object", d);*/
      return Constants.ERROR_OUTCOME;
    }

    Visit visit = new Visit();
    visit.setUser(newUser);
    visit.setAuthenticationBean(this);
    setVisit(visit);

    getApplication().createValueBinding("#{" + Constants.VISIT_KEY_SCOPE +
         Constants.VISIT_KEY + "}").setValue(facesContext, visit);

    if (newUser.getRole().equals(RoleType.UPPER_MANAGER))
    {
      return Constants.SUCCESS_READONLY_OUTCOME;
    }

    return Constants.SUCCESS_READWRITE_OUTCOME;
  }

  public String logout()
   {
     FacesContext facesContext = getFacesContext();
     Utils.log(facesContext, "Executing AuthenticationBean.logout()");

     HttpSession session = (HttpSession)facesContext.getExternalContext().
                           getSession(false);
     session.removeAttribute(Constants.VISIT_KEY_SCOPE + Constants.VISIT_KEY);

     if (session != null)
     {
       session.invalidate();
     }

     return Constants.SUCCESS_OUTCOME;
   }

  public boolean isInboxAuthorized()
  {
    return !getVisit().getUser().getRole().equals(RoleType.UPPER_MANAGER);
  }

  public boolean isCreateNewAuthorized()
  {
    return getVisit().getUser().getRole().equals(RoleType.PROJECT_MANAGER);
  }

  public boolean isReadOnly()
  {
    return getVisit().getUser().getRole().equals(RoleType.UPPER_MANAGER);
  }
}
