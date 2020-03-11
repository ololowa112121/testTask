package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class MailPage extends BasePage {
  // *********Constructor*********
  public MailPage(WebDriver driver) {
    super(driver);
  }

  // *********Web Elements*********
  // Block with inputs
  private final By inputMailRecipient = By.xpath("//input[@name='toFieldInput']");
  private final By inputMailSubject = By.xpath("//input[@name='subject']");
  private final By inputMailBody = By.xpath("//div");

  // Block with buttons
  private final By buttonWriteMail = By.xpath("//button[contains(@class, 'compose')]");
  private final By buttonSendMail = By.xpath("//button[contains(@class, 'default send')]");
  private final By buttonSentMailsSlider = By.xpath("//a[@id='10001']/parent::div");

  // Block with containers
  private final By containerSuccessMailSentText =
      By.xpath("//div[contains(@class, 'sendmsg__ads-ready')]");
  private final By containerSentMailRecipient =
      By.xpath("//span[@class='msglist__row-address-wrap']");
  private final By containerSentMailSubject = By.xpath("//a[@class='msglist__row_href']");
  private final By containerSentMailBody = By.xpath("//a[@class='msglist__row_href']/strong");

  // *********Page Methods*********
  public MailPage sendMail(String recipient, String subject, String body) {
    click(buttonWriteMail);
    writeText(inputMailRecipient, recipient);
    writeText(inputMailSubject, subject);
    driver.switchTo().frame("mce_0_ifr");
    writeText(inputMailBody, body);
    driver.switchTo().defaultContent();
    click(buttonSendMail);

    return this;
  }

  public MailPage verifySuccessMailSentText(String expectedText) {
    Assert.assertTrue(
        readText(containerSuccessMailSentText).contains(expectedText),
        "Success email's notification doesn't appeared");

    return this;
  }

  public MailPage verifySentMailData(
      String expectedRecipient, String expectedSubject, String expectedBody) {
    click(buttonSentMailsSlider);
    Assert.assertEquals(
        readText(containerSentMailRecipient), expectedRecipient, "Wrong mail's recipient");
    Assert.assertTrue(
        readText(containerSentMailSubject).contains(expectedSubject), "Wrong email's subject");
    Assert.assertEquals(
        readText(containerSentMailBody).replace(" ", ""), expectedBody, "Wrong email's body");

    return this;
  }
}
