package org.jia.ptrack.domain;

import java.sql.*;
import java.util.*;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2002</p>
 * <p>Company: </p>
 * @author unascribed
 * @version 1.0
 */

public class ResultSetProjectCoordinator
{
  private String url;
  private String name;
  private String password;
  private List connections = new ArrayList();

  public ResultSetProjectCoordinator(String url, String name, String password)
      throws DataStoreException
  {
    try
    {
      Class.forName("org.hsqldb.jdbcDriver");
    }
    catch (Exception e)
    {
      throw new DataStoreException("Error loading JDBC driver", e);
    }
    this.url = url;
    this.name = name;
    this.password = password;
  }

  public ResultSet getProjects() throws DataStoreException
  {
    try
    {
      Connection conn = DriverManager.getConnection(url, name, password);
      connections.add(conn);

      Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                                            ResultSet.CONCUR_READ_ONLY);
      return stmt.executeQuery(
          "select p.id, p.name as name, pt.description as type, " +
          "s.name as status, r.description as waitingfor " +
          "from projects p, project_type pt, status s, role r " +
          "where p.type = pt.project_type_id " +
          "and   p.status = s.status_id " +
          "and   s.role_id = r.role_id");
    }
    catch (SQLException e)
    {
      throw new DataStoreException("Error executing query for loading projects",
                                   e);
    }
  }

  public ResultSet getProjects(RoleType role) throws DataStoreException
  {
    try
    {
      Connection conn = DriverManager.getConnection(url, name, password);
      Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                                            ResultSet.CONCUR_READ_ONLY);
      return stmt.executeQuery(
          "select p.id, p.name as name, pt.description as type, " +
          "s.name as status, r.description as waitingfor " +
          "from projects p, project_type pt, status s, role r " +
          "where p.type = pt.project_type_id " +
          "and   p.status = s.status_id " +
          "and   s.role_id = r.role_id " +
          "and   r.role_id = " + role.getValue());
    }
    catch (SQLException e)
    {
      throw new DataStoreException("Error executing query for loading projects",
                                   e);
    }
  }

  public void shutdown() throws DataStoreException
  {
    try
    {
      Connection conn = DriverManager.getConnection(url, name, password);
      Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                                            ResultSet.CONCUR_READ_ONLY);
      stmt.executeQuery("shutdown");
      conn.close();
    }
    catch (SQLException e)
    {
      throw new DataStoreException("Error shutting down the database", e);
    }
  }
}
