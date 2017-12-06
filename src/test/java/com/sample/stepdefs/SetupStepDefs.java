package com.sample.stepdefs;

import com.sample.driver.Config;
import com.sample.pageobjects.Page;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import java.net.MalformedURLException;
import org.openqa.selenium.WebDriver;

public class SetupStepDefs {

  private Scenario scenario;
  private WebDriver driver;

  @Before
  public void setScenario(Scenario scenario) throws MalformedURLException {
    this.scenario = scenario;
    driver = Config.setDriver();
  }

  @After
  public void tearDownBrowser() {
    Page page = new Page(driver);
    page.tearDownDriver(scenario);
  }
}
