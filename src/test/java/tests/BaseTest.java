package tests;

import static com.codeborne.selenide.Selenide.closeWebDriver;
import static helpers.AttachmentsHelper.attachAsText;
import static helpers.AttachmentsHelper.attachPageSource;
import static helpers.AttachmentsHelper.attachScreenshot;
import static helpers.AttachmentsHelper.attachVideo;
import static helpers.AttachmentsHelper.getConsoleLogs;

import com.codeborne.selenide.Configuration;
import com.github.javafaker.Faker;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.remote.DesiredCapabilities;

public class BaseTest {
  protected Faker faker = new Faker();

  @BeforeAll
  static void setup() {
    Configuration.startMaximized = true;
    if(System.getProperty("remote_driver") != null) {
      DesiredCapabilities capabilities = new DesiredCapabilities();
      Configuration.browser = System.getProperty("browser", "chrome");
      capabilities.setCapability("enableVNC", true);
      capabilities.setCapability("enableVideo", true);
      Configuration.browserCapabilities = capabilities;
      Configuration.remote = System.getProperty("remote_driver");
    }
  }

  @AfterEach
  public void afterEach() {
    attachScreenshot("Last screenshot");
    attachPageSource();
    attachAsText("Browser console logs", getConsoleLogs());
    if(System.getProperty("remote_driver") != null) {
      attachVideo();
    }
    closeWebDriver();
  }
}
