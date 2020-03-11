package e2e.tests;

import e2e.constants.Constants;
import org.testng.annotations.Test;
import pageObjects.LoginPage;

public class MailTest extends BaseTest {

  @Test(dataProvider = "successCreds")
  public void correctSendMail(String username, String password) {
    String body = String.valueOf(System.currentTimeMillis());

    LoginPage loginPage = new LoginPage(driver);

    loginPage
        .goToPage()
        .signIn(username, password)
        .sendMail(Constants.RECIPIENT_EMAIL, Constants.TEXT_SUBJECT, body)
        .verifySuccessMailSentText(Constants.TEXT_SUCCESS_MAIL_SENT)
        .verifySentMailData(Constants.RECIPIENT_EMAIL, Constants.TEXT_SUBJECT, body);
  }
}
