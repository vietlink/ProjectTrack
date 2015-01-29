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

public interface IUserCoordinator extends Serializable
{
   public User getUser(String login, String password)
       throws DataStoreException, ObjectNotFoundException;
}
