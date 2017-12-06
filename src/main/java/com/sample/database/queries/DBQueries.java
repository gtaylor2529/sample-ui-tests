package com.sample.database.queries;

import com.sample.database.connection.DBConnect;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBQueries {

  public static void updateFirstLogin(String firstLogin, String username) throws SQLException {
    Statement st = DBConnect.getConnection("authentication").createStatement();
    st.execute("UPDATE users SET first_login = " + firstLogin + " WHERE name = '" + username + "'");
  }

  public static void deleteUser(String userUuid) throws SQLException {
    Statement st = DBConnect.getConnection("authentication").createStatement();
    st.execute(
        "DELETE FROM user_app WHERE user_id IN (SELECT user_id FROM users WHERE uuid = '" + userUuid
            + "')");
    st.execute(
        "DELETE FROM user_pid WHERE user_id IN (SELECT user_id FROM users WHERE uuid = '" + userUuid
            + "')");
    st.execute("DELETE FROM users WHERE uuid = '" + userUuid + "'");
  }

  public static void deleteOrganisation(String organisationUuid) throws SQLException {
    Statement st = DBConnect.getConnection("employer").createStatement();
    st.execute(
        "DELETE FROM finance_user WHERE organisation_id IN (SELECT id FROM organisation WHERE uuid = '"
            + organisationUuid + "')");
    st.execute(
        "DELETE FROM account WHERE organisation_id IN (SELECT id FROM organisation WHERE uuid = '"
            + organisationUuid + "')");
    st.execute("DELETE FROM organisation WHERE uuid = '" + organisationUuid + "'");
  }

  public static String selectUserId(String username) throws SQLException {
    Statement st = DBConnect.getConnection("authentication").createStatement();
    ResultSet rs = st.executeQuery("SELECT * FROM users WHERE name = '" + username + "'");
    String id = "";
    while (rs.next()) {
      id = rs.getString("user_id");
    }
    return id;
  }
}
