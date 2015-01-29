package org.jia.ptrack.domain;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2002</p>
 * <p>Company: </p>
 * @author unascribed
 * @version 1.0
 */

public class RoleType extends EnumeratedType
{
  public final static RoleType UPPER_MANAGER = new RoleType(0, "Upper Manager",
      "/ptrack-ui/images/inbox.gif");
  public final static RoleType PROJECT_MANAGER = new RoleType(10,
      "Project Manager", "/ptrack-ui/images/inbox.gif");
  public final static RoleType BUSINESS_ANALYST = new RoleType(20,
      "Business Analyst", "/ptrack-ui/images/inbox.gif");
  public final static RoleType DEVELOPMENT_MANAGER = new RoleType(30,
      "Development Manager", "/ptrack-ui/images/inbox.gif");
  public final static RoleType SYSTEMS_MANAGER = new RoleType(40,
      "Systems Manager", "/ptrack-ui/images/inbox.gif");
  public final static RoleType QA_MANAGER = new RoleType(50, "QA Manager",
      "/ptrack-ui/images/inbox.gif");
  private String iconUrl = null;

  private static EnumManager enumManager;

  static
  {
    enumManager = new EnumManager();
    enumManager.addInstance(PROJECT_MANAGER);
    enumManager.addInstance(BUSINESS_ANALYST);
    enumManager.addInstance(DEVELOPMENT_MANAGER);
    enumManager.addInstance(SYSTEMS_MANAGER);
    enumManager.addInstance(QA_MANAGER);
  }

  private RoleType(int value, String description)
  {
    super(value, description);
  }

  private RoleType(int value, String description, String iconUrl)
  {
    super(value, description);
    this.iconUrl = iconUrl;
  }

  public static EnumManager getEnumManager()
  {
    return enumManager;
  }

  public void setIconUrl(String iconUrl)
  {
    this.iconUrl = iconUrl;
  }

  public String getIconUrl()
  {
    return iconUrl;
  }
}
