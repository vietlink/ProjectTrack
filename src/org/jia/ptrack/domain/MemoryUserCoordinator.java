package org.jia.ptrack.domain;

import java.util.HashMap;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2002</p>
 * <p>Company: </p>
 * @author unascribed
 * @version 1.0
 */

public class MemoryUserCoordinator implements IUserCoordinator
{
  private HashMap users;

  public MemoryUserCoordinator()
  {
    users = new HashMap();
    init(users);
  }

  private void init(HashMap roles)
  {
    User user = null;

    user = new User("upper_mgr", "Casey", "Langer", "faces",
                             RoleType.UPPER_MANAGER);
    users.put(user.getLogin(), user);

    user = new User("proj_mgr", "Sean", "Sullivan", "faces",
                             RoleType.PROJECT_MANAGER);
    users.put(user.getLogin(), user);

    user = new User("analyst", "Marvin", "Walton", "faces",
                         RoleType.BUSINESS_ANALYST);
    users.put(user.getLogin(), user);

    user = new User("dev_mgr", "Devora", "Shapiro", "faces",
                             RoleType.DEVELOPMENT_MANAGER);
    users.put(user.getLogin(), user);

    user = new User("qa_mgr", "Tracey", "Burroughs", "faces",
                             RoleType.QA_MANAGER);
    users.put(user.getLogin(), user);

    user = new User("sys_mgr", "Ed", "LaCalle", "faces",
                             RoleType.SYSTEMS_MANAGER);
    users.put(user.getLogin(), user);
  }

  public User getUser(String login, String password) throws DataStoreException,
                                                           ObjectNotFoundException
  {
    if (login.equals("silly"))
    {
      throw new DataStoreException("This is a silly project!");
    }

    User user = (User)users.get(login);

    if ((user != null) && (user.getPassword().equals(password)))
    {
      return user;
    }
    else
    {
      throw new ObjectNotFoundException("No user found with that name and password");
    }
  }
}
