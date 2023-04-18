package pageobjects;
import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.python.antlr.PythonParser.return_stmt_return;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;
import com.provar.core.testapi.annotations.*;
@Page( title="MyPageObject"                                
     , summary=""
     , relativeUrl=""
     , connection="connurl"
     )             
public class MyPageObject {
	@TextType()
	@FindBy(xpath = "//label[normalize-space(.)='Een andere dienstVoor extra diensten zoals een postbus, de haal- en brengservice en meer.']//img")
	public WebElement een;
	@ChoiceListType()
	@FindBy(xpath = "//select")
	public WebElement dropdown_One;
	@ButtonType()
	@FindBy(xpath = "//button[normalize-space(.)='Doorgaan']")
	public WebElement doorgaan;
	@ChoiceListType()
	@FindBy(xpath = "//select")
	public WebElement dropdown_One_second;
	@ButtonType()
	@JavascriptBy(jspath = "return document.querySelector('c-pnl-mod-become-a-customer').shadowRoot.querySelector('c-pnl-ui-wizard-stage-screen').shadowRoot.querySelector('c-pnl-ui-button').shadowRoot.querySelector('button')")
	public WebElement doorgaan1;
	WebDriver driver;
	public MyPageObject(WebDriver driver)
	{
		this.driver= driver;
	}
public String check(){
WebElement  web=driver.findElement(By.xpath("((//*[@class='slds-checkbox--faux'])[2])//parent::label//input"));
/*
 * if(web.isSelected()) {
 */
String s= ""+web.isSelected();
//driver.findElement(By.xpath("(//*[@class='slds-checkbox--faux'])[2]")).click();
//}
 return s;
}
	public void dropdowntest() throws InterruptedException,
			AWTException {
		//	JavascriptExecutor js = (JavascriptExecutor)driver;
		//	js.executeScript("arguments[0].click();", dropdown_One_secondnew);
							  //Select drpCountry = new
							 // Select(driver.findElement(By.xpath("(//select)[1]"))); //
							//  drpCountry.selectByVisibleText("Extra@Home-producten"); Thread.sleep(5000);
							  Robot robot = new Robot();
							Thread.sleep(1000);
							   robot.keyPress(KeyEvent.VK_TAB);
                               robot.keyRelease(KeyEvent.VK_TAB);
							  Thread.sleep(1000);
							   robot.keyPress(KeyEvent.VK_TAB);
                               robot.keyRelease(KeyEvent.VK_TAB);
							  //driver.findElement(By.xpath("(//select)[1]")).click();
								/*
								 * Actions actions = new Actions(driver); WebElement elementLocator =
								 * driver.findElement(By.xpath("(//select)[1]"));
								 * actions.doubleClick(elementLocator).perform();
								 */
//							  Thread.sleep(1000); 
//							  robot.keyPress(KeyEvent.VK_DOWN);
//							  robot.keyRelease(KeyEvent.VK_DOWN);
//							 
//							  Thread.sleep(1000);
//							  robot.keyPress(KeyEvent.VK_DOWN);
//							  robot.keyRelease(KeyEvent.VK_DOWN); 
							 // Thread.sleep(2000);
								/*
								 * robot.keyRelease(KeyEvent.VK_DOWN); robot.keyRelease(KeyEvent.VK_DOWN);
								 * 
								 * 
								 * robot.keyRelease(KeyEvent.VK_DOWN); robot.keyRelease(KeyEvent.VK_DOWN);
								 * Thread.sleep(2000);
								 * 
								 * 
								 * 
								 * robot.keyRelease(KeyEvent.VK_ENTER);
								 * 
								 * 
								 * robot.keyRelease(KeyEvent.VK_TAB);
								 * 
								 * 
								 * robot.keyPress(KeyEvent.VK_ENTER); robot.keyRelease(KeyEvent.VK_ENTER);
								 */
}
public void sikuligoogle() throws FindFailed, InterruptedException{
Screen s = new Screen();
Pattern drop = new Pattern("C:\\Users\\vishal.poudel\\Provar\\URLTest\\URL_Pro\\templates\\google.PNG");
s.click(drop);
}
public void sikuliFunction() throws FindFailed, InterruptedException{
Screen s = new Screen();
Pattern drop = new Pattern("C:\\Users\\vishal.poudel\\Provar\\URLTest\\URL_Pro\\templates\\Drop1.PNG");
s.click(drop);
Thread.sleep(1000);
Pattern extra = new Pattern("C:\\Users\\vishal.poudel\\Provar\\URLTest\\URL_Pro\\templates\\extra.PNG");
s.click(extra);






}






public String version1(){

//String s= driver.capabilities["browserVersion"];
//Capabilities caps = ((RemoteWebDriver) driver).getCapabilities();
//String browserName = caps.getBrowserName();
//String browserVersion = caps.getVersion();
//
//
//return browserVersion;


String line="";
String s="";
{
        try {
            // Create a ProcessBuilder for the command you want to run
          //  ProcessBuilder builder = new ProcessBuilder("powershell -command", "(Get-Command 'C:\\Program Files (x86)\\Microsoft\\Edge\\Application\\msedge.exe').Version.ToString()");
ProcessBuilder builder = new ProcessBuilder("cmd.exe", "/c", "C:\\\\Program Files\\\\Google\\\\Chrome\\\\Application\\\\chrome.exe\" get Version /value");

            // Start the process
            Process process = builder.start();

            // Read the output of the process
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
               s=line;
                //return line;
            }

            // Wait for the process to finish and get its exit code
            int exitCode = process.waitFor();
            System.out.println("Command exited with code " + exitCode);
        } catch (IOException | InterruptedException e) {
           e.printStackTrace();
         s= "error";
          // return s;
            }
        


}
return s;

}



@TextType()
@FindBy(xpath = "//input[@name='q']")
public WebElement asas;

}
