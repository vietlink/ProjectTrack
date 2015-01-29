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

public interface IStatus extends Serializable
{
  public String getId();
  public String getName();
  public IStatus getApprovalStatus();
  public IStatus getRejectionStatus();
  public boolean isInitialState();
  public boolean isFinalState();
  public RoleType getRole();
  public IStatusCoordinator getCoordinator();
}
