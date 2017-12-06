package com.sample.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BBCHomePage extends Page {

  private String bbcHomePageTitle = "BBC - Home";
  private By bbcNewsLinkLocator = By.className("orb-nav-news");

  public BBCHomePage(WebDriver driver) {
    super(driver);
    waitForTitleToExist(bbcHomePageTitle);
    waitForElementToBeVisibleBy(bbcNewsLinkLocator);
  }

  public BBCNewsPage clickBBCNews() {
    navigateToRootElement();
    navigateToElementBy(bbcNewsLinkLocator);
    click();
    return new BBCNewsPage(driver);
  }
}
