package controllers;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;

import java.io.File;
import java.io.IOException;

public class BaseWebDriver {

  protected WebDriver driver = null;

  protected void initWebDriver() {
    WebDriverManager.chromedriver().setup();

    driver = new ChromeDriver();
  }

  protected void tearDownWebDriver(ITestResult result) throws IOException {

    if (result.getStatus() == ITestResult.FAILURE) {
      File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
      FileUtils.copyFile(scrFile, new File("./logs/" + result.getName() + ".jpg"));
    }

    driver.quit();
  }
}
