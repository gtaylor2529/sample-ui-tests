package com.sample.stepdefs;

import static org.assertj.core.api.Assertions.assertThat;

import com.sample.driver.Config;
import com.sample.pageobjects.BBCHomePage;
import com.sample.pageobjects.BBCNewsPage;
import com.sample.pageobjects.Page;
import com.sample.properties.PropertyReader;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebDriver;

public class BBCStepDefs {

  private WebDriver driver = Config.getDriver();
  private String bbcUrl = PropertyReader.getProperty("bbc.url");

  @Given("^I am on BBC")
  public void iAmOnBBC() throws Throwable {
    new Page(driver).navigateToUrl(bbcUrl);
  }

  @When("^I navigate to the BBC News page$")
  public void iNavigateToTheBBCNewsPage() throws Throwable {
    BBCHomePage bbcHomePage = new BBCHomePage(driver);
    bbcHomePage.clickBBCNews();
  }

  @Then("^the BBC News page will be displayed$")
  public void theBBCNewsPageWillBeDisplayed() throws Throwable {
    BBCNewsPage bbcNewsPage = new BBCNewsPage(driver);
    assertThat(bbcNewsPage.getBBCNewsLogoText()).matches("BBC News");
  }
}
