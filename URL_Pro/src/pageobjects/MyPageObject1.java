package pageobjects;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.provar.core.testapi.annotations.*;

@Page( title="MyPageObject1"                                
     , summary=""
     , relativeUrl=""
     , connection="conn1"
     )             
public class MyPageObject1 {

	@ButtonType()
	@FindBy(xpath = "//div[contains(@class, 'active') and contains(@class, 'open') and (contains(@class, 'forceModal') or contains(@class, 'uiModal'))][last()]//button[@name='SaveEdit']")
	public WebElement save;
	@ButtonType()
	@JavascriptBy(jspath = "document.querySelector('div > div > div > span > a')")
	public WebElement NewContact;
	
	WebDriver driver;

	public MyPageObject1(WebDriver driver) {
		this.driver = driver;
		}
		
	public String toast(String s)
	{
	driver.findElement(By.xpath("//div[contains(@class, 'active') and contains(@class, 'open') and (contains(@class, 'forceModal') or contains(@class, 'uiModal'))][last()]//button[@name='SaveEdit']")).click();
//JavascriptExecutor js = (JavascriptExecutor)driver;
//js.executeScript("arguments[0].click();", NewContact);
String toast1= s;
String s1=driver.findElement(By.xpath(toast1)).getText();
Assert.assertTrue("asas", false);
return s1;
	}
	
			
}
