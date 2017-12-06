package com.sample.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class GoogleHomePage extends Page {

  private String googleHomePageTitle = "Google";
  private By searchFieldLocator = By.id("lst-ib");
  private By searchButtonLocator = By.name("btnK");

  public GoogleHomePage(WebDriver driver) {
    super(driver);
    waitForTitleToExist(googleHomePageTitle);
    waitForElementToBeVisibleBy(searchFieldLocator);
  }

  private void enterSearch(String search) {
    navigateToRootElement();
    navigateToElementBy(searchFieldLocator);
    type(search);
  }

  private void clickSearch() {
    navigateToRootElement();
    navigateToElementBy(searchButtonLocator);
    click();
  }

  public GoogleSearchResultsPage searchGoogle(String search) {
    enterSearch(search);
    clickSearch();
    return new GoogleSearchResultsPage(driver, search);
  }
}
