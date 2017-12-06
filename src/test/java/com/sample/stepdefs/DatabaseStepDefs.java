package com.sample.stepdefs;

import static org.assertj.core.api.Assertions.assertThat;

import com.sample.database.queries.DBQueries;
import cucumber.api.java.en.Then;

public class DatabaseStepDefs {

  @Then("^the database will contain a user id$")
  public void theDatabaseWillContainAUserId() throws Throwable {
    assertThat(DBQueries.selectUserId("randomuser")).matches("13412490");
  }

}
