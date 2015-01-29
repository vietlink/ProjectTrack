package org.jia.ptrack.domain;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2002</p>
 * <p>Company: </p>
 * @author unascribed
 * @version 1.0
 */

public class MemoryStatusCoordinator
    implements IStatusCoordinator
{

  private class BasicStatus
      implements IStatus
  {
    private String id;
    private String name;
    private IStatus rejectionStatus;
    private IStatus approvalStatus;
    private boolean initialState;
    private boolean finalState;
    private RoleType role;
    private MemoryStatusCoordinator coordinator;

    private BasicStatus(MemoryStatusCoordinator coordinator,
                        String id, String name, RoleType role)
    {
      this.coordinator = coordinator;
      this.id = id;
      this.name = name;
      this.initialState = false;
      this.finalState = false;
      this.role = role;
    }

    public String getId()
    {
      return id;
    }

    public String getName()
    {
      return name;
    }

    public RoleType getRole()
    {
      return role;
    }

    public IStatus getApprovalStatus()
    {
      return approvalStatus;
    }

    public IStatus getRejectionStatus()
    {
      return rejectionStatus;
    }

    public boolean isFinalState()
    {
      return finalState;
    }

    public boolean isInitialState()
    {
      return initialState;
    }

    public String toString()
    {
      return name;
    }

    public boolean equals(Object other)
    {
      return ( (IStatus) other).getId().equals(id);
    }

    public IStatusCoordinator getCoordinator()
    {
      return coordinator;
    }
  }

  private IStatus initialStatus;

  public MemoryStatusCoordinator()
  {
    initialStatus = initStateMachine();
  }

  private IStatus initStateMachine()
  {
    BasicStatus proposal = new BasicStatus(this, "0", "Proposal",
                                           RoleType.PROJECT_MANAGER);
    BasicStatus planning = new BasicStatus(this, "1", "Planning",
                                           RoleType.PROJECT_MANAGER);
    BasicStatus analysis = new BasicStatus(this, "2", "Requirements/Analysis",
                                           RoleType.BUSINESS_ANALYST);
    BasicStatus architecture = new BasicStatus(this, "3", "Architecture",
                                               RoleType.DEVELOPMENT_MANAGER);
    BasicStatus initialDevelopment = new BasicStatus(this, "4",
                                                     "Core Development",
                                                     RoleType.
                                                     DEVELOPMENT_MANAGER);
    BasicStatus betaDeployment = new BasicStatus(this, "5", "Beta Deployment",
                                                 RoleType.SYSTEMS_MANAGER);
    BasicStatus betaTesting = new BasicStatus(this, "6", "Beta Testing",
                                              RoleType.QA_MANAGER);
    BasicStatus finalDevelopment = new BasicStatus(this, "7",
                                                   "Final Development",
                                                   RoleType.DEVELOPMENT_MANAGER);
    BasicStatus uatDeployment = new BasicStatus(this, "8",
                                                "Acceptance Testing Deployment",
                                                RoleType.SYSTEMS_MANAGER);
    BasicStatus uaTesting = new BasicStatus(this, "9", "Acceptance Testing",
                                            RoleType.QA_MANAGER);
    BasicStatus productionDeployment = new BasicStatus(this, "10",
                                                       "Production Deployment",
                                                       RoleType.SYSTEMS_MANAGER);
    BasicStatus complete = new BasicStatus(this, "11", "Complete",
                                           RoleType.PROJECT_MANAGER);
    BasicStatus closed = new BasicStatus(this, "12", "Closed", null);

    proposal.rejectionStatus = proposal;
    proposal.approvalStatus = planning;
    proposal.initialState = true;

    planning.rejectionStatus = proposal;
    planning.approvalStatus = analysis;

    analysis.rejectionStatus = planning;
    analysis.approvalStatus = architecture;

    architecture.rejectionStatus = analysis;
    architecture.approvalStatus = initialDevelopment;

    initialDevelopment.rejectionStatus = architecture;
    initialDevelopment.approvalStatus = betaDeployment;

    betaDeployment.rejectionStatus = initialDevelopment;
    betaDeployment.approvalStatus = betaTesting;

    betaTesting.rejectionStatus = initialDevelopment;
    betaTesting.approvalStatus = finalDevelopment;

    finalDevelopment.rejectionStatus = betaTesting;
    finalDevelopment.approvalStatus = uatDeployment;

    uatDeployment.rejectionStatus = finalDevelopment;
    uatDeployment.approvalStatus = uaTesting;

    uaTesting.rejectionStatus = uatDeployment;
    uaTesting.approvalStatus = productionDeployment;

    productionDeployment.rejectionStatus = finalDevelopment;
    productionDeployment.approvalStatus = complete;

    complete.rejectionStatus = productionDeployment;
    complete.approvalStatus = closed;

    closed.rejectionStatus = closed;
    closed.approvalStatus = closed;
    closed.finalState = true;

    return proposal;
  }

  public IStatus getInitialStatus()
  {
    return initialStatus;
  }

  public boolean isValidStateChange(IStatus status, boolean approve)
  {
    if (approve)
    {
      return!status.isFinalState();
    }
    else
    {
      return (!status.isInitialState() && !status.isFinalState());
    }
  }
}
