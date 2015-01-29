package org.jia.ptrack.domain;

import java.io.Serializable;
import java.util.*;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2002</p>
 * <p>Company: </p>
 * @author unascribed
 * @version 1.0
 */

public class Project
    implements Serializable
{
  private String name;
  private String initiatedBy;
  private String requirementsContact;
  private String description;
  private java.util.List operationHistory;
  private ArtifactType[] artifacts;
  private ProjectType type;
  private String id;
  private IStatus status;
  private IStatus initialStatus;

  private java.util.Map idMap;
  private String initialComments;
  private String requirementsContactEmail;

  public Project()
  {
    operationHistory = new ArrayList();
    artifacts = new ArtifactType[] {};
  }

  public Project(IStatus initialStatus)
  {
    this();
    setInitialStatus(initialStatus);
  }

  public void setName(String name)
  {
    this.name = name;
  }

  public String getName()
  {
    return name;
  }

  public void setInitiatedBy(String initiatedBy)
  {
    this.initiatedBy = initiatedBy;
  }

  public String getInitiatedBy()
  {
    return initiatedBy;
  }

  public void setRequirementsContact(String requirementsContact)
  {
    this.requirementsContact = requirementsContact;
  }

  public String getRequirementsContact()
  {
    return requirementsContact;
  }

  public void setDescription(String description)
  {
    this.description = description;
  }

  public String getDescription()
  {
    return description;
  }

  public List getHistory()
  {
    return Collections.unmodifiableList(operationHistory);
  }

  public void setArtifacts(ArtifactType[] artifacts)
  {
    this.artifacts = artifacts;
  }

  public ArtifactType[] getArtifacts()
  {
    return artifacts;
  }

  public void setType(ProjectType type)
  {
    this.type = type;
  }

  public ProjectType getType()
  {
    return type;
  }

  public void setId(String id)
  {
    this.id = id;
  }

  public String getId()
  {
    return id;
  }

  public IStatus getStatus()
  {
    return status;
  }

  public synchronized boolean changeStatus(boolean approve, User user,
                                           String comments)
  {
    return changeStatus(new Date(), approve, user, comments);
  }

  public synchronized boolean changeStatus(Date date, boolean approve,
                                           User user,
                                           String comments)
  {
    if (status == null)
    {
      throw new NullPointerException("The initialStatus property must be " +
                                     "set before the status can be changed.");
    }

    if (!status.getCoordinator().isValidStateChange(status, approve))
    {
      return false;
    }

    IStatus fromStatus = status;
    IStatus toStatus = null;

    if (approve)
    {
      toStatus = status.getApprovalStatus();
    }
    else
    {
      toStatus = status.getRejectionStatus();
    }

    Operation newAction = new Operation(date, user, fromStatus, toStatus,
                                        comments);
    operationHistory.add(newAction);
    status = toStatus;
    return true;
  }

  public void setInitialStatus(IStatus initialStatus)
  {
    this.initialStatus = initialStatus;
    if (status == null)
    {
      this.status = initialStatus;
    }
  }

  public void setIdMap(java.util.Map idMap)
  {
    this.idMap = idMap;
  }

  public java.util.Map getIdMap()
  {
    Map idMap = new HashMap();
    idMap.put(name, id);
    return idMap;
  }

  public void setInitialComments(String initialComments)
  {
    this.initialComments = initialComments;
  }

  public String getInitialComments()
  {
    return initialComments;
  }

  public String toString()
  {
    return name;
  }

  public String getRequirementsContactEmail()
  {
    return requirementsContactEmail;
  }

  public void setRequirementsContactEmail(String requirementsContactEmail)
  {
    this.requirementsContactEmail = requirementsContactEmail;
  }
}
