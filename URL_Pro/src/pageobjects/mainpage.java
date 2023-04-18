package pageobjects;



import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.provar.core.testapi.annotations.*;

@Page( title="mainpage"                                
     , summary=""
     , relativeUrl=""
     , connection="redirect"
     )             
public class mainpage {

	@TextType()
	@FindBy(xpath = "//h3[@id='toc1']")
	public WebElement handle;
	@TextType()
	@FindBy(xpath = "//div[contains(@class,'active') and contains(@class,'oneContent')]//input[@id='combobox-input-914']")
	public WebElement ParentId;
	@TextType()
	@JavascriptBy(jspath = "return document.querySelector('one-record-home-flexipage2').shadowRoot.querySelector('forcegenerated-adg-rollup_component___force-generated__flexipage_-record-page___sfa__-account_rec_-l___-account___-v-i-e-w').shadowRoot.querySelector('forcegenerated-flexipage_account_rec_l_account__view_js').shadowRoot.querySelector('records-lwc-detail-panel').shadowRoot.querySelector('records-base-record-form').shadowRoot.querySelector('records-lwc-record-layout').shadowRoot.querySelector('forcegenerated-detailpanel_account___0122x000000g2vyaaa___full___view___recordlayout2').shadowRoot.querySelector('records-record-layout-lookup').shadowRoot.querySelector('lightning-lookup').shadowRoot.querySelector('lightning-lookup-desktop').shadowRoot.querySelector('lightning-grouped-combobox').shadowRoot.querySelector('lightning-base-combobox').shadowRoot.querySelectorAll('lightning-base-combobox-item')[1].shadowRoot.querySelector('lightning-base-combobox-formatted-text').shadowRoot.querySelector('strong')")
	public WebElement ParentId1;
	@TextType()
	@FindBy(xpath = "//div[contains(@class,'active') and contains(@class,'oneContent')]//lightning-base-combobox-item[@id='combobox-input-914-1-914']/span/span[normalize-space(.)='vishal']")
	public WebElement ParentId2;
	@TextType()
	@JavascriptBy(jspath = "return document.querySelector('one-record-home-flexipage2').shadowRoot.querySelector('forcegenerated-adg-rollup_component___force-generated__flexipage_-record-page___sfa__-account_rec_-l___-account___-v-i-e-w').shadowRoot.querySelector('forcegenerated-flexipage_account_rec_l_account__view_js').shadowRoot.querySelector('records-lwc-detail-panel').shadowRoot.querySelector('records-base-record-form').shadowRoot.querySelector('records-lwc-record-layout').shadowRoot.querySelector('forcegenerated-detailpanel_account___0122x000000g2vyaaa___full___view___recordlayout2').shadowRoot.querySelector('records-record-layout-lookup').shadowRoot.querySelector('lightning-lookup').shadowRoot.querySelector('lightning-lookup-desktop').shadowRoot.querySelector('lightning-grouped-combobox').shadowRoot.querySelector('lightning-base-combobox').shadowRoot.querySelector('input')")
	public WebElement ParentIdNew;
			
}
