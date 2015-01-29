package org.jia.ptrack.web;

import javax.servlet.*;

import org.jia.ptrack.domain.*;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2002</p>
 * <p>Company: </p>
 * @author unascribed
 * @version 1.0
 */

public class Initializer implements ServletContextListener
{

  /**
   * For JDBC ResultSet example only
   */
  private ResultSetProjectCoordinator rsProjectCoordinator;

  public Initializer()
  {
  }

  public void contextInitialized(ServletContextEvent event)
  {
    ServletContext servletContext = event.getServletContext();
    Utils.log(servletContext, "Initializing ProjectTrack...");

    servletContext.setAttribute(Constants.PROJECT_COORDINATOR_KEY,
                                new MemoryProjectCoordinator());

    servletContext.setAttribute(Constants.STATUS_COORDINATOR_KEY,
                                new MemoryStatusCoordinator());

    servletContext.setAttribute(Constants.USER_COORDINATOR_KEY,
                                new MemoryUserCoordinator());

    // For JDBC ResultSet example only
    try
    {
      rsProjectCoordinator =
       new ResultSetProjectCoordinator(
             servletContext.getInitParameter("org.jia.ptrack.databaseUrl"),
             servletContext.getInitParameter("org.jia.ptrack.databaseLogin"),
             servletContext.getInitParameter("org.jia.ptrack.databasePassword"));
      servletContext.setAttribute(Constants.RESULT_SET_PROJECT_COORDINATOR_KEY,
                                  rsProjectCoordinator);
    }
    catch (DataStoreException e)
    {
      servletContext.log("Errror initializing ResultSetProjectCoordinator", e);
    }

    //jdbc:hsqldb:C:/Documents and Settings/kito/My Douments/Projects/JSF In Action/Examples/webapps/ptrack/WEB-INF/DATASET",
    //    "sa", "");

    Utils.log(servletContext, "Initialization complete...");
  }

  public void contextDestroyed(ServletContextEvent event)
  {
    try
    {
      rsProjectCoordinator.shutdown();
    }
    catch (DataStoreException e)
    {
      event.getServletContext().log("Error shutting down", e);
    }
  }
}
