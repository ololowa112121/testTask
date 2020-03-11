package e2e.tests;

import controllers.BaseWebDriver;
import controllers.Resources;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;

import java.io.IOException;

public class BaseTest extends BaseWebDriver {
  @BeforeMethod
  public void initBrowser() {
    initWebDriver();
  }

  @AfterMethod
  public void closeBrowser(ITestResult result) throws IOException {
    tearDownWebDriver(result);
  }

  @DataProvider(name = "successCreds")
  public Object[][] provider() {
    return Resources.readSuccessJsonCredentials();
  }
}
