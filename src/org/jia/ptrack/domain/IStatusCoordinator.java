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

public interface IStatusCoordinator extends Serializable
{
  public IStatus getInitialStatus();
  public boolean isValidStateChange(IStatus status, boolean approve);
}
