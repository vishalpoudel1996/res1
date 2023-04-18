package pageobjects;

import java.util.TimeZone;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.provar.core.testapi.annotations.ButtonType;
import com.provar.core.testapi.annotations.Page;
import com.provar.core.testapi.annotations.TestLogger;

@Page(title = "Utility", summary = "", relativeUrl = "", connection = "Europe")
public class Utility {
	@TestLogger
	public Logger testLogger;

	WebDriver driver;

	public Utility(WebDriver driver) {
		this.driver = driver;
	}

	public void scrolltoend() {
		((JavascriptExecutor) driver).executeScript("window.scrollTo(0, 500)");

	}

	public void clickShowMore(String var) {
	try{
		WebElement showmorebutton = driver.findElement(By.xpath("//*[text()='" + var
				+ "']/ancestor::div[contains(@class,'slds-media--center')]/div[3]//*[text()='Show more actions']/.."));
		JavascriptExecutor jse = (JavascriptExecutor) driver;

		jse.executeScript("arguments[0].click();", showmorebutton);
		}
	catch(Exception e){
		//e.printStackTrace();
		testLogger.info("Show More Function went to catch block");
	}
	}
	
	
	public void waitRefresh(String x) {

		testLogger.info("Wait Started");
		int i = 0;
		String check = "false";
		for (int count = 40; count > i; count--) {
			if (driver.findElements(By.xpath(x)).size() > 0) {
				testLogger.info("Element Present");
				i = 99;
				WebDriverWait wait = new WebDriverWait(driver, 20);
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(x)));

			} else {
				try {
					testLogger.info("Waiting for element to appear counter value is" + count);
					Thread.sleep(3000);
					if(count < 30 && check.equalsIgnoreCase("false")){
						driver.navigate().refresh();
						check = "true";
						testLogger.warning("It Refreshed");
					}
					if(count == 20 && check.equalsIgnoreCase("true")){
						driver.navigate().refresh();
						check = "gotoscroll";
						testLogger.warning("It Refreshed again");
					}
					if(count < 12 && check.equalsIgnoreCase("gotoscroll")){
						scrolltoend();
						check = "true";
						testLogger.warning("It Scrolled");
					}
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

	}
	
	@ButtonType()
	@FindBy(xpath = "//div[contains(@class, 'active') and contains(@class, 'open') and (contains(@class, 'forceModal') or contains(@class, 'uiModal'))][last()]//button[normalize-space(.)='Save']")
	public WebElement save;

	public void wait(String x) {
		
		try {
		testLogger.info("Wait Started");
		int i = 0;
		for (int count = 20; count > i; count--) {
			if (driver.findElements(By.xpath(x)).size() > 0) {
				testLogger.info("Element Present");
				i = 26;
				WebDriverWait wait = new WebDriverWait(driver, 20);
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(x)));

			} else {
				try {
					testLogger.info("Waiting for element to appear counter value is" + count);
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					//e.printStackTrace();
				}
			}

		}}
		catch(Exception e){}

	}

	public String getzone(String Country) {
		TimeZone tz = TimeZone.getTimeZone(Country);
		long hours = TimeUnit.MILLISECONDS.toHours(tz.getRawOffset());
		long minutes = TimeUnit.MILLISECONDS.toMinutes(tz.getRawOffset()) - TimeUnit.HOURS.toMinutes(hours);
		// avoid -4:-30 issue
		minutes = Math.abs(minutes);

		String result = "";
		if (hours > 0) {
			result = String.format("(GMT+%d:%02d) %s", hours, minutes, tz.getID());
		} else {
			result = String.format("(GMT%d:%02d) %s", hours, minutes, tz.getID());
		}

		return result;

	}

}
