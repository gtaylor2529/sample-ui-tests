package com.sample.driver;

import static java.util.concurrent.TimeUnit.MILLISECONDS;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import org.apache.commons.lang3.SystemUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriverService;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class Config {

  private static final String USERNAME = "";
  private static final String AUTOMATE_KEY = "";
  private static final String URL =
      "https://" + USERNAME + ":" + AUTOMATE_KEY + "@hub-cloud.browserstack.com/wd/hub";
  private static WebDriver driver;
  private static File exe;

  public static WebDriver setDriver() throws MalformedURLException {
    String browser = System.getProperty("browser");
    if (browser.equals("chrome")) {
      driver = chromeDriver();
    } else if (browser.equals("firefox")) {
      driver = firefoxDriver();
    } else if (browser.equals("phantomjs")) {
      driver = phantomJSDriver();
    } else if (browser.equals("browserstack")) {
      driver = browserstackDriver();
    }
    return driver;
  }

  public static WebDriver getDriver() {
    return driver;
  }

  private static WebDriver chromeDriver() {
    if (SystemUtils.IS_OS_MAC) {
      exe = new File("src/main/resources/binaries/chrome/2.33/chromedriver");
    } else if (SystemUtils.IS_OS_WINDOWS) {
      exe = new File("src/main/resources/binaries/chrome/2.33/chromedriver.exe");
    }
    System.setProperty("webdriver.chrome.driver", exe.getAbsolutePath());
    WebDriver driver = new ChromeDriver(chromeCapabilities());
    configureCommonSettings(driver);
    return driver;
  }

  private static WebDriver firefoxDriver() {
    if (SystemUtils.IS_OS_MAC) {
      exe = new File("src/main/resources/binaries/firefox/0.19.0/geckodriver");
    } else if (SystemUtils.IS_OS_WINDOWS) {
      exe = new File("src/main/resources/binaries/firefox/0.19.0/geckodriver.exe");
    }
    System.setProperty("webdriver.gecko.driver", exe.getAbsolutePath());
    WebDriver driver = new FirefoxDriver(firefoxCapabilities());
    configureCommonSettings(driver);
    return driver;
  }

  private static WebDriver phantomJSDriver() {
    if (SystemUtils.IS_OS_MAC) {
      exe = new File("src/main/resources/binaries/phantomjs/2.1.1/phantomjs");
    } else if (SystemUtils.IS_OS_WINDOWS) {
      exe = new File("src/main/resources/binaries/phantomjs/2.1.1/phantomjs.exe");
    }
    System.setProperty("phantomjs.binary.path", exe.getAbsolutePath());
    return new PhantomJSDriver(phantomJSCapabilities());
  }

  private static WebDriver browserstackDriver() throws MalformedURLException {
    return new RemoteWebDriver(new URL(URL), browserstackCapabilities());
  }

  private static DesiredCapabilities chromeCapabilities() {
    ArrayList<String> capabilityFlags = new ArrayList<>();
    capabilityFlags.add("--ignore-certificate-errors=true");
    DesiredCapabilities capabilities = DesiredCapabilities.chrome();
    capabilities.setCapability("chrome.switches", capabilityFlags);
    return capabilities;
  }

  private static DesiredCapabilities firefoxCapabilities() {
    DesiredCapabilities capabilities = DesiredCapabilities.firefox();
    capabilities.setCapability("acceptInsecureCerts", true);
    return capabilities;
  }

  private static DesiredCapabilities phantomJSCapabilities() {
    ArrayList<String> capabilityFlags = new ArrayList<>();
    capabilityFlags.add("--ignore-ssl-errors=true");
    DesiredCapabilities capabilities = DesiredCapabilities.phantomjs();
    capabilities.setCapability(PhantomJSDriverService.PHANTOMJS_CLI_ARGS, capabilityFlags);
    return capabilities;
  }

  private static DesiredCapabilities browserstackCapabilities() {
    DesiredCapabilities capabilities = new DesiredCapabilities();
    capabilities.setCapability("browser", System.getProperty("browser_name"));
    capabilities.setCapability("browser_version", System.getProperty("browser_version"));
    capabilities.setCapability("os", System.getProperty("os_name"));
    capabilities.setCapability("os_version", System.getProperty("os_version"));
    capabilities.setCapability("browserstack.debug", "true");
    capabilities.setCapability("acceptSslCerts", "true");
    return capabilities;
  }

  private static void configureCommonSettings(WebDriver driver) {
    driver.manage().timeouts().pageLoadTimeout(30000, MILLISECONDS);
    driver.manage().window().maximize();
  }
}
