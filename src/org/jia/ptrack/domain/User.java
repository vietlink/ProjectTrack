package org.jia.ptrack.domain;

import java.io.Serializable;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2002</p>
 * <p>Company: </p>
 * @author unascribed
 * @version 1.0
 */

public class User implements Serializable
{
  private String firstName;
  private String lastName;
  private String login;
  private String password;
  private RoleType role;

  public User()
  {
  }

  public User(String login, String firstName, String lastName,
              String password, RoleType role)
  {
    this.login = login;
    this.firstName = firstName;
    this.lastName = lastName;
    this.password = password;
    this.role = role;
  }

  public void setLogin(String login)
  {
    this.login = login;
  }

  public String getLogin()
  {
    return login;
  }

  public String getFirstName()
  {
    return firstName;
  }

  public void setFirstName(String firstName)
  {
    this.firstName = firstName;
  }

  public String getLastName()
  {
    return lastName;
  }

  public void setLastName(String lastName)
  {
    this.lastName = lastName;
  }

  public void setPassword(String password)
  {
    this.password = password;
  }

  public String getPassword()
  {
    return password;
  }

  public void setRole(RoleType role)
  {
    this.role = role;
  }

  public RoleType getRole()
  {
    return role;
  }

  public String toString()
  {
    return firstName + " " + lastName;
  }
}
