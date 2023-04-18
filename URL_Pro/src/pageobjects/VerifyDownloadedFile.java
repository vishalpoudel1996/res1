package pageobjects;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import  org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import com.provar.core.testapi.annotations.ButtonType;
import com.provar.core.testapi.annotations.ChoiceListType;
import com.provar.core.testapi.annotations.JavascriptBy;
import com.provar.core.testapi.annotations.LinkType;
import com.provar.core.testapi.annotations.Page;
import com.provar.core.testapi.annotations.PageFrame;
import com.provar.core.testapi.annotations.TextType;
import pageobjects.MyPageObject;
@Page(title = "Verify Downloaded File", summary = "", relativeUrl = "", connection = "MyConn")
public class VerifyDownloadedFile {
	WebDriver driver;
	public VerifyDownloadedFile(WebDriver driver) {
		this.driver = driver;
	}
// To verify the file downloaded in Downloads folder of the system.
//Filename should be with extension.
	public String VerifyFileDownloaded(String FileName) {
		String flag = "false";
		String home = System.getProperty("user.home");
		String path = home + "/Downloads/";
		File dir = new File(path);
		File[] dir_contents = dir.listFiles();
		for (int i = 0; i < dir_contents.length; i++) {
			if (dir_contents[i].getName().equals(FileName))
				return flag = "true";
		}
		return flag;
	}
	public String readFromInputStream(InputStream inputStream)
  throws IOException {
    StringBuilder resultStringBuilder = new StringBuilder();
    try (BufferedReader br
      = new BufferedReader(new InputStreamReader(inputStream))) {
        String line;
        while ((line = br.readLine()) != null) {
            resultStringBuilder.append(line).append(" ");
        }
    }
  return resultStringBuilder.toString();
}
	@LinkType()
	@FindBy(xpath = "//li[@id='credit2']/a")
	public WebElement bANK;
	@TextType()
	@FindBy(xpath = "//ol[@id='amt7']/li")
	public WebElement amount;
	@TextType()
	@FindBy(xpath = "//ol[@id='amt7']")
	public WebElement a;
	@TextType()
	@FindBy(xpath = "//ol[@id='bank']/li")
	public WebElement acc;
	@TextType()
	@JavascriptBy(jspath = "return document.querySelector('td:nth-child(1) > table > tbody > tr > td:nth-child(1) > div > div > ol > li')")
	public WebElement acc1;
	public void DragAndDropMethod(){
		WebElement fromElement = driver.findElement(By.xpath("//li[@id='credit2']/a"));
		//WebElement to which the above object is dropped
		WebElement toElement = driver.findElement(By.xpath("//ol[@id='bank']/li"));
		//Creating object of Actions class to build composite actions
		Actions builder = new Actions(driver);
		//Building a drag and drop action
		Action dragAndDrop = builder.clickAndHold(fromElement)
				.moveToElement(toElement)
				.release(toElement)
				.build();
		//Performing the drag and drop action
		dragAndDrop.perform();
	}
	@TextType()
	@FindBy(xpath = "//td[normalize-space(.)='Alfreds Futterkiste']")
	public WebElement c1r1;
	@ChoiceListType()
	@JavascriptBy(jspath = "return document.querySelector('select')")
	public WebElement ___;
	@ButtonType(file=true)
	@FindBy(xpath="//input[@type='file']")
	public WebElement attachOwn;
	@PageFrame()
	public static class Frame {

		@ButtonType()
		@FindBy(xpath = "//button[normalize-space(.)='No thanks']")
		public WebElement noThanks;
	}
	@FindBy(xpath = "//iframe")
	public Frame frame;
	@TextType()
	@JavascriptBy(jspath = "return document.querySelector('div.a4bIc > input')")
	public WebElement qw;
	@LinkType()
	@FindBy(xpath = "//a[normalize-space(.)='How to perform Double Click in Selenium']")
	public WebElement howToPerformDoubleClickInSelenium;
	@TextType()
	@FindBy(xpath = "//h1[normalize-space(.)='How to perform Double Click in Selenium']")
	public WebElement assertHeader;
	@LinkType()
	@FindBy(xpath = "//div[contains(@class,'active') and contains(@class,'oneContent')]//a[normalize-space(.)='Cases(0)']")
	public WebElement Cases;
}
