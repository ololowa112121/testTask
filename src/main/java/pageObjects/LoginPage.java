package pageObjects;

import constants.Routes;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {

  // *********Constructor*********
  public LoginPage(WebDriver driver) {
    super(driver);
  }

  // *********Web Elements*********
  // Block with inputs
  private final By inputEmail = By.xpath("//input[@type='text']");
  private final By inputPassword = By.xpath("//input[@type='password']");

  // Block with buttons
  private final By buttonSubmit = By.xpath("//button[contains(@class, 'form__submit')]");

  // *********Page Methods*********
  public LoginPage goToPage() {
    driver.get(Routes.MAIN_PAGE);

    return this;
  }

  public MailPage signIn(String email, String password) {
    writeText(inputEmail, email);
    writeText(inputPassword, password);
    click(buttonSubmit);

    return new MailPage(driver);
  }
}
