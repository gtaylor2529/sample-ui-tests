package com.sample.stepdefs;

import static org.assertj.core.api.Assertions.assertThat;

import com.sample.driver.Config;
import com.sample.pageobjects.GoogleHomePage;
import com.sample.pageobjects.GoogleSearchResultsPage;
import com.sample.pageobjects.Page;
import com.sample.properties.PropertyReader;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebDriver;

public class GoogleSearchStepDefs {

  private WebDriver driver = Config.getDriver();
  private String googleUrl = PropertyReader.getProperty("google.url");

  @Given("^I am on Google$")
  public void iAmOnGoogle() throws Throwable {
    new Page(driver).navigateToUrl(googleUrl);
  }

  @When("^I search for gobshites$")
  public void iSearchForGobshites() throws Throwable {
    GoogleHomePage googleHomePage = new GoogleHomePage(driver);
    googleHomePage.searchGoogle("gobshites");
  }

  @Then("^results for scouse scum will be displayed$")
  public void resultsForScouseScumWillBeDisplayed() throws Throwable {
    GoogleSearchResultsPage googleSearchResultsPage = new GoogleSearchResultsPage(driver,
        "gobshites");
    assertThat(googleSearchResultsPage.getTopResult()).matches(
        "Google closed its Map Maker tool, a previous version of its crowdsourcing service, in March after a series of embarrassments. The term 'gobshites' takes Google Maps users to Anfield.");
  }
}
