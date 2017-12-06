package com.sample.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class GoogleSearchResultsPage extends Page {

  private String googleSearchResultsPageTitle = " - Google Search";
  private By googleLogoLocator = By.id("logocont");
  private By topResultLocator = By.className("_Tgc");

  public GoogleSearchResultsPage(WebDriver driver, String search) {
    super(driver);
    waitForTitleToExist(search + googleSearchResultsPageTitle);
    waitForElementToBeVisibleBy(googleLogoLocator);
  }

  public String getTopResult() {
    navigateToRootElement();
    navigateToElementBy(topResultLocator);
    return getElementText();
  }
}
