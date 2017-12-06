package com.sample.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BBCNewsPage extends Page {

  private String bbcNewsTitle = "Home - BBC News";
  private By bbcNewsLogoLocator = By.id("brand");

  public BBCNewsPage(WebDriver driver) {
    super(driver);
    waitForTitleToExist(bbcNewsTitle);
    waitForElementToBeVisibleBy(bbcNewsLogoLocator);
  }

  public String getBBCNewsLogoText() {
    navigateToRootElement();
    navigateToElementBy(bbcNewsLogoLocator);
    return getElementText();
  }
}
