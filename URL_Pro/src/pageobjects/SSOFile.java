package pageobjects;

import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import  org.openqa.selenium.WebElement;
import com.provar.core.model.base.api.IRuntimeConfiguration;
import com.provar.core.testapi.ILoginPage;
import com.provar.core.testapi.ILoginResult;
import com.provar.core.testapi.SfLoginResult;
import com.provar.core.testapi.annotations.Page;
import com.provar.core.testapi.annotations.TextType;

@Page(title = "SSO Login Page", connection = "SSO")
public class SSOFile implements ILoginPage {

  @Override
  public ILoginResult doLogin(IRuntimeConfiguration runtimeConfiguration, WebDriver driver,
      Map<String, String> credentials) {

    // Get the user name and password.
    String userName = credentials.get(CREDENTIAL_USER);
    String password = credentials.get(CREDENTIAL_PASSWORD);

    // Submit the SSO form.
    driver.findElement(By.xpath("//input[@id='username']")).sendKeys(userName);
    driver.findElement(By.xpath("//input[@id='password']")).sendKeys(password);
    driver.findElement(By.xpath("//input[@id='Login']")).click();

    try {
      Thread.sleep(5000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }

    String currentUrl = driver.getCurrentUrl();
    int lightningPos = currentUrl.indexOf(".lightning.force.com");
    if (lightningPos > 0) {

      JavascriptExecutor jsExec = (JavascriptExecutor) driver;

      String classicUrl = currentUrl.substring(0, lightningPos) + ".my.salesforce.com/provardisco";
      String script = "window.open('" + classicUrl + "', 'provardisco')";
      jsExec.executeScript(script);
      try {
        Thread.sleep(5000);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
      driver.switchTo().window("provardisco");
    }

    // Return the result.
    return new SfLoginResult(true, null, driver);
  }

@TextType()
@FindBy(xpath = "//input[@name='q']")
public WebElement qw;

}