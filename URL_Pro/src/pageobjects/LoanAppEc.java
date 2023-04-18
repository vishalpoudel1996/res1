package pageobjects;
import java.util.List;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import com.provar.core.testapi.annotations.*;
@Page( title="LoanAppEc"                                
     , summary=""
     , relativeUrl=""
     , connection="SFDC_Admin_LoanTest"
     )             
public class LoanAppEc {

	@ButtonType()
	@FindBy(xpath = "(//button[@class='slds-button slds-button_brand slds-button slds-button_icon slds-cell-edit__button slds-m-left_x-small editicon'])[2]")
	public WebElement Button_Before_Adjustments_Prior;
	
		@ButtonType()
	@FindBy(xpath = "(//button[@class='slds-button slds-button_brand slds-button slds-button_icon slds-cell-edit__button slds-m-left_x-small editicon'])[2]")
	public WebElement __2;
}
