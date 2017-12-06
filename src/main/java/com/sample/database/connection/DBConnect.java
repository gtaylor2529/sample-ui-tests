package com.sample.database.connection;

import com.sample.properties.PropertyReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnect {

  private static String host = PropertyReader.getProperty("database.host");
  private static String port = PropertyReader.getProperty("database.port");
  private static String user = PropertyReader.getProperty("database.user");
  private static String password = PropertyReader.getProperty("database.password");
  private static String url = "jdbc:mysql://" + host + ":" + port + "/";

  public static Connection getConnection(String schema) throws SQLException {
    return DriverManager.getConnection(url + schema, user, password);
  }
}
