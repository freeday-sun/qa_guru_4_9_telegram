package helpers;

import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static org.openqa.selenium.logging.LogType.BROWSER;

import com.codeborne.selenide.Selenide;
import io.qameta.allure.Attachment;
import java.nio.charset.StandardCharsets;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.remote.RemoteWebDriver;


public class AttachmentsHelper {

  @Attachment(value = "{attachName}", type = "text/plain")
  public static String attachAsText(String attachName, String message) {
    return message;
  }

  @Attachment(value = "{attachName}", type = "image/png")
  public static byte[] attachScreenshot(String attachName) {
    return ((TakesScreenshot) getWebDriver()).getScreenshotAs(OutputType.BYTES);
  }

  @Attachment(value = "Page source", type = "text/plain")
  public static byte[] attachPageSource() {
    return getWebDriver().getPageSource().getBytes(StandardCharsets.UTF_8);
  }

  public static String getConsoleLogs() {
    return String.join("\n", Selenide.getWebDriverLogs(BROWSER));
  }

  @Attachment(value = "Video", type = "text/html", fileExtension = ".html")
  public static String attachVideo() {
    return "<html><body><video width='100%' height='100%' controls autoplay><source src='"
        + getVideoUrl()
        + "' type='video/mp4'></video></body></html>";
  }

  public static String getVideoUrl() {
    return System.getProperty("video_storage") + getSessionId() + ".mp4";
  }

  public static String getSessionId(){
    return ((RemoteWebDriver) getWebDriver()).getSessionId().toString();
  }

}
