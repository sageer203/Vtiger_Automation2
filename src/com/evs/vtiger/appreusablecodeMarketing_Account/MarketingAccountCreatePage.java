package com.evs.vtiger.appreusablecodeMarketing_Account;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.evs.vtiger.utils.WebUtil;

public class MarketingAccountCreatePage {
	@FindBy(xpath = "//input[@name='accountname']")
   private WebElement accounntnameTB;
   @FindBy(xpath = "//input[@name='website']" )
   private WebElement websitetb;
   @FindBy(xpath = "//input[@name='website']")
   private WebElement phoneTB;
   @FindBy(xpath = "//input[@id='email1']")
   private WebElement emailTB;
   @FindBy(xpath ="//select[@name='assigned_user_id']" )
   private WebElement useridTB;
   @FindBy(xpath = "//textarea[@name='bill_street']")
   private WebElement billSTTB; 
   @FindBy(xpath = "//input[@id='bill_pobox']")
   private WebElement billpoTB;
   @FindBy(xpath = "//input[@id='bill_city']")
   private WebElement CityTB;
   @FindBy(xpath = "//input[@id='bill_state']" )
   private WebElement StateTB;
   @FindBy(xpath = "//input[@id='bill_code']")
   private WebElement pincodeTB;
   @FindBy(xpath = "//input[@id='bill_country']")
   private WebElement countryTB; 
   
   @FindBy(xpath = "//b[text()='Copy Billing address']/preceding-sibling::input" )
   private WebElement addressTB;
   @FindBy(xpath = "//textarea[@name='description']")
   private WebElement descriptionTB;
   @FindBy(xpath ="(//input[@title='Save [Alt+S]'])[2]" )
   private WebElement saveButton;
   
	public void enterAndSaveMarketingAccountInfo() {
		WebUtil.mySendKeys(accounntnameTB,"Mohtliv", "Account Name Box");
		WebUtil.mySendKeys(websitetb,"VtigerPractice.com", "Website Name Box");
		WebUtil.mySendKeys(phoneTB,"(765) 435 325", "Phone Number Box");
		WebUtil.mySendKeys(emailTB,"arito_yadav@1secmail.com", "Email Box");

	//	WebUtil.selectByValue(useridTB, "Assign To Dropdown", "1");

		WebUtil.mySendKeys(billSTTB,"State-UP-City-Jaunpur",  "Billing Address Box");
		WebUtil.mySendKeys(billpoTB,"None", "bill_pobox ");
		WebUtil.mySendKeys(CityTB,"Varanasi",  "Billing City Box");
		WebUtil.mySendKeys(StateTB,"UP", "Billing State Box");
		WebUtil.mySendKeys(pincodeTB,"423245", "Billing Postal Code Box");
		WebUtil.mySendKeys(countryTB,"India", "Billing Country Box");
		WebUtil.myClick(addressTB,
				"Account inforamation copy checkbox");
		WebUtil.mySendKeys(descriptionTB,"This Account Creation is only for testing Purpose",
				"Description Box");
		WebUtil.myClick(saveButton,"Save Button");
		
	}
}
